package G2;

import A2.a;
import java.util.List;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f6609a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f6610b;

    /* renamed from: c  reason: collision with root package name */
    public final List f6611c;

    public f(Boolean bool, Integer num, List list) {
        this.f6609a = bool;
        this.f6610b = num;
        this.f6611c = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (m.a(this.f6609a, fVar.f6609a) && m.a(this.f6610b, fVar.f6610b) && m.a(this.f6611c, fVar.f6611c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        Boolean bool = this.f6609a;
        int i6 = 0;
        if (bool == null) {
            i4 = 0;
        } else {
            i4 = bool.hashCode();
        }
        int i7 = i4 * 31;
        Integer num = this.f6610b;
        if (num == null) {
            i5 = 0;
        } else {
            i5 = num.hashCode();
        }
        int i8 = (i7 + i5) * 31;
        List list = this.f6611c;
        if (list != null) {
            i6 = list.hashCode();
        }
        return i8 + i6;
    }

    public String toString() {
        StringBuilder a5 = a.a("EncodingOptions(isForVendors=");
        a5.append(this.f6609a);
        a5.append(", version=");
        a5.append(this.f6610b);
        a5.append(", segments=");
        a5.append(this.f6611c);
        a5.append(')');
        return a5.toString();
    }
}
