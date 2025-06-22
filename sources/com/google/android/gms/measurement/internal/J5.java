package com.google.android.gms.measurement.internal;

final class J5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ W5 f2600a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ H5 f2601b;

    J5(H5 h5, W5 w5) {
        this.f2600a = w5;
        this.f2601b = h5;
    }

    public final void run() {
        H5.v(this.f2601b, this.f2600a);
        this.f2601b.D0();
    }
}
