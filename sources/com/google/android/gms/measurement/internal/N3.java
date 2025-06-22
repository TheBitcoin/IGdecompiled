package com.google.android.gms.measurement.internal;

import java.util.concurrent.Executor;

final class N3 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ F3 f2658a;

    N3(F3 f32) {
        this.f2658a = f32;
    }

    public final void execute(Runnable runnable) {
        this.f2658a.f().D(runnable);
    }
}
