package androidx.core.os;

import R2.m;
import R2.n;
import V2.d;
import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(31)
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final d continuation;

    public ContinuationOutcomeReceiver(d dVar) {
        super(false);
        this.continuation = dVar;
    }

    public void onError(E e5) {
        if (compareAndSet(false, true)) {
            d dVar = this.continuation;
            m.a aVar = m.f8216a;
            dVar.resumeWith(m.a(n.a(e5)));
        }
    }

    public void onResult(R r4) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(m.a(r4));
        }
    }

    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
