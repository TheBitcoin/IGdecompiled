package g2;

import android.content.Context;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.t;

/* renamed from: g2.G  reason: case insensitive filesystem */
public final class C2039G {

    /* renamed from: f  reason: collision with root package name */
    public static final a f20367f = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20368a;

    /* renamed from: b  reason: collision with root package name */
    private String f20369b;

    /* renamed from: c  reason: collision with root package name */
    private String f20370c;

    /* renamed from: d  reason: collision with root package name */
    private long f20371d;

    /* renamed from: e  reason: collision with root package name */
    private int f20372e;

    /* renamed from: g2.G$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            t a5 = t.f21927u.a(context);
            a5.a();
            a5.i1();
            a5.i();
        }

        public final C2039G b(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectData");
            C2039G g4 = new C2039G();
            g4.h(jSONObject);
            return g4;
        }

        public final C2039G c(Cursor cursor) {
            m.e(cursor, "c");
            C2039G g4 = new C2039G();
            g4.k(cursor.getLong(0));
            g4.l(cursor.getInt(1));
            return g4;
        }

        private a() {
        }
    }

    public C2039G(long j4, String str, String str2, boolean z4, long j5) {
        m.e(str, RewardPlus.NAME);
        this.f20368a = j4;
        this.f20369b = str;
        this.f20370c = str2;
        if (z4) {
            this.f20372e = 1;
        } else {
            this.f20372e = 0;
        }
        this.f20371d = j5;
    }

    /* access modifiers changed from: private */
    public final void h(JSONObject jSONObject) {
        if (!jSONObject.isNull("appID")) {
            this.f20368a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20369b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f20370c = jSONObject.optString("iconURL");
        }
        if (!jSONObject.isNull("addedAt")) {
            this.f20371d = jSONObject.optLong("addedAt");
        }
    }

    public final long b() {
        return this.f20371d;
    }

    public final long c() {
        return this.f20368a;
    }

    public final int d() {
        return this.f20372e;
    }

    public final String e() {
        return this.f20370c;
    }

    public final String f() {
        return this.f20369b;
    }

    public final void g(Cursor cursor) {
        m.e(cursor, "c");
        this.f20368a = cursor.getLong(0);
        this.f20372e = cursor.getInt(1);
    }

    public final void i(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        if (a5.v0(this.f20368a) == null) {
            a5.S0(this);
        }
        a5.i();
    }

    public final void j(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        a5.j1(this.f20368a);
        a5.i();
    }

    public final void k(long j4) {
        this.f20368a = j4;
    }

    public final void l(int i4) {
        this.f20372e = i4;
    }

    public final void m(String str) {
        this.f20370c = str;
    }

    public final void n(String str) {
        this.f20369b = str;
    }

    public String toString() {
        return "PreRegister(appID=" + this.f20368a + ", name=" + this.f20369b + ", icon=" + this.f20370c + ", addedAt=" + this.f20371d + ", automaticDownload=" + this.f20372e + ')';
    }

    public C2039G() {
    }
}
