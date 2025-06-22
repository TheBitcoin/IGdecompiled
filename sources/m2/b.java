package M2;

import A2.a;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f7741a;

    /* renamed from: b  reason: collision with root package name */
    public final a f7742b;

    public b(Integer num, a aVar) {
        this.f7741a = num;
        this.f7742b = aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (m.a(this.f7741a, bVar.f7741a) && m.a(this.f7742b, bVar.f7742b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Integer num = this.f7741a;
        int i5 = 0;
        if (num == null) {
            i4 = 0;
        } else {
            i4 = num.hashCode();
        }
        int i6 = i4 * 31;
        a aVar = this.f7742b;
        if (aVar != null) {
            i5 = aVar.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        StringBuilder a5 = a.a("GBCPurpose(id=");
        a5.append(this.f7741a);
        a5.append(", banner=");
        a5.append(this.f7742b);
        a5.append(')');
        return a5.toString();
    }
}
