package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class Y implements Spliterator.OfInt {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Z f5112a;

    public /* synthetic */ Y(Z z4) {
        this.f5112a = z4;
    }

    public static /* synthetic */ Spliterator.OfInt a(Z z4) {
        if (z4 == null) {
            return null;
        }
        return z4 instanceof X ? ((X) z4).f5111a : new Y(z4);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5112a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Z z4 = this.f5112a;
        if (obj instanceof Y) {
            obj = ((Y) obj).f5112a;
        }
        return z4.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5112a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5112a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5112a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f5112a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5112a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5112a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5112a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5112a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5112a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5112a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f5112a.tryAdvance(intConsumer);
    }
}
