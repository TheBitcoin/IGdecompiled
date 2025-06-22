package androidx.core.util;

import S2.E;
import android.util.SparseIntArray;

public final class SparseIntArrayKt$keyIterator$1 extends E {
    final /* synthetic */ SparseIntArray $this_keyIterator;
    private int index;

    SparseIntArrayKt$keyIterator$1(SparseIntArray sparseIntArray) {
        this.$this_keyIterator = sparseIntArray;
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
        SparseIntArray sparseIntArray = this.$this_keyIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseIntArray.keyAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
