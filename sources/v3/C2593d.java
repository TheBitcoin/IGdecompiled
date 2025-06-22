package V3;

import A2.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: V3.d  reason: case insensitive filesystem */
public final class C2593d {

    /* renamed from: a  reason: collision with root package name */
    public final List f24079a;

    public C2593d(List list) {
        m.e(list, "disclosures");
        this.f24079a = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof C2593d) && m.a(this.f24079a, ((C2593d) obj).f24079a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f24079a.hashCode();
    }

    public String toString() {
        StringBuilder a5 = a.a("CookieDisclosure(disclosures=");
        a5.append(this.f24079a);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2593d(List list, int i4) {
        this((i4 & 1) != 0 ? new ArrayList() : null);
    }
}
