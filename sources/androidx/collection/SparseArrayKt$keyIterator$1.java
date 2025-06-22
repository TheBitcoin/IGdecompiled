package androidx.collection;

import S2.E;

public final class SparseArrayKt$keyIterator$1 extends E {
    final /* synthetic */ SparseArrayCompat $this_keyIterator;
    private int index;

    SparseArrayKt$keyIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_keyIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_keyIterator.size()) {
            return true;
        }
        return false;
    }

    public int nextInt() {
        SparseArrayCompat sparseArrayCompat = this.$this_keyIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseArrayCompat.keyAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
