package v0;

import B0.F;
import B0.G;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

public final class d implements C2327a {

    /* renamed from: c  reason: collision with root package name */
    private static final h f21966c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final R0.a f21967a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f21968b = new AtomicReference((Object) null);

    private static final class b implements h {
        private b() {
        }

        public File a() {
            return null;
        }

        public File b() {
            return null;
        }

        public File c() {
            return null;
        }

        public F.a d() {
            return null;
        }

        public File e() {
            return null;
        }

        public File f() {
            return null;
        }

        public File g() {
            return null;
        }
    }

    public d(R0.a aVar) {
        this.f21967a = aVar;
        aVar.a(new C2328b(this));
    }

    public static /* synthetic */ void f(d dVar, R0.b bVar) {
        dVar.getClass();
        g.f().b("Crashlytics native component now available.");
        dVar.f21968b.set((C2327a) bVar.get());
    }

    public void a(String str, String str2, long j4, G g4) {
        g f4 = g.f();
        f4.i("Deferring native open session: " + str);
        this.f21967a.a(new c(str, str2, j4, g4));
    }

    public h b(String str) {
        C2327a aVar = (C2327a) this.f21968b.get();
        if (aVar == null) {
            return f21966c;
        }
        return aVar.b(str);
    }

    public boolean c() {
        C2327a aVar = (C2327a) this.f21968b.get();
        if (aVar == null || !aVar.c()) {
            return false;
        }
        return true;
    }

    public boolean d(String str) {
        C2327a aVar = (C2327a) this.f21968b.get();
        if (aVar == null || !aVar.d(str)) {
            return false;
        }
        return true;
    }
}
