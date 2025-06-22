package o3;

import R2.m;
import R2.n;
import V2.d;
import d3.l;
import kotlin.jvm.internal.C2103g;

public abstract class E {
    public static final Object a(Object obj, d dVar) {
        if (!(obj instanceof A)) {
            return m.a(obj);
        }
        m.a aVar = m.f8216a;
        return m.a(n.a(((A) obj).f3624a));
    }

    public static final Object b(Object obj, l lVar) {
        Throwable b5 = m.b(obj);
        if (b5 != null) {
            return new A(b5, false, 2, (C2103g) null);
        }
        if (lVar != null) {
            return new B(obj, lVar);
        }
        return obj;
    }

    public static final Object c(Object obj, C0989m mVar) {
        Throwable b5 = m.b(obj);
        if (b5 == null) {
            return obj;
        }
        return new A(b5, false, 2, (C2103g) null);
    }

    public static /* synthetic */ Object d(Object obj, l lVar, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
