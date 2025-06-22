package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class m0 implements I, DoubleConsumer, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5236a = false;

    /* renamed from: b  reason: collision with root package name */
    public double f5237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ W f5238c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        while (hasNext()) {
            doubleConsumer.accept(nextDouble());
        }
    }

    public final Double next() {
        if (!z0.f5683a) {
            return Double.valueOf(nextDouble());
        }
        z0.a(m0.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            forEachRemaining((DoubleConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((DoubleConsumer) new F(consumer, 0));
            return;
        }
        z0.a(m0.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
        throw null;
    }

    public m0(W w4) {
        this.f5238c = w4;
    }

    public final void accept(double d5) {
        this.f5236a = true;
        this.f5237b = d5;
    }

    public final boolean hasNext() {
        if (!this.f5236a) {
            this.f5238c.tryAdvance(this);
        }
        return this.f5236a;
    }

    public final double nextDouble() {
        if (this.f5236a || hasNext()) {
            this.f5236a = false;
            return this.f5237b;
        }
        throw new NoSuchElementException();
    }
}
