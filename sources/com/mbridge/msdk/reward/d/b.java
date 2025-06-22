package com.mbridge.msdk.reward.d;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.f.e;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.out.MBConfiguration;

public final class b extends com.mbridge.msdk.foundation.same.net.f.b {
    public b(Context context) {
        super(context);
    }

    public final void addExtraParams(String str, e eVar) {
        super.addExtraParams(str, eVar);
        eVar.a("platform", "1");
        eVar.a("os_version", Build.VERSION.RELEASE);
        eVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, ab.f(this.mContext));
        eVar.a("app_version_name", ab.q(this.mContext));
        eVar.a("app_version_code", ab.r(this.mContext) + "");
        eVar.a("orientation", ab.s(this.mContext) + "");
        eVar.a("model", ab.h());
        eVar.a("brand", ab.x());
        eVar.a("gaid", "");
        eVar.a("gaid2", f.b());
        int m4 = ab.m(this.mContext);
        eVar.a("network_type", m4 + "");
        eVar.a("network_str", ab.a(this.mContext, m4) + "");
        eVar.a("language", ab.t(this.mContext));
        eVar.a("timezone", ab.y());
        eVar.a("useragent", ab.g());
        eVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        eVar.a("screen_size", ab.j(this.mContext) + "x" + ab.h(this.mContext));
        if (com.mbridge.msdk.e.b.a()) {
            eVar.a("gp_version", k.d(this.mContext));
        }
        eVar.a("version_flag", "1");
        com.mbridge.msdk.foundation.same.net.f.f.a(eVar, this.mContext);
        com.mbridge.msdk.foundation.same.net.f.f.a(eVar);
        com.mbridge.msdk.foundation.same.net.f.f.c(eVar);
        com.mbridge.msdk.foundation.same.net.f.f.e(eVar);
    }
}
