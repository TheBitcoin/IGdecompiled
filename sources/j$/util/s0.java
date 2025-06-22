package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public final class s0 extends C1127b implements i0 {
    public final /* synthetic */ long getExactSizeIfKnown() {
        return C1127b.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return C1127b.e(this, i4);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return false;
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
    }
}
