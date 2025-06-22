package com.google.android.gms.measurement.internal;

import M.C0335p;

/* renamed from: com.google.android.gms.measurement.internal.e3  reason: case insensitive filesystem */
final class C0759e3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2964a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ X2 f2965b;

    C0759e3(X2 x22, M5 m5) {
        this.f2964a = m5;
        this.f2965b = x22;
    }

    public final void run() {
        this.f2965b.f2792a.z0();
        H5 i4 = this.f2965b.f2792a;
        M5 m5 = this.f2964a;
        i4.f().k();
        i4.A0();
        C0335p.f(m5.f2631a);
        i4.g(m5);
    }
}
