package androidx.collection;

import e3.a;
import java.util.Iterator;

public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ SparseArrayCompat $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArrayCompat<T> sparseArrayCompat) {
        this.$this_valueIterator = sparseArrayCompat;
    }

    public final int getIndex() {
        return this.index;
    }

    public boolean hasNext() {
        if (this.index < this.$this_valueIterator.size()) {
            return true;
        }
        return false;
    }

    public T next() {
        SparseArrayCompat sparseArrayCompat = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseArrayCompat.valueAt(i4);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
