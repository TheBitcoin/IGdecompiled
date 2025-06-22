package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class X implements Z {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfInt f5111a;

    public /* synthetic */ X(Spliterator.OfInt ofInt) {
        this.f5111a = ofInt;
    }

    public static /* synthetic */ Z a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof Y ? ((Y) ofInt).f5112a : new X(ofInt);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5111a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.f5111a;
        if (obj instanceof X) {
            obj = ((X) obj).f5111a;
        }
        return ofInt.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5111a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5111a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5111a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f5111a.forEachRemaining(intConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5111a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5111a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5111a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5111a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5111a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5111a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f5111a.tryAdvance(intConsumer);
    }
}
