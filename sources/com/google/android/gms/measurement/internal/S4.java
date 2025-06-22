package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;
import android.os.RemoteException;
import f0.C0917f;

final class S4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2745a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Bundle f2746b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ F4 f2747c;

    S4(F4 f4, M5 m5, Bundle bundle) {
        this.f2745a = m5;
        this.f2746b = bundle;
        this.f2747c = f4;
    }

    public final void run() {
        C0917f y4 = this.f2747c.f2397d;
        if (y4 == null) {
            this.f2747c.a().G().a("Failed to send default event parameters to service");
            return;
        }
        try {
            C0335p.l(this.f2745a);
            y4.u(this.f2746b, this.f2745a);
        } catch (RemoteException e5) {
            this.f2747c.a().G().b("Failed to send default event parameters to service", e5);
        }
    }
}
