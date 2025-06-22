package j$.util.stream;

import j$.time.format.r;
import j$.util.B;
import j$.util.Objects;
import j$.util.concurrent.t;
import j$.util.function.a;
import j$.util.i0;
import j$.util.j0;
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

/* renamed from: j$.util.stream.a2  reason: case insensitive filesystem */
public abstract class C1147a2 extends C1144a implements Stream {
    public final Stream sorted() {
        return new D2(this);
    }

    public final Stream distinct() {
        return new Z1(this, W2.f5428m | W2.f5435t, 0);
    }

    public final B min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new a(comparator, 1));
    }

    public final B findAny() {
        return (B) z(H.f5307d);
    }

    public final B findFirst() {
        return (B) z(H.f5306c);
    }

    public final Stream sorted(Comparator comparator) {
        return new D2(this, comparator);
    }

    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return z(new C1252y1(X2.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return z(new C1252y1(X2.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        z(new O(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        z(new O(consumer, true));
    }

    public final B max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new a(comparator, 0));
    }

    public final X2 E() {
        return X2.REFERENCE;
    }

    public final B reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (B) z(new C1244w1(X2.REFERENCE, binaryOperator, 2));
    }

    public final E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction) {
        return C1232t1.B(aVar, i0Var, z4, intFunction);
    }

    public final i0 M(C1144a aVar, Supplier supplier, boolean z4) {
        return new Y2(aVar, supplier, z4);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final boolean D(j$.util.i0 r3, j$.util.stream.C1187i2 r4) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r4.m()
            if (r0 != 0) goto L_0x000c
            boolean r1 = r3.tryAdvance(r4)
            if (r1 != 0) goto L_0x0000
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C1147a2.D(j$.util.i0, j$.util.stream.i2):boolean");
    }

    public final C1243w0 F(long j4, IntFunction intFunction) {
        return C1232t1.z(j4, intFunction);
    }

    public final Iterator iterator() {
        i0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j0(spliterator);
    }

    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new r(this, W2.f5435t, predicate, 4);
    }

    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new r(this, W2.f5431p | W2.f5429n, function, 5);
    }

    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new U(this, W2.f5431p | W2.f5429n, toIntFunction, 2);
    }

    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return z(new C1252y1(X2.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }

    public final C1195k0 mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new C1165e0(this, W2.f5431p | W2.f5429n, toLongFunction, 3);
    }

    public final C mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new C1242w(this, W2.f5431p | W2.f5429n, toDoubleFunction, 2);
    }

    public final long count() {
        return ((Long) z(new A1(2))).longValue();
    }

    public final Stream a(r rVar) {
        Objects.requireNonNull(rVar);
        return new r(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 6);
    }

    public final IntStream m(r rVar) {
        Objects.requireNonNull(rVar);
        return new U(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 3);
    }

    public final C j(r rVar) {
        Objects.requireNonNull(rVar);
        return new C1242w(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 3);
    }

    public final Object collect(Collector collector) {
        Collector collector2;
        Object obj;
        if (!this.f5458a.f5468k || !collector.characteristics().contains(C1179h.CONCURRENT) || (W2.ORDERED.n(this.f5463f) && !collector.characteristics().contains(C1179h.UNORDERED))) {
            Supplier supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
            BiConsumer accumulator = collector.accumulator();
            collector2 = collector;
            obj = z(new F1(X2.REFERENCE, collector.combiner(), accumulator, supplier, collector2));
        } else {
            obj = collector.supplier().get();
            forEach(new t(7, (Object) collector.accumulator(), obj));
            collector2 = collector;
        }
        if (collector2.characteristics().contains(C1179h.IDENTITY_FINISH)) {
            return obj;
        }
        return collector2.finisher().apply(obj);
    }

    public final C1195k0 h(r rVar) {
        Objects.requireNonNull(rVar);
        return new C1165e0(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 2);
    }

    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new r(this, consumer);
    }

    public final Stream limit(long j4) {
        if (j4 >= 0) {
            return C1232t1.Y(this, 0, j4);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final Stream skip(long j4) {
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 >= 0) {
            return i4 == 0 ? this : C1232t1.Y(this, j4, -1);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final Stream takeWhile(Predicate predicate) {
        int i4 = K3.f5362a;
        Objects.requireNonNull(predicate);
        return new F3(this, K3.f5362a, predicate, 0);
    }

    public final Stream dropWhile(Predicate predicate) {
        int i4 = K3.f5362a;
        Objects.requireNonNull(predicate);
        return new F3(this, K3.f5363b, predicate, 1);
    }

    public final Object[] toArray(IntFunction intFunction) {
        return C1232t1.J(A(intFunction), intFunction).n(intFunction);
    }

    public final Object[] toArray() {
        return toArray(new C1145a0(17));
    }

    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) z(C1232t1.X(C1223r0.ANY, predicate))).booleanValue();
    }

    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) z(C1232t1.X(C1223r0.ALL, predicate))).booleanValue();
    }

    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) z(C1232t1.X(C1223r0.NONE, predicate))).booleanValue();
    }
}
