package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.toolbox.f;
import com.mbridge.msdk.tracker.network.w;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends i<JSONObject> implements w.a {

    /* renamed from: b  reason: collision with root package name */
    private final k<JSONObject> f15544b;

    public j(int i4, String str, String str2, long j4, k<JSONObject> kVar) {
        super(i4, str, 0, str2, j4);
        this.f15544b = kVar;
        a((w.a) this);
    }

    private void b(w<JSONObject> wVar) {
        k<JSONObject> kVar = this.f15544b;
        if (kVar != null) {
            try {
                kVar.b(this, wVar, wVar.f15667c.f15507a);
            } catch (Exception e5) {
                af.b(i.f15538a, e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
    }

    /* access modifiers changed from: protected */
    public final w<JSONObject> a(r rVar) {
        try {
            String str = new String(rVar.f15601b, StandardCharsets.UTF_8);
            if (rVar.f15600a == 204) {
                w<JSONObject> a5 = w.a(new JSONObject(), f.a(rVar));
                a(a5, rVar);
                return a5;
            }
            w<JSONObject> a6 = w.a(new JSONObject(str), f.a(rVar));
            a(a6, rVar);
            return a6;
        } catch (JSONException e5) {
            af.b(i.f15538a, e5.getMessage());
            w<JSONObject> a7 = w.a(new t(e5));
            b(a7);
            return a7;
        } catch (Throwable th) {
            w<JSONObject> a8 = w.a(new ac(th));
            b(a8);
            return a8;
        }
    }

    private void a(w<JSONObject> wVar, r rVar) {
        k<JSONObject> kVar = this.f15544b;
        if (kVar != null) {
            try {
                kVar.a(this, wVar, rVar);
            } catch (Exception e5) {
                af.b(i.f15538a, e5.getMessage());
            }
        }
    }

    public final void a(ad adVar) {
        b(w.a(adVar));
    }
}
