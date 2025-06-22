package g2;

import android.content.Context;
import com.uptodown.activities.preferences.a;
import java.util.Arrays;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class L {

    /* renamed from: a  reason: collision with root package name */
    private String f20404a;

    /* renamed from: b  reason: collision with root package name */
    private int f20405b;

    /* renamed from: c  reason: collision with root package name */
    private String f20406c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f20407d;

    public final void a(Context context) {
        m.e(context, "context");
        if (this.f20405b == 526) {
            a.C0236a aVar = a.f18818a;
            aVar.h1(context, true);
            aVar.o1(context, 671);
            String str = this.f20404a;
            if (str != null && str.length() != 0) {
                String str2 = this.f20404a;
                m.b(str2);
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.isNull("url_update")) {
                    aVar.m1(context, jSONObject.optString("url_update"));
                }
            }
        }
    }

    public final boolean b() {
        int i4 = this.f20405b;
        if (i4 < 200 || i4 >= 300) {
            return true;
        }
        return false;
    }

    public final String c() {
        return this.f20406c;
    }

    public final String d() {
        return this.f20404a;
    }

    public final JSONObject e() {
        return this.f20407d;
    }

    public final int f() {
        return this.f20405b;
    }

    public final String g(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        String str = null;
        try {
            if (!jSONObject.isNull("errorMsg")) {
                Object obj = jSONObject.get("errorMsg");
                if (obj instanceof JSONArray) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("errorMsg");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            if (str == null || m.a(str, "")) {
                                str = optJSONArray.getString(i4);
                            } else {
                                F f4 = F.f20971a;
                                String format = String.format("%s\n%s", Arrays.copyOf(new Object[]{str, optJSONArray.optString(i4)}, 2));
                                m.d(format, "format(...)");
                                str = format;
                            }
                        }
                        return str;
                    }
                } else if (obj instanceof String) {
                    return (String) obj;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final void h(String str) {
        this.f20406c = str;
    }

    public final void i(String str) {
        this.f20404a = str;
    }

    public final void j(JSONObject jSONObject) {
        this.f20407d = jSONObject;
    }

    public final void k(int i4) {
        this.f20405b = i4;
    }
}
