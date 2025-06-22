package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

final class M4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService.a f2623a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f2624b;

    M4(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.a aVar) {
        this.f2623a = aVar;
        this.f2624b = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f2624b.f2310a.H().a0(this.f2623a);
    }
}
