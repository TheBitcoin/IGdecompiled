package T3;

import A2.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: T3.k  reason: case insensitive filesystem */
public final class C2583k extends C2580h {

    /* renamed from: e  reason: collision with root package name */
    public final List f24014e;

    public C2583k(List list) {
        m.e(list, "userEvents");
        this.f24014e = list;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        for (C2587o a5 : this.f24014e) {
            arrayList.add(new JSONObject(a5.a()));
        }
        jSONObject.put("userEvents", new JSONArray(arrayList));
        jSONObject.put("clientTimestamp", this.f23995a);
        jSONObject.put("operationType", this.f23996b.f23973a);
        jSONObject.putOpt("sessionId", this.f23997c);
        jSONObject.put("domain", this.f23998d);
        String jSONObject2 = jSONObject.toString();
        m.d(jSONObject2, "JSONObject().apply {\n   … domain)\n    }.toString()");
        return jSONObject2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C2583k) && m.a(this.f24014e, ((C2583k) obj).f24014e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24014e.hashCode();
    }

    public String toString() {
        StringBuilder a5 = a.a("TrackingUserEventsLog(userEvents=");
        a5.append(this.f24014e);
        a5.append(')');
        return a5.toString();
    }
}
