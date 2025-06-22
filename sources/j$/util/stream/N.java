package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.i0;
import java.util.function.LongConsumer;

public final class N extends P implements C1182h2 {

    /* renamed from: b  reason: collision with root package name */
    public final LongConsumer f5373b;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        i((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public final /* synthetic */ void i(Long l4) {
        C1232t1.i(this, l4);
    }

    public final Object b(C1144a aVar, i0 i0Var) {
        aVar.N(i0Var, this);
        return null;
    }

    public final /* bridge */ /* synthetic */ Object c(C1144a aVar, i0 i0Var) {
        e(aVar, i0Var);
        return null;
    }

    public N(LongConsumer longConsumer, boolean z4) {
        super(z4);
        this.f5373b = longConsumer;
    }

    public final void accept(long j4) {
        this.f5373b.accept(j4);
    }
}
