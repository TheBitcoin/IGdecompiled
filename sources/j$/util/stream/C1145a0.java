package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.A;
import j$.util.function.Consumer$CC;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* renamed from: j$.util.stream.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C1145a0 implements BiConsumer, IntFunction, LongFunction, Supplier, ObjLongConsumer, LongBinaryOperator, Consumer, BinaryOperator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f5469a;

    public /* synthetic */ C1145a0(int i4) {
        this.f5469a = i4;
    }

    private final void accept$j$$util$stream$Node$$ExternalSyntheticLambda0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda0(Object obj) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda1(Object obj) {
    }

    public void accept(Object obj) {
        int i4 = this.f5469a;
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f5469a) {
            case 0:
                return a.b(this, biConsumer);
            default:
                return a.b(this, biConsumer);
        }
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f5469a) {
            case 11:
                return a.c(this, function);
            case 13:
                return a.c(this, function);
            case 15:
                return a.c(this, function);
            default:
                return a.c(this, function);
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f5469a) {
            case 8:
                return Consumer$CC.$default$andThen(this, consumer);
            case 21:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public Object apply(long j4) {
        switch (this.f5469a) {
            case 2:
                return Long.valueOf(j4);
            case 10:
                return C1232t1.G(j4);
            case 12:
                return C1232t1.P(j4);
            default:
                return C1232t1.Q(j4);
        }
    }

    public long applyAsLong(long j4, long j5) {
        switch (this.f5469a) {
            case 6:
                return Math.max(j4, j5);
            default:
                return j4 + j5;
        }
    }

    public Object get() {
        return new long[2];
    }

    public void accept(Object obj, long j4) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j4;
    }

    public void accept(Object obj, Object obj2) {
        switch (this.f5469a) {
            case 0:
                ((A) obj).b((A) obj2);
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
        switch (this.f5469a) {
            case 1:
                return new Long[i4];
            case 9:
                return new Object[i4];
            case 17:
                return new Object[i4];
            case 18:
                return new Integer[i4];
            case 19:
                return new Long[i4];
            default:
                return new Double[i4];
        }
    }

    public Object apply(Object obj, Object obj2) {
        switch (this.f5469a) {
            case 11:
                return new G0((C1251y0) obj, (C1251y0) obj2);
            case 13:
                return new G0((A0) obj, (A0) obj2);
            case 15:
                return new G0((C0) obj, (C0) obj2);
            default:
                return new G0((E0) obj, (E0) obj2);
        }
    }
}
