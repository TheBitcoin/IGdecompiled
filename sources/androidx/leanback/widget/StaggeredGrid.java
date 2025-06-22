package androidx.leanback.widget;

import androidx.collection.CircularArray;
import androidx.collection.CircularIntArray;
import androidx.leanback.widget.Grid;
import java.io.PrintWriter;

abstract class StaggeredGrid extends Grid {
    protected int mFirstIndex = -1;
    protected CircularArray<Location> mLocations = new CircularArray<>(64);
    protected Object mPendingItem;
    protected int mPendingItemSize;

    public static class Location extends Grid.Location {
        public int offset;
        public int size;

        public Location(int i4, int i5, int i6) {
            super(i4);
            this.offset = i5;
            this.size = i6;
        }
    }

    StaggeredGrid() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int calculateOffsetAfterLastItem(int r3) {
        /*
            r2 = this;
            int r0 = r2.getLastIndex()
        L_0x0004:
            int r1 = r2.mFirstIndex
            if (r0 < r1) goto L_0x0014
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation((int) r0)
            int r1 = r1.row
            if (r1 != r3) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            int r0 = r0 + -1
            goto L_0x0004
        L_0x0014:
            int r0 = r2.getLastIndex()
        L_0x0018:
            boolean r3 = r2.isReversedFlow()
            if (r3 == 0) goto L_0x0028
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation((int) r0)
            int r3 = r3.size
            int r3 = -r3
            int r1 = r2.mSpacing
            goto L_0x003f
        L_0x0028:
            androidx.leanback.widget.StaggeredGrid$Location r3 = r2.getLocation((int) r0)
            int r3 = r3.size
            int r1 = r2.mSpacing
            int r3 = r3 + r1
        L_0x0031:
            int r0 = r0 + 1
            int r1 = r2.getLastIndex()
            if (r0 > r1) goto L_0x0041
            androidx.leanback.widget.StaggeredGrid$Location r1 = r2.getLocation((int) r0)
            int r1 = r1.offset
        L_0x003f:
            int r3 = r3 - r1
            goto L_0x0031
        L_0x0041:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGrid.calculateOffsetAfterLastItem(int):int");
    }

    /* access modifiers changed from: protected */
    public final boolean appendVisbleItemsWithCache(int i4, boolean z4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int count = this.mProvider.getCount();
        int i9 = this.mLastVisibleIndex;
        if (i9 >= 0) {
            i5 = i9 + 1;
            i6 = this.mProvider.getEdge(i9);
        } else {
            int i10 = this.mStartIndex;
            if (i10 != -1) {
                i5 = i10;
            } else {
                i5 = 0;
            }
            if (i5 > getLastIndex() + 1 || i5 < getFirstIndex()) {
                this.mLocations.clear();
                return false;
            } else if (i5 > getLastIndex()) {
                return false;
            } else {
                i6 = Integer.MAX_VALUE;
            }
        }
        int lastIndex = getLastIndex();
        int i11 = i5;
        while (i11 < count && i11 <= lastIndex) {
            Location location = getLocation(i11);
            if (i6 != Integer.MAX_VALUE) {
                i6 += location.offset;
            }
            int i12 = i6;
            int i13 = location.row;
            int createItem = this.mProvider.createItem(i11, true, this.mTmpItem, false);
            if (createItem != location.size) {
                location.size = createItem;
                this.mLocations.removeFromEnd(lastIndex - i11);
                i7 = i11;
            } else {
                i7 = lastIndex;
            }
            this.mLastVisibleIndex = i11;
            if (this.mFirstVisibleIndex < 0) {
                this.mFirstVisibleIndex = i11;
            }
            this.mProvider.addItem(this.mTmpItem[0], i11, createItem, i13, i12);
            if (!z4 && checkAppendOverLimit(i4)) {
                return true;
            }
            if (i12 == Integer.MAX_VALUE) {
                i8 = this.mProvider.getEdge(i11);
            } else {
                i8 = i12;
            }
            if (i13 == this.mNumRows - 1 && z4) {
                return true;
            }
            i11++;
            lastIndex = i7;
            i6 = i8;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int appendVisibleItemToRow(int i4, int i5, int i6) {
        int i7;
        int i8 = this.mLastVisibleIndex;
        if (i8 < 0 || (i8 == getLastIndex() && this.mLastVisibleIndex == i4 - 1)) {
            int i9 = this.mLastVisibleIndex;
            if (i9 >= 0) {
                i7 = i6 - this.mProvider.getEdge(i9);
            } else if (this.mLocations.size() <= 0 || i4 != getLastIndex() + 1) {
                i7 = 0;
            } else {
                i7 = calculateOffsetAfterLastItem(i5);
            }
            Location location = new Location(i5, i7, 0);
            this.mLocations.addLast(location);
            Object obj = this.mPendingItem;
            if (obj != null) {
                location.size = this.mPendingItemSize;
                this.mPendingItem = null;
            } else {
                location.size = this.mProvider.createItem(i4, true, this.mTmpItem, false);
                obj = this.mTmpItem[0];
            }
            Object obj2 = obj;
            if (this.mLocations.size() == 1) {
                this.mLastVisibleIndex = i4;
                this.mFirstVisibleIndex = i4;
                this.mFirstIndex = i4;
            } else {
                int i10 = this.mLastVisibleIndex;
                if (i10 < 0) {
                    this.mLastVisibleIndex = i4;
                    this.mFirstVisibleIndex = i4;
                } else {
                    this.mLastVisibleIndex = i10 + 1;
                }
            }
            this.mProvider.addItem(obj2, i4, location.size, i5, i6);
            return location.size;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final boolean appendVisibleItems(int i4, boolean z4) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkAppendOverLimit(i4)) {
            return false;
        }
        try {
            if (appendVisbleItemsWithCache(i4, z4)) {
                this.mTmpItem[0] = null;
                this.mPendingItem = null;
                return true;
            }
            boolean appendVisibleItemsWithoutCache = appendVisibleItemsWithoutCache(i4, z4);
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return appendVisibleItemsWithoutCache;
        } catch (Throwable th) {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean appendVisibleItemsWithoutCache(int i4, boolean z4);

    public final void debugPrint(PrintWriter printWriter) {
        int size = this.mLocations.size();
        for (int i4 = 0; i4 < size; i4++) {
            printWriter.print("<" + (this.mFirstIndex + i4) + "," + this.mLocations.get(i4).row + ">");
            printWriter.print(" ");
            printWriter.println();
        }
    }

    public final int getFirstIndex() {
        return this.mFirstIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows(int i4, int i5) {
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            this.mTmpItemPositionsInRows[i6].clear();
        }
        if (i4 >= 0) {
            while (i4 <= i5) {
                CircularIntArray circularIntArray = this.mTmpItemPositionsInRows[getLocation(i4).row];
                if (circularIntArray.size() <= 0 || circularIntArray.getLast() != i4 - 1) {
                    circularIntArray.addLast(i4);
                    circularIntArray.addLast(i4);
                } else {
                    circularIntArray.popLast();
                    circularIntArray.addLast(i4);
                }
                i4++;
            }
        }
        return this.mTmpItemPositionsInRows;
    }

    public final int getLastIndex() {
        return (this.mFirstIndex + this.mLocations.size()) - 1;
    }

    public final int getSize() {
        return this.mLocations.size();
    }

    public void invalidateItemsAfter(int i4) {
        super.invalidateItemsAfter(i4);
        this.mLocations.removeFromEnd((getLastIndex() - i4) + 1);
        if (this.mLocations.size() == 0) {
            this.mFirstIndex = -1;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean prependVisbleItemsWithCache(int i4, boolean z4) {
        int i5;
        int i6;
        int i7;
        if (this.mLocations.size() == 0) {
            return false;
        }
        int i8 = this.mFirstVisibleIndex;
        if (i8 >= 0) {
            i7 = this.mProvider.getEdge(i8);
            i6 = getLocation(this.mFirstVisibleIndex).offset;
            i5 = this.mFirstVisibleIndex - 1;
        } else {
            int i9 = this.mStartIndex;
            if (i9 != -1) {
                i5 = i9;
            } else {
                i5 = 0;
            }
            if (i5 > getLastIndex() || i5 < getFirstIndex() - 1) {
                this.mLocations.clear();
                return false;
            } else if (i5 < getFirstIndex()) {
                return false;
            } else {
                i7 = Integer.MAX_VALUE;
                i6 = 0;
            }
        }
        int max = Math.max(this.mProvider.getMinIndex(), this.mFirstIndex);
        for (int i10 = i5; i10 >= max; i10--) {
            Location location = getLocation(i10);
            int i11 = location.row;
            int createItem = this.mProvider.createItem(i10, false, this.mTmpItem, false);
            if (createItem != location.size) {
                this.mLocations.removeFromStart((i10 + 1) - this.mFirstIndex);
                this.mFirstIndex = this.mFirstVisibleIndex;
                this.mPendingItem = this.mTmpItem[0];
                this.mPendingItemSize = createItem;
                return false;
            }
            this.mFirstVisibleIndex = i10;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i10;
            }
            this.mProvider.addItem(this.mTmpItem[0], i10, createItem, i11, i7 - i6);
            if (!z4 && checkPrependOverLimit(i4)) {
                return true;
            }
            i7 = this.mProvider.getEdge(i10);
            i6 = location.offset;
            if (i11 == 0 && z4) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int prependVisibleItemToRow(int i4, int i5, int i6) {
        Location location;
        int i7;
        int i8 = this.mFirstVisibleIndex;
        if (i8 < 0 || (i8 == getFirstIndex() && this.mFirstVisibleIndex == i4 + 1)) {
            int i9 = this.mFirstIndex;
            if (i9 >= 0) {
                location = getLocation(i9);
            } else {
                location = null;
            }
            int edge = this.mProvider.getEdge(this.mFirstIndex);
            Location location2 = new Location(i5, 0, 0);
            this.mLocations.addFirst(location2);
            Object obj = this.mPendingItem;
            if (obj != null) {
                location2.size = this.mPendingItemSize;
                this.mPendingItem = null;
            } else {
                location2.size = this.mProvider.createItem(i4, false, this.mTmpItem, false);
                obj = this.mTmpItem[0];
            }
            Object obj2 = obj;
            this.mFirstVisibleIndex = i4;
            this.mFirstIndex = i4;
            if (this.mLastVisibleIndex < 0) {
                this.mLastVisibleIndex = i4;
            }
            if (!this.mReversedFlow) {
                i7 = i6 - location2.size;
            } else {
                i7 = i6 + location2.size;
            }
            int i10 = i7;
            if (location != null) {
                location.offset = edge - i10;
            }
            this.mProvider.addItem(obj2, i4, location2.size, i5, i10);
            return location2.size;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final boolean prependVisibleItems(int i4, boolean z4) {
        if (this.mProvider.getCount() == 0) {
            return false;
        }
        if (!z4 && checkPrependOverLimit(i4)) {
            return false;
        }
        try {
            if (prependVisbleItemsWithCache(i4, z4)) {
                this.mTmpItem[0] = null;
                this.mPendingItem = null;
                return true;
            }
            boolean prependVisibleItemsWithoutCache = prependVisibleItemsWithoutCache(i4, z4);
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            return prependVisibleItemsWithoutCache;
        } catch (Throwable th) {
            this.mTmpItem[0] = null;
            this.mPendingItem = null;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean prependVisibleItemsWithoutCache(int i4, boolean z4);

    public final Location getLocation(int i4) {
        int i5 = i4 - this.mFirstIndex;
        if (i5 < 0 || i5 >= this.mLocations.size()) {
            return null;
        }
        return this.mLocations.get(i5);
    }
}
