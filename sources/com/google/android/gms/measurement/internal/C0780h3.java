package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.h3  reason: case insensitive filesystem */
final class C0780h3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0755e f3013a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ X2 f3014b;

    C0780h3(X2 x22, C0755e eVar) {
        this.f3013a = eVar;
        this.f3014b = x22;
    }

    public final void run() {
        this.f3014b.f2792a.z0();
        if (this.f3013a.f2955c.c() == null) {
            this.f3014b.f2792a.q(this.f3013a);
        } else {
            this.f3014b.f2792a.W(this.f3013a);
        }
    }
}
