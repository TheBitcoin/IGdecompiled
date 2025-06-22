package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.j0  reason: case insensitive filesystem */
final class C0588j0 extends C0656r0 {

    /* renamed from: c  reason: collision with root package name */
    private final String f1941c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1942d;

    /* renamed from: e  reason: collision with root package name */
    private final C0672t0 f1943e;

    /* renamed from: f  reason: collision with root package name */
    private final C0664s0 f1944f;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ C0588j0(java.lang.String r1, boolean r2, com.google.android.gms.internal.measurement.C0672t0 r3, com.google.android.gms.internal.measurement.C0570h0 r4, com.google.android.gms.internal.measurement.C0561g0 r5, com.google.android.gms.internal.measurement.C0664s0 r6, com.google.android.gms.internal.measurement.C0606l0 r7) {
        /*
            r0 = this;
            r5 = 0
            r7 = r6
            r6 = 0
            r4 = r3
            r3 = 0
            r2 = r1
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0588j0.<init>(java.lang.String, boolean, com.google.android.gms.internal.measurement.t0, com.google.android.gms.internal.measurement.h0, com.google.android.gms.internal.measurement.g0, com.google.android.gms.internal.measurement.s0, com.google.android.gms.internal.measurement.l0):void");
    }

    public final C0570h0 a() {
        return null;
    }

    public final C0561g0 b() {
        return null;
    }

    public final C0672t0 c() {
        return this.f1943e;
    }

    public final C0664s0 d() {
        return this.f1944f;
    }

    public final String e() {
        return this.f1941c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0656r0) {
            C0656r0 r0Var = (C0656r0) obj;
            if (this.f1941c.equals(r0Var.e()) && this.f1942d == r0Var.f() && this.f1943e.equals(r0Var.c())) {
                r0Var.a();
                r0Var.b();
                if (this.f1944f.equals(r0Var.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f1942d;
    }

    public final int hashCode() {
        int i4;
        int hashCode = (this.f1941c.hashCode() ^ 1000003) * 1000003;
        if (this.f1942d) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((hashCode ^ i4) * 1000003) ^ this.f1943e.hashCode()) * 583896283) ^ this.f1944f.hashCode();
    }

    public final String toString() {
        String str = this.f1941c;
        boolean z4 = this.f1942d;
        String valueOf = String.valueOf(this.f1943e);
        String valueOf2 = String.valueOf(this.f1944f);
        return "FileComplianceOptions{fileOwner=" + str + ", hasDifferentDmaOwner=" + z4 + ", fileChecks=" + valueOf + ", dataForwardingNotAllowedResolver=" + "null" + ", multipleProductIdGroupsResolver=" + "null" + ", filePurpose=" + valueOf2 + "}";
    }

    private C0588j0(String str, boolean z4, C0672t0 t0Var, C0570h0 h0Var, C0561g0 g0Var, C0664s0 s0Var) {
        this.f1941c = str;
        this.f1942d = z4;
        this.f1943e = t0Var;
        this.f1944f = s0Var;
    }
}
