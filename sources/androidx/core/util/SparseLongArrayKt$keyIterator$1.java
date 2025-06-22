package androidx.core.util;

import S2.E;
import android.util.SparseLongArray;

public final class SparseLongArrayKt$keyIterator$1 extends E {
    final /* synthetic */ SparseLongArray $this_keyIterator;
    private int index;

    SparseLongArrayKt$keyIterator$1(SparseLongArray sparseLongArray) {
        this.$this_keyIterator = sparseLongArray;
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
        SparseLongArray sparseLongArray = this.$this_keyIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseLongArray.keyAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
