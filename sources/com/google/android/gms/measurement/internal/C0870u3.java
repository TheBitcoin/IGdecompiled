package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.u3  reason: case insensitive filesystem */
final class C0870u3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Y5 f3242a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f3243b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X2 f3244c;

    C0870u3(X2 x22, Y5 y5, M5 m5) {
        this.f3242a = y5;
        this.f3243b = m5;
        this.f3244c = x22;
    }

    public final void run() {
        this.f3244c.f2792a.z0();
        if (this.f3242a.c() == null) {
            this.f3244c.f2792a.H(this.f3242a.f2824b, this.f3243b);
        } else {
            this.f3244c.f2792a.w(this.f3242a, this.f3243b);
        }
    }
}
