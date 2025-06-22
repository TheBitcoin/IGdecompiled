package v3;

import V2.g;
import o3.G;
import t3.C1064n;

final class m extends G {

    /* renamed from: a  reason: collision with root package name */
    public static final m f4581a = new m();

    private m() {
    }

    public void dispatch(g gVar, Runnable runnable) {
        c.f4562g.F(runnable, l.f4580h, false);
    }

    public void dispatchYield(g gVar, Runnable runnable) {
        c.f4562g.F(runnable, l.f4580h, true);
    }

    public G limitedParallelism(int i4) {
        C1064n.a(i4);
        if (i4 >= l.f4576d) {
            return this;
        }
        return super.limitedParallelism(i4);
    }
}
