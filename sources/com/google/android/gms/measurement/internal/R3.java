package com.google.android.gms.measurement.internal;

import android.util.SparseArray;
import o0.C2169a;

final class R3 implements C2169a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ B5 f2702a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f2703b;

    R3(F3 f32, B5 b5) {
        this.f2702a = b5;
        this.f2703b = f32;
    }

    private final void c() {
        SparseArray K4 = this.f2703b.e().K();
        B5 b5 = this.f2702a;
        K4.put(b5.f2334c, Long.valueOf(b5.f2333b));
        this.f2703b.e().s(K4);
    }

    public final void a(Object obj) {
        this.f2703b.k();
        if (this.f2703b.b().q(G.f2433O0)) {
            c();
            this.f2703b.f2382i = false;
            this.f2703b.f2383j = 1;
            this.f2703b.a().F().b("Successfully registered trigger URI", this.f2702a.f2332a);
            this.f2703b.H0();
            return;
        }
        this.f2703b.f2382i = false;
        this.f2703b.H0();
        this.f2703b.a().F().b("registerTriggerAsync ran. uri", this.f2702a.f2332a);
    }

    public final void b(Throwable th) {
        int i4;
        this.f2703b.k();
        this.f2703b.f2382i = false;
        if (!this.f2703b.b().q(G.f2433O0)) {
            this.f2703b.H0();
            this.f2703b.a().G().b("registerTriggerAsync failed with throwable", th);
            return;
        }
        if (this.f2703b.b().q(G.f2429M0)) {
            i4 = F3.z(this.f2703b, th);
        } else {
            i4 = 2;
        }
        int i5 = i4 - 1;
        if (i5 == 0) {
            this.f2703b.a().L().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", C0821n2.s(this.f2703b.m().F()), C0821n2.s(th.toString()));
            this.f2703b.f2383j = 1;
            this.f2703b.A0().add(this.f2702a);
        } else if (i5 == 1) {
            this.f2703b.A0().add(this.f2702a);
            if (this.f2703b.f2383j > 32) {
                this.f2703b.f2383j = 1;
                this.f2703b.a().L().c("registerTriggerAsync failed. May try later. App ID, throwable", C0821n2.s(this.f2703b.m().F()), C0821n2.s(th.toString()));
                return;
            }
            this.f2703b.a().L().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", C0821n2.s(this.f2703b.m().F()), C0821n2.s(String.valueOf(this.f2703b.f2383j)), C0821n2.s(th.toString()));
            F3 f32 = this.f2703b;
            F3.P0(f32, f32.f2383j);
            F3 f33 = this.f2703b;
            f33.f2383j = f33.f2383j << 1;
        } else if (i5 == 2) {
            this.f2703b.a().G().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", C0821n2.s(this.f2703b.m().F()), th);
            c();
            this.f2703b.f2383j = 1;
            this.f2703b.H0();
        }
    }
}
