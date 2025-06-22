package androidx.lifecycle;

import R2.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d3.a;
import k3.c;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class ViewModelLazy<VM extends ViewModel> implements g {
    private VM cached;
    private final a extrasProducer;
    private final a factoryProducer;
    private final a storeProducer;
    private final c viewModelClass;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(c cVar, a aVar, a aVar2) {
        this(cVar, aVar, aVar2, (a) null, 8, (C2103g) null);
        m.e(cVar, "viewModelClass");
        m.e(aVar, "storeProducer");
        m.e(aVar2, "factoryProducer");
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    public ViewModelLazy(c cVar, a aVar, a aVar2, a aVar3) {
        m.e(cVar, "viewModelClass");
        m.e(aVar, "storeProducer");
        m.e(aVar2, "factoryProducer");
        m.e(aVar3, "extrasProducer");
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = ViewModelProvider.Companion.create((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewModelLazy(c cVar, a aVar, a aVar2, a aVar3, int i4, C2103g gVar) {
        this(cVar, aVar, aVar2, (i4 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
