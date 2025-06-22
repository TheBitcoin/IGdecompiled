package androidx.core.util;

import S2.E;
import android.util.SparseBooleanArray;

public final class SparseBooleanArrayKt$keyIterator$1 extends E {
    final /* synthetic */ SparseBooleanArray $this_keyIterator;
    private int index;

    SparseBooleanArrayKt$keyIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_keyIterator = sparseBooleanArray;
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
        SparseBooleanArray sparseBooleanArray = this.$this_keyIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseBooleanArray.keyAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
