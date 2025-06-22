package j$.util.stream;

import java.util.function.IntFunction;

/* renamed from: j$.util.stream.q1  reason: case insensitive filesystem */
public final class C1221q1 extends S2 implements E0, C1243w0 {
    public final E0 a() {
        return this;
    }

    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ E0 g(long j4, long j5, IntFunction intFunction) {
        return C1232t1.w(this, j4, j5, intFunction);
    }

    public final void j() {
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final /* synthetic */ int p() {
        return 0;
    }

    public final E0 b(int i4) {
        throw new IndexOutOfBoundsException();
    }

    public final void h(Object[] objArr, int i4) {
        long j4 = (long) i4;
        long count = count() + j4;
        if (count > ((long) objArr.length) || count < j4) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f5479c == 0) {
            System.arraycopy(this.f5402e, 0, objArr, i4, this.f5478b);
        } else {
            for (int i5 = 0; i5 < this.f5479c; i5++) {
                Object[] objArr2 = this.f5403f[i5];
                System.arraycopy(objArr2, 0, objArr, i4, objArr2.length);
                i4 += this.f5403f[i5].length;
            }
            int i6 = this.f5478b;
            if (i6 > 0) {
                System.arraycopy(this.f5402e, 0, objArr, i4, i6);
            }
        }
    }

    public final Object[] n(IntFunction intFunction) {
        long count = count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            h(objArr, 0);
            return objArr;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void k(long j4) {
        clear();
        r(j4);
    }
}
