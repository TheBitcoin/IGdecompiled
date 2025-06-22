package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class a0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfLong f5116a;

    public /* synthetic */ a0(Spliterator.OfLong ofLong) {
        this.f5116a = ofLong;
    }

    public static /* synthetic */ c0 a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof b0 ? ((b0) ofLong).f5117a : new a0(ofLong);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5116a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfLong ofLong = this.f5116a;
        if (obj instanceof a0) {
            obj = ((a0) obj).f5116a;
        }
        return ofLong.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5116a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5116a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5116a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f5116a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5116a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5116a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5116a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5116a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5116a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5116a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f5116a.tryAdvance(longConsumer);
    }
}
