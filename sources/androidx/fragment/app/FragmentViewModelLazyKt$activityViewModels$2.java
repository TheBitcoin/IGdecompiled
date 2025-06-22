package androidx.fragment.app;

import androidx.lifecycle.ViewModelProvider;
import d3.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class FragmentViewModelLazyKt$activityViewModels$2 extends n implements a {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        m.d(requireActivity, "requireActivity()");
        return requireActivity.getDefaultViewModelProviderFactory();
    }
}
