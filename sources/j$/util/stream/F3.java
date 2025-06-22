package j$.util.stream;

import j$.util.i0;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class F3 extends Z1 {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5290m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Predicate f5291n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ F3(C1147a2 a2Var, int i4, Predicate predicate, int i5) {
        super(a2Var, i4, 0);
        this.f5290m = i5;
        this.f5291n = predicate;
    }

    public final i0 H(C1144a aVar, i0 i0Var) {
        switch (this.f5290m) {
            case 0:
                if (W2.ORDERED.n(aVar.f5463f)) {
                    return G(aVar, i0Var, new C1145a0(9)).spliterator();
                }
                return new J3(aVar.P(i0Var), this.f5291n, 1);
            default:
                if (W2.ORDERED.n(aVar.f5463f)) {
                    return G(aVar, i0Var, new C1145a0(9)).spliterator();
                }
                return new J3(aVar.P(i0Var), this.f5291n, 0);
        }
    }

    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        switch (this.f5290m) {
            case 0:
                return (E0) new I3(this, aVar, i0Var, intFunction).invoke();
            default:
                return (E0) new H3(this, aVar, i0Var, intFunction).invoke();
        }
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        switch (this.f5290m) {
            case 0:
                return new C1199l(this, i2Var);
            default:
                return new G3(this, i2Var, false);
        }
    }
}
