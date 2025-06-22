package com.google.android.gms.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.F3;
import com.google.android.gms.measurement.internal.S2;
import java.util.List;
import java.util.Map;

final class b extends AppMeasurement.a {

    /* renamed from: a  reason: collision with root package name */
    private final S2 f2281a;

    /* renamed from: b  reason: collision with root package name */
    private final F3 f2282b;

    public b(S2 s22) {
        super();
        C0335p.l(s22);
        this.f2281a = s22;
        this.f2282b = s22.H();
    }

    public final long E() {
        return this.f2281a.L().R0();
    }

    public final String F() {
        return this.f2282b.w0();
    }

    public final String a() {
        return this.f2282b.v0();
    }

    public final void b(String str, String str2, Bundle bundle) {
        this.f2281a.H().h0(str, str2, bundle);
    }

    public final int c(String str) {
        return F3.E(str);
    }

    public final String d() {
        return this.f2282b.x0();
    }

    public final String e() {
        return this.f2282b.v0();
    }

    public final void f(Bundle bundle) {
        this.f2282b.N0(bundle);
    }

    public final void g(String str) {
        this.f2281a.v().D(str, this.f2281a.B().elapsedRealtime());
    }

    public final List h(String str, String str2) {
        return this.f2282b.G(str, str2);
    }

    public final void i(String str) {
        this.f2281a.v().w(str, this.f2281a.B().elapsedRealtime());
    }

    public final Map j(String str, String str2, boolean z4) {
        return this.f2282b.H(str, str2, z4);
    }

    public final void k(String str, String str2, Bundle bundle) {
        this.f2282b.U0(str, str2, bundle);
    }
}
