package E2;

import A2.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Long f6352a;

    /* renamed from: b  reason: collision with root package name */
    public Map f6353b;

    public g(Long l4, Map map) {
        m.e(map, "cmpInfoMap");
        this.f6352a = l4;
        this.f6353b = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (m.a(this.f6352a, gVar.f6352a) && m.a(this.f6353b, gVar.f6353b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Long l4 = this.f6352a;
        if (l4 == null) {
            i4 = 0;
        } else {
            i4 = l4.hashCode();
        }
        return this.f6353b.hashCode() + (i4 * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("IabApprovedCmpList(lastUpdated=");
        a5.append(this.f6352a);
        a5.append(", cmpInfoMap=");
        a5.append(this.f6353b);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Long l4, Map map, int i4) {
        this((Long) null, (i4 & 2) != 0 ? new LinkedHashMap() : null);
    }
}
