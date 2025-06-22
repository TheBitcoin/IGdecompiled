package j$.util.stream;

import j$.util.C1127b;
import j$.util.i0;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class H0 implements E0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f5308a;

    /* renamed from: b  reason: collision with root package name */
    public int f5309b;

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.w(this, j4, j5, intFunction);
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final E0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public H0(long j4, IntFunction intFunction) {
        if (j4 < 2147483639) {
            this.f5308a = (Object[]) intFunction.apply((int) j4);
            this.f5309b = 0;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public H0(Object[] objArr) {
        this.f5308a = objArr;
        this.f5309b = objArr.length;
    }

    public final i0 spliterator() {
        return C1127b.x(this.f5308a, 0, this.f5309b);
    }

    public final void h(Object[] objArr, int i4) {
        System.arraycopy(this.f5308a, 0, objArr, i4, this.f5309b);
    }

    public final Object[] n(IntFunction intFunction) {
        Object[] objArr = this.f5308a;
        if (objArr.length == this.f5309b) {
            return objArr;
        }
        throw new IllegalStateException();
    }

    public final long count() {
        return (long) this.f5309b;
    }

    public final void forEach(Consumer consumer) {
        for (int i4 = 0; i4 < this.f5309b; i4++) {
            consumer.accept(this.f5308a[i4]);
        }
    }

    public String toString() {
        Object[] objArr = this.f5308a;
        return String.format("ArrayNode[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f5309b), Arrays.toString(objArr)});
    }
}
