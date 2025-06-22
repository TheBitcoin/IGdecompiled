package q;

import o.C0962c;
import o.C0963d;
import o.h;
import o.i;
import o.k;

final class s implements i {

    /* renamed from: a  reason: collision with root package name */
    private final p f4020a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4021b;

    /* renamed from: c  reason: collision with root package name */
    private final C0962c f4022c;

    /* renamed from: d  reason: collision with root package name */
    private final h f4023d;

    /* renamed from: e  reason: collision with root package name */
    private final t f4024e;

    s(p pVar, String str, C0962c cVar, h hVar, t tVar) {
        this.f4020a = pVar;
        this.f4021b = str;
        this.f4022c = cVar;
        this.f4023d = hVar;
        this.f4024e = tVar;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    public void a(C0963d dVar) {
        b(dVar, new r());
    }

    public void b(C0963d dVar, k kVar) {
        this.f4024e.a(o.a().e(this.f4020a).c(dVar).f(this.f4021b).d(this.f4023d).b(this.f4022c).a(), kVar);
    }

    /* access modifiers changed from: package-private */
    public p d() {
        return this.f4020a;
    }
}
