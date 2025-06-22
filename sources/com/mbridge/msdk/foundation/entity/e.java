package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private String f12985a;

    /* renamed from: b  reason: collision with root package name */
    private String f12986b;

    /* renamed from: c  reason: collision with root package name */
    private String f12987c;

    /* renamed from: d  reason: collision with root package name */
    private int f12988d;

    /* renamed from: e  reason: collision with root package name */
    private int f12989e;

    /* renamed from: f  reason: collision with root package name */
    private String f12990f;

    /* renamed from: g  reason: collision with root package name */
    private String f12991g;

    /* renamed from: h  reason: collision with root package name */
    private String f12992h;

    /* renamed from: i  reason: collision with root package name */
    private int f12993i;

    /* renamed from: j  reason: collision with root package name */
    private String f12994j;

    /* renamed from: k  reason: collision with root package name */
    private int f12995k;

    /* renamed from: l  reason: collision with root package name */
    private String f12996l;

    /* renamed from: m  reason: collision with root package name */
    private int f12997m;

    /* renamed from: n  reason: collision with root package name */
    private String f12998n;

    /* renamed from: o  reason: collision with root package name */
    private String f12999o;

    /* renamed from: p  reason: collision with root package name */
    private int f13000p;

    /* renamed from: q  reason: collision with root package name */
    private String f13001q;

    public final void a(String str) {
        this.f13001q = str;
    }

    public final void b(String str) {
        this.f12998n = str;
    }

    public final void c(String str) {
        this.f12996l = str;
    }

    public final void d(String str) {
        this.f12991g = str;
    }

    public final void e(int i4) {
        this.f12995k = i4;
    }

    public final void f(String str) {
        this.f12992h = str;
    }

    public final void g(String str) {
        this.f12990f = str;
    }

    public final void h(String str) {
        this.f12994j = str;
    }

    public final void i(String str) {
        this.f12986b = str;
    }

    public final void j(String str) {
        this.f12985a = str;
    }

    public final void k(String str) {
        this.f12999o = str;
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.f12985a + ", click_duration=" + this.f12986b + ", lastUrl=" + this.f12994j + ", code=" + this.f12989e + ", excepiton=" + this.f12991g + ", header=" + this.f12992h + ", content=" + this.f12990f + ", type=" + this.f13000p + ", click_type=" + this.f12988d + "]";
    }

    public final void a(int i4) {
        this.f12997m = i4;
    }

    public final void b(int i4) {
        this.f12988d = i4;
    }

    public final void c(int i4) {
        this.f13000p = i4;
    }

    public final void d(int i4) {
        this.f12993i = i4;
    }

    public final void e(String str) {
        this.f12987c = str;
    }

    public final void f(int i4) {
        this.f12989e = i4;
    }

    public static ArrayList<JSONObject> a(List<e> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList<JSONObject> arrayList = new ArrayList<>();
        for (e next : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rid", next.f12998n);
                jSONObject.put("rid_n", next.f12999o);
                jSONObject.put("cid", next.f12985a);
                jSONObject.put("click_type", next.f12988d);
                jSONObject.put("type", next.f13000p);
                jSONObject.put("click_duration", next.f12986b);
                jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "2000013");
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, next.f13001q);
                jSONObject.put("last_url", next.f12994j);
                jSONObject.put("content", next.f12990f);
                jSONObject.put("code", next.f12989e);
                jSONObject.put("exception", next.f12991g);
                jSONObject.put("header", next.f12992h);
                jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, next.f12993i);
                jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, next.f12995k);
                jSONObject.put("click_time", next.f12987c);
                if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", next.f12997m);
                    jSONObject.put("network_str", next.f12996l);
                }
                String str = next.f13001q;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a.f12767b.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("u_stid", str2);
                }
                arrayList.add(jSONObject);
            } catch (Throwable th) {
                af.b("ClickTime", th.getMessage());
            }
        }
        return arrayList;
    }

    public static JSONObject a(e eVar) {
        if (eVar == null) {
            return null;
        }
        String str = eVar.f12994j;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rid", eVar.f12998n);
            jSONObject.put("rid_n", eVar.f12999o);
            jSONObject.put("click_type", eVar.f12988d);
            jSONObject.put("type", eVar.f13000p);
            jSONObject.put("cid", eVar.f12985a);
            jSONObject.put("click_duration", eVar.f12986b);
            jSONObject.put(LeanbackPreferenceDialogFragment.ARG_KEY, "2000012");
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, eVar.f13001q);
            jSONObject.put("last_url", str);
            jSONObject.put("code", eVar.f12989e);
            jSONObject.put("exception", eVar.f12991g);
            jSONObject.put(CampaignEx.JSON_KEY_LANDING_TYPE, eVar.f12993i);
            jSONObject.put(CampaignEx.JSON_KEY_LINK_TYPE, eVar.f12995k);
            jSONObject.put("click_time", eVar.f12987c);
            if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("network_type", eVar.f12997m);
                jSONObject.put("network_str", eVar.f12996l);
            }
            return jSONObject;
        } catch (Throwable th) {
            af.b("ClickTime", th.getMessage());
            return null;
        }
    }
}
