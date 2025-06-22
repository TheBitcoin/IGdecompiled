package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C0576h6;

/* renamed from: com.google.android.gms.measurement.internal.l4  reason: case insensitive filesystem */
final class C0809l4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ A3 f3103a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f3104b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f3105c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ boolean f3106d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ A3 f3107e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F3 f3108f;

    C0809l4(F3 f32, A3 a32, long j4, long j5, boolean z4, A3 a33) {
        this.f3103a = a32;
        this.f3104b = j4;
        this.f3105c = j5;
        this.f3106d = z4;
        this.f3107e = a33;
        this.f3108f = f32;
    }

    public final void run() {
        this.f3108f.R(this.f3103a);
        if (!C0576h6.a() || !this.f3108f.b().q(G.f2453Y0)) {
            this.f3108f.J(this.f3104b, false);
        }
        F3.V(this.f3108f, this.f3103a, this.f3105c, true, this.f3106d);
        F3.W(this.f3108f, this.f3103a, this.f3107e);
    }
}
