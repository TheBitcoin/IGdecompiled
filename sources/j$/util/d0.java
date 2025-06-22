package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class d0 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfPrimitive f5195a;

    public /* synthetic */ d0(Spliterator.OfPrimitive ofPrimitive) {
        this.f5195a = ofPrimitive;
    }

    public static /* synthetic */ f0 a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof e0 ? ((e0) ofPrimitive).f5199a : ofPrimitive instanceof Spliterator.OfDouble ? U.a((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? X.a((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? a0.a((Spliterator.OfLong) ofPrimitive) : new d0(ofPrimitive);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5195a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfPrimitive ofPrimitive = this.f5195a;
        if (obj instanceof d0) {
            obj = ((d0) obj).f5195a;
        }
        return ofPrimitive.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5195a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5195a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5195a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5195a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5195a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5195a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5195a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5195a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5195a.tryAdvance(consumer);
    }
}
