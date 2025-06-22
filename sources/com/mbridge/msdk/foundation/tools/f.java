package com.mbridge.msdk.foundation.tools;

import C.a;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.b;
import com.mbridge.msdk.foundation.controller.authoritycontroller.c;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f13647a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f13648b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13649c = false;

    /* renamed from: d  reason: collision with root package name */
    public static int f13650d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f13651e = "";

    /* renamed from: f  reason: collision with root package name */
    private static boolean f13652f = false;

    /* renamed from: g  reason: collision with root package name */
    private static String f13653g = "";

    /* renamed from: h  reason: collision with root package name */
    private static boolean f13654h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f13655i = false;

    public static int a() {
        return f13650d;
    }

    public static String b() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!b.a()) {
            if (TextUtils.isEmpty(f13648b)) {
                return "";
            }
            return f13648b;
        } else if (TextUtils.isEmpty(f13648b)) {
            if (!f13649c) {
                a(com.mbridge.msdk.foundation.controller.c.m().c());
                f13649c = true;
            }
            return "";
        } else if (b.b()) {
            return f13648b;
        } else {
            if (f13650d == 0) {
                return f13648b;
            }
            return "";
        }
    }

    public static String c() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!b.a()) {
            if (TextUtils.isEmpty(f13647a)) {
                return "";
            }
            return f13647a;
        } else if (TextUtils.isEmpty(f13647a)) {
            ab.j();
            if (!f13649c) {
                a(com.mbridge.msdk.foundation.controller.c.m().c());
                f13649c = true;
            }
            if (TextUtils.isEmpty(f13647a)) {
                return "";
            }
            return f13647a;
        } else if (b.b()) {
            return f13647a;
        } else {
            if (f13650d == 0) {
                return f13647a;
            }
            return "";
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f13653g) && !f13652f) {
            e();
        }
        return f13653g;
    }

    public static String e() {
        if (!c.k() || !c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f13652f) {
            return f13651e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().c().getContentResolver();
            int i4 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i4);
            jSONObject.put("amazonId", string);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                f13653g = jSONObject2;
                f13651e = z.b(jSONObject2);
            }
        } catch (Settings.SettingNotFoundException e5) {
            af.b("DomainSameDiTool", e5.getMessage());
        } catch (Throwable th) {
            af.b("DomainSameDiTool", th.getMessage());
        }
        f13652f = true;
        return f13651e;
    }

    public static void a(int i4) {
        f13650d = i4;
    }

    public static void a(final Context context) {
        new Thread(new Runnable() {
            public final void run() {
                if (c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && b.a()) {
                    try {
                        a.C0000a a5 = a.a(context);
                        f.a(a5.a());
                        f.f13650d = a5.b() ? 1 : 0;
                        f.a(context, a5.a(), f.f13650d);
                    } catch (Exception unused) {
                        af.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                        try {
                            b.a a6 = new b().a(context);
                            f.a(a6.a());
                            f.f13650d = a6.b() ? 1 : 0;
                            f.a(context, a6.a(), f.f13650d);
                        } catch (Exception unused2) {
                            af.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                        }
                    } catch (Throwable th) {
                        af.b("DomainSameDiTool", th.getMessage());
                    }
                }
            }
        }).start();
    }

    public static void a(String str) {
        f13648b = z.b(str);
        f13647a = str;
    }

    static /* synthetic */ void a(Context context, String str, int i4) {
        try {
            if (ap.b(str)) {
                an.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            an.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i4));
        } catch (Exception e5) {
            af.b("DomainSameDiTool", e5.getMessage());
        }
    }

    public static void b(Context context) {
        if (context != null) {
            Class<WebEnvCheckEntry> cls = WebEnvCheckEntry.class;
            try {
                WebEnvCheckEntry newInstance = cls.newInstance();
                cls.getMethod("check", new Class[]{Context.class}).invoke(newInstance, new Object[]{context});
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public static boolean c(Context context) {
        try {
            if (f13655i) {
                return f13654h;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                f13654h = context.getPackageManager().checkPermission(z.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
            } else {
                f13654h = true;
            }
            f13655i = true;
            return f13654h;
        } catch (Exception unused) {
            f13654h = false;
        }
    }
}
