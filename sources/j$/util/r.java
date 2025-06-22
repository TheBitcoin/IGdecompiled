package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

public final class r implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final i0 f5251a;

    public r(i0 i0Var) {
        this.f5251a = i0Var;
    }

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.f5251a.tryAdvance(new j$.time.format.r(1, consumer));
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.f5251a.forEachRemaining(new j$.time.format.r(1, consumer));
    }

    public final i0 trySplit() {
        i0 trySplit = this.f5251a.trySplit();
        if (trySplit == null) {
            return null;
        }
        return new r(trySplit);
    }

    public final long estimateSize() {
        return this.f5251a.estimateSize();
    }

    public final long getExactSizeIfKnown() {
        return this.f5251a.getExactSizeIfKnown();
    }

    public final int characteristics() {
        return this.f5251a.characteristics();
    }

    public final boolean hasCharacteristics(int i4) {
        return this.f5251a.hasCharacteristics(i4);
    }

    public final Comparator getComparator() {
        return this.f5251a.getComparator();
    }
}
