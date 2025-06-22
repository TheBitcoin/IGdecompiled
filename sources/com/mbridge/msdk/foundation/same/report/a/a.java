package com.mbridge.msdk.foundation.same.report.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.h;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.tracker.e;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f13363a;

    /* renamed from: b  reason: collision with root package name */
    protected h f13364b;

    public a(h hVar) {
        this.f13364b = hVar;
        Context c5 = c.m().c();
        this.f13363a = c5;
        if (this.f13364b != null && c5 != null) {
            int m4 = ab.m(c5);
            this.f13364b.d(m4);
            this.f13364b.c(ab.a(this.f13363a, m4));
        }
    }

    public final void a() {
        if (this.f13364b != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.f13364b.b());
                jSONObject.put(CampaignEx.JSON_KEY_HB, this.f13364b.h());
                jSONObject.put("fb", this.f13364b.e());
                jSONObject.put("num", this.f13364b.c());
                jSONObject.put(CampaignEx.JSON_KEY_AD_SOURCE_ID, this.f13364b.a());
                jSONObject.put("timeout", this.f13364b.i());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.f13364b.d());
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    jSONObject.put("network_type", this.f13364b.g());
                    jSONObject.put("network_str", this.f13364b.f());
                }
                e eVar = new e("2000006");
                eVar.b(0);
                eVar.a(0);
                eVar.a(jSONObject);
                eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
                d.a().c().a(eVar);
            } catch (Throwable unused) {
            }
        }
    }

    public final void b(int i4) {
        h hVar = this.f13364b;
        if (hVar != null) {
            hVar.a(i4);
        }
    }

    public final void c(int i4) {
        h hVar = this.f13364b;
        if (hVar != null) {
            hVar.c(i4);
        }
    }

    public final void b(String str) {
        h hVar = this.f13364b;
        if (hVar != null) {
            hVar.b(str);
        }
    }

    public final void a(int i4) {
        h hVar = this.f13364b;
        if (hVar != null) {
            hVar.b(i4);
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13364b.a(str);
        }
    }
}
