package j$.util.stream;

import j$.util.i0;
import java.util.function.IntConsumer;

public final class X extends Z {
    public final IntStream sequential() {
        this.f5458a.f5468k = false;
        return this;
    }

    public final IntStream parallel() {
        this.f5458a.f5468k = true;
        return this;
    }

    public final void forEach(IntConsumer intConsumer) {
        if (!this.f5458a.f5468k) {
            Z.Q(L()).forEachRemaining(intConsumer);
        } else {
            super.forEach(intConsumer);
        }
    }

    public final void forEachOrdered(IntConsumer intConsumer) {
        if (!this.f5458a.f5468k) {
            Z.Q(L()).forEachRemaining(intConsumer);
        } else {
            super.forEachOrdered(intConsumer);
        }
    }

    public final C1174g unordered() {
        if (!W2.ORDERED.n(this.f5463f)) {
            return this;
        }
        return new C1230t(this, W2.f5433r, 2);
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
