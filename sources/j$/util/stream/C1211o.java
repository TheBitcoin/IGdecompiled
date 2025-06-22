package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.A;
import j$.util.B;
import j$.util.C;
import j$.util.C1261w;
import j$.util.C1262x;
import j$.util.D;
import j$.util.E;
import j$.util.function.Predicate$CC;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* renamed from: j$.util.stream.o  reason: case insensitive filesystem */
public final /* synthetic */ class C1211o implements BiConsumer, DoubleFunction, ToDoubleFunction, IntFunction, DoubleBinaryOperator, Supplier, ObjDoubleConsumer, Predicate, ToIntFunction, IntBinaryOperator, ObjIntConsumer, ObjLongConsumer, LongBinaryOperator, ToLongFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5554a;

    public /* synthetic */ C1211o(int i4) {
        this.f5554a = i4;
    }

    public void accept(Object obj, long j4) {
        ((A) obj).accept(j4);
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        switch (this.f5554a) {
            case 7:
                return Predicate$CC.$default$and(this, predicate);
            case 9:
                return Predicate$CC.$default$and(this, predicate);
            case 11:
                return Predicate$CC.$default$and(this, predicate);
            default:
                return Predicate$CC.$default$and(this, predicate);
        }
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f5554a) {
            case 0:
                return a.b(this, biConsumer);
            case 21:
                return a.b(this, biConsumer);
            default:
                return a.b(this, biConsumer);
        }
    }

    public Object apply(double d5) {
        return Double.valueOf(d5);
    }

    public double applyAsDouble(double d5, double d6) {
        return Math.max(d5, d6);
    }

    public int applyAsInt(int i4, int i5) {
        switch (this.f5554a) {
            case 19:
                return Math.min(i4, i5);
            case 22:
                return i4 + i5;
            default:
                return Math.max(i4, i5);
        }
    }

    public long applyAsLong(long j4, long j5) {
        return Math.min(j4, j5);
    }

    public /* synthetic */ Predicate negate() {
        switch (this.f5554a) {
            case 7:
                return Predicate$CC.$default$negate(this);
            case 9:
                return Predicate$CC.$default$negate(this);
            case 11:
                return Predicate$CC.$default$negate(this);
            default:
                return Predicate$CC.$default$negate(this);
        }
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        switch (this.f5554a) {
            case 7:
                return Predicate$CC.$default$or(this, predicate);
            case 9:
                return Predicate$CC.$default$or(this, predicate);
            case 11:
                return Predicate$CC.$default$or(this, predicate);
            default:
                return Predicate$CC.$default$or(this, predicate);
        }
    }

    public boolean test(Object obj) {
        switch (this.f5554a) {
            case 7:
                return ((C) obj).f5088a;
            case 9:
                return ((D) obj).f5091a;
            case 11:
                return ((E) obj).f5094a;
            default:
                return ((B) obj).f5086a != null;
        }
    }

    public double applyAsDouble(Object obj) {
        return ((Double) obj).doubleValue();
    }

    public long applyAsLong(Object obj) {
        return ((Long) obj).longValue();
    }

    public void accept(Object obj, double d5) {
        double[] dArr = (double[]) obj;
        Collectors.a(dArr, d5);
        dArr[2] = dArr[2] + d5;
    }

    public int applyAsInt(Object obj) {
        return ((Integer) obj).intValue();
    }

    public Object get() {
        switch (this.f5554a) {
            case 5:
                return new double[3];
            case 8:
                return new Object();
            case 10:
                return new Object();
            case 12:
                return new Object();
            case 14:
                return new Object();
            default:
                return new long[2];
        }
    }

    public void accept(Object obj, int i4) {
        switch (this.f5554a) {
            case 20:
                ((C1262x) obj).accept(i4);
                return;
            default:
                long[] jArr = (long[]) obj;
                jArr[0] = jArr[0] + 1;
                jArr[1] = jArr[1] + ((long) i4);
                return;
        }
    }

    public void accept(Object obj, Object obj2) {
        switch (this.f5554a) {
            case 0:
                ((C1261w) obj).b((C1261w) obj2);
                return;
            case 21:
                ((C1262x) obj).b((C1262x) obj2);
                return;
            default:
                long[] jArr = (long[]) obj;
                long[] jArr2 = (long[]) obj2;
                jArr[0] = jArr[0] + jArr2[0];
                jArr[1] = jArr[1] + jArr2[1];
                return;
        }
    }

    public Object apply(int i4) {
        switch (this.f5554a) {
            case 3:
                return new Double[i4];
            case 15:
                return new Object[i4];
            case 16:
                return new Integer[i4];
            default:
                return Integer.valueOf(i4);
        }
    }
}
