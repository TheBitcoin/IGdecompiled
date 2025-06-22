package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import d3.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends n implements l {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    public final View invoke(View view) {
        m.e(view, "currentView");
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
