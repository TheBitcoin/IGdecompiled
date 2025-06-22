package androidx.fragment.app;

import android.os.Bundle;
import d3.p;
import kotlin.jvm.internal.m;

public final class FragmentKt {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        m.e(fragment, "$this$clearFragmentResult");
        m.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        m.e(fragment, "$this$clearFragmentResultListener");
        m.e(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        m.e(fragment, "$this$setFragmentResult");
        m.e(str, "requestKey");
        m.e(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, p pVar) {
        m.e(fragment, "$this$setFragmentResultListener");
        m.e(str, "requestKey");
        m.e(pVar, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentKt$sam$androidx_fragment_app_FragmentResultListener$0(pVar));
    }
}
