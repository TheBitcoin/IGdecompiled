package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.DoubleConsumer;

public final class L extends P implements C1172f2 {

    /* renamed from: b  reason: collision with root package name */
    public final DoubleConsumer f5364b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        o((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ void o(Double d5) {
        C1232t1.e(this, d5);
    }

    public final Object b(C1144a aVar, i0 i0Var) {
        aVar.N(i0Var, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object c(C1144a aVar, i0 i0Var) {
        e(aVar, i0Var);
        return null;
    }

    public L(DoubleConsumer doubleConsumer, boolean z4) {
        super(z4);
        this.f5364b = doubleConsumer;
    }

    public final void accept(double d5) {
        this.f5364b.accept(d5);
    }
}
