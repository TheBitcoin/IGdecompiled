package g2;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.adselection.u;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: g2.a  reason: case insensitive filesystem */
public final class C2043a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0250a f20521f = new C0250a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f20522a;

    /* renamed from: b  reason: collision with root package name */
    private final long f20523b;

    /* renamed from: c  reason: collision with root package name */
    private int f20524c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f20525d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f20526e = b.DOWNLOADED;

    /* renamed from: g2.a$a  reason: collision with other inner class name */
    public static final class C0250a {
        public /* synthetic */ C0250a(C2103g gVar) {
            this();
        }

        public final b a(int i4) {
            b bVar = b.DOWNLOADED;
            if (i4 == bVar.ordinal()) {
                return bVar;
            }
            b bVar2 = b.INSTALLED;
            if (i4 == bVar2.ordinal()) {
                return bVar2;
            }
            throw new IllegalArgumentException();
        }

        private C0250a() {
        }
    }

    /* renamed from: g2.a$b */
    public enum b {
        DOWNLOADED,
        INSTALLED;

        static {
            b[] a5;
            f20530d = X2.b.a(a5);
        }
    }

    public C2043a(String str, long j4) {
        m.e(str, "packageName");
        this.f20522a = str;
        this.f20523b = j4;
    }

    public final int a() {
        return this.f20525d;
    }

    public final int b() {
        return this.f20524c;
    }

    public final String c() {
        return this.f20522a;
    }

    public final b d() {
        return this.f20526e;
    }

    public final long e() {
        return this.f20523b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2043a)) {
            return false;
        }
        C2043a aVar = (C2043a) obj;
        if (m.a(this.f20522a, aVar.f20522a) && this.f20523b == aVar.f20523b) {
            return true;
        }
        return false;
    }

    public final C2043a f(Context context) {
        C2043a aVar;
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        int i4 = this.f20525d;
        if (i4 != -1) {
            aVar = a5.U(i4);
        } else {
            int i5 = this.f20524c;
            if (i5 != -1) {
                aVar = a5.W(i5);
            } else {
                aVar = a5.V(this.f20522a, this.f20523b);
            }
        }
        a5.i();
        return aVar;
    }

    public final void g(Context context) {
        C2043a aVar;
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        int i4 = this.f20525d;
        if (i4 != -1) {
            aVar = a5.U(i4);
        } else {
            int i5 = this.f20524c;
            if (i5 != -1) {
                aVar = a5.W(i5);
            } else {
                aVar = a5.V(this.f20522a, this.f20523b);
            }
        }
        if (aVar != null) {
            a5.q1(this);
        } else {
            a5.H0(this);
        }
        a5.i();
    }

    public final void h(int i4) {
        this.f20525d = i4;
    }

    public int hashCode() {
        return (this.f20522a.hashCode() * 31) + u.a(this.f20523b);
    }

    public final void i(int i4) {
        this.f20524c = i4;
    }

    public final void j(b bVar) {
        m.e(bVar, "<set-?>");
        this.f20526e = bVar;
    }

    public String toString() {
        return "ActiveNotification(packageName=" + this.f20522a + ", versionCode=" + this.f20523b + ')';
    }
}
