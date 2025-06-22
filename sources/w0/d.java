package w0;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;
import v0.g;
import x0.C2347a;
import x0.C2348b;

public class d implements b, C2348b {

    /* renamed from: a  reason: collision with root package name */
    private C2347a f22009a;

    private static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String next : bundle.keySet()) {
            jSONObject2.put(next, bundle.get(next));
        }
        jSONObject.put(RewardPlus.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public void a(C2347a aVar) {
        this.f22009a = aVar;
        g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    public void j(String str, Bundle bundle) {
        C2347a aVar = this.f22009a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
