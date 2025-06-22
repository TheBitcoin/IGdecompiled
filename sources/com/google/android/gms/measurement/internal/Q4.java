package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import f0.C0917f;

final class Q4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f2697a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F4 f2698b;

    Q4(F4 f4, C0892x4 x4Var) {
        this.f2697a = x4Var;
        this.f2698b = f4;
    }

    public final void run() {
        C0917f y4 = this.f2698b.f2397d;
        if (y4 == null) {
            this.f2698b.a().G().a("Failed to send current screen to service");
            return;
        }
        try {
            C0892x4 x4Var = this.f2697a;
            if (x4Var == null) {
                y4.H(0, (String) null, (String) null, this.f2698b.A().getPackageName());
            } else {
                y4.H(x4Var.f3296c, x4Var.f3294a, x4Var.f3295b, this.f2698b.A().getPackageName());
            }
            this.f2698b.m0();
        } catch (RemoteException e5) {
            this.f2698b.a().G().b("Failed to send current screen to the service", e5);
        }
    }
}
