package androidx.core.util;

import android.util.LongSparseArray;
import e3.a;
import java.util.Iterator;

public final class LongSparseArrayKt$valueIterator$1 implements Iterator<T>, a {
    final /* synthetic */ LongSparseArray<T> $this_valueIterator;
    private int index;

    LongSparseArrayKt$valueIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_valueIterator = longSparseArray;
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
        LongSparseArray<T> longSparseArray = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return longSparseArray.valueAt(i4);
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
