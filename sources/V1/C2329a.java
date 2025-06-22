package v1;

import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
import q1.C2205a;
import q1.C2207c;
import q1.d;
import q1.m;
import q1.n;
import r1.C2216b;
import t1.C2290g;
import t1.C2291h;
import w1.C2334a;
import w1.C2335b;
import w1.C2336c;
import w1.C2339f;
import z1.C2448b;

/* renamed from: v1.a  reason: case insensitive filesystem */
public abstract class C2329a {

    /* renamed from: a  reason: collision with root package name */
    private String f21981a;

    /* renamed from: b  reason: collision with root package name */
    private C2448b f21982b = new C2448b((WebView) null);

    /* renamed from: c  reason: collision with root package name */
    private C2205a f21983c;

    /* renamed from: d  reason: collision with root package name */
    private C2216b f21984d;

    /* renamed from: e  reason: collision with root package name */
    private C0271a f21985e;

    /* renamed from: f  reason: collision with root package name */
    private long f21986f;

    /* renamed from: v1.a$a  reason: collision with other inner class name */
    enum C0271a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public C2329a(String str) {
        a();
        this.f21981a = str;
    }

    public void a() {
        this.f21986f = C2339f.b();
        this.f21985e = C0271a.AD_STATE_IDLE;
    }

    public void b(float f4) {
        C2291h.a().c(w(), this.f21981a, f4);
    }

    /* access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f21982b = new C2448b(webView);
    }

    public void d(String str) {
        f(str, (JSONObject) null);
    }

    public void e(String str, long j4) {
        C0271a aVar;
        if (j4 >= this.f21986f && this.f21985e != (aVar = C0271a.AD_STATE_NOTVISIBLE)) {
            this.f21985e = aVar;
            C2291h.a().m(w(), this.f21981a, str);
        }
    }

    public void f(String str, JSONObject jSONObject) {
        C2291h.a().e(w(), this.f21981a, str, jSONObject);
    }

    public void g(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            C2336c.g(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
            C2291h.a().j(w(), jSONObject);
        }
    }

    public void h(JSONObject jSONObject) {
        C2291h.a().n(w(), this.f21981a, jSONObject);
    }

    public void i(C2205a aVar) {
        this.f21983c = aVar;
    }

    public void j(C2207c cVar) {
        C2291h.a().f(w(), this.f21981a, cVar.d());
    }

    public void k(n nVar, d dVar) {
        l(nVar, dVar, (JSONObject) null);
    }

    /* access modifiers changed from: protected */
    public void l(n nVar, d dVar, JSONObject jSONObject) {
        String s4 = nVar.s();
        JSONObject jSONObject2 = new JSONObject();
        C2336c.g(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        C2336c.g(jSONObject2, "adSessionType", dVar.c());
        C2336c.g(jSONObject2, "deviceInfo", C2335b.d());
        C2336c.g(jSONObject2, "deviceCategory", C2334a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C2336c.g(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C2336c.g(jSONObject3, "partnerName", dVar.h().b());
        C2336c.g(jSONObject3, "partnerVersion", dVar.h().c());
        C2336c.g(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C2336c.g(jSONObject4, "libraryVersion", "1.4.13-Mmadbridge");
        C2336c.g(jSONObject4, "appId", C2290g.c().a().getApplicationContext().getPackageName());
        C2336c.g(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject4);
        if (dVar.d() != null) {
            C2336c.g(jSONObject2, "contentUrl", dVar.d());
        }
        if (dVar.e() != null) {
            C2336c.g(jSONObject2, "customReferenceData", dVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (m mVar : dVar.i()) {
            C2336c.g(jSONObject5, mVar.d(), mVar.e());
        }
        C2291h.a().g(w(), s4, jSONObject2, jSONObject5, jSONObject);
    }

    public void m(C2216b bVar) {
        this.f21984d = bVar;
    }

    public void n(boolean z4) {
        String str;
        if (t()) {
            if (z4) {
                str = "foregrounded";
            } else {
                str = "backgrounded";
            }
            C2291h.a().o(w(), this.f21981a, str);
        }
    }

    public void o() {
        this.f21982b.clear();
    }

    public void p(String str, long j4) {
        if (j4 >= this.f21986f) {
            this.f21985e = C0271a.AD_STATE_VISIBLE;
            C2291h.a().m(w(), this.f21981a, str);
        }
    }

    public void q(boolean z4) {
        String str;
        if (t()) {
            if (z4) {
                str = "locked";
            } else {
                str = "unlocked";
            }
            C2291h.a().d(w(), this.f21981a, str);
        }
    }

    public C2205a r() {
        return this.f21983c;
    }

    public C2216b s() {
        return this.f21984d;
    }

    public boolean t() {
        if (this.f21982b.get() != null) {
            return true;
        }
        return false;
    }

    public void u() {
        C2291h.a().b(w(), this.f21981a);
    }

    public void v() {
        C2291h.a().l(w(), this.f21981a);
    }

    public WebView w() {
        return (WebView) this.f21982b.get();
    }

    public void x() {
        h((JSONObject) null);
    }

    public void y() {
    }
}
