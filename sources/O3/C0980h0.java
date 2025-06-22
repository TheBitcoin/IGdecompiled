package o3;

import java.util.concurrent.CancellationException;

/* renamed from: o3.h0  reason: case insensitive filesystem */
public abstract class C0980h0 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
