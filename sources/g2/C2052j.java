package g2;

import android.content.Context;
import com.squareup.picasso.s;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.j  reason: case insensitive filesystem */
public final class C2052j extends C2045c {

    /* renamed from: n  reason: collision with root package name */
    public static final a f20686n = new a((C2103g) null);

    /* renamed from: k  reason: collision with root package name */
    private final long f20687k;

    /* renamed from: l  reason: collision with root package name */
    private final String f20688l;

    /* renamed from: m  reason: collision with root package name */
    private String f20689m;

    /* renamed from: g2.j$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            com.uptodown.activities.preferences.a.f18818a.a(context);
        }

        public final boolean b(Context context, long j4) {
            m.e(context, "context");
            if (j4 <= -1) {
                return false;
            }
            return C2045c.f20544j.a(d(context), j4);
        }

        public final C2052j c(JSONObject jSONObject) {
            String str;
            String str2;
            long j4;
            m.e(jSONObject, "jsonObjectData");
            if (!jSONObject.isNull("imgURL")) {
                str = jSONObject.optString("imgURL");
                s.h().l(str).d();
            } else {
                str = null;
            }
            if (!jSONObject.isNull("packageName")) {
                str2 = jSONObject.optString("packageName");
            } else {
                str2 = null;
            }
            if (!jSONObject.isNull("appID")) {
                j4 = jSONObject.optLong("appID");
            } else {
                j4 = -1;
            }
            if (j4 <= -1 || str2 == null || str2.length() == 0 || str == null || str.length() == 0) {
                return null;
            }
            return new C2052j(j4, str2, str);
        }

        public final C2052j d(Context context) {
            m.e(context, "context");
            return com.uptodown.activities.preferences.a.f18818a.g(context);
        }

        private a() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2052j(long r8, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.m.e(r10, r0)
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.m.e(r11, r0)
            java.lang.String r6 = "banner"
            r1 = r7
            r2 = r8
            r4 = r10
            r5 = r11
            r1.<init>(r2, r4, r5, r6)
            r1.f20687k = r2
            r1.f20688l = r4
            r1.f20689m = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.C2052j.<init>(long, java.lang.String, java.lang.String):void");
    }

    public void A(String str) {
        m.e(str, "<set-?>");
        this.f20689m = str;
    }

    public long k() {
        return this.f20687k;
    }

    public String n() {
        return this.f20689m;
    }

    public String r() {
        return this.f20688l;
    }

    public void t(Context context) {
        m.e(context, "context");
        com.uptodown.activities.preferences.a.f18818a.n0(context, this);
    }
}
