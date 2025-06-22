package androidx.core.util;

import S2.F;
import android.util.SparseLongArray;

public final class SparseLongArrayKt$valueIterator$1 extends F {
    final /* synthetic */ SparseLongArray $this_valueIterator;
    private int index;

    SparseLongArrayKt$valueIterator$1(SparseLongArray sparseLongArray) {
        this.$this_valueIterator = sparseLongArray;
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

    public long nextLong() {
        SparseLongArray sparseLongArray = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseLongArray.valueAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
