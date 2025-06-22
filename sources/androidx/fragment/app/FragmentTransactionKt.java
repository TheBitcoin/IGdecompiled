package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.m;

public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i4, String str, Bundle bundle) {
        m.e(fragmentTransaction, "$this$add");
        m.j(4, "F");
        FragmentTransaction add = fragmentTransaction.add(i4, Fragment.class, bundle, str);
        m.d(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i4, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        m.e(fragmentTransaction, "$this$add");
        m.j(4, "F");
        FragmentTransaction add = fragmentTransaction.add(i4, Fragment.class, bundle, str);
        m.d(add, "add(containerViewId, F::class.java, args, tag)");
        return add;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i4, String str, Bundle bundle) {
        m.e(fragmentTransaction, "$this$replace");
        m.j(4, "F");
        FragmentTransaction replace = fragmentTransaction.replace(i4, Fragment.class, bundle, str);
        m.d(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i4, String str, Bundle bundle, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = null;
        }
        if ((i5 & 4) != 0) {
            bundle = null;
        }
        m.e(fragmentTransaction, "$this$replace");
        m.j(4, "F");
        FragmentTransaction replace = fragmentTransaction.replace(i4, Fragment.class, bundle, str);
        m.d(replace, "replace(containerViewId, F::class.java, args, tag)");
        return replace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String str, Bundle bundle) {
        m.e(fragmentTransaction, "$this$add");
        m.e(str, "tag");
        m.j(4, "F");
        FragmentTransaction add = fragmentTransaction.add((Class<? extends Fragment>) Fragment.class, bundle, str);
        m.d(add, "add(F::class.java, args, tag)");
        return add;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String str, Bundle bundle, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            bundle = null;
        }
        m.e(fragmentTransaction, "$this$add");
        m.e(str, "tag");
        m.j(4, "F");
        FragmentTransaction add = fragmentTransaction.add((Class<? extends Fragment>) Fragment.class, bundle, str);
        m.d(add, "add(F::class.java, args, tag)");
        return add;
    }
}
