package j$.util.stream;

import j$.util.C1127b;
import j$.util.h0;
import j$.util.stream.IntStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final /* synthetic */ class U2 implements Stream {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stream f5410a;

    public /* synthetic */ U2(Stream stream) {
        this.f5410a = stream;
    }

    public static /* synthetic */ Stream w(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof T2 ? ((T2) stream).f5406a : new U2(stream);
    }

    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f5410a.allMatch(predicate);
    }

    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f5410a.anyMatch(predicate);
    }

    public final /* synthetic */ void close() {
        this.f5410a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f5410a.collect(supplier, biConsumer, biConsumer2);
    }

    public final /* synthetic */ Object collect(Collector collector) {
        return this.f5410a.collect(collector == null ? null : collector instanceof C1189j ? ((C1189j) collector).f5520a : new C1184i(collector));
    }

    public final /* synthetic */ long count() {
        return this.f5410a.count();
    }

    public final /* synthetic */ Stream distinct() {
        return w(this.f5410a.distinct());
    }

    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return w(this.f5410a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Stream stream = this.f5410a;
        if (obj instanceof U2) {
            obj = ((U2) obj).f5410a;
        }
        return stream.equals(obj);
    }

    public final /* synthetic */ Stream filter(Predicate predicate) {
        return w(this.f5410a.filter(predicate));
    }

    public final /* synthetic */ Optional findAny() {
        return C1127b.o(this.f5410a.findAny());
    }

    public final /* synthetic */ Optional findFirst() {
        return C1127b.o(this.f5410a.findFirst());
    }

    public final /* synthetic */ Stream flatMap(Function function) {
        return w(this.f5410a.a(C1232t1.O(function)));
    }

    public final /* synthetic */ DoubleStream flatMapToDouble(Function function) {
        return B.w(this.f5410a.j(C1232t1.O(function)));
    }

    public final /* synthetic */ IntStream flatMapToInt(Function function) {
        return IntStream.Wrapper.convert(this.f5410a.m(C1232t1.O(function)));
    }

    public final /* synthetic */ LongStream flatMapToLong(Function function) {
        return C1190j0.w(this.f5410a.h(C1232t1.O(function)));
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f5410a.forEach(consumer);
    }

    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f5410a.forEachOrdered(consumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5410a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5410a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f5410a.iterator();
    }

    public final /* synthetic */ Stream limit(long j4) {
        return w(this.f5410a.limit(j4));
    }

    public final /* synthetic */ Stream map(Function function) {
        return w(this.f5410a.map(function));
    }

    public final /* synthetic */ DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
        return B.w(this.f5410a.mapToDouble(toDoubleFunction));
    }

    public final /* synthetic */ java.util.stream.IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.Wrapper.convert(this.f5410a.mapToInt(toIntFunction));
    }

    public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
        return C1190j0.w(this.f5410a.mapToLong(toLongFunction));
    }

    public final /* synthetic */ Optional max(Comparator comparator) {
        return C1127b.o(this.f5410a.max(comparator));
    }

    public final /* synthetic */ Optional min(Comparator comparator) {
        return C1127b.o(this.f5410a.min(comparator));
    }

    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f5410a.noneMatch(predicate);
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return C1169f.w(this.f5410a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return C1169f.w(this.f5410a.parallel());
    }

    public final /* synthetic */ Stream peek(Consumer consumer) {
        return w(this.f5410a.peek(consumer));
    }

    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f5410a.reduce(obj, biFunction, binaryOperator);
    }

    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f5410a.reduce(obj, binaryOperator);
    }

    public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
        return C1127b.o(this.f5410a.reduce(binaryOperator));
    }

    public final /* synthetic */ BaseStream sequential() {
        return C1169f.w(this.f5410a.sequential());
    }

    public final /* synthetic */ Stream skip(long j4) {
        return w(this.f5410a.skip(j4));
    }

    public final /* synthetic */ Stream sorted() {
        return w(this.f5410a.sorted());
    }

    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return w(this.f5410a.sorted(comparator));
    }

    public final /* synthetic */ Spliterator spliterator() {
        return h0.a(this.f5410a.spliterator());
    }

    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return w(this.f5410a.takeWhile(predicate));
    }

    public final /* synthetic */ Object[] toArray() {
        return this.f5410a.toArray();
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f5410a.toArray(intFunction);
    }

    public final /* synthetic */ BaseStream unordered() {
        return C1169f.w(this.f5410a.unordered());
    }
}
