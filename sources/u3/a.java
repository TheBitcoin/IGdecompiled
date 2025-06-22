package u3;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import W2.b;
import d3.l;
import d3.p;
import t3.C1061k;

public abstract class a {
    private static final void a(d dVar, Throwable th) {
        m.a aVar = m.f8216a;
        dVar.resumeWith(m.a(n.a(th)));
        throw th;
    }

    public static final void b(d dVar, d dVar2) {
        try {
            d b5 = b.b(dVar);
            m.a aVar = m.f8216a;
            C1061k.c(b5, m.a(s.f8222a), (l) null, 2, (Object) null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static final void c(p pVar, Object obj, d dVar, l lVar) {
        try {
            d b5 = b.b(b.a(pVar, obj, dVar));
            m.a aVar = m.f8216a;
            C1061k.b(b5, m.a(s.f8222a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, l lVar, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, dVar, lVar);
    }
}
