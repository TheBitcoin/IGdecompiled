package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.z3  reason: case insensitive filesystem */
abstract class C0905z3 extends C0884w3 {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3342b;

    C0905z3(S2 s22) {
        super(s22);
        this.f3273a.k();
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: protected */
    public final void m() {
        if (!p()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void n() {
        if (this.f3342b) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!q()) {
            this.f3273a.R();
            this.f3342b = true;
        }
    }

    public final void o() {
        if (!this.f3342b) {
            l();
            this.f3273a.R();
            this.f3342b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean p() {
        if (this.f3342b) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean q();
}
