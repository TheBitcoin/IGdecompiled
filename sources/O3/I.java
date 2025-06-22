package o3;

import R2.a;
import V2.g;
import t3.C1058h;

public abstract class I {
    public static final void a(g gVar, Throwable th) {
        try {
            H h4 = (H) gVar.get(H.f3655j0);
            if (h4 != null) {
                h4.r(gVar, th);
            } else {
                C1058h.a(gVar, th);
            }
        } catch (Throwable th2) {
            C1058h.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        a.a(runtimeException, th);
        return runtimeException;
    }
}
