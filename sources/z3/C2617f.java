package Z3;

import C2.b;
import M2.a;
import M2.c;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: Z3.f  reason: case insensitive filesystem */
public final class C2617f implements C2621j {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f24376a;

    public Object a(String str) {
        m.e(str, "jsonString");
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f24376a = jSONObject;
            return new c(jSONObject.optString("language"), a(), b());
        } catch (JSONException unused) {
            b.a(b.f6277a, ChoiceError.INVALID_JSON_FORMAT, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
            return new c((String) null, (a) null, (List) null, 7);
        }
    }

    public final List b() {
        JSONObject jSONObject = this.f24376a;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("purposes");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                Integer valueOf = Integer.valueOf(jSONObject2.optInt("id"));
                JSONObject jSONObject3 = jSONObject2.getJSONObject("banner");
                m.d(jSONObject3, "gbcPurpose.getJSONObject(\"banner\")");
                String optString = jSONObject3.optString(CampaignEx.JSON_KEY_TITLE);
                m.d(optString, "jsonObject.optString(\"title\")");
                arrayList.add(new M2.b(valueOf, new a(optString, (String) null, (String) null, (String) null, 14)));
                i4 = i5;
            }
        }
        return arrayList;
    }

    public final a a() {
        JSONObject jSONObject = this.f24376a;
        if (jSONObject == null) {
            m.u("json");
            jSONObject = null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
        String optString = jSONObject2.optString(CampaignEx.JSON_KEY_TITLE);
        String a5 = C2615d.a(optString, "bannerDetails.optString(\"title\")", jSONObject2, "sectionTitle", "bannerDetails.optString(\"sectionTitle\")");
        String optString2 = jSONObject2.optString("description");
        return new a(optString, a5, optString2, C2615d.a(optString2, "bannerDetails.optString(\"description\")", jSONObject2, "confirm", "bannerDetails.optString(\"confirm\")"));
    }
}
