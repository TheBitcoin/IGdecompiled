package androidx.core.util;

import android.util.SparseArray;
import e3.a;
import java.util.Iterator;

public final class SparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ SparseArray<T> $this_valueIterator;
    private int index;

    SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.$this_valueIterator = sparseArray;
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
        SparseArray<T> sparseArray = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseArray.valueAt(i4);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
