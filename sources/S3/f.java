package s3;

import V2.d;
import V2.g;
import W2.b;
import d3.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.G;
import r3.C1036f;
import t3.J;

public abstract class f {
    /* JADX INFO: finally extract failed */
    public static final Object b(g gVar, Object obj, Object obj2, p pVar, d dVar) {
        Object c5 = J.c(gVar, obj2);
        try {
            Object invoke = ((p) G.b(pVar, 2)).invoke(obj, new x(dVar, gVar));
            J.a(gVar, c5);
            if (invoke == b.c()) {
                h.c(dVar);
            }
            return invoke;
        } catch (Throwable th) {
            J.a(gVar, c5);
            throw th;
        }
    }

    public static /* synthetic */ Object c(g gVar, Object obj, Object obj2, p pVar, d dVar, int i4, Object obj3) {
        if ((i4 & 4) != 0) {
            obj2 = J.b(gVar);
        }
        return b(gVar, obj, obj2, pVar, dVar);
    }

    /* access modifiers changed from: private */
    public static final C1036f d(C1036f fVar, g gVar) {
        boolean z4;
        if (fVar instanceof w) {
            z4 = true;
        } else {
            z4 = fVar instanceof r;
        }
        if (z4) {
            return fVar;
        }
        return new z(fVar, gVar);
    }
}
