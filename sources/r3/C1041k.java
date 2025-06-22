package r3;

import V2.g;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import q3.a;
import s3.h;
import s3.p;

/* renamed from: r3.k  reason: case insensitive filesystem */
abstract /* synthetic */ class C1041k {
    public static final C1035e a(C1035e eVar, int i4, a aVar) {
        int i5;
        if (i4 < 0 && i4 != -2 && i4 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i4).toString());
        } else if (i4 != -1 || aVar == a.SUSPEND) {
            if (i4 == -1) {
                aVar = a.DROP_OLDEST;
                i5 = 0;
            } else {
                i5 = i4;
            }
            a aVar2 = aVar;
            if (eVar instanceof p) {
                return p.a.a((p) eVar, (g) null, i5, aVar2, 1, (Object) null);
            }
            return new h(eVar, (g) null, i5, aVar2, 2, (C2103g) null);
        } else {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
    }

    public static /* synthetic */ C1035e b(C1035e eVar, int i4, a aVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = -2;
        }
        if ((i5 & 2) != 0) {
            aVar = a.SUSPEND;
        }
        return C1037g.b(eVar, i4, aVar);
    }

    private static final void c(g gVar) {
        if (gVar.get(C1001s0.f3726k0) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
        }
    }

    public static final C1035e d(C1035e eVar) {
        return b(eVar, -1, (a) null, 2, (Object) null);
    }

    public static final C1035e e(C1035e eVar, g gVar) {
        c(gVar);
        if (m.a(gVar, V2.h.f8445a)) {
            return eVar;
        }
        if (eVar instanceof p) {
            return p.a.a((p) eVar, gVar, 0, (a) null, 6, (Object) null);
        }
        return new h(eVar, gVar, 0, (a) null, 12, (C2103g) null);
    }
}
