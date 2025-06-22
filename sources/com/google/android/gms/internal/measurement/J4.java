package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class J4 extends E3 implements C0716y4, C0593j5, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final long[] f1507d;

    /* renamed from: e  reason: collision with root package name */
    private static final J4 f1508e;

    /* renamed from: b  reason: collision with root package name */
    private long[] f1509b;

    /* renamed from: c  reason: collision with root package name */
    private int f1510c;

    static {
        long[] jArr = new long[0];
        f1507d = jArr;
        f1508e = new J4(jArr, 0, false);
    }

    private J4(long[] jArr, int i4, boolean z4) {
        super(z4);
        this.f1509b = jArr;
        this.f1510c = i4;
    }

    public static J4 h() {
        return f1508e;
    }

    private static int k(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String l(int i4) {
        int i5 = this.f1510c;
        return "Index:" + i4 + ", Size:" + i5;
    }

    private final void m(int i4) {
        if (i4 < 0 || i4 >= this.f1510c) {
            throw new IndexOutOfBoundsException(l(i4));
        }
    }

    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        long longValue = ((Long) obj).longValue();
        c();
        if (i4 < 0 || i4 > (i5 = this.f1510c)) {
            throw new IndexOutOfBoundsException(l(i4));
        }
        long[] jArr = this.f1509b;
        if (i5 < jArr.length) {
            System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
        } else {
            long[] jArr2 = new long[k(jArr.length)];
            System.arraycopy(this.f1509b, 0, jArr2, 0, i4);
            System.arraycopy(this.f1509b, i4, jArr2, i4 + 1, this.f1510c - i4);
            this.f1509b = jArr2;
        }
        this.f1509b[i4] = longValue;
        this.f1510c++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        c();
        C0684u4.e(collection);
        if (!(collection instanceof J4)) {
            return super.addAll(collection);
        }
        J4 j4 = (J4) collection;
        int i4 = j4.f1510c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f1510c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            long[] jArr = this.f1509b;
            if (i6 > jArr.length) {
                this.f1509b = Arrays.copyOf(jArr, i6);
            }
            System.arraycopy(j4.f1509b, 0, this.f1509b, this.f1510c, j4.f1510c);
            this.f1510c = i6;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final long d(int i4) {
        m(i4);
        return this.f1509b[i4];
    }

    /* renamed from: e */
    public final C0716y4 a(int i4) {
        long[] jArr;
        if (i4 >= this.f1510c) {
            if (i4 == 0) {
                jArr = f1507d;
            } else {
                jArr = Arrays.copyOf(this.f1509b, i4);
            }
            return new J4(jArr, this.f1510c, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof J4)) {
            return super.equals(obj);
        }
        J4 j4 = (J4) obj;
        if (this.f1510c != j4.f1510c) {
            return false;
        }
        long[] jArr = j4.f1509b;
        for (int i4 = 0; i4 < this.f1510c; i4++) {
            if (this.f1509b[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    public final void g(long j4) {
        c();
        int i4 = this.f1510c;
        long[] jArr = this.f1509b;
        if (i4 == jArr.length) {
            long[] jArr2 = new long[k(jArr.length)];
            System.arraycopy(this.f1509b, 0, jArr2, 0, this.f1510c);
            this.f1509b = jArr2;
        }
        long[] jArr3 = this.f1509b;
        int i5 = this.f1510c;
        this.f1510c = i5 + 1;
        jArr3[i5] = j4;
    }

    public final /* synthetic */ Object get(int i4) {
        return Long.valueOf(d(i4));
    }

    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f1510c; i5++) {
            i4 = (i4 * 31) + C0684u4.b(this.f1509b[i5]);
        }
        return i4;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f1509b[i4] == longValue) {
                return i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final void j(int i4) {
        long[] jArr = this.f1509b;
        if (i4 > jArr.length) {
            if (jArr.length == 0) {
                this.f1509b = new long[Math.max(i4, 10)];
                return;
            }
            int length = jArr.length;
            while (length < i4) {
                length = k(length);
            }
            this.f1509b = Arrays.copyOf(this.f1509b, length);
        }
    }

    public final /* synthetic */ Object remove(int i4) {
        c();
        m(i4);
        long[] jArr = this.f1509b;
        long j4 = jArr[i4];
        int i5 = this.f1510c;
        if (i4 < i5 - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (i5 - i4) - 1);
        }
        this.f1510c--;
        this.modCount++;
        return Long.valueOf(j4);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i4, int i5) {
        c();
        if (i5 >= i4) {
            long[] jArr = this.f1509b;
            System.arraycopy(jArr, i5, jArr, i4, this.f1510c - i5);
            this.f1510c -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i4, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        m(i4);
        long[] jArr = this.f1509b;
        long j4 = jArr[i4];
        jArr[i4] = longValue;
        return Long.valueOf(j4);
    }

    public final int size() {
        return this.f1510c;
    }

    public final /* synthetic */ boolean add(Object obj) {
        g(((Long) obj).longValue());
        return true;
    }
}
