package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.U0;

final class O3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U0 f2665a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ E f2666b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2667c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f2668d;

    O3(AppMeasurementDynamiteService appMeasurementDynamiteService, U0 u02, E e5, String str) {
        this.f2665a = u02;
        this.f2666b = e5;
        this.f2667c = str;
        this.f2668d = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f2668d.f2310a.J().E(this.f2665a, this.f2666b, this.f2667c);
    }
}
