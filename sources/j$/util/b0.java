package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class b0 implements Spliterator.OfLong {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c0 f5117a;

    public /* synthetic */ b0(c0 c0Var) {
        this.f5117a = c0Var;
    }

    public static /* synthetic */ Spliterator.OfLong a(c0 c0Var) {
        if (c0Var == null) {
            return null;
        }
        return c0Var instanceof a0 ? ((a0) c0Var).f5116a : new b0(c0Var);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5117a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        c0 c0Var = this.f5117a;
        if (obj instanceof b0) {
            obj = ((b0) obj).f5117a;
        }
        return c0Var.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5117a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5117a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5117a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f5117a.forEachRemaining(longConsumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5117a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5117a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5117a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5117a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5117a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5117a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f5117a.tryAdvance(longConsumer);
    }
}
