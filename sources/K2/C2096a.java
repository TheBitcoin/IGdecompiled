package k2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.util.Locale;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import l2.C2123c;
import l2.C2125e;
import l2.k;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: k2.a  reason: case insensitive filesystem */
public final class C2096a {

    /* renamed from: i  reason: collision with root package name */
    public static final C0259a f20936i = new C0259a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f20937a;

    /* renamed from: b  reason: collision with root package name */
    public final long f20938b = -1;

    /* renamed from: c  reason: collision with root package name */
    public final long f20939c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final String f20940d;

    /* renamed from: e  reason: collision with root package name */
    public final String f20941e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20942f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20943g;

    /* renamed from: h  reason: collision with root package name */
    public final String f20944h;

    /* renamed from: k2.a$a  reason: collision with other inner class name */
    public static final class C0259a {
        public C0259a(C2103g gVar) {
        }
    }

    /* renamed from: k2.a$b */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f20945a = Build.MODEL;

        /* renamed from: b  reason: collision with root package name */
        public final String f20946b = Build.MANUFACTURER;

        /* renamed from: c  reason: collision with root package name */
        public final String f20947c = Build.BRAND;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            String str = this.f20945a;
            if (!(str == null || str.length() == 0)) {
                jSONObject.put("model", this.f20945a);
            }
            String str2 = this.f20946b;
            if (!(str2 == null || str2.length() == 0)) {
                jSONObject.put("manufacturer", this.f20946b);
            }
            String str3 = this.f20947c;
            if (!(str3 == null || str3.length() == 0)) {
                jSONObject.put("brand", this.f20947c);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        }
    }

    public C2096a(Context context, String str) {
        m.e(context, "context");
        m.e(str, "token");
        this.f20937a = str;
        this.f20938b = new C2125e(context).a();
        String country = Locale.getDefault().getCountry();
        this.f20940d = country;
        if (country == null || country.length() == 0) {
            Object systemService = context.getSystemService("phone");
            m.c(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            this.f20940d = ((TelephonyManager) systemService).getNetworkCountryIso();
        }
        k kVar = k.f21023a;
        String packageName = context.getPackageName();
        m.d(packageName, "context.packageName");
        this.f20941e = kVar.a(context, packageName);
        try {
            PackageManager packageManager = context.getPackageManager();
            m.d(packageManager, "context.packageManager");
            String packageName2 = context.getPackageName();
            m.d(packageName2, "context.packageName");
            PackageInfo a5 = C2123c.a(packageManager, packageName2, 0);
            this.f20939c = kVar.e(a5);
            if (kVar.g(a5)) {
                this.f20943g = 1;
            } else {
                this.f20943g = 0;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
        }
        long j4 = this.f20939c;
        long j5 = this.f20938b;
        if (j4 <= j5) {
            this.f20942f = 0;
        } else if (j5 == -1) {
            this.f20942f = 0;
        } else {
            this.f20942f = 1;
        }
        this.f20944h = Locale.getDefault().getLanguage();
    }

    public final JSONObject a(Context context) {
        boolean z4;
        m.e(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.f20937a);
        jSONObject.put("sdkVersion", Build.VERSION.SDK_INT);
        String str = this.f20940d;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.f20940d;
            m.b(str2);
            String upperCase = str2.toUpperCase(Locale.ROOT);
            m.d(upperCase, "toUpperCase(...)");
            jSONObject.put("countryCode", upperCase);
        }
        String str3 = this.f20941e;
        if (!(str3 == null || str3.length() == 0)) {
            jSONObject.put("installer", this.f20941e);
        }
        jSONObject.put("update", this.f20942f);
        jSONObject.put("isSystemApp", this.f20943g);
        JSONObject a5 = new b().a();
        if (a5 != null) {
            jSONObject.put("device", a5);
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                JSONArray jSONArray = new JSONArray();
                for (String put : strArr) {
                    jSONArray.put(put);
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("abis", jSONArray);
                }
            }
        }
        String str4 = this.f20944h;
        if (!(str4 == null || str4.length() == 0)) {
            jSONObject.put("deviceLanguageCode", this.f20944h);
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            jSONObject.put("identifier", string);
        }
        return jSONObject;
    }
}
