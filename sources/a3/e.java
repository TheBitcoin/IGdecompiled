package A3;

import M2.a;
import S2.C1601o;
import java.util.List;
import kotlin.jvm.internal.m;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f60a;

    /* renamed from: b  reason: collision with root package name */
    public final String f61b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f62c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f63d;

    /* renamed from: e  reason: collision with root package name */
    public final a f64e;

    /* renamed from: f  reason: collision with root package name */
    public final List f65f;

    /* renamed from: g  reason: collision with root package name */
    public List f66g;

    public e(Integer num, String str, Boolean bool, Boolean bool2, a aVar, List list, List list2) {
        this.f60a = num;
        this.f61b = str;
        this.f62c = bool;
        this.f63d = bool2;
        this.f64e = aVar;
        this.f65f = list;
        this.f66g = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (m.a(this.f60a, eVar.f60a) && m.a(this.f61b, eVar.f61b) && m.a(this.f62c, eVar.f62c) && m.a(this.f63d, eVar.f63d) && m.a(this.f64e, eVar.f64e) && m.a(this.f65f, eVar.f65f) && m.a(this.f66g, eVar.f66g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Integer num = this.f60a;
        int i10 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        int i11 = i4 * 31;
        String str = this.f61b;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        int i12 = (i11 + i5) * 31;
        Boolean bool = this.f62c;
        if (bool == null) {
            i6 = 0;
        } else {
            i6 = bool.hashCode();
        }
        int i13 = (i12 + i6) * 31;
        Boolean bool2 = this.f63d;
        if (bool2 == null) {
            i7 = 0;
        } else {
            i7 = bool2.hashCode();
        }
        int i14 = (i13 + i7) * 31;
        a aVar = this.f64e;
        if (aVar == null) {
            i8 = 0;
        } else {
            i8 = aVar.hashCode();
        }
        int i15 = (i14 + i8) * 31;
        List list = this.f65f;
        if (list == null) {
            i9 = 0;
        } else {
            i9 = list.hashCode();
        }
        int i16 = (i15 + i9) * 31;
        List list2 = this.f66g;
        if (list2 != null) {
            i10 = list2.hashCode();
        }
        return i16 + i10;
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("MSPAPurpose(id=");
        a5.append(this.f60a);
        a5.append(", category=");
        a5.append(this.f61b);
        a5.append(", defaultValue=");
        a5.append(this.f62c);
        a5.append(", value=");
        a5.append(this.f63d);
        a5.append(", consentBanner=");
        a5.append(this.f64e);
        a5.append(", purposes=");
        a5.append(this.f65f);
        a5.append(", applicableSensitivePurposes=");
        a5.append(this.f66g);
        a5.append(')');
        return a5.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Integer num, String str, Boolean bool, Boolean bool2, a aVar, List list, List list2, int i4) {
        this((i4 & 1) != 0 ? 0 : num, (i4 & 2) != 0 ? "" : null, (i4 & 4) != 0 ? Boolean.FALSE : bool, (i4 & 8) != 0 ? Boolean.FALSE : null, (i4 & 16) != 0 ? new a((String) null, (String) null, (String) null, (String) null, 15) : aVar, (i4 & 32) != 0 ? C1601o.h() : list, (i4 & 64) != 0 ? C1601o.h() : null);
    }
}
