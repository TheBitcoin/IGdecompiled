package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.u5  reason: case insensitive filesystem */
final class C0872u5 {

    /* renamed from: a  reason: collision with root package name */
    private long f3250a;

    /* renamed from: b  reason: collision with root package name */
    protected long f3251b;

    /* renamed from: c  reason: collision with root package name */
    private final C0859t f3252c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ C0838p5 f3253d;

    public C0872u5(C0838p5 p5Var) {
        this.f3253d = p5Var;
        this.f3252c = new C0893x5(this, p5Var.f3273a);
        long elapsedRealtime = p5Var.B().elapsedRealtime();
        this.f3250a = elapsedRealtime;
        this.f3251b = elapsedRealtime;
    }

    static /* synthetic */ void c(C0872u5 u5Var) {
        u5Var.f3253d.k();
        u5Var.d(false, false, u5Var.f3253d.B().elapsedRealtime());
        u5Var.f3253d.l().s(u5Var.f3253d.B().elapsedRealtime());
    }

    /* access modifiers changed from: package-private */
    public final long a(long j4) {
        long j5 = j4 - this.f3251b;
        this.f3251b = j4;
        return j5;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.f3252c.a();
        if (this.f3253d.b().q(G.f2464c1)) {
            this.f3250a = this.f3253d.B().elapsedRealtime();
        } else {
            this.f3250a = 0;
        }
        this.f3251b = this.f3250a;
    }

    public final boolean d(boolean z4, boolean z5, long j4) {
        this.f3253d.k();
        this.f3253d.s();
        if (this.f3253d.f3273a.m()) {
            this.f3253d.e().f3333r.b(this.f3253d.B().currentTimeMillis());
        }
        long j5 = j4 - this.f3250a;
        if (z4 || j5 >= 1000) {
            if (!z5) {
                j5 = a(j4);
            }
            this.f3253d.a().K().b("Recording user engagement, ms", Long.valueOf(j5));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j5);
            d6.X(this.f3253d.p().z(!this.f3253d.b().V()), bundle, true);
            if (!z5) {
                this.f3253d.o().b1("auto", "_e", bundle);
            }
            this.f3250a = j4;
            this.f3252c.a();
            this.f3252c.b(((Long) G.f2466d0.a((Object) null)).longValue());
            return true;
        }
        this.f3253d.a().K().b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j5));
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void e(long j4) {
        this.f3252c.a();
    }

    /* access modifiers changed from: package-private */
    public final void f(long j4) {
        this.f3253d.k();
        this.f3252c.a();
        this.f3250a = j4;
        this.f3251b = j4;
    }
}
