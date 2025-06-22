package S2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;

abstract class r extends C1603q {
    public static int p(Iterable iterable, int i4) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i4;
    }

    public static final Integer q(Iterable iterable) {
        m.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    public static List r(Iterable iterable) {
        m.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            v.u(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
