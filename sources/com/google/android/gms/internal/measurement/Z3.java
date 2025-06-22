package com.google.android.gms.internal.measurement;

final class Z3 extends W3 {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1738c;

    /* renamed from: d  reason: collision with root package name */
    private int f1739d;

    /* renamed from: e  reason: collision with root package name */
    private int f1740e;

    /* renamed from: f  reason: collision with root package name */
    private int f1741f;

    /* renamed from: g  reason: collision with root package name */
    private int f1742g;

    /* renamed from: h  reason: collision with root package name */
    private int f1743h;

    private final void f() {
        int i4 = this.f1739d + this.f1740e;
        this.f1739d = i4;
        int i5 = i4 - this.f1742g;
        int i6 = this.f1743h;
        if (i5 > i6) {
            int i7 = i5 - i6;
            this.f1740e = i7;
            this.f1739d = i4 - i7;
            return;
        }
        this.f1740e = 0;
    }

    public final int d(int i4) {
        if (i4 >= 0) {
            int e5 = i4 + e();
            if (e5 >= 0) {
                int i5 = this.f1743h;
                if (e5 <= i5) {
                    this.f1743h = e5;
                    f();
                    return i5;
                }
                throw B4.g();
            }
            throw B4.e();
        }
        throw B4.d();
    }

    public final int e() {
        return this.f1741f - this.f1742g;
    }

    private Z3(byte[] bArr, int i4, int i5, boolean z4) {
        super();
        this.f1743h = Integer.MAX_VALUE;
        this.f1738c = bArr;
        this.f1739d = i5 + i4;
        this.f1741f = i4;
        this.f1742g = i4;
    }
}
