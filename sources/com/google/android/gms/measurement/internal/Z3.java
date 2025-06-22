package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Z3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f2833a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2834b;

    Z3(F3 f32, long j4) {
        this.f2833a = j4;
        this.f2834b = f32;
    }

    public final void run() {
        this.f2834b.M0(this.f2833a);
        this.f2834b.q().Q(new AtomicReference());
    }
}
