package com.google.android.gms.measurement.internal;

final class T3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f2753a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2754b;

    T3(F3 f32, boolean z4) {
        this.f2753a = z4;
        this.f2754b = f32;
    }

    public final void run() {
        boolean m4 = this.f2754b.f3273a.m();
        boolean l4 = this.f2754b.f3273a.l();
        this.f2754b.f3273a.j(this.f2753a);
        if (l4 == this.f2753a) {
            this.f2754b.f3273a.a().K().b("Default data collection state already set to", Boolean.valueOf(this.f2753a));
        }
        if (this.f2754b.f3273a.m() == m4 || this.f2754b.f3273a.m() != this.f2754b.f3273a.l()) {
            this.f2754b.f3273a.a().M().c("Default data collection is different than actual status", Boolean.valueOf(this.f2753a), Boolean.valueOf(m4));
        }
        this.f2754b.K0();
    }
}
