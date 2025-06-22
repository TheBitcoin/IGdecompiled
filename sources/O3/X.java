package o3;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import t3.C1060j;
import t3.J;

public abstract class X {
    public static final void a(W w4, int i4) {
        boolean z4;
        d f4 = w4.f();
        if (i4 == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 || !(f4 instanceof C1060j) || b(i4) != b(w4.f3680c)) {
            d(w4, f4, z4);
            return;
        }
        G g4 = ((C1060j) f4).f4496d;
        g context = f4.getContext();
        if (g4.isDispatchNeeded(context)) {
            g4.dispatch(context, w4);
        } else {
            e(w4);
        }
    }

    public static final boolean b(int i4) {
        if (i4 == 1 || i4 == 2) {
            return true;
        }
        return false;
    }

    public static final boolean c(int i4) {
        if (i4 == 2) {
            return true;
        }
        return false;
    }

    public static final void d(W w4, d dVar, boolean z4) {
        Object h4;
        U0 u02;
        Object j4 = w4.j();
        Throwable g4 = w4.g(j4);
        if (g4 != null) {
            m.a aVar = m.f8216a;
            h4 = n.a(g4);
        } else {
            m.a aVar2 = m.f8216a;
            h4 = w4.h(j4);
        }
        Object a5 = m.a(h4);
        if (z4) {
            kotlin.jvm.internal.m.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            C1060j jVar = (C1060j) dVar;
            d dVar2 = jVar.f4497e;
            Object obj = jVar.f4499g;
            g context = dVar2.getContext();
            Object c5 = J.c(context, obj);
            if (c5 != J.f4469a) {
                u02 = F.g(dVar2, context, c5);
            } else {
                u02 = null;
            }
            try {
                jVar.f4497e.resumeWith(a5);
                s sVar = s.f8222a;
                if (u02 == null || u02.P0()) {
                    J.a(context, c5);
                }
            } catch (Throwable th) {
                if (u02 == null || u02.P0()) {
                    J.a(context, c5);
                }
                throw th;
            }
        } else {
            dVar.resumeWith(a5);
        }
    }

    private static final void e(W w4) {
        C0970c0 b5 = S0.f3672a.b();
        if (b5.L()) {
            b5.H(w4);
            return;
        }
        b5.J(true);
        try {
            d(w4, w4.f(), true);
            do {
            } while (b5.O());
        } catch (Throwable th) {
            b5.D(true);
            throw th;
        }
        b5.D(true);
    }
}
