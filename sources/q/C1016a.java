package q;

import K0.C1494c;
import K0.C1495d;
import K0.C1496e;
import L0.a;
import t.C1046a;
import t.C1047b;
import t.C1048c;
import t.C1049d;
import t.C1050e;

/* renamed from: q.a  reason: case insensitive filesystem */
public final class C1016a implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3938a = new C1016a();

    /* renamed from: q.a$a  reason: collision with other inner class name */
    private static final class C0034a implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final C0034a f3939a = new C0034a();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3940b = C1494c.a("window").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f3941c = C1494c.a("logSourceMetrics").b(N0.a.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final C1494c f3942d = C1494c.a("globalMetrics").b(N0.a.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final C1494c f3943e = C1494c.a("appNamespace").b(N0.a.b().c(4).a()).a();

        private C0034a() {
        }

        /* renamed from: b */
        public void a(C1046a aVar, C1496e eVar) {
            eVar.a(f3940b, aVar.d());
            eVar.a(f3941c, aVar.c());
            eVar.a(f3942d, aVar.b());
            eVar.a(f3943e, aVar.a());
        }
    }

    /* renamed from: q.a$b */
    private static final class b implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final b f3944a = new b();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3945b = C1494c.a("storageMetrics").b(N0.a.b().c(1).a()).a();

        private b() {
        }

        /* renamed from: b */
        public void a(C1047b bVar, C1496e eVar) {
            eVar.a(f3945b, bVar.a());
        }
    }

    /* renamed from: q.a$c */
    private static final class c implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final c f3946a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3947b = C1494c.a("eventsDroppedCount").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f3948c = C1494c.a("reason").b(N0.a.b().c(3).a()).a();

        private c() {
        }

        /* renamed from: b */
        public void a(C1048c cVar, C1496e eVar) {
            eVar.c(f3947b, cVar.a());
            eVar.a(f3948c, cVar.b());
        }
    }

    /* renamed from: q.a$d */
    private static final class d implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final d f3949a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3950b = C1494c.a("logSource").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f3951c = C1494c.a("logEventDropped").b(N0.a.b().c(2).a()).a();

        private d() {
        }

        /* renamed from: b */
        public void a(C1049d dVar, C1496e eVar) {
            eVar.a(f3950b, dVar.b());
            eVar.a(f3951c, dVar.a());
        }
    }

    /* renamed from: q.a$e */
    private static final class e implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final e f3952a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3953b = C1494c.d("clientMetrics");

        private e() {
        }

        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            android.support.v4.media.a.a(obj);
            b((m) null, (C1496e) obj2);
        }

        public void b(m mVar, C1496e eVar) {
            throw null;
        }
    }

    /* renamed from: q.a$f */
    private static final class f implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final f f3954a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3955b = C1494c.a("currentCacheSizeBytes").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f3956c = C1494c.a("maxCacheSizeBytes").b(N0.a.b().c(2).a()).a();

        private f() {
        }

        /* renamed from: b */
        public void a(C1050e eVar, C1496e eVar2) {
            eVar2.c(f3955b, eVar.a());
            eVar2.c(f3956c, eVar.b());
        }
    }

    /* renamed from: q.a$g */
    private static final class g implements C1495d {

        /* renamed from: a  reason: collision with root package name */
        static final g f3957a = new g();

        /* renamed from: b  reason: collision with root package name */
        private static final C1494c f3958b = C1494c.a("startMs").b(N0.a.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final C1494c f3959c = C1494c.a("endMs").b(N0.a.b().c(2).a()).a();

        private g() {
        }

        /* renamed from: b */
        public void a(t.f fVar, C1496e eVar) {
            eVar.c(f3958b, fVar.b());
            eVar.c(f3959c, fVar.a());
        }
    }

    private C1016a() {
    }

    public void a(L0.b bVar) {
        bVar.a(m.class, e.f3952a);
        bVar.a(C1046a.class, C0034a.f3939a);
        bVar.a(t.f.class, g.f3957a);
        bVar.a(C1049d.class, d.f3949a);
        bVar.a(C1048c.class, c.f3946a);
        bVar.a(C1047b.class, b.f3944a);
        bVar.a(C1050e.class, f.f3954a);
    }
}
