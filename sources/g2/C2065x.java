package g2;

import android.content.Context;
import com.squareup.picasso.s;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.x  reason: case insensitive filesystem */
public final class C2065x extends C2045c {

    /* renamed from: n  reason: collision with root package name */
    public static final a f20781n = new a((C2103g) null);

    /* renamed from: k  reason: collision with root package name */
    private final long f20782k;

    /* renamed from: l  reason: collision with root package name */
    private final String f20783l;

    /* renamed from: m  reason: collision with root package name */
    private String f20784m;

    /* renamed from: g2.x$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(Context context) {
            m.e(context, "context");
            com.uptodown.activities.preferences.a.f18818a.b(context);
        }

        public final boolean b(Context context, long j4) {
            m.e(context, "context");
            if (j4 <= -1) {
                return false;
            }
            return C2045c.f20544j.a(d(context), j4);
        }

        public final C2065x c(JSONObject jSONObject) {
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
            if (j4 <= -1 || str2 == null || str == null) {
                return null;
            }
            return new C2065x(j4, str2, str);
        }

        public final C2065x d(Context context) {
            m.e(context, "context");
            return com.uptodown.activities.preferences.a.f18818a.o(context);
        }

        private a() {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C2065x(long r8, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.m.e(r10, r0)
            java.lang.String r0 = "imageUrl"
            kotlin.jvm.internal.m.e(r11, r0)
            java.lang.String r6 = "interstitial"
            r1 = r7
            r2 = r8
            r4 = r10
            r5 = r11
            r1.<init>(r2, r4, r5, r6)
            r1.f20782k = r2
            r1.f20783l = r4
            r1.f20784m = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.C2065x.<init>(long, java.lang.String, java.lang.String):void");
    }

    public void A(String str) {
        m.e(str, "<set-?>");
        this.f20784m = str;
    }

    public long k() {
        return this.f20782k;
    }

    public String n() {
        return this.f20784m;
    }

    public String r() {
        return this.f20783l;
    }

    public void t(Context context) {
        m.e(context, "context");
        com.uptodown.activities.preferences.a.f18818a.o0(context, this);
    }
}
