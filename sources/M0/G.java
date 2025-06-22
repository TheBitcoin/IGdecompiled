package m0;

import java.util.Comparator;
import l0.c;

public abstract class G implements Comparator {
    protected G() {
    }

    public static G a(Comparator comparator) {
        if (comparator instanceof G) {
            return (G) comparator;
        }
        return new C2143k(comparator);
    }

    public static G c() {
        return C2130D.f21051a;
    }

    public C2147o b(Iterable iterable) {
        return C2147o.w(this, iterable);
    }

    public abstract int compare(Object obj, Object obj2);

    /* access modifiers changed from: package-private */
    public G d() {
        return e(z.b());
    }

    public G e(c cVar) {
        return new C2138f(cVar, this);
    }
}
