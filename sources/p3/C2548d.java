package P3;

import java.util.HashMap;
import java.util.Map;

/* renamed from: P3.d  reason: case insensitive filesystem */
public class C2548d {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f23840a;

    public C2548d() {
        this.f23840a = new HashMap(14);
    }

    public synchronized String a(C2547c cVar) {
        return (String) this.f23840a.get(cVar.toString());
    }

    public synchronized boolean b(C2547c cVar) {
        return this.f23840a.containsKey(cVar.toString());
    }

    public synchronized C2548d c(C2547c cVar, String str) {
        d(cVar.toString(), str);
        return this;
    }

    public synchronized C2548d d(String str, String str2) {
        if (str2 == null) {
            try {
                this.f23840a.remove(str);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else if (str2.length() > 0) {
            this.f23840a.put(str, str2);
        }
        return this;
    }

    public synchronized Map e() {
        return new HashMap(this.f23840a);
    }

    public synchronized C2548d f(C2547c cVar, int i4) {
        return h(cVar, String.valueOf(i4));
    }

    public synchronized C2548d g(C2547c cVar, long j4) {
        return h(cVar, String.valueOf(j4));
    }

    public synchronized C2548d h(C2547c cVar, String str) {
        if (!b(cVar)) {
            c(cVar, str);
        }
        return this;
    }

    public C2548d(C2548d dVar) {
        HashMap hashMap = new HashMap(14);
        this.f23840a = hashMap;
        hashMap.putAll(dVar.f23840a);
    }
}
