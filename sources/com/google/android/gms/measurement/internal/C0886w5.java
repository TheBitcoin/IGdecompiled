package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.w5  reason: case insensitive filesystem */
final class C0886w5 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0838p5 f3284a;

    C0886w5(C0838p5 p5Var) {
        this.f3284a = p5Var;
    }

    private final void c(long j4, boolean z4) {
        this.f3284a.k();
        if (this.f3284a.f3273a.m()) {
            this.f3284a.e().f3333r.b(j4);
            this.f3284a.a().K().b("Session started, time", Long.valueOf(this.f3284a.B().elapsedRealtime()));
            long j5 = j4 / 1000;
            long j6 = j4;
            this.f3284a.o().k0("auto", "_sid", Long.valueOf(j5), j6);
            long j7 = j6;
            this.f3284a.e().f3334s.b(j5);
            this.f3284a.e().f3329n.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j5);
            this.f3284a.o().e0("auto", "_s", j7, bundle);
            String a5 = this.f3284a.e().f3339x.a();
            if (!TextUtils.isEmpty(a5)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", a5);
                this.f3284a.o().e0("auto", "_ssr", j7, bundle2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f3284a.k();
        if (this.f3284a.e().w(this.f3284a.B().currentTimeMillis())) {
            this.f3284a.e().f3329n.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f3284a.a().K().a("Detected application was in foreground");
                c(this.f3284a.B().currentTimeMillis(), false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j4, boolean z4) {
        this.f3284a.k();
        this.f3284a.G();
        if (this.f3284a.e().w(j4)) {
            this.f3284a.e().f3329n.a(true);
            this.f3284a.m().I();
        }
        this.f3284a.e().f3333r.b(j4);
        if (this.f3284a.e().f3329n.b()) {
            c(j4, z4);
        }
    }
}
