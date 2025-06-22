package o3;

import R2.m;
import R2.n;
import R2.s;

final class K0 extends z0 {

    /* renamed from: e  reason: collision with root package name */
    private final C0991n f3658e;

    public K0(C0991n nVar) {
        this.f3658e = nVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return s.f8222a;
    }

    public void r(Throwable th) {
        Object f02 = s().f0();
        if (f02 instanceof A) {
            C0991n nVar = this.f3658e;
            m.a aVar = m.f8216a;
            nVar.resumeWith(m.a(n.a(((A) f02).f3624a)));
            return;
        }
        C0991n nVar2 = this.f3658e;
        m.a aVar2 = m.f8216a;
        nVar2.resumeWith(m.a(B0.h(f02)));
    }
}
