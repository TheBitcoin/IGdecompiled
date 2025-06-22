package androidx.lifecycle.viewmodel;

import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import k3.c;
import kotlin.jvm.internal.m;

public final class ViewModelProviderImpl {
    private final CreationExtras extras;
    private final ViewModelProvider.Factory factory;
    private final ViewModelStore store;

    public ViewModelProviderImpl(ViewModelStore viewModelStore, ViewModelProvider.Factory factory2, CreationExtras creationExtras) {
        m.e(viewModelStore, "store");
        m.e(factory2, "factory");
        m.e(creationExtras, "extras");
        this.store = viewModelStore;
        this.factory = factory2;
        this.extras = creationExtras;
    }

    public static /* synthetic */ ViewModel getViewModel$lifecycle_viewmodel_release$default(ViewModelProviderImpl viewModelProviderImpl, c cVar, String str, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel_release(cVar);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel_release(cVar, str);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel_release(c cVar, String str) {
        m.e(cVar, "modelClass");
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        T t4 = this.store.get(str);
        if (cVar.c(t4)) {
            ViewModelProvider.Factory factory2 = this.factory;
            if (factory2 instanceof ViewModelProvider.OnRequeryFactory) {
                m.b(t4);
                ((ViewModelProvider.OnRequeryFactory) factory2).onRequery(t4);
            }
            m.c(t4, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
            return t4;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.extras);
        mutableCreationExtras.set(ViewModelProviders.ViewModelKey.INSTANCE, str);
        T createViewModel = ViewModelProviderImpl_androidKt.createViewModel(this.factory, cVar, mutableCreationExtras);
        this.store.put(str, createViewModel);
        return createViewModel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelProviderImpl(ViewModelStoreOwner viewModelStoreOwner, ViewModelProvider.Factory factory2, CreationExtras creationExtras) {
        this(viewModelStoreOwner.getViewModelStore(), factory2, creationExtras);
        m.e(viewModelStoreOwner, "owner");
        m.e(factory2, "factory");
        m.e(creationExtras, "extras");
    }
}
