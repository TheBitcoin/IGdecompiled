package com.google.android.gms.measurement.internal;

import j$.util.Objects;

public final /* synthetic */ class f6 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ S2 f2983a;

    public /* synthetic */ f6(S2 s22) {
        this.f2983a = s22;
    }

    public final void run() {
        S2 s22 = this.f2983a;
        if (!s22.L().X0()) {
            s22.a().L().a("registerTrigger called but app not eligible");
            return;
        }
        F3 H4 = s22.H();
        Objects.requireNonNull(H4);
        new Thread(new g6(H4)).start();
    }
}
