package com.google.android.gms.measurement.internal;

final class A4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f2308a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0885w4 f2309b;

    A4(C0885w4 w4Var, long j4) {
        this.f2308a = j4;
        this.f2309b = w4Var;
    }

    public final void run() {
        this.f2309b.l().s(this.f2308a);
        this.f2309b.f3276e = null;
    }
}
