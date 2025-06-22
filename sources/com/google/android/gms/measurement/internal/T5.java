package com.google.android.gms.measurement.internal;

import M.C0335p;
import java.util.concurrent.Callable;

final class T5 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f2756a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ H5 f2757b;

    T5(H5 h5, M5 m5) {
        this.f2756a = m5;
        this.f2757b = h5;
    }

    public final /* synthetic */ Object call() {
        if (!this.f2757b.U((String) C0335p.l(this.f2756a.f2631a)).z() || !A3.q(this.f2756a.f2652v).z()) {
            this.f2757b.a().K().a("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        C0744c2 g4 = this.f2757b.g(this.f2756a);
        if (g4 != null) {
            return g4.m();
        }
        this.f2757b.a().L().a("App info was null when attempting to get app instance id");
        return null;
    }
}
