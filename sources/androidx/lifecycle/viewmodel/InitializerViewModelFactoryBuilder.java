package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders_jvmKt;
import d3.l;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.c;
import kotlin.jvm.internal.m;

@ViewModelFactoryDsl
public final class InitializerViewModelFactoryBuilder {
    private final Map<c, ViewModelInitializer<?>> initializers = new LinkedHashMap();

    public final <T extends ViewModel> void addInitializer(c cVar, l lVar) {
        m.e(cVar, "clazz");
        m.e(lVar, "initializer");
        if (!this.initializers.containsKey(cVar)) {
            this.initializers.put(cVar, new ViewModelInitializer(cVar, lVar));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + ViewModelProviders_jvmKt.getCanonicalName(cVar) + '.').toString());
    }

    public final ViewModelProvider.Factory build() {
        return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel_release((Collection<? extends ViewModelInitializer<?>>) this.initializers.values());
    }
}
