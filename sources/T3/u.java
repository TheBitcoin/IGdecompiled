package t3;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import l3.h;
import o3.E0;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f4526a;

    /* renamed from: b  reason: collision with root package name */
    public static final E0 f4527b;

    static {
        u uVar = new u();
        f4526a = uVar;
        G.f("kotlinx.coroutines.fast.service.loader", true);
        f4527b = uVar.a();
    }

    private u() {
    }

    private final E0 a() {
        Object obj;
        Class<t> cls = t.class;
        try {
            List o4 = h.o(h.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator it = o4.iterator();
            if (!it.hasNext()) {
                obj = null;
            } else {
                obj = it.next();
                if (it.hasNext()) {
                    int c5 = ((t) obj).c();
                    do {
                        Object next = it.next();
                        int c6 = ((t) next).c();
                        if (c5 < c6) {
                            obj = next;
                            c5 = c6;
                        }
                    } while (it.hasNext());
                }
            }
            t tVar = (t) obj;
            if (tVar != null) {
                E0 e5 = v.e(tVar, o4);
                if (e5 != null) {
                    return e5;
                }
            }
            v.b((Throwable) null, (String) null, 3, (Object) null);
            return null;
        } catch (Throwable th) {
            v.b(th, (String) null, 2, (Object) null);
            return null;
        }
    }
}
