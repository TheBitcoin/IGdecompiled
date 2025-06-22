package C3;

import A2.a;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f154a;

    /* renamed from: b  reason: collision with root package name */
    public final GBCConsentValue f155b;

    public b(int i4, GBCConsentValue gBCConsentValue) {
        m.e(gBCConsentValue, "defaultValue");
        this.f154a = i4;
        this.f155b = gBCConsentValue;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f154a == bVar.f154a && this.f155b == bVar.f155b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f155b.hashCode() + (this.f154a * 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("GBCApplicablePurpose(id=");
        a5.append(this.f154a);
        a5.append(", defaultValue=");
        a5.append(this.f155b);
        a5.append(')');
        return a5.toString();
    }
}
