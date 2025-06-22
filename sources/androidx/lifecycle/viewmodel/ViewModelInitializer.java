package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import c3.C1704a;
import d3.l;
import k3.c;
import kotlin.jvm.internal.m;

public final class ViewModelInitializer<T extends ViewModel> {
    private final c clazz;
    private final l initializer;

    public ViewModelInitializer(c cVar, l lVar) {
        m.e(cVar, "clazz");
        m.e(lVar, "initializer");
        this.clazz = cVar;
        this.initializer = lVar;
    }

    public final c getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> cls, l lVar) {
        this(C1704a.c(cls), lVar);
        m.e(cls, "clazz");
        m.e(lVar, "initializer");
    }
}
