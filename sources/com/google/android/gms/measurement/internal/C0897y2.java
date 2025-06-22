package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.y2  reason: case insensitive filesystem */
abstract class C0897y2 extends C0729a1 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3304b;

    C0897y2(S2 s22) {
        super(s22);
        this.f3273a.k();
    }

    /* access modifiers changed from: protected */
    public final void s() {
        if (!w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void t() {
        if (this.f3304b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!x()) {
            this.f3273a.R();
            this.f3304b = true;
        }
    }

    public final void u() {
        if (!this.f3304b) {
            v();
            this.f3273a.R();
            this.f3304b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    /* access modifiers changed from: package-private */
    public final boolean w() {
        if (this.f3304b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean x();
}
