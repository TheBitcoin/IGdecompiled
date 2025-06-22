package r1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;
import q1.C2206b;
import q1.n;
import t1.C2292i;
import w1.C2336c;
import w1.C2340g;

/* renamed from: r1.b  reason: case insensitive filesystem */
public final class C2216b {

    /* renamed from: a  reason: collision with root package name */
    private final n f21586a;

    private C2216b(n nVar) {
        this.f21586a = nVar;
    }

    private void e(float f4) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    private void f(float f4) {
        if (f4 < 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public static C2216b g(C2206b bVar) {
        n nVar = (n) bVar;
        C2340g.b(bVar, "AdSession is null");
        C2340g.k(nVar);
        C2340g.h(nVar);
        C2340g.g(nVar);
        C2340g.m(nVar);
        C2216b bVar2 = new C2216b(nVar);
        nVar.t().m(bVar2);
        return bVar2;
    }

    public void a(C2215a aVar) {
        C2340g.b(aVar, "InteractionType is null");
        C2340g.f(this.f21586a);
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, "interactionType", aVar);
        this.f21586a.t().f("adUserInteraction", jSONObject);
    }

    public void b() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d("bufferFinish");
    }

    public void c() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d("bufferStart");
    }

    public void d() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public void h() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d("firstQuartile");
    }

    public void i() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void j() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d(CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
    }

    public void k() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void l() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d("skipped");
    }

    public void m(float f4, float f5) {
        e(f4);
        f(f5);
        C2340g.f(this.f21586a);
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, TypedValues.TransitionType.S_DURATION, Float.valueOf(f4));
        C2336c.g(jSONObject, "mediaPlayerVolume", Float.valueOf(f5));
        C2336c.g(jSONObject, "deviceVolume", Float.valueOf(C2292i.d().c()));
        this.f21586a.t().f("start", jSONObject);
    }

    public void n() {
        C2340g.f(this.f21586a);
        this.f21586a.t().d("thirdQuartile");
    }

    public void o(float f4) {
        f(f4);
        C2340g.f(this.f21586a);
        JSONObject jSONObject = new JSONObject();
        C2336c.g(jSONObject, "mediaPlayerVolume", Float.valueOf(f4));
        C2336c.g(jSONObject, "deviceVolume", Float.valueOf(C2292i.d().c()));
        this.f21586a.t().f("volumeChange", jSONObject);
    }
}
