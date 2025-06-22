package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0608l2;
import com.google.android.gms.internal.measurement.C0613l7;
import com.google.android.gms.internal.measurement.C0617m2;
import com.google.android.gms.internal.measurement.C0635o2;
import com.google.android.gms.internal.measurement.C0643p2;
import com.google.android.gms.internal.measurement.C0651q2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.C0674t2;
import com.google.android.gms.internal.measurement.R6;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.v4  reason: case insensitive filesystem */
final class C0878v4 extends E5 {
    public C0878v4(H5 h5) {
        super(h5);
    }

    private static String h(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    public final byte[] v(E e5, String str) {
        a6 a6Var;
        List list;
        C0635o2.a aVar;
        Bundle bundle;
        byte[] bArr;
        C0744c2 c2Var;
        C0643p2.a aVar2;
        A a5;
        long j4;
        E e6 = e5;
        String str2 = str;
        k();
        this.f3273a.Q();
        C0335p.l(e6);
        C0335p.f(str2);
        if (!b().F(str2, G.f2493m0)) {
            a().F().b("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(e6.f2366a) || "_iapx".equals(e6.f2366a)) {
            C0635o2.a L4 = C0635o2.L();
            n().c1();
            C0744c2 M02 = n().M0(str2);
            if (M02 == null) {
                a().F().b("Log and bundle not available. package_name", str2);
                byte[] bArr2 = new byte[0];
                n().i1();
                return bArr2;
            } else if (!M02.A()) {
                a().F().b("Log and bundle disabled. package_name", str2);
                byte[] bArr3 = new byte[0];
                n().i1();
                return bArr3;
            } else {
                C0643p2.a S02 = C0643p2.u2().t0(1).S0("android");
                if (!TextUtils.isEmpty(M02.l())) {
                    S02.R(M02.l());
                }
                if (!TextUtils.isEmpty(M02.n())) {
                    S02.d0((String) C0335p.l(M02.n()));
                }
                if (!TextUtils.isEmpty(M02.o())) {
                    S02.j0((String) C0335p.l(M02.o()));
                }
                if (M02.U() != -2147483648L) {
                    S02.g0((int) M02.U());
                }
                S02.m0(M02.z0()).b0(M02.v0());
                String q4 = M02.q();
                String j5 = M02.j();
                if (!TextUtils.isEmpty(q4)) {
                    S02.M0(q4);
                } else if (!TextUtils.isEmpty(j5)) {
                    S02.G(j5);
                }
                S02.C0(M02.J0());
                A3 U4 = this.f2403b.U(str2);
                S02.V(M02.t0());
                if (this.f3273a.m() && b().N(S02.Z0()) && U4.y() && !TextUtils.isEmpty((CharSequence) null)) {
                    S02.D0((String) null);
                }
                S02.r0(U4.w());
                if (U4.y() && M02.z()) {
                    Pair w4 = p().w(M02.l(), U4);
                    if (M02.z() && w4 != null && !TextUtils.isEmpty((CharSequence) w4.first)) {
                        try {
                            S02.U0(h((String) w4.first, Long.toString(e6.f2369d)));
                            Object obj = w4.second;
                            if (obj != null) {
                                S02.Y(((Boolean) obj).booleanValue());
                            }
                        } catch (SecurityException e7) {
                            a().F().b("Resettable device id encryption failed", e7.getMessage());
                            return new byte[0];
                        } finally {
                            n().i1();
                        }
                    }
                }
                c().m();
                C0643p2.a z02 = S02.z0(Build.MODEL);
                c().m();
                z02.Q0(Build.VERSION.RELEASE).B0((int) c().r()).Y0(c().s());
                try {
                    if (U4.z() && M02.m() != null) {
                        S02.X(h((String) C0335p.l(M02.m()), Long.toString(e6.f2369d)));
                    }
                    if (!TextUtils.isEmpty(M02.p())) {
                        S02.K0((String) C0335p.l(M02.p()));
                    }
                    String l4 = M02.l();
                    List Y02 = n().Y0(l4);
                    Iterator it = Y02.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            a6Var = null;
                            break;
                        }
                        a6Var = (a6) it.next();
                        if ("_lte".equals(a6Var.f2856c)) {
                            break;
                        }
                    }
                    if (a6Var == null || a6Var.f2858e == null) {
                        list = Y02;
                        a6 a6Var2 = new a6(l4, "auto", "_lte", B().currentTimeMillis(), 0L);
                        list.add(a6Var2);
                        n().i0(a6Var2);
                    } else {
                        list = Y02;
                    }
                    C0674t2[] t2VarArr = new C0674t2[list.size()];
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        C0674t2.a y4 = C0674t2.S().t(((a6) list.get(i4)).f2856c).y(((a6) list.get(i4)).f2857d);
                        l().V(y4, ((a6) list.get(i4)).f2858e);
                        t2VarArr[i4] = (C0674t2) ((C0668s4) y4.m());
                    }
                    S02.i0(Arrays.asList(t2VarArr));
                    this.f2403b.u(M02, S02);
                    if (R6.a() && b().q(G.f2447V0)) {
                        this.f2403b.a0(M02, S02);
                    }
                    C0848r2 b5 = C0848r2.b(e6);
                    g().N(b5.f3204d, n().K0(str2));
                    g().W(b5, b().s(str2));
                    Bundle bundle2 = b5.f3204d;
                    bundle2.putLong("_c", 1);
                    a().F().a("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", e6.f2368c);
                    if (g().E0(S02.Z0(), M02.v())) {
                        g().O(bundle2, "_dbg", 1L);
                        g().O(bundle2, "_r", 1L);
                    }
                    A L02 = n().L0(str2, e6.f2366a);
                    if (L02 == null) {
                        c2Var = M02;
                        bArr = null;
                        bundle = bundle2;
                        aVar2 = S02;
                        aVar = L4;
                        a5 = new A(str2, e6.f2366a, 0, 0, e6.f2369d, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j4 = 0;
                    } else {
                        aVar = L4;
                        bundle = bundle2;
                        bArr = null;
                        c2Var = M02;
                        aVar2 = S02;
                        long j6 = L02.f2288f;
                        a5 = L02.a(e6.f2369d);
                        j4 = j6;
                    }
                    A a6 = a5;
                    n().U(a6);
                    String str3 = str;
                    B b6 = new B(this.f3273a, e6.f2368c, str3, e6.f2366a, e6.f2369d, j4, bundle);
                    String str4 = str3;
                    C0599k2.a x4 = C0599k2.S().D(b6.f2319d).B(b6.f2317b).x(b6.f2320e);
                    Iterator it2 = b6.f2321f.iterator();
                    while (it2.hasNext()) {
                        String str5 = (String) it2.next();
                        C0617m2.a y5 = C0617m2.U().y(str5);
                        Object l5 = b6.f2321f.l(str5);
                        if (l5 != null) {
                            l().U(y5, l5);
                            x4.y(y5);
                        }
                    }
                    C0643p2.a aVar3 = aVar2;
                    aVar3.B(x4).C(C0651q2.G().q(C0608l2.G().q(a6.f2285c).r(e6.f2366a)));
                    aVar3.F(m().w(c2Var.l(), Collections.EMPTY_LIST, aVar3.J(), Long.valueOf(x4.F()), Long.valueOf(x4.F())));
                    if (x4.J()) {
                        aVar3.y0(x4.F()).h0(x4.F());
                    }
                    long D02 = c2Var.D0();
                    int i5 = (D02 > 0 ? 1 : (D02 == 0 ? 0 : -1));
                    if (i5 != 0) {
                        aVar3.q0(D02);
                    }
                    long H02 = c2Var.H0();
                    if (H02 != 0) {
                        aVar3.u0(H02);
                    } else if (i5 != 0) {
                        aVar3.u0(D02);
                    }
                    String u4 = c2Var.u();
                    if (C0613l7.a() && b().F(str4, G.f2516x0) && u4 != null) {
                        aVar3.W0(u4);
                    }
                    c2Var.y();
                    aVar3.l0((int) c2Var.F0()).J0(106000).F0(B().currentTimeMillis()).e0(true);
                    this.f2403b.E(aVar3.Z0(), aVar3);
                    C0635o2.a aVar4 = aVar;
                    aVar4.r(aVar3);
                    C0744c2 c2Var2 = c2Var;
                    c2Var2.C0(aVar3.k0());
                    c2Var2.y0(aVar3.f0());
                    n().V(c2Var2, false, false);
                    n().k1();
                    try {
                        return l().h0(((C0635o2) ((C0668s4) aVar4.m())).i());
                    } catch (IOException e8) {
                        a().G().c("Data loss. Failed to bundle and serialize. appId", C0821n2.s(str4), e8);
                        return bArr;
                    }
                } catch (SecurityException e9) {
                    a().F().b("app instance id encryption failed", e9.getMessage());
                    byte[] bArr4 = new byte[0];
                    n().i1();
                    return bArr4;
                }
            }
        } else {
            a().F().c("Generating a payload for this event is not available. package_name, event_name", str2, e6.f2366a);
            return null;
        }
    }
}
