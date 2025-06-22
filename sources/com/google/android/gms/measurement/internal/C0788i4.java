package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.i4  reason: case insensitive filesystem */
final class C0788i4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3027a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3028b;

    C0788i4(F3 f32, AtomicReference atomicReference) {
        this.f3027a = atomicReference;
        this.f3028b = f32;
    }

    public final void run() {
        synchronized (this.f3027a) {
            try {
                this.f3027a.set(Long.valueOf(this.f3028b.b().x(this.f3028b.m().F(), G.f2434P)));
                this.f3027a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
