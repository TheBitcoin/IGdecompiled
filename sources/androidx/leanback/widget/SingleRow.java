package androidx.leanback.widget;

import androidx.annotation.NonNull;
import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;

class SingleRow extends Grid {
    private final Grid.Location mTmpLocation = new Grid.Location(0);

    SingleRow() {
        setNumRows(1);
    }

    /* access modifiers changed from: protected */
    public final boolean appendVisibleItems(int i4, boolean z4) {
        int i5;
        int i6;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkAppendOverLimit(i4)) {
            return false;
        }
        int startIndexForAppend = getStartIndexForAppend();
        boolean z5 = false;
        while (startIndexForAppend < this.mProvider.getCount()) {
            int createItem = this.mProvider.createItem(startIndexForAppend, true, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                if (this.mReversedFlow) {
                    i6 = Integer.MAX_VALUE;
                } else {
                    i6 = Integer.MIN_VALUE;
                }
                this.mFirstVisibleIndex = startIndexForAppend;
                this.mLastVisibleIndex = startIndexForAppend;
            } else {
                if (this.mReversedFlow) {
                    int i7 = startIndexForAppend - 1;
                    i5 = (this.mProvider.getEdge(i7) - this.mProvider.getSize(i7)) - this.mSpacing;
                } else {
                    int i8 = startIndexForAppend - 1;
                    i5 = this.mProvider.getEdge(i8) + this.mProvider.getSize(i8) + this.mSpacing;
                }
                this.mLastVisibleIndex = startIndexForAppend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForAppend, createItem, 0, i5);
            if (z4 || checkAppendOverLimit(i4)) {
                return true;
            }
            startIndexForAppend++;
            z5 = true;
        }
        return z5;
    }

    public void collectAdjacentPrefetchPositions(int i4, int i5, @NonNull RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i6;
        int i7;
        int i8;
        if (!this.mReversedFlow ? i5 >= 0 : i5 <= 0) {
            if (getLastVisibleIndex() != this.mProvider.getCount() - 1) {
                i6 = getStartIndexForAppend();
                int size = this.mProvider.getSize(this.mLastVisibleIndex) + this.mSpacing;
                int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
                if (this.mReversedFlow) {
                    size = -size;
                }
                i7 = size + edge;
            } else {
                return;
            }
        } else if (getFirstVisibleIndex() != 0) {
            i6 = getStartIndexForPrepend();
            int edge2 = this.mProvider.getEdge(this.mFirstVisibleIndex);
            if (this.mReversedFlow) {
                i8 = this.mSpacing;
            } else {
                i8 = -this.mSpacing;
            }
            i7 = edge2 + i8;
        } else {
            return;
        }
        layoutPrefetchRegistry.addPosition(i6, Math.abs(i7 - i4));
    }

    public final void debugPrint(PrintWriter printWriter) {
        printWriter.print("SingleRow<");
        printWriter.print(this.mFirstVisibleIndex);
        printWriter.print(",");
        printWriter.print(this.mLastVisibleIndex);
        printWriter.print(">");
        printWriter.println();
    }

    /* access modifiers changed from: protected */
    public final int findRowMax(boolean z4, int i4, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i4;
        }
        if (this.mReversedFlow) {
            return this.mProvider.getEdge(i4);
        }
        return this.mProvider.getEdge(i4) + this.mProvider.getSize(i4);
    }

    /* access modifiers changed from: protected */
    public final int findRowMin(boolean z4, int i4, int[] iArr) {
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = i4;
        }
        if (this.mReversedFlow) {
            return this.mProvider.getEdge(i4) - this.mProvider.getSize(i4);
        }
        return this.mProvider.getEdge(i4);
    }

    public final CircularIntArray[] getItemPositionsInRows(int i4, int i5) {
        this.mTmpItemPositionsInRows[0].clear();
        this.mTmpItemPositionsInRows[0].addLast(i4);
        this.mTmpItemPositionsInRows[0].addLast(i5);
        return this.mTmpItemPositionsInRows;
    }

    public final Grid.Location getLocation(int i4) {
        return this.mTmpLocation;
    }

    /* access modifiers changed from: package-private */
    public int getStartIndexForAppend() {
        int i4 = this.mLastVisibleIndex;
        if (i4 >= 0) {
            return i4 + 1;
        }
        int i5 = this.mStartIndex;
        if (i5 != -1) {
            return Math.min(i5, this.mProvider.getCount() - 1);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getStartIndexForPrepend() {
        int i4 = this.mFirstVisibleIndex;
        if (i4 >= 0) {
            return i4 - 1;
        }
        int i5 = this.mStartIndex;
        if (i5 != -1) {
            return Math.min(i5, this.mProvider.getCount() - 1);
        }
        return this.mProvider.getCount() - 1;
    }

    /* access modifiers changed from: protected */
    public final boolean prependVisibleItems(int i4, boolean z4) {
        int i5;
        int i6;
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkPrependOverLimit(i4)) {
            return false;
        }
        int minIndex = this.mProvider.getMinIndex();
        boolean z5 = false;
        for (int startIndexForPrepend = getStartIndexForPrepend(); startIndexForPrepend >= minIndex; startIndexForPrepend--) {
            int createItem = this.mProvider.createItem(startIndexForPrepend, false, this.mTmpItem, false);
            if (this.mFirstVisibleIndex < 0 || this.mLastVisibleIndex < 0) {
                if (this.mReversedFlow) {
                    i6 = Integer.MIN_VALUE;
                } else {
                    i6 = Integer.MAX_VALUE;
                }
                this.mFirstVisibleIndex = startIndexForPrepend;
                this.mLastVisibleIndex = startIndexForPrepend;
            } else {
                if (this.mReversedFlow) {
                    i5 = this.mProvider.getEdge(startIndexForPrepend + 1) + this.mSpacing + createItem;
                } else {
                    i5 = (this.mProvider.getEdge(startIndexForPrepend + 1) - this.mSpacing) - createItem;
                }
                this.mFirstVisibleIndex = startIndexForPrepend;
            }
            this.mProvider.addItem(this.mTmpItem[0], startIndexForPrepend, createItem, 0, i5);
            z5 = true;
            if (z4 || checkPrependOverLimit(i4)) {
                break;
            }
        }
        return z5;
    }
}
