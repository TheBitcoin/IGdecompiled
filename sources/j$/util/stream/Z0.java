package j$.util.stream;

import j$.util.Objects;
import j$.util.f0;
import j$.util.i0;
import j$.util.t0;
import j$.util.w0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

public class Z0 implements A0 {

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5454a;

    /* renamed from: b  reason: collision with root package name */
    public int f5455b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C1232t1.r(this, consumer);
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.u(this, j4, j5);
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
        C1232t1.o(this, (Integer[]) objArr, i4);
    }

    public final void e(Object obj) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i4 = 0; i4 < this.f5455b; i4++) {
            intConsumer.accept(this.f5454a[i4]);
        }
    }

    public final void q(int i4, Object obj) {
        int i5 = this.f5455b;
        System.arraycopy(this.f5454a, 0, (int[]) obj, i4, i5);
    }

    public Z0(long j4) {
        if (j4 < 2147483639) {
            this.f5454a = new int[((int) j4)];
            this.f5455b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public Z0(int[] iArr) {
        this.f5454a = iArr;
        this.f5455b = iArr.length;
    }

    public final f0 spliterator() {
        int i4 = this.f5455b;
        int[] iArr = this.f5454a;
        w0.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i4);
        return new t0(iArr, 0, i4, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m26spliterator() {
        int i4 = this.f5455b;
        int[] iArr = this.f5454a;
        w0.a(((int[]) Objects.requireNonNull(iArr)).length, 0, i4);
        return new t0(iArr, 0, i4, 1040);
    }

    public final Object d() {
        int[] iArr = this.f5454a;
        int length = iArr.length;
        int i4 = this.f5455b;
        if (length == i4) {
            return iArr;
        }
        return Arrays.copyOf(iArr, i4);
    }

    public final long count() {
        return (long) this.f5455b;
    }

    public String toString() {
        int[] iArr = this.f5454a;
        return String.format("IntArrayNode[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f5455b), Arrays.toString(iArr)});
    }
}
