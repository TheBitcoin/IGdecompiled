package g2;

import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.E  reason: case insensitive filesystem */
public final class C2037E {

    /* renamed from: a  reason: collision with root package name */
    private String f20363a;

    /* renamed from: b  reason: collision with root package name */
    private String f20364b;

    public final void a(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("permission")) {
            this.f20363a = jSONObject.optString("permission");
        }
        if (!jSONObject.isNull("description")) {
            this.f20364b = jSONObject.optString("description");
        }
    }

    public final String b() {
        return this.f20363a;
    }

    public final void c(String str) {
        this.f20364b = str;
    }

    public final void d(String str) {
        this.f20363a = str;
    }
}
