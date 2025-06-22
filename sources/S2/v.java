package S2;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;

abstract class v extends u {
    public static boolean u(Collection collection, Iterable iterable) {
        m.e(collection, "<this>");
        m.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z4 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z4 = true;
            }
        }
        return z4;
    }

    public static boolean v(Collection collection, Object[] objArr) {
        m.e(collection, "<this>");
        m.e(objArr, "elements");
        return collection.addAll(C1597k.c(objArr));
    }

    public static Object w(List list) {
        m.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object x(List list) {
        m.e(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(C1603q.j(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static Object y(List list) {
        m.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(C1603q.j(list));
    }
}
