package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public final /* synthetic */ class e0 implements Spliterator.OfPrimitive {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f0 f5199a;

    public /* synthetic */ e0(f0 f0Var) {
        this.f5199a = f0Var;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(f0 f0Var) {
        if (f0Var == null) {
            return null;
        }
        return f0Var instanceof d0 ? ((d0) f0Var).f5195a : f0Var instanceof W ? V.a((W) f0Var) : f0Var instanceof Z ? Y.a((Z) f0Var) : f0Var instanceof c0 ? b0.a((c0) f0Var) : new e0(f0Var);
    }

    public final /* synthetic */ int characteristics() {
        return this.f5199a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        f0 f0Var = this.f5199a;
        if (obj instanceof e0) {
            obj = ((e0) obj).f5199a;
        }
        return f0Var.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.f5199a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5199a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5199a.forEachRemaining(consumer);
    }

    public final /* synthetic */ Comparator getComparator() {
        return this.f5199a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5199a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i4) {
        return this.f5199a.hasCharacteristics(i4);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5199a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5199a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5199a.tryAdvance(consumer);
    }
}
