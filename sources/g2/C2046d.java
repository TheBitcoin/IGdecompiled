package g2;

import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;
import u2.x;

/* renamed from: g2.d  reason: case insensitive filesystem */
public final class C2046d {

    /* renamed from: h  reason: collision with root package name */
    public static final a f20554h = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20555a;

    /* renamed from: b  reason: collision with root package name */
    private String f20556b;

    /* renamed from: c  reason: collision with root package name */
    private String f20557c;

    /* renamed from: d  reason: collision with root package name */
    private String f20558d;

    /* renamed from: e  reason: collision with root package name */
    private String f20559e;

    /* renamed from: f  reason: collision with root package name */
    private String f20560f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f20561g;

    /* renamed from: g2.d$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final C2046d a(JSONObject jSONObject) {
            m.e(jSONObject, "jsonObjectData");
            C2046d dVar = new C2046d();
            if (!jSONObject.isNull("affiliatedURL")) {
                dVar.j(jSONObject.optString("affiliatedURL"));
            }
            if (!jSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
                dVar.o(jSONObject.optString(CampaignEx.JSON_KEY_TITLE));
            }
            if (!jSONObject.isNull("description")) {
                dVar.l(jSONObject.optString("description"));
            }
            if (!jSONObject.isNull("buttonText")) {
                dVar.k(jSONObject.optString("buttonText"));
            }
            if (!jSONObject.isNull("mainColor")) {
                dVar.m(jSONObject.optString("mainColor"));
            }
            if (!jSONObject.isNull("secondaryColor")) {
                dVar.n(jSONObject.optString("secondaryColor"));
            }
            return dVar;
        }

        private a() {
        }
    }

    public final void a(Context context, Long l4) {
        m.e(context, "context");
        Bundle bundle = new Bundle();
        if (l4 != null && l4.longValue() > 0) {
            bundle.putString("appId", l4.toString());
        }
        bundle.putString("type", "clicked");
        new x(context).d("affiliated", bundle);
    }

    public final void b(Context context, Long l4) {
        m.e(context, "context");
        if (!this.f20561g) {
            this.f20561g = true;
            Bundle bundle = new Bundle();
            if (l4 != null && l4.longValue() > 0) {
                bundle.putString("appId", l4.toString());
            }
            bundle.putString("type", "shown");
            new x(context).d("affiliated", bundle);
        }
    }

    public final String c() {
        return this.f20555a;
    }

    public final String d() {
        return this.f20558d;
    }

    public final String e() {
        return this.f20557c;
    }

    public final String f() {
        return this.f20559e;
    }

    public final String g() {
        return this.f20560f;
    }

    public final boolean h() {
        return this.f20561g;
    }

    public final String i() {
        return this.f20556b;
    }

    public final void j(String str) {
        this.f20555a = str;
    }

    public final void k(String str) {
        this.f20558d = str;
    }

    public final void l(String str) {
        this.f20557c = str;
    }

    public final void m(String str) {
        this.f20559e = str;
    }

    public final void n(String str) {
        this.f20560f = str;
    }

    public final void o(String str) {
        this.f20556b = str;
    }
}
