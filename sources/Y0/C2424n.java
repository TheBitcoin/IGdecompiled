package y0;

import E0.g;
import c1.C1649b;

/* renamed from: y0.n  reason: case insensitive filesystem */
public class C2424n implements C1649b {

    /* renamed from: a  reason: collision with root package name */
    private final D f22663a;

    /* renamed from: b  reason: collision with root package name */
    private final C2423m f22664b;

    public C2424n(D d5, g gVar) {
        this.f22663a = d5;
        this.f22664b = new C2423m(gVar);
    }

    public boolean a() {
        return this.f22663a.d();
    }

    public C1649b.a b() {
        return C1649b.a.CRASHLYTICS;
    }

    public void c(C1649b.C0162b bVar) {
        v0.g f4 = v0.g.f();
        f4.b("App Quality Sessions session changed: " + bVar);
        this.f22664b.f(bVar.a());
    }

    public String d(String str) {
        return this.f22664b.c(str);
    }

    public void e(String str) {
        this.f22664b.g(str);
    }
}
