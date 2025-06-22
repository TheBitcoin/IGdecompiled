package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;

/* renamed from: com.google.android.gms.measurement.internal.y5  reason: case insensitive filesystem */
final class C0900y5 {

    /* renamed from: a  reason: collision with root package name */
    private final d f3310a;

    /* renamed from: b  reason: collision with root package name */
    private long f3311b;

    public C0900y5(d dVar) {
        C0335p.l(dVar);
        this.f3310a = dVar;
    }

    public final void a() {
        this.f3311b = 0;
    }

    public final boolean b(long j4) {
        if (this.f3311b != 0 && this.f3310a.elapsedRealtime() - this.f3311b < 3600000) {
            return false;
        }
        return true;
    }

    public final void c() {
        this.f3311b = this.f3310a.elapsedRealtime();
    }
}
