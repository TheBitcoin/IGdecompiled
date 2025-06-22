package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v2  reason: case insensitive filesystem */
final class C0876v2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f3260a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0883w2 f3261b;

    C0876v2(C0883w2 w2Var, boolean z4) {
        this.f3260a = z4;
        this.f3261b = w2Var;
    }

    public final void run() {
        this.f3261b.f3270a.K(this.f3260a);
    }
}
