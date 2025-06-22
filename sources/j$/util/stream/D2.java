package j$.util.stream;

import j$.util.C1131f;
import j$.util.Objects;
import j$.util.i0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public final class D2 extends Z1 {

    /* renamed from: m  reason: collision with root package name */
    public final boolean f5272m;

    /* renamed from: n  reason: collision with root package name */
    public final Comparator f5273n;

    public D2(C1147a2 a2Var) {
        super(a2Var, W2.f5432q | W2.f5430o, 0);
        this.f5272m = true;
        this.f5273n = C1131f.INSTANCE;
    }

    public D2(C1147a2 a2Var, Comparator comparator) {
        super(a2Var, W2.f5432q | W2.f5431p, 0);
        this.f5272m = false;
        this.f5273n = (Comparator) Objects.requireNonNull(comparator);
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        if (W2.SORTED.n(i4) && this.f5272m) {
            return i2Var;
        }
        boolean n4 = W2.SIZED.n(i4);
        Comparator comparator = this.f5273n;
        if (n4) {
            return new C1245w2(i2Var, comparator);
        }
        return new C1245w2(i2Var, comparator);
    }

    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        if (W2.SORTED.n(aVar.f5463f) && this.f5272m) {
            return aVar.y(i0Var, false, intFunction);
        }
        Object[] n4 = aVar.y(i0Var, true, intFunction).n(intFunction);
        Arrays.sort(n4, this.f5273n);
        return new H0(n4);
    }
}
