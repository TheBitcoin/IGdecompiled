package o3;

import R2.m;

/* renamed from: o3.x  reason: case insensitive filesystem */
public abstract class C1010x {
    public static final C1006v a(C1001s0 s0Var) {
        return new C1008w(s0Var);
    }

    public static /* synthetic */ C1006v b(C1001s0 s0Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            s0Var = null;
        }
        return a(s0Var);
    }

    public static final boolean c(C1006v vVar, Object obj) {
        Throwable b5 = m.b(obj);
        if (b5 == null) {
            return vVar.v(obj);
        }
        return vVar.u(b5);
    }
}
