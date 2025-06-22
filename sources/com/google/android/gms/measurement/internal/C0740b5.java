package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.U0;
import f0.C0917f;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.b5  reason: case insensitive filesystem */
final class C0740b5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2877a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2878b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ M5 f2879c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ U0 f2880d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ F4 f2881e;

    C0740b5(F4 f4, String str, String str2, M5 m5, U0 u02) {
        this.f2877a = str;
        this.f2878b = str2;
        this.f2879c = m5;
        this.f2880d = u02;
        this.f2881e = f4;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        try {
            C0917f y4 = this.f2881e.f2397d;
            if (y4 == null) {
                this.f2881e.a().G().c("Failed to get conditional properties; not connected to service", this.f2877a, this.f2878b);
                return;
            }
            C0335p.l(this.f2879c);
            arrayList = d6.t0(y4.l(this.f2877a, this.f2878b, this.f2879c));
            this.f2881e.m0();
            this.f2881e.g().T(this.f2880d, arrayList);
        } catch (RemoteException e5) {
            this.f2881e.a().G().d("Failed to get conditional properties; remote exception", this.f2877a, this.f2878b, e5);
        } finally {
            this.f2881e.g().T(this.f2880d, arrayList);
        }
    }
}
