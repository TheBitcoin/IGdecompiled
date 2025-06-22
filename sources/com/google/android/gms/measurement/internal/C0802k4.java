package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.k4  reason: case insensitive filesystem */
final class C0802k4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3084a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3085b;

    C0802k4(F3 f32, AtomicReference atomicReference) {
        this.f3084a = atomicReference;
        this.f3085b = f32;
    }

    public final void run() {
        synchronized (this.f3084a) {
            try {
                this.f3084a.set(Double.valueOf(this.f3085b.b().l(this.f3085b.m().F(), G.f2438R)));
                this.f3084a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
