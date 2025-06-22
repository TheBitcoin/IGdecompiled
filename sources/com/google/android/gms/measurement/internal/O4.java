package com.google.android.gms.measurement.internal;

import M.C0335p;
import N.a;
import android.os.RemoteException;
import f0.C0917f;

final class O4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2669a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F4 f2670b;

    O4(F4 f4, M5 m5) {
        this.f2669a = m5;
        this.f2670b = f4;
    }

    public final void run() {
        C0917f y4 = this.f2670b.f2397d;
        if (y4 == null) {
            this.f2670b.a().G().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            C0335p.l(this.f2669a);
            y4.o(this.f2669a);
            this.f2670b.n().J();
            this.f2670b.O(y4, (a) null, this.f2669a);
            this.f2670b.m0();
        } catch (RemoteException e5) {
            this.f2670b.a().G().b("Failed to send app launch to the service", e5);
        }
    }
}
