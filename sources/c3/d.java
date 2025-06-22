package C3;

import A2.a;
import E2.t;
import S2.C1601o;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.m;
import z3.c;
import z3.h;
import z3.l;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f159a;

    /* renamed from: b  reason: collision with root package name */
    public final String f160b;

    /* renamed from: c  reason: collision with root package name */
    public final String f161c;

    /* renamed from: d  reason: collision with root package name */
    public final String f162d;

    /* renamed from: e  reason: collision with root package name */
    public final String f163e;

    /* renamed from: f  reason: collision with root package name */
    public final List f164f;

    /* renamed from: g  reason: collision with root package name */
    public final List f165g;

    public d(int i4, String str, String str2, String str3, String str4, List list, List list2) {
        m.e(str, "pCode");
        m.e(str2, RewardPlus.NAME);
        m.e(str3, "description");
        m.e(str4, "privacyPolicyUrl");
        m.e(list, "nonIabPurposeConsentIds");
        m.e(list2, "nonIabPurposeLegitimateInterestIds");
        this.f159a = i4;
        this.f160b = str;
        this.f161c = str2;
        this.f162d = str3;
        this.f163e = str4;
        this.f164f = list;
        this.f165g = list2;
    }

    public final l a() {
        return new l(this.f159a, this.f161c, this.f162d, C1601o.c0(this.f164f), C1601o.c0(this.f165g), (Set) null, (Set) null, (Set) null, (Set) null, this.f163e, (String) null, (h) null, 0, false, false, (Boolean) null, (Set) null, (c) null, (Set) null, (String) null, 914912);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f159a == dVar.f159a && m.a(this.f160b, dVar.f160b) && m.a(this.f161c, dVar.f161c) && m.a(this.f162d, dVar.f162d) && m.a(this.f163e, dVar.f163e) && m.a(this.f164f, dVar.f164f) && m.a(this.f165g, dVar.f165g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f165g.hashCode() + A3.l.a(this.f164f, t.a(this.f163e, t.a(this.f162d, t.a(this.f161c, t.a(this.f160b, this.f159a * 31, 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder a5 = a.a("NonIABVendor(vendorId=");
        a5.append(this.f159a);
        a5.append(", pCode=");
        a5.append(this.f160b);
        a5.append(", name=");
        a5.append(this.f161c);
        a5.append(", description=");
        a5.append(this.f162d);
        a5.append(", privacyPolicyUrl=");
        a5.append(this.f163e);
        a5.append(", nonIabPurposeConsentIds=");
        a5.append(this.f164f);
        a5.append(", nonIabPurposeLegitimateInterestIds=");
        a5.append(this.f165g);
        a5.append(')');
        return a5.toString();
    }
}
