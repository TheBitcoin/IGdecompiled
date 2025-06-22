package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.IntConsumer;

public final class M extends P implements C1177g2 {

    /* renamed from: b  reason: collision with root package name */
    public final IntConsumer f5368b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ void l(Integer num) {
        C1232t1.g(this, num);
    }

    public final Object b(C1144a aVar, i0 i0Var) {
        aVar.N(i0Var, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object c(C1144a aVar, i0 i0Var) {
        e(aVar, i0Var);
        return null;
    }

    public M(IntConsumer intConsumer, boolean z4) {
        super(z4);
        this.f5368b = intConsumer;
    }

    public final void accept(int i4) {
        this.f5368b.accept(i4);
    }
}
