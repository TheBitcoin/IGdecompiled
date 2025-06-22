package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import f0.C0917f;

final class R4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2704a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F4 f2705b;

    R4(F4 f4, M5 m5) {
        this.f2704a = m5;
        this.f2705b = f4;
    }

    public final void run() {
        C0917f y4 = this.f2705b.f2397d;
        if (y4 == null) {
            this.f2705b.a().L().a("Failed to send app backgrounded");
            return;
        }
        try {
            C0335p.l(this.f2704a);
            y4.J(this.f2704a);
            this.f2705b.m0();
        } catch (RemoteException e5) {
            this.f2705b.a().G().b("Failed to send app backgrounded to the service", e5);
        }
    }
}
