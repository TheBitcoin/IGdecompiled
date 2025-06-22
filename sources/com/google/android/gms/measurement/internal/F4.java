package com.google.android.gms.measurement.internal;

import J.C0313l;
import M.C0335p;
import N.a;
import Q.b;
import R.d;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.C0576h6;
import com.google.android.gms.internal.measurement.U0;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.C0913b;
import f0.C0917f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class F4 extends C0897y2 {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C0754d5 f2396c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public C0917f f2397d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f2398e;

    /* renamed from: f  reason: collision with root package name */
    private final C0859t f2399f;

    /* renamed from: g  reason: collision with root package name */
    private final C0900y5 f2400g;

    /* renamed from: h  reason: collision with root package name */
    private final List f2401h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final C0859t f2402i;

    protected F4(S2 s22) {
        super(s22);
        this.f2400g = new C0900y5(s22.B());
        this.f2396c = new C0754d5(this);
        this.f2399f = new G4(this, s22);
        this.f2402i = new T4(this, s22);
    }

    static /* synthetic */ void K(F4 f4, ComponentName componentName) {
        f4.k();
        if (f4.f2397d != null) {
            f4.f2397d = null;
            f4.a().K().b("Disconnected from device MeasurementService", componentName);
            f4.k();
            f4.Z();
        }
    }

    private final void P(Runnable runnable) {
        k();
        if (g0()) {
            runnable.run();
        } else if (((long) this.f2401h.size()) >= 1000) {
            a().G().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f2401h.add(runnable);
            this.f2402i.b(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            Z();
        }
    }

    /* access modifiers changed from: private */
    public final void l0() {
        k();
        a().K().b("Processing queued up service tasks", Integer.valueOf(this.f2401h.size()));
        for (Runnable run : this.f2401h) {
            try {
                run.run();
            } catch (RuntimeException e5) {
                a().G().b("Task exception while flushing queue", e5);
            }
        }
        this.f2401h.clear();
        this.f2402i.a();
    }

    /* access modifiers changed from: private */
    public final void m0() {
        k();
        this.f2400g.c();
        this.f2399f.b(((Long) G.f2428M.a((Object) null)).longValue());
    }

    private final M5 p0(boolean z4) {
        String str;
        C0772g2 m4 = m();
        if (z4) {
            str = a().O();
        } else {
            str = null;
        }
        return m4.y(str);
    }

    static /* synthetic */ void r0(F4 f4) {
        f4.k();
        if (f4.g0()) {
            f4.a().K().a("Inactivity, disconnecting from the service");
            f4.a0();
        }
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

    public final void D(U0 u02) {
        k();
        s();
        P(new P4(this, p0(false), u02));
    }

    public final void E(U0 u02, E e5, String str) {
        k();
        s();
        if (g().r(C0313l.f342a) != 0) {
            a().L().a("Not bundling data. Service unavailable or out of date");
            g().V(u02, new byte[0]);
            return;
        }
        P(new V4(this, e5, str, u02));
    }

    /* access modifiers changed from: protected */
    public final void F(U0 u02, String str, String str2) {
        k();
        s();
        P(new C0740b5(this, str, str2, p0(false), u02));
    }

    /* access modifiers changed from: protected */
    public final void G(U0 u02, String str, String str2, boolean z4) {
        k();
        s();
        P(new I4(this, str, str2, p0(false), z4, u02));
    }

    /* access modifiers changed from: protected */
    public final void H(C0755e eVar) {
        C0335p.l(eVar);
        k();
        s();
        P(new Z4(this, true, p0(true), n().E(eVar), new C0755e(eVar), eVar));
    }

    /* access modifiers changed from: protected */
    public final void I(E e5, String str) {
        C0335p.l(e5);
        k();
        s();
        P(new W4(this, true, p0(true), n().F(e5), e5, str));
    }

    /* access modifiers changed from: protected */
    public final void J(C0892x4 x4Var) {
        k();
        s();
        P(new Q4(this, x4Var));
    }

    /* access modifiers changed from: protected */
    public final void M(Y5 y5) {
        k();
        s();
        P(new J4(this, p0(true), n().G(y5), y5));
    }

    /* access modifiers changed from: protected */
    public final void N(C0917f fVar) {
        k();
        C0335p.l(fVar);
        this.f2397d = fVar;
        m0();
        l0();
    }

    /* access modifiers changed from: package-private */
    public final void O(C0917f fVar, a aVar, M5 m5) {
        int i4;
        long j4;
        long j5;
        C0917f fVar2 = fVar;
        a aVar2 = aVar;
        M5 m52 = m5;
        k();
        s();
        int i5 = 100;
        int i6 = 100;
        int i7 = 0;
        while (i7 < 1001 && i6 == i5) {
            ArrayList arrayList = new ArrayList();
            List z4 = n().z(i5);
            if (z4 != null) {
                arrayList.addAll(z4);
                i4 = z4.size();
            } else {
                i4 = 0;
            }
            if (aVar2 != null && i4 < i5) {
                arrayList.add(aVar2);
            }
            boolean q4 = b().q(G.f2415F0);
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                int i9 = i8 + 1;
                a aVar3 = (a) arrayList.get(i8);
                if (aVar3 instanceof E) {
                    if (q4) {
                        try {
                            long currentTimeMillis = this.f3273a.B().currentTimeMillis();
                            try {
                                j4 = this.f3273a.B().elapsedRealtime();
                                j5 = currentTimeMillis;
                            } catch (RemoteException e5) {
                                e = e5;
                                j4 = 0;
                                j5 = currentTimeMillis;
                                a().G().b("Failed to send event to the service", e);
                                if (q4 && j5 != 0) {
                                    C0807l2.a(this.f3273a).b(36301, 13, j5, this.f3273a.B().currentTimeMillis(), (int) (this.f3273a.B().elapsedRealtime() - j4));
                                }
                                i8 = i9;
                            }
                        } catch (RemoteException e6) {
                            e = e6;
                            j5 = 0;
                            j4 = 0;
                            a().G().b("Failed to send event to the service", e);
                            C0807l2.a(this.f3273a).b(36301, 13, j5, this.f3273a.B().currentTimeMillis(), (int) (this.f3273a.B().elapsedRealtime() - j4));
                            i8 = i9;
                        }
                    } else {
                        j5 = 0;
                        j4 = 0;
                    }
                    try {
                        fVar2.i0((E) aVar3, m52);
                        if (q4) {
                            a().K().a("Logging telemetry for logEvent from database");
                            C0807l2.a(this.f3273a).b(36301, 0, j5, this.f3273a.B().currentTimeMillis(), (int) (this.f3273a.B().elapsedRealtime() - j4));
                        }
                    } catch (RemoteException e7) {
                        e = e7;
                        a().G().b("Failed to send event to the service", e);
                        C0807l2.a(this.f3273a).b(36301, 13, j5, this.f3273a.B().currentTimeMillis(), (int) (this.f3273a.B().elapsedRealtime() - j4));
                        i8 = i9;
                    }
                } else if (aVar3 instanceof Y5) {
                    try {
                        fVar2.w((Y5) aVar3, m52);
                    } catch (RemoteException e8) {
                        a().G().b("Failed to send user property to the service", e8);
                    }
                } else if (aVar3 instanceof C0755e) {
                    try {
                        fVar2.G((C0755e) aVar3, m52);
                    } catch (RemoteException e9) {
                        a().G().b("Failed to send conditional user property to the service", e9);
                    }
                } else {
                    a().G().a("Discarding data. Unrecognized parcel type.");
                }
                i8 = i9;
            }
            i7++;
            i6 = i4;
            i5 = 100;
        }
    }

    public final void Q(AtomicReference atomicReference) {
        k();
        s();
        P(new L4(this, atomicReference, p0(false)));
    }

    /* access modifiers changed from: protected */
    public final void R(AtomicReference atomicReference, Bundle bundle) {
        k();
        s();
        P(new K4(this, atomicReference, p0(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void S(AtomicReference atomicReference, String str, String str2, String str3) {
        k();
        s();
        P(new Y4(this, atomicReference, str, str2, str3, p0(false)));
    }

    /* access modifiers changed from: protected */
    public final void T(AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        k();
        s();
        P(new C0733a5(this, atomicReference, str, str2, str3, p0(false), z4));
    }

    /* access modifiers changed from: protected */
    public final void U(boolean z4) {
        k();
        s();
        if ((!C0576h6.a() || !b().q(G.f2453Y0)) && z4) {
            n().H();
        }
        if (i0()) {
            P(new X4(this, p0(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final C0913b V() {
        k();
        s();
        C0917f fVar = this.f2397d;
        if (fVar == null) {
            Z();
            a().F().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        M5 p02 = p0(false);
        C0335p.l(p02);
        try {
            C0913b X4 = fVar.X(p02);
            m0();
            return X4;
        } catch (RemoteException e5) {
            a().G().b("Failed to get consents; remote exception", e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean W() {
        return this.f2398e;
    }

    /* access modifiers changed from: protected */
    public final void X() {
        k();
        s();
        P(new R4(this, p0(true)));
    }

    /* access modifiers changed from: protected */
    public final void Y() {
        k();
        s();
        M5 p02 = p0(true);
        n().I();
        P(new O4(this, p02));
    }

    /* access modifiers changed from: package-private */
    public final void Z() {
        k();
        s();
        if (!g0()) {
            if (k0()) {
                this.f2396c.a();
            } else if (!b().X()) {
                List<ResolveInfo> queryIntentServices = A().getPackageManager().queryIntentServices(new Intent().setClassName(A(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    a().G().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(A(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.f2396c.b(intent);
            }
        }
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final void a0() {
        k();
        s();
        this.f2396c.d();
        try {
            b.b().c(A(), this.f2396c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f2397d = null;
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b0() {
        C0917f fVar = this.f2397d;
        if (fVar == null) {
            a().G().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            M5 p02 = p0(false);
            C0335p.l(p02);
            fVar.b0(p02);
            m0();
        } catch (RemoteException e5) {
            a().G().b("Failed to send Dma consent settings to the service", e5);
        }
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c0() {
        C0917f fVar = this.f2397d;
        if (fVar == null) {
            a().G().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            M5 p02 = p0(false);
            C0335p.l(p02);
            fVar.W(p02);
            m0();
        } catch (RemoteException e5) {
            a().G().b("Failed to send storage consent settings to the service", e5);
        }
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    /* access modifiers changed from: protected */
    public final void d0() {
        k();
        s();
        M5 p02 = p0(false);
        n().H();
        P(new N4(this, p02));
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    /* access modifiers changed from: protected */
    public final void e0() {
        k();
        s();
        P(new H4(this));
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    /* access modifiers changed from: protected */
    public final void f0() {
        k();
        s();
        P(new U4(this, p0(true)));
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final boolean g0() {
        k();
        s();
        if (this.f2397d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean h0() {
        k();
        s();
        if (k0() && g().I0() < 200900) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    /* access modifiers changed from: package-private */
    public final boolean i0() {
        k();
        s();
        if (k0() && g().I0() < ((Integer) G.f2510u0.a((Object) null)).intValue()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    /* access modifiers changed from: package-private */
    public final boolean j0() {
        k();
        s();
        if (k0() && g().I0() < 241200) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k0() {
        /*
            r5 = this;
            r5.k()
            r5.s()
            java.lang.Boolean r0 = r5.f2398e
            if (r0 != 0) goto L_0x0101
            r5.k()
            r5.s()
            com.google.android.gms.measurement.internal.z2 r0 = r5.e()
            java.lang.Boolean r0 = r0.N()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00fb
        L_0x0023:
            com.google.android.gms.measurement.internal.g2 r2 = r5.m()
            int r2 = r2.z()
            r3 = 0
            if (r2 != r1) goto L_0x0031
        L_0x002e:
            r0 = 1
            goto L_0x00d7
        L_0x0031:
            com.google.android.gms.measurement.internal.n2 r2 = r5.a()
            com.google.android.gms.measurement.internal.p2 r2 = r2.K()
            java.lang.String r4 = "Checking service availability"
            r2.a(r4)
            com.google.android.gms.measurement.internal.d6 r2 = r5.g()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.r(r4)
            if (r2 == 0) goto L_0x00c8
            if (r2 == r1) goto L_0x00ba
            r4 = 2
            if (r2 == r4) goto L_0x0099
            r0 = 3
            if (r2 == r0) goto L_0x008b
            r0 = 9
            if (r2 == r0) goto L_0x007d
            r0 = 18
            if (r2 == r0) goto L_0x006f
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.b(r2, r1)
        L_0x006c:
            r0 = 0
        L_0x006d:
            r1 = 0
            goto L_0x00d7
        L_0x006f:
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.String r2 = "Service updating"
            r0.a(r2)
            goto L_0x002e
        L_0x007d:
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.String r1 = "Service invalid"
            r0.a(r1)
            goto L_0x006c
        L_0x008b:
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.String r1 = "Service disabled"
            r0.a(r1)
            goto L_0x006c
        L_0x0099:
            com.google.android.gms.measurement.internal.n2 r2 = r5.a()
            com.google.android.gms.measurement.internal.p2 r2 = r2.F()
            java.lang.String r4 = "Service container out of date"
            r2.a(r4)
            com.google.android.gms.measurement.internal.d6 r2 = r5.g()
            int r2 = r2.I0()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00b4
        L_0x00b2:
            r0 = 1
            goto L_0x006d
        L_0x00b4:
            if (r0 != 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r1 = 0
        L_0x00b8:
            r0 = 0
            goto L_0x00d7
        L_0x00ba:
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            java.lang.String r2 = "Service missing"
            r0.a(r2)
            goto L_0x00b2
        L_0x00c8:
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            java.lang.String r2 = "Service available"
            r0.a(r2)
            goto L_0x002e
        L_0x00d7:
            if (r1 != 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.g r2 = r5.b()
            boolean r2 = r2.X()
            if (r2 == 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.n2 r0 = r5.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.a(r2)
            goto L_0x00f2
        L_0x00f1:
            r3 = r0
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.measurement.internal.z2 r0 = r5.e()
            r0.u(r1)
        L_0x00fb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.f2398e = r0
        L_0x0101:
            java.lang.Boolean r0 = r5.f2398e
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.F4.k0():boolean");
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

    /* access modifiers changed from: protected */
    public final void o0(boolean z4) {
        k();
        s();
        if ((!C0576h6.a() || !b().q(G.f2453Y0)) && z4) {
            n().H();
        }
        P(new E4(this));
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

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final void z(Bundle bundle) {
        k();
        s();
        P(new S4(this, p0(false), bundle));
    }
}
