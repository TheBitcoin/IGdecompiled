package g2;

import android.content.Context;
import android.database.Cursor;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.t;

/* renamed from: g2.B  reason: case insensitive filesystem */
public final class C2034B {

    /* renamed from: g  reason: collision with root package name */
    public static final a f20333g = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private int f20334a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20335b;

    /* renamed from: c  reason: collision with root package name */
    private String f20336c;

    /* renamed from: d  reason: collision with root package name */
    private String f20337d;

    /* renamed from: e  reason: collision with root package name */
    private String f20338e;

    /* renamed from: f  reason: collision with root package name */
    private String f20339f;

    /* renamed from: g2.B$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C2034B a(Context context) {
            m.e(context, "context");
            t a5 = t.f21927u.a(context);
            a5.a();
            C2034B q02 = a5.q0();
            a5.i();
            return q02;
        }

        private a() {
        }
    }

    public final String a() {
        return this.f20338e;
    }

    public final String b() {
        return this.f20339f;
    }

    public final int c() {
        return this.f20334a;
    }

    public final String d() {
        return this.f20337d;
    }

    public final String e() {
        return this.f20335b;
    }

    public final String f() {
        return this.f20336c;
    }

    public final void g(Cursor cursor) {
        m.e(cursor, "c");
        this.f20334a = cursor.getInt(0);
        this.f20335b = cursor.getString(1);
        this.f20336c = cursor.getString(2);
        this.f20337d = cursor.getString(3);
        this.f20338e = cursor.getString(4);
        this.f20339f = cursor.getString(5);
    }

    public final void h(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        a5.R0(this);
        if (a5.k() > 100) {
            a5.K(100);
        }
        a5.i();
    }

    public final void i(String str) {
        this.f20338e = str;
    }

    public final void j(String str) {
        this.f20339f = str;
    }

    public final void k(String str) {
        this.f20337d = str;
    }

    public final void l(String str) {
        this.f20335b = str;
    }

    public final void m(String str) {
        this.f20336c = str;
    }

    public String toString() {
        return "{id=" + this.f20334a + ", timestamp=" + this.f20335b + ", title='" + this.f20336c + "', msg='" + this.f20337d + "', actions='" + this.f20338e + "', extraInfo='" + this.f20339f + "'}";
    }
}
