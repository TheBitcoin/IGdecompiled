package com.google.android.gms.measurement.internal;

final class Y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f2811a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0894y f2812b;

    Y(C0894y yVar, long j4) {
        this.f2811a = j4;
        this.f2812b = yVar;
    }

    public final void run() {
        this.f2812b.y(this.f2811a);
    }
}
