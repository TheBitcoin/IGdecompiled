package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class G3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ F3 f2523a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ AtomicReference f2524b;

    public /* synthetic */ G3(F3 f32, AtomicReference atomicReference) {
        this.f2523a = f32;
        this.f2524b = atomicReference;
    }

    public final void run() {
        this.f2523a.o0(this.f2524b);
    }
}
