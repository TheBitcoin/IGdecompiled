package S2;

import R2.l;
import T2.d;
import java.util.Collections;
import java.util.Map;
import kotlin.jvm.internal.m;

abstract class J extends I {
    public static Map b(Map map) {
        m.e(map, "builder");
        return ((d) map).l();
    }

    public static Map c() {
        return new d();
    }

    public static int d(int i4) {
        if (i4 < 0) {
            return i4;
        }
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((((float) i4) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map e(l lVar) {
        m.e(lVar, "pair");
        Map singletonMap = Collections.singletonMap(lVar.c(), lVar.d());
        m.d(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final Map f(Map map) {
        m.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        m.d(singletonMap, "with(...)");
        return singletonMap;
    }
}
