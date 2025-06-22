package androidx.leanback.widget;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.CircularIntArray;
import androidx.recyclerview.widget.RecyclerView;
import java.io.PrintWriter;
import java.util.Arrays;

abstract class Grid {
    public static final int START_DEFAULT = -1;
    protected int mFirstVisibleIndex = -1;
    protected int mLastVisibleIndex = -1;
    protected int mNumRows;
    protected Provider mProvider;
    protected boolean mReversedFlow;
    protected int mSpacing;
    protected int mStartIndex = -1;
    Object[] mTmpItem = new Object[1];
    protected CircularIntArray[] mTmpItemPositionsInRows;

    public static class Location {
        public int row;

        public Location(int i4) {
            this.row = i4;
        }
    }

    public interface Provider {
        void addItem(Object obj, int i4, int i5, int i6, int i7);

        int createItem(int i4, boolean z4, Object[] objArr, boolean z5);

        int getCount();

        int getEdge(int i4);

        int getMinIndex();

        int getSize(int i4);

        void removeItem(int i4);
    }

    Grid() {
    }

    public static Grid createGrid(int i4) {
        if (i4 == 1) {
            return new SingleRow();
        }
        StaggeredGridDefault staggeredGridDefault = new StaggeredGridDefault();
        staggeredGridDefault.setNumRows(i4);
        return staggeredGridDefault;
    }

    private void resetVisibleIndexIfEmpty() {
        if (this.mLastVisibleIndex < this.mFirstVisibleIndex) {
            resetVisibleIndex();
        }
    }

    public boolean appendOneColumnVisibleItems() {
        int i4;
        if (this.mReversedFlow) {
            i4 = Integer.MAX_VALUE;
        } else {
            i4 = Integer.MIN_VALUE;
        }
        return appendVisibleItems(i4, true);
    }

