package j$.util.stream;

import j$.time.format.a;
import j$.util.C;
import j$.util.C1262x;
import j$.util.D;
import j$.util.J;
import j$.util.M;
import j$.util.Objects;
import j$.util.i0;
import j$.util.k0;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public abstract class Z extends C1144a implements IntStream {
    public final D findAny() {
        return (D) z(F.f5282d);
    }

    public final D findFirst() {
        return (D) z(F.f5281c);
    }

    public final IntStream sorted() {
        return new Y(this, W2.f5432q | W2.f5430o, 0);
    }

    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        z(new M(intConsumer, false));
    }

    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        z(new M(intConsumer, true));
    }

    public static j$.util.Z Q(i0 i0Var) {
        if (i0Var instanceof j$.util.Z) {
            return (j$.util.Z) i0Var;
        }
        if (E3.f5280a) {
            E3.a(C1144a.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    public final X2 E() {
        return X2.INT_VALUE;
    }

    public final E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction) {
        return C1232t1.D(aVar, i0Var, z4);
    }

    public final i0 M(C1144a aVar, Supplier supplier, boolean z4) {
        return new Y2(aVar, supplier, z4);
    }

    public final boolean D(i0 i0Var, C1187i2 i2Var) {
        IntConsumer intConsumer;
        boolean m4;
        j$.util.Z Q4 = Q(i0Var);
        if (i2Var instanceof IntConsumer) {
            intConsumer = (IntConsumer) i2Var;
        } else if (!E3.f5280a) {
            Objects.requireNonNull(i2Var);
            intConsumer = new J(i2Var, 1);
        } else {
            E3.a(C1144a.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        }
        do {
            m4 = i2Var.m();
            if (m4 || !Q4.tryAdvance(intConsumer)) {
                return m4;
            }
            m4 = i2Var.m();
            break;
        } while (!Q4.tryAdvance(intConsumer));
        return m4;
    }

    public final C1243w0 F(long j4, IntFunction intFunction) {
        return C1232t1.P(j4);
    }

    public final M iterator() {
        j$.util.Z spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new k0(spliterator);
    }

    public final j$.util.Z spliterator() {
        return Q(super.spliterator());
    }

    public final C1195k0 asLongStream() {
        return new C1234u(this, 0, 1);
    }

    public final C asDoubleStream() {
        return new C1226s(this, 0, 3);
    }

    public final Stream boxed() {
        return new r(this, 0, new C1211o(18), 1);
    }

    public final IntStream c() {
        Objects.requireNonNull(null);
        return new C1230t(this, W2.f5431p | W2.f5429n, 1);
    }

    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new r(this, W2.f5431p | W2.f5429n, intFunction, 1);
    }

    public final C1195k0 k() {
        Objects.requireNonNull(null);
        return new C1234u(this, W2.f5431p | W2.f5429n, 2);
    }

    public final C d() {
        Objects.requireNonNull(null);
        return new C1226s(this, W2.f5431p | W2.f5429n, 4);
    }

    public final int reduce(int i4, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) z(new J1(X2.INT_VALUE, intBinaryOperator, i4))).intValue();
    }

    public final IntStream u(K k4) {
        Objects.requireNonNull(k4);
        return new U(this, W2.f5431p | W2.f5429n | W2.f5435t, k4, 1);
    }

    public final D reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (D) z(new C1244w1(X2.INT_VALUE, intBinaryOperator, 3));
    }

    public final IntStream b() {
        Objects.requireNonNull(null);
        return new C1230t(this, W2.f5435t, 3);
    }

    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new U(this, intConsumer);
    }

    public final IntStream limit(long j4) {
        if (j4 >= 0) {
            return C1232t1.U(this, 0, j4);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final IntStream skip(long j4) {
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 >= 0) {
            return i4 == 0 ? this : C1232t1.U(this, j4, -1);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final long count() {
        return ((Long) z(new A1(3))).longValue();
    }

    public final IntStream distinct() {
        return ((C1147a2) boxed()).distinct().mapToInt(new C1211o(17));
    }

    public final int sum() {
        return reduce(0, new C1211o(22));
    }

    public final D min() {
        return reduce(new C1211o(19));
    }

    public final D max() {
        return reduce(new C1211o(23));
    }

    public final C average() {
        long[] jArr = (long[]) collect(new C1211o(24), new C1211o(25), new C1211o(26));
        long j4 = jArr[0];
        return j4 > 0 ? new C(((double) jArr[1]) / ((double) j4)) : C.f5087c;
    }

    public final C1262x summaryStatistics() {
        return (C1262x) collect(new a(13), new C1211o(20), new C1211o(21));
    }

    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C1215p pVar = new C1215p(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(pVar);
        return z(new C1252y1(X2.INT_VALUE, pVar, objIntConsumer, supplier, 4));
    }

    public final boolean p() {
        return ((Boolean) z(C1232t1.T(C1223r0.ANY))).booleanValue();
    }

    public final boolean r() {
        return ((Boolean) z(C1232t1.T(C1223r0.ALL))).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) z(C1232t1.T(C1223r0.NONE))).booleanValue();
    }

    public final int[] toArray() {
        return (int[]) C1232t1.L((A0) A(new C1211o(16))).d();
    }
}
