package j$.util.stream;

import j$.time.format.a;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.k  reason: case insensitive filesystem */
public final class C1194k implements Collector {

    /* renamed from: a  reason: collision with root package name */
    public final Supplier f5525a;

    /* renamed from: b  reason: collision with root package name */
    public final BiConsumer f5526b;

    /* renamed from: c  reason: collision with root package name */
    public final BinaryOperator f5527c;

    /* renamed from: d  reason: collision with root package name */
    public final Function f5528d;

    /* renamed from: e  reason: collision with root package name */
    public final Set f5529e;

    public C1194k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
        this.f5525a = supplier;
        this.f5526b = biConsumer;
        this.f5527c = binaryOperator;
        this.f5528d = function;
        this.f5529e = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C1194k(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
        this(supplier, biConsumer, binaryOperator, new a(16), set);
        Set set2 = Collectors.f5263a;
    }

    public final BiConsumer accumulator() {
        return this.f5526b;
    }

    public final Supplier supplier() {
        return this.f5525a;
    }

    public final BinaryOperator combiner() {
        return this.f5527c;
    }

    public final Function finisher() {
        return this.f5528d;
    }

    public final Set characteristics() {
        return this.f5529e;
    }
}
