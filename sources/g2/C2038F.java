package g2;

import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: g2.F  reason: case insensitive filesystem */
public final class C2038F {

    /* renamed from: a  reason: collision with root package name */
    private int f20365a;

    /* renamed from: b  reason: collision with root package name */
    private String f20366b;

    public final void a(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("positives")) {
            this.f20365a = jSONObject.optInt("positives");
        }
        if (!jSONObject.isNull("sha256")) {
            this.f20366b = jSONObject.optString("sha256");
        }
    }

    public final int b() {
        return this.f20365a;
    }

    public final String c() {
        return this.f20366b;
    }
}
