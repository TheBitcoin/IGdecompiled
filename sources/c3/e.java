package C3;

import A2.a;
import E2.t;
import S2.C1601o;
import java.util.List;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public List f166a;

    /* renamed from: b  reason: collision with root package name */
    public final String f167b;

    /* renamed from: c  reason: collision with root package name */
    public final String f168c;

    public e(List list, String str, String str2) {
        m.e(list, "nonIabVendorList");
        m.e(str, "updateAt");
        m.e(str2, "nonIabVendorsHash");
        this.f166a = list;
        this.f167b = str;
        this.f168c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (m.a(this.f166a, eVar.f166a) && m.a(this.f167b, eVar.f167b) && m.a(this.f168c, eVar.f168c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f168c.hashCode() + t.a(this.f167b, this.f166a.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("NonIabVendorsInfo(nonIabVendorList=");
        a5.append(this.f166a);
        a5.append(", updateAt=");
        a5.append(this.f167b);
        a5.append(", nonIabVendorsHash=");
        a5.append(this.f168c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(List list, String str, String str2, int i4) {
        this((i4 & 1) != 0 ? C1601o.h() : null, (i4 & 2) != 0 ? "" : null, (i4 & 4) != 0 ? "" : null);
    }
}
