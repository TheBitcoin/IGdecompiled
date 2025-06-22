package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.U0;
import f0.C0917f;

final class P4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2686a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ U0 f2687b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ F4 f2688c;

    P4(F4 f4, M5 m5, U0 u02) {
        this.f2686a = m5;
        this.f2687b = u02;
        this.f2688c = f4;
    }

    public final void run() {
        try {
            if (!this.f2688c.e().M().z()) {
                this.f2688c.a().M().a("Analytics storage consent denied; will not get app instance id");
                this.f2688c.o().a1((String) null);
                this.f2688c.e().f3324i.b((String) null);
                return;
            }
            C0917f y4 = this.f2688c.f2397d;
            if (y4 == null) {
                this.f2688c.a().G().a("Failed to get app instance id");
                this.f2688c.g().S(this.f2687b, (String) null);
                return;
            }
            C0335p.l(this.f2686a);
            String z4 = y4.z(this.f2686a);
            if (z4 != null) {
                this.f2688c.o().a1(z4);
                this.f2688c.e().f3324i.b(z4);
            }
            this.f2688c.m0();
            this.f2688c.g().S(this.f2687b, z4);
        } catch (RemoteException e5) {
            this.f2688c.a().G().b("Failed to get app instance id", e5);
        } finally {
            this.f2688c.g().S(this.f2687b, (String) null);
        }
    }
}
