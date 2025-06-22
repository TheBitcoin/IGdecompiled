package m0;

import java.io.Serializable;
import l0.h;

/* renamed from: m0.D  reason: case insensitive filesystem */
final class C2130D extends G implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final C2130D f21051a = new C2130D();

    private C2130D() {
    }

    /* renamed from: f */
    public int compare(Comparable comparable, Comparable comparable2) {
        h.i(comparable);
        h.i(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
