package j$.util.stream;

import j$.util.Objects;
import j$.util.i0;
import java.util.Arrays;
import java.util.function.IntFunction;

public final class C2 extends C1175g0 {
    public final C1187i2 J(int i4, C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        if (W2.SORTED.n(i4)) {
            return i2Var;
        }
        return W2.SIZED.n(i4) ? new C1162d2(i2Var) : new C1162d2(i2Var);
    }

    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        if (W2.SORTED.n(aVar.f5463f)) {
            return aVar.y(i0Var, false, intFunction);
        }
        long[] jArr = (long[]) ((C0) aVar.y(i0Var, true, intFunction)).d();
        Arrays.sort(jArr);
        return new C1186i1(jArr);
    }
}
