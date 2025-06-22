package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class g0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator f5215a;

    public /* synthetic */ g0(Spliterator spliterator) {
        this.f5215a = spliterator;
    }

    public static /* synthetic */ i0 a(Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof h0 ? ((h0) spliterator).f5218a : spliterator instanceof Spliterator.OfPrimitive ? d0.a((Spliterator.OfPrimitive) spliterator) : new g0(spliterator);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5215a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator spliterator = this.f5215a;
        if (obj instanceof g0) {
            obj = ((g0) obj).f5215a;
        }
        return spliterator.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5215a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5215a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5215a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5215a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5215a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5215a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5215a.tryAdvance(consumer);
    }

    public final /* synthetic */ i0 trySplit() {
        return a(this.f5215a.trySplit());
    }
}
