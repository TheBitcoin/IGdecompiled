package w1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q1.j;
import t1.C2288e;
import x1.b;

/* renamed from: w1.c  reason: case insensitive filesystem */
public abstract class C2336c {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f22012a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f22013b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    static float f22014c = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: w1.c$a */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22015a;

        static {
            int[] iArr = new int[j.values().length];
            f22015a = iArr;
            try {
                iArr[j.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* renamed from: w1.c$b */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final float f22016a;

        /* renamed from: b  reason: collision with root package name */
        final float f22017b;

        b(float f4, float f5) {
            this.f22016a = f4;
            this.f22017b = f5;
        }
    }

    static float a(int i4) {
        return ((float) i4) / f22014c;
    }

    public static JSONObject b(int i4, int i5, int i6, int i7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i4));
            jSONObject.put("y", (double) a(i5));
            jSONObject.put("width", (double) a(i6));
            jSONObject.put("height", (double) a(i7));
            return jSONObject;
        } catch (JSONException e5) {
            C2337d.b("Error with creating viewStateObject", e5);
            return jSONObject;
        }
    }

    private static b c(JSONObject jSONObject) {
        float f4;
        float f5;
        if (f22012a != null) {
            Point point = new Point(0, 0);
            f22012a.getDefaultDisplay().getRealSize(point);
            f5 = a(point.x);
            f4 = a(point.y);
        } else {
            f5 = 0.0f;
            f4 = 0.0f;
        }
        return new b(f5, f4);
    }

    public static void d(Context context) {
        if (context != null) {
            f22014c = context.getResources().getDisplayMetrics().density;
            f22012a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void e(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e5) {
            C2337d.b("Error with setting has window focus", e5);
        }
    }

    public static void f(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e5) {
            C2337d.b("Error with setting ad session id", e5);
        }
    }

    public static void g(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e5) {
            C2337d.b("JSONException during JSONObject.put for name [" + str + "]", e5);
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static void i(JSONObject jSONObject, j jVar) {
        try {
            jSONObject.put("noOutputDevice", l(jVar));
        } catch (JSONException e5) {
            C2337d.b("Error with setting output device status", e5);
        }
    }

    public static void j(JSONObject jSONObject, b.a aVar) {
        C2288e a5 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        ArrayList c5 = aVar.c();
        int size = c5.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = c5.get(i4);
            i4++;
            jSONArray.put((String) obj);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a5.d());
            jSONObject.put("friendlyObstructionPurpose", a5.b());
            jSONObject.put("friendlyObstructionReason", a5.a());
        } catch (JSONException e5) {
            C2337d.b("Error with setting friendly obstruction", e5);
        }
    }

    private static boolean k(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        return true;
    }

    private static boolean l(j jVar) {
        if (a.f22015a[jVar.ordinal()] != 1) {
            return false;
        }
        return true;
    }

    public static void m(JSONObject jSONObject) {
        b c5 = c(jSONObject);
        try {
            jSONObject.put("width", (double) c5.f22016a);
            jSONObject.put("height", (double) c5.f22017b);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public static void n(JSONObject jSONObject, Boolean bool) {
        if (bool.booleanValue()) {
            try {
                jSONObject.put("isPipActive", bool);
            } catch (JSONException e5) {
                C2337d.b("Error with setting is picture-in-picture active", e5);
            }
        }
    }

    public static void o(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e5) {
            C2337d.b("Error with setting not visible reason", e5);
        }
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!k(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            if (!v(optJSONArray.optJSONObject(i4), optJSONArray2.optJSONObject(i4))) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!k(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            if (!optJSONArray.optString(i4, "").equals(optJSONArray2.optString(i4, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean s(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean t(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f22013b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean v(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || !t(jSONObject, jSONObject2) || !u(jSONObject, jSONObject2) || !s(jSONObject, jSONObject2) || !r(jSONObject, jSONObject2) || !q(jSONObject, jSONObject2) || !p(jSONObject, jSONObject2)) {
            return false;
        }
        return true;
    }
}
