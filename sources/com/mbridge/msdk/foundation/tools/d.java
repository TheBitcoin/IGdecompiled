package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.e;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f13625a;

    /* renamed from: b  reason: collision with root package name */
    public int f13626b;

    /* renamed from: c  reason: collision with root package name */
    public String f13627c;

    /* renamed from: d  reason: collision with root package name */
    public String f13628d;

    /* renamed from: e  reason: collision with root package name */
    public String f13629e;

    /* renamed from: f  reason: collision with root package name */
    public String f13630f;

    /* renamed from: g  reason: collision with root package name */
    public String f13631g;

    /* renamed from: h  reason: collision with root package name */
    public String f13632h;

    /* renamed from: i  reason: collision with root package name */
    public String f13633i = ab.m();

    /* renamed from: j  reason: collision with root package name */
    public String f13634j;

    /* renamed from: k  reason: collision with root package name */
    public String f13635k;

    /* renamed from: l  reason: collision with root package name */
    public String f13636l = f.c();

    /* renamed from: m  reason: collision with root package name */
    public int f13637m;

    /* renamed from: n  reason: collision with root package name */
    public String f13638n;

    /* renamed from: o  reason: collision with root package name */
    public String f13639o;

    /* renamed from: p  reason: collision with root package name */
    public String f13640p;

    /* renamed from: q  reason: collision with root package name */
    public String f13641q = "android";

    /* renamed from: r  reason: collision with root package name */
    public String f13642r;

    /* renamed from: s  reason: collision with root package name */
    public String f13643s;

    /* renamed from: t  reason: collision with root package name */
    public String f13644t;

    /* renamed from: u  reason: collision with root package name */
    public String f13645u = ab.w();

    /* renamed from: v  reason: collision with root package name */
    public String f13646v;

    public d(Context context) {
        int m4 = ab.m(context);
        this.f13638n = String.valueOf(m4);
        this.f13639o = ab.a(context, m4);
        this.f13634j = ab.g(context);
        this.f13629e = c.m().b();
        this.f13628d = c.m().k();
        this.f13644t = String.valueOf(ak.f(context));
        this.f13643s = String.valueOf(ak.e(context));
        this.f13642r = String.valueOf(ak.d(context));
        this.f13646v = c.m().i().toString();
        this.f13631g = ab.x();
        this.f13637m = ak.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f13640p = "landscape";
        } else {
            this.f13640p = "portrait";
        }
        this.f13630f = a.f13124V;
        this.f13632h = a.f13133g;
        this.f13635k = ab.n();
        this.f13627c = f.d();
        this.f13625a = f.a();
        this.f13626b = b.b() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f13633i);
                jSONObject.put("system_version", this.f13645u);
                jSONObject.put("network_type", this.f13638n);
                jSONObject.put("network_type_str", this.f13639o);
                jSONObject.put("device_ua", this.f13634j);
                jSONObject.put("has_wx", ab.v(c.m().c()));
                jSONObject.put("integrated_wx", ab.z());
                jSONObject.put("opensdk_ver", ab.u() + "");
                jSONObject.put("wx_api_ver", ab.c(c.m().h()) + "");
                jSONObject.put("brand", this.f13631g);
                jSONObject.put("mnc", ab.l(c.m().c()));
                jSONObject.put("mcc", ab.k(c.m().c()));
                jSONObject.put("adid_limit", this.f13625a);
                jSONObject.put("adid_limit_dev", this.f13626b);
            }
            jSONObject.put("plantform", this.f13641q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f13636l);
                jSONObject.put("az_aid_info", this.f13627c);
            }
            jSONObject.put("appkey", this.f13629e);
            jSONObject.put("appId", this.f13628d);
            jSONObject.put("screen_width", this.f13644t);
            jSONObject.put("screen_height", this.f13643s);
            jSONObject.put("orientation", this.f13640p);
            jSONObject.put("scale", this.f13642r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f13630f);
            jSONObject.put("c", this.f13632h);
            jSONObject.put("web_env", this.f13646v);
            jSONObject.put("f", this.f13635k);
            jSONObject.put("misk_spt", this.f13637m);
            if (ab.q() != 0) {
                jSONObject.put("tun", ab.q());
            }
            String str = e.f13341c;
            jSONObject.put(str, com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f13625a);
                jSONObject2.put("adid_limit_dev", this.f13626b);
                jSONObject.put("dvi", z.b(jSONObject2.toString()));
            }
            if (!b.a()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
                return jSONObject;
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        return jSONObject;
    }
}
