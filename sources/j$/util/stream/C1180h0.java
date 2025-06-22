package j$.util.stream;

import j$.time.format.a;
import j$.time.format.r;
import j$.util.A;
import j$.util.C;
import j$.util.E;
import j$.util.N;
import j$.util.Objects;
import j$.util.Q;
import j$.util.c0;
import j$.util.i0;
import j$.util.l0;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.h0  reason: case insensitive filesystem */
public abstract class C1180h0 extends C1144a implements C1195k0 {
    public final E findAny() {
        return (E) z(G.f5293d);
    }

    public final E findFirst() {
        return (E) z(G.f5292c);
    }

    public final C1195k0 sorted() {
        return new C1175g0(this, W2.f5432q | W2.f5430o, 0);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        z(new N(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        z(new N(longConsumer, true));
    }

    public static c0 Q(i0 i0Var) {
        if (i0Var instanceof c0) {
            return (c0) i0Var;
        }
        if (E3.f5280a) {
            E3.a(C1144a.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    public final X2 E() {
        return X2.LONG_VALUE;
    }

    public final E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction) {
        return C1232t1.E(aVar, i0Var, z4);
    }

    public final i0 M(C1144a aVar, Supplier supplier, boolean z4) {
        return new Y2(aVar, supplier, z4);
    }

    public final boolean D(i0 i0Var, C1187i2 i2Var) {
        LongConsumer longConsumer;
        boolean m4;
        c0 Q4 = Q(i0Var);
        if (i2Var instanceof LongConsumer) {
            longConsumer = (LongConsumer) i2Var;
        } else if (!E3.f5280a) {
            Objects.requireNonNull(i2Var);
            longConsumer = new N(i2Var, 1);
        } else {
            E3.a(C1144a.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        }
        do {
            m4 = i2Var.m();
            if (m4 || !Q4.tryAdvance(longConsumer)) {
                return m4;
            }
            m4 = i2Var.m();
            break;
        } while (!Q4.tryAdvance(longConsumer));
        return m4;
    }

    public final C1243w0 F(long j4, IntFunction intFunction) {
        return C1232t1.Q(j4);
    }

    public final Q iterator() {
        c0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new l0(spliterator);
    }

    public final c0 spliterator() {
        return Q(super.spliterator());
    }

    public final C asDoubleStream() {
        return new C1226s(this, W2.f5429n, 5);
    }

    public final Stream boxed() {
        return new r(this, 0, new C1145a0(2), 2);
    }

    public final C1195k0 c() {
        Objects.requireNonNull(null);
        return new C1234u(this, W2.f5431p | W2.f5429n, 3);
    }

    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new r(this, W2.f5431p | W2.f5429n, longFunction, 2);
    }

    public final IntStream t() {
        Objects.requireNonNull(null);
        return new C1230t(this, W2.f5431p | W2.f5429n, 4);
    }

    public final C i() {
        Objects.requireNonNull(null);
        return new C1226s(this, W2.f5431p | W2.f5429n, 6);
    }

    public final C1195k0 a(r rVar) {
        Objects.requireNonNull(rVar);
        return new C1165e0(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 0);
    }

    public final C1195k0 b() {
        Objects.requireNonNull(null);
        return new C1234u(this, W2.f5435t, 5);
    }

    public final C1195k0 peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new C1165e0(this, longConsumer);
    }

    public final C1195k0 limit(long j4) {
        if (j4 >= 0) {
            return C1232t1.W(this, 0, j4);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final C1195k0 skip(long j4) {
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 >= 0) {
            return i4 == 0 ? this : C1232t1.W(this, j4, -1);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final C1195k0 distinct() {
        return ((C1147a2) boxed()).distinct().mapToLong(new C1211o(29));
    }

    public final long sum() {
        return reduce(0, new C1145a0(7));
    }

    public final E min() {
        return reduce(new C1211o(28));
    }

    public final E max() {
        return reduce(new C1145a0(6));
    }

    public final C average() {
        long[] jArr = (long[]) collect(new C1145a0(3), new C1145a0(4), new C1145a0(5));
        long j4 = jArr[0];
        return j4 > 0 ? new C(((double) jArr[1]) / ((double) j4)) : C.f5087c;
    }

    public final long reduce(long j4, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) z(new C1236u1(X2.LONG_VALUE, longBinaryOperator, j4))).longValue();
    }

    public final A summaryStatistics() {
        return (A) collect(new a(14), new C1211o(27), new C1145a0(0));
    }

    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C1215p pVar = new C1215p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return z(new C1252y1(X2.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    public final boolean s() {
        return ((Boolean) z(C1232t1.V(C1223r0.ANY))).booleanValue();
    }

    public final boolean o() {
        return ((Boolean) z(C1232t1.V(C1223r0.ALL))).booleanValue();
    }

    public final E reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (E) z(new C1244w1(X2.LONG_VALUE, longBinaryOperator, 0));
    }

    public final boolean l() {
        return ((Boolean) z(C1232t1.V(C1223r0.NONE))).booleanValue();
    }

    public final long[] toArray() {
        return (long[]) C1232t1.M((C0) A(new C1145a0(1))).d();
    }

    public final long count() {
        return ((Long) z(new A1(0))).longValue();
    }
}
