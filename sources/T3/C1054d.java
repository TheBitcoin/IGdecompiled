package t3;

import d3.p;

/* renamed from: t3.d  reason: case insensitive filesystem */
public abstract class C1054d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final F f4489a = new F("CLOSED");

    public static final C1055e b(C1055e eVar) {
        while (true) {
            Object a5 = eVar.f();
            if (a5 == f4489a) {
                return eVar;
            }
            C1055e eVar2 = (C1055e) a5;
            if (eVar2 != null) {
                eVar = eVar2;
            } else if (eVar.j()) {
                return eVar;
            }
        }
    }

    public static final Object c(C c5, long j4, p pVar) {
        while (true) {
            if (c5.f4463c >= j4 && !c5.h()) {
                return D.a(c5);
            }
            Object a5 = c5.f();
            if (a5 == f4489a) {
                return D.a(f4489a);
            }
            C c6 = (C) ((C1055e) a5);
            if (c6 == null) {
                c6 = (C) pVar.invoke(Long.valueOf(c5.f4463c + 1), c5);
                if (c5.l(c6)) {
                    if (c5.h()) {
                        c5.k();
                    }
                }
            }
            c5 = c6;
        }
    }
}
