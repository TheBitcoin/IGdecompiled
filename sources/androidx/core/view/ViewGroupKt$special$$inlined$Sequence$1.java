package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import l3.e;

public final class ViewGroupKt$special$$inlined$Sequence$1 implements e {
    final /* synthetic */ ViewGroup $this_descendants$inlined;

    public ViewGroupKt$special$$inlined$Sequence$1(ViewGroup viewGroup) {
        this.$this_descendants$inlined = viewGroup;
    }

    public Iterator<View> iterator() {
        return new TreeIterator(ViewGroupKt.getChildren(this.$this_descendants$inlined).iterator(), ViewGroupKt$descendants$1$1.INSTANCE);
    }
}
