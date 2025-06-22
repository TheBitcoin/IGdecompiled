package T3;

import A2.a;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.adselection.u;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* renamed from: T3.o  reason: case insensitive filesystem */
public final class C2587o extends C2580h {

    /* renamed from: e  reason: collision with root package name */
    public long f24050e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24051f;

    public C2587o(long j4, String str) {
        m.e(str, NotificationCompat.CATEGORY_EVENT);
        this.f24050e = j4;
        this.f24051f = str;
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("clientTimestamp", Long.valueOf(this.f24050e));
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f24051f);
        jSONObject.putOpt("sessionId", this.f23997c);
        String jSONObject2 = jSONObject.toString();
        m.d(jSONObject2, "JSONObject().apply {\n   …ssionId)\n    }.toString()");
        return jSONObject2;
    }

    public void b(long j4) {
        this.f24050e = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2587o)) {
            return false;
        }
        C2587o oVar = (C2587o) obj;
        if (this.f24050e == oVar.f24050e && m.a(this.f24051f, oVar.f24051f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24051f.hashCode() + (u.a(this.f24050e) * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("UserEvent(clientTimestamp=");
        a5.append(this.f24050e);
        a5.append(", event=");
        a5.append(this.f24051f);
        a5.append(')');
        return a5.toString();
    }
}
