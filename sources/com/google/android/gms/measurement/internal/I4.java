package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.U0;
import f0.C0917f;

final class I4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2583a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2584b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ M5 f2585c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f2586d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ U0 f2587e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F4 f2588f;

    I4(F4 f4, String str, String str2, M5 m5, boolean z4, U0 u02) {
        this.f2583a = str;
        this.f2584b = str2;
        this.f2585c = m5;
        this.f2586d = z4;
        this.f2587e = u02;
        this.f2588f = f4;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            C0917f y4 = this.f2588f.f2397d;
            if (y4 == null) {
                this.f2588f.a().G().c("Failed to get user properties; not connected to service", this.f2583a, this.f2584b);
                return;
            }
            C0335p.l(this.f2585c);
            bundle = d6.G(y4.Z(this.f2583a, this.f2584b, this.f2586d, this.f2585c));
            this.f2588f.m0();
            this.f2588f.g().R(this.f2587e, bundle);
        } catch (RemoteException e5) {
            this.f2588f.a().G().c("Failed to get user properties; remote exception", this.f2583a, e5);
        } finally {
            this.f2588f.g().R(this.f2587e, bundle);
        }
    }
}
