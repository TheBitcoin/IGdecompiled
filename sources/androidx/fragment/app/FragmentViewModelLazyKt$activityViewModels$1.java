package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import d3.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class FragmentViewModelLazyKt$activityViewModels$1 extends n implements a {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.$this_activityViewModels.requireActivity();
        m.d(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        m.d(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
