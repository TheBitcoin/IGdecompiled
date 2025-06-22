package com.google.android.gms.internal.measurement;

class V3 extends S3 {

    /* renamed from: d  reason: collision with root package name */
    protected final byte[] f1649d;

    V3(byte[] bArr) {
        super();
        bArr.getClass();
        this.f1649d = bArr;
    }

    public byte c(int i4) {
        return this.f1649d[i4];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof K3) || q() != ((K3) obj).q()) {
            return false;
        }
        if (q() == 0) {
            return true;
        }
        if (!(obj instanceof V3)) {
            return obj.equals(this);
        }
        V3 v32 = (V3) obj;
        int g4 = g();
        int g5 = v32.g();
        if (g4 == 0 || g5 == 0 || g4 == g5) {
            return t(v32, 0, q());
        }
        return false;
    }

    public final K3 k(int i4, int i5) {
        int j4 = K3.j(0, i5, q());
        if (j4 == 0) {
            return K3.f1515b;
        }
        return new O3(this.f1649d, u(), j4);
    }

    /* access modifiers changed from: package-private */
    public final void o(L3 l32) {
        l32.a(this.f1649d, u(), q());
    }

    /* access modifiers changed from: package-private */
    public byte p(int i4) {
        return this.f1649d[i4];
    }

    public int q() {
        return this.f1649d.length;
    }

    /* access modifiers changed from: protected */
    public final int r(int i4, int i5, int i6) {
        return C0684u4.a(i4, this.f1649d, u(), i6);
    }

    /* access modifiers changed from: package-private */
    public final boolean t(K3 k32, int i4, int i5) {
        if (i5 > k32.q()) {
            int q4 = q();
            throw new IllegalArgumentException("Length too large: " + i5 + q4);
        } else if (i5 > k32.q()) {
            int q5 = k32.q();
            throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + i5 + ", " + q5);
        } else if (!(k32 instanceof V3)) {
            return k32.k(0, i5).equals(k(0, i5));
        } else {
            V3 v32 = (V3) k32;
            byte[] bArr = this.f1649d;
            byte[] bArr2 = v32.f1649d;
            int u4 = u() + i5;
            int u5 = u();
            int u6 = v32.u();
            while (u5 < u4) {
                if (bArr[u5] != bArr2[u6]) {
                    return false;
                }
                u5++;
                u6++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public int u() {
        return 0;
    }
}
