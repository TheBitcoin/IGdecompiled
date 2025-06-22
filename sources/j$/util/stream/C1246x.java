package j$.util.stream;

import j$.util.i0;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.x  reason: case insensitive filesystem */
public final class C1246x extends C1254z {
    public final C sequential() {
        this.f5458a.f5468k = false;
        return this;
    }

    public final C parallel() {
        this.f5458a.f5468k = true;
        return this;
    }

    public final void forEach(DoubleConsumer doubleConsumer) {
        if (!this.f5458a.f5468k) {
            C1254z.Q(L()).forEachRemaining(doubleConsumer);
        } else {
            super.forEach(doubleConsumer);
        }
    }

    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (!this.f5458a.f5468k) {
            C1254z.Q(L()).forEachRemaining(doubleConsumer);
        } else {
            super.forEachOrdered(doubleConsumer);
        }
    }

    public final C1174g unordered() {
        if (!W2.ORDERED.n(this.f5463f)) {
            return this;
        }
        return new C1226s(this, W2.f5433r, 1);
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
