package j$.util.stream;

import j$.time.format.r;
import j$.util.C1132g;
import j$.util.Objects;
import j$.util.W;
import j$.util.Z;
import j$.util.c0;
import j$.util.concurrent.t;
import j$.util.i0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* renamed from: j$.util.stream.t1  reason: case insensitive filesystem */
public abstract class C1232t1 implements C3 {

    /* renamed from: a  reason: collision with root package name */
    public static final W0 f5601a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final U0 f5602b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static final V0 f5603c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final T0 f5604d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f5605e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    public static final long[] f5606f = new long[0];

    /* renamed from: g  reason: collision with root package name */
    public static final double[] f5607g = new double[0];

    public abstract O1 Z();

    public /* synthetic */ int d() {
        return 0;
    }

    public static r O(Function function) {
        r rVar = new r(7);
        rVar.f4970b = function;
        return rVar;
    }

    public static Set N(Set set) {
        C1179h hVar;
        Collector.Characteristics characteristics;
        if (set == null || set.isEmpty()) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Object next = set.iterator().next();
        if (next instanceof C1179h) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    C1179h hVar2 = (C1179h) it.next();
                    if (hVar2 == null) {
                        characteristics = null;
                    } else {
                        characteristics = hVar2 == C1179h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar2 == C1179h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH;
                    }
                    hashSet.add(characteristics);
                } catch (ClassCastException e5) {
                    C1132g.a("java.util.stream.Collector.Characteristics", e5);
                    throw null;
                }
            }
        } else if (next instanceof Collector.Characteristics) {
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                try {
                    Collector.Characteristics characteristics2 = (Collector.Characteristics) it2.next();
                    if (characteristics2 == null) {
                        hVar = null;
                    } else {
                        hVar = characteristics2 == Collector.Characteristics.CONCURRENT ? C1179h.CONCURRENT : characteristics2 == Collector.Characteristics.UNORDERED ? C1179h.UNORDERED : C1179h.IDENTITY_FINISH;
                    }
                    hashSet.add(hVar);
                } catch (ClassCastException e6) {
                    C1132g.a("java.util.stream.Collector.Characteristics", e6);
                    throw null;
                }
            }
        } else {
            C1132g.a("java.util.stream.Collector.Characteristics", next.getClass());
            throw null;
        }
        return hashSet;
    }

    public static long x(long j4, long j5, long j6) {
        if (j4 >= 0) {
            return Math.max(-1, Math.min(j4 - j5, j6));
        }
        return -1;
    }

    public static long A(long j4, long j5) {
        long j6 = j5 >= 0 ? j4 + j5 : Long.MAX_VALUE;
        if (j6 >= 0) {
            return j6;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [j$.util.stream.Y1, j$.util.stream.a] */
    public static Y1 a0(i0 i0Var, boolean z4) {
        Objects.requireNonNull(i0Var);
        return new C1144a(i0Var, W2.m(i0Var), z4);
    }

    public static i0 y(X2 x22, i0 i0Var, long j4, long j5) {
        long A4 = A(j4, j5);
        int i4 = C1225r2.f5581a[x22.ordinal()];
        if (i4 == 1) {
            return new q3(i0Var, j4, A4);
        }
        if (i4 == 2) {
            return new p3((Z) i0Var, j4, A4);
        }
        if (i4 == 3) {
            return new p3((c0) i0Var, j4, A4);
        }
        if (i4 == 4) {
            return new p3((W) i0Var, j4, A4);
        }
        throw new IllegalStateException("Unknown shape " + x22);
    }

    public static t X(C1223r0 r0Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(r0Var);
        return new t(X2.REFERENCE, r0Var, (Supplier) new t(5, (Object) r0Var, (Object) predicate));
    }

    public static X0 H(X2 x22) {
        int i4 = F0.f5283a[x22.ordinal()];
        if (i4 == 1) {
            return f5601a;
        }
        if (i4 == 2) {
            return f5602b;
        }
        if (i4 == 3) {
            return f5603c;
        }
        if (i4 == 4) {
            return f5604d;
        }
        throw new IllegalStateException("Unknown shape " + x22);
    }

    public static t T(C1223r0 r0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r0Var);
        return new t(X2.INT_VALUE, r0Var, (Supplier) new C1200l0(r0Var, 1));
    }

    public static C1197k2 Y(C1147a2 a2Var, long j4, long j5) {
        if (j4 >= 0) {
            return new C1197k2(a2Var, I(j5), j4, j5);
        }
        long j6 = j4;
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static E0 w(E0 e02, long j4, long j5, IntFunction intFunction) {
        if (j4 == 0 && j5 == e02.count()) {
            return e02;
        }
        i0 spliterator = e02.spliterator();
        long j6 = j5 - j4;
        C1243w0 z4 = z(j6, intFunction);
        z4.k(j6);
        for (int i4 = 0; ((long) i4) < j4 && spliterator.tryAdvance(new C1145a0(8)); i4++) {
        }
        if (j5 == e02.count()) {
            spliterator.forEachRemaining(z4);
        } else {
            for (int i5 = 0; ((long) i5) < j6 && spliterator.tryAdvance(z4); i5++) {
            }
        }
        z4.j();
        return z4.a();
    }

    public static G0 F(X2 x22, E0 e02, E0 e03) {
        int i4 = F0.f5283a[x22.ordinal()];
        if (i4 == 1) {
            return new G0(e02, e03);
        }
        if (i4 == 2) {
            return new G0((A0) e02, (A0) e03);
        }
        if (i4 == 3) {
            return new G0((C0) e02, (C0) e03);
        }
        if (i4 == 4) {
            return new G0((C1251y0) e02, (C1251y0) e03);
        }
        throw new IllegalStateException("Unknown shape " + x22);
    }

    public static t V(C1223r0 r0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r0Var);
        return new t(X2.LONG_VALUE, r0Var, (Supplier) new C1200l0(r0Var, 0));
    }

    public static void k() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static t R(C1223r0 r0Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r0Var);
        return new t(X2.DOUBLE_VALUE, r0Var, (Supplier) new C1200l0(r0Var, 2));
    }

    public static void l() {
        throw new IllegalStateException("called wrong accept method");
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [j$.util.stream.w0, j$.util.stream.S2] */
    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.H0, j$.util.stream.w0] */
    public static C1243w0 z(long j4, IntFunction intFunction) {
        if (j4 < 0 || j4 >= 2147483639) {
            return new S2();
        }
        return new H0(j4, intFunction);
    }

    public static void a() {
        throw new IllegalStateException("called wrong accept method");
    }

    public static void g(C1177g2 g2Var, Integer num) {
        if (!E3.f5280a) {
            g2Var.accept(num.intValue());
        } else {
            E3.a(g2Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
    }

    public static void i(C1182h2 h2Var, Long l4) {
        if (!E3.f5280a) {
            h2Var.accept(l4.longValue());
        } else {
            E3.a(h2Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [j$.util.stream.R2, j$.util.stream.u0] */
    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.Z0, j$.util.stream.u0] */
    public static C1235u0 P(long j4) {
        if (j4 < 0 || j4 >= 2147483639) {
            return new R2();
        }
        return new Z0(j4);
    }

    public static void e(C1172f2 f2Var, Double d5) {
        if (!E3.f5280a) {
            f2Var.accept(d5.doubleValue());
        } else {
            E3.a(f2Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
    }

    public static C1206m2 U(Z z4, long j4, long j5) {
        if (j4 >= 0) {
            return new C1206m2(z4, I(j5), j4, j5);
        }
        long j6 = j4;
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [j$.util.stream.R2, j$.util.stream.v0] */
    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.i1, j$.util.stream.v0] */
    public static C1239v0 Q(long j4) {
        if (j4 < 0 || j4 >= 2147483639) {
            return new R2();
        }
        return new C1186i1(j4);
    }

    public static Object[] m(D0 d02, IntFunction intFunction) {
        if (E3.f5280a) {
            E3.a(d02.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (d02.count() < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) d02.count());
            d02.h(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [j$.util.stream.R2, j$.util.stream.t0] */
    /* JADX WARNING: type inference failed for: r0v2, types: [j$.util.stream.Q0, j$.util.stream.t0] */
    public static C1231t0 G(long j4) {
        if (j4 < 0 || j4 >= 2147483639) {
            return new R2();
        }
        return new Q0(j4);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.function.LongFunction, j$.util.stream.K, java.lang.Object] */
    public static E0 B(C1144a aVar, i0 i0Var, boolean z4, IntFunction intFunction) {
        long C4 = aVar.C(i0Var);
        if (C4 < 0 || !i0Var.hasCharacteristics(16384)) {
            ? obj = new Object();
            obj.f5354a = intFunction;
            E0 e02 = (E0) new J0(aVar, i0Var, obj, new C1145a0(16), 3).invoke();
            return z4 ? J(e02, intFunction) : e02;
        } else if (C4 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) C4);
            new C1213o1(i0Var, aVar, objArr).invoke();
            return new H0(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void r(A0 a02, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            a02.e((IntConsumer) consumer);
        } else if (!E3.f5280a) {
            ((Z) a02.spliterator()).forEachRemaining(consumer);
        } else {
            E3.a(a02.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static C1214o2 W(C1180h0 h0Var, long j4, long j5) {
        if (j4 >= 0) {
            return new C1214o2(h0Var, I(j5), j4, j5);
        }
        long j6 = j4;
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static void o(A0 a02, Integer[] numArr, int i4) {
        if (!E3.f5280a) {
            int[] iArr = (int[]) a02.d();
            for (int i5 = 0; i5 < iArr.length; i5++) {
                numArr[i4 + i5] = Integer.valueOf(iArr[i5]);
            }
            return;
        }
        E3.a(a02.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
        throw null;
    }

    public static A0 u(A0 a02, long j4, long j5) {
        if (j4 == 0 && j5 == a02.count()) {
            return a02;
        }
        long j6 = j5 - j4;
        Z z4 = (Z) a02.spliterator();
        C1235u0 P4 = P(j6);
        P4.k(j6);
        for (int i4 = 0; ((long) i4) < j4 && z4.tryAdvance(new C1255z0(0)); i4++) {
        }
        if (j5 == a02.count()) {
            z4.forEachRemaining(P4);
        } else {
            for (int i5 = 0; ((long) i5) < j6 && z4.tryAdvance(P4); i5++) {
            }
        }
        P4.j();
        return P4.a();
    }

    public static A0 D(C1144a aVar, i0 i0Var, boolean z4) {
        long C4 = aVar.C(i0Var);
        if (C4 < 0 || !i0Var.hasCharacteristics(16384)) {
            A0 a02 = (A0) new J0(aVar, i0Var, new C1145a0(12), new C1145a0(13), 1).invoke();
            return z4 ? L(a02) : a02;
        } else if (C4 < 2147483639) {
            int[] iArr = new int[((int) C4)];
            new C1205m1(i0Var, aVar, iArr).invoke();
            return new Z0(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static C0 E(C1144a aVar, i0 i0Var, boolean z4) {
        long C4 = aVar.C(i0Var);
        if (C4 < 0 || !i0Var.hasCharacteristics(16384)) {
            C0 c02 = (C0) new J0(aVar, i0Var, new C1145a0(14), new C1145a0(15), 2).invoke();
            return z4 ? M(c02) : c02;
        } else if (C4 < 2147483639) {
            long[] jArr = new long[((int) C4)];
            new C1209n1(i0Var, aVar, jArr).invoke();
            return new C1186i1(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static void s(C0 c02, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            c02.e((LongConsumer) consumer);
        } else if (!E3.f5280a) {
            ((c0) c02.spliterator()).forEachRemaining(consumer);
        } else {
            E3.a(c02.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static void p(C0 c02, Long[] lArr, int i4) {
        if (!E3.f5280a) {
            long[] jArr = (long[]) c02.d();
            for (int i5 = 0; i5 < jArr.length; i5++) {
                lArr[i4 + i5] = Long.valueOf(jArr[i5]);
            }
            return;
        }
        E3.a(c02.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
        throw null;
    }

    public static C0 v(C0 c02, long j4, long j5) {
        if (j4 == 0 && j5 == c02.count()) {
            return c02;
        }
        long j6 = j5 - j4;
        c0 c0Var = (c0) c02.spliterator();
        C1239v0 Q4 = Q(j6);
        Q4.k(j6);
        for (int i4 = 0; ((long) i4) < j4 && c0Var.tryAdvance(new B0(0)); i4++) {
        }
        if (j5 == c02.count()) {
            c0Var.forEachRemaining(Q4);
        } else {
            for (int i5 = 0; ((long) i5) < j6 && c0Var.tryAdvance(Q4); i5++) {
            }
        }
        Q4.j();
        return Q4.a();
    }

    public static C1251y0 C(C1144a aVar, i0 i0Var, boolean z4) {
        long C4 = aVar.C(i0Var);
        if (C4 < 0 || !i0Var.hasCharacteristics(16384)) {
            C1251y0 y0Var = (C1251y0) new J0(aVar, i0Var, new C1145a0(10), new C1145a0(11), 0).invoke();
            return z4 ? K(y0Var) : y0Var;
        } else if (C4 < 2147483639) {
            double[] dArr = new double[((int) C4)];
            new C1201l1(i0Var, aVar, dArr).invoke();
            return new Q0(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static C1222q2 S(C1254z zVar, long j4, long j5) {
        if (j4 >= 0) {
            return new C1222q2(zVar, I(j5), j4, j5);
        }
        long j6 = j4;
        throw new IllegalArgumentException("Skip must be non-negative: " + j6);
    }

    public static E0 J(E0 e02, IntFunction intFunction) {
        if (e02.p() <= 0) {
            return e02;
        }
        long count = e02.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            new C1228s1(e02, (Object) objArr, 1).invoke();
            return new H0(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static void q(C1251y0 y0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            y0Var.e((DoubleConsumer) consumer);
        } else if (!E3.f5280a) {
            ((W) y0Var.spliterator()).forEachRemaining(consumer);
        } else {
            E3.a(y0Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    public static A0 L(A0 a02) {
        if (a02.p() <= 0) {
            return a02;
        }
        long count = a02.count();
        if (count < 2147483639) {
            int[] iArr = new int[((int) count)];
            new C1228s1((E0) a02, (Object) iArr, 0).invoke();
            return new Z0(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static void n(C1251y0 y0Var, Double[] dArr, int i4) {
        if (!E3.f5280a) {
            double[] dArr2 = (double[]) y0Var.d();
            for (int i5 = 0; i5 < dArr2.length; i5++) {
                dArr[i4 + i5] = Double.valueOf(dArr2[i5]);
            }
            return;
        }
        E3.a(y0Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
        throw null;
    }

    public static C1251y0 t(C1251y0 y0Var, long j4, long j5) {
        if (j4 == 0 && j5 == y0Var.count()) {
            return y0Var;
        }
        long j6 = j5 - j4;
        W w4 = (W) y0Var.spliterator();
        C1231t0 G4 = G(j6);
        G4.k(j6);
        for (int i4 = 0; ((long) i4) < j4 && w4.tryAdvance(new C1247x0(0)); i4++) {
        }
        if (j5 == y0Var.count()) {
            w4.forEachRemaining(G4);
        } else {
            for (int i5 = 0; ((long) i5) < j6 && w4.tryAdvance(G4); i5++) {
            }
        }
        G4.j();
        return G4.a();
    }

    public static C0 M(C0 c02) {
        if (c02.p() <= 0) {
            return c02;
        }
        long count = c02.count();
        if (count < 2147483639) {
            long[] jArr = new long[((int) count)];
            new C1228s1((E0) c02, (Object) jArr, 0).invoke();
            return new C1186i1(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public static int I(long j4) {
        return (j4 != -1 ? W2.f5436u : 0) | W2.f5435t;
    }

    public static C1251y0 K(C1251y0 y0Var) {
        if (y0Var.p() <= 0) {
            return y0Var;
        }
        long count = y0Var.count();
        if (count < 2147483639) {
            double[] dArr = new double[((int) count)];
            new C1228s1((E0) y0Var, (Object) dArr, 0).invoke();
            return new Q0(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public Object b(C1144a aVar, i0 i0Var) {
        O1 Z4 = Z();
        aVar.N(i0Var, Z4);
        return Z4.get();
    }

    public Object c(C1144a aVar, i0 i0Var) {
        return ((O1) new V1(this, aVar, i0Var).invoke()).get();
    }
}
