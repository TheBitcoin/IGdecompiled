package t1;

import android.content.Context;
import android.os.Handler;
import q1.n;
import s1.C2274b;
import s1.C2275c;
import s1.C2276d;
import s1.C2277e;
import t1.C2287d;
import x1.C2349a;

/* renamed from: t1.i  reason: case insensitive filesystem */
public class C2292i implements C2287d.a, C2275c {

    /* renamed from: f  reason: collision with root package name */
    private static C2292i f21808f;

    /* renamed from: a  reason: collision with root package name */
    private float f21809a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final C2277e f21810b;

    /* renamed from: c  reason: collision with root package name */
    private final C2274b f21811c;

    /* renamed from: d  reason: collision with root package name */
    private C2276d f21812d;

    /* renamed from: e  reason: collision with root package name */
    private C2286c f21813e;

    public C2292i(C2277e eVar, C2274b bVar) {
        this.f21810b = eVar;
        this.f21811c = bVar;
    }

    private C2286c a() {
        if (this.f21813e == null) {
            this.f21813e = C2286c.e();
        }
        return this.f21813e;
    }

    public static C2292i d() {
        if (f21808f == null) {
            f21808f = new C2292i(new C2277e(), new C2274b());
        }
        return f21808f;
    }

    public void b(Context context) {
        this.f21812d = this.f21810b.a(new Handler(), context, this.f21811c.a(), this);
    }

    public float c() {
        return this.f21809a;
    }

    public void e() {
        C2285b.k().b(this);
        C2285b.k().i();
        C2349a.p().q();
        this.f21812d.d();
    }

    public void f() {
        C2349a.p().s();
        C2285b.k().j();
        this.f21812d.e();
    }

    public void a(float f4) {
        this.f21809a = f4;
        for (n t4 : a().a()) {
            t4.t().b(f4);
        }
    }

    public void a(boolean z4) {
        if (z4) {
            C2349a.p().q();
        } else {
            C2349a.p().o();
        }
    }
}
