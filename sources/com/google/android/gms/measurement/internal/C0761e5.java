package com.google.android.gms.measurement.internal;

import f0.C0917f;

/* renamed from: com.google.android.gms.measurement.internal.e5  reason: case insensitive filesystem */
final class C0761e5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0917f f2971a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0754d5 f2972b;

    C0761e5(C0754d5 d5Var, C0917f fVar) {
        this.f2971a = fVar;
        this.f2972b = d5Var;
    }

    public final void run() {
        synchronized (this.f2972b) {
            try {
                this.f2972b.f2942a = false;
                if (!this.f2972b.f2944c.g0()) {
                    this.f2972b.f2944c.a().F().a("Connected to remote service");
                    this.f2972b.f2944c.N(this.f2971a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
