package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.m5  reason: case insensitive filesystem */
final class C0817m5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ H5 f3124a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Runnable f3125b;

    C0817m5(C0810l5 l5Var, H5 h5, Runnable runnable) {
        this.f3124a = h5;
        this.f3125b = runnable;
    }

    public final void run() {
        this.f3124a.z0();
        this.f3124a.x(this.f3125b);
        this.f3124a.E0();
    }
}
