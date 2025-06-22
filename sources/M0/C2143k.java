package m0;

import java.io.Serializable;
import java.util.Comparator;
import l0.h;

/* renamed from: m0.k  reason: case insensitive filesystem */
final class C2143k extends G implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final Comparator f21119a;

    C2143k(Comparator comparator) {
        this.f21119a = (Comparator) h.i(comparator);
    }

    public int compare(Object obj, Object obj2) {
        return this.f21119a.compare(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2143k) {
            return this.f21119a.equals(((C2143k) obj).f21119a);
        }
        return false;
    }

    public int hashCode() {
        return this.f21119a.hashCode();
    }

    public String toString() {
        return this.f21119a.toString();
    }
}
