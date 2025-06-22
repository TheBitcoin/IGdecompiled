package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

public abstract class BaseGridView extends RecyclerView {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FOCUS_SCROLL_ALIGNED = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FOCUS_SCROLL_ITEM = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int FOCUS_SCROLL_PAGE = 2;
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    public static final int SAVE_ALL_CHILD = 3;
    public static final int SAVE_LIMITED_CHILD = 2;
    public static final int SAVE_NO_CHILD = 0;
    public static final int SAVE_ON_SCREEN_CHILD = 1;
    public static final int WINDOW_ALIGN_BOTH_EDGE = 3;
    public static final int WINDOW_ALIGN_HIGH_EDGE = 2;
    public static final int WINDOW_ALIGN_LOW_EDGE = 1;
    public static final int WINDOW_ALIGN_NO_EDGE = 0;
    public static final float WINDOW_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private boolean mAnimateChildLayout = true;
    RecyclerView.RecyclerListener mChainedRecyclerListener;
    private boolean mHasOverlappingRendering = true;
    int mInitialPrefetchItemCount = 4;
    final GridLayoutManager mLayoutManager;
    private OnKeyInterceptListener mOnKeyInterceptListener;
    private OnMotionInterceptListener mOnMotionInterceptListener;
    private OnTouchInterceptListener mOnTouchInterceptListener;
    private OnUnhandledKeyListener mOnUnhandledKeyListener;
    private RecyclerView.ItemAnimator mSavedItemAnimator;

    public interface OnKeyInterceptListener {
        boolean onInterceptKeyEvent(KeyEvent keyEvent);
    }

    public interface OnMotionInterceptListener {
        boolean onInterceptMotionEvent(MotionEvent motionEvent);
    }

    public interface OnTouchInterceptListener {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(KeyEvent keyEvent);
    }

    BaseGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        this.mLayoutManager = gridLayoutManager;
        setLayoutManager(gridLayoutManager);
        setPreserveFocusAfterLayout(false);
        setDescendantFocusability(262144);
        setHasFixedSize(true);
        setChildrenDrawingOrderEnabled(true);
        setWillNotDraw(true);
        setOverScrollMode(2);
        ((SimpleItemAnimator) getItemAnimator()).setSupportsChangeAnimations(false);
        super.setRecyclerListener(new RecyclerView.RecyclerListener() {
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                BaseGridView.this.mLayoutManager.onChildRecycled(viewHolder);
                RecyclerView.RecyclerListener recyclerListener = BaseGridView.this.mChainedRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
            }
        });
    }

    public void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.addOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public void animateIn() {
        this.mLayoutManager.slideIn();
    }

    public void animateOut() {
        this.mLayoutManager.slideOut();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchGenericFocusedEvent(MotionEvent motionEvent) {
        OnMotionInterceptListener onMotionInterceptListener = this.mOnMotionInterceptListener;
        if (onMotionInterceptListener == null || !onMotionInterceptListener.onInterceptMotionEvent(motionEvent)) {
            return super.dispatchGenericFocusedEvent(motionEvent);
        }
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnKeyInterceptListener onKeyInterceptListener = this.mOnKeyInterceptListener;
        if ((onKeyInterceptListener != null && onKeyInterceptListener.onInterceptKeyEvent(keyEvent)) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnUnhandledKeyListener onUnhandledKeyListener = this.mOnUnhandledKeyListener;
        if (onUnhandledKeyListener == null || !onUnhandledKeyListener.onUnhandledKey(keyEvent)) {
            return false;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        OnTouchInterceptListener onTouchInterceptListener = this.mOnTouchInterceptListener;
        if (onTouchInterceptListener == null || !onTouchInterceptListener.onInterceptTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public View focusSearch(int i4) {
        if (isFocused()) {
            GridLayoutManager gridLayoutManager = this.mLayoutManager;
            View findViewByPosition = gridLayoutManager.findViewByPosition(gridLayoutManager.getSelection());
            if (findViewByPosition != null) {
                return focusSearch(findViewByPosition, i4);
            }
        }
        return super.focusSearch(i4);
    }

    public int getChildDrawingOrder(int i4, int i5) {
        return this.mLayoutManager.getChildDrawingOrder(this, i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getExtraLayoutSpace() {
        return this.mLayoutManager.getExtraLayoutSpace();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getFocusScrollStrategy() {
        return this.mLayoutManager.getFocusScrollStrategy();
    }

    @Deprecated
    public int getHorizontalMargin() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getHorizontalSpacing() {
        return this.mLayoutManager.getHorizontalSpacing();
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getItemAlignmentOffset() {
        return this.mLayoutManager.getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.mLayoutManager.getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.mLayoutManager.getItemAlignmentViewId();
    }

    public OnUnhandledKeyListener getOnUnhandledKeyListener() {
        return this.mOnUnhandledKeyListener;
    }

    public final int getSaveChildrenLimitNumber() {
        return this.mLayoutManager.mChildrenStates.getLimitNumber();
    }

    public final int getSaveChildrenPolicy() {
        return this.mLayoutManager.mChildrenStates.getSavePolicy();
    }

    public int getSelectedPosition() {
        return this.mLayoutManager.getSelection();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getSelectedSubPosition() {
        return this.mLayoutManager.getSubSelection();
    }

    @Deprecated
    public int getVerticalMargin() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public int getVerticalSpacing() {
        return this.mLayoutManager.getVerticalSpacing();
    }

    public void getViewSelectedOffsets(View view, int[] iArr) {
        this.mLayoutManager.getViewSelectedOffsets(view, iArr);
    }

    public int getWindowAlignment() {
        return this.mLayoutManager.getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.mLayoutManager.getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.mLayoutManager.getWindowAlignmentOffsetPercent();
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    public boolean hasPreviousViewInSameRow(int i4) {
        return this.mLayoutManager.hasPreviousViewInSameRow(i4);
    }

    /* access modifiers changed from: package-private */
    public void initBaseGridViewAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbBaseGridView);
        this.mLayoutManager.setFocusOutAllowed(obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutFront, false), obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutEnd, false));
        this.mLayoutManager.setFocusOutSideAllowed(obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideStart, true), obtainStyledAttributes.getBoolean(R.styleable.lbBaseGridView_focusOutSideEnd, true));
        this.mLayoutManager.setVerticalSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_verticalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_verticalMargin, 0)));
        this.mLayoutManager.setHorizontalSpacing(obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_android_horizontalSpacing, obtainStyledAttributes.getDimensionPixelSize(R.styleable.lbBaseGridView_horizontalMargin, 0)));
        int i4 = R.styleable.lbBaseGridView_android_gravity;
        if (obtainStyledAttributes.hasValue(i4)) {
            setGravity(obtainStyledAttributes.getInt(i4, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public boolean isChildLayoutAnimated() {
        return this.mAnimateChildLayout;
    }

    /* access modifiers changed from: package-private */
    public final boolean isChildrenDrawingOrderEnabledInternal() {
        return isChildrenDrawingOrderEnabled();
    }

    public boolean isFocusDrawingOrderEnabled() {
        return super.isChildrenDrawingOrderEnabled();
    }

    public final boolean isFocusSearchDisabled() {
        return this.mLayoutManager.isFocusSearchDisabled();
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return this.mLayoutManager.isItemAlignmentOffsetWithPadding();
    }

    public boolean isScrollEnabled() {
        return this.mLayoutManager.isScrollEnabled();
    }

    public boolean isWindowAlignmentPreferKeyLineOverHighEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverHighEdge();
    }

    public boolean isWindowAlignmentPreferKeyLineOverLowEdge() {
        return this.mLayoutManager.mWindowAlignment.mainAxis().isPreferKeylineOverLowEdge();
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z4, int i4, Rect rect) {
        super.onFocusChanged(z4, i4, rect);
        this.mLayoutManager.onFocusChanged(z4, i4, rect);
    }

    public boolean onRequestFocusInDescendants(int i4, Rect rect) {
        return this.mLayoutManager.gridOnRequestFocusInDescendants(this, i4, rect);
    }

    public void onRtlPropertiesChanged(int i4) {
        this.mLayoutManager.onRtlPropertiesChanged(i4);
    }

    public void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.removeOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public void scrollToPosition(int i4) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i4, 0, 0);
        } else {
            super.scrollToPosition(i4);
        }
    }

    public void setAnimateChildLayout(boolean z4) {
        if (this.mAnimateChildLayout != z4) {
            this.mAnimateChildLayout = z4;
            if (!z4) {
                this.mSavedItemAnimator = getItemAnimator();
                super.setItemAnimator((RecyclerView.ItemAnimator) null);
                return;
            }
            super.setItemAnimator(this.mSavedItemAnimator);
        }
    }

    public void setChildrenVisibility(int i4) {
        this.mLayoutManager.setChildrenVisibility(i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraLayoutSpace(int i4) {
        this.mLayoutManager.setExtraLayoutSpace(i4);
    }

    public void setFocusDrawingOrderEnabled(boolean z4) {
        super.setChildrenDrawingOrderEnabled(z4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFocusScrollStrategy(int i4) {
        if (i4 == 0 || i4 == 1 || i4 == 2) {
            this.mLayoutManager.setFocusScrollStrategy(i4);
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid scrollStrategy");
    }

    public final void setFocusSearchDisabled(boolean z4) {
        int i4;
        if (z4) {
            i4 = 393216;
        } else {
            i4 = 262144;
        }
        setDescendantFocusability(i4);
        this.mLayoutManager.setFocusSearchDisabled(z4);
    }

    public void setGravity(int i4) {
        this.mLayoutManager.setGravity(i4);
        requestLayout();
    }

    public void setHasOverlappingRendering(boolean z4) {
        this.mHasOverlappingRendering = z4;
    }

    @Deprecated
    public void setHorizontalMargin(int i4) {
        setHorizontalSpacing(i4);
    }

    public void setHorizontalSpacing(int i4) {
        this.mLayoutManager.setHorizontalSpacing(i4);
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int i4) {
        this.mInitialPrefetchItemCount = i4;
    }

    public void setItemAlignmentOffset(int i4) {
        this.mLayoutManager.setItemAlignmentOffset(i4);
        requestLayout();
    }

    public void setItemAlignmentOffsetPercent(float f4) {
        this.mLayoutManager.setItemAlignmentOffsetPercent(f4);
        requestLayout();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z4) {
        this.mLayoutManager.setItemAlignmentOffsetWithPadding(z4);
        requestLayout();
    }

    public void setItemAlignmentViewId(int i4) {
        this.mLayoutManager.setItemAlignmentViewId(i4);
    }

    @Deprecated
    public void setItemMargin(int i4) {
        setItemSpacing(i4);
    }

    public void setItemSpacing(int i4) {
        this.mLayoutManager.setItemSpacing(i4);
        requestLayout();
    }

    public void setLayoutEnabled(boolean z4) {
        this.mLayoutManager.setLayoutEnabled(z4);
    }

    public void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mLayoutManager.setOnChildLaidOutListener(onChildLaidOutListener);
    }

    public void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mLayoutManager.setOnChildSelectedListener(onChildSelectedListener);
    }

    public void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        this.mLayoutManager.setOnChildViewHolderSelectedListener(onChildViewHolderSelectedListener);
    }

    public void setOnKeyInterceptListener(OnKeyInterceptListener onKeyInterceptListener) {
        this.mOnKeyInterceptListener = onKeyInterceptListener;
    }

    public void setOnMotionInterceptListener(OnMotionInterceptListener onMotionInterceptListener) {
        this.mOnMotionInterceptListener = onMotionInterceptListener;
    }

    public void setOnTouchInterceptListener(OnTouchInterceptListener onTouchInterceptListener) {
        this.mOnTouchInterceptListener = onTouchInterceptListener;
    }

    public void setOnUnhandledKeyListener(OnUnhandledKeyListener onUnhandledKeyListener) {
        this.mOnUnhandledKeyListener = onUnhandledKeyListener;
    }

    public void setPruneChild(boolean z4) {
        this.mLayoutManager.setPruneChild(z4);
    }

    public void setRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
        this.mChainedRecyclerListener = recyclerListener;
    }

    public final void setSaveChildrenLimitNumber(int i4) {
        this.mLayoutManager.mChildrenStates.setLimitNumber(i4);
    }

    public final void setSaveChildrenPolicy(int i4) {
        this.mLayoutManager.mChildrenStates.setSavePolicy(i4);
    }

    public void setScrollEnabled(boolean z4) {
        this.mLayoutManager.setScrollEnabled(z4);
    }

    public void setSelectedPosition(int i4) {
        this.mLayoutManager.setSelection(i4, 0);
    }

    public void setSelectedPositionSmooth(int i4) {
        this.mLayoutManager.setSelectionSmooth(i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSelectedPositionSmoothWithSub(int i4, int i5) {
        this.mLayoutManager.setSelectionSmoothWithSub(i4, i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSelectedPositionWithSub(int i4, int i5) {
        this.mLayoutManager.setSelectionWithSub(i4, i5, 0);
    }

    @Deprecated
    public void setVerticalMargin(int i4) {
        setVerticalSpacing(i4);
    }

    public void setVerticalSpacing(int i4) {
        this.mLayoutManager.setVerticalSpacing(i4);
        requestLayout();
    }

    public void setWindowAlignment(int i4) {
        this.mLayoutManager.setWindowAlignment(i4);
        requestLayout();
    }

    public void setWindowAlignmentOffset(int i4) {
        this.mLayoutManager.setWindowAlignmentOffset(i4);
        requestLayout();
    }

    public void setWindowAlignmentOffsetPercent(float f4) {
        this.mLayoutManager.setWindowAlignmentOffsetPercent(f4);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverHighEdge(boolean z4) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverHighEdge(z4);
        requestLayout();
    }

    public void setWindowAlignmentPreferKeyLineOverLowEdge(boolean z4) {
        this.mLayoutManager.mWindowAlignment.mainAxis().setPreferKeylineOverLowEdge(z4);
        requestLayout();
    }

    public void smoothScrollToPosition(int i4) {
        if (this.mLayoutManager.isSlidingChildViews()) {
            this.mLayoutManager.setSelectionWithSub(i4, 0, 0);
        } else {
            super.smoothScrollToPosition(i4);
        }
    }

    public void setSelectedPosition(int i4, int i5) {
        this.mLayoutManager.setSelection(i4, i5);
    }

    public void setSelectedPositionSmooth(final int i4, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i4);
            if (findViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
                    public void onChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
                        if (i4 == i4) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(findViewHolderForPosition);
            }
        }
        setSelectedPositionSmooth(i4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSelectedPositionWithSub(int i4, int i5, int i6) {
        this.mLayoutManager.setSelectionWithSub(i4, i5, i6);
    }

    public void setSelectedPosition(final int i4, final ViewHolderTask viewHolderTask) {
        if (viewHolderTask != null) {
            RecyclerView.ViewHolder findViewHolderForPosition = findViewHolderForPosition(i4);
            if (findViewHolderForPosition == null || hasPendingAdapterUpdates()) {
                addOnChildViewHolderSelectedListener(new OnChildViewHolderSelectedListener() {
                    public void onChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
                        if (i4 == i4) {
                            BaseGridView.this.removeOnChildViewHolderSelectedListener(this);
                            viewHolderTask.run(viewHolder);
                        }
                    }
                });
            } else {
                viewHolderTask.run(findViewHolderForPosition);
            }
        }
        setSelectedPosition(i4);
    }
}
