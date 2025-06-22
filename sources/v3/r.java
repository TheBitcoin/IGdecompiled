package V3;

import A2.a;
import java.util.List;
import kotlin.jvm.internal.m;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public C2594e f24230a;

    /* renamed from: b  reason: collision with root package name */
    public C2603n f24231b;

    /* renamed from: c  reason: collision with root package name */
    public C2598i f24232c;

    public r(C2594e eVar, C2603n nVar, C2598i iVar) {
        m.e(eVar, "coreUiLabels");
        m.e(nVar, "premiumUiLabels");
        m.e(iVar, "mobileUiLabels");
        this.f24230a = eVar;
        this.f24231b = nVar;
        this.f24232c = iVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (m.a(this.f24230a, rVar.f24230a) && m.a(this.f24231b, rVar.f24231b) && m.a(this.f24232c, rVar.f24232c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f24231b.hashCode();
        return this.f24232c.hashCode() + ((hashCode + (this.f24230a.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("TranslationsText(coreUiLabels=");
        a5.append(this.f24230a);
        a5.append(", premiumUiLabels=");
        a5.append(this.f24231b);
        a5.append(", mobileUiLabels=");
        a5.append(this.f24232c);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(C2594e eVar, C2603n nVar, C2598i iVar, int i4) {
        this((i4 & 1) != 0 ? new C2594e((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, (List) null, (List) null, (List) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, -1, 262143) : null, (i4 & 2) != 0 ? new C2603n((String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 1023) : null, (i4 & 4) != 0 ? new C2598i((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (List) null, 32767) : null);
    }
}
