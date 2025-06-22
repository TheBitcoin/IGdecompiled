package Z3;

import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: Z3.d  reason: case insensitive filesystem */
public abstract /* synthetic */ class C2615d {
    public static String a(String str, String str2, JSONObject jSONObject, String str3, String str4) {
        m.d(str, str2);
        String optString = jSONObject.optString(str3);
        m.d(optString, str4);
        return optString;
    }
}
