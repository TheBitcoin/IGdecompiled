package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.stream.IntStream;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
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
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* renamed from: j$.util.stream.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C1190j0 implements LongStream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C1195k0 f5521a;

    public /* synthetic */ C1190j0(C1195k0 k0Var) {
        this.f5521a = k0Var;
    }

    public static /* synthetic */ LongStream w(C1195k0 k0Var) {
        if (k0Var == null) {
            return null;
        }
        return k0Var instanceof C1185i0 ? ((C1185i0) k0Var).f5515a : new C1190j0(k0Var);
    }

    public final /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.f5521a.o();
    }

    public final /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.f5521a.s();
    }

    public final /* synthetic */ DoubleStream asDoubleStream() {
        return B.w(this.f5521a.asDoubleStream());
    }

    public final /* synthetic */ OptionalDouble average() {
        return C1127b.p(this.f5521a.average());
    }

    public final /* synthetic */ Stream boxed() {
        return U2.w(this.f5521a.boxed());
    }

    public final /* synthetic */ void close() {
        this.f5521a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f5521a.collect(supplier, objLongConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.f5521a.count();
    }

    public final /* synthetic */ LongStream distinct() {
        return w(this.f5521a.distinct());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        C1195k0 k0Var = this.f5521a;
        if (obj instanceof C1190j0) {
            obj = ((C1190j0) obj).f5521a;
        }
        return k0Var.equals(obj);
    }

    public final /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return w(this.f5521a.b());
    }

    public final /* synthetic */ OptionalLong findAny() {
        return C1127b.r(this.f5521a.findAny());
    }

    public final /* synthetic */ OptionalLong findFirst() {
        return C1127b.r(this.f5521a.findFirst());
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f5521a.forEach(longConsumer);
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f5521a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5521a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5521a.isParallel();
    }

    public final /* synthetic */ LongStream limit(long j4) {
        return w(this.f5521a.limit(j4));
    }

    public final /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return w(this.f5521a.c());
    }

    public final /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return B.w(this.f5521a.i());
    }

    public final /* synthetic */ IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return IntStream.Wrapper.convert(this.f5521a.t());
    }

    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return U2.w(this.f5521a.mapToObj(longFunction));
    }

    public final /* synthetic */ OptionalLong max() {
        return C1127b.r(this.f5521a.max());
    }

    public final /* synthetic */ OptionalLong min() {
        return C1127b.r(this.f5521a.min());
    }

    public final /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.f5521a.l();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C1169f.w(this.f5521a.onClose(runnable));
    }

    public final /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return w(this.f5521a.peek(longConsumer));
    }

    public final /* synthetic */ long reduce(long j4, LongBinaryOperator longBinaryOperator) {
        return this.f5521a.reduce(j4, longBinaryOperator);
    }

    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return C1127b.r(this.f5521a.reduce(longBinaryOperator));
    }

    public final /* synthetic */ LongStream skip(long j4) {
        return w(this.f5521a.skip(j4));
    }

    public final /* synthetic */ LongStream sorted() {
        return w(this.f5521a.sorted());
    }

    public final /* synthetic */ long sum() {
        return this.f5521a.sum();
    }

    public final /* synthetic */ long[] toArray() {
        return this.f5521a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return C1169f.w(this.f5521a.unordered());
    }

    public final LongSummaryStatistics summaryStatistics() {
        this.f5521a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public final LongStream flatMap(LongFunction longFunction) {
        C1195k0 k0Var = this.f5521a;
        r rVar = new r(8);
        rVar.f4970b = longFunction;
        return w(k0Var.a(rVar));
    }
}
