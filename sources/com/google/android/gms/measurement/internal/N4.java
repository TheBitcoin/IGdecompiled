package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import f0.C0917f;

final class N4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2659a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F4 f2660b;

    N4(F4 f4, M5 m5) {
        this.f2659a = m5;
        this.f2660b = f4;
    }

    public final void run() {
        C0917f y4 = this.f2660b.f2397d;
        if (y4 == null) {
            this.f2660b.a().G().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            C0335p.l(this.f2659a);
            y4.t(this.f2659a);
        } catch (RemoteException e5) {
            this.f2660b.a().G().b("Failed to reset data on the service: remote exception", e5);
        }
        this.f2660b.m0();
    }
}
