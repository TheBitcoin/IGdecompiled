package g2;

import android.content.Context;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: g2.A  reason: case insensitive filesystem */
public final class C2033A {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20327f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20328a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20329b;

    /* renamed from: c  reason: collision with root package name */
    private int f20330c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f20331d;

    /* renamed from: e  reason: collision with root package name */
    private long f20332e;

    /* renamed from: g2.A$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            com.uptodown.activities.preferences.a.f18818a.c(context);
        }

        public final C2033A b(Context context) {
            m.e(context, "context");
            C2033A A4 = com.uptodown.activities.preferences.a.f18818a.A(context);
            if (A4 == null) {
                return null;
            }
            if (A4.h()) {
                return A4;
            }
            a(context);
            return null;
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public final boolean h() {
        if (this.f20328a <= -1 || this.f20329b == null) {
            return false;
        }
        long j4 = this.f20331d;
        if (j4 <= 0 || j4 + ((long) 86400000) <= System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public final long b() {
        return this.f20328a;
    }

    public final int c() {
        return this.f20330c;
    }

    public final String d() {
        return this.f20329b;
    }

    public final long e() {
        return this.f20331d;
    }

    public final long f() {
        return this.f20332e;
    }

    public final boolean g() {
        if (this.f20332e > 0) {
            return true;
        }
        return false;
    }

    public final void i(Context context) {
        m.e(context, "context");
        com.uptodown.activities.preferences.a.f18818a.p0(context, this);
    }

    public final void j(long j4) {
        this.f20328a = j4;
    }

    public final void k(int i4) {
        this.f20330c = i4;
    }

    public final void l(Context context, int i4) {
        m.e(context, "context");
        this.f20330c = i4;
        i(context);
    }

    public final void m(String str) {
        this.f20329b = str;
    }

    public final void n(Context context) {
        m.e(context, "context");
        this.f20331d = System.currentTimeMillis();
        i(context);
    }

    public final void o(long j4) {
        this.f20331d = j4;
    }

    public final void p(Context context) {
        m.e(context, "context");
        this.f20332e = System.currentTimeMillis();
        i(context);
    }

    public final void q(long j4) {
        this.f20332e = j4;
    }

    public String toString() {
        return "NotificationFCM(appId=" + this.f20328a + ", packageName=" + this.f20329b + ", downloadId=" + this.f20330c + ')';
    }
}
