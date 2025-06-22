package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import l3.e;

public final class ViewGroupKt$children$1 implements e {
    final /* synthetic */ ViewGroup $this_children;

    ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.$this_children = viewGroup;
    }

    public Iterator<View> iterator() {
        return ViewGroupKt.iterator(this.$this_children);
    }
}
