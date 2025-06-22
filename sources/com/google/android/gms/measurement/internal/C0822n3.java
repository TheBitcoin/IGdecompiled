package com.google.android.gms.measurement.internal;

import M.C0335p;

/* renamed from: com.google.android.gms.measurement.internal.n3  reason: case insensitive filesystem */
final class C0822n3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f3146a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ X2 f3147b;

    C0822n3(X2 x22, M5 m5) {
        this.f3146a = m5;
        this.f3147b = x22;
    }

    public final void run() {
        this.f3147b.f2792a.z0();
        H5 i4 = this.f3147b.f2792a;
        M5 m5 = this.f3146a;
        i4.f().k();
        i4.A0();
        C0335p.f(m5.f2631a);
        i4.o0(m5);
        i4.m0(m5);
    }
}
