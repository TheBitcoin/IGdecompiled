package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.y  reason: case insensitive filesystem */
public final class C0894y extends C0729a1 {

    /* renamed from: b  reason: collision with root package name */
    private final Map f3301b = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map f3302c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    private long f3303d;

    public C0894y(S2 s22) {
        super(s22);
    }

    private final void t(long j4, C0892x4 x4Var) {
        if (x4Var == null) {
            a().K().a("Not logging ad exposure. No active activity");
        } else if (j4 < 1000) {
            a().K().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j4);
            d6.X(x4Var, bundle, true);
            o().b1("am", "_xa", bundle);
        }
    }

    static /* synthetic */ void v(C0894y yVar, String str, long j4) {
        yVar.k();
        C0335p.f(str);
        if (yVar.f3302c.isEmpty()) {
            yVar.f3303d = j4;
        }
        Integer num = (Integer) yVar.f3302c.get(str);
        if (num != null) {
            yVar.f3302c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (yVar.f3302c.size() >= 100) {
            yVar.a().L().a("Too many ads visible");
        } else {
            yVar.f3302c.put(str, 1);
            yVar.f3301b.put(str, Long.valueOf(j4));
        }
    }

    private final void x(String str, long j4, C0892x4 x4Var) {
        if (x4Var == null) {
            a().K().a("Not logging ad unit exposure. No active activity");
        } else if (j4 < 1000) {
            a().K().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j4));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j4);
            d6.X(x4Var, bundle, true);
            o().b1("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void y(long j4) {
        for (String put : this.f3301b.keySet()) {
            this.f3301b.put(put, Long.valueOf(j4));
        }
        if (!this.f3301b.isEmpty()) {
            this.f3303d = j4;
        }
    }

    static /* synthetic */ void z(C0894y yVar, String str, long j4) {
        yVar.k();
        C0335p.f(str);
        Integer num = (Integer) yVar.f3302c.get(str);
        if (num != null) {
            C0892x4 z4 = yVar.p().z(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                yVar.f3302c.remove(str);
                Long l4 = (Long) yVar.f3301b.get(str);
                if (l4 == null) {
                    yVar.a().G().a("First ad unit exposure time was never set");
                } else {
                    yVar.f3301b.remove(str);
                    yVar.x(str, j4 - l4.longValue(), z4);
                }
                if (yVar.f3302c.isEmpty()) {
                    long j5 = yVar.f3303d;
                    if (j5 == 0) {
                        yVar.a().G().a("First ad exposure time was never set");
                        return;
                    }
                    yVar.t(j4 - j5, z4);
                    yVar.f3303d = 0;
                    return;
                }
                return;
            }
            yVar.f3302c.put(str, Integer.valueOf(intValue));
            return;
        }
        yVar.a().G().b("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final void D(String str, long j4) {
        if (str == null || str.length() == 0) {
            a().G().a("Ad unit id must be a non-empty string");
        } else {
            f().D(new C0902z0(this, str, j4));
        }
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ C0894y l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ C0772g2 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0765f2 n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ F3 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0885w4 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ F4 q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ C0838p5 r() {
        return super.r();
    }

    public final void s(long j4) {
        C0892x4 z4 = p().z(false);
        for (String str : this.f3301b.keySet()) {
            x(str, j4 - ((Long) this.f3301b.get(str)).longValue(), z4);
        }
        if (!this.f3301b.isEmpty()) {
            t(j4 - this.f3303d, z4);
        }
        y(j4);
    }

    public final void w(String str, long j4) {
        if (str == null || str.length() == 0) {
            a().G().a("Ad unit id must be a non-empty string");
        } else {
            f().D(new C0727a(this, str, j4));
        }
    }
}
