package com.google.android.gms.measurement.internal;

final class D4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f2360a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f2361b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0885w4 f2362c;

    D4(C0885w4 w4Var, C0892x4 x4Var, long j4) {
        this.f2360a = x4Var;
        this.f2361b = j4;
        this.f2362c = w4Var;
    }

    public final void run() {
        this.f2362c.O(this.f2360a, false, this.f2361b);
        C0885w4 w4Var = this.f2362c;
        w4Var.f3276e = null;
        w4Var.q().J((C0892x4) null);
    }
}
