package T3;

import A2.a;
import R2.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: T3.l  reason: case insensitive filesystem */
public final class C2584l extends C2580h {

    /* renamed from: e  reason: collision with root package name */
    public final List f24015e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24016f;

    /* renamed from: g  reason: collision with root package name */
    public final List f24017g;

    public C2584l(List list, String str, List list2) {
        m.e(list, "userEvents");
        this.f24015e = list;
        this.f24016f = str;
        this.f24017g = list2;
    }

    public String a() {
        ArrayList arrayList;
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList2 = new ArrayList();
        for (C2587o a5 : this.f24015e) {
            arrayList2.add(new JSONObject(a5.a()));
        }
        jSONObject.put("userEvents", new JSONArray(arrayList2));
        jSONObject.putOpt("acceptanceState", this.f24016f);
        if (this.f24017g == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (l lVar : this.f24017g) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(String.valueOf(((Number) lVar.c()).intValue()), lVar.d());
                arrayList.add(jSONObject2);
            }
        }
        jSONObject.putOpt("gbcData", new JSONArray(arrayList));
        jSONObject.put("clientTimestamp", this.f23995a);
        jSONObject.put("operationType", this.f23996b.f23973a);
        jSONObject.putOpt("sessionId", this.f23997c);
        jSONObject.put("domain", this.f23998d);
        String jSONObject3 = jSONObject.toString();
        m.d(jSONObject3, "JSONObject().apply {\n   … domain)\n    }.toString()");
        return jSONObject3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2584l)) {
            return false;
        }
        C2584l lVar = (C2584l) obj;
        if (m.a(this.f24015e, lVar.f24015e) && m.a(this.f24016f, lVar.f24016f) && m.a(this.f24017g, lVar.f24017g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.f24015e.hashCode() * 31;
        String str = this.f24016f;
        int i5 = 0;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int i6 = (hashCode + i4) * 31;
        List list = this.f24017g;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        StringBuilder a5 = a.a("TrackingUserGBCDoneLog(userEvents=");
        a5.append(this.f24015e);
        a5.append(", acceptanceState=");
        a5.append(this.f24016f);
        a5.append(", gbcData=");
        a5.append(this.f24017g);
        a5.append(')');
        return a5.toString();
    }
}
