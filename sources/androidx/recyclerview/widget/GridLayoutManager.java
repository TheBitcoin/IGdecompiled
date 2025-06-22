package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i4, int i5) {
            return i4 % i5;
        }

        public int getSpanSize(int i4) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i4) {
            int size = sparseIntArray.size() - 1;
            int i5 = 0;
            while (i5 <= size) {
                int i6 = (i5 + size) >>> 1;
                if (sparseIntArray.keyAt(i6) < i4) {
                    i5 = i6 + 1;
                } else {
                    size = i6 - 1;
                }
            }
            int i7 = i5 - 1;
            if (i7 < 0 || i7 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i7);
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanGroupIndex(int i4, int i5) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i4, i5);
            }
            int i6 = this.mSpanGroupIndexCache.get(i4, -1);
            if (i6 != -1) {
                return i6;
            }
            int spanGroupIndex = getSpanGroupIndex(i4, i5);
            this.mSpanGroupIndexCache.put(i4, spanGroupIndex);
            return spanGroupIndex;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i4, int i5) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i4, i5);
            }
            int i6 = this.mSpanIndexCache.get(i4, -1);
            if (i6 != -1) {
                return i6;
            }
            int spanIndex = getSpanIndex(i4, i5);
            this.mSpanIndexCache.put(i4, spanIndex);
            return spanIndex;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanGroupIndex(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.mCacheSpanGroupIndices
                r1 = 0
                if (r0 == 0) goto L_0x0025
                android.util.SparseIntArray r0 = r6.mSpanGroupIndexCache
                int r0 = findFirstKeyLessThan(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0025
                android.util.SparseIntArray r2 = r6.mSpanGroupIndexCache
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.getCachedSpanIndex(r0, r8)
                int r0 = r6.getSpanSize(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0028
                int r2 = r2 + 1
            L_0x0023:
                r4 = 0
                goto L_0x0028
            L_0x0025:
                r2 = 0
                r3 = 0
                goto L_0x0023
            L_0x0028:
                int r0 = r6.getSpanSize(r7)
            L_0x002c:
                if (r3 >= r7) goto L_0x0041
                int r5 = r6.getSpanSize(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0039
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003e
            L_0x0039:
                if (r4 <= r8) goto L_0x003e
                int r2 = r2 + 1
                r4 = r5
            L_0x003e:
                int r3 = r3 + 1
                goto L_0x002c
            L_0x0041:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0046
                int r2 = r2 + 1
            L_0x0046:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanGroupIndex(int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i4);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z4) {
            if (!z4) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z4;
        }

        public void setSpanIndexCacheEnabled(boolean z4) {
            if (!z4) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z4;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i4, i5).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i4, boolean z4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (z4) {
            i5 = i4;
            i6 = 0;
            i7 = 1;
        } else {
            i6 = i4 - 1;
            i5 = -1;
            i7 = -1;
        }
        while (i6 != i5) {
            View view = this.mSet[i6];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i8;
            i8 += spanSize;
            i6 += i7;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i4) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i4);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        int i4;
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    i4 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i4 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i4;
                }
                return Math.round((((float) i4) * (((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.getItemCount() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((((float) decoratedEnd) / ((float) ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1))) * ((float) (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1)));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i4) {
        boolean z4;
        if (i4 == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z4) {
            while (spanIndex > 0) {
                int i5 = anchorInfo.mPosition;
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    anchorInfo.mPosition = i6;
                    spanIndex = getSpanIndex(recycler, state, i6);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i7 = anchorInfo.mPosition;
        while (i7 < itemCount) {
            int i8 = i7 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i8);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i7 = i8;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i7;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i4) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i4, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i4);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i4);
        return 0;
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i4) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i4, this.mSpanCount);
        }
        int i5 = this.mPreLayoutSpanIndexCache.get(i4, -1);
        if (i5 != -1) {
            return i5;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i4);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
        return 0;
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i4) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i4);
        }
        int i5 = this.mPreLayoutSpanSizeCache.get(i4, -1);
        if (i5 != -1) {
            return i5;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i4);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i4);
        return 1;
    }

    private void guessMeasurement(float f4, int i4) {
        calculateItemBorders(Math.max(Math.round(f4 * ((float) this.mSpanCount)), i4));
    }

    private void measureChild(View view, int i4, boolean z4) {
        int i5;
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i7 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i8 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i5 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i4, i8, layoutParams.width, false);
            i6 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i7, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i4, i7, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i8, layoutParams.width, true);
            i6 = childMeasureSpec;
            i5 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i5, i6, z4);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i4, int i5, boolean z4) {
        boolean z5;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z4) {
            z5 = shouldReMeasureChild(view, i4, i5, layoutParams);
        } else {
            z5 = shouldMeasureChild(view, i4, i5, layoutParams);
        }
        if (z5) {
            view.measure(i4, i5);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i4 = this.mSpanCount;
        for (int i5 = 0; i5 < this.mSpanCount && layoutState.hasMore(state) && i4 > 0; i5++) {
            int i6 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i6, Math.max(0, layoutState.mScrollingOffset));
            i4 -= this.mSpanSizeLookup.getSpanSize(i6);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z4, boolean z5) {
        int i4;
        int i5;
        int childCount = getChildCount();
        int i6 = 1;
        if (z5) {
            i5 = getChildCount() - 1;
            i4 = -1;
            i6 = -1;
        } else {
            i4 = childCount;
            i5 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i5 != i4) {
            View childAt = getChildAt(i5);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i5 += i6;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    /* access modifiers changed from: package-private */
    public int getSpaceForSpanRange(int i4, int i5) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i5 + i4] - iArr[i4];
        }
        int[] iArr2 = this.mCachedBorders;
        int i6 = this.mSpanCount;
        return iArr2[i6 - i4] - iArr2[(i6 - i4) - i5];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        View next;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (getChildCount() > 0) {
            i4 = this.mCachedBorders[this.mSpanCount];
        } else {
            i4 = 0;
        }
        if (z4) {
            updateMeasurements();
        }
        if (layoutState2.mItemDirection == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        int i14 = this.mSpanCount;
        if (!z5) {
            i14 = getSpanIndex(recycler2, state2, layoutState2.mCurrentPosition) + getSpanSize(recycler2, state2, layoutState2.mCurrentPosition);
        }
        int i15 = 0;
        while (i15 < this.mSpanCount && layoutState2.hasMore(state2) && i14 > 0) {
            int i16 = layoutState2.mCurrentPosition;
            int spanSize = getSpanSize(recycler2, state2, i16);
            if (spanSize <= this.mSpanCount) {
                i14 -= spanSize;
                if (i14 < 0 || (next = layoutState2.next(recycler2)) == null) {
                    break;
                }
                this.mSet[i15] = next;
                i15++;
            } else {
                throw new IllegalArgumentException("Item at position " + i16 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (i15 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        assignSpans(recycler2, state2, i15, z5);
        float f4 = 0.0f;
        int i17 = 0;
        for (int i18 = 0; i18 < i15; i18++) {
            View view = this.mSet[i18];
            if (layoutState2.mScrapList == null) {
                if (z5) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z5) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i17) {
                i17 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f4) {
                f4 = decoratedMeasurementInOther;
            }
        }
        if (z4) {
            guessMeasurement(f4, i4);
            i17 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view2 = this.mSet[i19];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i17) {
                    i17 = decoratedMeasurement2;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view3 = this.mSet[i20];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i17) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i21 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i22 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i13 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i22, layoutParams.width, false);
                    i12 = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i22, 1073741824);
                    i12 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i21, layoutParams.height, false);
                    i13 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i13, i12, true);
            }
        }
        layoutChunkResult2.mConsumed = i17;
        if (this.mOrientation == 1) {
            if (layoutState2.mLayoutDirection == -1) {
                i8 = layoutState2.mOffset;
                i11 = i8 - i17;
            } else {
                i11 = layoutState2.mOffset;
                i8 = i11 + i17;
            }
            i5 = i11;
            i7 = 0;
            i6 = 0;
        } else {
            if (layoutState2.mLayoutDirection == -1) {
                i10 = layoutState2.mOffset;
                i9 = i10 - i17;
            } else {
                i9 = layoutState2.mOffset;
                i10 = i9 + i17;
            }
            i6 = i9;
            i5 = 0;
            i7 = i10;
            i8 = 0;
        }
        for (int i23 = 0; i23 < i15; i23++) {
            View view4 = this.mSet[i23];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                i5 = this.mCachedBorders[layoutParams2.mSpanIndex] + getPaddingTop();
                i8 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + i5;
            } else if (isLayoutRTL()) {
                i7 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i6 = i7 - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
            } else {
                i6 = this.mCachedBorders[layoutParams2.mSpanIndex] + getPaddingLeft();
                i7 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + i6;
            }
            View view5 = view4;
            int i24 = i8;
            View view6 = view5;
            int i25 = i5;
            int i26 = i7;
            int i27 = i6;
            int i28 = i25;
            layoutDecoratedWithMargins(view6, i27, i28, i26, i24);
            int i29 = i24;
            View view7 = view6;
            i8 = i29;
            int i30 = i28;
            i6 = i27;
            i7 = i26;
            i5 = i30;
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult2.mIgnoreConsumed = true;
            }
            layoutChunkResult2.mFocusable = view7.hasFocusable() | layoutChunkResult2.mFocusable;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i4) {
        super.onAnchorReady(recycler, state, anchorInfo, i4);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i4);
        }
        ensureViewSet();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d3, code lost:
        if (r13 == r4) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f3, code lost:
        if (r13 == r8) goto L_0x00f5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0111  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.mSpanIndex
            int r5 = r5.mSpanSize
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            r11 = -1
            if (r7 == r10) goto L_0x0039
            int r7 = r0.getChildCount()
            int r7 = r7 - r9
            r10 = -1
            r12 = -1
            goto L_0x0040
        L_0x0039:
            int r7 = r0.getChildCount()
            r10 = r7
            r7 = 0
            r12 = 1
        L_0x0040:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x004c
            boolean r13 = r0.isLayoutRTL()
            if (r13 == 0) goto L_0x004c
            r13 = 1
            goto L_0x004d
        L_0x004c:
            r13 = 0
        L_0x004d:
            int r14 = r0.getSpanGroupIndex(r1, r2, r7)
            r11 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x0059:
            if (r11 == r10) goto L_0x0065
            int r9 = r0.getSpanGroupIndex(r1, r2, r11)
            android.view.View r1 = r0.getChildAt(r11)
            if (r1 != r3) goto L_0x006b
        L_0x0065:
            r21 = r4
            r19 = r7
            goto L_0x0138
        L_0x006b:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0084
            if (r9 == r14) goto L_0x0084
            if (r4 == 0) goto L_0x0076
            goto L_0x0065
        L_0x0076:
            r18 = r3
            r21 = r4
        L_0x007a:
            r19 = r7
            r20 = r8
        L_0x007e:
            r4 = r16
            r7 = r17
            goto L_0x0127
        L_0x0084:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.mSpanIndex
            r18 = r3
            int r3 = r9.mSpanSize
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009c
            if (r2 != r6) goto L_0x009c
            if (r3 != r5) goto L_0x009c
            return r1
        L_0x009c:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a4
            if (r4 == 0) goto L_0x00ac
        L_0x00a4:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b7
            if (r7 != 0) goto L_0x00b7
        L_0x00ac:
            r21 = r4
        L_0x00ae:
            r19 = r7
            r20 = r8
            r4 = r16
            r7 = r17
            goto L_0x00f5
        L_0x00b7:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r4
            int r4 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d6
            if (r4 <= r8) goto L_0x00cc
        L_0x00cb:
            goto L_0x00ae
        L_0x00cc:
            if (r4 != r8) goto L_0x007a
            if (r2 <= r15) goto L_0x00d2
            r4 = 1
            goto L_0x00d3
        L_0x00d2:
            r4 = 0
        L_0x00d3:
            if (r13 != r4) goto L_0x007a
            goto L_0x00cb
        L_0x00d6:
            if (r21 != 0) goto L_0x007a
            r19 = r7
            r20 = r8
            r7 = 0
            r8 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r7, r8)
            if (r22 == 0) goto L_0x007e
            r7 = r17
            if (r4 <= r7) goto L_0x00eb
            r4 = r16
            goto L_0x00f5
        L_0x00eb:
            if (r4 != r7) goto L_0x0125
            r4 = r16
            if (r2 <= r4) goto L_0x00f2
            goto L_0x00f3
        L_0x00f2:
            r8 = 0
        L_0x00f3:
            if (r13 != r8) goto L_0x0127
        L_0x00f5:
            boolean r8 = r1.hasFocusable()
            if (r8 == 0) goto L_0x0111
            int r8 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r16 = r4
            r17 = r7
            r15 = r8
            r7 = r19
            r4 = r1
            r8 = r2
            goto L_0x012e
        L_0x0111:
            int r4 = r9.mSpanIndex
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r7 = r1
            r16 = r4
        L_0x0120:
            r8 = r20
            r4 = r21
            goto L_0x012e
        L_0x0125:
            r4 = r16
        L_0x0127:
            r16 = r4
            r17 = r7
            r7 = r19
            goto L_0x0120
        L_0x012e:
            int r11 = r11 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r9 = 1
            goto L_0x0059
        L_0x0138:
            if (r21 == 0) goto L_0x013b
            return r21
        L_0x013b:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
            return;
        }
        int i4 = spanGroupIndex;
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i4, int i5) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i4, int i5, int i6) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i4, int i5) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i4, int i5, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i4, recycler, state);
    }

    public int scrollVerticallyBy(int i4, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i4, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i4, int i5) {
        int i6;
        int i7;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i4, i5);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i7 = RecyclerView.LayoutManager.chooseSize(i5, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i6 = RecyclerView.LayoutManager.chooseSize(i4, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i6 = RecyclerView.LayoutManager.chooseSize(i4, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i7 = RecyclerView.LayoutManager.chooseSize(i5, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i6, i7);
    }

    public void setSpanCount(int i4) {
        if (i4 != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i4 >= 1) {
                this.mSpanCount = i4;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i4);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z4) {
        if (!z4) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z4) {
        this.mUsingSpansToEstimateScrollBarDimensions = z4;
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.mPendingSpanCountChange) {
            return false;
        }
        return true;
    }

    static int[] calculateItemBorders(int[] iArr, int i4, int i5) {
        int i6;
        if (!(iArr != null && iArr.length == i4 + 1 && iArr[iArr.length - 1] == i5)) {
            iArr = new int[(i4 + 1)];
        }
        int i7 = 0;
        iArr[0] = 0;
        int i8 = i5 / i4;
        int i9 = i5 % i4;
        int i10 = 0;
        for (int i11 = 1; i11 <= i4; i11++) {
            i7 += i9;
            if (i7 <= 0 || i4 - i7 >= i9) {
                i6 = i8;
            } else {
                i6 = i8 + 1;
                i7 -= i4;
            }
            i10 += i6;
            iArr[i11] = i10;
        }
        return iArr;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
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
    }

    public GridLayoutManager(Context context, int i4) {
        super(context);
        setSpanCount(i4);
    }

    public GridLayoutManager(Context context, int i4, int i5, boolean z4) {
        super(context, i5, z4);
        setSpanCount(i4);
    }
}
