package q1;

import r1.C2218d;
import w1.C2340g;

/* renamed from: q1.a  reason: case insensitive filesystem */
public final class C2205a {

    /* renamed from: a  reason: collision with root package name */
    private final n f21505a;

    private C2205a(n nVar) {
        this.f21505a = nVar;
    }

    public static C2205a a(C2206b bVar) {
        n nVar = (n) bVar;
        C2340g.b(bVar, "AdSession is null");
        C2340g.l(nVar);
        C2340g.g(nVar);
        C2205a aVar = new C2205a(nVar);
        nVar.t().i(aVar);
        return aVar;
    }

    public void b() {
        C2340g.g(this.f21505a);
        C2340g.j(this.f21505a);
        if (!this.f21505a.q()) {
            try {
                this.f21505a.g();
            } catch (Exception unused) {
            }
        }
        if (this.f21505a.q()) {
            this.f21505a.x();
        }
    }

    public void c() {
        C2340g.f(this.f21505a);
        C2340g.j(this.f21505a);
        this.f21505a.y();
    }

    public void d(C2218d dVar) {
        C2340g.b(dVar, "VastProperties is null");
        C2340g.f(this.f21505a);
        C2340g.j(this.f21505a);
        this.f21505a.k(dVar.a());
    }
}
