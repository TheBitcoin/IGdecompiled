package com.google.android.gms.measurement.internal;

import M.C0335p;
import f0.C0917f;

final class J4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2596a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f2597b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Y5 f2598c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ F4 f2599d;

    J4(F4 f4, M5 m5, boolean z4, Y5 y5) {
        this.f2596a = m5;
        this.f2597b = z4;
        this.f2598c = y5;
        this.f2599d = f4;
    }

    public final void run() {
        Y5 y5;
        C0917f y4 = this.f2599d.f2397d;
        if (y4 == null) {
            this.f2599d.a().G().a("Discarding data. Failed to set user property");
            return;
        }
        C0335p.l(this.f2596a);
        F4 f4 = this.f2599d;
        if (this.f2597b) {
            y5 = null;
        } else {
            y5 = this.f2598c;
        }
        f4.O(y4, y5, this.f2596a);
        this.f2599d.m0();
    }
}
