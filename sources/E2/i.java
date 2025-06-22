package E2;

import G2.e;
import java.util.List;
import kotlin.jvm.internal.m;

public final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6358c = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f6359a;

    /* renamed from: b  reason: collision with root package name */
    public k f6360b;

    public static final class a {
        public final i a(String str) {
            k kVar;
            m.e(str, "hash");
            String str2 = str;
            List j02 = m3.m.j0(str2, new String[]{"-"}, false, 0, 6, (Object) null);
            if (j02.size() == 2) {
                int parseInt = Integer.parseInt((String) j02.get(0));
                int parseInt2 = Integer.parseInt((String) j02.get(1));
                if (parseInt2 == 1) {
                    kVar = k.REQUIRE_CONSENT;
                } else if (parseInt2 != 2) {
                    kVar = k.NOT_ALLOWED;
                } else {
                    kVar = k.REQUIRE_LI;
                }
                return new i(parseInt, kVar);
            }
            StringBuilder sb = new StringBuilder();
            a aVar = i.f6358c;
            sb.append("f.i");
            sb.append(": TCModelError, hash: ");
            sb.append(str2);
            throw new e(sb.toString());
        }
    }

    public i(int i4, k kVar) {
        m.e(kVar, "restrictionType");
        this.f6359a = i4;
        this.f6360b = kVar;
    }

    public final String a() {
        if (this.f6359a > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6359a);
            sb.append('-');
            sb.append(this.f6360b.f6369a);
            return sb.toString();
        }
        throw new e(m.m("f.i", ": TCModelError, cannot hash invalid PurposeRestriction"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f6359a == iVar.f6359a && this.f6360b == iVar.f6360b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f6360b.hashCode() + (this.f6359a * 31);
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("PurposeRestriction(purposeId=");
        a5.append(this.f6359a);
        a5.append(", restrictionType=");
        a5.append(this.f6360b);
        a5.append(')');
        return a5.toString();
    }
}
