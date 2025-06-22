package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class P3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2684a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2685b;

    P3(F3 f32, AtomicReference atomicReference) {
        this.f2684a = atomicReference;
        this.f2685b = f32;
    }

    public final void run() {
        synchronized (this.f2684a) {
            try {
                this.f2684a.set(Boolean.valueOf(this.f2685b.b().M(this.f2685b.m().F())));
                this.f2684a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
