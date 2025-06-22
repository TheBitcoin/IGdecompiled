package androidx.leanback.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.VisibleForTesting;
import androidx.collection.CircularIntArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.leanback.widget.Grid;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.leanback.widget.WindowAlignment;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class GridLayoutManager extends RecyclerView.LayoutManager {
    static final boolean DEBUG = false;
    static final int DEFAULT_MAX_PENDING_MOVES = 10;
    static final int MIN_MS_SMOOTH_SCROLL_MAIN_SCREEN = 30;
    private static final int NEXT_ITEM = 1;
    private static final int NEXT_ROW = 3;
    static final int PF_FAST_RELAYOUT = 4;
    static final int PF_FAST_RELAYOUT_UPDATED_SELECTED_POSITION = 8;
    static final int PF_FOCUS_OUT_END = 4096;
    static final int PF_FOCUS_OUT_FRONT = 2048;
    static final int PF_FOCUS_OUT_MASKS = 6144;
    static final int PF_FOCUS_OUT_SIDE_END = 16384;
    static final int PF_FOCUS_OUT_SIDE_MASKS = 24576;
    static final int PF_FOCUS_OUT_SIDE_START = 8192;
    static final int PF_FOCUS_SEARCH_DISABLED = 32768;
    static final int PF_FORCE_FULL_LAYOUT = 256;
    static final int PF_IN_LAYOUT_SEARCH_FOCUS = 16;
    static final int PF_IN_SELECTION = 32;
    static final int PF_LAYOUT_EATEN_IN_SLIDING = 128;
    static final int PF_LAYOUT_ENABLED = 512;
    static final int PF_PRUNE_CHILD = 65536;
    static final int PF_REVERSE_FLOW_MASK = 786432;
    static final int PF_REVERSE_FLOW_PRIMARY = 262144;
    static final int PF_REVERSE_FLOW_SECONDARY = 524288;
    static final int PF_ROW_SECONDARY_SIZE_REFRESH = 1024;
    static final int PF_SCROLL_ENABLED = 131072;
    static final int PF_SLIDING = 64;
    static final int PF_STAGE_LAYOUT = 1;
    static final int PF_STAGE_MASK = 3;
    static final int PF_STAGE_SCROLL = 2;
    private static final int PREV_ITEM = 0;
    private static final int PREV_ROW = 2;
    private static final String TAG = "GridLayoutManager";
    static final boolean TRACE = false;
    private static final Rect sTempRect = new Rect();
    static int[] sTwoInts = new int[2];
    final BaseGridView mBaseGridView;
    OnChildLaidOutListener mChildLaidOutListener = null;
    private OnChildSelectedListener mChildSelectedListener = null;
    private ArrayList<OnChildViewHolderSelectedListener> mChildViewHolderSelectedListeners = null;
    int mChildVisibility;
    final ViewsStateBundle mChildrenStates = new ViewsStateBundle();
    GridLinearSmoothScroller mCurrentSmoothScroller;
    int[] mDisappearingPositions;
    private int mExtraLayoutSpace;
    int mExtraLayoutSpaceInPreLayout;
    private FacetProviderAdapter mFacetProviderAdapter;
    private int mFixedRowSizeSecondary;
    int mFlag = 221696;
    int mFocusPosition = -1;
    private int mFocusPositionOffset = 0;
    private int mFocusScrollStrategy = 0;
    private int mGravity = 8388659;
    Grid mGrid;
    private Grid.Provider mGridProvider = new Grid.Provider() {
        public void addItem(Object obj, int i4, int i5, int i6, int i7) {
            int i8;
            int i9;
            long itemId;
            PendingMoveSmoothScroller pendingMoveSmoothScroller;
            int size;
            View view = (View) obj;
            if (i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
                if (!GridLayoutManager.this.mGrid.isReversedFlow()) {
                    size = GridLayoutManager.this.mWindowAlignment.mainAxis().getPaddingMin();
                } else {
                    size = GridLayoutManager.this.mWindowAlignment.mainAxis().getSize() - GridLayoutManager.this.mWindowAlignment.mainAxis().getPaddingMax();
                }
                i7 = size;
            }
            if (!GridLayoutManager.this.mGrid.isReversedFlow()) {
                i8 = i5 + i7;
                i9 = i7;
            } else {
                i9 = i7 - i5;
                i8 = i7;
            }
            int rowStartSecondary = GridLayoutManager.this.getRowStartSecondary(i6) + GridLayoutManager.this.mWindowAlignment.secondAxis().getPaddingMin();
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            int i10 = rowStartSecondary - gridLayoutManager.mScrollOffsetSecondary;
            gridLayoutManager.mChildrenStates.loadView(view, i4);
            GridLayoutManager.this.layoutChild(i6, view, i9, i8, i10);
            if (!GridLayoutManager.this.mState.isPreLayout()) {
                GridLayoutManager.this.updateScrollLimits();
            }
            GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
            if (!((gridLayoutManager2.mFlag & 3) == 1 || (pendingMoveSmoothScroller = gridLayoutManager2.mPendingMoveSmoothScroller) == null)) {
                pendingMoveSmoothScroller.consumePendingMovesAfterLayout();
            }
            GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
            if (gridLayoutManager3.mChildLaidOutListener != null) {
                RecyclerView.ViewHolder childViewHolder = gridLayoutManager3.mBaseGridView.getChildViewHolder(view);
                GridLayoutManager gridLayoutManager4 = GridLayoutManager.this;
                OnChildLaidOutListener onChildLaidOutListener = gridLayoutManager4.mChildLaidOutListener;
                BaseGridView baseGridView = gridLayoutManager4.mBaseGridView;
                if (childViewHolder == null) {
                    itemId = -1;
                } else {
                    itemId = childViewHolder.getItemId();
                }
                onChildLaidOutListener.onChildLaidOut(baseGridView, view, i4, itemId);
            }
        }

        /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.Object[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int createItem(int r6, boolean r7, java.lang.Object[] r8, boolean r9) {
            /*
                r5 = this;
                androidx.leanback.widget.GridLayoutManager r0 = androidx.leanback.widget.GridLayoutManager.this
                int r1 = r0.mPositionDeltaInPreLayout
                int r1 = r6 - r1
                android.view.View r0 = r0.getViewForPosition(r1)
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                androidx.leanback.widget.GridLayoutManager$LayoutParams r1 = (androidx.leanback.widget.GridLayoutManager.LayoutParams) r1
                androidx.leanback.widget.GridLayoutManager r2 = androidx.leanback.widget.GridLayoutManager.this
                androidx.leanback.widget.BaseGridView r2 = r2.mBaseGridView
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r2.getChildViewHolder(r0)
                androidx.leanback.widget.GridLayoutManager r3 = androidx.leanback.widget.GridLayoutManager.this
                java.lang.Class<androidx.leanback.widget.ItemAlignmentFacet> r4 = androidx.leanback.widget.ItemAlignmentFacet.class
                java.lang.Object r2 = r3.getFacet(r2, r4)
                androidx.leanback.widget.ItemAlignmentFacet r2 = (androidx.leanback.widget.ItemAlignmentFacet) r2
                r1.setItemAlignmentFacet(r2)
                boolean r1 = r1.isItemRemoved()
                r2 = 0
                if (r1 != 0) goto L_0x00b5
                if (r9 == 0) goto L_0x003c
                if (r7 == 0) goto L_0x0036
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                r7.addDisappearingView(r0)
                goto L_0x0049
            L_0x0036:
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                r7.addDisappearingView(r0, r2)
                goto L_0x0049
            L_0x003c:
                if (r7 == 0) goto L_0x0044
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                r7.addView(r0)
                goto L_0x0049
            L_0x0044:
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                r7.addView(r0, r2)
            L_0x0049:
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                int r7 = r7.mChildVisibility
                r9 = -1
                if (r7 == r9) goto L_0x0053
                r0.setVisibility(r7)
            L_0x0053:
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                androidx.leanback.widget.GridLayoutManager$PendingMoveSmoothScroller r7 = r7.mPendingMoveSmoothScroller
                if (r7 == 0) goto L_0x005c
                r7.consumePendingMovesBeforeLayout()
            L_0x005c:
                androidx.leanback.widget.GridLayoutManager r7 = androidx.leanback.widget.GridLayoutManager.this
                android.view.View r9 = r0.findFocus()
                int r7 = r7.getSubPositionByView(r0, r9)
                androidx.leanback.widget.GridLayoutManager r9 = androidx.leanback.widget.GridLayoutManager.this
                int r1 = r9.mFlag
                r3 = r1 & 3
                r4 = 1
                if (r3 == r4) goto L_0x007f
                int r1 = r9.mFocusPosition
                if (r6 != r1) goto L_0x00b0
                int r6 = r9.mSubFocusPosition
                if (r7 != r6) goto L_0x00b0
                androidx.leanback.widget.GridLayoutManager$PendingMoveSmoothScroller r6 = r9.mPendingMoveSmoothScroller
                if (r6 != 0) goto L_0x00b0
                r9.dispatchChildSelected()
                goto L_0x00b0
            L_0x007f:
                r3 = r1 & 4
                if (r3 != 0) goto L_0x00b0
                r3 = r1 & 16
                if (r3 != 0) goto L_0x0093
                int r3 = r9.mFocusPosition
                if (r6 != r3) goto L_0x0093
                int r3 = r9.mSubFocusPosition
                if (r7 != r3) goto L_0x0093
                r9.dispatchChildSelected()
                goto L_0x00b0
            L_0x0093:
                r1 = r1 & 16
                if (r1 == 0) goto L_0x00b0
                int r9 = r9.mFocusPosition
                if (r6 < r9) goto L_0x00b0
                boolean r9 = r0.hasFocusable()
                if (r9 == 0) goto L_0x00b0
                androidx.leanback.widget.GridLayoutManager r9 = androidx.leanback.widget.GridLayoutManager.this
                r9.mFocusPosition = r6
                r9.mSubFocusPosition = r7
                int r6 = r9.mFlag
                r6 = r6 & -17
                r9.mFlag = r6
                r9.dispatchChildSelected()
            L_0x00b0:
                androidx.leanback.widget.GridLayoutManager r6 = androidx.leanback.widget.GridLayoutManager.this
                r6.measureChild(r0)
            L_0x00b5:
                r8[r2] = r0
                androidx.leanback.widget.GridLayoutManager r6 = androidx.leanback.widget.GridLayoutManager.this
                int r7 = r6.mOrientation
                if (r7 != 0) goto L_0x00c2
                int r6 = r6.getDecoratedMeasuredWidthWithMargin(r0)
                return r6
            L_0x00c2:
                int r6 = r6.getDecoratedMeasuredHeightWithMargin(r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.AnonymousClass2.createItem(int, boolean, java.lang.Object[], boolean):int");
        }

        public int getCount() {
            return GridLayoutManager.this.mState.getItemCount() + GridLayoutManager.this.mPositionDeltaInPreLayout;
        }

        public int getEdge(int i4) {
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            View findViewByPosition = gridLayoutManager.findViewByPosition(i4 - gridLayoutManager.mPositionDeltaInPreLayout);
            GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
            if ((gridLayoutManager2.mFlag & 262144) != 0) {
                return gridLayoutManager2.getViewMax(findViewByPosition);
            }
            return gridLayoutManager2.getViewMin(findViewByPosition);
        }

        public int getMinIndex() {
            return GridLayoutManager.this.mPositionDeltaInPreLayout;
        }

        public int getSize(int i4) {
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            return gridLayoutManager.getViewPrimarySize(gridLayoutManager.findViewByPosition(i4 - gridLayoutManager.mPositionDeltaInPreLayout));
        }

        public void removeItem(int i4) {
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            View findViewByPosition = gridLayoutManager.findViewByPosition(i4 - gridLayoutManager.mPositionDeltaInPreLayout);
            GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
            if ((gridLayoutManager2.mFlag & 3) == 1) {
                gridLayoutManager2.detachAndScrapView(findViewByPosition, gridLayoutManager2.mRecycler);
            } else {
                gridLayoutManager2.removeAndRecycleView(findViewByPosition, gridLayoutManager2.mRecycler);
            }
        }
    };
    private int mHorizontalSpacing;
    private final ItemAlignment mItemAlignment = new ItemAlignment();
    @VisibleForTesting
    OnLayoutCompleteListener mLayoutCompleteListener;
    int mMaxPendingMoves = 10;
    private int mMaxSizeSecondary;
    private int[] mMeasuredDimension = new int[2];
    int mNumRows;
    private int mNumRowsRequested = 1;
    int mOrientation = 0;
    private OrientationHelper mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
    PendingMoveSmoothScroller mPendingMoveSmoothScroller;
    int mPositionDeltaInPreLayout;
    final SparseIntArray mPositionToRowInPostLayout = new SparseIntArray();
    private int mPrimaryScrollExtra;
    RecyclerView.Recycler mRecycler;
    private final Runnable mRequestLayoutRunnable = new Runnable() {
        public void run() {
            GridLayoutManager.this.requestLayout();
        }
    };
    private int[] mRowSizeSecondary;
    private int mRowSizeSecondaryRequested;
    int mScrollOffsetSecondary;
    private int mSizePrimary;
    private int mSpacingPrimary;
    private int mSpacingSecondary;
    RecyclerView.State mState;
    int mSubFocusPosition = 0;
    private int mVerticalSpacing;
    final WindowAlignment mWindowAlignment = new WindowAlignment();

    abstract class GridLinearSmoothScroller extends LinearSmoothScroller {
        boolean mSkipOnStopInternal;

        GridLinearSmoothScroller() {
            super(GridLayoutManager.this.mBaseGridView.getContext());
        }

        /* access modifiers changed from: protected */
        public int calculateTimeForScrolling(int i4) {
            int calculateTimeForScrolling = super.calculateTimeForScrolling(i4);
            if (GridLayoutManager.this.mWindowAlignment.mainAxis().getSize() > 0) {
                float size = (30.0f / ((float) GridLayoutManager.this.mWindowAlignment.mainAxis().getSize())) * ((float) i4);
                if (((float) calculateTimeForScrolling) < size) {
                    return (int) size;
                }
            }
            return calculateTimeForScrolling;
        }

        /* access modifiers changed from: protected */
        public void onStop() {
            super.onStop();
            if (!this.mSkipOnStopInternal) {
                onStopInternal();
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            if (gridLayoutManager.mCurrentSmoothScroller == this) {
                gridLayoutManager.mCurrentSmoothScroller = null;
            }
            if (gridLayoutManager.mPendingMoveSmoothScroller == this) {
                gridLayoutManager.mPendingMoveSmoothScroller = null;
            }
        }

        /* access modifiers changed from: protected */
        public void onStopInternal() {
            View findViewByPosition = findViewByPosition(getTargetPosition());
            if (findViewByPosition != null) {
                if (GridLayoutManager.this.mFocusPosition != getTargetPosition()) {
                    GridLayoutManager.this.mFocusPosition = getTargetPosition();
                }
                if (GridLayoutManager.this.hasFocus()) {
                    GridLayoutManager.this.mFlag |= 32;
                    findViewByPosition.requestFocus();
                    GridLayoutManager.this.mFlag &= -33;
                }
                GridLayoutManager.this.dispatchChildSelected();
                GridLayoutManager.this.dispatchChildSelectedAndPositioned();
            } else if (getTargetPosition() >= 0) {
                GridLayoutManager.this.scrollToSelection(getTargetPosition(), 0, false, 0);
            }
        }

        /* access modifiers changed from: protected */
        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int i4;
            int i5;
            if (GridLayoutManager.this.getScrollPosition(view, (View) null, GridLayoutManager.sTwoInts)) {
                if (GridLayoutManager.this.mOrientation == 0) {
                    int[] iArr = GridLayoutManager.sTwoInts;
                    i5 = iArr[0];
                    i4 = iArr[1];
                } else {
                    int[] iArr2 = GridLayoutManager.sTwoInts;
                    int i6 = iArr2[1];
                    i4 = iArr2[0];
                    i5 = i6;
                }
                action.update(i5, i4, calculateTimeForDeceleration((int) Math.sqrt((double) ((i5 * i5) + (i4 * i4)))), this.mDecelerateInterpolator);
            }
        }
    }

    static final class LayoutParams extends RecyclerView.LayoutParams {
        private int[] mAlignMultiple;
        private int mAlignX;
        private int mAlignY;
        private ItemAlignmentFacet mAlignmentFacet;
        int mBottomInset;
        int mLeftInset;
        int mRightInset;
        int mTopInset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: package-private */
        public void calculateItemAlignments(int i4, View view) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = this.mAlignmentFacet.getAlignmentDefs();
            int[] iArr = this.mAlignMultiple;
            if (iArr == null || iArr.length != alignmentDefs.length) {
                this.mAlignMultiple = new int[alignmentDefs.length];
            }
            for (int i5 = 0; i5 < alignmentDefs.length; i5++) {
                this.mAlignMultiple[i5] = ItemAlignmentFacetHelper.getAlignmentPosition(view, alignmentDefs[i5], i4);
            }
            if (i4 == 0) {
                this.mAlignX = this.mAlignMultiple[0];
            } else {
                this.mAlignY = this.mAlignMultiple[0];
            }
        }

        /* access modifiers changed from: package-private */
        public int[] getAlignMultiple() {
            return this.mAlignMultiple;
        }

        /* access modifiers changed from: package-private */
        public int getAlignX() {
            return this.mAlignX;
        }

        /* access modifiers changed from: package-private */
        public int getAlignY() {
            return this.mAlignY;
        }

        /* access modifiers changed from: package-private */
        public ItemAlignmentFacet getItemAlignmentFacet() {
            return this.mAlignmentFacet;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalBottom(View view) {
            return view.getBottom() - this.mBottomInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalBottomInset() {
            return this.mBottomInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalHeight(View view) {
            return (view.getHeight() - this.mTopInset) - this.mBottomInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalLeft(View view) {
            return view.getLeft() + this.mLeftInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalLeftInset() {
            return this.mLeftInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalRight(View view) {
            return view.getRight() - this.mRightInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalRightInset() {
            return this.mRightInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalTop(View view) {
            return view.getTop() + this.mTopInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalTopInset() {
            return this.mTopInset;
        }

        /* access modifiers changed from: package-private */
        public int getOpticalWidth(View view) {
            return (view.getWidth() - this.mLeftInset) - this.mRightInset;
        }

        /* access modifiers changed from: package-private */
        public void setAlignX(int i4) {
            this.mAlignX = i4;
        }

        /* access modifiers changed from: package-private */
        public void setAlignY(int i4) {
            this.mAlignY = i4;
        }

        /* access modifiers changed from: package-private */
        public void setItemAlignmentFacet(ItemAlignmentFacet itemAlignmentFacet) {
            this.mAlignmentFacet = itemAlignmentFacet;
        }

        /* access modifiers changed from: package-private */
        public void setOpticalInsets(int i4, int i5, int i6, int i7) {
            this.mLeftInset = i4;
            this.mTopInset = i5;
            this.mRightInset = i6;
            this.mBottomInset = i7;
        }

        public LayoutParams(int i4, int i5) {
            super(i4, i5);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
        }
    }

    @VisibleForTesting
    public static class OnLayoutCompleteListener {
        public void onLayoutCompleted(RecyclerView.State state) {
        }
    }

    final class PendingMoveSmoothScroller extends GridLinearSmoothScroller {
        static final int TARGET_UNDEFINED = -2;
        private int mPendingMoves;
        private final boolean mStaggeredGrid;

        PendingMoveSmoothScroller(int i4, boolean z4) {
            super();
            this.mPendingMoves = i4;
            this.mStaggeredGrid = z4;
            setTargetPosition(-2);
        }

        public PointF computeScrollVectorForPosition(int i4) {
            int i5;
            int i6 = this.mPendingMoves;
            if (i6 == 0) {
                return null;
            }
            GridLayoutManager gridLayoutManager = GridLayoutManager.this;
            if ((gridLayoutManager.mFlag & 262144) == 0 ? i6 >= 0 : i6 <= 0) {
                i5 = 1;
            } else {
                i5 = -1;
            }
            if (gridLayoutManager.mOrientation == 0) {
                return new PointF((float) i5, 0.0f);
            }
            return new PointF(0.0f, (float) i5);
        }

        /* access modifiers changed from: package-private */
        public void consumePendingMovesAfterLayout() {
            int i4;
            if (this.mStaggeredGrid && (i4 = this.mPendingMoves) != 0) {
                this.mPendingMoves = GridLayoutManager.this.processSelectionMoves(true, i4);
            }
            int i5 = this.mPendingMoves;
            if (i5 == 0 || ((i5 > 0 && GridLayoutManager.this.hasCreatedLastItem()) || (this.mPendingMoves < 0 && GridLayoutManager.this.hasCreatedFirstItem()))) {
                setTargetPosition(GridLayoutManager.this.mFocusPosition);
                stop();
            }
        }

        /* access modifiers changed from: package-private */
        public void consumePendingMovesBeforeLayout() {
            int i4;
            int i5;
            View findViewByPosition;
            int i6;
            if (!this.mStaggeredGrid && (i4 = this.mPendingMoves) != 0) {
                if (i4 > 0) {
                    GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                    i5 = gridLayoutManager.mFocusPosition + gridLayoutManager.mNumRows;
                } else {
                    GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                    i5 = gridLayoutManager2.mFocusPosition - gridLayoutManager2.mNumRows;
                }
                View view = null;
                while (this.mPendingMoves != 0 && (findViewByPosition = findViewByPosition(i5)) != null) {
                    if (GridLayoutManager.this.canScrollTo(findViewByPosition)) {
                        GridLayoutManager gridLayoutManager3 = GridLayoutManager.this;
                        gridLayoutManager3.mFocusPosition = i5;
                        gridLayoutManager3.mSubFocusPosition = 0;
                        int i7 = this.mPendingMoves;
                        if (i7 > 0) {
                            this.mPendingMoves = i7 - 1;
                        } else {
                            this.mPendingMoves = i7 + 1;
                        }
                        view = findViewByPosition;
                    }
                    if (this.mPendingMoves > 0) {
                        i6 = i5 + GridLayoutManager.this.mNumRows;
                    } else {
                        i6 = i5 - GridLayoutManager.this.mNumRows;
                    }
                }
                if (view != null && GridLayoutManager.this.hasFocus()) {
                    GridLayoutManager.this.mFlag |= 32;
                    view.requestFocus();
                    GridLayoutManager.this.mFlag &= -33;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void decreasePendingMoves() {
            int i4 = this.mPendingMoves;
            if (i4 > (-GridLayoutManager.this.mMaxPendingMoves)) {
                this.mPendingMoves = i4 - 1;
            }
        }

        /* access modifiers changed from: package-private */
        public void increasePendingMoves() {
            int i4 = this.mPendingMoves;
            if (i4 < GridLayoutManager.this.mMaxPendingMoves) {
                this.mPendingMoves = i4 + 1;
            }
        }

        /* access modifiers changed from: protected */
        public void onStopInternal() {
            super.onStopInternal();
            this.mPendingMoves = 0;
            View findViewByPosition = findViewByPosition(getTargetPosition());
            if (findViewByPosition != null) {
                GridLayoutManager.this.scrollToView(findViewByPosition, true);
            }
        }

        /* access modifiers changed from: protected */
        public void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action action) {
            if (this.mPendingMoves != 0) {
                super.updateActionForInterimTarget(action);
            }
        }
    }

    public GridLayoutManager(BaseGridView baseGridView) {
        this.mBaseGridView = baseGridView;
        this.mChildVisibility = -1;
        setItemPrefetchEnabled(false);
    }

    private boolean appendOneColumnVisibleItems() {
        return this.mGrid.appendOneColumnVisibleItems();
    }

    private void appendVisibleItems() {
        int i4;
        Grid grid = this.mGrid;
        if ((this.mFlag & 262144) != 0) {
            i4 = (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout;
        } else {
            i4 = this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout;
        }
        grid.appendVisibleItems(i4);
    }

    private void discardLayoutInfo() {
        this.mGrid = null;
        this.mRowSizeSecondary = null;
        this.mFlag &= -1025;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001d, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bb A[LOOP:3: B:28:0x00bb->B:31:0x00c9, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fastRelayout() {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            androidx.leanback.widget.Grid r1 = r13.mGrid
            int r1 = r1.getFirstVisibleIndex()
            int r2 = r13.mFlag
            r2 = r2 & -9
            r13.mFlag = r2
            r2 = 0
        L_0x0011:
            if (r2 >= r0) goto L_0x00d2
            android.view.View r3 = r13.getChildAt(r2)
            int r4 = r13.getAdapterPositionByView(r3)
            if (r1 == r4) goto L_0x001f
        L_0x001d:
            r7 = r13
            goto L_0x0080
        L_0x001f:
            androidx.leanback.widget.Grid r4 = r13.mGrid
            androidx.leanback.widget.Grid$Location r4 = r4.getLocation(r1)
            if (r4 != 0) goto L_0x0028
            goto L_0x001d
        L_0x0028:
            int r5 = r4.row
            int r5 = r13.getRowStartSecondary(r5)
            androidx.leanback.widget.WindowAlignment r6 = r13.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r6 = r6.secondAxis()
            int r6 = r6.getPaddingMin()
            int r5 = r5 + r6
            int r6 = r13.mScrollOffsetSecondary
            int r12 = r5 - r6
            int r10 = r13.getViewMin(r3)
            int r5 = r13.getViewPrimarySize(r3)
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.leanback.widget.GridLayoutManager$LayoutParams r6 = (androidx.leanback.widget.GridLayoutManager.LayoutParams) r6
            boolean r6 = r6.viewNeedsUpdate()
            if (r6 == 0) goto L_0x0063
            int r6 = r13.mFlag
            r6 = r6 | 8
            r13.mFlag = r6
            androidx.recyclerview.widget.RecyclerView$Recycler r6 = r13.mRecycler
            r13.detachAndScrapView(r3, r6)
            android.view.View r3 = r13.getViewForPosition(r1)
            r13.addView(r3, r2)
        L_0x0063:
            r9 = r3
            r13.measureChild(r9)
            int r3 = r13.mOrientation
            if (r3 != 0) goto L_0x0073
            int r3 = r13.getDecoratedMeasuredWidthWithMargin(r9)
        L_0x006f:
            int r6 = r10 + r3
            r11 = r6
            goto L_0x0078
        L_0x0073:
            int r3 = r13.getDecoratedMeasuredHeightWithMargin(r9)
            goto L_0x006f
        L_0x0078:
            int r8 = r4.row
            r7 = r13
            r7.layoutChild(r8, r9, r10, r11, r12)
            if (r5 == r3) goto L_0x00cc
        L_0x0080:
            androidx.leanback.widget.Grid r3 = r7.mGrid
            int r3 = r3.getLastVisibleIndex()
            int r0 = r0 + -1
        L_0x0088:
            if (r0 < r2) goto L_0x0096
            android.view.View r4 = r13.getChildAt(r0)
            androidx.recyclerview.widget.RecyclerView$Recycler r5 = r7.mRecycler
            r13.detachAndScrapView(r4, r5)
            int r0 = r0 + -1
            goto L_0x0088
        L_0x0096:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            r0.invalidateItemsAfter(r1)
            int r0 = r7.mFlag
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00bb
            r13.appendVisibleItems()
            int r0 = r7.mFocusPosition
            if (r0 < 0) goto L_0x00d3
            if (r0 > r3) goto L_0x00d3
        L_0x00ab:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            int r0 = r0.getLastVisibleIndex()
            int r1 = r7.mFocusPosition
            if (r0 >= r1) goto L_0x00d3
            androidx.leanback.widget.Grid r0 = r7.mGrid
            r0.appendOneColumnVisibleItems()
            goto L_0x00ab
        L_0x00bb:
            androidx.leanback.widget.Grid r0 = r7.mGrid
            boolean r0 = r0.appendOneColumnVisibleItems()
            if (r0 == 0) goto L_0x00d3
            androidx.leanback.widget.Grid r0 = r7.mGrid
            int r0 = r0.getLastVisibleIndex()
            if (r0 >= r3) goto L_0x00d3
            goto L_0x00bb
        L_0x00cc:
            int r2 = r2 + 1
            int r1 = r1 + 1
            goto L_0x0011
        L_0x00d2:
            r7 = r13
        L_0x00d3:
            r13.updateScrollLimits()
            r13.updateSecondaryScrollLimits()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.fastRelayout():void");
    }

    private int findImmediateChildIndex(View view) {
        View findContainingItemView;
        BaseGridView baseGridView = this.mBaseGridView;
        if (baseGridView == null || view == baseGridView || (findContainingItemView = findContainingItemView(view)) == null) {
            return -1;
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (getChildAt(i4) == findContainingItemView) {
                return i4;
            }
        }
        return -1;
    }

    private void focusToViewInLayout(boolean z4, boolean z5, int i4, int i5) {
        View findViewByPosition = findViewByPosition(this.mFocusPosition);
        if (findViewByPosition != null && z5) {
            scrollToView(findViewByPosition, false, i4, i5);
        }
        if (findViewByPosition != null && z4 && !findViewByPosition.hasFocus()) {
            findViewByPosition.requestFocus();
        } else if (!z4 && !this.mBaseGridView.hasFocus()) {
            if (findViewByPosition == null || !findViewByPosition.hasFocusable()) {
                int childCount = getChildCount();
                int i6 = 0;
                while (true) {
                    if (i6 < childCount) {
                        findViewByPosition = getChildAt(i6);
                        if (findViewByPosition != null && findViewByPosition.hasFocusable()) {
                            this.mBaseGridView.focusableViewAvailable(findViewByPosition);
                            break;
                        }
                        i6++;
                    } else {
                        break;
                    }
                }
            } else {
                this.mBaseGridView.focusableViewAvailable(findViewByPosition);
            }
            if (z5 && findViewByPosition != null && findViewByPosition.hasFocus()) {
                scrollToView(findViewByPosition, false, i4, i5);
            }
        }
    }

    private void forceRequestLayout() {
        ViewCompat.postOnAnimation(this.mBaseGridView, this.mRequestLayoutRunnable);
    }

    private int getAdapterPositionByIndex(int i4) {
        return getAdapterPositionByView(getChildAt(i4));
    }

    private int getAdapterPositionByView(View view) {
        LayoutParams layoutParams;
        if (view == null || (layoutParams = (LayoutParams) view.getLayoutParams()) == null || layoutParams.isItemRemoved()) {
            return -1;
        }
        return layoutParams.getViewAdapterPosition();
    }

    private int getAdjustedPrimaryAlignedScrollDistance(int i4, View view, View view2) {
        int subPositionByView = getSubPositionByView(view, view2);
        if (subPositionByView == 0) {
            return i4;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return i4 + (layoutParams.getAlignMultiple()[subPositionByView] - layoutParams.getAlignMultiple()[0]);
    }

    private int getAdjustedViewCenter(View view) {
        View findFocus;
        if (!view.hasFocus() || (findFocus = view.findFocus()) == null || findFocus == view) {
            return getViewCenter(view);
        }
        return getAdjustedPrimaryAlignedScrollDistance(getViewCenter(view), view, findFocus);
    }

    private boolean getAlignedPosition(View view, View view2, int[] iArr) {
        int primaryAlignedScrollDistance = getPrimaryAlignedScrollDistance(view);
        if (view2 != null) {
            primaryAlignedScrollDistance = getAdjustedPrimaryAlignedScrollDistance(primaryAlignedScrollDistance, view, view2);
        }
        int secondaryScrollDistance = getSecondaryScrollDistance(view);
        int i4 = primaryAlignedScrollDistance + this.mPrimaryScrollExtra;
        if (i4 == 0 && secondaryScrollDistance == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
        iArr[0] = i4;
        iArr[1] = secondaryScrollDistance;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0048 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getMovement(int r10) {
        /*
            r9 = this;
            int r0 = r9.mOrientation
            r1 = 130(0x82, float:1.82E-43)
            r2 = 66
            r3 = 33
            r4 = 2
            r5 = 0
            r6 = 3
            r7 = 1
            r8 = 17
            if (r0 != 0) goto L_0x002b
            r0 = 262144(0x40000, float:3.67342E-40)
            if (r10 == r8) goto L_0x0024
            if (r10 == r3) goto L_0x0023
            if (r10 == r2) goto L_0x001c
            if (r10 == r1) goto L_0x001b
            goto L_0x0048
        L_0x001b:
            return r6
        L_0x001c:
            int r10 = r9.mFlag
            r10 = r10 & r0
            if (r10 != 0) goto L_0x0022
            return r7
        L_0x0022:
            return r5
        L_0x0023:
            return r4
        L_0x0024:
            int r10 = r9.mFlag
            r10 = r10 & r0
            if (r10 != 0) goto L_0x002a
            return r5
        L_0x002a:
            return r7
        L_0x002b:
            if (r0 != r7) goto L_0x0048
            r0 = 524288(0x80000, float:7.34684E-40)
            if (r10 == r8) goto L_0x0041
            if (r10 == r3) goto L_0x0040
            if (r10 == r2) goto L_0x0039
            if (r10 == r1) goto L_0x0038
            goto L_0x0048
        L_0x0038:
            return r7
        L_0x0039:
            int r10 = r9.mFlag
            r10 = r10 & r0
            if (r10 != 0) goto L_0x003f
            return r6
        L_0x003f:
            return r4
        L_0x0040:
            return r5
        L_0x0041:
            int r10 = r9.mFlag
            r10 = r10 & r0
            if (r10 != 0) goto L_0x0047
            return r4
        L_0x0047:
            return r6
        L_0x0048:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.getMovement(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009f, code lost:
        if (r2 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean getNoneAlignedPosition(android.view.View r13, int[] r14) {
        /*
            r12 = this;
            int r0 = r12.getAdapterPositionByView(r13)
            int r1 = r12.getViewMin(r13)
            int r2 = r12.getViewMax(r13)
            androidx.leanback.widget.WindowAlignment r3 = r12.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r3 = r3.mainAxis()
            int r3 = r3.getPaddingMin()
            androidx.leanback.widget.WindowAlignment r4 = r12.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r4 = r4.mainAxis()
            int r4 = r4.getClientSize()
            androidx.leanback.widget.Grid r5 = r12.mGrid
            int r5 = r5.getRowIndex(r0)
            r6 = 1
            r7 = 0
            r8 = 2
            r9 = 0
            if (r1 >= r3) goto L_0x006f
            int r1 = r12.mFocusScrollStrategy
            if (r1 != r8) goto L_0x006c
            r1 = r13
        L_0x0031:
            boolean r10 = r12.prependOneColumnVisibleItems()
            if (r10 == 0) goto L_0x0069
            androidx.leanback.widget.Grid r1 = r12.mGrid
            int r10 = r1.getFirstVisibleIndex()
            androidx.collection.CircularIntArray[] r1 = r1.getItemPositionsInRows(r10, r0)
            r1 = r1[r5]
            int r10 = r1.get(r7)
            android.view.View r10 = r12.findViewByPosition(r10)
            int r11 = r12.getViewMin(r10)
            int r11 = r2 - r11
            if (r11 <= r4) goto L_0x0067
            int r0 = r1.size()
            if (r0 <= r8) goto L_0x0064
            int r0 = r1.get(r8)
            android.view.View r0 = r12.findViewByPosition(r0)
            r2 = r9
            r9 = r0
            goto L_0x00a5
        L_0x0064:
            r2 = r9
            r9 = r10
            goto L_0x00a5
        L_0x0067:
            r1 = r10
            goto L_0x0031
        L_0x0069:
            r2 = r9
            r9 = r1
            goto L_0x00a5
        L_0x006c:
            r2 = r9
        L_0x006d:
            r9 = r13
            goto L_0x00a5
        L_0x006f:
            int r10 = r4 + r3
            if (r2 <= r10) goto L_0x00a4
            int r2 = r12.mFocusScrollStrategy
            if (r2 != r8) goto L_0x00a2
        L_0x0077:
            androidx.leanback.widget.Grid r2 = r12.mGrid
            int r8 = r2.getLastVisibleIndex()
            androidx.collection.CircularIntArray[] r2 = r2.getItemPositionsInRows(r0, r8)
            r2 = r2[r5]
            int r8 = r2.size()
            int r8 = r8 - r6
            int r2 = r2.get(r8)
            android.view.View r2 = r12.findViewByPosition(r2)
            int r8 = r12.getViewMax(r2)
            int r8 = r8 - r1
            if (r8 <= r4) goto L_0x0099
            r2 = r9
            goto L_0x009f
        L_0x0099:
            boolean r8 = r12.appendOneColumnVisibleItems()
            if (r8 != 0) goto L_0x0077
        L_0x009f:
            if (r2 == 0) goto L_0x006d
            goto L_0x00a5
        L_0x00a2:
            r2 = r13
            goto L_0x00a5
        L_0x00a4:
            r2 = r9
        L_0x00a5:
            if (r9 == 0) goto L_0x00ad
            int r0 = r12.getViewMin(r9)
        L_0x00ab:
            int r0 = r0 - r3
            goto L_0x00b6
        L_0x00ad:
            if (r2 == 0) goto L_0x00b5
            int r0 = r12.getViewMax(r2)
            int r3 = r3 + r4
            goto L_0x00ab
        L_0x00b5:
            r0 = 0
        L_0x00b6:
            if (r9 == 0) goto L_0x00ba
            r13 = r9
            goto L_0x00bd
        L_0x00ba:
            if (r2 == 0) goto L_0x00bd
            r13 = r2
        L_0x00bd:
            int r13 = r12.getSecondaryScrollDistance(r13)
            if (r0 != 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            return r7
        L_0x00c7:
            r14[r7] = r0
            r14[r6] = r13
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.getNoneAlignedPosition(android.view.View, int[]):boolean");
    }

    private int getPrimaryAlignedScrollDistance(View view) {
        return this.mWindowAlignment.mainAxis().getScroll(getViewCenter(view));
    }

    private int getRowSizeSecondary(int i4) {
        int i5 = this.mFixedRowSizeSecondary;
        if (i5 != 0) {
            return i5;
        }
        int[] iArr = this.mRowSizeSecondary;
        if (iArr == null) {
            return 0;
        }
        return iArr[i4];
    }

    private int getSecondaryScrollDistance(View view) {
        return this.mWindowAlignment.secondAxis().getScroll(getViewCenterSecondary(view));
    }

    private int getSizeSecondary() {
        int i4;
        if ((this.mFlag & 524288) != 0) {
            i4 = 0;
        } else {
            i4 = this.mNumRows - 1;
        }
        return getRowStartSecondary(i4) + getRowSizeSecondary(i4);
    }

    private int getViewCenter(View view) {
        if (this.mOrientation == 0) {
            return getViewCenterX(view);
        }
        return getViewCenterY(view);
    }

    private int getViewCenterSecondary(View view) {
        if (this.mOrientation == 0) {
            return getViewCenterY(view);
        }
        return getViewCenterX(view);
    }

    private int getViewCenterX(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalLeft(view) + layoutParams.getAlignX();
    }

    private int getViewCenterY(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return layoutParams.getOpticalTop(view) + layoutParams.getAlignY();
    }

    private boolean gridOnRequestFocusInDescendantsAligned(RecyclerView recyclerView, int i4, Rect rect) {
        View findViewByPosition = findViewByPosition(this.mFocusPosition);
        if (findViewByPosition != null) {
            return findViewByPosition.requestFocus(i4, rect);
        }
        return false;
    }

    private boolean gridOnRequestFocusInDescendantsUnaligned(RecyclerView recyclerView, int i4, Rect rect) {
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        if ((i4 & 2) != 0) {
            i7 = childCount;
            i5 = 0;
            i6 = 1;
        } else {
            i5 = childCount - 1;
            i7 = -1;
            i6 = -1;
        }
        int paddingMin = this.mWindowAlignment.mainAxis().getPaddingMin();
        int clientSize = this.mWindowAlignment.mainAxis().getClientSize() + paddingMin;
        while (i5 != i7) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && getViewMin(childAt) >= paddingMin && getViewMax(childAt) <= clientSize && childAt.requestFocus(i4, rect)) {
                return true;
            }
            i5 += i6;
        }
        return false;
    }

    private void initScrollController() {
        this.mWindowAlignment.reset();
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
        this.mScrollOffsetSecondary = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
        if (r0 != r5.mGrid.isReversedFlow()) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean layoutInit() {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$State r0 = r5.mState
            int r0 = r0.getItemCount()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0010
            r5.mFocusPosition = r1
            r5.mSubFocusPosition = r3
            goto L_0x0022
        L_0x0010:
            int r4 = r5.mFocusPosition
            if (r4 < r0) goto L_0x001a
            int r0 = r0 - r2
            r5.mFocusPosition = r0
            r5.mSubFocusPosition = r3
            goto L_0x0022
        L_0x001a:
            if (r4 != r1) goto L_0x0022
            if (r0 <= 0) goto L_0x0022
            r5.mFocusPosition = r3
            r5.mSubFocusPosition = r3
        L_0x0022:
            androidx.recyclerview.widget.RecyclerView$State r0 = r5.mState
            boolean r0 = r0.didStructureChange()
            if (r0 != 0) goto L_0x0052
            androidx.leanback.widget.Grid r0 = r5.mGrid
            if (r0 == 0) goto L_0x0052
            int r0 = r0.getFirstVisibleIndex()
            if (r0 < 0) goto L_0x0052
            int r0 = r5.mFlag
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x0052
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r0 = r0.getNumRows()
            int r1 = r5.mNumRows
            if (r0 != r1) goto L_0x0052
            r5.updateScrollController()
            r5.updateSecondaryScrollLimits()
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r1 = r5.mSpacingPrimary
            r0.setSpacing(r1)
            return r2
        L_0x0052:
            int r0 = r5.mFlag
            r0 = r0 & -257(0xfffffffffffffeff, float:NaN)
            r5.mFlag = r0
            androidx.leanback.widget.Grid r0 = r5.mGrid
            r1 = 262144(0x40000, float:3.67342E-40)
            if (r0 == 0) goto L_0x0076
            int r4 = r5.mNumRows
            int r0 = r0.getNumRows()
            if (r4 != r0) goto L_0x0076
            int r0 = r5.mFlag
            r0 = r0 & r1
            if (r0 == 0) goto L_0x006d
            r0 = 1
            goto L_0x006e
        L_0x006d:
            r0 = 0
        L_0x006e:
            androidx.leanback.widget.Grid r4 = r5.mGrid
            boolean r4 = r4.isReversedFlow()
            if (r0 == r4) goto L_0x008f
        L_0x0076:
            int r0 = r5.mNumRows
            androidx.leanback.widget.Grid r0 = androidx.leanback.widget.Grid.createGrid(r0)
            r5.mGrid = r0
            androidx.leanback.widget.Grid$Provider r4 = r5.mGridProvider
            r0.setProvider(r4)
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r4 = r5.mFlag
            r1 = r1 & r4
            if (r1 == 0) goto L_0x008b
            goto L_0x008c
        L_0x008b:
            r2 = 0
        L_0x008c:
            r0.setReversedFlow(r2)
        L_0x008f:
            r5.initScrollController()
            r5.updateSecondaryScrollLimits()
            androidx.leanback.widget.Grid r0 = r5.mGrid
            int r1 = r5.mSpacingPrimary
            r0.setSpacing(r1)
            androidx.recyclerview.widget.RecyclerView$Recycler r0 = r5.mRecycler
            r5.detachAndScrapAttachedViews(r0)
            androidx.leanback.widget.Grid r0 = r5.mGrid
            r0.resetVisibleIndex()
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.mainAxis()
            r0.invalidateScrollMin()
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.mainAxis()
            r0.invalidateScrollMax()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.layoutInit():boolean");
    }

    private void leaveContext() {
        this.mRecycler = null;
        this.mState = null;
        this.mPositionDeltaInPreLayout = 0;
        this.mExtraLayoutSpaceInPreLayout = 0;
    }

    private void measureScrapChild(int i4, int i5, int i6, int[] iArr) {
        View viewForPosition = this.mRecycler.getViewForPosition(i4);
        if (viewForPosition != null) {
            LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
            Rect rect = sTempRect;
            calculateItemDecorationsForChild(viewForPosition, rect);
            viewForPosition.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + rect.left + rect.right, layoutParams.width), ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top + rect.bottom, layoutParams.height));
            iArr[0] = getDecoratedMeasuredWidthWithMargin(viewForPosition);
            iArr[1] = getDecoratedMeasuredHeightWithMargin(viewForPosition);
            this.mRecycler.recycleView(viewForPosition);
        }
    }

    private void offsetChildrenPrimary(int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        if (this.mOrientation == 1) {
            while (i5 < childCount) {
                getChildAt(i5).offsetTopAndBottom(i4);
                i5++;
            }
            return;
        }
        while (i5 < childCount) {
            getChildAt(i5).offsetLeftAndRight(i4);
            i5++;
        }
    }

    private void offsetChildrenSecondary(int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        if (this.mOrientation == 0) {
            while (i5 < childCount) {
                getChildAt(i5).offsetTopAndBottom(i4);
                i5++;
            }
            return;
        }
        while (i5 < childCount) {
            getChildAt(i5).offsetLeftAndRight(i4);
            i5++;
        }
    }

    private boolean prependOneColumnVisibleItems() {
        return this.mGrid.prependOneColumnVisibleItems();
    }

    private void prependVisibleItems() {
        int i4;
        Grid grid = this.mGrid;
        if ((this.mFlag & 262144) != 0) {
            i4 = this.mSizePrimary + this.mExtraLayoutSpace + this.mExtraLayoutSpaceInPreLayout;
        } else {
            i4 = (-this.mExtraLayoutSpace) - this.mExtraLayoutSpaceInPreLayout;
        }
        grid.prependVisibleItems(i4);
    }

    private void processPendingMovement(boolean z4) {
        int i4;
        if (z4) {
            if (hasCreatedLastItem()) {
                return;
            }
        } else if (hasCreatedFirstItem()) {
            return;
        }
        PendingMoveSmoothScroller pendingMoveSmoothScroller = this.mPendingMoveSmoothScroller;
        if (pendingMoveSmoothScroller == null) {
            this.mBaseGridView.stopScroll();
            boolean z5 = true;
            if (z4) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            if (this.mNumRows <= 1) {
                z5 = false;
            }
            PendingMoveSmoothScroller pendingMoveSmoothScroller2 = new PendingMoveSmoothScroller(i4, z5);
            this.mFocusPositionOffset = 0;
            startSmoothScroll(pendingMoveSmoothScroller2);
        } else if (z4) {
            pendingMoveSmoothScroller.increasePendingMoves();
        } else {
            pendingMoveSmoothScroller.decreasePendingMoves();
        }
    }

    private boolean processRowSizeSecondary(boolean z4) {
        CircularIntArray[] circularIntArrayArr;
        CircularIntArray circularIntArray;
        int i4;
        int i5;
        int i6;
        if (this.mFixedRowSizeSecondary != 0 || this.mRowSizeSecondary == null) {
            return false;
        }
        Grid grid = this.mGrid;
        if (grid == null) {
            circularIntArrayArr = null;
        } else {
            circularIntArrayArr = grid.getItemPositionsInRows();
        }
        boolean z5 = false;
        int i7 = -1;
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            if (circularIntArrayArr == null) {
                circularIntArray = null;
            } else {
                circularIntArray = circularIntArrayArr[i8];
            }
            if (circularIntArray == null) {
                i4 = 0;
            } else {
                i4 = circularIntArray.size();
            }
            int i9 = -1;
            for (int i10 = 0; i10 < i4; i10 += 2) {
                int i11 = circularIntArray.get(i10 + 1);
                for (int i12 = circularIntArray.get(i10); i12 <= i11; i12++) {
                    View findViewByPosition = findViewByPosition(i12 - this.mPositionDeltaInPreLayout);
                    if (findViewByPosition != null) {
                        if (z4) {
                            measureChild(findViewByPosition);
                        }
                        if (this.mOrientation == 0) {
                            i6 = getDecoratedMeasuredHeightWithMargin(findViewByPosition);
                        } else {
                            i6 = getDecoratedMeasuredWidthWithMargin(findViewByPosition);
                        }
                        if (i6 > i9) {
                            i9 = i6;
                        }
                    }
                }
            }
            int itemCount = this.mState.getItemCount();
            if (!this.mBaseGridView.hasFixedSize() && z4 && i9 < 0 && itemCount > 0) {
                if (i7 < 0) {
                    int i13 = this.mFocusPosition;
                    if (i13 < 0) {
                        i13 = 0;
                    } else if (i13 >= itemCount) {
                        i13 = itemCount - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = this.mBaseGridView.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = this.mBaseGridView.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i5 >= layoutPosition && i5 <= layoutPosition2) {
                            if (i5 - layoutPosition <= layoutPosition2 - i5) {
                                i5 = layoutPosition - 1;
                            } else {
                                i5 = layoutPosition2 + 1;
                            }
                            if (i5 < 0 && layoutPosition2 < itemCount - 1) {
                                i5 = layoutPosition2 + 1;
                            } else if (i5 >= itemCount && layoutPosition > 0) {
                                i5 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i5 >= 0 && i5 < itemCount) {
                        measureScrapChild(i5, View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0), this.mMeasuredDimension);
                        if (this.mOrientation == 0) {
                            i7 = this.mMeasuredDimension[1];
                        } else {
                            i7 = this.mMeasuredDimension[0];
                        }
                    }
                }
                if (i7 >= 0) {
                    i9 = i7;
                }
            }
            if (i9 < 0) {
                i9 = 0;
            }
            int[] iArr = this.mRowSizeSecondary;
            if (iArr[i8] != i9) {
                iArr[i8] = i9;
                z5 = true;
            }
        }
        return z5;
    }

    private void removeInvisibleViewsAtEnd() {
        int i4;
        int i5 = this.mFlag;
        if ((65600 & i5) == 65536) {
            Grid grid = this.mGrid;
            int i6 = this.mFocusPosition;
            if ((i5 & 262144) != 0) {
                i4 = -this.mExtraLayoutSpace;
            } else {
                i4 = this.mSizePrimary + this.mExtraLayoutSpace;
            }
            grid.removeInvisibleItemsAtEnd(i6, i4);
        }
    }

    private void removeInvisibleViewsAtFront() {
        int i4;
        int i5 = this.mFlag;
        if ((65600 & i5) == 65536) {
            Grid grid = this.mGrid;
            int i6 = this.mFocusPosition;
            if ((i5 & 262144) != 0) {
                i4 = this.mSizePrimary + this.mExtraLayoutSpace;
            } else {
                i4 = -this.mExtraLayoutSpace;
            }
            grid.removeInvisibleItemsAtFront(i6, i4);
        }
    }

    private void saveContext(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!(this.mRecycler == null && this.mState == null)) {
            Log.e(TAG, "Recycler information was not released, bug!");
        }
        this.mRecycler = recycler;
        this.mState = state;
        this.mPositionDeltaInPreLayout = 0;
        this.mExtraLayoutSpaceInPreLayout = 0;
    }

    private int scrollDirectionPrimary(int i4) {
        boolean z4;
        int i5;
        int i6 = this.mFlag;
        boolean z5 = true;
        if ((i6 & 64) == 0 && (i6 & 3) != 1 && (i4 <= 0 ? !(i4 >= 0 || this.mWindowAlignment.mainAxis().isMinUnknown() || i4 >= (i5 = this.mWindowAlignment.mainAxis().getMinScroll())) : !(this.mWindowAlignment.mainAxis().isMaxUnknown() || i4 <= (i5 = this.mWindowAlignment.mainAxis().getMaxScroll())))) {
            i4 = i5;
        }
        if (i4 == 0) {
            return 0;
        }
        offsetChildrenPrimary(-i4);
        if ((this.mFlag & 3) == 1) {
            updateScrollLimits();
            return i4;
        }
        int childCount = getChildCount();
        if ((this.mFlag & 262144) == 0 ? i4 >= 0 : i4 <= 0) {
            appendVisibleItems();
        } else {
            prependVisibleItems();
        }
        if (getChildCount() > childCount) {
            z4 = true;
        } else {
            z4 = false;
        }
        int childCount2 = getChildCount();
        if ((262144 & this.mFlag) == 0 ? i4 >= 0 : i4 <= 0) {
            removeInvisibleViewsAtFront();
        } else {
            removeInvisibleViewsAtEnd();
        }
        if (getChildCount() >= childCount2) {
            z5 = false;
        }
        if (z4 || z5) {
            updateRowSecondarySizeRefresh();
        }
        this.mBaseGridView.invalidate();
        updateScrollLimits();
        return i4;
    }

    private int scrollDirectionSecondary(int i4) {
        if (i4 == 0) {
            return 0;
        }
        offsetChildrenSecondary(-i4);
        this.mScrollOffsetSecondary += i4;
        updateSecondaryScrollLimits();
        this.mBaseGridView.invalidate();
        return i4;
    }

    private void scrollGrid(int i4, int i5, boolean z4) {
        if ((this.mFlag & 3) == 1) {
            scrollDirectionPrimary(i4);
            scrollDirectionSecondary(i5);
            return;
        }
        if (this.mOrientation != 0) {
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        }
        if (z4) {
            this.mBaseGridView.smoothScrollBy(i4, i5);
            return;
        }
        this.mBaseGridView.scrollBy(i4, i5);
        dispatchChildSelectedAndPositioned();
    }

    private void updateChildAlignments(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.getItemAlignmentFacet() == null) {
            layoutParams.setAlignX(this.mItemAlignment.horizontal.getAlignmentPosition(view));
            layoutParams.setAlignY(this.mItemAlignment.vertical.getAlignmentPosition(view));
            return;
        }
        layoutParams.calculateItemAlignments(this.mOrientation, view);
        if (this.mOrientation == 0) {
            layoutParams.setAlignY(this.mItemAlignment.vertical.getAlignmentPosition(view));
        } else {
            layoutParams.setAlignX(this.mItemAlignment.horizontal.getAlignmentPosition(view));
        }
    }

    private void updateRowSecondarySizeRefresh() {
        int i4 = this.mFlag & -1025;
        int i5 = 0;
        if (processRowSizeSecondary(false)) {
            i5 = 1024;
        }
        int i6 = i4 | i5;
        this.mFlag = i6;
        if ((i6 & 1024) != 0) {
            forceRequestLayout();
        }
    }

    private void updateScrollController() {
        this.mWindowAlignment.horizontal.setSize(getWidth());
        this.mWindowAlignment.vertical.setSize(getHeight());
        this.mWindowAlignment.horizontal.setPadding(getPaddingLeft(), getPaddingRight());
        this.mWindowAlignment.vertical.setPadding(getPaddingTop(), getPaddingBottom());
        this.mSizePrimary = this.mWindowAlignment.mainAxis().getSize();
    }

    private void updateSecondaryScrollLimits() {
        WindowAlignment.Axis secondAxis = this.mWindowAlignment.secondAxis();
        int paddingMin = secondAxis.getPaddingMin() - this.mScrollOffsetSecondary;
        int sizeSecondary = getSizeSecondary() + paddingMin;
        secondAxis.updateMinMax(paddingMin, sizeSecondary, paddingMin, sizeSecondary);
    }

    public void addOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (this.mChildViewHolderSelectedListeners == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0 || this.mNumRows > 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean canScrollTo(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        if (!hasFocus() || view.hasFocusable()) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1 || this.mNumRows > 1) {
            return true;
        }
        return false;
    }

    public void collectAdjacentPrefetchPositions(int i4, int i5, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i6;
        try {
            saveContext((RecyclerView.Recycler) null, state);
            if (this.mOrientation != 0) {
                i4 = i5;
            }
            if (getChildCount() != 0) {
                if (i4 != 0) {
                    if (i4 < 0) {
                        i6 = -this.mExtraLayoutSpace;
                    } else {
                        i6 = this.mSizePrimary + this.mExtraLayoutSpace;
                    }
                    this.mGrid.collectAdjacentPrefetchPositions(i6, i4, layoutPrefetchRegistry);
                    leaveContext();
                }
            }
        } finally {
            leaveContext();
        }
    }

    public void collectInitialPrefetchPositions(int i4, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i5 = this.mBaseGridView.mInitialPrefetchItemCount;
        if (i4 != 0 && i5 != 0) {
            int max = Math.max(0, Math.min(this.mFocusPosition - ((i5 - 1) / 2), i4 - i5));
            int i6 = max;
            while (i6 < i4 && i6 < max + i5) {
                layoutPrefetchRegistry.addPosition(i6, 0);
                i6++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildSelected() {
        View view;
        long j4;
        if (this.mChildSelectedListener != null || hasOnChildViewHolderSelectedListener()) {
            int i4 = this.mFocusPosition;
            if (i4 == -1) {
                view = null;
            } else {
                view = findViewByPosition(i4);
            }
            if (view != null) {
                RecyclerView.ViewHolder childViewHolder = this.mBaseGridView.getChildViewHolder(view);
                OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
                if (onChildSelectedListener != null) {
                    BaseGridView baseGridView = this.mBaseGridView;
                    int i5 = this.mFocusPosition;
                    if (childViewHolder == null) {
                        j4 = -1;
                    } else {
                        j4 = childViewHolder.getItemId();
                    }
                    onChildSelectedListener.onChildSelected(baseGridView, view, i5, j4);
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, childViewHolder, this.mFocusPosition, this.mSubFocusPosition);
            } else {
                OnChildSelectedListener onChildSelectedListener2 = this.mChildSelectedListener;
                if (onChildSelectedListener2 != null) {
                    onChildSelectedListener2.onChildSelected(this.mBaseGridView, (View) null, -1, -1);
                }
                fireOnChildViewHolderSelected(this.mBaseGridView, (RecyclerView.ViewHolder) null, -1, 0);
            }
            if ((this.mFlag & 3) != 1 && !this.mBaseGridView.isLayoutRequested()) {
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    if (getChildAt(i6).isLayoutRequested()) {
                        forceRequestLayout();
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildSelectedAndPositioned() {
        View view;
        if (hasOnChildViewHolderSelectedListener()) {
            int i4 = this.mFocusPosition;
            if (i4 == -1) {
                view = null;
            } else {
                view = findViewByPosition(i4);
            }
            if (view != null) {
                fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, this.mBaseGridView.getChildViewHolder(view), this.mFocusPosition, this.mSubFocusPosition);
                return;
            }
            OnChildSelectedListener onChildSelectedListener = this.mChildSelectedListener;
            if (onChildSelectedListener != null) {
                onChildSelectedListener.onChildSelected(this.mBaseGridView, (View) null, -1, -1);
            }
            fireOnChildViewHolderSelectedAndPositioned(this.mBaseGridView, (RecyclerView.ViewHolder) null, -1, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void fillScrapViewsInPostLayout() {
        int i4;
        List<RecyclerView.ViewHolder> scrapList = this.mRecycler.getScrapList();
        int size = scrapList.size();
        if (size != 0) {
            int[] iArr = this.mDisappearingPositions;
            if (iArr == null || size > iArr.length) {
                if (iArr == null) {
                    i4 = 16;
                } else {
                    i4 = iArr.length;
                }
                while (i4 < size) {
                    i4 <<= 1;
                }
                this.mDisappearingPositions = new int[i4];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                int adapterPosition = scrapList.get(i6).getAdapterPosition();
                if (adapterPosition >= 0) {
                    this.mDisappearingPositions[i5] = adapterPosition;
                    i5++;
                }
            }
            if (i5 > 0) {
                Arrays.sort(this.mDisappearingPositions, 0, i5);
                this.mGrid.fillDisappearingItems(this.mDisappearingPositions, i5, this.mPositionToRowInPostLayout);
            }
            this.mPositionToRowInPostLayout.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void fireOnChildViewHolderSelected(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelected(recyclerView, viewHolder, i4, i5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void fireOnChildViewHolderSelectedAndPositioned(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i4, int i5) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mChildViewHolderSelectedListeners.get(size).onChildViewHolderSelectedAndPositioned(recyclerView, viewHolder, i4, i5);
            }
        }
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public int getChildDrawingOrder(RecyclerView recyclerView, int i4, int i5) {
        int indexOfChild;
        View findViewByPosition = findViewByPosition(this.mFocusPosition);
        if (findViewByPosition == null || i5 < (indexOfChild = recyclerView.indexOfChild(findViewByPosition))) {
            return i5;
        }
        if (i5 < i4 - 1) {
            return ((indexOfChild + i4) - 1) - i5;
        }
        return indexOfChild;
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        if (this.mOrientation != 1 || (grid = this.mGrid) == null) {
            return super.getColumnCountForAccessibility(recycler, state);
        }
        return grid.getNumRows();
    }

    public int getDecoratedBottom(View view) {
        return super.getDecoratedBottom(view) - ((LayoutParams) view.getLayoutParams()).mBottomInset;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        rect.left += layoutParams.mLeftInset;
        rect.top += layoutParams.mTopInset;
        rect.right -= layoutParams.mRightInset;
        rect.bottom -= layoutParams.mBottomInset;
    }

    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) + ((LayoutParams) view.getLayoutParams()).mLeftInset;
    }

    /* access modifiers changed from: package-private */
    public int getDecoratedMeasuredHeightWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: package-private */
    public int getDecoratedMeasuredWidthWithMargin(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public int getDecoratedRight(View view) {
        return super.getDecoratedRight(view) - ((LayoutParams) view.getLayoutParams()).mRightInset;
    }

    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) + ((LayoutParams) view.getLayoutParams()).mTopInset;
    }

    /* access modifiers changed from: package-private */
    public int getExtraLayoutSpace() {
        return this.mExtraLayoutSpace;
    }

    /* access modifiers changed from: package-private */
    public <E> E getFacet(RecyclerView.ViewHolder viewHolder, Class<? extends E> cls) {
        E e5;
        FacetProviderAdapter facetProviderAdapter;
        FacetProvider facetProvider;
        if (viewHolder instanceof FacetProvider) {
            e5 = ((FacetProvider) viewHolder).getFacet(cls);
        } else {
            e5 = null;
        }
        if (e5 != null || (facetProviderAdapter = this.mFacetProviderAdapter) == null || (facetProvider = facetProviderAdapter.getFacetProvider(viewHolder.getItemViewType())) == null) {
            return e5;
        }
        return facetProvider.getFacet(cls);
    }

    public int getFocusScrollStrategy() {
        return this.mFocusScrollStrategy;
    }

    public int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    public int getItemAlignmentOffset() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffset();
    }

    public float getItemAlignmentOffsetPercent() {
        return this.mItemAlignment.mainAxis().getItemAlignmentOffsetPercent();
    }

    public int getItemAlignmentViewId() {
        return this.mItemAlignment.mainAxis().getItemAlignmentViewId();
    }

    /* access modifiers changed from: package-private */
    public final int getOpticalBottom(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalBottom(view);
    }

    /* access modifiers changed from: package-private */
    public final int getOpticalLeft(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalLeft(view);
    }

    /* access modifiers changed from: package-private */
    public final int getOpticalRight(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalRight(view);
    }

    /* access modifiers changed from: package-private */
    public final int getOpticalTop(View view) {
        return ((LayoutParams) view.getLayoutParams()).getOpticalTop(view);
    }

    public boolean getPruneChild() {
        if ((this.mFlag & 65536) != 0) {
            return true;
        }
        return false;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Grid grid;
        if (this.mOrientation != 0 || (grid = this.mGrid) == null) {
            return super.getRowCountForAccessibility(recycler, state);
        }
        return grid.getNumRows();
    }

    /* access modifiers changed from: package-private */
    public int getRowStartSecondary(int i4) {
        int i5 = 0;
        if ((this.mFlag & 524288) != 0) {
            for (int i6 = this.mNumRows - 1; i6 > i4; i6--) {
                i5 += getRowSizeSecondary(i6) + this.mSpacingSecondary;
            }
            return i5;
        }
        int i7 = 0;
        while (i5 < i4) {
            i7 += getRowSizeSecondary(i5) + this.mSpacingSecondary;
            i5++;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public boolean getScrollPosition(View view, View view2, int[] iArr) {
        int i4 = this.mFocusScrollStrategy;
        if (i4 == 1 || i4 == 2) {
            return getNoneAlignedPosition(view, iArr);
        }
        return getAlignedPosition(view, view2, iArr);
    }

    public int getSelection() {
        return this.mFocusPosition;
    }

    /* access modifiers changed from: package-private */
    public int getSlideOutDistance() {
        int left;
        int right;
        int top;
        if (this.mOrientation == 1) {
            int i4 = -getHeight();
            if (getChildCount() <= 0 || (top = getChildAt(0).getTop()) >= 0) {
                return i4;
            }
            return i4 + top;
        } else if ((this.mFlag & 262144) != 0) {
            int width = getWidth();
            if (getChildCount() <= 0 || (right = getChildAt(0).getRight()) <= width) {
                return width;
            }
            return right;
        } else {
            int i5 = -getWidth();
            if (getChildCount() <= 0 || (left = getChildAt(0).getLeft()) >= 0) {
                return i5;
            }
            return i5 + left;
        }
    }

    /* access modifiers changed from: package-private */
    public int getSubPositionByView(View view, View view2) {
        ItemAlignmentFacet itemAlignmentFacet;
        if (!(view == null || view2 == null || (itemAlignmentFacet = ((LayoutParams) view.getLayoutParams()).getItemAlignmentFacet()) == null)) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = itemAlignmentFacet.getAlignmentDefs();
            if (alignmentDefs.length > 1) {
                while (view2 != view) {
                    int id = view2.getId();
                    if (id != -1) {
                        for (int i4 = 1; i4 < alignmentDefs.length; i4++) {
                            if (alignmentDefs[i4].getItemAlignmentFocusViewId() == id) {
                                return i4;
                            }
                        }
                        continue;
                    }
                    view2 = (View) view2.getParent();
                }
            }
        }
        return 0;
    }

    public int getSubSelection() {
        return this.mSubFocusPosition;
    }

    /* access modifiers changed from: package-private */
    public String getTag() {
        return "GridLayoutManager:" + this.mBaseGridView.getId();
    }

    public int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    /* access modifiers changed from: protected */
    public View getViewForPosition(int i4) {
        return this.mRecycler.getViewForPosition(i4);
    }

    /* access modifiers changed from: package-private */
    public int getViewMax(View view) {
        return this.mOrientationHelper.getDecoratedEnd(view);
    }

    /* access modifiers changed from: package-private */
    public int getViewMin(View view) {
        return this.mOrientationHelper.getDecoratedStart(view);
    }

    /* access modifiers changed from: package-private */
    public int getViewPrimarySize(View view) {
        Rect rect = sTempRect;
        getDecoratedBoundsWithMargins(view, rect);
        if (this.mOrientation == 0) {
            return rect.width();
        }
        return rect.height();
    }

    public void getViewSelectedOffsets(View view, int[] iArr) {
        if (this.mOrientation == 0) {
            iArr[0] = getPrimaryAlignedScrollDistance(view);
            iArr[1] = getSecondaryScrollDistance(view);
            return;
        }
        iArr[1] = getPrimaryAlignedScrollDistance(view);
        iArr[0] = getSecondaryScrollDistance(view);
    }

    public int getWindowAlignment() {
        return this.mWindowAlignment.mainAxis().getWindowAlignment();
    }

    public int getWindowAlignmentOffset() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffset();
    }

    public float getWindowAlignmentOffsetPercent() {
        return this.mWindowAlignment.mainAxis().getWindowAlignmentOffsetPercent();
    }

    /* access modifiers changed from: package-private */
    public boolean gridOnRequestFocusInDescendants(RecyclerView recyclerView, int i4, Rect rect) {
        int i5 = this.mFocusScrollStrategy;
        if (i5 == 1 || i5 == 2) {
            return gridOnRequestFocusInDescendantsUnaligned(recyclerView, i4, rect);
        }
        return gridOnRequestFocusInDescendantsAligned(recyclerView, i4, rect);
    }

    /* access modifiers changed from: package-private */
    public boolean hasCreatedFirstItem() {
        if (getItemCount() == 0 || this.mBaseGridView.findViewHolderForAdapterPosition(0) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasCreatedLastItem() {
        int itemCount = getItemCount();
        if (itemCount == 0 || this.mBaseGridView.findViewHolderForAdapterPosition(itemCount - 1) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean hasDoneFirstLayout() {
        if (this.mGrid != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean hasOnChildViewHolderSelectedListener() {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean hasPreviousViewInSameRow(int i4) {
        Grid grid = this.mGrid;
        if (!(grid == null || i4 == -1 || grid.getFirstVisibleIndex() < 0)) {
            if (this.mGrid.getFirstVisibleIndex() > 0) {
                return true;
            }
            int i5 = this.mGrid.getLocation(i4).row;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                int adapterPositionByIndex = getAdapterPositionByIndex(childCount);
                Grid.Location location = this.mGrid.getLocation(adapterPositionByIndex);
                if (location != null && location.row == i5 && adapterPositionByIndex < i4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isFocusSearchDisabled() {
        if ((this.mFlag & 32768) != 0) {
            return true;
        }
        return false;
    }

    public boolean isItemAlignmentOffsetWithPadding() {
        return this.mItemAlignment.mainAxis().isItemAlignmentOffsetWithPadding();
    }

    /* access modifiers changed from: package-private */
    public boolean isItemFullyVisible(int i4) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.mBaseGridView.findViewHolderForAdapterPosition(i4);
        if (findViewHolderForAdapterPosition != null && findViewHolderForAdapterPosition.itemView.getLeft() >= 0 && findViewHolderForAdapterPosition.itemView.getRight() <= this.mBaseGridView.getWidth() && findViewHolderForAdapterPosition.itemView.getTop() >= 0 && findViewHolderForAdapterPosition.itemView.getBottom() <= this.mBaseGridView.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean isScrollEnabled() {
        if ((this.mFlag & 131072) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isSlidingChildViews() {
        if ((this.mFlag & 64) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void layoutChild(int i4, View view, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.mOrientation == 0) {
            i8 = getDecoratedMeasuredHeightWithMargin(view);
        } else {
            i8 = getDecoratedMeasuredWidthWithMargin(view);
        }
        int i15 = this.mFixedRowSizeSecondary;
        if (i15 > 0) {
            i8 = Math.min(i8, i15);
        }
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        if ((this.mFlag & PF_REVERSE_FLOW_MASK) != 0) {
            i9 = Gravity.getAbsoluteGravity(i16 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK, 1);
        } else {
            i9 = i16 & 7;
        }
        int i18 = this.mOrientation;
        if (!((i18 == 0 && i17 == 48) || (i18 == 1 && i9 == 3))) {
            if ((i18 == 0 && i17 == 80) || (i18 == 1 && i9 == 5)) {
                i14 = getRowSizeSecondary(i4) - i8;
            } else if ((i18 == 0 && i17 == 16) || (i18 == 1 && i9 == 1)) {
                i14 = (getRowSizeSecondary(i4) - i8) / 2;
            }
            i7 += i14;
        }
        if (this.mOrientation == 0) {
            i13 = i5;
            i11 = i6;
            i12 = i7;
            i10 = i8 + i7;
        } else {
            i12 = i5;
            i10 = i6;
            i13 = i7;
            i11 = i8 + i7;
        }
        View view2 = view;
        layoutDecoratedWithMargins(view2, i13, i12, i11, i10);
        Rect rect = sTempRect;
        super.getDecoratedBoundsWithMargins(view2, rect);
        ((LayoutParams) view.getLayoutParams()).setOpticalInsets(i13 - rect.left, i12 - rect.top, rect.right - i11, rect.bottom - i10);
        updateChildAlignments(view2);
    }

    /* access modifiers changed from: package-private */
    public void measureChild(View view) {
        int i4;
        int i5;
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = sTempRect;
        calculateItemDecorationsForChild(view, rect);
        int i7 = layoutParams.leftMargin + layoutParams.rightMargin + rect.left + rect.right;
        int i8 = layoutParams.topMargin + layoutParams.bottomMargin + rect.top + rect.bottom;
        if (this.mRowSizeSecondaryRequested == -2) {
            i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            i4 = View.MeasureSpec.makeMeasureSpec(this.mFixedRowSizeSecondary, 1073741824);
        }
        if (this.mOrientation == 0) {
            i5 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i7, layoutParams.width);
            i6 = ViewGroup.getChildMeasureSpec(i4, i8, layoutParams.height);
        } else {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i8, layoutParams.height);
            i5 = ViewGroup.getChildMeasureSpec(i4, i7, layoutParams.width);
            i6 = childMeasureSpec;
        }
        view.measure(i5, i6);
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        if (adapter != null) {
            discardLayoutInfo();
            this.mFocusPosition = -1;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.clear();
        }
        if (adapter2 instanceof FacetProviderAdapter) {
            this.mFacetProviderAdapter = (FacetProviderAdapter) adapter2;
        } else {
            this.mFacetProviderAdapter = null;
        }
        super.onAdapterChanged(adapter, adapter2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onAddFocusables(androidx.recyclerview.widget.RecyclerView r19, java.util.ArrayList<android.view.View> r20, int r21, int r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            int r4 = r0.mFlag
            r5 = 32768(0x8000, float:4.5918E-41)
            r4 = r4 & r5
            r5 = 1
            if (r4 == 0) goto L_0x0012
            return r5
        L_0x0012:
            boolean r4 = r19.hasFocus()
            if (r4 == 0) goto L_0x0117
            androidx.leanback.widget.GridLayoutManager$PendingMoveSmoothScroller r4 = r0.mPendingMoveSmoothScroller
            if (r4 == 0) goto L_0x001d
            return r5
        L_0x001d:
            int r4 = r0.getMovement(r2)
            android.view.View r7 = r19.findFocus()
            int r7 = r0.findImmediateChildIndex(r7)
            int r8 = r0.getAdapterPositionByIndex(r7)
            r9 = -1
            if (r8 != r9) goto L_0x0032
            r10 = 0
            goto L_0x0036
        L_0x0032:
            android.view.View r10 = r0.findViewByPosition(r8)
        L_0x0036:
            if (r10 == 0) goto L_0x003b
            r10.addFocusables(r1, r2, r3)
        L_0x003b:
            androidx.leanback.widget.Grid r11 = r0.mGrid
            if (r11 == 0) goto L_0x0045
            int r11 = r0.getChildCount()
            if (r11 != 0) goto L_0x0049
        L_0x0045:
            r17 = 1
            goto L_0x0116
        L_0x0049:
            r11 = 2
            r12 = 3
            if (r4 == r12) goto L_0x004f
            if (r4 != r11) goto L_0x0058
        L_0x004f:
            androidx.leanback.widget.Grid r13 = r0.mGrid
            int r13 = r13.getNumRows()
            if (r13 > r5) goto L_0x0058
            return r5
        L_0x0058:
            androidx.leanback.widget.Grid r13 = r0.mGrid
            if (r13 == 0) goto L_0x0065
            if (r10 == 0) goto L_0x0065
            androidx.leanback.widget.Grid$Location r13 = r13.getLocation(r8)
            int r13 = r13.row
            goto L_0x0066
        L_0x0065:
            r13 = -1
        L_0x0066:
            int r14 = r1.size()
            if (r4 == r5) goto L_0x0071
            if (r4 != r12) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r15 = -1
            goto L_0x0072
        L_0x0071:
            r15 = 1
        L_0x0072:
            if (r15 <= 0) goto L_0x007d
            int r16 = r0.getChildCount()
            int r16 = r16 + -1
            r6 = r16
            goto L_0x007e
        L_0x007d:
            r6 = 0
        L_0x007e:
            if (r7 != r9) goto L_0x008d
            if (r15 <= 0) goto L_0x0085
            r16 = 0
            goto L_0x008f
        L_0x0085:
            int r7 = r0.getChildCount()
            int r7 = r7 - r5
            r16 = r7
            goto L_0x008f
        L_0x008d:
            int r16 = r7 + r15
        L_0x008f:
            r7 = r16
        L_0x0091:
            if (r15 <= 0) goto L_0x009a
            if (r7 > r6) goto L_0x0096
            goto L_0x009c
        L_0x0096:
            r17 = 1
            goto L_0x0193
        L_0x009a:
            if (r7 < r6) goto L_0x0096
        L_0x009c:
            android.view.View r9 = r0.getChildAt(r7)
            int r16 = r9.getVisibility()
            if (r16 != 0) goto L_0x00ac
            boolean r16 = r9.hasFocusable()
            if (r16 != 0) goto L_0x00b2
        L_0x00ac:
            r5 = 2
            r11 = 3
        L_0x00ae:
            r17 = 1
            goto L_0x0110
        L_0x00b2:
            if (r10 != 0) goto L_0x00be
            r9.addFocusables(r1, r2, r3)
            int r9 = r1.size()
            if (r9 <= r14) goto L_0x00ac
            goto L_0x0096
        L_0x00be:
            int r11 = r0.getAdapterPositionByIndex(r7)
            androidx.leanback.widget.Grid r12 = r0.mGrid
            androidx.leanback.widget.Grid$Location r12 = r12.getLocation(r11)
            if (r12 != 0) goto L_0x00cb
            goto L_0x00ac
        L_0x00cb:
            if (r4 != r5) goto L_0x00dd
            int r12 = r12.row
            if (r12 != r13) goto L_0x00ac
            if (r11 <= r8) goto L_0x00ac
            r9.addFocusables(r1, r2, r3)
            int r9 = r1.size()
            if (r9 <= r14) goto L_0x00ac
            goto L_0x0096
        L_0x00dd:
            if (r4 != 0) goto L_0x00ef
            int r12 = r12.row
            if (r12 != r13) goto L_0x00ac
            if (r11 >= r8) goto L_0x00ac
            r9.addFocusables(r1, r2, r3)
            int r9 = r1.size()
            if (r9 <= r14) goto L_0x00ac
            goto L_0x0096
        L_0x00ef:
            r11 = 3
            if (r4 != r11) goto L_0x00ff
            int r12 = r12.row
            if (r12 != r13) goto L_0x00f8
        L_0x00f6:
            r5 = 2
            goto L_0x00ae
        L_0x00f8:
            if (r12 >= r13) goto L_0x00fb
            goto L_0x0096
        L_0x00fb:
            r9.addFocusables(r1, r2, r3)
            goto L_0x00f6
        L_0x00ff:
            r5 = 2
            r17 = 1
            if (r4 != r5) goto L_0x0110
            int r12 = r12.row
            if (r12 != r13) goto L_0x0109
            goto L_0x0110
        L_0x0109:
            if (r12 <= r13) goto L_0x010d
            goto L_0x0193
        L_0x010d:
            r9.addFocusables(r1, r2, r3)
        L_0x0110:
            int r7 = r7 + r15
            r5 = 1
            r11 = 2
            r12 = 3
            goto L_0x0091
        L_0x0116:
            return r17
        L_0x0117:
            r17 = 1
            int r4 = r1.size()
            int r5 = r0.mFocusScrollStrategy
            if (r5 == 0) goto L_0x0176
            androidx.leanback.widget.WindowAlignment r5 = r0.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r5 = r5.mainAxis()
            int r5 = r5.getPaddingMin()
            androidx.leanback.widget.WindowAlignment r6 = r0.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r6 = r6.mainAxis()
            int r6 = r6.getClientSize()
            int r6 = r6 + r5
            int r7 = r0.getChildCount()
            r8 = 0
        L_0x013b:
            if (r8 >= r7) goto L_0x0159
            android.view.View r9 = r0.getChildAt(r8)
            int r10 = r9.getVisibility()
            if (r10 != 0) goto L_0x0156
            int r10 = r0.getViewMin(r9)
            if (r10 < r5) goto L_0x0156
            int r10 = r0.getViewMax(r9)
            if (r10 > r6) goto L_0x0156
            r9.addFocusables(r1, r2, r3)
        L_0x0156:
            int r8 = r8 + 1
            goto L_0x013b
        L_0x0159:
            int r5 = r1.size()
            if (r5 != r4) goto L_0x0181
            int r5 = r0.getChildCount()
            r6 = 0
        L_0x0164:
            if (r6 >= r5) goto L_0x0181
            android.view.View r7 = r0.getChildAt(r6)
            int r8 = r7.getVisibility()
            if (r8 != 0) goto L_0x0173
            r7.addFocusables(r1, r2, r3)
        L_0x0173:
            int r6 = r6 + 1
            goto L_0x0164
        L_0x0176:
            int r5 = r0.mFocusPosition
            android.view.View r5 = r0.findViewByPosition(r5)
            if (r5 == 0) goto L_0x0181
            r5.addFocusables(r1, r2, r3)
        L_0x0181:
            int r2 = r1.size()
            if (r2 == r4) goto L_0x0188
            return r17
        L_0x0188:
            boolean r2 = r19.isFocusable()
            if (r2 == 0) goto L_0x0193
            r2 = r19
            r1.add(r2)
        L_0x0193:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onAddFocusables(androidx.recyclerview.widget.RecyclerView, java.util.ArrayList, int, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public void onChildRecycled(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition != -1) {
            this.mChildrenStates.saveOffscreenView(viewHolder.itemView, adapterPosition);
        }
    }

    /* access modifiers changed from: package-private */
    public void onFocusChanged(boolean z4, int i4, Rect rect) {
        if (z4) {
            int i5 = this.mFocusPosition;
            while (true) {
                View findViewByPosition = findViewByPosition(i5);
                if (findViewByPosition != null) {
                    if (findViewByPosition.getVisibility() != 0 || !findViewByPosition.hasFocusable()) {
                        i5++;
                    } else {
                        findViewByPosition.requestFocus();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z4;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        saveContext(recycler, state);
        int itemCount = state.getItemCount();
        if ((this.mFlag & 262144) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (itemCount > 1 && !isItemFullyVisible(0)) {
            if (Build.VERSION.SDK_INT < 23) {
                accessibilityNodeInfoCompat.addAction(8192);
            } else if (this.mOrientation == 0) {
                if (z4) {
                    accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                } else {
                    accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                }
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
            } else {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        if (itemCount > 1 && !isItemFullyVisible(itemCount - 1)) {
            if (Build.VERSION.SDK_INT < 23) {
                accessibilityNodeInfoCompat.addAction(4096);
            } else if (this.mOrientation == 0) {
                if (z4) {
                    accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                } else {
                    accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                }
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
            } else {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        leaveContext();
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.mGrid != null && (layoutParams instanceof LayoutParams)) {
            int viewAdapterPosition = ((LayoutParams) layoutParams).getViewAdapterPosition();
            if (viewAdapterPosition >= 0) {
                i4 = this.mGrid.getRowIndex(viewAdapterPosition);
            } else {
                i4 = -1;
            }
            if (i4 >= 0) {
                int numRows = viewAdapterPosition / this.mGrid.getNumRows();
                if (this.mOrientation == 0) {
                    accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i4, 1, numRows, 1, false, false));
                    return;
                }
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(numRows, 1, i4, 1, false, false));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x00cb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onInterceptFocusSearch(android.view.View r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.mFlag
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0009
            return r8
        L_0x0009:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            r1 = 0
            r2 = 2
            r3 = 1
            if (r9 == r2) goto L_0x001c
            if (r9 != r3) goto L_0x0015
            goto L_0x001c
        L_0x0015:
            androidx.leanback.widget.BaseGridView r4 = r7.mBaseGridView
            android.view.View r0 = r0.findNextFocus(r4, r8, r9)
            goto L_0x0055
        L_0x001c:
            boolean r4 = r7.canScrollVertically()
            if (r4 == 0) goto L_0x0030
            if (r9 != r2) goto L_0x0027
            r4 = 130(0x82, float:1.82E-43)
            goto L_0x0029
        L_0x0027:
            r4 = 33
        L_0x0029:
            androidx.leanback.widget.BaseGridView r5 = r7.mBaseGridView
            android.view.View r4 = r0.findNextFocus(r5, r8, r4)
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            boolean r5 = r7.canScrollHorizontally()
            if (r5 == 0) goto L_0x0054
            int r4 = r7.getLayoutDirection()
            if (r4 != r3) goto L_0x003f
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            if (r9 != r2) goto L_0x0044
            r5 = 1
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            r4 = r4 ^ r5
            if (r4 == 0) goto L_0x004b
            r4 = 66
            goto L_0x004d
        L_0x004b:
            r4 = 17
        L_0x004d:
            androidx.leanback.widget.BaseGridView r5 = r7.mBaseGridView
            android.view.View r0 = r0.findNextFocus(r5, r8, r4)
            goto L_0x0055
        L_0x0054:
            r0 = r4
        L_0x0055:
            if (r0 == 0) goto L_0x0058
            return r0
        L_0x0058:
            androidx.leanback.widget.BaseGridView r4 = r7.mBaseGridView
            int r4 = r4.getDescendantFocusability()
            r5 = 393216(0x60000, float:5.51013E-40)
            if (r4 != r5) goto L_0x006d
            androidx.leanback.widget.BaseGridView r0 = r7.mBaseGridView
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r8 = r0.focusSearch(r8, r9)
            return r8
        L_0x006d:
            int r4 = r7.getMovement(r9)
            androidx.leanback.widget.BaseGridView r5 = r7.mBaseGridView
            int r5 = r5.getScrollState()
            if (r5 == 0) goto L_0x007b
            r5 = 1
            goto L_0x007c
        L_0x007b:
            r5 = 0
        L_0x007c:
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r4 != r3) goto L_0x0098
            if (r5 != 0) goto L_0x0088
            int r1 = r7.mFlag
            r1 = r1 & 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x0089
        L_0x0088:
            r0 = r8
        L_0x0089:
            int r1 = r7.mFlag
            r1 = r1 & r6
            if (r1 == 0) goto L_0x00c9
            boolean r1 = r7.hasCreatedLastItem()
            if (r1 != 0) goto L_0x00c9
            r7.processPendingMovement(r3)
            goto L_0x00c8
        L_0x0098:
            if (r4 != 0) goto L_0x00b2
            if (r5 != 0) goto L_0x00a2
            int r2 = r7.mFlag
            r2 = r2 & 2048(0x800, float:2.87E-42)
            if (r2 != 0) goto L_0x00a3
        L_0x00a2:
            r0 = r8
        L_0x00a3:
            int r2 = r7.mFlag
            r2 = r2 & r6
            if (r2 == 0) goto L_0x00c9
            boolean r2 = r7.hasCreatedFirstItem()
            if (r2 != 0) goto L_0x00c9
            r7.processPendingMovement(r1)
            goto L_0x00c8
        L_0x00b2:
            r1 = 3
            if (r4 != r1) goto L_0x00be
            if (r5 != 0) goto L_0x00c8
            int r1 = r7.mFlag
            r1 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r1 != 0) goto L_0x00c9
            goto L_0x00c8
        L_0x00be:
            if (r4 != r2) goto L_0x00c9
            if (r5 != 0) goto L_0x00c8
            int r1 = r7.mFlag
            r1 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r1 != 0) goto L_0x00c9
        L_0x00c8:
            r0 = r8
        L_0x00c9:
            if (r0 == 0) goto L_0x00cc
            return r0
        L_0x00cc:
            androidx.leanback.widget.BaseGridView r0 = r7.mBaseGridView
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r9 = r0.focusSearch(r8, r9)
            if (r9 == 0) goto L_0x00d9
            return r9
        L_0x00d9:
            if (r8 == 0) goto L_0x00dc
            return r8
        L_0x00dc:
            androidx.leanback.widget.BaseGridView r8 = r7.mBaseGridView
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onInterceptFocusSearch(android.view.View, int):android.view.View");
    }

    public void onItemsAdded(RecyclerView recyclerView, int i4, int i5) {
        Grid grid;
        int i6;
        if (!(this.mFocusPosition == -1 || (grid = this.mGrid) == null || grid.getFirstVisibleIndex() < 0 || (i6 = this.mFocusPositionOffset) == Integer.MIN_VALUE || i4 > this.mFocusPosition + i6)) {
            this.mFocusPositionOffset = i6 + i5;
        }
        this.mChildrenStates.clear();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mFocusPositionOffset = 0;
        this.mChildrenStates.clear();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i4, int i5, int i6) {
        int i7;
        int i8 = this.mFocusPosition;
        if (!(i8 == -1 || (i7 = this.mFocusPositionOffset) == Integer.MIN_VALUE)) {
            int i9 = i8 + i7;
            if (i4 <= i9 && i9 < i4 + i6) {
                this.mFocusPositionOffset = i7 + (i5 - i4);
            } else if (i4 < i9 && i5 > i9 - i6) {
                this.mFocusPositionOffset = i7 - i6;
            } else if (i4 > i9 && i5 < i9) {
                this.mFocusPositionOffset = i7 + i6;
            }
        }
        this.mChildrenStates.clear();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r1 = r4.mFocusPosition;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemsRemoved(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            int r5 = r4.mFocusPosition
            r0 = -1
            if (r5 == r0) goto L_0x002a
            androidx.leanback.widget.Grid r5 = r4.mGrid
            if (r5 == 0) goto L_0x002a
            int r5 = r5.getFirstVisibleIndex()
            if (r5 < 0) goto L_0x002a
            int r5 = r4.mFocusPositionOffset
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r0) goto L_0x002a
            int r1 = r4.mFocusPosition
            int r2 = r1 + r5
            if (r6 > r2) goto L_0x002a
            int r3 = r6 + r7
            if (r3 <= r2) goto L_0x0027
            int r6 = r6 - r2
            int r5 = r5 + r6
            int r1 = r1 + r5
            r4.mFocusPosition = r1
            r4.mFocusPositionOffset = r0
            goto L_0x002a
        L_0x0027:
            int r5 = r5 - r7
            r4.mFocusPositionOffset = r5
        L_0x002a:
            androidx.leanback.widget.ViewsStateBundle r5 = r4.mChildrenStates
            r5.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onItemsRemoved(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i4, int i5) {
        int i6 = i5 + i4;
        while (i4 < i6) {
            this.mChildrenStates.remove(i4);
            i4++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0172 A[LOOP:1: B:84:0x0172->B:87:0x017c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler r14, androidx.recyclerview.widget.RecyclerView.State r15) {
        /*
            r13 = this;
            int r0 = r13.mNumRows
            if (r0 != 0) goto L_0x0005
            goto L_0x000b
        L_0x0005:
            int r0 = r15.getItemCount()
            if (r0 >= 0) goto L_0x000c
        L_0x000b:
            return
        L_0x000c:
            int r0 = r13.mFlag
            r0 = r0 & 64
            if (r0 == 0) goto L_0x001f
            int r0 = r13.getChildCount()
            if (r0 <= 0) goto L_0x001f
            int r14 = r13.mFlag
            r14 = r14 | 128(0x80, float:1.794E-43)
            r13.mFlag = r14
            return
        L_0x001f:
            int r0 = r13.mFlag
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x002c
            r13.discardLayoutInfo()
            r13.removeAndRecycleAllViews(r14)
            return
        L_0x002c:
            r0 = r0 & -4
            r1 = 1
            r0 = r0 | r1
            r13.mFlag = r0
            r13.saveContext(r14, r15)
            boolean r14 = r15.isPreLayout()
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 0
            if (r14 == 0) goto L_0x00d8
            r13.updatePositionDeltaInPreLayout()
            int r14 = r13.getChildCount()
            androidx.leanback.widget.Grid r15 = r13.mGrid
            if (r15 == 0) goto L_0x00ce
            if (r14 <= 0) goto L_0x00ce
            androidx.leanback.widget.BaseGridView r15 = r13.mBaseGridView
            android.view.View r1 = r13.getChildAt(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r15 = r15.getChildViewHolder(r1)
            int r15 = r15.getOldPosition()
            androidx.leanback.widget.BaseGridView r1 = r13.mBaseGridView
            int r3 = r14 + -1
            android.view.View r3 = r13.getChildAt(r3)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getChildViewHolder(r3)
            int r1 = r1.getOldPosition()
            r3 = 2147483647(0x7fffffff, float:NaN)
        L_0x006c:
            if (r2 >= r14) goto L_0x00c3
            android.view.View r4 = r13.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            androidx.leanback.widget.GridLayoutManager$LayoutParams r5 = (androidx.leanback.widget.GridLayoutManager.LayoutParams) r5
            androidx.leanback.widget.BaseGridView r6 = r13.mBaseGridView
            int r6 = r6.getChildAdapterPosition(r4)
            boolean r7 = r5.isItemChanged()
            if (r7 != 0) goto L_0x00b0
            boolean r7 = r5.isItemRemoved()
            if (r7 != 0) goto L_0x00b0
            boolean r7 = r4.isLayoutRequested()
            if (r7 != 0) goto L_0x00b0
            boolean r7 = r4.hasFocus()
            if (r7 != 0) goto L_0x009e
            int r7 = r13.mFocusPosition
            int r8 = r5.getViewAdapterPosition()
            if (r7 == r8) goto L_0x00b0
        L_0x009e:
            boolean r7 = r4.hasFocus()
            if (r7 == 0) goto L_0x00ac
            int r7 = r13.mFocusPosition
            int r5 = r5.getViewAdapterPosition()
            if (r7 != r5) goto L_0x00b0
        L_0x00ac:
            if (r6 < r15) goto L_0x00b0
            if (r6 <= r1) goto L_0x00c0
        L_0x00b0:
            int r5 = r13.getViewMin(r4)
            int r3 = java.lang.Math.min(r3, r5)
            int r4 = r13.getViewMax(r4)
            int r0 = java.lang.Math.max(r0, r4)
        L_0x00c0:
            int r2 = r2 + 1
            goto L_0x006c
        L_0x00c3:
            if (r0 <= r3) goto L_0x00c8
            int r0 = r0 - r3
            r13.mExtraLayoutSpaceInPreLayout = r0
        L_0x00c8:
            r13.appendVisibleItems()
            r13.prependVisibleItems()
        L_0x00ce:
            int r14 = r13.mFlag
            r14 = r14 & -4
            r13.mFlag = r14
            r13.leaveContext()
            return
        L_0x00d8:
            boolean r14 = r15.willRunPredictiveAnimations()
            if (r14 == 0) goto L_0x00e1
            r13.updatePositionToRowMapInPostLayout()
        L_0x00e1:
            boolean r14 = r13.isSmoothScrolling()
            if (r14 != 0) goto L_0x00ec
            int r14 = r13.mFocusScrollStrategy
            if (r14 != 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r1 = 0
        L_0x00ed:
            int r14 = r13.mFocusPosition
            r3 = -1
            if (r14 == r3) goto L_0x00fb
            int r4 = r13.mFocusPositionOffset
            if (r4 == r0) goto L_0x00fb
            int r14 = r14 + r4
            r13.mFocusPosition = r14
            r13.mSubFocusPosition = r2
        L_0x00fb:
            r13.mFocusPositionOffset = r2
            int r14 = r13.mFocusPosition
            android.view.View r14 = r13.findViewByPosition(r14)
            int r0 = r13.mFocusPosition
            int r4 = r13.mSubFocusPosition
            androidx.leanback.widget.BaseGridView r5 = r13.mBaseGridView
            boolean r5 = r5.hasFocus()
            androidx.leanback.widget.Grid r6 = r13.mGrid
            if (r6 == 0) goto L_0x0116
            int r6 = r6.getFirstVisibleIndex()
            goto L_0x0117
        L_0x0116:
            r6 = -1
        L_0x0117:
            androidx.leanback.widget.Grid r7 = r13.mGrid
            if (r7 == 0) goto L_0x0120
            int r7 = r7.getLastVisibleIndex()
            goto L_0x0121
        L_0x0120:
            r7 = -1
        L_0x0121:
            int r8 = r13.mOrientation
            if (r8 != 0) goto L_0x012e
            int r8 = r15.getRemainingScrollHorizontal()
            int r9 = r15.getRemainingScrollVertical()
            goto L_0x0136
        L_0x012e:
            int r9 = r15.getRemainingScrollHorizontal()
            int r8 = r15.getRemainingScrollVertical()
        L_0x0136:
            boolean r10 = r13.layoutInit()
            r11 = 16
            if (r10 == 0) goto L_0x014f
            int r2 = r13.mFlag
            r2 = r2 | 4
            r13.mFlag = r2
            androidx.leanback.widget.Grid r2 = r13.mGrid
            int r3 = r13.mFocusPosition
            r2.setStart(r3)
            r13.fastRelayout()
            goto L_0x017f
        L_0x014f:
            int r10 = r13.mFlag
            r12 = r10 & -5
            r13.mFlag = r12
            r10 = r10 & -21
            if (r5 == 0) goto L_0x015b
            r2 = 16
        L_0x015b:
            r2 = r2 | r10
            r13.mFlag = r2
            if (r1 == 0) goto L_0x016b
            if (r6 < 0) goto L_0x0168
            int r2 = r13.mFocusPosition
            if (r2 > r7) goto L_0x0168
            if (r2 >= r6) goto L_0x016b
        L_0x0168:
            int r6 = r13.mFocusPosition
            r7 = r6
        L_0x016b:
            androidx.leanback.widget.Grid r2 = r13.mGrid
            r2.setStart(r6)
            if (r7 == r3) goto L_0x017f
        L_0x0172:
            boolean r2 = r13.appendOneColumnVisibleItems()
            if (r2 == 0) goto L_0x017f
            android.view.View r2 = r13.findViewByPosition(r7)
            if (r2 != 0) goto L_0x017f
            goto L_0x0172
        L_0x017f:
            r13.updateScrollLimits()
            androidx.leanback.widget.Grid r2 = r13.mGrid
            int r2 = r2.getFirstVisibleIndex()
            androidx.leanback.widget.Grid r3 = r13.mGrid
            int r3 = r3.getLastVisibleIndex()
            int r6 = -r8
            int r7 = -r9
            r13.focusToViewInLayout(r5, r1, r6, r7)
            r13.appendVisibleItems()
            r13.prependVisibleItems()
            androidx.leanback.widget.Grid r6 = r13.mGrid
            int r6 = r6.getFirstVisibleIndex()
            if (r6 != r2) goto L_0x017f
            androidx.leanback.widget.Grid r2 = r13.mGrid
            int r2 = r2.getLastVisibleIndex()
            if (r2 != r3) goto L_0x017f
            r13.removeInvisibleViewsAtFront()
            r13.removeInvisibleViewsAtEnd()
            boolean r15 = r15.willRunPredictiveAnimations()
            if (r15 == 0) goto L_0x01b8
            r13.fillScrapViewsInPostLayout()
        L_0x01b8:
            int r15 = r13.mFlag
            r1 = r15 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x01c3
            r15 = r15 & -1025(0xfffffffffffffbff, float:NaN)
            r13.mFlag = r15
            goto L_0x01c6
        L_0x01c3:
            r13.updateRowSecondarySizeRefresh()
        L_0x01c6:
            int r15 = r13.mFlag
            r15 = r15 & 4
            if (r15 == 0) goto L_0x01e4
            int r15 = r13.mFocusPosition
            if (r15 != r0) goto L_0x01e0
            int r0 = r13.mSubFocusPosition
            if (r0 != r4) goto L_0x01e0
            android.view.View r15 = r13.findViewByPosition(r15)
            if (r15 != r14) goto L_0x01e0
            int r14 = r13.mFlag
            r14 = r14 & 8
            if (r14 == 0) goto L_0x01e4
        L_0x01e0:
            r13.dispatchChildSelected()
            goto L_0x01ed
        L_0x01e4:
            int r14 = r13.mFlag
            r14 = r14 & 20
            if (r14 != r11) goto L_0x01ed
            r13.dispatchChildSelected()
        L_0x01ed:
            r13.dispatchChildSelectedAndPositioned()
            int r14 = r13.mFlag
            r14 = r14 & 64
            if (r14 == 0) goto L_0x01fd
            int r14 = r13.getSlideOutDistance()
            r13.scrollDirectionPrimary(r14)
        L_0x01fd:
            int r14 = r13.mFlag
            r14 = r14 & -4
            r13.mFlag = r14
            r13.leaveContext()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        OnLayoutCompleteListener onLayoutCompleteListener = this.mLayoutCompleteListener;
        if (onLayoutCompleteListener != null) {
            onLayoutCompleteListener.onLayoutCompleted(state);
        }
    }

    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i4, int i5) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        saveContext(recycler, state);
        if (this.mOrientation == 0) {
            size2 = View.MeasureSpec.getSize(i4);
            size = View.MeasureSpec.getSize(i5);
            mode = View.MeasureSpec.getMode(i5);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i4);
            size2 = View.MeasureSpec.getSize(i5);
            mode = View.MeasureSpec.getMode(i4);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i6 = paddingLeft + paddingRight;
        this.mMaxSizeSecondary = size;
        int i7 = this.mRowSizeSecondaryRequested;
        if (i7 == -2) {
            int i8 = this.mNumRowsRequested;
            if (i8 == 0) {
                i8 = 1;
            }
            this.mNumRows = i8;
            this.mFixedRowSizeSecondary = 0;
            int[] iArr = this.mRowSizeSecondary;
            if (iArr == null || iArr.length != i8) {
                this.mRowSizeSecondary = new int[i8];
            }
            if (this.mState.isPreLayout()) {
                updatePositionDeltaInPreLayout();
            }
            processRowSizeSecondary(true);
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(getSizeSecondary() + i6, this.mMaxSizeSecondary);
            } else if (mode == 0) {
                size = getSizeSecondary() + i6;
            } else if (mode == 1073741824) {
                size = this.mMaxSizeSecondary;
            } else {
                throw new IllegalStateException("wrong spec");
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    if (i7 == 0) {
                        i7 = size - i6;
                    }
                    this.mFixedRowSizeSecondary = i7;
                    int i9 = this.mNumRowsRequested;
                    if (i9 == 0) {
                        i9 = 1;
                    }
                    this.mNumRows = i9;
                    size = (i7 * i9) + (this.mSpacingSecondary * (i9 - 1)) + i6;
                } else if (mode != 1073741824) {
                    throw new IllegalStateException("wrong spec");
                }
            }
            int i10 = this.mNumRowsRequested;
            if (i10 == 0 && i7 == 0) {
                this.mNumRows = 1;
                this.mFixedRowSizeSecondary = size - i6;
            } else if (i10 == 0) {
                this.mFixedRowSizeSecondary = i7;
                int i11 = this.mSpacingSecondary;
                this.mNumRows = (size + i11) / (i7 + i11);
            } else if (i7 == 0) {
                this.mNumRows = i10;
                this.mFixedRowSizeSecondary = ((size - i6) - (this.mSpacingSecondary * (i10 - 1))) / i10;
            } else {
                this.mNumRows = i10;
                this.mFixedRowSizeSecondary = i7;
            }
            if (mode == Integer.MIN_VALUE) {
                int i12 = this.mFixedRowSizeSecondary;
                int i13 = this.mNumRows;
                int i14 = (i12 * i13) + (this.mSpacingSecondary * (i13 - 1)) + i6;
                if (i14 < size) {
                    size = i14;
                }
            }
        }
        if (this.mOrientation == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        leaveContext();
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        if ((this.mFlag & 32768) == 0 && getAdapterPositionByView(view) != -1 && (this.mFlag & 35) == 0) {
            scrollToView(view, view2, true);
        }
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mFocusPosition = savedState.index;
            this.mFocusPositionOffset = 0;
            this.mChildrenStates.loadFromBundle(savedState.childStates);
            this.mFlag |= 256;
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRtlPropertiesChanged(int r6) {
        /*
            r5 = this;
            int r0 = r5.mOrientation
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000d
            if (r6 != r2) goto L_0x000b
            r0 = 262144(0x40000, float:3.67342E-40)
            goto L_0x0011
        L_0x000b:
            r0 = 0
            goto L_0x0011
        L_0x000d:
            if (r6 != r2) goto L_0x000b
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x0011:
            int r3 = r5.mFlag
            r4 = 786432(0xc0000, float:1.102026E-39)
            r4 = r4 & r3
            if (r4 != r0) goto L_0x0019
            return
        L_0x0019:
            r4 = -786433(0xfffffffffff3ffff, float:NaN)
            r3 = r3 & r4
            r0 = r0 | r3
            r0 = r0 | 256(0x100, float:3.59E-43)
            r5.mFlag = r0
            androidx.leanback.widget.WindowAlignment r0 = r5.mWindowAlignment
            androidx.leanback.widget.WindowAlignment$Axis r0 = r0.horizontal
            if (r6 != r2) goto L_0x0029
            r1 = 1
        L_0x0029:
            r0.setReversedFlow(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onRtlPropertiesChanged(int):void");
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.index = getSelection();
        Bundle saveAsBundle = this.mChildrenStates.saveAsBundle();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int adapterPositionByView = getAdapterPositionByView(childAt);
            if (adapterPositionByView != -1) {
                saveAsBundle = this.mChildrenStates.saveOnScreenView(saveAsBundle, childAt, adapterPositionByView);
            }
        }
        savedState.childStates = saveAsBundle;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r5 != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r5 != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        if (r7 == androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN.getId()) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        r7 = 4096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r5, androidx.recyclerview.widget.RecyclerView.State r6, int r7, android.os.Bundle r8) {
        /*
            r4 = this;
            boolean r8 = r4.isScrollEnabled()
            r0 = 1
            if (r8 != 0) goto L_0x0008
            return r0
        L_0x0008:
            r4.saveContext(r5, r6)
            int r5 = r4.mFlag
            r6 = 262144(0x40000, float:3.67342E-40)
            r5 = r5 & r6
            r6 = 0
            if (r5 == 0) goto L_0x0015
            r5 = 1
            goto L_0x0016
        L_0x0015:
            r5 = 0
        L_0x0016:
            int r8 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 8192(0x2000, float:1.14794E-41)
            r3 = 4096(0x1000, float:5.74E-42)
            if (r8 < r1) goto L_0x004f
            int r8 = r4.mOrientation
            if (r8 != 0) goto L_0x003a
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r8 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT
            int r8 = r8.getId()
            if (r7 != r8) goto L_0x002f
            if (r5 == 0) goto L_0x0042
            goto L_0x004d
        L_0x002f:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r8 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT
            int r8 = r8.getId()
            if (r7 != r8) goto L_0x004f
            if (r5 == 0) goto L_0x004d
            goto L_0x0042
        L_0x003a:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r5 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP
            int r5 = r5.getId()
            if (r7 != r5) goto L_0x0045
        L_0x0042:
            r7 = 8192(0x2000, float:1.14794E-41)
            goto L_0x004f
        L_0x0045:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat r5 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN
            int r5 = r5.getId()
            if (r7 != r5) goto L_0x004f
        L_0x004d:
            r7 = 4096(0x1000, float:5.74E-42)
        L_0x004f:
            if (r7 == r3) goto L_0x005c
            if (r7 == r2) goto L_0x0054
            goto L_0x0062
        L_0x0054:
            r4.processPendingMovement(r6)
            r5 = -1
            r4.processSelectionMoves(r6, r5)
            goto L_0x0062
        L_0x005c:
            r4.processPendingMovement(r0)
            r4.processSelectionMoves(r6, r0)
        L_0x0062:
            r4.leaveContext()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
    }

    /* access modifiers changed from: package-private */
    public int processSelectionMoves(boolean z4, int i4) {
        int i5;
        int i6;
        Grid grid = this.mGrid;
        if (grid == null) {
            return i4;
        }
        int i7 = this.mFocusPosition;
        if (i7 != -1) {
            i5 = grid.getRowIndex(i7);
        } else {
            i5 = -1;
        }
        int childCount = getChildCount();
        View view = null;
        for (int i8 = 0; i8 < childCount && i4 != 0; i8++) {
            if (i4 > 0) {
                i6 = i8;
            } else {
                i6 = (childCount - 1) - i8;
            }
            View childAt = getChildAt(i6);
            if (canScrollTo(childAt)) {
                int adapterPositionByIndex = getAdapterPositionByIndex(i6);
                int rowIndex = this.mGrid.getRowIndex(adapterPositionByIndex);
                if (i5 == -1) {
                    i7 = adapterPositionByIndex;
                    view = childAt;
                    i5 = rowIndex;
                } else if (rowIndex == i5 && ((i4 > 0 && adapterPositionByIndex > i7) || (i4 < 0 && adapterPositionByIndex < i7))) {
                    if (i4 > 0) {
                        i4--;
                    } else {
                        i4++;
                    }
                    i7 = adapterPositionByIndex;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z4) {
                if (hasFocus()) {
                    this.mFlag |= 32;
                    view.requestFocus();
                    this.mFlag &= -33;
                }
                this.mFocusPosition = i7;
                this.mSubFocusPosition = 0;
                return i4;
            }
            scrollToView(view, true);
        }
        return i4;
    }

    public void removeAndRecycleAllViews(RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, recycler);
        }
    }

    public void removeOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList != null) {
            arrayList.remove(onChildViewHolderSelectedListener);
        }
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z4) {
        return false;
    }

    public int scrollHorizontallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5;
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        saveContext(recycler, state);
        this.mFlag = (this.mFlag & -4) | 2;
        if (this.mOrientation == 0) {
            i5 = scrollDirectionPrimary(i4);
        } else {
            i5 = scrollDirectionSecondary(i4);
        }
        leaveContext();
        this.mFlag &= -4;
        return i5;
    }

    public void scrollToPosition(int i4) {
        setSelection(i4, 0, false, 0);
    }

    /* access modifiers changed from: package-private */
    public void scrollToSelection(int i4, int i5, boolean z4, int i6) {
        this.mPrimaryScrollExtra = i6;
        View findViewByPosition = findViewByPosition(i4);
        boolean isSmoothScrolling = isSmoothScrolling();
        if (isSmoothScrolling || this.mBaseGridView.isLayoutRequested() || findViewByPosition == null || getAdapterPositionByView(findViewByPosition) != i4) {
            int i7 = this.mFlag;
            if ((i7 & 512) == 0 || (i7 & 64) != 0) {
                this.mFocusPosition = i4;
                this.mSubFocusPosition = i5;
                this.mFocusPositionOffset = Integer.MIN_VALUE;
            } else if (!z4 || this.mBaseGridView.isLayoutRequested()) {
                if (isSmoothScrolling) {
                    skipSmoothScrollerOnStopInternal();
                    this.mBaseGridView.stopScroll();
                }
                if (this.mBaseGridView.isLayoutRequested() || findViewByPosition == null || getAdapterPositionByView(findViewByPosition) != i4) {
                    this.mFocusPosition = i4;
                    this.mSubFocusPosition = i5;
                    this.mFocusPositionOffset = Integer.MIN_VALUE;
                    this.mFlag |= 256;
                    requestLayout();
                    return;
                }
                this.mFlag |= 32;
                scrollToView(findViewByPosition, z4);
                this.mFlag &= -33;
            } else {
                this.mFocusPosition = i4;
                this.mSubFocusPosition = i5;
                this.mFocusPositionOffset = Integer.MIN_VALUE;
                if (!hasDoneFirstLayout()) {
                    Log.w(getTag(), "setSelectionSmooth should not be called before first layout pass");
                    return;
                }
                int startPositionSmoothScroller = startPositionSmoothScroller(i4);
                if (startPositionSmoothScroller != this.mFocusPosition) {
                    this.mFocusPosition = startPositionSmoothScroller;
                    this.mSubFocusPosition = 0;
                }
            }
        } else {
            this.mFlag |= 32;
            scrollToView(findViewByPosition, z4);
            this.mFlag &= -33;
        }
    }

    /* access modifiers changed from: package-private */
    public void scrollToView(View view, boolean z4) {
        scrollToView(view, view == null ? null : view.findFocus(), z4);
    }

    public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i5;
        if ((this.mFlag & 512) == 0 || !hasDoneFirstLayout()) {
            return 0;
        }
        this.mFlag = (this.mFlag & -4) | 2;
        saveContext(recycler, state);
        if (this.mOrientation == 1) {
            i5 = scrollDirectionPrimary(i4);
        } else {
            i5 = scrollDirectionSecondary(i4);
        }
        leaveContext();
        this.mFlag &= -4;
        return i5;
    }

    /* access modifiers changed from: package-private */
    public void setChildrenVisibility(int i4) {
        this.mChildVisibility = i4;
        if (i4 != -1) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).setVisibility(this.mChildVisibility);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setExtraLayoutSpace(int i4) {
        int i5 = this.mExtraLayoutSpace;
        if (i5 != i4) {
            if (i5 >= 0) {
                this.mExtraLayoutSpace = i4;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("ExtraLayoutSpace must >= 0");
        }
    }

    public void setFocusOutAllowed(boolean z4, boolean z5) {
        int i4;
        int i5 = this.mFlag & -6145;
        int i6 = 0;
        if (z4) {
            i4 = 2048;
        } else {
            i4 = 0;
        }
        int i7 = i4 | i5;
        if (z5) {
            i6 = 4096;
        }
        this.mFlag = i7 | i6;
    }

    public void setFocusOutSideAllowed(boolean z4, boolean z5) {
        int i4;
        int i5 = this.mFlag & -24577;
        int i6 = 0;
        if (z4) {
            i4 = 8192;
        } else {
            i4 = 0;
        }
        int i7 = i4 | i5;
        if (z5) {
            i6 = 16384;
        }
        this.mFlag = i7 | i6;
    }

    public void setFocusScrollStrategy(int i4) {
        this.mFocusScrollStrategy = i4;
    }

    /* access modifiers changed from: package-private */
    public void setFocusSearchDisabled(boolean z4) {
        int i4;
        int i5 = this.mFlag & -32769;
        if (z4) {
            i4 = 32768;
        } else {
            i4 = 0;
        }
        this.mFlag = i4 | i5;
    }

    public void setGravity(int i4) {
        this.mGravity = i4;
    }

    public void setHorizontalSpacing(int i4) {
        if (this.mOrientation == 0) {
            this.mHorizontalSpacing = i4;
            this.mSpacingPrimary = i4;
            return;
        }
        this.mHorizontalSpacing = i4;
        this.mSpacingSecondary = i4;
    }

    public void setItemAlignmentOffset(int i4) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffset(i4);
        updateChildAlignments();
    }

    public void setItemAlignmentOffsetPercent(float f4) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetPercent(f4);
        updateChildAlignments();
    }

    public void setItemAlignmentOffsetWithPadding(boolean z4) {
        this.mItemAlignment.mainAxis().setItemAlignmentOffsetWithPadding(z4);
        updateChildAlignments();
    }

    public void setItemAlignmentViewId(int i4) {
        this.mItemAlignment.mainAxis().setItemAlignmentViewId(i4);
        updateChildAlignments();
    }

    public void setItemSpacing(int i4) {
        this.mHorizontalSpacing = i4;
        this.mVerticalSpacing = i4;
        this.mSpacingSecondary = i4;
        this.mSpacingPrimary = i4;
    }

    public void setLayoutEnabled(boolean z4) {
        boolean z5;
        int i4 = this.mFlag;
        int i5 = 0;
        if ((i4 & 512) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 != z4) {
            int i6 = i4 & -513;
            if (z4) {
                i5 = 512;
            }
            this.mFlag = i6 | i5;
            requestLayout();
        }
    }

    public void setNumRows(int i4) {
        if (i4 >= 0) {
            this.mNumRowsRequested = i4;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public void setOnChildLaidOutListener(OnChildLaidOutListener onChildLaidOutListener) {
        this.mChildLaidOutListener = onChildLaidOutListener;
    }

    public void setOnChildSelectedListener(OnChildSelectedListener onChildSelectedListener) {
        this.mChildSelectedListener = onChildSelectedListener;
    }

    public void setOnChildViewHolderSelectedListener(OnChildViewHolderSelectedListener onChildViewHolderSelectedListener) {
        if (onChildViewHolderSelectedListener == null) {
            this.mChildViewHolderSelectedListeners = null;
            return;
        }
        ArrayList<OnChildViewHolderSelectedListener> arrayList = this.mChildViewHolderSelectedListeners;
        if (arrayList == null) {
            this.mChildViewHolderSelectedListeners = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        this.mChildViewHolderSelectedListeners.add(onChildViewHolderSelectedListener);
    }

    public void setOrientation(int i4) {
        if (i4 == 0 || i4 == 1) {
            this.mOrientation = i4;
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, i4);
            this.mWindowAlignment.setOrientation(i4);
            this.mItemAlignment.setOrientation(i4);
            this.mFlag |= 256;
        }
    }

    public void setPruneChild(boolean z4) {
        boolean z5;
        int i4 = this.mFlag;
        int i5 = 65536;
        if ((i4 & 65536) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 != z4) {
            int i6 = i4 & -65537;
            if (!z4) {
                i5 = 0;
            }
            this.mFlag = i6 | i5;
            if (z4) {
                requestLayout();
            }
        }
    }

    public void setRowHeight(int i4) {
        if (i4 >= 0 || i4 == -2) {
            this.mRowSizeSecondaryRequested = i4;
            return;
        }
        throw new IllegalArgumentException("Invalid row height: " + i4);
    }

    public void setScrollEnabled(boolean z4) {
        boolean z5;
        int i4;
        int i5 = this.mFlag;
        int i6 = 0;
        if ((i5 & 131072) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 != z4) {
            int i7 = i5 & -131073;
            if (z4) {
                i6 = 131072;
            }
            int i8 = i7 | i6;
            this.mFlag = i8;
            if ((i8 & 131072) != 0 && this.mFocusScrollStrategy == 0 && (i4 = this.mFocusPosition) != -1) {
                scrollToSelection(i4, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
            }
        }
    }

    public void setSelection(int i4, int i5) {
        setSelection(i4, 0, false, i5);
    }

    public void setSelectionSmooth(int i4) {
        setSelection(i4, 0, true, 0);
    }

    public void setSelectionSmoothWithSub(int i4, int i5) {
        setSelection(i4, i5, true, 0);
    }

    public void setSelectionWithSub(int i4, int i5, int i6) {
        setSelection(i4, i5, false, i6);
    }

    public void setVerticalSpacing(int i4) {
        if (this.mOrientation == 1) {
            this.mVerticalSpacing = i4;
            this.mSpacingPrimary = i4;
            return;
        }
        this.mVerticalSpacing = i4;
        this.mSpacingSecondary = i4;
    }

    public void setWindowAlignment(int i4) {
        this.mWindowAlignment.mainAxis().setWindowAlignment(i4);
    }

    public void setWindowAlignmentOffset(int i4) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffset(i4);
    }

    public void setWindowAlignmentOffsetPercent(float f4) {
        this.mWindowAlignment.mainAxis().setWindowAlignmentOffsetPercent(f4);
    }

    /* access modifiers changed from: package-private */
    public void skipSmoothScrollerOnStopInternal() {
        GridLinearSmoothScroller gridLinearSmoothScroller = this.mCurrentSmoothScroller;
        if (gridLinearSmoothScroller != null) {
            gridLinearSmoothScroller.mSkipOnStopInternal = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void slideIn() {
        int i4 = this.mFlag;
        if ((i4 & 64) != 0) {
            this.mFlag = i4 & -65;
            int i5 = this.mFocusPosition;
            if (i5 >= 0) {
                scrollToSelection(i5, this.mSubFocusPosition, true, this.mPrimaryScrollExtra);
            } else {
                this.mFlag = i4 & -193;
                requestLayout();
            }
            int i6 = this.mFlag;
            if ((i6 & 128) != 0) {
                this.mFlag = i6 & -129;
                if (this.mBaseGridView.getScrollState() != 0 || isSmoothScrolling()) {
                    this.mBaseGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                            if (i4 == 0) {
                                GridLayoutManager.this.mBaseGridView.removeOnScrollListener(this);
                                GridLayoutManager.this.requestLayout();
                            }
                        }
                    });
                } else {
                    requestLayout();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void slideOut() {
        int i4 = this.mFlag;
        if ((i4 & 64) == 0) {
            this.mFlag = i4 | 64;
            if (getChildCount() != 0) {
                if (this.mOrientation == 1) {
                    this.mBaseGridView.smoothScrollBy(0, getSlideOutDistance(), new AccelerateDecelerateInterpolator());
                } else {
                    this.mBaseGridView.smoothScrollBy(getSlideOutDistance(), 0, new AccelerateDecelerateInterpolator());
                }
            }
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i4) {
        setSelection(i4, 0, true, 0);
    }

    /* access modifiers changed from: package-private */
    public int startPositionSmoothScroller(int i4) {
        AnonymousClass4 r02 = new GridLinearSmoothScroller() {
            public PointF computeScrollVectorForPosition(int i4) {
                int i5;
                if (getChildCount() == 0) {
                    return null;
                }
                GridLayoutManager gridLayoutManager = GridLayoutManager.this;
                int position = gridLayoutManager.getPosition(gridLayoutManager.getChildAt(0));
                GridLayoutManager gridLayoutManager2 = GridLayoutManager.this;
                if ((gridLayoutManager2.mFlag & 262144) == 0 ? i4 >= position : i4 <= position) {
                    i5 = 1;
                } else {
                    i5 = -1;
                }
                if (gridLayoutManager2.mOrientation == 0) {
                    return new PointF((float) i5, 0.0f);
                }
                return new PointF(0.0f, (float) i5);
            }
        };
        r02.setTargetPosition(i4);
        startSmoothScroll(r02);
        return r02.getTargetPosition();
    }

    public void startSmoothScroll(RecyclerView.SmoothScroller smoothScroller) {
        skipSmoothScrollerOnStopInternal();
        super.startSmoothScroll(smoothScroller);
        if (!smoothScroller.isRunning() || !(smoothScroller instanceof GridLinearSmoothScroller)) {
            this.mCurrentSmoothScroller = null;
            this.mPendingMoveSmoothScroller = null;
            return;
        }
        GridLinearSmoothScroller gridLinearSmoothScroller = (GridLinearSmoothScroller) smoothScroller;
        this.mCurrentSmoothScroller = gridLinearSmoothScroller;
        if (gridLinearSmoothScroller instanceof PendingMoveSmoothScroller) {
            this.mPendingMoveSmoothScroller = (PendingMoveSmoothScroller) gridLinearSmoothScroller;
        } else {
            this.mPendingMoveSmoothScroller = null;
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void updatePositionDeltaInPreLayout() {
        if (getChildCount() > 0) {
            this.mPositionDeltaInPreLayout = this.mGrid.getFirstVisibleIndex() - ((LayoutParams) getChildAt(0).getLayoutParams()).getViewLayoutPosition();
        } else {
            this.mPositionDeltaInPreLayout = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void updatePositionToRowMapInPostLayout() {
        Grid.Location location;
        this.mPositionToRowInPostLayout.clear();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            int oldPosition = this.mBaseGridView.getChildViewHolder(getChildAt(i4)).getOldPosition();
            if (oldPosition >= 0 && (location = this.mGrid.getLocation(oldPosition)) != null) {
                this.mPositionToRowInPostLayout.put(oldPosition, location.row);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateScrollLimits() {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z4;
        boolean z5;
        int i8;
        int i9;
        int i10;
        int i11;
        if (this.mState.getItemCount() != 0) {
            if ((this.mFlag & 262144) == 0) {
                i7 = this.mGrid.getLastVisibleIndex();
                i6 = this.mState.getItemCount() - 1;
                i4 = this.mGrid.getFirstVisibleIndex();
                i5 = 0;
            } else {
                i7 = this.mGrid.getFirstVisibleIndex();
                i4 = this.mGrid.getLastVisibleIndex();
                i5 = this.mState.getItemCount() - 1;
                i6 = 0;
            }
            if (i7 >= 0 && i4 >= 0) {
                if (i7 == i6) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i4 == i5) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 || !this.mWindowAlignment.mainAxis().isMaxUnknown() || z5 || !this.mWindowAlignment.mainAxis().isMinUnknown()) {
                    if (z4) {
                        i9 = this.mGrid.findRowMax(true, sTwoInts);
                        View findViewByPosition = findViewByPosition(sTwoInts[1]);
                        i8 = getViewCenter(findViewByPosition);
                        int[] alignMultiple = ((LayoutParams) findViewByPosition.getLayoutParams()).getAlignMultiple();
                        if (alignMultiple != null && alignMultiple.length > 0) {
                            i8 += alignMultiple[alignMultiple.length - 1] - alignMultiple[0];
                        }
                    } else {
                        i9 = Integer.MAX_VALUE;
                        i8 = Integer.MAX_VALUE;
                    }
                    if (z5) {
                        i11 = this.mGrid.findRowMin(false, sTwoInts);
                        i10 = getViewCenter(findViewByPosition(sTwoInts[1]));
                    } else {
                        i11 = Integer.MIN_VALUE;
                        i10 = Integer.MIN_VALUE;
                    }
                    this.mWindowAlignment.mainAxis().updateMinMax(i11, i9, i10, i8);
                }
            }
        }
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void scrollToView(View view, boolean z4, int i4, int i5) {
        scrollToView(view, view == null ? null : view.findFocus(), z4, i4, i5);
    }

    public void setSelection(int i4, int i5, boolean z4, int i6) {
        if ((this.mFocusPosition != i4 && i4 != -1) || i5 != this.mSubFocusPosition || i6 != this.mPrimaryScrollExtra) {
            scrollToSelection(i4, i5, z4, i6);
        }
    }

    private void scrollToView(View view, View view2, boolean z4) {
        scrollToView(view, view2, z4, 0, 0);
    }

    static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i4) {
                return new SavedState[i4];
            }
        };
        Bundle childStates = Bundle.EMPTY;
        int index;

        SavedState(Parcel parcel) {
            this.index = parcel.readInt();
            this.childStates = parcel.readBundle(GridLayoutManager.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.index);
            parcel.writeBundle(this.childStates);
        }

        SavedState() {
        }
    }

    private void scrollToView(View view, View view2, boolean z4, int i4, int i5) {
        if ((this.mFlag & 64) == 0) {
            int adapterPositionByView = getAdapterPositionByView(view);
            int subPositionByView = getSubPositionByView(view, view2);
            if (!(adapterPositionByView == this.mFocusPosition && subPositionByView == this.mSubFocusPosition)) {
                this.mFocusPosition = adapterPositionByView;
                this.mSubFocusPosition = subPositionByView;
                this.mFocusPositionOffset = 0;
                if ((this.mFlag & 3) != 1) {
                    dispatchChildSelected();
                }
                if (this.mBaseGridView.isChildrenDrawingOrderEnabledInternal()) {
                    this.mBaseGridView.invalidate();
                }
            }
            if (view != null) {
                if (!view.hasFocus() && this.mBaseGridView.hasFocus()) {
                    view.requestFocus();
                }
                if ((this.mFlag & 131072) == 0 && z4) {
                    return;
                }
                if (getScrollPosition(view, view2, sTwoInts) || i4 != 0 || i5 != 0) {
                    int[] iArr = sTwoInts;
                    scrollGrid(iArr[0] + i4, iArr[1] + i5, z4);
                }
            }
        }
    }

    private void updateChildAlignments() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            updateChildAlignments(getChildAt(i4));
        }
    }
}
