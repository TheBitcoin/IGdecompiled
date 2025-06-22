package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Y3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2815a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2816b;

    Y3(F3 f32, AtomicReference atomicReference) {
        this.f2815a = atomicReference;
        this.f2816b = f32;
    }

    public final void run() {
        synchronized (this.f2815a) {
            try {
                this.f2815a.set(this.f2816b.b().G(this.f2816b.m().F()));
                this.f2815a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
