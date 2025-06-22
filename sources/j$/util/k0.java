package j$.util;

import j$.com.android.tools.r8.a;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final class k0 implements M, IntConsumer, C1263y {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5228a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f5229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Z f5230c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        while (hasNext()) {
            intConsumer.accept(nextInt());
        }
    }

    public final Integer next() {
        if (!z0.f5683a) {
            return Integer.valueOf(nextInt());
        }
        z0.a(k0.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
        throw null;
    }

    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            forEachRemaining((IntConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (!z0.f5683a) {
            Objects.requireNonNull(consumer);
            forEachRemaining((IntConsumer) new J(consumer, 0));
            return;
        }
        z0.a(k0.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
        throw null;
    }

    public k0(Z z4) {
        this.f5230c = z4;
    }

    public final void accept(int i4) {
        this.f5228a = true;
        this.f5229b = i4;
    }

    public final boolean hasNext() {
        if (!this.f5228a) {
            this.f5230c.tryAdvance(this);
        }
        return this.f5228a;
    }

    public final int nextInt() {
        if (this.f5228a || hasNext()) {
            this.f5228a = false;
            return this.f5229b;
        }
        throw new NoSuchElementException();
    }
}
