package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.i0  reason: case insensitive filesystem */
final class C0579i0 extends C0649q0 {

    /* renamed from: a  reason: collision with root package name */
    private String f1925a;

    /* renamed from: b  reason: collision with root package name */
    private C0672t0 f1926b;

    /* renamed from: c  reason: collision with root package name */
    private C0664s0 f1927c;

    /* renamed from: d  reason: collision with root package name */
    private byte f1928d;

    C0579i0() {
    }

    public final C0649q0 a(C0664s0 s0Var) {
        if (s0Var != null) {
            this.f1927c = s0Var;
            return this;
        }
        throw new NullPointerException("Null filePurpose");
    }

    /* access modifiers changed from: package-private */
    public final C0649q0 b(C0672t0 t0Var) {
        if (t0Var != null) {
            this.f1926b = t0Var;
            return this;
        }
        throw new NullPointerException("Null fileChecks");
    }

    public final C0649q0 c(boolean z4) {
        this.f1928d = (byte) (this.f1928d | 1);
        return this;
    }

    public final C0656r0 d() {
        if (this.f1928d == 1 && this.f1925a != null && this.f1926b != null && this.f1927c != null) {
            return new C0588j0(this.f1925a, false, this.f1926b, (C0570h0) null, (C0561g0) null, this.f1927c, (C0606l0) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f1925a == null) {
            sb.append(" fileOwner");
        }
        if ((1 & this.f1928d) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.f1926b == null) {
            sb.append(" fileChecks");
        }
        if (this.f1927c == null) {
            sb.append(" filePurpose");
        }
        String valueOf = String.valueOf(sb);
        throw new IllegalStateException("Missing required properties:" + valueOf);
    }

    public final C0649q0 e(String str) {
        this.f1925a = str;
        return this;
    }
}
