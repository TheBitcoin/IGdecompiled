package A0;

import B0.F;
import K0.C1492a;
import M0.d;
import org.json.JSONObject;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final C1492a f5730a = new d().j(C1265a.f5684a).i();

    static i a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static i b(String str, String str2, String str3, String str4, long j4) {
        return new C1266b(str, str2, i(str3), str4, j4);
    }

    private static String i(String str) {
        if (str.length() > 256) {
            return str.substring(0, 256);
        }
        return str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public F.e.d.C0075e h() {
        return F.e.d.C0075e.a().d(F.e.d.C0075e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
