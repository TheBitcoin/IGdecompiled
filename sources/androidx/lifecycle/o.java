package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import c3.C1704a;
import k3.c;
import kotlin.jvm.internal.m;

public abstract /* synthetic */ class o {
    static {
        ViewModelProvider.Factory.Companion companion = ViewModelProvider.Factory.Companion;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, Class cls) {
        m.e(cls, "modelClass");
        return ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel_release();
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        m.e(cls, "modelClass");
        m.e(creationExtras, "extras");
        return factory.create(cls);
    }

    public static ViewModel c(ViewModelProvider.Factory factory, c cVar, CreationExtras creationExtras) {
        m.e(cVar, "modelClass");
        m.e(creationExtras, "extras");
        return factory.create(C1704a.a(cVar), creationExtras);
    }

    public static ViewModelProvider.Factory d(ViewModelInitializer... viewModelInitializerArr) {
        return ViewModelProvider.Factory.Companion.from(viewModelInitializerArr);
    }
}
