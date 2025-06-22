package j$.util.stream;

import java.util.function.Consumer;

public final class Y1 extends C1147a2 {
    public final void forEach(Consumer consumer) {
        if (!this.f5458a.f5468k) {
            L().forEachRemaining(consumer);
        } else {
            super.forEach(consumer);
        }
    }

    public final void forEachOrdered(Consumer consumer) {
        if (!this.f5458a.f5468k) {
            L().forEachRemaining(consumer);
        } else {
            super.forEachOrdered(consumer);
        }
    }

    public final C1174g unordered() {
        if (!W2.ORDERED.n(this.f5463f)) {
            return this;
        }
        return new Z1(this, W2.f5433r, 1);
    }

    public final boolean I() {
        throw new UnsupportedOperationException();
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        throw new UnsupportedOperationException();
    }
}
