package A0;

import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import v0.g;
import y0.C2420j;

/* renamed from: A0.d  reason: case insensitive filesystem */
class C1268d {

    /* renamed from: a  reason: collision with root package name */
    private final Map f5696a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int f5697b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5698c;

    public C1268d(int i4, int i5) {
        this.f5697b = i4;
        this.f5698c = i5;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f5698c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i4) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.length() > i4) {
            return trim.substring(0, i4);
        }
        return trim;
    }

    public synchronized Map a() {
        return DesugarCollections.unmodifiableMap(new HashMap(this.f5696a));
    }

    public synchronized boolean d(String str, String str2) {
        String b5 = b(str);
        if (this.f5696a.size() >= this.f5697b) {
            if (!this.f5696a.containsKey(b5)) {
                g f4 = g.f();
                f4.k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f5697b);
                return false;
            }
        }
        String c5 = c(str2, this.f5698c);
        if (C2420j.y((String) this.f5696a.get(b5), c5)) {
            return false;
        }
        Map map = this.f5696a;
        if (str2 == null) {
            c5 = "";
        }
        map.put(b5, c5);
        return true;
    }

    public synchronized void e(Map map) {
        String str;
        try {
            int i4 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String b5 = b((String) entry.getKey());
                if (this.f5696a.size() >= this.f5697b) {
                    if (!this.f5696a.containsKey(b5)) {
                        i4++;
                    }
                }
                String str2 = (String) entry.getValue();
                Map map2 = this.f5696a;
                if (str2 == null) {
                    str = "";
                } else {
                    str = c(str2, this.f5698c);
                }
                map2.put(b5, str);
            }
            if (i4 > 0) {
                g f4 = g.f();
                f4.k("Ignored " + i4 + " entries when adding custom keys. Maximum allowable: " + this.f5697b);
            }
        } finally {
            while (true) {
            }
        }
    }
}
