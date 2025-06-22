package com.google.android.gms.measurement.internal;

final class V3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ long f2768a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2769b;

    V3(F3 f32, long j4) {
        this.f2768a = j4;
        this.f2769b = f32;
    }

    public final void run() {
        this.f2769b.e().f3328m.b(this.f2768a);
        this.f2769b.a().F().b("Session timeout duration set", Long.valueOf(this.f2768a));
    }
}
