package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class V implements Spliterator.OfDouble {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ W f5110a;

    public /* synthetic */ V(W w4) {
        this.f5110a = w4;
    }

    public static /* synthetic */ Spliterator.OfDouble a(W w4) {
        if (w4 == null) {
            return null;
        }
        return w4 instanceof U ? ((U) w4).f5109a : new V(w4);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5110a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        W w4 = this.f5110a;
        if (obj instanceof V) {
            obj = ((V) obj).f5110a;
        }
        return w4.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5110a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5110a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5110a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f5110a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5110a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5110a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5110a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5110a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5110a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5110a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f5110a.tryAdvance(doubleConsumer);
    }
}
