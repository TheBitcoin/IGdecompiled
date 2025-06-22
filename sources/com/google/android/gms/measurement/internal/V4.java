package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.U0;
import f0.C0917f;

final class V4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ E f2770a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2771b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ U0 f2772c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ F4 f2773d;

    V4(F4 f4, E e5, String str, U0 u02) {
        this.f2770a = e5;
        this.f2771b = str;
        this.f2772c = u02;
        this.f2773d = f4;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            C0917f y4 = this.f2773d.f2397d;
            if (y4 == null) {
                this.f2773d.a().G().a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = y4.d0(this.f2770a, this.f2771b);
            this.f2773d.m0();
            this.f2773d.g().V(this.f2772c, bArr);
        } catch (RemoteException e5) {
            this.f2773d.a().G().b("Failed to send event to the service to bundle", e5);
        } finally {
            this.f2773d.g().V(this.f2772c, bArr);
        }
    }
}
