package b3;

import R2.a;
import java.io.Closeable;

/* renamed from: b3.b  reason: case insensitive filesystem */
public abstract class C1642b {
    public static final void a(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            a.a(th, th2);
        }
    }
}
