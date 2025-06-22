package o3;

import V2.d;
import V2.e;
import V2.g;
import V2.h;
import d3.l;
import d3.p;
import kotlin.jvm.internal.m;
import t3.B;
import t3.J;
import u3.a;
import u3.b;

/* renamed from: o3.i  reason: case insensitive filesystem */
abstract /* synthetic */ class C0981i {
    public static final Q a(J j4, g gVar, L l4, p pVar) {
        S s4;
        g e5 = F.e(j4, gVar);
        if (l4.c()) {
            s4 = new C0(e5, pVar);
        } else {
            s4 = new S(e5, true);
        }
        s4.O0(l4, s4, pVar);
        return s4;
    }

    public static /* synthetic */ Q b(J j4, g gVar, L l4, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = h.f8445a;
        }
        if ((i4 & 2) != 0) {
            l4 = L.DEFAULT;
        }
        return C0977g.a(j4, gVar, l4, pVar);
    }

    public static final C1001s0 c(J j4, g gVar, L l4, p pVar) {
        C0965a aVar;
        g e5 = F.e(j4, gVar);
        if (l4.c()) {
            aVar = new D0(e5, pVar);
        } else {
            aVar = new N0(e5, true);
        }
        aVar.O0(l4, aVar, pVar);
        return aVar;
    }

    public static /* synthetic */ C1001s0 d(J j4, g gVar, L l4, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = h.f8445a;
        }
        if ((i4 & 2) != 0) {
            l4 = L.DEFAULT;
        }
        return C0977g.c(j4, gVar, l4, pVar);
    }

    public static final Object e(g gVar, p pVar, d dVar) {
        Object obj;
        g context = dVar.getContext();
        g d5 = F.d(context, gVar);
        C1009w0.f(d5);
        if (d5 == context) {
            B b5 = new B(d5, dVar);
            obj = b.b(b5, b5, pVar);
        } else {
            e.b bVar = e.f8442a0;
            if (m.a(d5.get(bVar), context.get(bVar))) {
                U0 u02 = new U0(d5, dVar);
                g context2 = u02.getContext();
                Object c5 = J.c(context2, (Object) null);
                try {
                    Object b6 = b.b(u02, u02, pVar);
                    J.a(context2, c5);
                    obj = b6;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    J.a(context2, c5);
                    throw th2;
                }
            } else {
                V v4 = new V(d5, dVar);
                a.d(pVar, v4, v4, (l) null, 4, (Object) null);
                obj = v4.P0();
            }
        }
        if (obj == W2.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return obj;
    }
}
