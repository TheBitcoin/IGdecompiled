package m0;

import java.util.Map;
import l0.c;

public abstract class z {

    private enum a implements c {
        KEY {
            /* renamed from: b */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        },
        VALUE {
            /* renamed from: b */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        };
    }

    static boolean a(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static c b() {
        return a.KEY;
    }

    static String c(Map map) {
        StringBuilder a5 = C2140h.a(map.size());
        a5.append('{');
        boolean z4 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z4) {
                a5.append(", ");
            }
            a5.append(entry.getKey());
            a5.append('=');
            a5.append(entry.getValue());
            z4 = false;
        }
        a5.append('}');
        return a5.toString();
    }

    static c d() {
        return a.VALUE;
    }
}
