package Z3;

import C2.c;
import P2.b;
import com.inmobi.cmp.model.ChoiceError;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.g  reason: case insensitive filesystem */
public final class C2618g implements C2621j {
    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("country");
            m.d(optString, "json.optString(\"country\")");
            String optString2 = jSONObject.optString(TtmlNode.TAG_REGION);
            m.d(optString2, "json.optString(\"region\")");
            String optString3 = jSONObject.optString("city");
            m.d(optString3, "json.optString(\"city\")");
            return new b(optString, optString2, optString3);
        } catch (JSONException unused) {
            C2.b.a(C2.b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new b((String) null, (String) null, (String) null, 7);
        }
    }
}
