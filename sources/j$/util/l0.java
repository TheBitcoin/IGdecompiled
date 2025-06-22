package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final class l0 implements Q, LongConsumer, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5231a = false;

    /* renamed from: b  reason: collision with root package name */
    public long f5232b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f5233c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }

    public final Long next() {
        if (!z0.f5683a) {
            return Long.valueOf(nextLong());
        }
        z0.a(l0.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((LongConsumer) new N(consumer, 0));
            return;
        }
        z0.a(l0.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
        throw null;
    }

    public l0(c0 c0Var) {
        this.f5233c = c0Var;
    }

    public final void accept(long j4) {
        this.f5231a = true;
        this.f5232b = j4;
    }

    public final boolean hasNext() {
        if (!this.f5231a) {
            this.f5233c.tryAdvance(this);
        }
        return this.f5231a;
    }

    public final long nextLong() {
        if (this.f5231a || hasNext()) {
            this.f5231a = false;
            return this.f5232b;
        }
        throw new NoSuchElementException();
    }
}
