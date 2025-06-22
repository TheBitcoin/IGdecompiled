package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.u;

public final class d {
    public static String a(String str, u<?> uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return "";
        }
        byte[] p4 = uVar.p();
        if (p4 == null || p4.length == 0) {
            return str;
        }
        if (str.endsWith("?")) {
            return str + new String(p4);
        }
        return str + "?" + new String(p4);
    }
}
