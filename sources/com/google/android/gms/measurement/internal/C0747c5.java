package com.google.android.gms.measurement.internal;

import f0.C0917f;

/* renamed from: com.google.android.gms.measurement.internal.c5  reason: case insensitive filesystem */
final class C0747c5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0917f f2931a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0754d5 f2932b;

    C0747c5(C0754d5 d5Var, C0917f fVar) {
        this.f2931a = fVar;
        this.f2932b = d5Var;
    }

    public final void run() {
        synchronized (this.f2932b) {
            try {
                this.f2932b.f2942a = false;
                if (!this.f2932b.f2944c.g0()) {
                    this.f2932b.f2944c.a().K().a("Connected to service");
                    this.f2932b.f2944c.N(this.f2931a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
