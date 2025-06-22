package j$.util.stream;

import j$.time.format.r;
import j$.util.A;
import j$.util.C;
import j$.util.C1127b;
import j$.util.E;
import j$.util.stream.IntStream;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;

/* renamed from: j$.util.stream.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C1185i0 implements C1195k0, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LongStream f5515a;

    public /* synthetic */ C1185i0(LongStream longStream) {
        this.f5515a = longStream;
    }

    public static /* synthetic */ C1195k0 w(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C1190j0 ? ((C1190j0) longStream).f5521a : new C1185i0(longStream);
    }

    public final /* synthetic */ C asDoubleStream() {
        return A.w(this.f5515a.asDoubleStream());
    }

    public final /* synthetic */ C average() {
        return C1127b.l(this.f5515a.average());
    }

    public final /* synthetic */ C1195k0 b() {
        return w(this.f5515a.filter((LongPredicate) null));
    }

    public final /* synthetic */ Stream boxed() {
        return T2.w(this.f5515a.boxed());
    }

    public final /* synthetic */ C1195k0 c() {
        return w(this.f5515a.map((LongUnaryOperator) null));
    }

    public final /* synthetic */ void close() {
        this.f5515a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f5515a.collect(supplier, objLongConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f5515a.count();
    }

    public final /* synthetic */ C1195k0 distinct() {
        return w(this.f5515a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.f5515a;
        if (obj instanceof C1185i0) {
            obj = ((C1185i0) obj).f5515a;
        }
        return longStream.equals(obj);
    }

    public final /* synthetic */ E findAny() {
        return C1127b.n(this.f5515a.findAny());
    }

    public final /* synthetic */ E findFirst() {
        return C1127b.n(this.f5515a.findFirst());
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f5515a.forEach(longConsumer);
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f5515a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5515a.hashCode();
    }

    public final /* synthetic */ C i() {
        return A.w(this.f5515a.mapToDouble((LongToDoubleFunction) null));
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5515a.isParallel();
    }

    public final /* synthetic */ boolean l() {
        return this.f5515a.noneMatch((LongPredicate) null);
    }

    public final /* synthetic */ C1195k0 limit(long j4) {
        return w(this.f5515a.limit(j4));
    }

    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return T2.w(this.f5515a.mapToObj(longFunction));
    }

    public final /* synthetic */ E max() {
        return C1127b.n(this.f5515a.max());
    }

    public final /* synthetic */ E min() {
        return C1127b.n(this.f5515a.min());
    }

    public final /* synthetic */ boolean o() {
        return this.f5515a.allMatch((LongPredicate) null);
    }

    public final /* synthetic */ C1174g onClose(Runnable runnable) {
        return C1164e.w(this.f5515a.onClose(runnable));
    }

    public final /* synthetic */ C1195k0 peek(LongConsumer longConsumer) {
        return w(this.f5515a.peek(longConsumer));
    }

    public final /* synthetic */ long reduce(long j4, LongBinaryOperator longBinaryOperator) {
        return this.f5515a.reduce(j4, longBinaryOperator);
    }

    public final /* synthetic */ E reduce(LongBinaryOperator longBinaryOperator) {
        return C1127b.n(this.f5515a.reduce(longBinaryOperator));
    }

    public final /* synthetic */ boolean s() {
        return this.f5515a.anyMatch((LongPredicate) null);
    }

    public final /* synthetic */ C1195k0 skip(long j4) {
        return w(this.f5515a.skip(j4));
    }

    public final /* synthetic */ C1195k0 sorted() {
        return w(this.f5515a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f5515a.sum();
    }

    public final /* synthetic */ IntStream t() {
        return IntStream.VivifiedWrapper.convert(this.f5515a.mapToInt((LongToIntFunction) null));
    }

    public final /* synthetic */ long[] toArray() {
        return this.f5515a.toArray();
    }

    public final /* synthetic */ C1174g unordered() {
        return C1164e.w(this.f5515a.unordered());
    }

    public final A summaryStatistics() {
        this.f5515a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    public final C1195k0 a(r rVar) {
        LongStream longStream = this.f5515a;
        r rVar2 = new r(8);
        rVar2.f4970b = rVar;
        return w(longStream.flatMap(rVar2));
    }
}
