package g2;

import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: g2.v  reason: case insensitive filesystem */
public final class C2063v {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20775d = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20776a;

    /* renamed from: b  reason: collision with root package name */
    private long f20777b;

    /* renamed from: c  reason: collision with root package name */
    private String f20778c;

    /* renamed from: g2.v$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public final String a() {
        return this.f20778c;
    }

    public final String b() {
        String str = this.f20778c;
        if (str == null) {
            return null;
        }
        m.b(str);
        String str2 = this.f20778c;
        m.b(str2);
        String substring = str.substring(m3.m.R(str2, "/", 0, false, 6, (Object) null) + 1);
        m.d(substring, "substring(...)");
        return substring;
    }

    public final String c() {
        return this.f20776a;
    }

    public final long d() {
        return this.f20777b;
    }

    public final void e(String str) {
        this.f20778c = str;
    }

    public final void f(String str) {
        this.f20776a = str;
    }

    public final void g(long j4) {
        this.f20777b = j4;
    }

    public String toString() {
        return "{sha256='" + this.f20776a + "', size=" + this.f20777b + ", absolutePath='" + this.f20778c + "'}";
    }
}
