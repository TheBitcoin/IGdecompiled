package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.z4  reason: case insensitive filesystem */
final class C0906z4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Bundle f3343a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f3344b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0892x4 f3345c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f3346d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0885w4 f3347e;

    C0906z4(C0885w4 w4Var, Bundle bundle, C0892x4 x4Var, C0892x4 x4Var2, long j4) {
        this.f3343a = bundle;
        this.f3344b = x4Var;
        this.f3345c = x4Var2;
        this.f3346d = j4;
        this.f3347e = w4Var;
    }

    public final void run() {
        C0885w4.J(this.f3347e, this.f3343a, this.f3344b, this.f3345c, this.f3346d);
    }
}
