package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int ALIGNMENT_CENTER = 1;
    public static final int ALIGNMENT_START = 0;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "CarouselLayoutManager";
    public static final int VERTICAL = 1;
    private int carouselAlignment;
    @NonNull
    private CarouselStrategy carouselStrategy;
    private int currentEstimatedPosition;
    private int currentFillStartPosition;
    @Nullable
    private KeylineState currentKeylineState;
    private final DebugItemDecoration debugItemDecoration;
    private boolean isDebuggingEnabled;
    /* access modifiers changed from: private */
    @Nullable
    public KeylineStateList keylineStateList;
    @Nullable
    private Map<Integer, KeylineState> keylineStatePositionMap;
    private int lastItemCount;
    @VisibleForTesting
    int maxScroll;
    @VisibleForTesting
    int minScroll;
    private CarouselOrientationHelper orientationHelper;
    private final View.OnLayoutChangeListener recyclerViewSizeChangeListener;
    @VisibleForTesting
    int scrollOffset;

    private static final class ChildCalculations {
        final float center;
        final View child;
        final float offsetCenter;
        final KeylineRange range;

        ChildCalculations(View view, float f4, float f5, KeylineRange keylineRange) {
            this.child = view;
            this.center = f4;
            this.offsetCenter = f5;
            this.range = keylineRange;
        }
    }

    private static class DebugItemDecoration extends RecyclerView.ItemDecoration {
        private List<KeylineState.Keyline> keylines = DesugarCollections.unmodifiableList(new ArrayList());
        private final Paint linePaint;

        DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDrawOver(canvas, recyclerView, state);
            this.linePaint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline next : this.keylines) {
                this.linePaint.setColor(ColorUtils.blendARGB(-65281, -16776961, next.mask));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    canvas.drawLine(next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentTop(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentBottom(), this.linePaint);
                } else {
                    canvas.drawLine((float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentLeft(), next.locOffset, (float) ((CarouselLayoutManager) recyclerView.getLayoutManager()).getParentRight(), next.locOffset, this.linePaint);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setKeylines(List<KeylineState.Keyline> list) {
            this.keylines = DesugarCollections.unmodifiableList(list);
        }
    }

    private static class KeylineRange {
        final KeylineState.Keyline leftOrTop;
        final KeylineState.Keyline rightOrBottom;

        KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            boolean z4;
            if (keyline.loc <= keyline2.loc) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            this.leftOrTop = keyline;
            this.rightOrBottom = keyline2;
        }
    }

    private static class LayoutDirection {
        private static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;

        private LayoutDirection() {
        }
    }

    public CarouselLayoutManager() {
        this(new MultiBrowseCarouselStrategy());
    }

    private void addAndLayoutView(View view, int i4, ChildCalculations childCalculations) {
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        addView(view, i4);
        float f4 = childCalculations.offsetCenter;
        this.orientationHelper.layoutDecoratedWithMargins(view, (int) (f4 - itemSize), (int) (f4 + itemSize));
        updateChildMaskForLocation(view, childCalculations.center, childCalculations.range);
    }

    private float addEnd(float f4, float f5) {
        if (isLayoutRtl()) {
            return f4 - f5;
        }
        return f4 + f5;
    }

    private float addStart(float f4, float f5) {
        if (isLayoutRtl()) {
            return f4 + f5;
        }
        return f4 - f5;
    }

    private void addViewAtPosition(@NonNull RecyclerView.Recycler recycler, int i4, int i5) {
        if (i4 >= 0 && i4 < getItemCount()) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill(i4), i4);
            addAndLayoutView(makeChildCalculations.child, i5, makeChildCalculations);
        }
    }

    private void addViewsEnd(RecyclerView.Recycler recycler, RecyclerView.State state, int i4) {
        float calculateChildStartForFill = calculateChildStartForFill(i4);
        while (i4 < state.getItemCount()) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill, i4);
            if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, -1, makeChildCalculations);
                }
                i4++;
            } else {
                return;
            }
        }
    }

    private void addViewsStart(RecyclerView.Recycler recycler, int i4) {
        float calculateChildStartForFill = calculateChildStartForFill(i4);
        while (i4 >= 0) {
            ChildCalculations makeChildCalculations = makeChildCalculations(recycler, calculateChildStartForFill, i4);
            if (!isLocOffsetOutOfFillBoundsStart(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                calculateChildStartForFill = addStart(calculateChildStartForFill, this.currentKeylineState.getItemSize());
                if (!isLocOffsetOutOfFillBoundsEnd(makeChildCalculations.offsetCenter, makeChildCalculations.range)) {
                    addAndLayoutView(makeChildCalculations.child, 0, makeChildCalculations);
                }
                i4--;
            } else {
                return;
            }
        }
    }

    public static /* synthetic */ void b(CarouselLayoutManager carouselLayoutManager, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        carouselLayoutManager.getClass();
        if (i4 != i8 || i5 != i9 || i6 != i10 || i7 != i11) {
            view.post(new a(carouselLayoutManager));
        }
    }

    private float calculateChildOffsetCenterForLocation(View view, float f4, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f5 = keyline.locOffset;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        float lerp = AnimationUtils.lerp(f5, keyline2.locOffset, keyline.loc, keyline2.loc, f4);
        if (keylineRange.rightOrBottom != this.currentKeylineState.getFirstKeyline() && keylineRange.leftOrTop != this.currentKeylineState.getLastKeyline()) {
            return lerp;
        }
        float maskMargins = this.orientationHelper.getMaskMargins((RecyclerView.LayoutParams) view.getLayoutParams()) / this.currentKeylineState.getItemSize();
        KeylineState.Keyline keyline3 = keylineRange.rightOrBottom;
        return lerp + ((f4 - keyline3.loc) * ((1.0f - keyline3.mask) + maskMargins));
    }

    private float calculateChildStartForFill(int i4) {
        return addEnd((float) (getParentStart() - this.scrollOffset), this.currentKeylineState.getItemSize() * ((float) i4));
    }

    private int calculateEndScroll(RecyclerView.State state, KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        float f4;
        float f5;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getStartState();
        } else {
            keylineState = keylineStateList2.getEndState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getFirstFocalKeyline();
        } else {
            keyline = keylineState.getLastFocalKeyline();
        }
        float itemCount = ((float) (state.getItemCount() - 1)) * keylineState.getItemSize();
        if (isLayoutRtl) {
            f4 = -1.0f;
        } else {
            f4 = 1.0f;
        }
        float f6 = itemCount * f4;
        if (isLayoutRtl) {
            f5 = -keyline.leftOrTopPaddingShift;
        } else {
            f5 = keyline.rightOrBottomPaddingShift;
        }
        int parentStart = (int) ((f6 - (keyline.loc - ((float) getParentStart()))) + (((float) getParentEnd()) - keyline.loc) + f5);
        if (isLayoutRtl) {
            return Math.min(0, parentStart);
        }
        return Math.max(0, parentStart);
    }

    private static int calculateShouldScrollBy(int i4, int i5, int i6, int i7) {
        int i8 = i5 + i4;
        return i8 < i6 ? i6 - i5 : i8 > i7 ? i7 - i5 : i4;
    }

    private int calculateStartScroll(@NonNull KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        KeylineState.Keyline keyline;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            keylineState = keylineStateList2.getEndState();
        } else {
            keylineState = keylineStateList2.getStartState();
        }
        if (isLayoutRtl) {
            keyline = keylineState.getLastFocalKeyline();
        } else {
            keyline = keylineState.getFirstFocalKeyline();
        }
        return (int) (((float) getParentStart()) - addStart(keyline.loc, keylineState.getItemSize() / 2.0f));
    }

    private int convertFocusDirectionToLayoutDirection(int i4) {
        int orientation = getOrientation();
        if (i4 == 1) {
            return -1;
        }
        if (i4 == 2) {
            return 1;
        }
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        Log.d(TAG, "Unknown focus request:" + i4);
                        return Integer.MIN_VALUE;
                    } else if (orientation == 1) {
                        return 1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (orientation != 0) {
                    return Integer.MIN_VALUE;
                } else {
                    if (isLayoutRtl()) {
                        return -1;
                    }
                    return 1;
                }
            } else if (orientation == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (orientation != 0) {
            return Integer.MIN_VALUE;
        } else {
            if (isLayoutRtl()) {
                return 1;
            }
            return -1;
        }
    }

    private void fill(RecyclerView.Recycler recycler, RecyclerView.State state) {
        removeAndRecycleOutOfBoundsViews(recycler);
        if (getChildCount() == 0) {
            addViewsStart(recycler, this.currentFillStartPosition - 1);
            addViewsEnd(recycler, state, this.currentFillStartPosition);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            addViewsStart(recycler, position - 1);
            addViewsEnd(recycler, state, position2 + 1);
        }
        validateChildOrderIfDebugging();
    }

    private View getChildClosestToEnd() {
        int i4;
        if (isLayoutRtl()) {
            i4 = 0;
        } else {
            i4 = getChildCount() - 1;
        }
        return getChildAt(i4);
    }

    private View getChildClosestToStart() {
        int i4;
        if (isLayoutRtl()) {
            i4 = getChildCount() - 1;
        } else {
            i4 = 0;
        }
        return getChildAt(i4);
    }

    private int getContainerSize() {
        if (isHorizontal()) {
            return getContainerWidth();
        }
        return getContainerHeight();
    }

    private float getDecoratedCenterWithMargins(View view) {
        int centerY;
        Rect rect = new Rect();
        super.getDecoratedBoundsWithMargins(view, rect);
        if (isHorizontal()) {
            centerY = rect.centerX();
        } else {
            centerY = rect.centerY();
        }
        return (float) centerY;
    }

    private int getItemMargins() {
        int i4;
        int i5;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) getChildAt(0).getLayoutParams();
        if (this.orientationHelper.orientation == 0) {
            i4 = layoutParams.leftMargin;
            i5 = layoutParams.rightMargin;
        } else {
            i4 = layoutParams.topMargin;
            i5 = layoutParams.bottomMargin;
        }
        return i4 + i5;
    }

    private KeylineState getKeylineStateForPosition(int i4) {
        KeylineState keylineState;
        Map<Integer, KeylineState> map = this.keylineStatePositionMap;
        if (map == null || (keylineState = map.get(Integer.valueOf(MathUtils.clamp(i4, 0, Math.max(0, getItemCount() - 1))))) == null) {
            return this.keylineStateList.getDefaultState();
        }
        return keylineState;
    }

    private int getLeftOrTopPaddingForKeylineShift() {
        if (getClipToPadding() || !this.carouselStrategy.isContained()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingTop();
        }
        return getPaddingLeft();
    }

    private float getMaskedItemSizeForLocOffset(float f4, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.leftOrTop;
        float f5 = keyline.maskedItemSize;
        KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
        return AnimationUtils.lerp(f5, keyline2.maskedItemSize, keyline.locOffset, keyline2.locOffset, f4);
    }

    /* access modifiers changed from: private */
    public int getParentBottom() {
        return this.orientationHelper.getParentBottom();
    }

    private int getParentEnd() {
        return this.orientationHelper.getParentEnd();
    }

    /* access modifiers changed from: private */
    public int getParentLeft() {
        return this.orientationHelper.getParentLeft();
    }

    /* access modifiers changed from: private */
    public int getParentRight() {
        return this.orientationHelper.getParentRight();
    }

    private int getParentStart() {
        return this.orientationHelper.getParentStart();
    }

    /* access modifiers changed from: private */
    public int getParentTop() {
        return this.orientationHelper.getParentTop();
    }

    private int getRightOrBottomPaddingForKeylineShift() {
        if (getClipToPadding() || !this.carouselStrategy.isContained()) {
            return 0;
        }
        if (getOrientation() == 1) {
            return getPaddingBottom();
        }
        return getPaddingRight();
    }

    private int getScrollOffsetForPosition(int i4, KeylineState keylineState) {
        if (isLayoutRtl()) {
            return (int) (((((float) getContainerSize()) - keylineState.getLastFocalKeyline().loc) - (((float) i4) * keylineState.getItemSize())) - (keylineState.getItemSize() / 2.0f));
        }
        return (int) (((((float) i4) * keylineState.getItemSize()) - keylineState.getFirstFocalKeyline().loc) + (keylineState.getItemSize() / 2.0f));
    }

    private int getSmallestScrollOffsetToFocalKeyline(int i4, @NonNull KeylineState keylineState) {
        int i5;
        int i6 = Integer.MAX_VALUE;
        for (KeylineState.Keyline next : keylineState.getFocalKeylines()) {
            float itemSize = (((float) i4) * keylineState.getItemSize()) + (keylineState.getItemSize() / 2.0f);
            if (isLayoutRtl()) {
                i5 = (int) ((((float) getContainerSize()) - next.loc) - itemSize);
            } else {
                i5 = (int) (itemSize - next.loc);
            }
            int i7 = i5 - this.scrollOffset;
            if (Math.abs(i6) > Math.abs(i7)) {
                i6 = i7;
            }
        }
        return i6;
    }

    private static KeylineRange getSurroundingKeylineRange(List<KeylineState.Keyline> list, float f4, boolean z4) {
        float f5;
        float f6 = Float.MAX_VALUE;
        float f7 = Float.MAX_VALUE;
        float f8 = Float.MAX_VALUE;
        float f9 = -3.4028235E38f;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < list.size(); i8++) {
            KeylineState.Keyline keyline = list.get(i8);
            if (z4) {
                f5 = keyline.locOffset;
            } else {
                f5 = keyline.loc;
            }
            float abs = Math.abs(f5 - f4);
            if (f5 <= f4 && abs <= f6) {
                i4 = i8;
                f6 = abs;
            }
            if (f5 > f4 && abs <= f7) {
                i6 = i8;
                f7 = abs;
            }
            if (f5 <= f8) {
                i5 = i8;
                f8 = f5;
            }
            if (f5 > f9) {
                i7 = i8;
                f9 = f5;
            }
        }
        if (i4 == -1) {
            i4 = i5;
        }
        if (i6 == -1) {
            i6 = i7;
        }
        return new KeylineRange(list.get(i4), list.get(i6));
    }

    private boolean isLocOffsetOutOfFillBoundsEnd(float f4, KeylineRange keylineRange) {
        float addStart = addStart(f4, getMaskedItemSizeForLocOffset(f4, keylineRange) / 2.0f);
        if (isLayoutRtl()) {
            if (addStart < 0.0f) {
                return true;
            }
            return false;
        } else if (addStart > ((float) getContainerSize())) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLocOffsetOutOfFillBoundsStart(float f4, KeylineRange keylineRange) {
        float addEnd = addEnd(f4, getMaskedItemSizeForLocOffset(f4, keylineRange) / 2.0f);
        if (isLayoutRtl()) {
            if (addEnd > ((float) getContainerSize())) {
                return true;
            }
            return false;
        } else if (addEnd < 0.0f) {
            return true;
        } else {
            return false;
        }
    }

    private void logChildrenIfDebugging() {
        if (this.isDebuggingEnabled && Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "internal representation of views on the screen");
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                float decoratedCenterWithMargins = getDecoratedCenterWithMargins(childAt);
                Log.d(TAG, "item position " + getPosition(childAt) + ", center:" + decoratedCenterWithMargins + ", child index:" + i4);
            }
            Log.d(TAG, "==============");
        }
    }

    private ChildCalculations makeChildCalculations(RecyclerView.Recycler recycler, float f4, int i4) {
        View viewForPosition = recycler.getViewForPosition(i4);
        measureChildWithMargins(viewForPosition, 0, 0);
        float addEnd = addEnd(f4, this.currentKeylineState.getItemSize() / 2.0f);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        return new ChildCalculations(viewForPosition, addEnd, calculateChildOffsetCenterForLocation(viewForPosition, addEnd, surroundingKeylineRange), surroundingKeylineRange);
    }

    private float offsetChild(View view, float f4, float f5, Rect rect) {
        float addEnd = addEnd(f4, f5);
        KeylineRange surroundingKeylineRange = getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), addEnd, false);
        float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, addEnd, surroundingKeylineRange);
        super.getDecoratedBoundsWithMargins(view, rect);
        updateChildMaskForLocation(view, addEnd, surroundingKeylineRange);
        this.orientationHelper.offsetChild(view, rect, f5, calculateChildOffsetCenterForLocation);
        return calculateChildOffsetCenterForLocation;
    }

    private void recalculateKeylineStateList(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        KeylineState onFirstChildMeasuredWithMargins = this.carouselStrategy.onFirstChildMeasuredWithMargins(this, viewForPosition);
        if (isLayoutRtl()) {
            onFirstChildMeasuredWithMargins = KeylineState.reverse(onFirstChildMeasuredWithMargins, (float) getContainerSize());
        }
        this.keylineStateList = KeylineStateList.from(this, onFirstChildMeasuredWithMargins, (float) getItemMargins(), (float) getLeftOrTopPaddingForKeylineShift(), (float) getRightOrBottomPaddingForKeylineShift());
    }

    /* access modifiers changed from: private */
    public void refreshKeylineState() {
        this.keylineStateList = null;
        requestLayout();
    }

    private void removeAndRecycleOutOfBoundsViews(RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float decoratedCenterWithMargins = getDecoratedCenterWithMargins(childAt);
            if (!isLocOffsetOutOfFillBoundsStart(decoratedCenterWithMargins, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterWithMargins, true))) {
                break;
            }
            removeAndRecycleView(childAt, recycler);
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float decoratedCenterWithMargins2 = getDecoratedCenterWithMargins(childAt2);
            if (isLocOffsetOutOfFillBoundsEnd(decoratedCenterWithMargins2, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), decoratedCenterWithMargins2, true))) {
                removeAndRecycleView(childAt2, recycler);
            } else {
                return;
            }
        }
    }

    private void scrollBy(RecyclerView recyclerView, int i4) {
        if (isHorizontal()) {
            recyclerView.scrollBy(i4, 0);
        } else {
            recyclerView.scrollBy(0, i4);
        }
    }

    private void setCarouselAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            setCarouselAlignment(obtainStyledAttributes.getInt(R.styleable.Carousel_carousel_alignment, 0));
            setOrientation(obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 0));
            obtainStyledAttributes.recycle();
        }
    }

    private void updateChildMaskForLocation(View view, float f4, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.leftOrTop;
            float f5 = keyline.mask;
            KeylineState.Keyline keyline2 = keylineRange.rightOrBottom;
            float lerp = AnimationUtils.lerp(f5, keyline2.mask, keyline.loc, keyline2.loc, f4);
            float height = (float) view.getHeight();
            float width = (float) view.getWidth();
            float lerp2 = AnimationUtils.lerp(0.0f, width / 2.0f, 0.0f, 1.0f, lerp);
            RectF maskRect = this.orientationHelper.getMaskRect(height, width, AnimationUtils.lerp(0.0f, height / 2.0f, 0.0f, 1.0f, lerp), lerp2);
            float calculateChildOffsetCenterForLocation = calculateChildOffsetCenterForLocation(view, f4, keylineRange);
            float height2 = (maskRect.height() / 2.0f) + calculateChildOffsetCenterForLocation;
            RectF rectF = new RectF(calculateChildOffsetCenterForLocation - (maskRect.width() / 2.0f), calculateChildOffsetCenterForLocation - (maskRect.height() / 2.0f), calculateChildOffsetCenterForLocation + (maskRect.width() / 2.0f), height2);
            RectF rectF2 = new RectF((float) getParentLeft(), (float) getParentTop(), (float) getParentRight(), (float) getParentBottom());
            if (this.carouselStrategy.isContained()) {
                this.orientationHelper.containMaskWithinBounds(maskRect, rectF, rectF2);
            }
            this.orientationHelper.moveMaskOnEdgeOutsideBounds(maskRect, rectF, rectF2);
            ((Maskable) view).setMaskRectF(maskRect);
        }
    }

    private void updateCurrentKeylineStateForScrollOffset(@NonNull KeylineStateList keylineStateList2) {
        KeylineState keylineState;
        int i4 = this.maxScroll;
        int i5 = this.minScroll;
        if (i4 <= i5) {
            if (isLayoutRtl()) {
                keylineState = keylineStateList2.getEndState();
            } else {
                keylineState = keylineStateList2.getStartState();
            }
            this.currentKeylineState = keylineState;
        } else {
            this.currentKeylineState = keylineStateList2.getShiftedState((float) this.scrollOffset, (float) i5, (float) i4);
        }
        this.debugItemDecoration.setKeylines(this.currentKeylineState.getKeylines());
    }

    private void updateItemCount() {
        int itemCount = getItemCount();
        int i4 = this.lastItemCount;
        if (itemCount != i4 && this.keylineStateList != null) {
            if (this.carouselStrategy.shouldRefreshKeylineState(this, i4)) {
                refreshKeylineState();
            }
            this.lastItemCount = itemCount;
        }
    }

    private void validateChildOrderIfDebugging() {
        if (this.isDebuggingEnabled && getChildCount() >= 1) {
            int i4 = 0;
            while (i4 < getChildCount() - 1) {
                int position = getPosition(getChildAt(i4));
                int i5 = i4 + 1;
                int position2 = getPosition(getChildAt(i5));
                if (position <= position2) {
                    i4 = i5;
                } else {
                    logChildrenIfDebugging();
                    throw new IllegalStateException("Detected invalid child order. Child at index [" + i4 + "] had adapter position [" + position + "] and child at index [" + i5 + "] had adapter position [" + position2 + "].");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int calculateScrollDeltaToMakePositionVisible(int i4) {
        return (int) (((float) this.scrollOffset) - ((float) getScrollOffsetForPosition(i4, getKeylineStateForPosition(i4))));
    }

    public boolean canScrollHorizontally() {
        return isHorizontal();
    }

    public boolean canScrollVertically() {
        return !isHorizontal();
    }

    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getWidth()) * (this.keylineStateList.getDefaultState().getItemSize() / ((float) computeHorizontalScrollRange(state))));
    }

    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeHorizontalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    @Nullable
    public PointF computeScrollVectorForPosition(int i4) {
        if (this.keylineStateList == null) {
            return null;
        }
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i4, getKeylineStateForPosition(i4));
        if (isHorizontal()) {
            return new PointF((float) offsetToScrollToPosition, 0.0f);
        }
        return new PointF(0.0f, (float) offsetToScrollToPosition);
    }

    public int computeVerticalScrollExtent(@NonNull RecyclerView.State state) {
        if (getChildCount() == 0 || this.keylineStateList == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (((float) getHeight()) * (this.keylineStateList.getDefaultState().getItemSize() / ((float) computeVerticalScrollRange(state))));
    }

    public int computeVerticalScrollOffset(@NonNull RecyclerView.State state) {
        return this.scrollOffset;
    }

    public int computeVerticalScrollRange(@NonNull RecyclerView.State state) {
        return this.maxScroll - this.minScroll;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getCarouselAlignment() {
        return this.carouselAlignment;
    }

    public int getContainerHeight() {
        return getHeight();
    }

    public int getContainerWidth() {
        return getWidth();
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        float f4;
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = (float) rect.centerY();
        if (isHorizontal()) {
            centerY = (float) rect.centerX();
        }
        float maskedItemSizeForLocOffset = getMaskedItemSizeForLocOffset(centerY, getSurroundingKeylineRange(this.currentKeylineState.getKeylines(), centerY, true));
        float f5 = 0.0f;
        if (isHorizontal()) {
            f4 = (((float) rect.width()) - maskedItemSizeForLocOffset) / 2.0f;
        } else {
            f4 = 0.0f;
        }
        if (!isHorizontal()) {
            f5 = (((float) rect.height()) - maskedItemSizeForLocOffset) / 2.0f;
        }
        rect.set((int) (((float) rect.left) + f4), (int) (((float) rect.top) + f5), (int) (((float) rect.right) - f4), (int) (((float) rect.bottom) - f5));
    }

    /* access modifiers changed from: package-private */
    public int getOffsetToScrollToPosition(int i4, @NonNull KeylineState keylineState) {
        return getScrollOffsetForPosition(i4, keylineState) - this.scrollOffset;
    }

    /* access modifiers changed from: package-private */
    public int getOffsetToScrollToPositionForSnap(int i4, boolean z4) {
        int i5;
        int offsetToScrollToPosition = getOffsetToScrollToPosition(i4, this.keylineStateList.getShiftedState((float) this.scrollOffset, (float) this.minScroll, (float) this.maxScroll, true));
        if (this.keylineStatePositionMap != null) {
            i5 = getOffsetToScrollToPosition(i4, getKeylineStateForPosition(i4));
        } else {
            i5 = offsetToScrollToPosition;
        }
        if (!z4 || Math.abs(i5) >= Math.abs(offsetToScrollToPosition)) {
            return offsetToScrollToPosition;
        }
        return i5;
    }

    public int getOrientation() {
        return this.orientationHelper.orientation;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isHorizontal() {
        if (this.orientationHelper.orientation == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRtl() {
        if (!isHorizontal() || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void measureChildWithMargins(@NonNull View view, int i4, int i5) {
        float f4;
        float f5;
        if (view instanceof Maskable) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            Rect rect = new Rect();
            calculateItemDecorationsForChild(view, rect);
            int i6 = i4 + rect.left + rect.right;
            int i7 = i5 + rect.top + rect.bottom;
            KeylineStateList keylineStateList2 = this.keylineStateList;
            if (keylineStateList2 == null || this.orientationHelper.orientation != 0) {
                f4 = (float) layoutParams.width;
            } else {
                f4 = keylineStateList2.getDefaultState().getItemSize();
            }
            KeylineStateList keylineStateList3 = this.keylineStateList;
            if (keylineStateList3 == null || this.orientationHelper.orientation != 1) {
                f5 = (float) layoutParams.height;
            } else {
                f5 = keylineStateList3.getDefaultState().getItemSize();
            }
            view.measure(RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i6, (int) f4, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i7, (int) f5, canScrollVertically()));
            return;
        }
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.carouselStrategy.initialize(recyclerView.getContext());
        refreshKeylineState();
        recyclerView.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        recyclerView.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Nullable
    public View onFocusSearchFailed(@NonNull View view, int i4, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i4)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            addViewAtPosition(recycler, getPosition(getChildAt(0)) - 1, 0);
            return getChildClosestToStart();
        } else if (getPosition(view) == getItemCount() - 1) {
            return null;
        } else {
            addViewAtPosition(recycler, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
            return getChildClosestToEnd();
        }
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i4, int i5) {
        super.onItemsAdded(recyclerView, i4, i5);
        updateItemCount();
    }

    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i4, int i5) {
        super.onItemsRemoved(recyclerView, i4, i5);
        updateItemCount();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z4;
        int i4;
        if (state.getItemCount() <= 0 || ((float) getContainerSize()) <= 0.0f) {
            removeAndRecycleAllViews(recycler);
            this.currentFillStartPosition = 0;
            return;
        }
        boolean isLayoutRtl = isLayoutRtl();
        if (this.keylineStateList == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            recalculateKeylineStateList(recycler);
        }
        int calculateStartScroll = calculateStartScroll(this.keylineStateList);
        int calculateEndScroll = calculateEndScroll(state, this.keylineStateList);
        if (isLayoutRtl) {
            i4 = calculateEndScroll;
        } else {
            i4 = calculateStartScroll;
        }
        this.minScroll = i4;
        if (isLayoutRtl) {
            calculateEndScroll = calculateStartScroll;
        }
        this.maxScroll = calculateEndScroll;
        if (z4) {
            this.scrollOffset = calculateStartScroll;
            this.keylineStatePositionMap = this.keylineStateList.getKeylineStateForPositionMap(getItemCount(), this.minScroll, this.maxScroll, isLayoutRtl());
            int i5 = this.currentEstimatedPosition;
            if (i5 != -1) {
                this.scrollOffset = getScrollOffsetForPosition(i5, getKeylineStateForPosition(i5));
            }
        }
        int i6 = this.scrollOffset;
        this.scrollOffset = i6 + calculateShouldScrollBy(0, i6, this.minScroll, this.maxScroll);
        this.currentFillStartPosition = MathUtils.clamp(this.currentFillStartPosition, 0, state.getItemCount());
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        detachAndScrapAttachedViews(recycler);
        fill(recycler, state);
        this.lastItemCount = getItemCount();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (getChildCount() == 0) {
            this.currentFillStartPosition = 0;
        } else {
            this.currentFillStartPosition = getPosition(getChildAt(0));
        }
        validateChildOrderIfDebugging();
    }

    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z4, boolean z5) {
        int smallestScrollOffsetToFocalKeyline;
        if (this.keylineStateList == null || (smallestScrollOffsetToFocalKeyline = getSmallestScrollOffsetToFocalKeyline(getPosition(view), getKeylineStateForPosition(getPosition(view)))) == 0) {
            return false;
        }
        scrollBy(recyclerView, getSmallestScrollOffsetToFocalKeyline(getPosition(view), this.keylineStateList.getShiftedState((float) (this.scrollOffset + calculateShouldScrollBy(smallestScrollOffsetToFocalKeyline, this.scrollOffset, this.minScroll, this.maxScroll)), (float) this.minScroll, (float) this.maxScroll)));
        return true;
    }

    public int scrollHorizontallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i4, recycler, state);
        }
        return 0;
    }

    public void scrollToPosition(int i4) {
        this.currentEstimatedPosition = i4;
        if (this.keylineStateList != null) {
            this.scrollOffset = getScrollOffsetForPosition(i4, getKeylineStateForPosition(i4));
            this.currentFillStartPosition = MathUtils.clamp(i4, 0, Math.max(0, getItemCount() - 1));
            updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
            requestLayout();
        }
    }

    public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (canScrollVertically()) {
            return scrollBy(i4, recycler, state);
        }
        return 0;
    }

    public void setCarouselAlignment(int i4) {
        this.carouselAlignment = i4;
        refreshKeylineState();
    }

    public void setCarouselStrategy(@NonNull CarouselStrategy carouselStrategy2) {
        this.carouselStrategy = carouselStrategy2;
        refreshKeylineState();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setDebuggingEnabled(@NonNull RecyclerView recyclerView, boolean z4) {
        this.isDebuggingEnabled = z4;
        recyclerView.removeItemDecoration(this.debugItemDecoration);
        if (z4) {
            recyclerView.addItemDecoration(this.debugItemDecoration);
        }
        recyclerView.invalidateItemDecorations();
    }

    public void setOrientation(int i4) {
        if (i4 == 0 || i4 == 1) {
            assertNotInLayoutOrScroll((String) null);
            CarouselOrientationHelper carouselOrientationHelper = this.orientationHelper;
            if (carouselOrientationHelper == null || i4 != carouselOrientationHelper.orientation) {
                this.orientationHelper = CarouselOrientationHelper.createOrientationHelper(this, i4);
                refreshKeylineState();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i4);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i4) {
        AnonymousClass1 r22 = new LinearSmoothScroller(recyclerView.getContext()) {
            public int calculateDxToMakeVisible(View view, int i4) {
                if (CarouselLayoutManager.this.keylineStateList == null || !CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            public int calculateDyToMakeVisible(View view, int i4) {
                if (CarouselLayoutManager.this.keylineStateList == null || CarouselLayoutManager.this.isHorizontal()) {
                    return 0;
                }
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                return carouselLayoutManager.calculateScrollDeltaToMakePositionVisible(carouselLayoutManager.getPosition(view));
            }

            @Nullable
            public PointF computeScrollVectorForPosition(int i4) {
                return CarouselLayoutManager.this.computeScrollVectorForPosition(i4);
            }
        };
        r22.setTargetPosition(i4);
        startSmoothScroll(r22);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2) {
        this(carouselStrategy2, 0);
    }

    public CarouselLayoutManager(@NonNull CarouselStrategy carouselStrategy2, int i4) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new b(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(carouselStrategy2);
        setOrientation(i4);
    }

    private int scrollBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f4;
        if (getChildCount() == 0 || i4 == 0) {
            return 0;
        }
        if (this.keylineStateList == null) {
            recalculateKeylineStateList(recycler);
        }
        int calculateShouldScrollBy = calculateShouldScrollBy(i4, this.scrollOffset, this.minScroll, this.maxScroll);
        this.scrollOffset += calculateShouldScrollBy;
        updateCurrentKeylineStateForScrollOffset(this.keylineStateList);
        float itemSize = this.currentKeylineState.getItemSize() / 2.0f;
        float calculateChildStartForFill = calculateChildStartForFill(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        if (isLayoutRtl()) {
            f4 = this.currentKeylineState.getLastFocalKeyline().locOffset;
        } else {
            f4 = this.currentKeylineState.getFirstFocalKeyline().locOffset;
        }
        float f5 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            float abs = Math.abs(f4 - offsetChild(childAt, calculateChildStartForFill, itemSize, rect));
            if (childAt != null && abs < f5) {
                this.currentEstimatedPosition = getPosition(childAt);
                f5 = abs;
            }
            calculateChildStartForFill = addEnd(calculateChildStartForFill, this.currentKeylineState.getItemSize());
        }
        fill(recycler, state);
        return calculateShouldScrollBy;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        this.isDebuggingEnabled = false;
        this.debugItemDecoration = new DebugItemDecoration();
        this.currentFillStartPosition = 0;
        this.recyclerViewSizeChangeListener = new b(this);
        this.currentEstimatedPosition = -1;
        this.carouselAlignment = 0;
        setCarouselStrategy(new MultiBrowseCarouselStrategy());
        setCarouselAttributes(context, attributeSet);
    }
}
