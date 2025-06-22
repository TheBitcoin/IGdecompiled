package g2;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g2.e  reason: case insensitive filesystem */
public final class C2047e {

    /* renamed from: a  reason: collision with root package name */
    private String f20562a;

    /* renamed from: b  reason: collision with root package name */
    private String f20563b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f20564c;

    public final ArrayList a() {
        return this.f20564c;
    }

    public final String b() {
        return this.f20563b;
    }

    public final String c() {
        return this.f20562a;
    }

    public final void d(JSONObject jSONObject) {
        m.e(jSONObject, "jsonData");
        if (!jSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
            this.f20562a = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        }
        if (!jSONObject.isNull("description")) {
            this.f20563b = jSONObject.optString("description");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("apps");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                C2050h hVar = new C2050h();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                m.b(jSONObject2);
                C2050h.b(hVar, jSONObject2, (Context) null, 2, (Object) null);
                arrayList.add(hVar);
            }
            this.f20564c = arrayList;
        }
    }
}
