package j$.util.stream;

import j$.util.i0;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class D implements C3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f5265a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f5266b;

    /* renamed from: c  reason: collision with root package name */
    public final Predicate f5267c;

    /* renamed from: d  reason: collision with root package name */
    public final Supplier f5268d;

    public D(boolean z4, X2 x22, Object obj, Predicate predicate, Supplier supplier) {
        this.f5265a = (z4 ? 0 : W2.f5433r) | W2.f5436u;
        this.f5266b = obj;
        this.f5267c = predicate;
        this.f5268d = supplier;
    }

    public final int d() {
        return this.f5265a;
    }

    public final Object b(C1144a aVar, i0 i0Var) {
        D3 d32 = (D3) this.f5268d.get();
        aVar.N(i0Var, d32);
        Object obj = d32.get();
        if (obj != null) {
            return obj;
        }
        return this.f5266b;
    }

    public final Object c(C1144a aVar, i0 i0Var) {
        return new J(this, W2.ORDERED.n(aVar.f5463f), aVar, i0Var).invoke();
    }
}
