package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.C2103g;

public final class AtomicInt {
    private final AtomicInteger delegate;

    public AtomicInt(int i4) {
        this.delegate = new AtomicInteger(i4);
    }

    public final int decrementAndGet() {
        return this.delegate.decrementAndGet();
    }

    public final int get() {
        return this.delegate.get();
    }

    public final int getAndIncrement() {
        return this.delegate.getAndIncrement();
    }

    public final int incrementAndGet() {
        return this.delegate.incrementAndGet();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AtomicInt(int i4, int i5, C2103g gVar) {
        this((i5 & 1) != 0 ? 0 : i4);
    }
}
