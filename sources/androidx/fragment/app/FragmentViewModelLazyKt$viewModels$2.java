package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import d3.a;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class FragmentViewModelLazyKt$viewModels$2 extends n implements a {
    final /* synthetic */ a $ownerProducer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentViewModelLazyKt$viewModels$2(a aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
        m.d(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
