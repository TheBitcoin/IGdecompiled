package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.o;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import c3.C1704a;
import java.util.Arrays;
import k3.c;
import kotlin.jvm.internal.m;

public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... viewModelInitializerArr) {
        m.e(viewModelInitializerArr, "initializers");
        this.initializers = viewModelInitializerArr;
    }

    public /* synthetic */ ViewModel create(Class cls) {
        return o.a(this, cls);
    }

    public /* synthetic */ ViewModel create(c cVar, CreationExtras creationExtras) {
        return o.c(this, cVar, creationExtras);
    }

    public <VM extends ViewModel> VM create(Class<VM> cls, CreationExtras creationExtras) {
        m.e(cls, "modelClass");
        m.e(creationExtras, "extras");
        ViewModelProviders viewModelProviders = ViewModelProviders.INSTANCE;
        c c5 = C1704a.c(cls);
        ViewModelInitializer<?>[] viewModelInitializerArr = this.initializers;
        return viewModelProviders.createViewModelFromInitializers$lifecycle_viewmodel_release(c5, creationExtras, (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
