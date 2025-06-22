package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.k5  reason: case insensitive filesystem */
final class C0602k5 extends E3 implements RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    private static final Object[] f1973d;

    /* renamed from: e  reason: collision with root package name */
    private static final C0602k5 f1974e;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f1975b;

    /* renamed from: c  reason: collision with root package name */
    private int f1976c;

    static {
        Object[] objArr = new Object[0];
        f1973d = objArr;
        f1974e = new C0602k5(objArr, 0, false);
    }

    private C0602k5(Object[] objArr, int i4, boolean z4) {
        super(z4);
        this.f1975b = objArr;
        this.f1976c = i4;
    }

    private static int h(int i4) {
        return Math.max(((i4 * 3) / 2) + 1, 10);
    }

    public static C0602k5 j() {
        return f1974e;
    }

    private final String k(int i4) {
        int i5 = this.f1976c;
        return "Index:" + i4 + ", Size:" + i5;
    }

    private final void l(int i4) {
        if (i4 < 0 || i4 >= this.f1976c) {
            throw new IndexOutOfBoundsException(k(i4));
        }
    }

    public final /* synthetic */ C4 a(int i4) {
        Object[] objArr;
        if (i4 >= this.f1976c) {
            if (i4 == 0) {
                objArr = f1973d;
            } else {
                objArr = Arrays.copyOf(this.f1975b, i4);
            }
            return new C0602k5(objArr, this.f1976c, true);
        }
        throw new IllegalArgumentException();
    }

    public final void add(int i4, Object obj) {
        int i5;
        c();
        if (i4 < 0 || i4 > (i5 = this.f1976c)) {
            throw new IndexOutOfBoundsException(k(i4));
        }
        Object[] objArr = this.f1975b;
        if (i5 < objArr.length) {
            System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
        } else {
            Object[] objArr2 = new Object[h(objArr.length)];
            System.arraycopy(this.f1975b, 0, objArr2, 0, i4);
            System.arraycopy(this.f1975b, i4, objArr2, i4 + 1, this.f1976c - i4);
            this.f1975b = objArr2;
        }
        this.f1975b[i4] = obj;
        this.f1976c++;
        this.modCount++;
    }

    /* access modifiers changed from: package-private */
    public final void g(int i4) {
        Object[] objArr = this.f1975b;
        if (i4 > objArr.length) {
            if (objArr.length == 0) {
                this.f1975b = new Object[Math.max(i4, 10)];
                return;
            }
            int length = objArr.length;
            while (length < i4) {
                length = h(length);
            }
            this.f1975b = Arrays.copyOf(this.f1975b, length);
        }
    }

    public final Object get(int i4) {
        l(i4);
        return this.f1975b[i4];
    }

    public final Object remove(int i4) {
        c();
        l(i4);
        Object[] objArr = this.f1975b;
        Object obj = objArr[i4];
        int i5 = this.f1976c;
        if (i4 < i5 - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (i5 - i4) - 1);
        }
        this.f1976c--;
        this.modCount++;
        return obj;
    }

    public final Object set(int i4, Object obj) {
        c();
        l(i4);
        Object[] objArr = this.f1975b;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        this.modCount++;
        return obj2;
    }

    public final int size() {
        return this.f1976c;
    }

    public final boolean add(Object obj) {
        c();
        int i4 = this.f1976c;
        Object[] objArr = this.f1975b;
        if (i4 == objArr.length) {
            this.f1975b = Arrays.copyOf(this.f1975b, h(objArr.length));
        }
        Object[] objArr2 = this.f1975b;
        int i5 = this.f1976c;
        this.f1976c = i5 + 1;
        objArr2[i5] = obj;
        this.modCount++;
        return true;
    }
}
