package androidx.core.util;

import R2.m;
import R2.s;
import V2.d;
import java.util.concurrent.atomic.AtomicBoolean;

final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final d continuation;

    public ContinuationRunnable(d dVar) {
        super(false);
        this.continuation = dVar;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            d dVar = this.continuation;
            m.a aVar = m.f8216a;
            dVar.resumeWith(m.a(s.f8222a));
        }
    }

    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
