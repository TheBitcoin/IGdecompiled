package q1;

import org.json.JSONObject;
import w1.C2336c;
import w1.C2340g;

/* renamed from: q1.c  reason: case insensitive filesystem */
public class C2207c {

    /* renamed from: a  reason: collision with root package name */
    private final k f21506a;

    /* renamed from: b  reason: collision with root package name */
    private final k f21507b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f21508c;

    /* renamed from: d  reason: collision with root package name */
    private final f f21509d;

    /* renamed from: e  reason: collision with root package name */
    private final i f21510e;

    private C2207c(f fVar, i iVar, k kVar, k kVar2, boolean z4) {
        this.f21509d = fVar;
        this.f21510e = iVar;
        this.f21506a = kVar;
        if (kVar2 == null) {
            this.f21507b = k.NONE;
        } else {
            this.f21507b = kVar2;
        }
        this.f21508c = z4;
    }

    public static C2207c a(f fVar, i iVar, k kVar, k kVar2, boolean z4) {
        C2340g.b(fVar, "CreativeType is null");
        C2340g.b(iVar, "ImpressionType is null");
        C2340g.b(kVar, "Impression owner is null");
        C2340g.e(kVar, fVar, iVar);
        return new C2207c(fVar, iVar, kVar, kVar2, z4);
    }

    public boolean b() {
        if (k.NATIVE == this.f21506a) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (k.NATIVE == this.f21507b) {
            return true;
        }
        return false;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, "impressionOwner", this.f21506a);
        C2336c.g(jSONObject, "mediaEventsOwner", this.f21507b);
        C2336c.g(jSONObject, "creativeType", this.f21509d);
        C2336c.g(jSONObject, "impressionType", this.f21510e);
        C2336c.g(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f21508c));
        return jSONObject;
    }
}
