package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.U0;

final class U2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U0 f2758a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f2759b;

    U2(AppMeasurementDynamiteService appMeasurementDynamiteService, U0 u02) {
        this.f2758a = u02;
        this.f2759b = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f2759b.f2310a.J().D(this.f2758a);
    }
}
