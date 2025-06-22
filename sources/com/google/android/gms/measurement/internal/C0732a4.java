package com.google.android.gms.measurement.internal;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* renamed from: com.google.android.gms.measurement.internal.a4  reason: case insensitive filesystem */
final class C0732a4 extends C0859t {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ F3 f2846e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0732a4(F3 f32, C0898y3 y3Var) {
        super(y3Var);
        this.f2846e = f32;
    }

    public final void d() {
        if (this.f2846e.f3273a.r()) {
            this.f2846e.f2392s.b(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }
}
