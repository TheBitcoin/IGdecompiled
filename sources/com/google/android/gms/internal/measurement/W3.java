package com.google.android.gms.internal.measurement;

public abstract class W3 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f1654b = 100;

    /* renamed from: a  reason: collision with root package name */
    int f1655a;

    public static int a(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long b(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    static W3 c(byte[] bArr, int i4, int i5, boolean z4) {
        int i6 = i5;
        Z3 z32 = new Z3(bArr, i6);
        try {
            z32.d(i6);
            return z32;
        } catch (B4 e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public abstract int d(int i4);

    public abstract int e();

    private W3() {
        this.f1655a = f1654b;
    }
}
