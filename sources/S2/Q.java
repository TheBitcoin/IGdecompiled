package S2;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.m;

abstract class Q extends P {
    public static Set h(Set set, Iterable iterable) {
        int i4;
        m.e(set, "<this>");
        m.e(iterable, "elements");
        Integer q4 = r.q(iterable);
        if (q4 != null) {
            i4 = set.size() + q4.intValue();
        } else {
            i4 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(J.d(i4));
        linkedHashSet.addAll(set);
        v.u(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
