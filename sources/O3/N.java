package o3;

import R2.m;
import R2.n;
import V2.d;
import t3.C1060j;

public abstract class N {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(d dVar) {
        Object obj;
        if (dVar instanceof C1060j) {
            return dVar.toString();
        }
        try {
            m.a aVar = m.f8216a;
            obj = m.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            m.a aVar2 = m.f8216a;
            obj = m.a(n.a(th));
        }
        if (m.b(obj) != null) {
            obj = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) obj;
    }
}
