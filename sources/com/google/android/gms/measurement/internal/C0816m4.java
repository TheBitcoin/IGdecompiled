package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.m4  reason: case insensitive filesystem */
final class C0816m4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0873v f3122a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3123b;

    C0816m4(F3 f32, C0873v vVar) {
        this.f3122a = vVar;
        this.f3123b = f32;
    }

    public final void run() {
        if (this.f3123b.e().x(this.f3122a)) {
            this.f3123b.a().K().b("Setting DMA consent(FE)", this.f3122a);
            if (this.f3123b.q().j0()) {
                this.f3123b.q().e0();
            } else {
                this.f3123b.q().U(false);
            }
        } else {
            this.f3123b.a().J().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.f3122a.a()));
        }
    }
}
