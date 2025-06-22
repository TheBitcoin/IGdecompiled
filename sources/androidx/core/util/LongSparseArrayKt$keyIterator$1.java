package androidx.core.util;

import S2.F;
import android.util.LongSparseArray;

public final class LongSparseArrayKt$keyIterator$1 extends F {
    final /* synthetic */ LongSparseArray<T> $this_keyIterator;
    private int index;

    LongSparseArrayKt$keyIterator$1(LongSparseArray<T> longSparseArray) {
        this.$this_keyIterator = longSparseArray;
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

    public long nextLong() {
        LongSparseArray<T> longSparseArray = this.$this_keyIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return longSparseArray.keyAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
