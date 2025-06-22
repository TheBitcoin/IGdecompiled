package j$.util.stream;

import j$.util.C;
import j$.util.C1127b;
import j$.util.C1262x;
import j$.util.D;
import j$.util.M;
import j$.util.Z;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface IntStream extends C1174g {
    C asDoubleStream();

    C1195k0 asLongStream();

    C average();

    IntStream b();

    Stream boxed();

    IntStream c();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    C d();

    IntStream distinct();

    boolean e();

    D findAny();

    D findFirst();

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    M iterator();

    C1195k0 k();

    IntStream limit(long j4);

    Stream mapToObj(IntFunction intFunction);

    D max();

    D min();

    boolean p();

    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    boolean r();

    int reduce(int i4, IntBinaryOperator intBinaryOperator);

    D reduce(IntBinaryOperator intBinaryOperator);

    IntStream sequential();

    IntStream skip(long j4);

    IntStream sorted();

    Z spliterator();

    int sum();

    C1262x summaryStatistics();

    int[] toArray();

    IntStream u(K k4);

    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        public /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).f5334a : new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.r();
        }

        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.p();
        }

        public final /* synthetic */ DoubleStream asDoubleStream() {
            return B.w(IntStream.this.asDoubleStream());
        }

        public final /* synthetic */ LongStream asLongStream() {
            return C1190j0.w(IntStream.this.asLongStream());
        }

        public final /* synthetic */ OptionalDouble average() {
            return C1127b.p(IntStream.this.average());
        }

        public final /* synthetic */ Stream boxed() {
            return U2.w(IntStream.this.boxed());
        }

        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.b());
        }

        public final /* synthetic */ OptionalInt findAny() {
            return C1127b.q(IntStream.this.findAny());
        }

        public final /* synthetic */ OptionalInt findFirst() {
            return C1127b.q(IntStream.this.findFirst());
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        public final /* synthetic */ java.util.stream.IntStream limit(long j4) {
            return convert(IntStream.this.limit(j4));
        }

        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.c());
        }

        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return B.w(IntStream.this.d());
        }

        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return C1190j0.w(IntStream.this.k());
        }

        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return U2.w(IntStream.this.mapToObj(intFunction));
        }

        public final /* synthetic */ OptionalInt max() {
            return C1127b.q(IntStream.this.max());
        }

        public final /* synthetic */ OptionalInt min() {
            return C1127b.q(IntStream.this.min());
        }

        public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.e();
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return C1169f.w(IntStream.this.onClose(runnable));
        }

        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.peek(intConsumer));
        }

        public final /* synthetic */ int reduce(int i4, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i4, intBinaryOperator);
        }

        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return C1127b.q(IntStream.this.reduce(intBinaryOperator));
        }

        public final /* synthetic */ java.util.stream.IntStream skip(long j4) {
            return convert(IntStream.this.skip(j4));
        }

        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        public final /* synthetic */ BaseStream unordered() {
            return C1169f.w(IntStream.this.unordered());
        }

        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.stream.K, java.lang.Object] */
        public final java.util.stream.IntStream flatMap(IntFunction intFunction) {
            IntStream intStream = IntStream.this;
            ? obj = new Object();
            obj.f5354a = intFunction;
            return convert(intStream.u(obj));
        }
    }

    public final /* synthetic */ class VivifiedWrapper implements IntStream, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ java.util.stream.IntStream f5334a;

        public /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.f5334a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        public final /* synthetic */ C asDoubleStream() {
            return A.w(this.f5334a.asDoubleStream());
        }

        public final /* synthetic */ C1195k0 asLongStream() {
            return C1185i0.w(this.f5334a.asLongStream());
        }

        public final /* synthetic */ C average() {
            return C1127b.l(this.f5334a.average());
        }

        public final /* synthetic */ IntStream b() {
            return convert(this.f5334a.filter((IntPredicate) null));
        }

        public final /* synthetic */ Stream boxed() {
            return T2.w(this.f5334a.boxed());
        }

        public final /* synthetic */ IntStream c() {
            return convert(this.f5334a.map((IntUnaryOperator) null));
        }

        public final /* synthetic */ void close() {
            this.f5334a.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.f5334a.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return this.f5334a.count();
        }

        public final /* synthetic */ C d() {
            return A.w(this.f5334a.mapToDouble((IntToDoubleFunction) null));
        }

        public final /* synthetic */ IntStream distinct() {
            return convert(this.f5334a.distinct());
        }

        public final /* synthetic */ boolean e() {
            return this.f5334a.noneMatch((IntPredicate) null);
        }

        public final /* synthetic */ boolean equals(Object obj) {
            java.util.stream.IntStream intStream = this.f5334a;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f5334a;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ D findAny() {
            return C1127b.m(this.f5334a.findAny());
        }

        public final /* synthetic */ D findFirst() {
            return C1127b.m(this.f5334a.findFirst());
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            this.f5334a.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            this.f5334a.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ int hashCode() {
            return this.f5334a.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return this.f5334a.isParallel();
        }

        public final /* synthetic */ C1195k0 k() {
            return C1185i0.w(this.f5334a.mapToLong((IntToLongFunction) null));
        }

        public final /* synthetic */ IntStream limit(long j4) {
            return convert(this.f5334a.limit(j4));
        }

        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return T2.w(this.f5334a.mapToObj(intFunction));
        }

        public final /* synthetic */ D max() {
            return C1127b.m(this.f5334a.max());
        }

        public final /* synthetic */ D min() {
            return C1127b.m(this.f5334a.min());
        }

        public final /* synthetic */ C1174g onClose(Runnable runnable) {
            return C1164e.w(this.f5334a.onClose(runnable));
        }

        public final /* synthetic */ boolean p() {
            return this.f5334a.anyMatch((IntPredicate) null);
        }

        public final /* synthetic */ IntStream peek(IntConsumer intConsumer) {
            return convert(this.f5334a.peek(intConsumer));
        }

        public final /* synthetic */ boolean r() {
            return this.f5334a.allMatch((IntPredicate) null);
        }

        public final /* synthetic */ int reduce(int i4, IntBinaryOperator intBinaryOperator) {
            return this.f5334a.reduce(i4, intBinaryOperator);
        }

        public final /* synthetic */ D reduce(IntBinaryOperator intBinaryOperator) {
            return C1127b.m(this.f5334a.reduce(intBinaryOperator));
        }

        public final /* synthetic */ IntStream skip(long j4) {
            return convert(this.f5334a.skip(j4));
        }

        public final /* synthetic */ IntStream sorted() {
            return convert(this.f5334a.sorted());
        }

        public final /* synthetic */ int sum() {
            return this.f5334a.sum();
        }

        public final /* synthetic */ int[] toArray() {
            return this.f5334a.toArray();
        }

        public final /* synthetic */ C1174g unordered() {
            return C1164e.w(this.f5334a.unordered());
        }

        public final C1262x summaryStatistics() {
            this.f5334a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [j$.util.stream.K, java.lang.Object, java.util.function.IntFunction] */
        public final IntStream u(K k4) {
            java.util.stream.IntStream intStream = this.f5334a;
            ? obj = new Object();
            obj.f5354a = k4;
            return convert(intStream.flatMap(obj));
        }
    }
}
