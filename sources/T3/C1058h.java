package t3;

import R2.a;
import V2.g;
import o3.H;
import o3.I;

/* renamed from: t3.h  reason: case insensitive filesystem */
public abstract class C1058h {
    public static final void a(g gVar, Throwable th) {
        for (H r4 : C1057g.a()) {
            try {
                r4.r(gVar, th);
            } catch (Throwable th2) {
                C1057g.b(I.b(th, th2));
            }
        }
        try {
            a.a(th, new C1059i(gVar));
        } catch (Throwable unused) {
        }
        C1057g.b(th);
    }
}