    public final void appendVisibleItems(int i4) {
        appendVisibleItems(i4, false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean appendVisibleItems(int i4, boolean z4);

    /* access modifiers changed from: protected */
    public final boolean checkAppendOverLimit(int i4) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            if (findRowMin(true, (int[]) null) <= i4 + this.mSpacing) {
                return true;
            }
            return false;
        } else if (findRowMax(false, (int[]) null) >= i4 - this.mSpacing) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean checkPrependOverLimit(int i4) {
        if (this.mLastVisibleIndex < 0) {
            return false;
        }
        if (this.mReversedFlow) {
            if (findRowMax(false, (int[]) null) >= i4 - this.mSpacing) {
                return true;
            }
            return false;
        } else if (findRowMin(true, (int[]) null) <= i4 + this.mSpacing) {
            return true;
        } else {
            return false;
        }
    }

    public void collectAdjacentPrefetchPositions(int i4, int i5, @NonNull RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
    }

    public abstract void debugPrint(PrintWriter printWriter);

    public void fillDisappearingItems(int[] iArr, int i4, SparseIntArray sparseIntArray) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int lastVisibleIndex = getLastVisibleIndex();
        if (lastVisibleIndex >= 0) {
            i5 = Arrays.binarySearch(iArr, 0, i4, lastVisibleIndex);
        } else {
            i5 = 0;
        }
        if (i5 < 0) {
            if (this.mReversedFlow) {
                i10 = (this.mProvider.getEdge(lastVisibleIndex) - this.mProvider.getSize(lastVisibleIndex)) - this.mSpacing;
            } else {
                i10 = this.mProvider.getEdge(lastVisibleIndex) + this.mProvider.getSize(lastVisibleIndex) + this.mSpacing;
            }
            int i12 = i10;
            for (int i13 = (-i5) - 1; i13 < i4; i13++) {
                int i14 = iArr[i13];
                int i15 = sparseIntArray.get(i14);
                if (i15 < 0) {
                    i11 = 0;
                } else {
                    i11 = i15;
                }
                int createItem = this.mProvider.createItem(i14, true, this.mTmpItem, true);
                this.mProvider.addItem(this.mTmpItem[0], i14, createItem, i11, i12);
                if (this.mReversedFlow) {
                    i12 = (i12 - createItem) - this.mSpacing;
                } else {
                    i12 = i12 + createItem + this.mSpacing;
                }
            }
        }
        int firstVisibleIndex = getFirstVisibleIndex();
        if (firstVisibleIndex >= 0) {
            i6 = Arrays.binarySearch(iArr, 0, i4, firstVisibleIndex);
        } else {
            i6 = 0;
        }
        if (i6 < 0) {
            int i16 = (-i6) - 2;
            if (this.mReversedFlow) {
                i7 = this.mProvider.getEdge(firstVisibleIndex);
            } else {
                i7 = this.mProvider.getEdge(firstVisibleIndex);
            }
            while (i16 >= 0) {
                int i17 = iArr[i16];
                int i18 = sparseIntArray.get(i17);
                if (i18 < 0) {
                    i8 = 0;
                } else {
                    i8 = i18;
                }
                int createItem2 = this.mProvider.createItem(i17, false, this.mTmpItem, true);
                if (this.mReversedFlow) {
                    i9 = i7 + this.mSpacing + createItem2;
                } else {
                    i9 = (i7 - this.mSpacing) - createItem2;
                }
                int i19 = i9;
                this.mProvider.addItem(this.mTmpItem[0], i17, createItem2, i8, i19);
                i16--;
                i7 = i19;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract int findRowMax(boolean z4, int i4, int[] iArr);

    public final int findRowMax(boolean z4, @Nullable int[] iArr) {
        return findRowMax(z4, this.mReversedFlow ? this.mFirstVisibleIndex : this.mLastVisibleIndex, iArr);
    }

    /* access modifiers changed from: protected */
    public abstract int findRowMin(boolean z4, int i4, int[] iArr);

    public final int findRowMin(boolean z4, @Nullable int[] iArr) {
        return findRowMin(z4, this.mReversedFlow ? this.mLastVisibleIndex : this.mFirstVisibleIndex, iArr);
    }

    public final int getFirstVisibleIndex() {
        return this.mFirstVisibleIndex;
    }

    public final CircularIntArray[] getItemPositionsInRows() {
        return getItemPositionsInRows(getFirstVisibleIndex(), getLastVisibleIndex());
    }

    public abstract CircularIntArray[] getItemPositionsInRows(int i4, int i5);

    public final int getLastVisibleIndex() {
        return this.mLastVisibleIndex;
    }

    public abstract Location getLocation(int i4);

    public int getNumRows() {
        return this.mNumRows;
    }

    public final int getRowIndex(int i4) {
        Location location = getLocation(i4);
        if (location == null) {
            return -1;
        }
        return location.row;
    }

    public void invalidateItemsAfter(int i4) {
        int i5;
        if (i4 >= 0 && (i5 = this.mLastVisibleIndex) >= 0) {
            if (i5 >= i4) {
                this.mLastVisibleIndex = i4 - 1;
            }
            resetVisibleIndexIfEmpty();
            if (getFirstVisibleIndex() < 0) {
                setStart(i4);
            }
        }
    }

    public boolean isReversedFlow() {
        return this.mReversedFlow;
    }

    public final boolean prependOneColumnVisibleItems() {
        int i4;
        if (this.mReversedFlow) {
            i4 = Integer.MIN_VALUE;
        } else {
            i4 = Integer.MAX_VALUE;
        }
        return prependVisibleItems(i4, true);
    }

    public final void prependVisibleItems(int i4) {
        prependVisibleItems(i4, false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean prependVisibleItems(int i4, boolean z4);

    public void removeInvisibleItemsAtEnd(int i4, int i5) {
        while (true) {
            int i6 = this.mLastVisibleIndex;
            if (i6 < this.mFirstVisibleIndex || i6 <= i4) {
                break;
            }
            if (this.mReversedFlow) {
                if (this.mProvider.getEdge(i6) > i5) {
                    break;
                }
            } else if (this.mProvider.getEdge(i6) < i5) {
                break;
            }
            this.mProvider.removeItem(this.mLastVisibleIndex);
            this.mLastVisibleIndex--;
        }
        resetVisibleIndexIfEmpty();
    }

    public void removeInvisibleItemsAtFront(int i4, int i5) {
        while (true) {
            int i6 = this.mLastVisibleIndex;
            int i7 = this.mFirstVisibleIndex;
            if (i6 < i7 || i7 >= i4) {
                break;
            }
            int size = this.mProvider.getSize(i7);
            if (this.mReversedFlow) {
                if (this.mProvider.getEdge(this.mFirstVisibleIndex) - size < i5) {
                    break;
                }
            } else if (this.mProvider.getEdge(this.mFirstVisibleIndex) + size > i5) {
                break;
            }
            this.mProvider.removeItem(this.mFirstVisibleIndex);
            this.mFirstVisibleIndex++;
        }
        resetVisibleIndexIfEmpty();
    }

    public void resetVisibleIndex() {
        this.mLastVisibleIndex = -1;
        this.mFirstVisibleIndex = -1;
    }

    /* access modifiers changed from: package-private */
    public void setNumRows(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException();
        } else if (this.mNumRows != i4) {
            this.mNumRows = i4;
            this.mTmpItemPositionsInRows = new CircularIntArray[i4];
            for (int i5 = 0; i5 < this.mNumRows; i5++) {
                this.mTmpItemPositionsInRows[i5] = new CircularIntArray();
            }
        }
    }

    public void setProvider(Provider provider) {
        this.mProvider = provider;
    }

    public final void setReversedFlow(boolean z4) {
        this.mReversedFlow = z4;
    }

    public final void setSpacing(int i4) {
        this.mSpacing = i4;
    }

    public void setStart(int i4) {
        this.mStartIndex = i4;
    }
}
