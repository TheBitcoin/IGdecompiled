package o3;

import V2.d;
import V2.g;
import d3.p;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.jvm.internal.h;
import t3.B;
import t3.C1056f;
import u3.b;

public abstract class K {
    public static final J a(g gVar) {
        if (gVar.get(C1001s0.f3726k0) == null) {
            gVar = gVar.plus(C1013y0.b((C1001s0) null, 1, (Object) null));
        }
        return new C1056f(gVar);
    }

    public static final void b(J j4, CancellationException cancellationException) {
        C1001s0 s0Var = (C1001s0) j4.getCoroutineContext().get(C1001s0.f3726k0);
        if (s0Var != null) {
            s0Var.a(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + j4).toString());
    }

    public static /* synthetic */ void c(J j4, CancellationException cancellationException, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cancellationException = null;
        }
        b(j4, cancellationException);
    }

    public static final Object d(p pVar, d dVar) {
        B b5 = new B(dVar.getContext(), dVar);
        Object b6 = b.b(b5, b5, pVar);
        if (b6 == W2.b.c()) {
            h.c(dVar);
        }
        return b6;
    }

    public static final void e(J j4) {
        C1009w0.f(j4.getCoroutineContext());
    }
}
