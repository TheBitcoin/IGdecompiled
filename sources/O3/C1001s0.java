package o3;

import V2.d;
import V2.g;
import d3.l;
import d3.p;
import java.util.concurrent.CancellationException;

/* renamed from: o3.s0  reason: case insensitive filesystem */
public interface C1001s0 extends g.b {

    /* renamed from: k0  reason: collision with root package name */
    public static final b f3726k0 = b.f3727a;

    /* renamed from: o3.s0$a */
    public static final class a {
        public static /* synthetic */ void a(C1001s0 s0Var, CancellationException cancellationException, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    cancellationException = null;
                }
                s0Var.a(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static Object b(C1001s0 s0Var, Object obj, p pVar) {
            return g.b.a.a(s0Var, obj, pVar);
        }

        public static g.b c(C1001s0 s0Var, g.c cVar) {
            return g.b.a.b(s0Var, cVar);
        }

        public static /* synthetic */ Z d(C1001s0 s0Var, boolean z4, boolean z5, l lVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    z4 = false;
                }
                if ((i4 & 2) != 0) {
                    z5 = true;
                }
                return s0Var.E(z4, z5, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static g e(C1001s0 s0Var, g.c cVar) {
            return g.b.a.c(s0Var, cVar);
        }

        public static g f(C1001s0 s0Var, g gVar) {
            return g.b.a.d(s0Var, gVar);
        }
    }

    /* renamed from: o3.s0$b */
    public static final class b implements g.c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f3727a = new b();

        private b() {
        }
    }

    boolean A();

    Z E(boolean z4, boolean z5, l lVar);

    void a(CancellationException cancellationException);

    Object g(d dVar);

    C1001s0 getParent();

    Z i(l lVar);

    boolean isActive();

    boolean isCancelled();

    C1000s k(C1004u uVar);

    CancellationException l();

    boolean start();
}
