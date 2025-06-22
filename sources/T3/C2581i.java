package T3;

import A2.a;
import A3.k;
import E2.t;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: T3.i  reason: case insensitive filesystem */
public final class C2581i extends C2580h {

    /* renamed from: e  reason: collision with root package name */
    public final String f23999e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24000f;

    /* renamed from: g  reason: collision with root package name */
    public final int f24001g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24002h;

    /* renamed from: i  reason: collision with root package name */
    public final String f24003i;

    /* renamed from: j  reason: collision with root package name */
    public final String f24004j;

    public C2581i(String str, String str2, int i4, String str3, String str4, String str5) {
        m.e(str, "accountId");
        m.e(str2, "publisher");
        m.e(str3, "cmpVersion");
        m.e(str4, "displayType");
        m.e(str5, "configurationHashCode");
        this.f23999e = str;
        this.f24000f = str2;
        this.f24001g = i4;
        this.f24002h = str3;
        this.f24003i = str4;
        this.f24004j = str5;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accountId", this.f23999e);
        jSONObject.put("publisher", this.f24000f);
        jSONObject.put("cmpId", this.f24001g);
        jSONObject.put("cmpVersion", this.f24002h);
        jSONObject.put("displayType", this.f24003i);
        jSONObject.put("configurationHashCode", this.f24004j);
        jSONObject.put("clientTimestamp", this.f23995a);
        jSONObject.put("operationType", this.f23996b.f23973a);
        jSONObject.put("sessionId", this.f23997c);
        jSONObject.put("domain", this.f23998d);
        String jSONObject2 = jSONObject.toString();
        m.d(jSONObject2, "JSONObject().apply {\n   … domain)\n    }.toString()");
        return jSONObject2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2581i)) {
            return false;
        }
        C2581i iVar = (C2581i) obj;
        if (m.a(this.f23999e, iVar.f23999e) && m.a(this.f24000f, iVar.f24000f) && this.f24001g == iVar.f24001g && m.a(this.f24002h, iVar.f24002h) && m.a(this.f24003i, iVar.f24003i) && m.a(this.f24004j, iVar.f24004j)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24004j.hashCode() + t.a(this.f24003i, t.a(this.f24002h, k.a(this.f24001g, t.a(this.f24000f, this.f23999e.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("TrackingInitLog(accountId=");
        a5.append(this.f23999e);
        a5.append(", publisher=");
        a5.append(this.f24000f);
        a5.append(", cmpId=");
        a5.append(this.f24001g);
        a5.append(", cmpVersion=");
        a5.append(this.f24002h);
        a5.append(", displayType=");
        a5.append(this.f24003i);
        a5.append(", configurationHashCode=");
        a5.append(this.f24004j);
        a5.append(')');
        return a5.toString();
    }
}
