package Z3;

import C2.b;
import C2.c;
import V3.C2593d;
import V3.C2595f;
import com.inmobi.cmp.model.ChoiceError;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.e  reason: case insensitive filesystem */
public final class C2616e implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f24375a;

    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            this.f24375a = new JSONObject(str);
            return new C2593d(b());
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new C2593d((List) null, 1);
        }
    }

    public final List b() {
        JSONObject jSONObject = this.f24375a;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("disclosures");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
            String optString = jSONObject2.optString("identifier");
            String a5 = C2615d.a(optString, "disclosure.optString(\"identifier\")", jSONObject2, "type", "disclosure.optString(\"type\")");
            int optInt = jSONObject2.optInt("maxAgeSeconds");
            String optString2 = jSONObject2.optString("domain");
            m.d(optString2, "disclosure.optString(\"domain\")");
            m.d(jSONObject2, "disclosure");
            arrayList.add(new C2595f(optString, a5, optInt, optString2, C2620i.a(jSONObject2, "purposes")));
            i4 = i5;
        }
        return arrayList;
    }
}
