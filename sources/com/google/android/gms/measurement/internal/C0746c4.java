package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.c4  reason: case insensitive filesystem */
final class C0746c4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f2929a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2930b;

    C0746c4(F3 f32, Bundle bundle) {
        this.f2929a = bundle;
        this.f2930b = f32;
    }

    public final void run() {
        F3.Q0(this.f2930b, this.f2929a);
    }
}
