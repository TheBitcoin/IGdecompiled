package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13554a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f13555b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13556c = false;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13557d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f13558e = false;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f13559f = false;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13560g = false;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f13561h = false;

    static {
        if (!MBridgeConstans.DEBUG) {
        }
    }

    public static void a(String str, String str2) {
        if (f13554a && !TextUtils.isEmpty(str2)) {
            Log.d(a(str), str2);
        }
    }

    public static void b(String str, String str2) {
        if (f13555b && str2 != null) {
            Log.e(a(str), str2);
        }
    }

    public static void c(String str, String str2) {
        if (f13556c && !TextUtils.isEmpty(str2)) {
            Log.i(a(str), str2);
        }
    }

    public static void d(String str, String str2) {
        if (f13561h && !TextUtils.isEmpty(str2)) {
            Log.w(a(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f13555b && str2 != null && th != null) {
            Log.e(a(str), str2, th);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return "MBRIDGE_" + str;
    }

    public static void c(String str, String str2, Throwable th) {
        if (f13561h && !TextUtils.isEmpty(str2)) {
            Log.w(a(str), str2, th);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f13554a && !TextUtils.isEmpty(str2)) {
            Log.d(a(str), str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (f13561h && th != null) {
            Log.w(a(str), th);
        }
    }
}
