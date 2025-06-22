package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import e3.a;
import java.util.Iterator;

public final class ViewGroupKt$iterator$1 implements Iterator<View>, a {
    final /* synthetic */ ViewGroup $this_iterator;
    private int index;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.$this_iterator = viewGroup;
    }

    public boolean hasNext() {
        if (this.index < this.$this_iterator.getChildCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        ViewGroup viewGroup = this.$this_iterator;
        int i4 = this.index - 1;
        this.index = i4;
        viewGroup.removeViewAt(i4);
    }

    public View next() {
        ViewGroup viewGroup = this.$this_iterator;
        int i4 = this.index;
        this.index = i4 + 1;
        View childAt = viewGroup.getChildAt(i4);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
