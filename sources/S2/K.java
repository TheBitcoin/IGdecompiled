package S2;

import R2.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;

abstract class K extends J {
    public static Map g() {
        B b5 = B.f8232a;
        m.c(b5, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return b5;
    }

    public static Object h(Map map, Object obj) {
        m.e(map, "<this>");
        return I.a(map, obj);
    }

    public static HashMap i(l... lVarArr) {
        m.e(lVarArr, "pairs");
        HashMap hashMap = new HashMap(J.d(lVarArr.length));
        o(hashMap, lVarArr);
        return hashMap;
    }

    public static Map j(l... lVarArr) {
        m.e(lVarArr, "pairs");
        if (lVarArr.length > 0) {
            return s(lVarArr, new LinkedHashMap(J.d(lVarArr.length)));
        }
        return g();
    }

    public static Map k(l... lVarArr) {
        m.e(lVarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(J.d(lVarArr.length));
        o(linkedHashMap, lVarArr);
        return linkedHashMap;
    }

    public static final Map l(Map map) {
        m.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return map;
        }
        return J.f(map);
    }

    public static Map m(Map map, l lVar) {
        m.e(map, "<this>");
        m.e(lVar, "pair");
        if (map.isEmpty()) {
            return J.e(lVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(lVar.c(), lVar.d());
        return linkedHashMap;
    }

    public static final void n(Map map, Iterable iterable) {
        m.e(map, "<this>");
        m.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            map.put(lVar.a(), lVar.b());
        }
    }

    public static final void o(Map map, l[] lVarArr) {
        m.e(map, "<this>");
        m.e(lVarArr, "pairs");
        for (l lVar : lVarArr) {
            map.put(lVar.a(), lVar.b());
        }
    }

    public static Map p(Iterable iterable) {
        Object next;
        m.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l(q(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return q(iterable, new LinkedHashMap(J.d(collection.size())));
        }
        if (iterable instanceof List) {
            next = ((List) iterable).get(0);
        } else {
            next = iterable.iterator().next();
        }
        return J.e((l) next);
    }

    public static final Map q(Iterable iterable, Map map) {
        m.e(iterable, "<this>");
        m.e(map, "destination");
        n(map, iterable);
        return map;
    }

    public static Map r(Map map) {
        m.e(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return g();
        }
        if (size != 1) {
            return t(map);
        }
        return J.f(map);
    }

    public static final Map s(l[] lVarArr, Map map) {
        m.e(lVarArr, "<this>");
        m.e(map, "destination");
        o(map, lVarArr);
        return map;
    }

    public static Map t(Map map) {
        m.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
