package com.google.android.gms.measurement.internal;

final class Y2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ D3 f2813a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ S2 f2814b;

    Y2(S2 s22, D3 d32) {
        this.f2813a = d32;
        this.f2814b = s22;
    }

    public final void run() {
        S2.e(this.f2814b, this.f2813a);
        this.f2814b.c(this.f2813a.f2356g);
    }
}
