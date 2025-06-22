package g2;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

public final class Y {

    /* renamed from: a  reason: collision with root package name */
    private int f20514a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20515b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20516c;

    /* renamed from: d  reason: collision with root package name */
    private int f20517d;

    public final void a(JSONObject jSONObject) {
        m.e(jSONObject, "jsonObject");
        if (!jSONObject.isNull("id")) {
            this.f20514a = jSONObject.optInt("id");
        }
        if (!jSONObject.isNull(RewardPlus.NAME)) {
            this.f20515b = jSONObject.optString(RewardPlus.NAME);
        }
        if (!jSONObject.isNull("isChecked")) {
            this.f20516c = jSONObject.optBoolean("isChecked");
        }
        if (!jSONObject.isNull("isTurbo")) {
            this.f20517d = jSONObject.optInt("isTurbo");
        }
    }

    public final int b() {
        return this.f20514a;
    }

    public final String c() {
        return this.f20515b;
    }

    public final boolean d() {
        return this.f20516c;
    }

    public final boolean e() {
        if (this.f20517d == 1) {
            return true;
        }
        return false;
    }
}
