package C3;

import A2.a;
import A3.l;
import S2.C1601o;
import java.util.List;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f156a;

    /* renamed from: b  reason: collision with root package name */
    public final List f157b;

    /* renamed from: c  reason: collision with root package name */
    public final List f158c;

    public c(boolean z4, List list, List list2) {
        m.e(list, "locations");
        m.e(list2, "applicablePurposes");
        this.f156a = z4;
        this.f157b = list;
        this.f158c = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f156a == cVar.f156a && m.a(this.f157b, cVar.f157b) && m.a(this.f158c, cVar.f158c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z4 = this.f156a;
        if (z4) {
            z4 = true;
        }
        return this.f158c.hashCode() + l.a(this.f157b, (z4 ? 1 : 0) * true, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("GBCConfig(enabled=");
        a5.append(this.f156a);
        a5.append(", locations=");
        a5.append(this.f157b);
        a5.append(", applicablePurposes=");
        a5.append(this.f158c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(boolean z4, List list, List list2, int i4) {
        this((i4 & 1) != 0 ? false : z4, (i4 & 2) != 0 ? C1601o.h() : null, (i4 & 4) != 0 ? C1601o.h() : null);
    }
}
