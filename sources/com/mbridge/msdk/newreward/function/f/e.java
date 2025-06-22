package com.mbridge.msdk.newreward.function.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.e.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.f.f;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.CustomInfoManager;
import java.util.HashMap;
import java.util.Map;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f14932a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Context f14933b = c.m().c();

    /* renamed from: c  reason: collision with root package name */
    private final int f14934c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14935d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14936e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f14937f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14938g;

    /* renamed from: h  reason: collision with root package name */
    private int f14939h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14940i = false;

    public e(int i4, String str, String str2, boolean z4, String str3) {
        this.f14934c = i4;
        this.f14935d = str;
        this.f14936e = str2;
        this.f14937f = z4;
        this.f14938g = str3;
    }

    public final void a(boolean z4) {
        this.f14940i = z4;
    }

    public final int b() {
        return this.f14934c;
    }

    public final String c() {
        return this.f14935d;
    }

    public final String d() {
        return this.f14936e;
    }

    public final String e() {
        return this.f14938g;
    }

    public final Map<String, String> f() {
        int i4;
        int i5;
        int i6;
        Map<String, String> a5 = a();
        if (a5 != null) {
            this.f14932a.putAll(a5);
        }
        com.mbridge.msdk.foundation.same.net.f.e eVar = new com.mbridge.msdk.foundation.same.net.f.e(this.f14932a);
        if (b.a()) {
            eVar.a("gp_version", k.d(this.f14933b));
        }
        String str = "1";
        eVar.a("version_flag", str);
        int i7 = 1;
        if (b.a()) {
            com.mbridge.msdk.foundation.controller.authoritycontroller.c.c(true);
        }
        eVar.a("misk_spt", String.valueOf(ak.a()));
        String c5 = ak.c();
        if (!TextUtils.isEmpty(c5)) {
            eVar.a("misk_spt_det", c5);
        }
        String str2 = this.f14936e;
        if (str2 != null) {
            CustomInfoManager instance = CustomInfoManager.getInstance();
            if (this.f14937f) {
                i6 = 7;
            } else {
                i6 = 8;
            }
            String customInfoByUnitId = instance.getCustomInfoByUnitId(str2, i6);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.c.k d5 = h.a().d(c.m().k(), str2);
            if (d5 != null && !TextUtils.isEmpty(d5.a())) {
                eVar.a("u_stid", d5.a());
            }
        }
        String a6 = com.mbridge.msdk.foundation.same.a.b.a(this.f14936e, "reward");
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f14936e);
        if (!TextUtils.isEmpty(this.f14935d)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f14935d);
        }
        com.mbridge.msdk.videocommon.d.c a7 = com.mbridge.msdk.videocommon.d.b.a().a(c.m().k(), this.f14936e);
        if (a7 != null) {
            i5 = a7.t();
            i4 = a7.u();
        } else {
            i5 = 0;
            i4 = 0;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(i5));
        if (this.f14934c != 287) {
            i7 = i4;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(i7));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, com.mbridge.msdk.foundation.same.net.f.e.f13342d, a6);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, str);
        String str3 = com.mbridge.msdk.foundation.same.net.f.e.f13344f;
        String str4 = MBridgeGlobalCommon.SESSION_ID;
        if (str4 == null) {
            str4 = "";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str3, str4);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(this.f14934c));
        if (!TextUtils.isEmpty(this.f14938g)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", this.f14938g);
        }
        if (this.f14934c == 287) {
            int i8 = this.f14939h;
            if (i8 == a.f13111I || i8 == a.f13110H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", str);
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        if (a7 != null && !TextUtils.isEmpty(a7.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", a7.k());
        }
        com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
        if (b5 != null && !TextUtils.isEmpty(b5.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", b5.b());
        }
        if (!this.f14940i) {
            str = "0";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", str);
        String d6 = ak.d(this.f14936e);
        if (!TextUtils.isEmpty(d6)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", d6);
        }
        f.a(eVar, this.f14933b);
        f.a(eVar);
        f.c(eVar);
        f.e(eVar);
        f.f(eVar);
        return eVar.a();
    }

    public final void a(int i4) {
        this.f14939h = i4;
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str) && b.a()) {
            this.f14932a.put("install_ids", str);
        }
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str) && b.a() && b.a()) {
            this.f14932a.put("ttc_ids", str);
        }
    }

    public final void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14932a.put(com.mbridge.msdk.foundation.same.net.f.e.f13344f, str);
        }
    }

    public final void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14932a.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str);
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14932a.put(com.mbridge.msdk.foundation.same.net.f.e.f13343e, str);
        }
    }

    public final void b(int i4) {
        this.f14932a.put(TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i4));
    }

    public final void a(Map<String, String> map) {
        if (this.f14932a != null && map != null && !map.isEmpty()) {
            this.f14932a.putAll(map);
        }
    }

    public final void c(int i4) {
        this.f14932a.put("req_type", String.valueOf(i4));
    }
}
