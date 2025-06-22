package androidx.core.util;

import R2.m;
import V2.d;
import androidx.annotation.RequiresApi;
import j$.util.function.Consumer$CC;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

@RequiresApi(24)
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final d continuation;

    public ContinuationConsumer(d dVar) {
        super(false);
        this.continuation = dVar;
    }

    public void accept(T t4) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(m.a(t4));
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
