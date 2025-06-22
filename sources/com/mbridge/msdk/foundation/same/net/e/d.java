package com.mbridge.msdk.foundation.same.net.e;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.tracker.o;
import com.mbridge.msdk.tracker.t;
import com.mbridge.msdk.tracker.v;
import com.mbridge.msdk.tracker.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class d {

    /* renamed from: A  reason: collision with root package name */
    public String f13285A;

    /* renamed from: B  reason: collision with root package name */
    public String f13286B;

    /* renamed from: C  reason: collision with root package name */
    public String f13287C;

    /* renamed from: D  reason: collision with root package name */
    public String f13288D;

    /* renamed from: E  reason: collision with root package name */
    public String f13289E;

    /* renamed from: F  reason: collision with root package name */
    public String f13290F;

    /* renamed from: G  reason: collision with root package name */
    public String f13291G;

    /* renamed from: H  reason: collision with root package name */
    public String f13292H;

    /* renamed from: I  reason: collision with root package name */
    public String f13293I;

    /* renamed from: J  reason: collision with root package name */
    public String f13294J;

    /* renamed from: K  reason: collision with root package name */
    public String f13295K;

    /* renamed from: L  reason: collision with root package name */
    public String f13296L;

    /* renamed from: M  reason: collision with root package name */
    public String f13297M;

    /* renamed from: N  reason: collision with root package name */
    public String f13298N;

    /* renamed from: O  reason: collision with root package name */
    public String f13299O;

    /* renamed from: P  reason: collision with root package name */
    private final String f13300P;

    /* renamed from: Q  reason: collision with root package name */
    private String f13301Q;

    /* renamed from: R  reason: collision with root package name */
    private String f13302R;

    /* renamed from: S  reason: collision with root package name */
    private String f13303S;

    /* renamed from: T  reason: collision with root package name */
    private String f13304T;

    /* renamed from: U  reason: collision with root package name */
    private String f13305U;

    /* renamed from: V  reason: collision with root package name */
    private String f13306V;

    /* renamed from: W  reason: collision with root package name */
    private String f13307W;

    /* renamed from: X  reason: collision with root package name */
    private String f13308X;

    /* renamed from: Y  reason: collision with root package name */
    private String f13309Y;

    /* renamed from: Z  reason: collision with root package name */
    private String f13310Z;

    /* renamed from: a  reason: collision with root package name */
    public String f13311a;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private boolean ae;
    private int af;

    /* renamed from: b  reason: collision with root package name */
    public String f13312b;

    /* renamed from: c  reason: collision with root package name */
    public String f13313c;

    /* renamed from: d  reason: collision with root package name */
    public String f13314d;

    /* renamed from: e  reason: collision with root package name */
    public String f13315e;

    /* renamed from: f  reason: collision with root package name */
    public String f13316f;

    /* renamed from: g  reason: collision with root package name */
    public String f13317g;

    /* renamed from: h  reason: collision with root package name */
    public String f13318h;

    /* renamed from: i  reason: collision with root package name */
    public String f13319i;

    /* renamed from: j  reason: collision with root package name */
    public String f13320j;

    /* renamed from: k  reason: collision with root package name */
    public String f13321k;

    /* renamed from: l  reason: collision with root package name */
    public String f13322l;

    /* renamed from: m  reason: collision with root package name */
    public int f13323m;

    /* renamed from: n  reason: collision with root package name */
    public int f13324n;

    /* renamed from: o  reason: collision with root package name */
    public int f13325o;

    /* renamed from: p  reason: collision with root package name */
    public int f13326p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f13327q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f13328r;

    /* renamed from: s  reason: collision with root package name */
    public int f13329s;

    /* renamed from: t  reason: collision with root package name */
    public ArrayList<String> f13330t;

    /* renamed from: u  reason: collision with root package name */
    public int f13331u;

    /* renamed from: v  reason: collision with root package name */
    public int f13332v;

    /* renamed from: w  reason: collision with root package name */
    public ArrayList<String> f13333w;

    /* renamed from: x  reason: collision with root package name */
    public String f13334x;

    /* renamed from: y  reason: collision with root package name */
    public String f13335y;

    /* renamed from: z  reason: collision with root package name */
    public String f13336z;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f13337a = new d();
    }

    public static d f() {
        return a.f13337a;
    }

    public final boolean a() {
        try {
            if (!this.f13328r) {
                ArrayList<String> arrayList = this.f13330t;
                if (arrayList != null && this.f13331u <= arrayList.size() - 1) {
                    this.f13318h = this.f13330t.get(this.f13331u);
                    b();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.f13333w;
                if (arrayList2 != null && this.f13332v <= arrayList2.size() - 1) {
                    if (!b(this.f13333w.get(this.f13332v))) {
                        this.f13322l = this.f13333w.get(this.f13332v);
                        c();
                    }
                    return true;
                }
            }
            if (this.f13327q) {
                this.f13331u = 0;
                this.f13332v = 0;
            }
            return false;
        } catch (Throwable th) {
            af.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public final void b() {
        this.f13291G = this.f13318h + this.f13309Y;
        this.f13335y = this.f13318h + this.f13303S;
        this.f13293I = this.f13318h + this.f13310Z;
        this.f13287C = this.f13318h + this.f13306V;
        this.f13295K = this.f13318h + this.aa;
    }

    public final void c() {
        this.f13292H = this.f13322l + this.f13309Y;
        this.f13336z = this.f13322l + this.f13303S;
        this.f13294J = this.f13322l + this.f13310Z;
        this.f13288D = this.f13322l + this.f13306V;
        this.f13296L = this.f13322l + this.aa;
    }

    public final int d() {
        return this.af;
    }

    public final void e() {
        boolean z4;
        HashMap<String, String> J4;
        o oVar;
        g b5 = h.a().b(c.m().k());
        if (b5 != null) {
            com.mbridge.msdk.c.a q4 = b5.q();
            if (q4 != null) {
                this.f13321k = q4.f();
                this.f13325o = q4.g();
                this.f13317g = q4.e();
                this.f13290F = this.f13317g + this.f13308X;
            }
            com.mbridge.msdk.c.d F4 = b5.F();
            if (F4 != null) {
                this.f13320j = F4.d();
                this.f13324n = F4.e();
                this.f13315e = F4.c();
                this.f13289E = this.f13315e + this.f13307W;
                com.mbridge.msdk.c.d F5 = b5.F();
                if (!(F5 == null || F5.a() == 1)) {
                    int a5 = ah.a().a("monitor", "type", ah.a().a("t_r_t", 1));
                    if (!(a5 == 0 || a5 == 1)) {
                        a5 = 0;
                    }
                    w.a a6 = new w.a().a((com.mbridge.msdk.tracker.d) new com.mbridge.msdk.foundation.same.report.d()).a((v) new m());
                    if (a5 == 1) {
                        oVar = new o(new l((byte) 2), a.f13337a.f13320j, a.f13337a.f13324n);
                    } else {
                        oVar = new o(new com.mbridge.msdk.tracker.network.toolbox.h(), a.f13337a.f13289E, 0);
                    }
                    t.a().a(c.m().c(), a6.a(a5, oVar).e(ah.a().a("t_m_e_t", 604800000)).a(ah.a().a("t_m_e_s", 50)).d(ah.a().a("t_m_r_c", 50)).b(ah.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ah.a().a("t_m_r_t_s", 1)).a(), F5.b() * 1000, com.mbridge.msdk.foundation.same.report.c.a());
                }
            }
            if (b5.aq() == 2) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f13328r = z4;
            this.f13329s = b5.aq();
            this.ae = !b5.z(2);
            if (b5.J() != null && b5.J().size() > 0 && (J4 = b5.J()) != null && J4.size() > 0) {
                if (J4.containsKey("v") && !TextUtils.isEmpty(J4.get("v")) && b(J4.get("v"))) {
                    this.f13314d = J4.get("v");
                    this.f13297M = this.f13314d + this.ab;
                    this.f13298N = this.f13314d + this.ac;
                    this.f13299O = this.f13314d + this.ad;
                    this.f13285A = this.f13314d + this.f13304T;
                }
                if (J4.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(J4.get(CampaignEx.JSON_KEY_HB)) && b(J4.get(CampaignEx.JSON_KEY_HB))) {
                    this.f13301Q = J4.get(CampaignEx.JSON_KEY_HB);
                    this.f13334x = this.f13301Q + this.f13302R;
                    this.f13286B = this.f13301Q + this.f13305U;
                }
                if (J4.containsKey("lg") && !TextUtils.isEmpty(J4.get("lg"))) {
                    String str = J4.get("lg");
                    if (b(str)) {
                        this.f13313c = str;
                    } else {
                        this.f13319i = str;
                    }
                }
                if (J4.containsKey("lgt") && !TextUtils.isEmpty(J4.get("lgt"))) {
                    String str2 = J4.get("lgt");
                    if (b(str2)) {
                        String c5 = c(str2);
                        if (!TextUtils.isEmpty(c5)) {
                            this.f13319i = c5;
                        }
                    } else {
                        this.f13319i = str2;
                    }
                }
            }
            String B4 = b5.B();
            if (!TextUtils.isEmpty(B4)) {
                this.f13318h = B4;
                b();
                this.f13330t.add(0, B4);
            }
            String C4 = b5.C();
            if (!TextUtils.isEmpty(C4)) {
                this.f13322l = C4;
                c();
                this.f13333w.add(0, C4);
            }
        }
    }

    private d() {
        this.f13300P = "RequestUrlUtil";
        this.f13311a = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.f13312b = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.f13313c = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f13314d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.f13315e = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.f13316f = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.f13317g = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.f13318h = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f13319i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.f13320j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.f13321k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.f13322l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.f13323m = 9377;
        this.f13324n = 9377;
        this.f13325o = 9988;
        this.f13326p = 9377;
        this.f13327q = false;
        this.f13328r = false;
        this.f13329s = 1;
        this.f13330t = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.f13331u = 0;
        this.f13332v = 0;
        this.f13333w = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.f13301Q = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.f13302R = "/bid";
        this.f13334x = this.f13301Q + this.f13302R;
        this.f13303S = "/sdk/customid";
        this.f13335y = this.f13318h + this.f13303S;
        this.f13336z = this.f13322l + this.f13303S;
        this.f13304T = "/image";
        this.f13285A = this.f13314d + this.f13304T;
        this.f13305U = "/load";
        this.f13286B = this.f13301Q + this.f13305U;
        this.f13306V = "/mapping";
        this.f13287C = this.f13318h + this.f13306V;
        this.f13288D = this.f13322l + this.f13306V;
        this.f13307W = "";
        this.f13289E = this.f13317g + this.f13307W;
        this.f13308X = "/batchPaidEvent";
        this.f13290F = this.f13317g + this.f13308X;
        this.f13309Y = "/setting";
        this.f13291G = this.f13318h + this.f13309Y;
        this.f13292H = this.f13322l + this.f13309Y;
        this.f13310Z = "/rewardsetting";
        this.f13293I = this.f13318h + this.f13310Z;
        this.f13294J = this.f13322l + this.f13310Z;
        this.aa = "/appwall/setting";
        this.f13295K = this.f13318h + this.aa;
        this.f13296L = this.f13322l + this.aa;
        this.ab = "/openapi/ad/v3";
        this.f13297M = this.f13314d + this.ab;
        this.ac = "/openapi/ad/v4";
        this.f13298N = this.f13314d + this.ac;
        this.ad = "/openapi/ad/v5";
        this.f13299O = this.f13314d + this.ad;
        this.ae = true;
        this.af = 0;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            af.b("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    public final String a(String str, int i4) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return a(true, split[1]);
                }
                return a(true, "");
            }
        } catch (Exception e5) {
            af.b("RequestUrlUtil", e5.getMessage());
        }
        return i4 % 2 == 0 ? this.f13299O : this.f13297M;
    }

    public final String a(boolean z4, String str) {
        if (!z4) {
            return this.f13334x.replace("{}", "");
        }
        if (!this.f13286B.contains("{}") || TextUtils.isEmpty(str)) {
            return this.f13286B.replace("{}", "");
        }
        String str2 = this.f13286B;
        return str2.replace("{}", str + "-");
    }

    public final void a(int i4) {
        this.af = i4;
    }

    public final String a(String str) {
        return a.f13337a.a(str, 1);
    }
}
