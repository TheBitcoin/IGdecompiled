package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import d3.l;
import java.util.Iterator;
import kotlin.jvm.internal.n;
import l3.e;

final class ViewGroupKt$descendants$1$1 extends n implements l {
    public static final ViewGroupKt$descendants$1$1 INSTANCE = new ViewGroupKt$descendants$1$1();

    ViewGroupKt$descendants$1$1() {
        super(1);
    }

    public final Iterator<View> invoke(View view) {
        e children;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
            return null;
        }
        return children.iterator();
    }
}
