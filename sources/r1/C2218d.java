package r1;

import org.json.JSONException;
import org.json.JSONObject;
import w1.C2337d;
import w1.C2340g;

/* renamed from: r1.d  reason: case insensitive filesystem */
public final class C2218d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f21593a;

    /* renamed from: b  reason: collision with root package name */
    private final Float f21594b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21595c;

    /* renamed from: d  reason: collision with root package name */
    private final C2217c f21596d;

    private C2218d(boolean z4, Float f4, boolean z5, C2217c cVar) {
        this.f21593a = z4;
        this.f21594b = f4;
        this.f21595c = z5;
        this.f21596d = cVar;
    }

    public static C2218d b(boolean z4, C2217c cVar) {
        C2340g.b(cVar, "Position is null");
        return new C2218d(false, (Float) null, z4, cVar);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", this.f21593a);
            if (this.f21593a) {
                jSONObject.put("skipOffset", this.f21594b);
            }
            jSONObject.put("autoPlay", this.f21595c);
            jSONObject.put("position", this.f21596d);
            return jSONObject;
        } catch (JSONException e5) {
            C2337d.b("VastProperties: JSON error", e5);
            return jSONObject;
        }
    }
}
