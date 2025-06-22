package m0;

import java.util.Collection;
import java.util.Map;

/* renamed from: m0.d  reason: case insensitive filesystem */
abstract class C2136d implements C2127A {
    C2136d() {
    }

    public abstract Map a();

    public boolean b(Object obj) {
        for (Collection contains : a().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        return C2128B.a(this, obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
