package g2;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class W {

    /* renamed from: j  reason: collision with root package name */
    public static final a f20497j = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20498a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20499b;

    /* renamed from: c  reason: collision with root package name */
    private String f20500c;

    /* renamed from: d  reason: collision with root package name */
    private String f20501d;

    /* renamed from: e  reason: collision with root package name */
    private String f20502e;

    /* renamed from: f  reason: collision with root package name */
    private long f20503f = -1;

    /* renamed from: g  reason: collision with root package name */
    private String f20504g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList f20505h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private long f20506i = -1;

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final W a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObject");
            W w4 = new W();
            if (!jSONObject.isNull("appID")) {
                w4.k(jSONObject.optLong("appID"));
            }
            if (!jSONObject.isNull(RewardPlus.NAME)) {
                w4.o(jSONObject.optString(RewardPlus.NAME));
            }
            if (!jSONObject.isNull(RewardPlus.ICON)) {
                w4.n(jSONObject.optString(RewardPlus.ICON));
            }
            if (!jSONObject.isNull("packagename")) {
                w4.p(jSONObject.optString("packagename"));
            }
            if (!jSONObject.isNull("wishlistAdded")) {
                w4.r(jSONObject.optString("wishlistAdded"));
            }
            if (!jSONObject.isNull("platformID")) {
                w4.q(jSONObject.optLong("platformID"));
            }
            if (!jSONObject.isNull("downloadStatus")) {
                w4.l(jSONObject.optString("downloadStatus"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("floatingCategories");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                    C2053k kVar = new C2053k(0, (String) null, (String) null, 7, (C2103g) null);
                    m.b(optJSONObject);
                    kVar.m(optJSONObject);
                    w4.c().add(kVar);
                }
            }
            return w4;
        }

        private a() {
        }
    }

    public final long a() {
        return this.f20498a;
    }

    public final String b() {
        return this.f20504g;
    }

    public final ArrayList c() {
        return this.f20505h;
    }

    public final String d() {
        if (this.f20500c == null) {
            return null;
        }
        return this.f20500c + UptodownApp.f17422D.r() + ":webp";
    }

    public final String e() {
        return this.f20499b;
    }

    public final String f() {
        return this.f20501d;
    }

    public final String g() {
        return this.f20502e;
    }

    public final boolean h() {
        if (this.f20503f == 13) {
            return true;
        }
        return false;
    }

    public final boolean i() {
        if (this.f20503f == 3) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        if (this.f20503f == 1) {
            return true;
        }
        return false;
    }

    public final void k(long j4) {
        this.f20498a = j4;
    }

    public final void l(String str) {
        this.f20504g = str;
    }

    public final void m(long j4) {
        this.f20506i = j4;
    }

    public final void n(String str) {
        this.f20500c = str;
    }

    public final void o(String str) {
        this.f20499b = str;
    }

    public final void p(String str) {
        this.f20501d = str;
    }

    public final void q(long j4) {
        this.f20503f = j4;
    }

    public final void r(String str) {
        this.f20502e = str;
    }

    public String toString() {
        return "UserListItem(programId=" + this.f20498a + ", name=" + this.f20499b + ", icon=" + this.f20500c + ", packagename=" + this.f20501d + ')';
    }
}
