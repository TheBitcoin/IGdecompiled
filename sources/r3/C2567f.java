package R3;

import P3.C2546b;
import P3.C2547c;
import P3.C2548d;
import P3.C2549e;
import R3.C2565d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: R3.f  reason: case insensitive filesystem */
public class C2567f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f23928b = C2546b.i(C2567f.class);

    /* renamed from: a  reason: collision with root package name */
    protected final C2548d f23929a;

    /* renamed from: R3.f$a */
    static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private final C2567f f23930a;

        a(C2567f fVar) {
            this.f23930a = fVar;
        }

        public abstract C2548d a();

        /* access modifiers changed from: package-private */
        public C2548d b() {
            return this.f23930a.f23929a;
        }

        public void c(C2549e eVar) {
            eVar.k(a());
        }
    }

    /* renamed from: R3.f$b */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private C2565d f23931a;

        /* renamed from: b  reason: collision with root package name */
        private final C2567f f23932b;

        /* renamed from: c  reason: collision with root package name */
        private C2565d.a f23933c = new C2565d.a.C0289a();

        /* renamed from: d  reason: collision with root package name */
        private boolean f23934d = false;

        /* renamed from: e  reason: collision with root package name */
        private String f23935e;

        b(C2565d dVar, C2567f fVar) {
            this.f23931a = dVar;
            this.f23932b = fVar;
        }

        public void a(C2549e eVar) {
            if (this.f23931a == null) {
                this.f23931a = new C2565d(eVar);
            }
            String str = this.f23935e;
            if (str != null) {
                this.f23931a.e(str);
            }
            if (this.f23934d) {
                this.f23931a.f(this.f23932b.f23929a, this.f23933c);
            } else {
                this.f23931a.h(this.f23932b.f23929a, this.f23933c);
            }
        }
    }

    /* renamed from: R3.f$c */
    public static class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private final String f23936b;

        /* renamed from: c  reason: collision with root package name */
        private final C2563b f23937c = new C2563b();

        /* renamed from: d  reason: collision with root package name */
        private final Map f23938d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private String f23939e;

        /* renamed from: f  reason: collision with root package name */
        private String f23940f;

        /* renamed from: g  reason: collision with root package name */
        private String f23941g;

        c(C2567f fVar, String str) {
            super(fVar);
            this.f23936b = str;
        }

        public C2548d a() {
            if (this.f23936b != null) {
                C2548d c5 = new C2548d(b()).c(C2547c.URL_PATH, this.f23936b).c(C2547c.ACTION_NAME, this.f23939e).c(C2547c.CAMPAIGN_NAME, this.f23940f).c(C2547c.CAMPAIGN_KEYWORD, this.f23941g);
                if (this.f23937c.a() > 0) {
                    c5.c(C2547c.SCREEN_SCOPE_CUSTOM_VARIABLES, this.f23937c.toString());
                }
                for (Map.Entry entry : this.f23938d.entrySet()) {
                    C2562a.b(c5, ((Integer) entry.getKey()).intValue(), (String) entry.getValue());
                }
                return c5;
            }
            throw new IllegalArgumentException("Screen tracking requires a non-empty path");
        }

        public /* bridge */ /* synthetic */ void c(C2549e eVar) {
            super.c(eVar);
        }
    }

    private C2567f() {
        this((C2548d) null);
    }

    public static C2567f c() {
        return new C2567f();
    }

    public b a() {
        return new b((C2565d) null, this);
    }

    public c b(String str) {
        return new c(this, str);
    }

    private C2567f(C2548d dVar) {
        this.f23929a = dVar == null ? new C2548d() : dVar;
    }
}
