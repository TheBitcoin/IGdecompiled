package S2;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.m;

abstract class P extends O {
    public static Set d() {
        return C.f8233a;
    }

    public static Set e(Object... objArr) {
        m.e(objArr, "elements");
        return (Set) C1598l.G(objArr, new LinkedHashSet(J.d(objArr.length)));
    }

    public static final Set f(Set set) {
        m.e(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return set;
        }
        return O.c(set.iterator().next());
    }

    public static Set g(Object... objArr) {
        m.e(objArr, "elements");
        return C1598l.N(objArr);
    }
}
