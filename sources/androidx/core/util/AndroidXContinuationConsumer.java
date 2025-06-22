package androidx.core.util;

import R2.m;
import V2.d;
import java.util.concurrent.atomic.AtomicBoolean;

final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final d continuation;

    public AndroidXContinuationConsumer(d dVar) {
        super(false);
        this.continuation = dVar;
    }

    public void accept(T t4) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(m.a(t4));
        }
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
