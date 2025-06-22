package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class I3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ F3 f2581a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Bundle f2582b;

    public /* synthetic */ I3(F3 f32, Bundle bundle) {
        this.f2581a = f32;
        this.f2582b = bundle;
    }

    public final void run() {
        this.f2581a.M(this.f2582b);
    }
}
