package o3;

import V2.e;
import V2.g;
import V2.h;
import d3.p;

/* renamed from: o3.h  reason: case insensitive filesystem */
abstract /* synthetic */ class C0979h {
    public static final Object a(g gVar, p pVar) {
        g gVar2;
        C0970c0 c0Var;
        C0970c0 c0Var2;
        Thread currentThread = Thread.currentThread();
        e eVar = (e) gVar.get(e.f8442a0);
        if (eVar == null) {
            c0Var = S0.f3672a.b();
            gVar2 = F.e(C0988l0.f3711a, gVar.plus(c0Var));
        } else {
            C0970c0 c0Var3 = null;
            if (eVar instanceof C0970c0) {
                c0Var2 = (C0970c0) eVar;
            } else {
                c0Var2 = null;
            }
            if (c0Var2 != null) {
                if (c0Var2.P()) {
                    c0Var3 = c0Var2;
                }
                if (c0Var3 != null) {
                    c0Var = c0Var3;
                    gVar2 = F.e(C0988l0.f3711a, gVar);
                }
            }
            c0Var = S0.f3672a.a();
            gVar2 = F.e(C0988l0.f3711a, gVar);
        }
        C0973e eVar2 = new C0973e(gVar2, currentThread, c0Var);
        eVar2.O0(L.DEFAULT, eVar2, pVar);
        return eVar2.P0();
    }

    public static /* synthetic */ Object b(g gVar, p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = h.f8445a;
        }
        return C0977g.e(gVar, pVar);
    }
}
