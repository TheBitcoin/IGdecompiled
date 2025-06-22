package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.CreationExtras;
import c3.C1704a;
import k3.c;
import kotlin.jvm.internal.m;

public final class DefaultViewModelProviderFactory implements ViewModelProvider.Factory {
    public static final DefaultViewModelProviderFactory INSTANCE = new DefaultViewModelProviderFactory();

    private DefaultViewModelProviderFactory() {
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return o.a(this, cls);
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return o.b(this, cls, creationExtras);
    }

    public <T extends ViewModel> T create(c cVar, CreationExtras creationExtras) {
        m.e(cVar, "modelClass");
        m.e(creationExtras, "extras");
        return JvmViewModelProviders.INSTANCE.createViewModel(C1704a.a(cVar));
    }
}
