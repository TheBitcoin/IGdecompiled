package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* renamed from: com.google.android.gms.measurement.internal.t5  reason: case insensitive filesystem */
final class C0865t5 {

    /* renamed from: a  reason: collision with root package name */
    private C0858s5 f3234a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0838p5 f3235b;

    C0865t5(C0838p5 p5Var) {
        this.f3235b = p5Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f3235b.k();
        if (this.f3234a != null) {
            this.f3235b.f3186c.removeCallbacks(this.f3234a);
        }
        this.f3235b.e().f3336u.a(false);
        this.f3235b.D(false);
        if (this.f3235b.b().q(G.f2429M0) && this.f3235b.o().J0()) {
            this.f3235b.a().K().a("Retrying trigger URI registration in foreground");
            this.f3235b.o().H0();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j4) {
        this.f3234a = new C0858s5(this, this.f3235b.B().currentTimeMillis(), j4);
        this.f3235b.f3186c.postDelayed(this.f3234a, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }
}
