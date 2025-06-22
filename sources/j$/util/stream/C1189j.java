package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.j  reason: case insensitive filesystem */
public final /* synthetic */ class C1189j implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f5520a;

    public /* synthetic */ C1189j(Collector collector) {
        this.f5520a = collector;
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return this.f5520a.accumulator();
    }

    public final /* synthetic */ Set characteristics() {
        return C1232t1.N(this.f5520a.characteristics());
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return this.f5520a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f5520a;
        if (obj instanceof C1189j) {
            obj = ((C1189j) obj).f5520a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return this.f5520a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5520a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return this.f5520a.supplier();
    }
}
