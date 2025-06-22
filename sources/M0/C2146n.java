package m0;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import l0.h;

/* renamed from: m0.n  reason: case insensitive filesystem */
public abstract class C2146n extends AbstractCollection implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f21121a = new Object[0];

    /* renamed from: m0.n$a */
    static abstract class a extends b {

        /* renamed from: a  reason: collision with root package name */
        Object[] f21122a;

        /* renamed from: b  reason: collision with root package name */
        int f21123b = 0;

        /* renamed from: c  reason: collision with root package name */
        boolean f21124c;

        a(int i4) {
            C2139g.b(i4, "initialCapacity");
            this.f21122a = new Object[i4];
        }

        private void d(int i4) {
            Object[] objArr = this.f21122a;
            if (objArr.length < i4) {
                this.f21122a = Arrays.copyOf(objArr, b.a(objArr.length, i4));
                this.f21124c = false;
            } else if (this.f21124c) {
                this.f21122a = (Object[]) objArr.clone();
                this.f21124c = false;
            }
        }

        public b b(Object... objArr) {
            c(objArr, objArr.length);
            return this;
        }

        /* access modifiers changed from: package-private */
        public final void c(Object[] objArr, int i4) {
            C2132F.c(objArr, i4);
            d(this.f21123b + i4);
            System.arraycopy(objArr, 0, this.f21122a, this.f21123b, i4);
            this.f21123b += i4;
        }
    }

    /* renamed from: m0.n$b */
    public static abstract class b {
        b() {
        }

        static int a(int i4, int i5) {
            if (i5 >= 0) {
                int i6 = i4 + (i4 >> 1) + 1;
                if (i6 < i5) {
                    i6 = Integer.highestOneBit(i5 - 1) << 1;
                }
                if (i6 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i6;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    C2146n() {
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract int c(Object[] objArr, int i4);

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public Object[] g() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int j() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean k();

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f21121a);
    }

    public final Object[] toArray(Object[] objArr) {
        h.i(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] g4 = g();
            if (g4 != null) {
                return H.a(g4, j(), h(), objArr);
            }
            objArr = C2132F.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        c(objArr, 0);
        return objArr;
    }
}
