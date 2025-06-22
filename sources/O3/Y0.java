package o3;

import R2.s;
import V2.d;
import V2.g;
import W2.b;
import kotlin.coroutines.jvm.internal.h;
import t3.C1060j;
import t3.C1061k;

public abstract class Y0 {
    public static final Object a(d dVar) {
        C1060j jVar;
        Object obj;
        g context = dVar.getContext();
        C1009w0.f(context);
        d b5 = b.b(dVar);
        if (b5 instanceof C1060j) {
            jVar = (C1060j) b5;
        } else {
            jVar = null;
        }
        if (jVar == null) {
            obj = s.f8222a;
        } else {
            if (jVar.f4496d.isDispatchNeeded(context)) {
                jVar.m(context, s.f8222a);
            } else {
                X0 x02 = new X0();
                g plus = context.plus(x02);
                s sVar = s.f8222a;
                jVar.m(plus, sVar);
                if (x02.f3682a) {
                    if (C1061k.d(jVar)) {
                        obj = b.c();
                    } else {
                        obj = sVar;
                    }
                }
            }
            obj = b.c();
        }
        if (obj == b.c()) {
            h.c(dVar);
        }
        if (obj == b.c()) {
            return obj;
        }
        return s.f8222a;
    }
}
