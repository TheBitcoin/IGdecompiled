package androidx.lifecycle.viewmodel.internal;

import V2.g;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o3.J;

public final class CloseableCoroutineScope implements AutoCloseable, J {
    private final g coroutineContext;

    public CloseableCoroutineScope(g gVar) {
        m.e(gVar, "coroutineContext");
        this.coroutineContext = gVar;
    }

    public void close() {
        C1013y0.d(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }

    public g getCoroutineContext() {
        return this.coroutineContext;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CloseableCoroutineScope(J j4) {
        this(j4.getCoroutineContext());
        m.e(j4, "coroutineScope");
    }
}
