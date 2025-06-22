package j$.util.stream;

import j$.time.format.r;
import j$.util.B;
import j$.util.C1127b;
import j$.util.g0;
import j$.util.i0;
import j$.util.stream.IntStream;
import java.util.Comparator;
import java.util.Iterator;
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
import java.util.stream.Stream;

public final /* synthetic */ class T2 implements Stream, AutoCloseable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Stream f5406a;

    public /* synthetic */ T2(Stream stream) {
        this.f5406a = stream;
    }

    public static /* synthetic */ Stream w(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof U2 ? ((U2) stream).f5410a : new T2(stream);
    }

    public final /* synthetic */ Stream a(r rVar) {
        return w(this.f5406a.flatMap(C1232t1.O(rVar)));
    }

    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f5406a.allMatch(predicate);
    }

    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f5406a.anyMatch(predicate);
    }

    public final /* synthetic */ void close() {
        this.f5406a.close();
    }

    public final /* synthetic */ Object collect(Collector collector) {
        return this.f5406a.collect(collector == null ? null : collector instanceof C1184i ? ((C1184i) collector).f5514a : new C1189j(collector));
    }

    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f5406a.collect(supplier, biConsumer, biConsumer2);
    }

    public final /* synthetic */ long count() {
        return this.f5406a.count();
    }

    public final /* synthetic */ Stream distinct() {
        return w(this.f5406a.distinct());
    }

    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return w(this.f5406a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Stream stream = this.f5406a;
        if (obj instanceof T2) {
            obj = ((T2) obj).f5406a;
        }
        return stream.equals(obj);
    }

    public final /* synthetic */ Stream filter(Predicate predicate) {
        return w(this.f5406a.filter(predicate));
    }

    public final /* synthetic */ B findAny() {
        return C1127b.k(this.f5406a.findAny());
    }

    public final /* synthetic */ B findFirst() {
        return C1127b.k(this.f5406a.findFirst());
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f5406a.forEach(consumer);
    }

    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f5406a.forEachOrdered(consumer);
    }

    public final /* synthetic */ C1195k0 h(r rVar) {
        return C1185i0.w(this.f5406a.flatMapToLong(C1232t1.O(rVar)));
    }

    public final /* synthetic */ int hashCode() {
        return this.f5406a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.f5406a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.f5406a.iterator();
    }

    public final /* synthetic */ C j(r rVar) {
        return A.w(this.f5406a.flatMapToDouble(C1232t1.O(rVar)));
    }

    public final /* synthetic */ Stream limit(long j4) {
        return w(this.f5406a.limit(j4));
    }

    public final /* synthetic */ IntStream m(r rVar) {
        return IntStream.VivifiedWrapper.convert(this.f5406a.flatMapToInt(C1232t1.O(rVar)));
    }

    public final /* synthetic */ Stream map(Function function) {
        return w(this.f5406a.map(function));
    }

    public final /* synthetic */ C mapToDouble(ToDoubleFunction toDoubleFunction) {
        return A.w(this.f5406a.mapToDouble(toDoubleFunction));
    }

    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f5406a.mapToInt(toIntFunction));
    }

    public final /* synthetic */ C1195k0 mapToLong(ToLongFunction toLongFunction) {
        return C1185i0.w(this.f5406a.mapToLong(toLongFunction));
    }

    public final /* synthetic */ B max(Comparator comparator) {
        return C1127b.k(this.f5406a.max(comparator));
    }

    public final /* synthetic */ B min(Comparator comparator) {
        return C1127b.k(this.f5406a.min(comparator));
    }

    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f5406a.noneMatch(predicate);
    }

    public final /* synthetic */ C1174g onClose(Runnable runnable) {
        return C1164e.w(this.f5406a.onClose(runnable));
    }

    public final /* synthetic */ C1174g parallel() {
        return C1164e.w(this.f5406a.parallel());
    }

    public final /* synthetic */ Stream peek(Consumer consumer) {
        return w(this.f5406a.peek(consumer));
    }

    public final /* synthetic */ B reduce(BinaryOperator binaryOperator) {
        return C1127b.k(this.f5406a.reduce(binaryOperator));
    }

    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f5406a.reduce(obj, biFunction, binaryOperator);
    }

    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f5406a.reduce(obj, binaryOperator);
    }

    public final /* synthetic */ C1174g sequential() {
        return C1164e.w(this.f5406a.sequential());
    }

    public final /* synthetic */ Stream skip(long j4) {
        return w(this.f5406a.skip(j4));
    }

    public final /* synthetic */ Stream sorted() {
        return w(this.f5406a.sorted());
    }

    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return w(this.f5406a.sorted(comparator));
    }

    public final /* synthetic */ i0 spliterator() {
        return g0.a(this.f5406a.spliterator());
    }

    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return w(this.f5406a.takeWhile(predicate));
    }

    public final /* synthetic */ Object[] toArray() {
        return this.f5406a.toArray();
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f5406a.toArray(intFunction);
    }

    public final /* synthetic */ C1174g unordered() {
        return C1164e.w(this.f5406a.unordered());
    }
}
