package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.f;
import org.json.JSONObject;

public final class j {
    public static JSONObject a(Context context, g gVar) throws Exception {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String l4 = ab.l();
            if (!TextUtils.isEmpty(l4)) {
                jSONObject.put("manufacturer", l4);
            }
            int k4 = ab.k();
            if (k4 != -1) {
                jSONObject.put("sdkint", k4);
            }
            String n4 = ab.n(context);
            if (!TextUtils.isEmpty(n4)) {
                jSONObject.put("is24H", n4);
            }
            String p4 = ab.p();
            if (!TextUtils.isEmpty(p4)) {
                jSONObject.put("totalram", p4);
            }
            String o4 = ab.o(context);
            if (!TextUtils.isEmpty(o4)) {
                jSONObject.put("totalmemory", o4);
            }
            jSONObject.put("adid_limit", f.a() + "");
            if (b.b()) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put("adid_limit_dev", str);
        }
        if (gVar.av() == 1 && !TextUtils.isEmpty(f.d()) && c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", f.d());
        }
        return jSONObject;
    }
}
