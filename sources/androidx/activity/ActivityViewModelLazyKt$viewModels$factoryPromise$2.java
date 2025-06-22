package androidx.activity;

import androidx.lifecycle.ViewModelProvider;
import d3.a;
import kotlin.jvm.internal.n;

public final class ActivityViewModelLazyKt$viewModels$factoryPromise$2 extends n implements a {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$factoryPromise$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    }
}
