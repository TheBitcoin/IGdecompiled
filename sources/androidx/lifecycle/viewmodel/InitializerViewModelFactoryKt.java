package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import d3.l;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;

public final class InitializerViewModelFactoryKt {
    public static final /* synthetic */ <VM extends ViewModel> void initializer(InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder, l lVar) {
        m.e(initializerViewModelFactoryBuilder, "<this>");
        m.e(lVar, "initializer");
        m.j(4, "VM");
        initializerViewModelFactoryBuilder.addInitializer(D.b(ViewModel.class), lVar);
    }

    public static final ViewModelProvider.Factory viewModelFactory(l lVar) {
        m.e(lVar, "builder");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        lVar.invoke(initializerViewModelFactoryBuilder);
        return initializerViewModelFactoryBuilder.build();
    }
}
