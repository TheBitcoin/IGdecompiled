package androidx.core.util;

import S2.C1600n;
import android.util.SparseBooleanArray;

public final class SparseBooleanArrayKt$valueIterator$1 extends C1600n {
    final /* synthetic */ SparseBooleanArray $this_valueIterator;
    private int index;

    SparseBooleanArrayKt$valueIterator$1(SparseBooleanArray sparseBooleanArray) {
        this.$this_valueIterator = sparseBooleanArray;
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

    public boolean nextBoolean() {
        SparseBooleanArray sparseBooleanArray = this.$this_valueIterator;
        int i4 = this.index;
        this.index = i4 + 1;
        return sparseBooleanArray.valueAt(i4);
    }

    public final void setIndex(int i4) {
        this.index = i4;
    }
}
