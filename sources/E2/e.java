package E2;

import A2.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Map f6348a;

    public e(Map map) {
        m.e(map, "googleVendorsInfoList");
        this.f6348a = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof e) && m.a(this.f6348a, ((e) obj).f6348a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6348a.hashCode();
    }

    public String toString() {
        StringBuilder a5 = a.a("GoogleVendorList(googleVendorsInfoList=");
        a5.append(this.f6348a);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Map map, int i4) {
        this((i4 & 1) != 0 ? new LinkedHashMap() : null);
    }
}
