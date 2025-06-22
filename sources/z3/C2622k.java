package Z3;

import A3.a;
import A3.e;
import A3.f;
import C2.b;
import C2.c;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.k  reason: case insensitive filesystem */
public final class C2622k implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f24378a;

    public Object a(String str) {
        String str2 = str;
        m.e(str2, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str2);
            try {
                this.f24378a = jSONObject;
                return new a(jSONObject.optString("jurisdiction"), (String) null, b(), (List) null, 10);
            } catch (JSONException unused) {
                b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
                return new a((String) null, (String) null, (List) null, (List) null, 15);
            }
        } catch (JSONException unused2) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (c) null, (Throwable) null, 30);
            return new a((String) null, (String) null, (List) null, (List) null, 15);
        }
    }

    public final List b() {
        M2.a aVar;
        JSONObject jSONObject = this.f24378a;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
                Integer valueOf = Integer.valueOf(optJSONObject.optInt("id"));
                Boolean valueOf2 = Boolean.valueOf(optJSONObject.optBoolean("defaultValue"));
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("consentBanner");
                if (optJSONObject2 == null) {
                    aVar = new M2.a((String) null, (String) null, (String) null, (String) null, 15);
                } else {
                    String optString = optJSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
                    aVar = new M2.a(optString, (String) null, C2615d.a(optString, "it.optString(\"title\")", optJSONObject2, "description", "it.optString(\"description\")"), (String) null, 10);
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("purposes");
                ArrayList arrayList2 = new ArrayList();
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    int i6 = 0;
                    while (i6 < length2) {
                        int i7 = i6 + 1;
                        JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                        Integer valueOf3 = Integer.valueOf(optJSONObject3.optInt("id"));
                        Integer valueOf4 = Integer.valueOf(optJSONObject3.optInt("order"));
                        String optString2 = optJSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                        String optString3 = optJSONObject3.optString("description");
                        m.d(optJSONObject3, "mspaSensitivePurpose");
                        arrayList2.add(new f(valueOf3, valueOf4, optString2, (Boolean) null, optString3, C2620i.a(optJSONObject3, "nationalIds"), 8));
                        i6 = i7;
                        optJSONArray2 = optJSONArray2;
                    }
                }
                arrayList.add(new e(valueOf, (String) null, valueOf2, (Boolean) null, aVar, arrayList2, (List) null, 74));
                i4 = i5;
            }
        }
        return arrayList;
    }
}
