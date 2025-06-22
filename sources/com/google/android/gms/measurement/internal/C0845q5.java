package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.q5  reason: case insensitive filesystem */
final class C0845q5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f3198a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0838p5 f3199b;

    C0845q5(C0838p5 p5Var, long j4) {
        this.f3198a = j4;
        this.f3199b = p5Var;
    }

    public final void run() {
        C0838p5.z(this.f3199b, this.f3198a);
    }
}
