package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import f0.C0917f;

final class X4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2804a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F4 f2805b;

    X4(F4 f4, M5 m5) {
        this.f2804a = m5;
        this.f2805b = f4;
    }

    public final void run() {
        C0917f y4 = this.f2805b.f2397d;
        if (y4 == null) {
            this.f2805b.a().G().a("Failed to send consent settings to service");
            return;
        }
        try {
            C0335p.l(this.f2804a);
            y4.v(this.f2804a);
            this.f2805b.m0();
        } catch (RemoteException e5) {
            this.f2805b.a().G().b("Failed to send consent settings to the service", e5);
        }
    }
}
