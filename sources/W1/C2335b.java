package w1;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: w1.b  reason: case insensitive filesystem */
public abstract class C2335b {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return "Android";
    }

    public static String c() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, "deviceType", a());
        C2336c.g(jSONObject, "osVersion", c());
        C2336c.g(jSONObject, "os", b());
        return jSONObject;
    }
}
