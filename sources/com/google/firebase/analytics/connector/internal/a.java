package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import f0.q;
import m0.C2147o;
import m0.r;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final r f11105a = r.u("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b  reason: collision with root package name */
    private static final C2147o f11106b = C2147o.u("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c  reason: collision with root package name */
    private static final C2147o f11107c = C2147o.t("auto", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "am");

    /* renamed from: d  reason: collision with root package name */
    private static final C2147o f11108d = C2147o.s("_r", "_dbg");

    /* renamed from: e  reason: collision with root package name */
    private static final C2147o f11109e = new C2147o.a().e(f0.r.f3383a).e(f0.r.f3384b).f();

    /* renamed from: f  reason: collision with root package name */
    private static final C2147o f11110f = C2147o.s("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static String a(String str) {
        String a5 = q.a(str);
        if (a5 != null) {
            return a5;
        }
        return str;
    }

    public static void b(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1);
        }
    }

    public static boolean c(String str, Bundle bundle) {
        if (f11106b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        C2147o oVar = f11108d;
        int size = oVar.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = oVar.get(i4);
            i4++;
            if (bundle.containsKey((String) obj)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            if (str.equals("fcm") || str.equals("frc")) {
                return true;
            }
            return false;
        } else if ("_ln".equals(str2)) {
            if (str.equals("fcm") || str.equals("fiam")) {
                return true;
            }
            return false;
        } else if (f11109e.contains(str2)) {
            return false;
        } else {
            C2147o oVar = f11110f;
            int size = oVar.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = oVar.get(i4);
                i4++;
                if (str2.matches((String) obj)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean e(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!g(str) || bundle == null) {
            return false;
        }
        C2147o oVar = f11108d;
        int size = oVar.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = oVar.get(i4);
            i4++;
            if (bundle.containsKey((String) obj)) {
                return false;
            }
        }
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals("fcm")) {
                    c5 = 0;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c5 = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals("fiam")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            case 2:
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean f(String str) {
        if (!f11105a.contains(str)) {
            return true;
        }
        return false;
    }

    public static boolean g(String str) {
        if (!f11107c.contains(str)) {
            return true;
        }
        return false;
    }
}
