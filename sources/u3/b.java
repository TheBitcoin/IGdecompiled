package u3;

import R2.m;
import R2.n;
import V2.d;
import V2.g;
import d3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.G;
import o3.A;
import o3.B0;
import t3.B;
import t3.J;

public abstract class b {
    public static final void a(p pVar, Object obj, d dVar) {
        g context;
        Object c5;
        d a5 = h.a(dVar);
        try {
            context = dVar.getContext();
            c5 = J.c(context, (Object) null);
            Object invoke = ((p) G.b(pVar, 2)).invoke(obj, a5);
            J.a(context, c5);
            if (invoke != W2.b.c()) {
                a5.resumeWith(m.a(invoke));
            }
        } catch (Throwable th) {
            m.a aVar = m.f8216a;
            a5.resumeWith(m.a(n.a(th)));
        }
    }

    public static final Object b(B b5, Object obj, p pVar) {
        Object obj2;
        try {
            obj2 = ((p) G.b(pVar, 2)).invoke(obj, b5);
        } catch (Throwable th) {
            obj2 = new A(th, false, 2, (C2103g) null);
        }
        if (obj2 == W2.b.c()) {
            return W2.b.c();
        }
        Object o02 = b5.o0(obj2);
        if (o02 == B0.f3641b) {
            return W2.b.c();
        }
        if (!(o02 instanceof A)) {
            return B0.h(o02);
        }
        throw ((A) o02).f3624a;
    }
}
