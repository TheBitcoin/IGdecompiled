package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import android.text.TextUtils;
import f0.C0917f;

final class Z4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f2835a = true;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ M5 f2836b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f2837c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C0755e f2838d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0755e f2839e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F4 f2840f;

    Z4(F4 f4, boolean z4, M5 m5, boolean z5, C0755e eVar, C0755e eVar2) {
        this.f2836b = m5;
        this.f2837c = z5;
        this.f2838d = eVar;
        this.f2839e = eVar2;
        this.f2840f = f4;
    }

    public final void run() {
        C0755e eVar;
        C0917f y4 = this.f2840f.f2397d;
        if (y4 == null) {
            this.f2840f.a().G().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f2835a) {
            C0335p.l(this.f2836b);
            F4 f4 = this.f2840f;
            if (this.f2837c) {
                eVar = null;
            } else {
                eVar = this.f2838d;
            }
            f4.O(y4, eVar, this.f2836b);
        } else {
            try {
                if (TextUtils.isEmpty(this.f2839e.f2953a)) {
                    C0335p.l(this.f2836b);
                    y4.G(this.f2838d, this.f2836b);
                } else {
                    y4.L(this.f2838d);
                }
            } catch (RemoteException e5) {
                this.f2840f.a().G().b("Failed to send conditional user property to the service", e5);
            }
        }
        this.f2840f.m0();
    }
}
