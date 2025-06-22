package Z3;

import C2.b;
import C2.c;
import E2.e;
import E2.f;
import com.inmobi.cmp.model.ChoiceError;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.h  reason: case insensitive filesystem */
public final class C2619h implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f24377a;

    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            this.f24377a = new JSONArray(str);
            return new e(b());
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new e((Map) null, 1);
        }
    }

    public final Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = this.f24377a;
        if (jSONArray == null) {
            m.u("googleVendorsJson");
            jSONArray = null;
        }
        int length = jSONArray.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            JSONArray jSONArray2 = this.f24377a;
            if (jSONArray2 == null) {
                m.u("googleVendorsJson");
                jSONArray2 = null;
            }
            String string = jSONArray2.getString(i4);
            if (string == null) {
                string = "0";
            }
            JSONArray jSONArray3 = this.f24377a;
            if (jSONArray3 == null) {
                m.u("googleVendorsJson");
                jSONArray3 = null;
            }
            JSONObject jSONObject = jSONArray3.getJSONObject(i4);
            String string2 = jSONObject.getString("provider_id");
            m.d(string2, "googleVendor.getString(\"provider_id\")");
            int parseInt = Integer.parseInt(string2);
            String string3 = jSONObject.getString("provider_name");
            m.d(string3, "googleVendor.getString(\"provider_name\")");
            String string4 = jSONObject.getString("policy_url");
            m.d(string4, "googleVendor.getString(\"policy_url\")");
            String string5 = jSONObject.getString("domains");
            m.d(string5, "googleVendor.getString(\"domains\")");
            linkedHashMap.put(string, new f(parseInt, string3, string4, string5));
            i4 = i5;
        }
        return linkedHashMap;
    }
}
