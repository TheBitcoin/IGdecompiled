package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.y4  reason: case insensitive filesystem */
final class C0899y4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f3305a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f3306b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f3307c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f3308d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0885w4 f3309e;

    C0899y4(C0885w4 w4Var, C0892x4 x4Var, C0892x4 x4Var2, long j4, boolean z4) {
        this.f3305a = x4Var;
        this.f3306b = x4Var2;
        this.f3307c = j4;
        this.f3308d = z4;
        this.f3309e = w4Var;
    }

    public final void run() {
        this.f3309e.N(this.f3305a, this.f3306b, this.f3307c, this.f3308d, (Bundle) null);
    }
}
