package T1;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0109a f8280f = new C0109a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f8281a;

    /* renamed from: b  reason: collision with root package name */
    private long f8282b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f8283c;

    /* renamed from: d  reason: collision with root package name */
    private long f8284d;

    /* renamed from: e  reason: collision with root package name */
    private long f8285e = -1;

    /* renamed from: T1.a$a  reason: collision with other inner class name */
    public static final class C0109a {
        public /* synthetic */ C0109a(C2103g gVar) {
            this();
        }

        private C0109a() {
        }
    }

    public final String a() {
        return this.f8283c;
    }

    public final String b() {
        return this.f8281a;
    }

    public final long c() {
        return this.f8285e;
    }

    public final long d() {
        return this.f8284d;
    }

    public final long e() {
        return this.f8282b;
    }

    public final void f(String str, long j4, String str2, long j5) {
        m.e(str, "packageName");
        m.e(str2, "appName");
        this.f8281a = str;
        this.f8282b = j4;
        this.f8283c = str2;
        this.f8284d = System.currentTimeMillis();
        this.f8285e = j5;
    }
}
