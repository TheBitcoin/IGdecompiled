package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.r5  reason: case insensitive filesystem */
final class C0851r5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f3208a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0838p5 f3209b;

    C0851r5(C0838p5 p5Var, long j4) {
        this.f3208a = j4;
        this.f3209b = p5Var;
    }

    public final void run() {
        C0838p5.I(this.f3209b, this.f3208a);
    }
}
