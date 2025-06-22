package q3;

import java.util.concurrent.CancellationException;
import o3.C0980h0;

abstract /* synthetic */ class m {
    public static final void a(u uVar, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = C0980h0.a("Channel was consumed, consumer had failed", th);
            }
        }
        uVar.a(cancellationException);
    }
}
