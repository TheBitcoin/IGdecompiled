package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.h4  reason: case insensitive filesystem */
final class C0781h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f3015a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3016b;

    C0781h4(F3 f32, AtomicReference atomicReference) {
        this.f3015a = atomicReference;
        this.f3016b = f32;
    }

    public final void run() {
        synchronized (this.f3015a) {
            try {
                this.f3015a.set(Integer.valueOf(this.f3016b.b().t(this.f3016b.m().F(), G.f2436Q)));
                this.f3015a.notify();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
