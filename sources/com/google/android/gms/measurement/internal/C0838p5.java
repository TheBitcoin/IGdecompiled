package com.google.android.gms.measurement.internal;

import R.d;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.N0;

/* renamed from: com.google.android.gms.measurement.internal.p5  reason: case insensitive filesystem */
public final class C0838p5 extends C0897y2 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Handler f3186c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3187d = true;

    /* renamed from: e  reason: collision with root package name */
    protected final C0886w5 f3188e = new C0886w5(this);

    /* renamed from: f  reason: collision with root package name */
    protected final C0872u5 f3189f = new C0872u5(this);

    /* renamed from: g  reason: collision with root package name */
    private final C0865t5 f3190g = new C0865t5(this);

    C0838p5(S2 s22) {
        super(s22);
    }

    /* access modifiers changed from: private */
    public final void G() {
        k();
        if (this.f3186c == null) {
            this.f3186c = new N0(Looper.getMainLooper());
        }
    }

    static /* synthetic */ void I(C0838p5 p5Var, long j4) {
        p5Var.k();
        p5Var.G();
        p5Var.a().K().b("Activity resumed, time", Long.valueOf(j4));
        if (p5Var.b().q(G.f2435P0)) {
            if (p5Var.b().V() || p5Var.f3187d) {
                p5Var.f3189f.f(j4);
            }
        } else if (p5Var.b().V() || p5Var.e().f3336u.b()) {
            p5Var.f3189f.f(j4);
        }
        p5Var.f3190g.a();
        C0886w5 w5Var = p5Var.f3188e;
        w5Var.f3284a.k();
        if (w5Var.f3284a.f3273a.m()) {
            w5Var.b(w5Var.f3284a.B().currentTimeMillis(), false);
        }
    }

    static /* synthetic */ void z(C0838p5 p5Var, long j4) {
        p5Var.k();
        p5Var.G();
        p5Var.a().K().b("Activity paused, time", Long.valueOf(j4));
        p5Var.f3190g.b(j4);
        if (p5Var.b().V()) {
            p5Var.f3189f.e(j4);
        }
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    /* access modifiers changed from: package-private */
    public final void D(boolean z4) {
        k();
        this.f3187d = z4;
    }

    public final boolean E(boolean z4, boolean z5, long j4) {
        return this.f3189f.d(z4, z5, j4);
    }

    /* access modifiers changed from: package-private */
    public final boolean F() {
        k();
        return this.f3187d;
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ C0894y l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ C0772g2 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0765f2 n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ F3 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0885w4 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ F4 q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ C0838p5 r() {
        return super.r();
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }
}
