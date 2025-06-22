package j$.util.stream;

import j$.time.format.a;
import j$.time.format.r;
import j$.util.C;
import j$.util.C1261w;
import j$.util.F;
import j$.util.I;
import j$.util.Objects;
import j$.util.W;
import j$.util.i0;
import j$.util.m0;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.z  reason: case insensitive filesystem */
public abstract class C1254z extends C1144a implements C {
    public final C findAny() {
        return (C) z(E.f5275d);
    }

    public final C findFirst() {
        return (C) z(E.f5274c);
    }

    public final C sorted() {
        return new C1250y(this, W2.f5432q | W2.f5430o, 0);
    }

    public static W Q(i0 i0Var) {
        if (i0Var instanceof W) {
            return (W) i0Var;
        }
        if (E3.f5280a) {
            E3.a(C1144a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        z(new L(doubleConsumer, false));
    }

    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        z(new L(doubleConsumer, true));
    }

    public final X2 E() {
        return X2.DOUBLE_VALUE;
    }

    public final E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction) {
        return C1232t1.C(aVar, i0Var, z4);
    }

    public final i0 M(C1144a aVar, Supplier supplier, boolean z4) {
        return new Y2(aVar, supplier, z4);
    }

    public final boolean D(i0 i0Var, C1187i2 i2Var) {
        DoubleConsumer doubleConsumer;
        boolean m4;
        W Q4 = Q(i0Var);
        if (i2Var instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) i2Var;
        } else if (!E3.f5280a) {
            Objects.requireNonNull(i2Var);
            doubleConsumer = new F(i2Var, 1);
        } else {
            E3.a(C1144a.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        }
        do {
            m4 = i2Var.m();
            if (m4 || !Q4.tryAdvance(doubleConsumer)) {
                return m4;
            }
            m4 = i2Var.m();
            break;
        } while (!Q4.tryAdvance(doubleConsumer));
        return m4;
    }

    public final C1243w0 F(long j4, IntFunction intFunction) {
        return C1232t1.G(j4);
    }

    public final I iterator() {
        W spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new m0(spliterator);
    }

    public final W spliterator() {
        return Q(super.spliterator());
    }

    public final Stream boxed() {
        return new r(this, 0, new C1211o(1), 0);
    }

    public final C c() {
        Objects.requireNonNull(null);
        return new C1226s(this, W2.f5431p | W2.f5429n, 0);
    }

    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new r(this, W2.f5431p | W2.f5429n, doubleFunction, 0);
    }

    public final IntStream q() {
        Objects.requireNonNull(null);
        return new C1230t(this, W2.f5431p | W2.f5429n, 0);
    }

    public final C1195k0 g() {
        Objects.requireNonNull(null);
        return new C1234u(this, W2.f5431p | W2.f5429n, 0);
    }

    public final C a(r rVar) {
        Objects.requireNonNull(rVar);
        return new C1242w(this, W2.f5431p | W2.f5429n | W2.f5435t, rVar, 0);
    }

    public final C b() {
        Objects.requireNonNull(null);
        return new C1226s(this, W2.f5435t, 2);
    }

    public final C peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new C1242w(this, doubleConsumer);
    }

    public final C limit(long j4) {
        if (j4 >= 0) {
            return C1232t1.S(this, 0, j4);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final C skip(long j4) {
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if (i4 >= 0) {
            return i4 == 0 ? this : C1232t1.S(this, j4, -1);
        }
        throw new IllegalArgumentException(Long.toString(j4));
    }

    public final C distinct() {
        return ((C1147a2) boxed()).distinct().mapToDouble(new C1211o(2));
    }

    public final double sum() {
        double[] dArr = (double[]) collect(new C1211o(5), new C1211o(6), new a(24));
        Set set = Collectors.f5263a;
        double d5 = dArr[0] + dArr[1];
        double d6 = dArr[dArr.length - 1];
        return (!Double.isNaN(d5) || !Double.isInfinite(d6)) ? d5 : d6;
    }

    public final C min() {
        return reduce(new a(25));
    }

    public final C max() {
        return reduce(new C1211o(4));
    }

    public final C average() {
        double[] dArr = (double[]) collect(new a(26), new a(27), new a(28));
        if (dArr[2] <= 0.0d) {
            return C.f5087c;
        }
        Set set = Collectors.f5263a;
        double d5 = dArr[0] + dArr[1];
        double d6 = dArr[dArr.length - 1];
        if (Double.isNaN(d5) && Double.isInfinite(d6)) {
            d5 = d6;
        }
        return new C(d5 / dArr[2]);
    }

    public final C1261w summaryStatistics() {
        return (C1261w) collect(new a(10), new a(29), new C1211o(0));
    }

    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C1215p pVar = new C1215p(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(pVar);
        return z(new C1252y1(X2.DOUBLE_VALUE, pVar, objDoubleConsumer, supplier, 1));
    }

    public final boolean n() {
        return ((Boolean) z(C1232t1.R(C1223r0.ANY))).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) z(C1232t1.R(C1223r0.ALL))).booleanValue();
    }

    public final boolean v() {
        return ((Boolean) z(C1232t1.R(C1223r0.NONE))).booleanValue();
    }

    public final double[] toArray() {
        return (double[]) C1232t1.K((C1251y0) A(new C1211o(3))).d();
    }

    public final double reduce(double d5, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) z(new C1(X2.DOUBLE_VALUE, doubleBinaryOperator, d5))).doubleValue();
    }

    public final C reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (C) z(new C1244w1(X2.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }

    public final long count() {
        return ((Long) z(new A1(1))).longValue();
    }
}
