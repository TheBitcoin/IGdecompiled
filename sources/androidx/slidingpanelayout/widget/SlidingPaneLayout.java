package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlidingPaneLayout extends ViewGroup implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.slidingpanelayout.widget.SlidingPaneLayout";
    public static final int LOCK_MODE_LOCKED = 3;
    public static final int LOCK_MODE_LOCKED_CLOSED = 2;
    public static final int LOCK_MODE_LOCKED_OPEN = 1;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    FoldingFeature mFoldingFeature;
    private FoldingFeatureObserver mFoldingFeatureObserver;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private int mLockMode;
    private FoldingFeatureObserver.OnFoldingFeatureChangeListener mOnFoldingFeatureChangeListener;
    @Nullable
    private PanelSlideListener mPanelSlideListener;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i4);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!filter(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                this.mChildView.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        private boolean isDraggable() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.mIsUnableToDrag || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() && SlidingPaneLayout.this.getLockMode() == 1) {
                return false;
            }
            if (SlidingPaneLayout.this.isOpen() || SlidingPaneLayout.this.getLockMode() != 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i4, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i4, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        public int clampViewPositionVertical(View view, int i4, int i5) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public void onEdgeDragStarted(int i4, int i5) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i5);
            }
        }

        public void onEdgeTouched(int i4, int i5) {
            if (isDraggable()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i5);
            }
        }

        public void onViewCaptured(View view, int i4) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int i4) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset == 1.0f) {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                    return;
                }
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = true;
            }
        }

        public void onViewPositionChanged(View view, int i4, int i5, int i6, int i7) {
            SlidingPaneLayout.this.onPanelDragged(i4);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f4, float f5) {
            int i4;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f4 < 0.0f || (f4 == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                i4 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                i4 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                if (i5 > 0 || (i5 == 0 && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    i4 += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i4, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i4) {
            if (!isDraggable()) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f4);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean isOpen;
        int mLockMode;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.mLockMode);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
            this.mLockMode = parcel.readInt();
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(@NonNull View view) {
        }

        public void onPanelOpened(@NonNull View view) {
        }

        public void onPanelSlide(@NonNull View view, float f4) {
        }
    }

    private static class TouchBlocker extends FrameLayout {
        TouchBlocker(View view) {
            super(view.getContext());
            addView(view);
        }

        public boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    static {
        boolean z4;
        if (Build.VERSION.SDK_INT >= 29) {
            z4 = true;
        } else {
            z4 = false;
        }
        sEdgeSizeUsingSystemGestureInsets = z4;
    }

    public SlidingPaneLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean closePane(int i4) {
        if (!this.mCanSlide) {
            this.mPreservedOpenState = false;
        }
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i4)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    @Nullable
    private static Activity getActivityOrNull(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private static Rect getFoldBoundsInView(@NonNull FoldingFeature foldingFeature, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i4 = iArr[0];
        Rect rect = new Rect(i4, iArr[1], view.getWidth() + i4, iArr[1] + view.getWidth());
        Rect rect2 = new Rect(foldingFeature.getBounds());
        boolean intersect = rect2.intersect(rect);
        if ((rect2.width() == 0 && rect2.height() == 0) || !intersect) {
            return null;
        }
        rect2.offset(-iArr[0], -iArr[1]);
        return rect2;
    }

    private static int getMinimumWidth(View view) {
        if (view instanceof TouchBlocker) {
            return ViewCompat.getMinimumWidth(((TouchBlocker) view).getChildAt(0));
        }
        return ViewCompat.getMinimumWidth(view);
    }

    private Insets getSystemGestureInsets() {
        WindowInsetsCompat rootWindowInsets;
        if (!sEdgeSizeUsingSystemGestureInsets || (rootWindowInsets = ViewCompat.getRootWindowInsets(this)) == null) {
            return null;
        }
        return rootWindowInsets.getSystemGestureInsets();
    }

    private static int measureChildHeight(@NonNull View view, int i4, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
            return View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824);
        }
        return ViewGroup.getChildMeasureSpec(i4, i5, layoutParams.height);
    }

    private boolean openPane(int i4) {
        if (!this.mCanSlide) {
            this.mPreservedOpenState = true;
        }
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i4)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    private void parallaxOtherViews(float f4) {
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != this.mSlideableView) {
                int i5 = this.mParallaxBy;
                this.mParallaxOffset = f4;
                int i6 = ((int) ((1.0f - this.mParallaxOffset) * ((float) i5))) - ((int) ((1.0f - f4) * ((float) i5)));
                if (isLayoutRtlSupport) {
                    i6 = -i6;
                }
                childAt.offsetLeftAndRight(i6);
            }
        }
    }

    private void setFoldingFeatureObserver(FoldingFeatureObserver foldingFeatureObserver) {
        this.mFoldingFeatureObserver = foldingFeatureObserver;
        foldingFeatureObserver.setOnFoldingFeatureChangeListener(this.mOnFoldingFeatureChangeListener);
    }

    private ArrayList<Rect> splitViewPositions() {
        Rect foldBoundsInView;
        FoldingFeature foldingFeature = this.mFoldingFeature;
        if (foldingFeature == null || !foldingFeature.isSeparating() || this.mFoldingFeature.getBounds().left == 0 || this.mFoldingFeature.getBounds().top != 0 || (foldBoundsInView = getFoldBoundsInView(this.mFoldingFeature, this)) == null) {
            return null;
        }
        Rect rect = new Rect(getPaddingLeft(), getPaddingTop(), Math.max(getPaddingLeft(), foldBoundsInView.left), getHeight() - getPaddingBottom());
        int width = getWidth() - getPaddingRight();
        return new ArrayList<>(Arrays.asList(new Rect[]{rect, new Rect(Math.min(width, foldBoundsInView.right), getPaddingTop(), width, getHeight() - getPaddingBottom())}));
    }

    private static boolean viewIsOpaque(View view) {
        if (view.isOpaque()) {
            return true;
        }
        return false;
    }

    public void addPanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        this.mPanelSlideListeners.add(panelSlideListener);
    }

    public void addView(@NonNull View view, int i4, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() == 1) {
            super.addView(new TouchBlocker(view), i4, layoutParams);
        } else {
            super.addView(view, i4, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z4, int i4, int i5, int i6) {
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i4, i8 - childAt.getLeft(), i7 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z4) {
            return false;
        }
        if (!isLayoutRtlSupport()) {
            i4 = -i4;
        }
        if (view.canScrollHorizontally(i4)) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void close() {
        closePane();
    }

    public void computeScroll() {
        if (!this.mDragHelper.continueSettling(true)) {
            return;
        }
        if (!this.mCanSlide) {
            this.mDragHelper.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelClosed(@NonNull View view) {
        for (PanelSlideListener onPanelClosed : this.mPanelSlideListeners) {
            onPanelClosed.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelOpened(@NonNull View view) {
        for (PanelSlideListener onPanelOpened : this.mPanelSlideListeners) {
            onPanelOpened.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelSlide(@NonNull View view) {
        for (PanelSlideListener onPanelSlide : this.mPanelSlideListeners) {
            onPanelSlide.onPanelSlide(view, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i4;
        int i5;
        super.draw(canvas);
        if (isLayoutRtlSupport()) {
            drawable = this.mShadowDrawableRight;
        } else {
            drawable = this.mShadowDrawableLeft;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                i5 = view.getRight();
                i4 = intrinsicWidth + i5;
            } else {
                int left = view.getLeft();
                int i6 = left - intrinsicWidth;
                i4 = left;
                i5 = i6;
            }
            drawable.setBounds(i5, top, i4, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j4) {
        if (isLayoutRtlSupport() ^ isOpen()) {
            this.mDragHelper.setEdgeTrackingEnabled(1);
            Insets systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                ViewDragHelper viewDragHelper = this.mDragHelper;
                viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            }
        } else {
            this.mDragHelper.setEdgeTrackingEnabled(2);
            Insets systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                ViewDragHelper viewDragHelper2 = this.mDragHelper;
                viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets2.right));
            }
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.mCanSlide && !layoutParams.slideable && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean drawChild = super.drawChild(canvas, view, j4);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @ColorInt
    @Deprecated
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public final int getLockMode() {
        return this.mLockMode;
    }

    @Px
    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    @Deprecated
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    /* access modifiers changed from: package-private */
    public void invalidateChildRegion(View view) {
        ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
    }

    /* access modifiers changed from: package-private */
    public boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.mCanSlide || !layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRtlSupport() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        if (!this.mCanSlide || this.mSlideOffset == 0.0f) {
            return true;
        }
        return false;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        Activity activityOrNull;
        super.onAttachedToWindow();
        this.mFirstLayout = true;
        if (this.mFoldingFeatureObserver != null && (activityOrNull = getActivityOrNull(getContext())) != null) {
            this.mFoldingFeatureObserver.registerLayoutStateChangeCallback(activityOrNull);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        FoldingFeatureObserver foldingFeatureObserver = this.mFoldingFeatureObserver;
        if (foldingFeatureObserver != null) {
            foldingFeatureObserver.unregisterLayoutStateChangeCallback();
        }
        int size = this.mPostedRunnables.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mPostedRunnables.get(i4).run();
        }
        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                this.mInitialMotionX = x4;
                this.mInitialMotionY = y4;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x4, (int) y4) && isDimmed(this.mSlideableView)) {
                    z4 = true;
                    if (!this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z4) {
                        return true;
                    }
                    return false;
                }
            } else if (actionMasked == 2) {
                float x5 = motionEvent.getX();
                float y5 = motionEvent.getY();
                float abs = Math.abs(x5 - this.mInitialMotionX);
                float abs2 = Math.abs(y5 - this.mInitialMotionY);
                if (abs > ((float) this.mDragHelper.getTouchSlop()) && abs2 > abs) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z4 = false;
            if (!this.mDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.isLayoutRtlSupport()
            int r2 = r22 - r20
            if (r1 == 0) goto L_0x000f
            int r3 = r0.getPaddingRight()
            goto L_0x0013
        L_0x000f:
            int r3 = r0.getPaddingLeft()
        L_0x0013:
            if (r1 == 0) goto L_0x001a
            int r4 = r0.getPaddingLeft()
            goto L_0x001e
        L_0x001a:
            int r4 = r0.getPaddingRight()
        L_0x001e:
            int r5 = r0.getPaddingTop()
            int r6 = r0.getChildCount()
            boolean r7 = r0.mFirstLayout
            if (r7 == 0) goto L_0x0038
            boolean r7 = r0.mCanSlide
            if (r7 == 0) goto L_0x0034
            boolean r7 = r0.mPreservedOpenState
            if (r7 == 0) goto L_0x0034
            r7 = 0
            goto L_0x0036
        L_0x0034:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x0036:
            r0.mSlideOffset = r7
        L_0x0038:
            r9 = r3
            r10 = 0
        L_0x003a:
            if (r10 >= r6) goto L_0x00ea
            android.view.View r11 = r0.getChildAt(r10)
            int r12 = r11.getVisibility()
            r13 = 8
            if (r12 != r13) goto L_0x004c
            r19 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00e6
        L_0x004c:
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r12 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r12
            int r13 = r11.getMeasuredWidth()
            boolean r14 = r12.slideable
            if (r14 == 0) goto L_0x0092
            int r14 = r12.leftMargin
            int r15 = r12.rightMargin
            int r14 = r14 + r15
            int r15 = r2 - r4
            int r16 = java.lang.Math.min(r3, r15)
            int r16 = r16 - r9
            int r14 = r16 - r14
            r0.mSlideRange = r14
            r19 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x0072
            int r8 = r12.rightMargin
            goto L_0x0074
        L_0x0072:
            int r8 = r12.leftMargin
        L_0x0074:
            int r16 = r9 + r8
            int r16 = r16 + r14
            int r17 = r13 / 2
            int r7 = r16 + r17
            if (r7 <= r15) goto L_0x0080
            r7 = 1
            goto L_0x0081
        L_0x0080:
            r7 = 0
        L_0x0081:
            r12.dimWhenOffset = r7
            float r7 = (float) r14
            float r12 = r0.mSlideOffset
            float r7 = r7 * r12
            int r7 = (int) r7
            int r8 = r8 + r7
            int r9 = r9 + r8
            float r7 = (float) r7
            float r8 = (float) r14
            float r7 = r7 / r8
            r0.mSlideOffset = r7
        L_0x0090:
            r7 = 0
            goto L_0x00a8
        L_0x0092:
            r19 = 1065353216(0x3f800000, float:1.0)
            boolean r7 = r0.mCanSlide
            if (r7 == 0) goto L_0x00a6
            int r7 = r0.mParallaxBy
            if (r7 == 0) goto L_0x00a6
            float r8 = r0.mSlideOffset
            float r8 = r19 - r8
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            r9 = r3
            goto L_0x00a8
        L_0x00a6:
            r9 = r3
            goto L_0x0090
        L_0x00a8:
            if (r1 == 0) goto L_0x00b0
            int r8 = r2 - r9
            int r8 = r8 + r7
            int r7 = r8 - r13
            goto L_0x00b4
        L_0x00b0:
            int r7 = r9 - r7
            int r8 = r7 + r13
        L_0x00b4:
            int r12 = r11.getMeasuredHeight()
            int r12 = r12 + r5
            r11.layout(r7, r5, r8, r12)
            androidx.window.layout.FoldingFeature r7 = r0.mFoldingFeature
            if (r7 == 0) goto L_0x00db
            androidx.window.layout.FoldingFeature$Orientation r7 = r7.getOrientation()
            androidx.window.layout.FoldingFeature$Orientation r8 = androidx.window.layout.FoldingFeature.Orientation.VERTICAL
            if (r7 != r8) goto L_0x00db
            androidx.window.layout.FoldingFeature r7 = r0.mFoldingFeature
            boolean r7 = r7.isSeparating()
            if (r7 == 0) goto L_0x00db
            androidx.window.layout.FoldingFeature r7 = r0.mFoldingFeature
            android.graphics.Rect r7 = r7.getBounds()
            int r7 = r7.width()
            goto L_0x00dc
        L_0x00db:
            r7 = 0
        L_0x00dc:
            int r8 = r11.getWidth()
            int r7 = java.lang.Math.abs(r7)
            int r8 = r8 + r7
            int r3 = r3 + r8
        L_0x00e6:
            int r10 = r10 + 1
            goto L_0x003a
        L_0x00ea:
            boolean r1 = r0.mFirstLayout
            if (r1 == 0) goto L_0x0100
            boolean r1 = r0.mCanSlide
            if (r1 == 0) goto L_0x00fb
            int r1 = r0.mParallaxBy
            if (r1 == 0) goto L_0x00fb
            float r1 = r0.mSlideOffset
            r0.parallaxOtherViews(r1)
        L_0x00fb:
            android.view.View r1 = r0.mSlideableView
            r0.updateObscuredViewsVisibility(r1)
        L_0x0100:
            r1 = 0
            r0.mFirstLayout = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        if (r8.width == 0) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r20, int r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            int r2 = android.view.View.MeasureSpec.getMode(r20)
            int r3 = android.view.View.MeasureSpec.getSize(r20)
            int r4 = android.view.View.MeasureSpec.getMode(r1)
            int r5 = android.view.View.MeasureSpec.getSize(r1)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 0
            if (r4 == r6) goto L_0x002c
            if (r4 == r7) goto L_0x0020
            r5 = 0
            r9 = 0
            goto L_0x0038
        L_0x0020:
            int r9 = r0.getPaddingTop()
            int r5 = r5 - r9
            int r9 = r0.getPaddingBottom()
            int r5 = r5 - r9
            r9 = r5
            goto L_0x0038
        L_0x002c:
            int r9 = r0.getPaddingTop()
            int r5 = r5 - r9
            int r9 = r0.getPaddingBottom()
            int r5 = r5 - r9
            r9 = r5
            r5 = 0
        L_0x0038:
            int r10 = r0.getPaddingLeft()
            int r10 = r3 - r10
            int r11 = r0.getPaddingRight()
            int r10 = r10 - r11
            int r10 = java.lang.Math.max(r10, r8)
            int r11 = r0.getChildCount()
            r12 = 2
            if (r11 <= r12) goto L_0x0055
            java.lang.String r12 = "SlidingPaneLayout"
            java.lang.String r13 = "onMeasure: More than two child views are not supported."
            android.util.Log.e(r12, r13)
        L_0x0055:
            r12 = 0
            r0.mSlideableView = r12
            r12 = r10
            r20 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x005e:
            r6 = 8
            if (r13 >= r11) goto L_0x00f6
            android.view.View r7 = r0.getChildAt(r13)
            android.view.ViewGroup$LayoutParams r16 = r7.getLayoutParams()
            r8 = r16
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r8 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r8
            r16 = r10
            int r10 = r7.getVisibility()
            if (r10 != r6) goto L_0x007d
            r6 = 0
            r8.dimWhenOffset = r6
        L_0x0079:
            r17 = r13
            goto L_0x00ed
        L_0x007d:
            float r6 = r8.weight
            int r10 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r10 <= 0) goto L_0x0089
            float r15 = r15 + r6
            int r6 = r8.width
            if (r6 != 0) goto L_0x0089
            goto L_0x0079
        L_0x0089:
            int r6 = r8.leftMargin
            int r10 = r8.rightMargin
            int r6 = r6 + r10
            int r10 = r16 - r6
            r6 = 0
            int r10 = java.lang.Math.max(r10, r6)
            int r6 = r8.width
            r17 = r13
            r13 = -2
            if (r6 != r13) goto L_0x00a7
            if (r2 != 0) goto L_0x00a0
            r6 = r2
            goto L_0x00a2
        L_0x00a0:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00a2:
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r6)
            goto L_0x00b5
        L_0x00a7:
            r13 = -1
            if (r6 != r13) goto L_0x00af
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r2)
            goto L_0x00b5
        L_0x00af:
            r10 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r10)
        L_0x00b5:
            int r10 = r0.getPaddingTop()
            int r13 = r0.getPaddingBottom()
            int r10 = r10 + r13
            int r13 = r8.height
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r10, r13)
            r7.measure(r6, r10)
            int r6 = r7.getMeasuredWidth()
            int r10 = r7.getMeasuredHeight()
            if (r10 <= r5) goto L_0x00dd
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r13) goto L_0x00da
            int r5 = java.lang.Math.min(r10, r9)
            goto L_0x00dd
        L_0x00da:
            if (r4 != 0) goto L_0x00dd
            r5 = r10
        L_0x00dd:
            int r12 = r12 - r6
            if (r17 != 0) goto L_0x00e1
            goto L_0x00ed
        L_0x00e1:
            if (r12 >= 0) goto L_0x00e5
            r6 = 1
            goto L_0x00e6
        L_0x00e5:
            r6 = 0
        L_0x00e6:
            r8.slideable = r6
            r14 = r14 | r6
            if (r6 == 0) goto L_0x00ed
            r0.mSlideableView = r7
        L_0x00ed:
            int r13 = r17 + 1
            r10 = r16
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 0
            goto L_0x005e
        L_0x00f6:
            r16 = r10
            if (r14 != 0) goto L_0x00fe
            int r2 = (r15 > r20 ? 1 : (r15 == r20 ? 0 : -1))
            if (r2 <= 0) goto L_0x0181
        L_0x00fe:
            r2 = 0
        L_0x00ff:
            if (r2 >= r11) goto L_0x0181
            android.view.View r7 = r0.getChildAt(r2)
            int r8 = r7.getVisibility()
            if (r8 != r6) goto L_0x010d
            goto L_0x017b
        L_0x010d:
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r8 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r8
            int r10 = r8.width
            if (r10 != 0) goto L_0x011f
            float r10 = r8.weight
            int r10 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r10 <= 0) goto L_0x011f
            r10 = 0
            goto L_0x0123
        L_0x011f:
            int r10 = r7.getMeasuredWidth()
        L_0x0123:
            if (r14 == 0) goto L_0x0136
            int r13 = r8.leftMargin
            int r8 = r8.rightMargin
            int r13 = r13 + r8
            int r8 = r16 - r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r17 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r13)
            r6 = r17
            r13 = 0
            goto L_0x0156
        L_0x0136:
            float r13 = r8.weight
            int r13 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r13 <= 0) goto L_0x0153
            r13 = 0
            int r6 = java.lang.Math.max(r13, r12)
            float r8 = r8.weight
            float r6 = (float) r6
            float r8 = r8 * r6
            float r8 = r8 / r15
            int r6 = (int) r8
            int r8 = r10 + r6
            r6 = 1073741824(0x40000000, float:2.0)
            int r17 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            r6 = r17
            goto L_0x0156
        L_0x0153:
            r13 = 0
            r8 = r10
            r6 = 0
        L_0x0156:
            int r17 = r0.getPaddingTop()
            int r18 = r0.getPaddingBottom()
            int r13 = r17 + r18
            int r13 = measureChildHeight(r7, r1, r13)
            if (r10 == r8) goto L_0x017b
            r7.measure(r6, r13)
            int r6 = r7.getMeasuredHeight()
            if (r6 <= r5) goto L_0x017b
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r13) goto L_0x0178
            int r5 = java.lang.Math.min(r6, r9)
            goto L_0x017b
        L_0x0178:
            if (r4 != 0) goto L_0x017b
            r5 = r6
        L_0x017b:
            int r2 = r2 + 1
            r6 = 8
            goto L_0x00ff
        L_0x0181:
            java.util.ArrayList r1 = r0.splitViewPositions()
            if (r1 == 0) goto L_0x0206
            if (r14 != 0) goto L_0x0206
            r8 = 0
        L_0x018a:
            if (r8 >= r11) goto L_0x0206
            android.view.View r2 = r0.getChildAt(r8)
            int r4 = r2.getVisibility()
            r6 = 8
            if (r4 != r6) goto L_0x019d
            r12 = 1073741824(0x40000000, float:2.0)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x01fb
        L_0x019d:
            java.lang.Object r4 = r1.get(r8)
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            android.view.ViewGroup$LayoutParams r7 = r2.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r9 = r7.leftMargin
            int r10 = r7.rightMargin
            int r9 = r9 + r10
            int r10 = r2.getMeasuredHeight()
            r13 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r13)
            int r12 = r4.width()
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
            r2.measure(r12, r10)
            int r12 = r2.getMeasuredWidthAndState()
            r15 = 16777216(0x1000000, float:2.3509887E-38)
            r12 = r12 & r15
            r15 = 1
            if (r12 == r15) goto L_0x01df
            int r12 = getMinimumWidth(r2)
            if (r12 == 0) goto L_0x01e2
            int r12 = r4.width()
            int r15 = getMinimumWidth(r2)
            if (r12 >= r15) goto L_0x01e2
        L_0x01df:
            r12 = 1073741824(0x40000000, float:2.0)
            goto L_0x01f0
        L_0x01e2:
            int r4 = r4.width()
            r12 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r12)
            r2.measure(r4, r10)
            goto L_0x01fb
        L_0x01f0:
            int r4 = r16 - r9
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r12)
            r2.measure(r4, r10)
            if (r8 != 0) goto L_0x01fd
        L_0x01fb:
            r15 = 1
            goto L_0x0203
        L_0x01fd:
            r15 = 1
            r7.slideable = r15
            r0.mSlideableView = r2
            r14 = 1
        L_0x0203:
            int r8 = r8 + 1
            goto L_0x018a
        L_0x0206:
            int r1 = r0.getPaddingTop()
            int r5 = r5 + r1
            int r1 = r0.getPaddingBottom()
            int r5 = r5 + r1
            r0.setMeasuredDimension(r3, r5)
            r0.mCanSlide = r14
            androidx.customview.widget.ViewDragHelper r1 = r0.mDragHelper
            int r1 = r1.getViewDragState()
            if (r1 == 0) goto L_0x0224
            if (r14 != 0) goto L_0x0224
            androidx.customview.widget.ViewDragHelper r1 = r0.mDragHelper
            r1.abort()
        L_0x0224:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void onPanelDragged(int i4) {
        int i5;
        int i6;
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i4 = (getWidth() - i4) - width;
        }
        if (isLayoutRtlSupport) {
            i5 = getPaddingRight();
        } else {
            i5 = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i6 = layoutParams.rightMargin;
        } else {
            i6 = layoutParams.leftMargin;
        }
        float f4 = ((float) (i4 - (i5 + i6))) / ((float) this.mSlideRange);
        this.mSlideOffset = f4;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(f4);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = savedState.isOpen;
        setLockMode(savedState.mLockMode);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        boolean z4;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
            z4 = isOpen();
        } else {
            z4 = this.mPreservedOpenState;
        }
        savedState.isOpen = z4;
        savedState.mLockMode = this.mLockMode;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
                float x4 = motionEvent.getX();
                float y4 = motionEvent.getY();
                float f4 = x4 - this.mInitialMotionX;
                float f5 = y4 - this.mInitialMotionY;
                int touchSlop = this.mDragHelper.getTouchSlop();
                if ((f4 * f4) + (f5 * f5) < ((float) (touchSlop * touchSlop)) && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x4, (int) y4)) {
                    closePane(0);
                }
            }
            return true;
        }
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        this.mInitialMotionX = x5;
        this.mInitialMotionY = y5;
        return true;
    }

    public void open() {
        openPane();
    }

    public void removePanelSlideListener(@NonNull PanelSlideListener panelSlideListener) {
        this.mPanelSlideListeners.remove(panelSlideListener);
    }

    public void removeView(@NonNull View view) {
        if (view.getParent() instanceof TouchBlocker) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    public void requestChildFocus(View view, View view2) {
        boolean z4;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            if (view == this.mSlideableView) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mPreservedOpenState = z4;
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Deprecated
    public void setCoveredFadeColor(@ColorInt int i4) {
        this.mCoveredFadeColor = i4;
    }

    public final void setLockMode(int i4) {
        this.mLockMode = i4;
    }

    @Deprecated
    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        PanelSlideListener panelSlideListener2 = this.mPanelSlideListener;
        if (panelSlideListener2 != null) {
            removePanelSlideListener(panelSlideListener2);
        }
        if (panelSlideListener != null) {
            addPanelSlideListener(panelSlideListener);
        }
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(@Px int i4) {
        this.mParallaxBy = i4;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i4) {
        setShadowDrawableLeft(getResources().getDrawable(i4));
    }

    public void setShadowResourceLeft(int i4) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i4));
    }

    public void setShadowResourceRight(int i4) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i4));
    }

    @Deprecated
    public void setSliderFadeColor(@ColorInt int i4) {
        this.mSliderFadeColor = i4;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    /* access modifiers changed from: package-private */
    public boolean smoothSlideTo(float f4, int i4) {
        int i5;
        if (!this.mCanSlide) {
            return false;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport) {
            i5 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f4 * ((float) this.mSlideRange))) + ((float) this.mSlideableView.getWidth())));
        } else {
            i5 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f4 * ((float) this.mSlideRange)));
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        View view = this.mSlideableView;
        if (!viewDragHelper.smoothSlideViewTo(view, i5, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void updateObscuredViewsVisibility(View view) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        View childAt;
        boolean z4;
        int i10;
        int i11;
        int i12;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        if (isLayoutRtlSupport) {
            i4 = getWidth() - getPaddingRight();
        } else {
            i4 = getPaddingLeft();
        }
        if (isLayoutRtlSupport) {
            i5 = getPaddingLeft();
        } else {
            i5 = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view2)) {
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
        } else {
            i9 = view2.getLeft();
            i8 = view2.getRight();
            i7 = view2.getTop();
            i6 = view2.getBottom();
        }
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            if (i13 < childCount && (childAt = getChildAt(i13)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z4 = isLayoutRtlSupport;
                } else {
                    if (isLayoutRtlSupport) {
                        i10 = i5;
                    } else {
                        i10 = i4;
                    }
                    int max = Math.max(i10, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    if (isLayoutRtlSupport) {
                        i11 = i4;
                    } else {
                        i11 = i5;
                    }
                    z4 = isLayoutRtlSupport;
                    int min = Math.min(i11, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max < i9 || max2 < i7 || min > i8 || min2 > i6) {
                        i12 = 0;
                    } else {
                        i12 = 4;
                    }
                    childAt.setVisibility(i12);
                }
                i13++;
                view2 = view;
                isLayoutRtlSupport = z4;
            } else {
                return;
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mSliderFadeColor = 0;
        this.mSlideOffset = 1.0f;
        this.mPanelSlideListeners = new CopyOnWriteArrayList();
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        this.mOnFoldingFeatureChangeListener = new FoldingFeatureObserver.OnFoldingFeatureChangeListener() {
            public void onFoldingFeatureChange(@NonNull FoldingFeature foldingFeature) {
                SlidingPaneLayout.this.mFoldingFeature = foldingFeature;
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(300);
                changeBounds.setInterpolator(PathInterpolatorCompat.create(0.2f, 0.0f, 0.0f, 1.0f));
                TransitionManager.beginDelayedTransition(SlidingPaneLayout.this, changeBounds);
                SlidingPaneLayout.this.requestLayout();
            }
        };
        float f4 = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewDragHelper create = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper = create;
        create.setMinVelocity(f4 * 400.0f);
        setFoldingFeatureObserver(new FoldingFeatureObserver(j.a(context), ContextCompat.getMainExecutor(context)));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public boolean closePane() {
        return closePane(0);
    }

    public boolean openPane() {
        return openPane(0);
    }
}
