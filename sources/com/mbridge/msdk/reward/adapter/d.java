package com.mbridge.msdk.reward.adapter;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.a.b;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.videocommon.d.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f15233a;

    /* renamed from: b  reason: collision with root package name */
    private final String f15234b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15235c;

    /* renamed from: d  reason: collision with root package name */
    private final c f15236d;

    /* renamed from: e  reason: collision with root package name */
    private final String f15237e;

    public d(String str, String str2, boolean z4, c cVar, String str3) {
        this.f15233a = str;
        this.f15234b = str2;
        this.f15235c = z4;
        this.f15236d = cVar;
        this.f15237e = str3;
    }

    public final e a(boolean z4, String str, int i4, String str2, String str3, String str4, String str5, boolean z5, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        String str6;
        String str7;
        int i10 = i5;
        String k4 = com.mbridge.msdk.foundation.controller.c.m().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().k() + com.mbridge.msdk.foundation.controller.c.m().b());
        if (z4) {
            i6 = 2;
        } else {
            i6 = 3;
        }
        c cVar = this.f15236d;
        if (cVar != null) {
            i8 = cVar.t();
            i7 = this.f15236d.u();
        } else {
            i8 = 0;
            i7 = 0;
        }
        String a5 = b.a(this.f15234b, "reward");
        if (this.f15235c) {
            i9 = 287;
        } else {
            i9 = 94;
        }
        e eVar = new e();
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.APP_ID, k4);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f15234b);
        if (!TextUtils.isEmpty(this.f15233a)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f15233a);
        }
        String str8 = "";
        if (com.mbridge.msdk.e.b.a()) {
            if (str4 == null) {
                str6 = str8;
            } else {
                str6 = str4;
            }
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ttc_ids", str6);
            if (str3 == null) {
                str7 = str8;
            } else {
                str7 = str3;
            }
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "install_ids", str7);
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "req_type", String.valueOf(i6));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_num", String.valueOf(i8));
        if (this.f15235c) {
            i7 = 1;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "tnum", String.valueOf(i7));
        String str9 = "1";
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "only_impression", str9);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ping_mode", str9);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, e.f13342d, a5);
        String str10 = e.f13343e;
        if (str == null) {
            str = str8;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str10, str);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, String.valueOf(1));
        String str11 = e.f13344f;
        if (str2 == null) {
            str2 = str8;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, str11, str2);
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ad_type", String.valueOf(i9));
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, TypedValues.CycleType.S_WAVE_OFFSET, String.valueOf(i4));
        if (!TextUtils.isEmpty(str5)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "token", str5);
        }
        if (this.f15235c) {
            if (i10 == a.f13111I || i10 == a.f13110H) {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", str9);
            } else {
                com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "ivrwd", "0");
            }
        }
        c cVar2 = this.f15236d;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.k())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "u_stid", this.f15236d.k());
        }
        com.mbridge.msdk.videocommon.d.a b5 = com.mbridge.msdk.videocommon.d.b.a().b();
        if (b5 != null && !TextUtils.isEmpty(b5.b())) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "r_stid", b5.b());
        }
        if (!z5) {
            str9 = "0";
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "rw_plus", str9);
        String d5 = ak.d(this.f15234b);
        if (!TextUtils.isEmpty(d5)) {
            com.mbridge.msdk.foundation.same.net.e.b.a(eVar, "j", d5);
        }
        String str12 = this.f15237e;
        if (str12 != null) {
            str8 = str12;
        }
        com.mbridge.msdk.foundation.same.net.e.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str8);
        return eVar;
    }
}
