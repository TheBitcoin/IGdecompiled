package androidx.leanback.widget;

import androidx.leanback.widget.StaggeredGrid;

final class StaggeredGridDefault extends StaggeredGrid {
    StaggeredGridDefault() {
    }

    private int findRowEdgeLimitSearchIndex(boolean z4) {
        boolean z5 = false;
        if (z4) {
            for (int i4 = this.mLastVisibleIndex; i4 >= this.mFirstVisibleIndex; i4--) {
                int i5 = getLocation(i4).row;
                if (i5 == 0) {
                    z5 = true;
                } else if (z5 && i5 == this.mNumRows - 1) {
                    return i4;
                }
            }
            return -1;
        }
        for (int i6 = this.mFirstVisibleIndex; i6 <= this.mLastVisibleIndex; i6++) {
            int i7 = getLocation(i6).row;
            if (i7 == this.mNumRows - 1) {
                z5 = true;
            } else if (z5 && i7 == 0) {
                return i6;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0108 A[LOOP:2: B:82:0x0108->B:96:0x012c, LOOP_START, PHI: r6 r9 r10 
      PHI: (r6v9 int) = (r6v3 int), (r6v12 int) binds: [B:81:0x0106, B:96:0x012c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v7 int) = (r9v5 int), (r9v8 int) binds: [B:81:0x0106, B:96:0x012c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v4 int) = (r10v2 int), (r10v6 int) binds: [B:81:0x0106, B:96:0x012c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean appendVisibleItemsWithoutCache(int r14, boolean r15) {
        /*
            r13 = this;
            androidx.leanback.widget.Grid$Provider r0 = r13.mProvider
            int r0 = r0.getCount()
            int r1 = r13.mLastVisibleIndex
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 < 0) goto L_0x0078
            int r6 = r13.getLastIndex()
            if (r1 >= r6) goto L_0x0016
            return r4
        L_0x0016:
            int r1 = r13.mLastVisibleIndex
            int r6 = r1 + 1
            androidx.leanback.widget.StaggeredGrid$Location r1 = r13.getLocation((int) r1)
            int r1 = r1.row
            int r7 = r13.findRowEdgeLimitSearchIndex(r5)
            if (r7 >= 0) goto L_0x0040
            r7 = 0
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0029:
            int r9 = r13.mNumRows
            if (r7 >= r9) goto L_0x004f
            boolean r8 = r13.mReversedFlow
            if (r8 == 0) goto L_0x0036
            int r8 = r13.getRowMin(r7)
            goto L_0x003a
        L_0x0036:
            int r8 = r13.getRowMax(r7)
        L_0x003a:
            if (r8 == r2) goto L_0x003d
            goto L_0x004f
        L_0x003d:
            int r7 = r7 + 1
            goto L_0x0029
        L_0x0040:
            boolean r8 = r13.mReversedFlow
            if (r8 == 0) goto L_0x004a
            int r7 = r13.findRowMin(r4, r7, r3)
        L_0x0048:
            r8 = r7
            goto L_0x004f
        L_0x004a:
            int r7 = r13.findRowMax(r5, r7, r3)
            goto L_0x0048
        L_0x004f:
            boolean r7 = r13.mReversedFlow
            if (r7 == 0) goto L_0x005a
            int r7 = r13.getRowMin(r1)
            if (r7 > r8) goto L_0x0076
            goto L_0x0060
        L_0x005a:
            int r7 = r13.getRowMax(r1)
            if (r7 < r8) goto L_0x0076
        L_0x0060:
            int r1 = r1 + 1
            int r7 = r13.mNumRows
            if (r1 != r7) goto L_0x0076
            boolean r1 = r13.mReversedFlow
            if (r1 == 0) goto L_0x0070
            int r1 = r13.findRowMin(r4, r3)
        L_0x006e:
            r8 = r1
            goto L_0x0075
        L_0x0070:
            int r1 = r13.findRowMax(r5, r3)
            goto L_0x006e
        L_0x0075:
            r1 = 0
        L_0x0076:
            r7 = 1
            goto L_0x009a
        L_0x0078:
            int r1 = r13.mStartIndex
            r6 = -1
            if (r1 == r6) goto L_0x007f
            r6 = r1
            goto L_0x0080
        L_0x007f:
            r6 = 0
        L_0x0080:
            androidx.collection.CircularArray<androidx.leanback.widget.StaggeredGrid$Location> r1 = r13.mLocations
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0094
            int r1 = r13.getLastIndex()
            androidx.leanback.widget.StaggeredGrid$Location r1 = r13.getLocation((int) r1)
            int r1 = r1.row
            int r1 = r1 + r5
            goto L_0x0095
        L_0x0094:
            r1 = r6
        L_0x0095:
            int r7 = r13.mNumRows
            int r1 = r1 % r7
            r7 = 0
            r8 = 0
        L_0x009a:
            r9 = 0
        L_0x009b:
            int r10 = r13.mNumRows
            if (r1 >= r10) goto L_0x014f
            if (r6 == r0) goto L_0x0151
            if (r15 != 0) goto L_0x00ab
            boolean r10 = r13.checkAppendOverLimit(r14)
            if (r10 == 0) goto L_0x00ab
            goto L_0x0151
        L_0x00ab:
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00b4
            int r9 = r13.getRowMin(r1)
            goto L_0x00b8
        L_0x00b4:
            int r9 = r13.getRowMax(r1)
        L_0x00b8:
            r10 = 2147483647(0x7fffffff, float:NaN)
            if (r9 == r10) goto L_0x00cc
            if (r9 != r2) goto L_0x00c0
            goto L_0x00cc
        L_0x00c0:
            boolean r10 = r13.mReversedFlow
            if (r10 == 0) goto L_0x00c8
            int r10 = r13.mSpacing
        L_0x00c6:
            int r10 = -r10
            goto L_0x00ca
        L_0x00c8:
            int r10 = r13.mSpacing
        L_0x00ca:
            int r9 = r9 + r10
            goto L_0x0100
        L_0x00cc:
            if (r1 != 0) goto L_0x00ef
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00da
            int r9 = r13.mNumRows
            int r9 = r9 - r5
            int r9 = r13.getRowMin(r9)
            goto L_0x00e1
        L_0x00da:
            int r9 = r13.mNumRows
            int r9 = r9 - r5
            int r9 = r13.getRowMax(r9)
        L_0x00e1:
            if (r9 == r10) goto L_0x0100
            if (r9 == r2) goto L_0x0100
            boolean r10 = r13.mReversedFlow
            if (r10 == 0) goto L_0x00ec
            int r10 = r13.mSpacing
            goto L_0x00c6
        L_0x00ec:
            int r10 = r13.mSpacing
            goto L_0x00ca
        L_0x00ef:
            boolean r9 = r13.mReversedFlow
            if (r9 == 0) goto L_0x00fa
            int r9 = r1 + -1
            int r9 = r13.getRowMax(r9)
            goto L_0x0100
        L_0x00fa:
            int r9 = r1 + -1
            int r9 = r13.getRowMin(r9)
        L_0x0100:
            int r10 = r6 + 1
            int r6 = r13.appendVisibleItemToRow(r6, r1, r9)
            if (r7 == 0) goto L_0x013a
        L_0x0108:
            boolean r11 = r13.mReversedFlow
            if (r11 == 0) goto L_0x0111
            int r11 = r9 - r6
            if (r11 <= r8) goto L_0x0138
            goto L_0x0115
        L_0x0111:
            int r11 = r9 + r6
            if (r11 >= r8) goto L_0x0138
        L_0x0115:
            if (r10 == r0) goto L_0x0137
            if (r15 != 0) goto L_0x0120
            boolean r11 = r13.checkAppendOverLimit(r14)
            if (r11 == 0) goto L_0x0120
            goto L_0x0137
        L_0x0120:
            boolean r11 = r13.mReversedFlow
            if (r11 == 0) goto L_0x0129
            int r6 = -r6
            int r11 = r13.mSpacing
            int r6 = r6 - r11
            goto L_0x012c
        L_0x0129:
            int r11 = r13.mSpacing
            int r6 = r6 + r11
        L_0x012c:
            int r9 = r9 + r6
            int r6 = r10 + 1
            int r10 = r13.appendVisibleItemToRow(r10, r1, r9)
            r12 = r10
            r10 = r6
            r6 = r12
            goto L_0x0108
        L_0x0137:
            return r5
        L_0x0138:
            r6 = r10
            goto L_0x014a
        L_0x013a:
            boolean r6 = r13.mReversedFlow
            if (r6 == 0) goto L_0x0143
            int r6 = r13.getRowMin(r1)
            goto L_0x0147
        L_0x0143:
            int r6 = r13.getRowMax(r1)
        L_0x0147:
            r8 = r6
            r7 = 1
            goto L_0x0138
        L_0x014a:
            int r1 = r1 + 1
            r9 = 1
            goto L_0x009b
        L_0x014f:
            if (r15 == 0) goto L_0x0152
        L_0x0151:
            return r9
        L_0x0152:
            boolean r1 = r13.mReversedFlow
            if (r1 == 0) goto L_0x015c
            int r1 = r13.findRowMin(r4, r3)
        L_0x015a:
            r8 = r1
            goto L_0x0161
        L_0x015c:
            int r1 = r13.findRowMax(r5, r3)
            goto L_0x015a
        L_0x0161:
            r1 = 0
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.appendVisibleItemsWithoutCache(int, boolean):boolean");
    }

    public int findRowMax(boolean z4, int i4, int[] iArr) {
        int i5;
        int edge = this.mProvider.getEdge(i4);
        StaggeredGrid.Location location = getLocation(i4);
        int i6 = location.row;
        if (this.mReversedFlow) {
            i5 = i6;
            int i7 = i5;
            int i8 = 1;
            int i9 = i4 + 1;
            int i10 = edge;
            while (i8 < this.mNumRows && i9 <= this.mLastVisibleIndex) {
                StaggeredGrid.Location location2 = getLocation(i9);
                i10 += location2.offset;
                int i11 = location2.row;
                if (i11 != i7) {
                    i8++;
                    if (!z4 ? i10 >= edge : i10 <= edge) {
                        i7 = i11;
                    } else {
                        edge = i10;
                        i4 = i9;
                        i5 = i11;
                        i7 = i5;
                    }
                }
                i9++;
            }
        } else {
            int i12 = i4 - 1;
            int i13 = 1;
            int i14 = i6;
            StaggeredGrid.Location location3 = location;
            int i15 = edge;
            edge = this.mProvider.getSize(i4) + edge;
            i5 = i14;
            while (i13 < this.mNumRows && i12 >= this.mFirstVisibleIndex) {
                i15 -= location3.offset;
                location3 = getLocation(i12);
                int i16 = location3.row;
                if (i16 != i14) {
                    i13++;
                    int size = this.mProvider.getSize(i12) + i15;
                    if (!z4 ? size >= edge : size <= edge) {
                        i14 = i16;
                    } else {
                        edge = size;
                        i4 = i12;
                        i5 = i16;
                        i14 = i5;
                    }
                }
                i12--;
            }
        }
        if (iArr != null) {
            iArr[0] = i5;
            iArr[1] = i4;
        }
        return edge;
    }

    public int findRowMin(boolean z4, int i4, int[] iArr) {
        int i5;
        int edge = this.mProvider.getEdge(i4);
        StaggeredGrid.Location location = getLocation(i4);
        int i6 = location.row;
        if (this.mReversedFlow) {
            int i7 = i4 - 1;
            int i8 = 1;
            i5 = edge - this.mProvider.getSize(i4);
            int i9 = i6;
            while (i8 < this.mNumRows && i7 >= this.mFirstVisibleIndex) {
                edge -= location.offset;
                location = getLocation(i7);
                int i10 = location.row;
                if (i10 != i9) {
                    i8++;
                    int size = edge - this.mProvider.getSize(i7);
                    if (!z4 ? size >= i5 : size <= i5) {
                        i9 = i10;
                    } else {
                        i5 = size;
                        i4 = i7;
                        i6 = i10;
                        i9 = i6;
                    }
                }
                i7--;
            }
        } else {
            int i11 = i6;
            int i12 = i11;
            int i13 = 1;
            int i14 = i4 + 1;
            int i15 = edge;
            while (i13 < this.mNumRows && i14 <= this.mLastVisibleIndex) {
                StaggeredGrid.Location location2 = getLocation(i14);
                i15 += location2.offset;
                int i16 = location2.row;
                if (i16 != i12) {
                    i13++;
                    if (!z4 ? i15 >= edge : i15 <= edge) {
                        i12 = i16;
                    } else {
                        edge = i15;
                        i4 = i14;
                        i11 = i16;
                        i12 = i11;
                    }
                }
                i14++;
            }
            i5 = edge;
            i6 = i11;
        }
        if (iArr != null) {
            iArr[0] = i6;
            iArr[1] = i4;
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public int getRowMax(int i4) {
        int i5;
        StaggeredGrid.Location location;
        int i6 = this.mFirstVisibleIndex;
        if (i6 < 0) {
            return Integer.MIN_VALUE;
        }
        if (this.mReversedFlow) {
            int edge = this.mProvider.getEdge(i6);
            if (getLocation(this.mFirstVisibleIndex).row == i4) {
                return edge;
            }
            int i7 = this.mFirstVisibleIndex;
            do {
                i7++;
                if (i7 <= getLastIndex()) {
                    location = getLocation(i7);
                    edge += location.offset;
                }
            } while (location.row != i4);
            return edge;
        }
        int edge2 = this.mProvider.getEdge(this.mLastVisibleIndex);
        StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
        if (location2.row != i4) {
            int i8 = this.mLastVisibleIndex;
            while (true) {
                i8--;
                if (i8 < getFirstIndex()) {
                    break;
                }
                edge2 -= location2.offset;
                location2 = getLocation(i8);
                if (location2.row == i4) {
                    i5 = location2.size;
                    break;
                }
            }
        } else {
            i5 = location2.size;
        }
        return edge2 + i5;
        return Integer.MIN_VALUE;
    }

    /* access modifiers changed from: package-private */
    public int getRowMin(int i4) {
        StaggeredGrid.Location location;
        int i5;
        int i6 = this.mFirstVisibleIndex;
        if (i6 < 0) {
            return Integer.MAX_VALUE;
        }
        if (this.mReversedFlow) {
            int edge = this.mProvider.getEdge(this.mLastVisibleIndex);
            StaggeredGrid.Location location2 = getLocation(this.mLastVisibleIndex);
            if (location2.row != i4) {
                int i7 = this.mLastVisibleIndex;
                while (true) {
                    i7--;
                    if (i7 < getFirstIndex()) {
                        break;
                    }
                    edge -= location2.offset;
                    location2 = getLocation(i7);
                    if (location2.row == i4) {
                        i5 = location2.size;
                        break;
                    }
                }
            } else {
                i5 = location2.size;
            }
            return edge - i5;
        }
        int edge2 = this.mProvider.getEdge(i6);
        if (getLocation(this.mFirstVisibleIndex).row == i4) {
            return edge2;
        }
        int i8 = this.mFirstVisibleIndex;
        do {
            i8++;
            if (i8 <= getLastIndex()) {
                location = getLocation(i8);
                edge2 += location.offset;
            }
        } while (location.row != i4);
        return edge2;
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0103 A[LOOP:2: B:80:0x0103->B:94:0x0127, LOOP_START, PHI: r5 r8 r9 
      PHI: (r5v9 int) = (r5v3 int), (r5v12 int) binds: [B:79:0x0101, B:94:0x0127] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r8v7 int) = (r8v5 int), (r8v8 int) binds: [B:79:0x0101, B:94:0x0127] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v3 int) = (r9v1 int), (r9v5 int) binds: [B:79:0x0101, B:94:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean prependVisibleItemsWithoutCache(int r13, boolean r14) {
        /*
            r12 = this;
            int r0 = r12.mFirstVisibleIndex
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 < 0) goto L_0x0076
            int r5 = r12.getFirstIndex()
            if (r0 <= r5) goto L_0x0011
            return r3
        L_0x0011:
            int r0 = r12.mFirstVisibleIndex
            int r5 = r0 + -1
            androidx.leanback.widget.StaggeredGrid$Location r0 = r12.getLocation((int) r0)
            int r0 = r0.row
            int r6 = r12.findRowEdgeLimitSearchIndex(r3)
            if (r6 >= 0) goto L_0x003e
            int r0 = r0 + -1
            int r6 = r12.mNumRows
            int r6 = r6 - r4
            r7 = 2147483647(0x7fffffff, float:NaN)
        L_0x0029:
            if (r6 < 0) goto L_0x004d
            boolean r7 = r12.mReversedFlow
            if (r7 == 0) goto L_0x0034
            int r7 = r12.getRowMax(r6)
            goto L_0x0038
        L_0x0034:
            int r7 = r12.getRowMin(r6)
        L_0x0038:
            if (r7 == r1) goto L_0x003b
            goto L_0x004d
        L_0x003b:
            int r6 = r6 + -1
            goto L_0x0029
        L_0x003e:
            boolean r7 = r12.mReversedFlow
            if (r7 == 0) goto L_0x0048
            int r6 = r12.findRowMax(r4, r6, r2)
        L_0x0046:
            r7 = r6
            goto L_0x004d
        L_0x0048:
            int r6 = r12.findRowMin(r3, r6, r2)
            goto L_0x0046
        L_0x004d:
            boolean r6 = r12.mReversedFlow
            if (r6 == 0) goto L_0x0058
            int r6 = r12.getRowMax(r0)
            if (r6 < r7) goto L_0x0074
            goto L_0x005e
        L_0x0058:
            int r6 = r12.getRowMin(r0)
            if (r6 > r7) goto L_0x0074
        L_0x005e:
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x0074
            int r0 = r12.mNumRows
            int r0 = r0 - r4
            boolean r6 = r12.mReversedFlow
            if (r6 == 0) goto L_0x006f
            int r6 = r12.findRowMax(r4, r2)
        L_0x006d:
            r7 = r6
            goto L_0x0074
        L_0x006f:
            int r6 = r12.findRowMin(r3, r2)
            goto L_0x006d
        L_0x0074:
            r6 = 1
            goto L_0x009b
        L_0x0076:
            int r0 = r12.mStartIndex
            r5 = -1
            if (r0 == r5) goto L_0x007d
            r5 = r0
            goto L_0x007e
        L_0x007d:
            r5 = 0
        L_0x007e:
            androidx.collection.CircularArray<androidx.leanback.widget.StaggeredGrid$Location> r0 = r12.mLocations
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0095
            int r0 = r12.getFirstIndex()
            androidx.leanback.widget.StaggeredGrid$Location r0 = r12.getLocation((int) r0)
            int r0 = r0.row
            int r6 = r12.mNumRows
            int r0 = r0 + r6
            int r0 = r0 - r4
            goto L_0x0096
        L_0x0095:
            r0 = r5
        L_0x0096:
            int r6 = r12.mNumRows
            int r0 = r0 % r6
            r6 = 0
            r7 = 0
        L_0x009b:
            r8 = 0
        L_0x009c:
            if (r0 < 0) goto L_0x014a
            if (r5 < 0) goto L_0x014c
            if (r14 != 0) goto L_0x00aa
            boolean r9 = r12.checkPrependOverLimit(r13)
            if (r9 == 0) goto L_0x00aa
            goto L_0x014c
        L_0x00aa:
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00b3
            int r8 = r12.getRowMax(r0)
            goto L_0x00b7
        L_0x00b3:
            int r8 = r12.getRowMin(r0)
        L_0x00b7:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r8 == r1) goto L_0x00ca
            if (r8 != r9) goto L_0x00be
            goto L_0x00ca
        L_0x00be:
            boolean r9 = r12.mReversedFlow
            if (r9 == 0) goto L_0x00c5
            int r9 = r12.mSpacing
            goto L_0x00c8
        L_0x00c5:
            int r9 = r12.mSpacing
        L_0x00c7:
            int r9 = -r9
        L_0x00c8:
            int r8 = r8 + r9
            goto L_0x00fb
        L_0x00ca:
            int r8 = r12.mNumRows
            int r8 = r8 - r4
            if (r0 != r8) goto L_0x00ea
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00d8
            int r8 = r12.getRowMax(r3)
            goto L_0x00dc
        L_0x00d8:
            int r8 = r12.getRowMin(r3)
        L_0x00dc:
            if (r8 == r1) goto L_0x00fb
            if (r8 == r9) goto L_0x00fb
            boolean r9 = r12.mReversedFlow
            if (r9 == 0) goto L_0x00e7
            int r9 = r12.mSpacing
            goto L_0x00c8
        L_0x00e7:
            int r9 = r12.mSpacing
            goto L_0x00c7
        L_0x00ea:
            boolean r8 = r12.mReversedFlow
            if (r8 == 0) goto L_0x00f5
            int r8 = r0 + 1
            int r8 = r12.getRowMin(r8)
            goto L_0x00fb
        L_0x00f5:
            int r8 = r0 + 1
            int r8 = r12.getRowMax(r8)
        L_0x00fb:
            int r9 = r5 + -1
            int r5 = r12.prependVisibleItemToRow(r5, r0, r8)
            if (r6 == 0) goto L_0x0135
        L_0x0103:
            boolean r10 = r12.mReversedFlow
            if (r10 == 0) goto L_0x010c
            int r10 = r8 + r5
            if (r10 >= r7) goto L_0x0133
            goto L_0x0110
        L_0x010c:
            int r10 = r8 - r5
            if (r10 <= r7) goto L_0x0133
        L_0x0110:
            if (r9 < 0) goto L_0x0132
            if (r14 != 0) goto L_0x011b
            boolean r10 = r12.checkPrependOverLimit(r13)
            if (r10 == 0) goto L_0x011b
            goto L_0x0132
        L_0x011b:
            boolean r10 = r12.mReversedFlow
            if (r10 == 0) goto L_0x0123
            int r10 = r12.mSpacing
            int r5 = r5 + r10
            goto L_0x0127
        L_0x0123:
            int r5 = -r5
            int r10 = r12.mSpacing
            int r5 = r5 - r10
        L_0x0127:
            int r8 = r8 + r5
            int r5 = r9 + -1
            int r9 = r12.prependVisibleItemToRow(r9, r0, r8)
            r11 = r9
            r9 = r5
            r5 = r11
            goto L_0x0103
        L_0x0132:
            return r4
        L_0x0133:
            r5 = r9
            goto L_0x0145
        L_0x0135:
            boolean r5 = r12.mReversedFlow
            if (r5 == 0) goto L_0x013e
            int r5 = r12.getRowMax(r0)
            goto L_0x0142
        L_0x013e:
            int r5 = r12.getRowMin(r0)
        L_0x0142:
            r7 = r5
            r6 = 1
            goto L_0x0133
        L_0x0145:
            int r0 = r0 + -1
            r8 = 1
            goto L_0x009c
        L_0x014a:
            if (r14 == 0) goto L_0x014d
        L_0x014c:
            return r8
        L_0x014d:
            boolean r0 = r12.mReversedFlow
            if (r0 == 0) goto L_0x0157
            int r0 = r12.findRowMax(r4, r2)
        L_0x0155:
            r7 = r0
            goto L_0x015c
        L_0x0157:
            int r0 = r12.findRowMin(r3, r2)
            goto L_0x0155
        L_0x015c:
            int r0 = r12.mNumRows
            int r0 = r0 - r4
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.StaggeredGridDefault.prependVisibleItemsWithoutCache(int, boolean):boolean");
    }
}
