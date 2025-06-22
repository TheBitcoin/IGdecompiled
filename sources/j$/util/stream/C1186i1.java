package j$.util.stream;

import j$.util.Objects;
import j$.util.f0;
import j$.util.i0;
import j$.util.v0;
import j$.util.w0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.i1  reason: case insensitive filesystem */
public class C1186i1 implements C0 {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f5516a;

    /* renamed from: b  reason: collision with root package name */
    public int f5517b;

    public final /* synthetic */ void forEach(Consumer consumer) {
        C1232t1.s(this, consumer);
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.v(this, j4, j5);
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
        C1232t1.p(this, (Long[]) objArr, i4);
    }

    public final void e(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i4 = 0; i4 < this.f5517b; i4++) {
            longConsumer.accept(this.f5516a[i4]);
        }
    }

    public final void q(int i4, Object obj) {
        int i5 = this.f5517b;
        System.arraycopy(this.f5516a, 0, (long[]) obj, i4, i5);
    }

    public C1186i1(long j4) {
        if (j4 < 2147483639) {
            this.f5516a = new long[((int) j4)];
            this.f5517b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public C1186i1(long[] jArr) {
        this.f5516a = jArr;
        this.f5517b = jArr.length;
    }

    public final f0 spliterator() {
        int i4 = this.f5517b;
        long[] jArr = this.f5516a;
        w0.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i4);
        return new v0(jArr, 0, i4, 1040);
    }

    /* renamed from: spliterator  reason: collision with other method in class */
    public final i0 m31spliterator() {
        int i4 = this.f5517b;
        long[] jArr = this.f5516a;
        w0.a(((long[]) Objects.requireNonNull(jArr)).length, 0, i4);
        return new v0(jArr, 0, i4, 1040);
    }

    public final Object d() {
        long[] jArr = this.f5516a;
        int length = jArr.length;
        int i4 = this.f5517b;
        if (length == i4) {
            return jArr;
        }
        return Arrays.copyOf(jArr, i4);
    }

    public final long count() {
        return (long) this.f5517b;
    }

    public String toString() {
        long[] jArr = this.f5516a;
        return String.format("LongArrayNode[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f5517b), Arrays.toString(jArr)});
    }
}
