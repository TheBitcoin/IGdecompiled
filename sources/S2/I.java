package S2;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;

abstract class I {
    public static final Object a(Map map, Object obj) {
        m.e(map, "<this>");
        if (map instanceof G) {
            return ((G) map).g(obj);
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
