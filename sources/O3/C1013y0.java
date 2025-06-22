package o3;

import V2.g;
import java.util.concurrent.CancellationException;

/* renamed from: o3.y0  reason: case insensitive filesystem */
abstract /* synthetic */ class C1013y0 {
    public static final C1012y a(C1001s0 s0Var) {
        return new C1007v0(s0Var);
    }

    public static /* synthetic */ C1012y b(C1001s0 s0Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            s0Var = null;
        }
        return C1009w0.a(s0Var);
    }

    public static final void c(g gVar, CancellationException cancellationException) {
        C1001s0 s0Var = (C1001s0) gVar.get(C1001s0.f3726k0);
        if (s0Var != null) {
            s0Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void d(g gVar, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        C1009w0.c(gVar, cancellationException);
    }

    public static final void e(g gVar) {
        C1001s0 s0Var = (C1001s0) gVar.get(C1001s0.f3726k0);
        if (s0Var != null) {
            C1009w0.g(s0Var);
        }
    }

    public static final void f(C1001s0 s0Var) {
        if (!s0Var.isActive()) {
            throw s0Var.l();
        }
    }
}
