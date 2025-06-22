package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.A3;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.z5  reason: case insensitive filesystem */
public final class C0907z5 {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f3348b = {"GoogleConsent", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "CmpSdkID"};

    /* renamed from: a  reason: collision with root package name */
    private final Map f3349a;

    private C0907z5(Map map) {
        HashMap hashMap = new HashMap();
        this.f3349a = hashMap;
        hashMap.putAll(map);
    }

    private static int a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public static C0907z5 c(SharedPreferences sharedPreferences) {
        HashMap hashMap = new HashMap();
        String f4 = f(sharedPreferences, "IABTCF_VendorConsents");
        if (!"\u0000".equals(f4) && f4.length() > 754) {
            hashMap.put("GoogleConsent", String.valueOf(f4.charAt(754)));
        }
        int a5 = a(sharedPreferences, "IABTCF_gdprApplies");
        if (a5 != -1) {
            hashMap.put("gdprApplies", String.valueOf(a5));
        }
        int a6 = a(sharedPreferences, "IABTCF_EnableAdvertiserConsentMode");
        if (a6 != -1) {
            hashMap.put("EnableAdvertiserConsentMode", String.valueOf(a6));
        }
        int a7 = a(sharedPreferences, "IABTCF_PolicyVersion");
        if (a7 != -1) {
            hashMap.put("PolicyVersion", String.valueOf(a7));
        }
        String f5 = f(sharedPreferences, "IABTCF_PurposeConsents");
        if (!"\u0000".equals(f5)) {
            hashMap.put("PurposeConsents", f5);
        }
        int a8 = a(sharedPreferences, "IABTCF_CmpSdkID");
        if (a8 != -1) {
            hashMap.put("CmpSdkID", String.valueOf(a8));
        }
        return new C0907z5(hashMap);
    }

    public static String d(String str, boolean z4) {
        if (!z4 || str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i4 = 1;
        while (true) {
            if (i4 >= 64) {
                i4 = 0;
                break;
            } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                break;
            } else {
                i4++;
            }
        }
        charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i4);
        return String.valueOf(charArray);
    }

    private static String f(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "\u0000");
        } catch (ClassCastException unused) {
            return "\u0000";
        }
    }

    private final int h() {
        try {
            String str = (String) this.f3349a.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final int i() {
        try {
            String str = (String) this.f3349a.get("PolicyVersion");
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final Bundle b() {
        String str;
        String str2;
        if (!"1".equals(this.f3349a.get("GoogleConsent")) || !"1".equals(this.f3349a.get("gdprApplies")) || !"1".equals(this.f3349a.get("EnableAdvertiserConsentMode"))) {
            return Bundle.EMPTY;
        }
        int i4 = i();
        if (i4 < 0) {
            return Bundle.EMPTY;
        }
        String str3 = (String) this.f3349a.get("PurposeConsents");
        if (TextUtils.isEmpty(str3)) {
            return Bundle.EMPTY;
        }
        Bundle bundle = new Bundle();
        String str4 = "denied";
        if (str3.length() > 0) {
            String str5 = A3.a.AD_STORAGE.f2307a;
            if (str3.charAt(0) == '1') {
                str2 = "granted";
            } else {
                str2 = str4;
            }
            bundle.putString(str5, str2);
        }
        if (str3.length() > 3) {
            String str6 = A3.a.AD_PERSONALIZATION.f2307a;
            if (str3.charAt(2) == '1' && str3.charAt(3) == '1') {
                str = "granted";
            } else {
                str = str4;
            }
            bundle.putString(str6, str);
        }
        if (str3.length() > 6 && i4 >= 4) {
            String str7 = A3.a.AD_USER_DATA.f2307a;
            if (str3.charAt(0) == '1' && str3.charAt(6) == '1') {
                str4 = "granted";
            }
            bundle.putString(str7, str4);
        }
        return bundle;
    }

    public final String e() {
        int i4;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int h4 = h();
        if (h4 < 0 || h4 > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((h4 >> 6) & 63));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(h4 & 63));
        }
        int i5 = i();
        if (i5 < 0 || i5 > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5));
        }
        C0335p.a(true);
        if ("1".equals(this.f3349a.get("gdprApplies"))) {
            i4 = 2;
        } else {
            i4 = 0;
        }
        int i6 = i4 | 4;
        if ("1".equals(this.f3349a.get("EnableAdvertiserConsentMode"))) {
            i6 = i4 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0907z5)) {
            return false;
        }
        return g().equalsIgnoreCase(((C0907z5) obj).g());
    }

    /* access modifiers changed from: package-private */
    public final String g() {
        StringBuilder sb = new StringBuilder();
        for (String str : f3348b) {
            if (this.f3349a.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) this.f3349a.get(str));
            }
        }
        return sb.toString();
    }

    public final int hashCode() {
        return g().hashCode();
    }

    public final String toString() {
        return g();
    }
}
