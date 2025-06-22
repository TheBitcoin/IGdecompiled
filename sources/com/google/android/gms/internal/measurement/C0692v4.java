package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.v4  reason: case insensitive filesystem */
final class C0692v4 extends E3 implements A4, C0593j5, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f2211d;

    /* renamed from: e  reason: collision with root package name */
    private static final C0692v4 f2212e;

    /* renamed from: b  reason: collision with root package name */
    private int[] f2213b;

    /* renamed from: c  reason: collision with root package name */
    private int f2214c;

    static {
        int[] iArr = new int[0];
        f2211d = iArr;
        f2212e = new C0692v4(iArr, 0, false);
    }

    private C0692v4(int[] iArr, int i4, boolean z4) {
        super(z4);
        this.f2213b = iArr;
        this.f2214c = i4;
    }

    public static C0692v4 h() {
        return f2212e;
    }

    private static int l(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    private final String m(int i4) {
        int i5 = this.f2214c;
        return "Index:" + i4 + ", Size:" + i5;
    }

    private final void n(int i4) {
        if (i4 < 0 || i4 >= this.f2214c) {
            throw new IndexOutOfBoundsException(m(i4));
        }
    }

    public final /* synthetic */ void add(int i4, Object obj) {
        int i5;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i4 < 0 || i4 > (i5 = this.f2214c)) {
            throw new IndexOutOfBoundsException(m(i4));
        }
        int[] iArr = this.f2213b;
        if (i5 < iArr.length) {
            System.arraycopy(iArr, i4, iArr, i4 + 1, i5 - i4);
        } else {
            int[] iArr2 = new int[l(iArr.length)];
            System.arraycopy(this.f2213b, 0, iArr2, 0, i4);
            System.arraycopy(this.f2213b, i4, iArr2, i4 + 1, this.f2214c - i4);
            this.f2213b = iArr2;
        }
        this.f2213b[i4] = intValue;
        this.f2214c++;
        this.modCount++;
    }

    public final boolean addAll(Collection collection) {
        c();
        C0684u4.e(collection);
        if (!(collection instanceof C0692v4)) {
            return super.addAll(collection);
        }
        C0692v4 v4Var = (C0692v4) collection;
        int i4 = v4Var.f2214c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f2214c;
        if (Integer.MAX_VALUE - i5 >= i4) {
            int i6 = i5 + i4;
            int[] iArr = this.f2213b;
            if (i6 > iArr.length) {
                this.f2213b = Arrays.copyOf(iArr, i6);
            }
            System.arraycopy(v4Var.f2213b, 0, this.f2213b, this.f2214c, v4Var.f2214c);
            this.f2214c = i6;
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

    /* renamed from: e */
    public final A4 a(int i4) {
        int[] iArr;
        if (i4 >= this.f2214c) {
            if (i4 == 0) {
                iArr = f2211d;
            } else {
                iArr = Arrays.copyOf(this.f2213b, i4);
            }
            return new C0692v4(iArr, this.f2214c, true);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0692v4)) {
            return super.equals(obj);
        }
        C0692v4 v4Var = (C0692v4) obj;
        if (this.f2214c != v4Var.f2214c) {
            return false;
        }
        int[] iArr = v4Var.f2213b;
        for (int i4 = 0; i4 < this.f2214c; i4++) {
            if (this.f2213b[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    public final int g(int i4) {
        n(i4);
        return this.f2213b[i4];
    }

    public final /* synthetic */ Object get(int i4) {
        return Integer.valueOf(g(i4));
    }

    public final int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f2214c; i5++) {
            i4 = (i4 * 31) + this.f2213b[i5];
        }
        return i4;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f2213b[i4] == intValue) {
                return i4;
            }
        }
        return -1;
    }

    public final void j(int i4) {
        c();
        int i5 = this.f2214c;
        int[] iArr = this.f2213b;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[l(iArr.length)];
            System.arraycopy(this.f2213b, 0, iArr2, 0, this.f2214c);
            this.f2213b = iArr2;
        }
        int[] iArr3 = this.f2213b;
        int i6 = this.f2214c;
        this.f2214c = i6 + 1;
        iArr3[i6] = i4;
    }

    /* access modifiers changed from: package-private */
    public final void k(int i4) {
        int[] iArr = this.f2213b;
        if (i4 > iArr.length) {
            if (iArr.length == 0) {
                this.f2213b = new int[Math.max(i4, 10)];
                return;
            }
            int length = iArr.length;
            while (length < i4) {
                length = l(length);
            }
            this.f2213b = Arrays.copyOf(this.f2213b, length);
        }
    }

    public final /* synthetic */ Object remove(int i4) {
        c();
        n(i4);
        int[] iArr = this.f2213b;
        int i5 = iArr[i4];
        int i6 = this.f2214c;
        if (i4 < i6 - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (i6 - i4) - 1);
        }
        this.f2214c--;
        this.modCount++;
        return Integer.valueOf(i5);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i4, int i5) {
        c();
        if (i5 >= i4) {
            int[] iArr = this.f2213b;
            System.arraycopy(iArr, i5, iArr, i4, this.f2214c - i5);
            this.f2214c -= i5 - i4;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i4, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        n(i4);
        int[] iArr = this.f2213b;
        int i5 = iArr[i4];
        iArr[i4] = intValue;
        return Integer.valueOf(i5);
    }

    public final int size() {
        return this.f2214c;
    }

    public final /* synthetic */ boolean add(Object obj) {
        j(((Integer) obj).intValue());
        return true;
    }
}
