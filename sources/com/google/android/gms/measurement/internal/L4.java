package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import f0.C0917f;
import java.util.concurrent.atomic.AtomicReference;

final class L4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2614a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f2615b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ F4 f2616c;

    L4(F4 f4, AtomicReference atomicReference, M5 m5) {
        this.f2614a = atomicReference;
        this.f2615b = m5;
        this.f2616c = f4;
    }

    public final void run() {
        synchronized (this.f2614a) {
            try {
                if (!this.f2616c.e().M().z()) {
                    this.f2616c.a().M().a("Analytics storage consent denied; will not get app instance id");
                    this.f2616c.o().a1((String) null);
                    this.f2616c.e().f3324i.b((String) null);
                    this.f2614a.set((Object) null);
                    this.f2614a.notify();
                    return;
                }
                C0917f y4 = this.f2616c.f2397d;
                if (y4 == null) {
                    this.f2616c.a().G().a("Failed to get app instance id");
                    this.f2614a.notify();
                    return;
                }
                C0335p.l(this.f2615b);
                this.f2614a.set(y4.z(this.f2615b));
                String str = (String) this.f2614a.get();
                if (str != null) {
                    this.f2616c.o().a1(str);
                    this.f2616c.e().f3324i.b(str);
                }
                this.f2616c.m0();
                this.f2614a.notify();
            } catch (RemoteException e5) {
                try {
                    this.f2616c.a().G().b("Failed to get app instance id", e5);
                    this.f2614a.notify();
                } catch (Throwable th) {
                    this.f2614a.notify();
                    throw th;
                }
            }
        }
    }
}
