package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Bundle;

final class U5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2763a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2764b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f2765c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ S5 f2766d;

    U5(S5 s5, String str, String str2, Bundle bundle) {
        this.f2763a = str;
        this.f2764b = str2;
        this.f2765c = bundle;
        this.f2766d = s5;
    }

    public final void run() {
        this.f2766d.f2748a.t((E) C0335p.l(this.f2766d.f2748a.y0().H(this.f2763a, this.f2764b, this.f2765c, "auto", this.f2766d.f2748a.B().currentTimeMillis(), false, true)), this.f2763a);
    }
}
