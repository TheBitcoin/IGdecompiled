package j$.util.stream;

import j$.util.i0;
import java.util.function.Consumer;

public final class O extends P {

    /* renamed from: b  reason: collision with root package name */
    public final Consumer f5377b;

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final Object b(C1144a aVar, i0 i0Var) {
        aVar.N(i0Var, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object c(C1144a aVar, i0 i0Var) {
        e(aVar, i0Var);
        return null;
    }

    public O(Consumer consumer, boolean z4) {
        super(z4);
        this.f5377b = consumer;
    }

    public final void accept(Object obj) {
        this.f5377b.accept(obj);
    }
}
