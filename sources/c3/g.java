package C3;

import A2.a;
import A3.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final List f175a;

    /* renamed from: b  reason: collision with root package name */
    public final List f176b;

    /* renamed from: c  reason: collision with root package name */
    public final List f177c;

    public g(List list, List list2, List list3) {
        m.e(list, "vendorBlacklist");
        m.e(list2, "vendorWhitelist");
        m.e(list3, "googleWhitelist");
        this.f175a = list;
        this.f176b = list2;
        this.f177c = list3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (m.a(this.f175a, gVar.f175a) && m.a(this.f176b, gVar.f176b) && m.a(this.f177c, gVar.f177c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f177c.hashCode() + l.a(this.f176b, this.f175a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("PremiumProperties(vendorBlacklist=");
        a5.append(this.f175a);
        a5.append(", vendorWhitelist=");
        a5.append(this.f176b);
        a5.append(", googleWhitelist=");
        a5.append(this.f177c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(List list, List list2, List list3, int i4) {
        this((i4 & 1) != 0 ? new ArrayList() : null, (i4 & 2) != 0 ? new ArrayList() : null, (i4 & 4) != 0 ? new ArrayList() : null);
    }
}
