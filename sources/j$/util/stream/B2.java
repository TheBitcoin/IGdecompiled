package j$.util.stream;

import j$.util.Objects;
import j$.util.i0;
import java.util.Arrays;
import java.util.function.IntFunction;

public final class B2 extends Y {
    public final C1187i2 J(int i4, C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        if (W2.SORTED.n(i4)) {
            return i2Var;
        }
        return W2.SIZED.n(i4) ? new C1157c2(i2Var) : new C1157c2(i2Var);
    }

    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        if (W2.SORTED.n(aVar.f5463f)) {
            return aVar.y(i0Var, false, intFunction);
        }
        int[] iArr = (int[]) ((A0) aVar.y(i0Var, true, intFunction)).d();
        Arrays.sort(iArr);
        return new Z0(iArr);
    }
}
