package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.m;

public final class ViewKt {
    public static final <F extends Fragment> F findFragment(View view) {
        m.e(view, "$this$findFragment");
        F findFragment = FragmentManager.findFragment(view);
        m.d(findFragment, "FragmentManager.findFragment(this)");
        return findFragment;
    }
}
