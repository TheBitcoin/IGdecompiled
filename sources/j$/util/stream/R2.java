package j$.util.stream;

import j$.util.i0;
import java.util.Arrays;

public abstract class R2 extends C1154c implements Iterable {

    /* renamed from: e  reason: collision with root package name */
    public Object f5396e = c(16);

    /* renamed from: f  reason: collision with root package name */
    public Object[] f5397f;

    public abstract Object c(int i4);

    public abstract void r(Object obj, int i4, int i5, Object obj2);

    public abstract int s(Object obj);

    public abstract i0 spliterator();

    public abstract Object[] v();

    public R2(int i4) {
        super(i4);
    }

    public R2() {
    }

    public final void u(long j4) {
        long j5;
        int i4 = this.f5479c;
        if (i4 == 0) {
            j5 = (long) s(this.f5396e);
        } else {
            j5 = ((long) s(this.f5397f[i4])) + this.f5480d[i4];
        }
        if (j4 > j5) {
            if (this.f5397f == null) {
                Object[] v4 = v();
                this.f5397f = v4;
                this.f5480d = new long[8];
                v4[0] = this.f5396e;
            }
            int i5 = this.f5479c + 1;
            while (j4 > j5) {
                Object[] objArr = this.f5397f;
                if (i5 >= objArr.length) {
                    int length = objArr.length * 2;
                    this.f5397f = Arrays.copyOf(objArr, length);
                    this.f5480d = Arrays.copyOf(this.f5480d, length);
                }
                int i6 = this.f5477a;
                if (!(i5 == 0 || i5 == 1)) {
                    i6 = Math.min((i6 + i5) - 1, 30);
                }
                int i7 = 1 << i6;
                this.f5397f[i5] = c(i7);
                long[] jArr = this.f5480d;
                int i8 = i5 - 1;
                jArr[i5] = jArr[i8] + ((long) s(this.f5397f[i8]));
                j5 += (long) i7;
                i5++;
            }
        }
    }

    public final int t(long j4) {
        if (this.f5479c == 0) {
            if (j4 < ((long) this.f5478b)) {
                return 0;
            }
            throw new IndexOutOfBoundsException(Long.toString(j4));
        } else if (j4 < count()) {
            for (int i4 = 0; i4 <= this.f5479c; i4++) {
                if (j4 < this.f5480d[i4] + ((long) s(this.f5397f[i4]))) {
                    return i4;
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j4));
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j4));
        }
    }

    public void q(int i4, Object obj) {
        long j4 = (long) i4;
        long count = count() + j4;
        if (count > ((long) s(obj)) || count < j4) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.f5479c == 0) {
            System.arraycopy(this.f5396e, 0, obj, i4, this.f5478b);
        } else {
            for (int i5 = 0; i5 < this.f5479c; i5++) {
                Object obj2 = this.f5397f[i5];
                System.arraycopy(obj2, 0, obj, i4, s(obj2));
                i4 += s(this.f5397f[i5]);
            }
            int i6 = this.f5478b;
            if (i6 > 0) {
                System.arraycopy(this.f5396e, 0, obj, i4, i6);
            }
        }
    }

    public Object d() {
        long count = count();
        if (count < 2147483639) {
            Object c5 = c((int) count);
            q(0, c5);
            return c5;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void w() {
        long j4;
        if (this.f5478b == s(this.f5396e)) {
            if (this.f5397f == null) {
                Object[] v4 = v();
                this.f5397f = v4;
                this.f5480d = new long[8];
                v4[0] = this.f5396e;
            }
            int i4 = this.f5479c;
            int i5 = i4 + 1;
            Object[] objArr = this.f5397f;
            if (i5 >= objArr.length || objArr[i5] == null) {
                if (i4 == 0) {
                    j4 = (long) s(this.f5396e);
                } else {
                    j4 = ((long) s(objArr[i4])) + this.f5480d[i4];
                }
                u(j4 + 1);
            }
            this.f5478b = 0;
            int i6 = this.f5479c + 1;
            this.f5479c = i6;
            this.f5396e = this.f5397f[i6];
        }
    }

    public final void clear() {
        Object[] objArr = this.f5397f;
        if (objArr != null) {
            this.f5396e = objArr[0];
            this.f5397f = null;
            this.f5480d = null;
        }
        this.f5478b = 0;
        this.f5479c = 0;
    }

    public void e(Object obj) {
        for (int i4 = 0; i4 < this.f5479c; i4++) {
            Object obj2 = this.f5397f[i4];
            r(obj2, 0, s(obj2), obj);
        }
        r(this.f5396e, 0, this.f5478b, obj);
    }
}
