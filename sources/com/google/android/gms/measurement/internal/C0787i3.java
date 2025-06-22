package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.i3  reason: case insensitive filesystem */
final class C0787i3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0755e f3024a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f3025b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X2 f3026c;

    C0787i3(X2 x22, C0755e eVar, M5 m5) {
        this.f3024a = eVar;
        this.f3025b = m5;
        this.f3026c = x22;
    }

    public final void run() {
        this.f3026c.f2792a.z0();
        if (this.f3024a.f2955c.c() == null) {
            this.f3026c.f2792a.r(this.f3024a, this.f3025b);
        } else {
            this.f3026c.f2792a.X(this.f3024a, this.f3025b);
        }
    }
}
