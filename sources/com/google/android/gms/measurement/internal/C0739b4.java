package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.b4  reason: case insensitive filesystem */
final class C0739b4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f2875a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2876b;

    C0739b4(F3 f32, Bundle bundle) {
        this.f2875a = bundle;
        this.f2876b = f32;
    }

    public final void run() {
        F3.U(this.f2876b, this.f2875a);
    }
}
