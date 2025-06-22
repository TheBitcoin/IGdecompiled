package M2;

import A2.a;
import S2.C1601o;
import java.util.List;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f7743a;

    /* renamed from: b  reason: collision with root package name */
    public final a f7744b;

    /* renamed from: c  reason: collision with root package name */
    public final List f7745c;

    public c(String str, a aVar, List list) {
        m.e(aVar, "banner");
        m.e(list, "purposes");
        this.f7743a = str;
        this.f7744b = aVar;
        this.f7745c = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (m.a(this.f7743a, cVar.f7743a) && m.a(this.f7744b, cVar.f7744b) && m.a(this.f7745c, cVar.f7745c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        String str = this.f7743a;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int hashCode = this.f7744b.hashCode();
        return this.f7745c.hashCode() + ((hashCode + (i4 * 31)) * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("GBCPurposeResponse(language=");
        a5.append(this.f7743a);
        a5.append(", banner=");
        a5.append(this.f7744b);
        a5.append(", purposes=");
        a5.append(this.f7745c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(String str, a aVar, List list, int i4) {
        this((i4 & 1) != 0 ? "" : null, (i4 & 2) != 0 ? new a((String) null, (String) null, (String) null, (String) null, 15) : null, (i4 & 4) != 0 ? C1601o.h() : null);
    }
}
