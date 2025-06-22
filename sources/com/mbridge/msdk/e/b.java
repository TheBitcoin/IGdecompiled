package com.mbridge.msdk.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f12707a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Boolean f12708b;

    public static boolean a() {
        boolean z4;
        if (f12707a == null) {
            try {
                if (Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                f12707a = Boolean.valueOf(z4);
                return z4;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isChina", e5);
                }
            }
        }
        if (f12707a == null || !f12707a.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        boolean z4;
        if (f12708b == null) {
            try {
                if (Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                f12708b = Boolean.valueOf(z4);
                return z4;
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonUtils", "isOversea", e5);
                }
            }
        }
        if (f12708b == null || !f12708b.booleanValue()) {
            return false;
        }
        return true;
    }
}
