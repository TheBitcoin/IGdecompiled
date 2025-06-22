package com.google.android.gms.internal.measurement;

final class O3 extends V3 {

    /* renamed from: e  reason: collision with root package name */
    private final int f1588e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1589f;

    O3(byte[] bArr, int i4, int i5) {
        super(bArr);
        K3.j(i4, i4 + i5, bArr.length);
        this.f1588e = i4;
        this.f1589f = i5;
    }

    public final byte c(int i4) {
        int q4 = q();
        if (((q4 - (i4 + 1)) | i4) >= 0) {
            return this.f1649d[this.f1588e + i4];
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + q4);
    }

    /* access modifiers changed from: package-private */
    public final byte p(int i4) {
        return this.f1649d[this.f1588e + i4];
    }

    public final int q() {
        return this.f1589f;
    }

    /* access modifiers changed from: protected */
    public final int u() {
        return this.f1588e;
    }
}
