package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.stream.IntStream;
import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class B implements DoubleStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f5254a;

    public /* synthetic */ B(C c5) {
        this.f5254a = c5;
    }

    public static /* synthetic */ DoubleStream w(C c5) {
        if (c5 == null) {
            return null;
        }
        return c5 instanceof A ? ((A) c5).f5252a : new B(c5);
    }

    public final /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.f5254a.f();
    }

    public final /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.f5254a.n();
    }

    public final /* synthetic */ OptionalDouble average() {
        return C1127b.p(this.f5254a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return U2.w(this.f5254a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f5254a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f5254a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f5254a.count();
    }

    public final /* synthetic */ DoubleStream distinct() {
        return w(this.f5254a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C c5 = this.f5254a;
        if (obj instanceof B) {
            obj = ((B) obj).f5254a;
        }
        return c5.equals(obj);
    }

    public final /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return w(this.f5254a.b());
    }

    public final /* synthetic */ OptionalDouble findAny() {
        return C1127b.p(this.f5254a.findAny());
    }

    public final /* synthetic */ OptionalDouble findFirst() {
        return C1127b.p(this.f5254a.findFirst());
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f5254a.forEach(doubleConsumer);
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f5254a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5254a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5254a.isParallel();
    }

    public final /* synthetic */ DoubleStream limit(long j4) {
        return w(this.f5254a.limit(j4));
    }

    public final /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return w(this.f5254a.c());
    }

    public final /* synthetic */ IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return IntStream.Wrapper.convert(this.f5254a.q());
    }

    public final /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return C1190j0.w(this.f5254a.g());
    }

    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return U2.w(this.f5254a.mapToObj(doubleFunction));
    }

    public final /* synthetic */ OptionalDouble max() {
        return C1127b.p(this.f5254a.max());
    }

    public final /* synthetic */ OptionalDouble min() {
        return C1127b.p(this.f5254a.min());
    }

    public final /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.f5254a.v();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C1169f.w(this.f5254a.onClose(runnable));
    }

    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return w(this.f5254a.peek(doubleConsumer));
    }

    public final /* synthetic */ double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f5254a.reduce(d5, doubleBinaryOperator);
    }

    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return C1127b.p(this.f5254a.reduce(doubleBinaryOperator));
    }

    public final /* synthetic */ DoubleStream skip(long j4) {
        return w(this.f5254a.skip(j4));
    }

    public final /* synthetic */ DoubleStream sorted() {
        return w(this.f5254a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f5254a.sum();
    }

    public final /* synthetic */ double[] toArray() {
        return this.f5254a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C1169f.w(this.f5254a.unordered());
    }

    public final DoubleSummaryStatistics summaryStatistics() {
        this.f5254a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public final DoubleStream flatMap(DoubleFunction doubleFunction) {
        C c5 = this.f5254a;
        r rVar = new r(6);
        rVar.f4970b = doubleFunction;
        return w(c5.a(rVar));
    }
}
