package j$.util.stream;

import j$.time.format.r;
import j$.util.C;
import j$.util.C1127b;
import j$.util.C1261w;
import j$.util.stream.IntStream;
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
import java.util.stream.DoubleStream;

public final /* synthetic */ class A implements C, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleStream f5252a;

    public /* synthetic */ A(DoubleStream doubleStream) {
        this.f5252a = doubleStream;
    }

    public static /* synthetic */ C w(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof B ? ((B) doubleStream).f5254a : new A(doubleStream);
    }

    public final /* synthetic */ C average() {
        return C1127b.l(this.f5252a.average());
    }

    public final /* synthetic */ C b() {
        return w(this.f5252a.filter((DoublePredicate) null));
    }

    public final /* synthetic */ Stream boxed() {
        return T2.w(this.f5252a.boxed());
    }

    public final /* synthetic */ C c() {
        return w(this.f5252a.map((DoubleUnaryOperator) null));
    }

    public final /* synthetic */ void close() {
        this.f5252a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f5252a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f5252a.count();
    }

    public final /* synthetic */ C distinct() {
        return w(this.f5252a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f5252a;
        if (obj instanceof A) {
            obj = ((A) obj).f5252a;
        }
        return doubleStream.equals(obj);
    }

    public final /* synthetic */ boolean f() {
        return this.f5252a.allMatch((DoublePredicate) null);
    }

    public final /* synthetic */ C findAny() {
        return C1127b.l(this.f5252a.findAny());
    }

    public final /* synthetic */ C findFirst() {
        return C1127b.l(this.f5252a.findFirst());
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f5252a.forEach(doubleConsumer);
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f5252a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ C1195k0 g() {
        return C1185i0.w(this.f5252a.mapToLong((DoubleToLongFunction) null));
    }

    public final /* synthetic */ int hashCode() {
        return this.f5252a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5252a.isParallel();
    }

    public final /* synthetic */ C limit(long j4) {
        return w(this.f5252a.limit(j4));
    }

    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return T2.w(this.f5252a.mapToObj(doubleFunction));
    }

    public final /* synthetic */ C max() {
        return C1127b.l(this.f5252a.max());
    }

    public final /* synthetic */ C min() {
        return C1127b.l(this.f5252a.min());
    }

    public final /* synthetic */ boolean n() {
        return this.f5252a.anyMatch((DoublePredicate) null);
    }

    public final /* synthetic */ C1174g onClose(Runnable runnable) {
        return C1164e.w(this.f5252a.onClose(runnable));
    }

    public final /* synthetic */ C peek(DoubleConsumer doubleConsumer) {
        return w(this.f5252a.peek(doubleConsumer));
    }

    public final /* synthetic */ IntStream q() {
        return IntStream.VivifiedWrapper.convert(this.f5252a.mapToInt((DoubleToIntFunction) null));
    }

    public final /* synthetic */ double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f5252a.reduce(d5, doubleBinaryOperator);
    }

    public final /* synthetic */ C reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return C1127b.l(this.f5252a.reduce(doubleBinaryOperator));
    }

    public final /* synthetic */ C skip(long j4) {
        return w(this.f5252a.skip(j4));
    }

    public final /* synthetic */ C sorted() {
        return w(this.f5252a.sorted());
    }

    public final /* synthetic */ double sum() {
        return this.f5252a.sum();
    }

    public final /* synthetic */ double[] toArray() {
        return this.f5252a.toArray();
    }

    public final /* synthetic */ C1174g unordered() {
        return C1164e.w(this.f5252a.unordered());
    }

    public final /* synthetic */ boolean v() {
        return this.f5252a.noneMatch((DoublePredicate) null);
    }

    public final C1261w summaryStatistics() {
        this.f5252a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    public final C a(r rVar) {
        DoubleStream doubleStream = this.f5252a;
        r rVar2 = new r(6);
        rVar2.f4970b = rVar;
        return w(doubleStream.flatMap(rVar2));
    }
}
