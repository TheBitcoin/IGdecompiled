package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.U0;

/* renamed from: com.google.android.gms.measurement.internal.o4  reason: case insensitive filesystem */
final class C0830o4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U0 f3163a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3164b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3165c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ AppMeasurementDynamiteService f3166d;

    C0830o4(AppMeasurementDynamiteService appMeasurementDynamiteService, U0 u02, String str, String str2) {
        this.f3163a = u02;
        this.f3164b = str;
        this.f3165c = str2;
        this.f3166d = appMeasurementDynamiteService;
    }

    public final void run() {
        this.f3166d.f2310a.J().F(this.f3163a, this.f3164b, this.f3165c);
    }
}
