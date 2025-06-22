package j$.util.stream;

import j$.util.i0;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.f0  reason: case insensitive filesystem */
public final class C1170f0 extends C1180h0 {
    public final C1195k0 sequential() {
        this.f5458a.f5468k = false;
        return this;
    }

    public final C1195k0 parallel() {
        this.f5458a.f5468k = true;
        return this;
    }

    public final void forEach(LongConsumer longConsumer) {
        if (!this.f5458a.f5468k) {
            C1180h0.Q(L()).forEachRemaining(longConsumer);
        } else {
            super.forEach(longConsumer);
        }
    }

    public final void forEachOrdered(LongConsumer longConsumer) {
        if (!this.f5458a.f5468k) {
            C1180h0.Q(L()).forEachRemaining(longConsumer);
        } else {
            super.forEachOrdered(longConsumer);
        }
    }

    public final C1174g unordered() {
        if (!W2.ORDERED.n(this.f5463f)) {
            return this;
        }
        return new C1234u(this, W2.f5433r, 4);
    }

    public final /* bridge */ /* synthetic */ i0 spliterator() {
        return spliterator();
    }

    public final boolean I() {
        throw new UnsupportedOperationException();
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        throw new UnsupportedOperationException();
    }
}
