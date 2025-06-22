package androidx.core.util;

import S2.E;
import android.util.SparseIntArray;

public final class SparseIntArrayKt$valueIterator$1 extends E {
    final /* synthetic */ SparseIntArray $this_valueIterator;
    private int index;

    SparseIntArrayKt$valueIterator$1(SparseIntArray sparseIntArray) {
        this.$this_valueIterator = sparseIntArray;
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

    public int nextInt() {
        SparseIntArray sparseIntArray = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseIntArray.valueAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
