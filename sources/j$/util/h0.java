package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class h0 implements Spliterator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f5218a;

    public /* synthetic */ h0(i0 i0Var) {
        this.f5218a = i0Var;
    }

    public static /* synthetic */ Spliterator a(i0 i0Var) {
        if (i0Var == null) {
            return null;
        }
        return i0Var instanceof g0 ? ((g0) i0Var).f5215a : i0Var instanceof f0 ? e0.a((f0) i0Var) : new h0(i0Var);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5218a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        i0 i0Var = this.f5218a;
        if (obj instanceof h0) {
            obj = ((h0) obj).f5218a;
        }
        return i0Var.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5218a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5218a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5218a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5218a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5218a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5218a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5218a.tryAdvance(consumer);
    }

    public final /* synthetic */ Spliterator trySplit() {
        return a(this.f5218a.trySplit());
    }
}
