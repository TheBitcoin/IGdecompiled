package j$.util.stream;

import j$.util.Objects;
import j$.util.f0;
import j$.util.i0;
import j$.util.o0;
import j$.util.w0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

public class Q0 implements C1251y0 {

    /* renamed from: a  reason: collision with root package name */
    public final double[] f5388a;

    /* renamed from: b  reason: collision with root package name */
    public int f5389b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C1232t1.q(this, consumer);
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.t(this, j4, j5);
    }

    public final /* synthetic */ Object[] n(IntFunction intFunction) {
        return C1232t1.m(this, intFunction);
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final D0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public final /* synthetic */ void h(Object[] objArr, int i4) {
        C1232t1.n(this, (Double[]) objArr, i4);
    }

    public final void e(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i4 = 0; i4 < this.f5389b; i4++) {
            doubleConsumer.accept(this.f5388a[i4]);
        }
    }

    public final void q(int i4, Object obj) {
        int i5 = this.f5389b;
        System.arraycopy(this.f5388a, 0, (double[]) obj, i4, i5);
    }

    public Q0(long j4) {
        if (j4 < 2147483639) {
            this.f5388a = new double[((int) j4)];
            this.f5389b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public Q0(double[] dArr) {
        this.f5388a = dArr;
        this.f5389b = dArr.length;
    }

    public final f0 spliterator() {
        int i4 = this.f5389b;
        double[] dArr = this.f5388a;
        w0.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i4);
        return new o0(dArr, 0, i4, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m23spliterator() {
        int i4 = this.f5389b;
        double[] dArr = this.f5388a;
        w0.a(((double[]) Objects.requireNonNull(dArr)).length, 0, i4);
        return new o0(dArr, 0, i4, 1040);
    }

    public final Object d() {
        double[] dArr = this.f5388a;
        int length = dArr.length;
        int i4 = this.f5389b;
        if (length == i4) {
            return dArr;
        }
        return Arrays.copyOf(dArr, i4);
    }

    public final long count() {
        return (long) this.f5389b;
    }

    public String toString() {
        double[] dArr = this.f5388a;
        return String.format("DoubleArrayNode[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f5389b), Arrays.toString(dArr)});
    }
}
