package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class U implements W {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfDouble f5109a;

    public /* synthetic */ U(Spliterator.OfDouble ofDouble) {
        this.f5109a = ofDouble;
    }

    public static /* synthetic */ W a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof V ? ((V) ofDouble).f5110a : new U(ofDouble);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5109a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.f5109a;
        if (obj instanceof U) {
            obj = ((U) obj).f5109a;
        }
        return ofDouble.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5109a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5109a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5109a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f5109a.forEachRemaining(doubleConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5109a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5109a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5109a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5109a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5109a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5109a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f5109a.tryAdvance(doubleConsumer);
    }
}
