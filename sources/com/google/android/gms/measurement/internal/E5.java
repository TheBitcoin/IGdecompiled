package com.google.android.gms.measurement.internal;

abstract class E5 extends F5 {

    /* renamed from: c  reason: collision with root package name */
    private boolean f2372c;

    E5(H5 h5) {
        super(h5);
        this.f2403b.C0();
    }

    /* access modifiers changed from: protected */
    public final void r() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void s() {
        if (!this.f2372c) {
            u();
            this.f2403b.B0();
            this.f2372c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean t() {
        if (this.f2372c) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean u();
}
