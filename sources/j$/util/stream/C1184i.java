package j$.util.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.i  reason: case insensitive filesystem */
public final /* synthetic */ class C1184i implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collector f5514a;

    public /* synthetic */ C1184i(Collector collector) {
        this.f5514a = collector;
    }

    public final /* synthetic */ BiConsumer accumulator() {
        return this.f5514a.accumulator();
    }

    public final /* synthetic */ Set characteristics() {
        return C1232t1.N(this.f5514a.characteristics());
    }

    public final /* synthetic */ BinaryOperator combiner() {
        return this.f5514a.combiner();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Collector collector = this.f5514a;
        if (obj instanceof C1184i) {
            obj = ((C1184i) obj).f5514a;
        }
        return collector.equals(obj);
    }

    public final /* synthetic */ Function finisher() {
        return this.f5514a.finisher();
    }

    public final /* synthetic */ int hashCode() {
        return this.f5514a.hashCode();
    }

    public final /* synthetic */ Supplier supplier() {
        return this.f5514a.supplier();
    }
}
