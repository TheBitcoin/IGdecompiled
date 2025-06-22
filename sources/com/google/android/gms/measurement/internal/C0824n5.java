package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.U0;

/* renamed from: com.google.android.gms.measurement.internal.n5  reason: case insensitive filesystem */
final class C0824n5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U0 f3149a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f3150b;

    C0824n5(AppMeasurementDynamiteService appMeasurementDynamiteService, U0 u02) {
        this.f3149a = u02;
        this.f3150b = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f3150b.f2310a.L().U(this.f3149a, this.f3150b.f2310a.l());
    }
}
