package o3;

import V2.d;
import t3.C1060j;

/* renamed from: o3.p  reason: case insensitive filesystem */
public abstract class C0995p {
    public static final void a(C0989m mVar, Z z4) {
        mVar.q(new C0966a0(z4));
    }

    public static final C0991n b(d dVar) {
        if (!(dVar instanceof C1060j)) {
            return new C0991n(dVar, 1);
        }
        C0991n l4 = ((C1060j) dVar).l();
        if (l4 != null) {
            if (!l4.K()) {
                l4 = null;
            }
            if (l4 != null) {
                return l4;
            }
        }
        return new C0991n(dVar, 2);
    }
}
