package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;
import android.os.RemoteException;
import f0.C0917f;
import java.util.concurrent.atomic.AtomicReference;

final class K4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2606a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f2607b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f2608c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ F4 f2609d;

    K4(F4 f4, AtomicReference atomicReference, M5 m5, Bundle bundle) {
        this.f2606a = atomicReference;
        this.f2607b = m5;
        this.f2608c = bundle;
        this.f2609d = f4;
    }

    public final void run() {
        synchronized (this.f2606a) {
            try {
                C0917f y4 = this.f2609d.f2397d;
                if (y4 == null) {
                    this.f2609d.a().G().a("Failed to get trigger URIs; not connected to service");
                    this.f2606a.notify();
                    return;
                }
                C0335p.l(this.f2607b);
                this.f2606a.set(y4.c0(this.f2607b, this.f2608c));
                this.f2609d.m0();
                this.f2606a.notify();
            } catch (RemoteException e5) {
                try {
                    this.f2609d.a().G().b("Failed to get trigger URIs; remote exception", e5);
                    this.f2606a.notify();
                } catch (Throwable th) {
                    this.f2606a.notify();
                    throw th;
                }
            }
        }
    }
}
