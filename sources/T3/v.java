package t3;

import R2.d;
import java.util.List;
import o3.E0;

public abstract class v {
    private static final w a(Throwable th, String str) {
        if (th != null) {
            throw th;
        }
        d();
        throw new d();
    }

    static /* synthetic */ w b(Throwable th, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            th = null;
        }
        if ((i4 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(E0 e02) {
        return e02.D() instanceof w;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final E0 e(t tVar, List list) {
        try {
            return tVar.b(list);
        } catch (Throwable th) {
            return a(th, tVar.a());
        }
    }
}
