package A0;

import E0.g;
import java.io.File;

/* renamed from: A0.e  reason: case insensitive filesystem */
public class C1269e {

    /* renamed from: c  reason: collision with root package name */
    private static final b f5699c = new b();

    /* renamed from: a  reason: collision with root package name */
    private final g f5700a;

    /* renamed from: b  reason: collision with root package name */
    private C1267c f5701b;

    public C1269e(g gVar) {
        this.f5700a = gVar;
        this.f5701b = f5699c;
    }

    private File d(String str) {
        return this.f5700a.q(str, "userlog");
    }

    public void a() {
        this.f5701b.d();
    }

    public byte[] b() {
        return this.f5701b.c();
    }

    public String c() {
        return this.f5701b.b();
    }

    public final void e(String str) {
        this.f5701b.a();
        this.f5701b = f5699c;
        if (str != null) {
            f(d(str), 65536);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(File file, int i4) {
        this.f5701b = new h(file, i4);
    }

    public void g(long j4, String str) {
        this.f5701b.e(j4, str);
    }

    public C1269e(g gVar, String str) {
        this(gVar);
        e(str);
    }

    /* renamed from: A0.e$b */
    private static final class b implements C1267c {
        private b() {
        }

        public String b() {
            return null;
        }

        public byte[] c() {
            return null;
        }

        public void a() {
        }

        public void d() {
        }

        public void e(long j4, String str) {
        }
    }
}
