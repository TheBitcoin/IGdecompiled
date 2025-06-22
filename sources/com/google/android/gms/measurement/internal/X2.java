package com.google.android.gms.measurement.internal;

import J.C0313l;
import J.C0314m;
import M.C0335p;
import R.o;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C;
import com.google.android.gms.internal.measurement.C0542e;
import com.google.android.gms.internal.measurement.C0543e0;
import com.google.android.gms.internal.measurement.C0621m6;
import f0.C0913b;
import f0.h;
import f0.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class X2 extends h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final H5 f2792a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f2793b;

    /* renamed from: k  reason: collision with root package name */
    private String f2794k;

    public X2(H5 h5) {
        this(h5, (String) null);
    }

    private final void l0(Runnable runnable) {
        C0335p.l(runnable);
        if (this.f2792a.f().J()) {
            runnable.run();
        } else {
            this.f2792a.f().G(runnable);
        }
    }

    private final void m0(String str, boolean z4) {
        boolean z5;
        if (!TextUtils.isEmpty(str)) {
            if (z4) {
                try {
                    if (this.f2793b == null) {
                        if (!"com.google.android.gms".equals(this.f2794k) && !o.a(this.f2792a.A(), Binder.getCallingUid())) {
                            if (!C0314m.a(this.f2792a.A()).c(Binder.getCallingUid())) {
                                z5 = false;
                                this.f2793b = Boolean.valueOf(z5);
                            }
                        }
                        z5 = true;
                        this.f2793b = Boolean.valueOf(z5);
                    }
                    if (this.f2793b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e5) {
                    this.f2792a.a().G().b("Measurement Service called with invalid calling package. appId", C0821n2.s(str));
                    throw e5;
                }
            }
            if (this.f2794k == null && C0313l.k(this.f2792a.A(), Binder.getCallingUid(), str)) {
                this.f2794k = str;
            }
            if (!str.equals(this.f2794k)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.f2792a.a().G().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    private final void p0(M5 m5, boolean z4) {
        C0335p.l(m5);
        C0335p.f(m5.f2631a);
        m0(m5.f2631a, false);
        this.f2792a.y0().k0(m5.f2632b, m5.f2647q);
    }

    private final void q0(Runnable runnable) {
        C0335p.l(runnable);
        if (this.f2792a.f().J()) {
            runnable.run();
        } else {
            this.f2792a.f().D(runnable);
        }
    }

    private final void s0(E e5, M5 m5) {
        this.f2792a.z0();
        this.f2792a.s(e5, m5);
    }

    public final void G(C0755e eVar, M5 m5) {
        C0335p.l(eVar);
        C0335p.l(eVar.f2955c);
        p0(m5, false);
        C0755e eVar2 = new C0755e(eVar);
        eVar2.f2953a = m5.f2631a;
        q0(new C0787i3(this, eVar2, m5));
    }

    public final void H(long j4, String str, String str2, String str3) {
        String str4 = str2;
        String str5 = str3;
        q0(new C0766f3(this, str4, str5, str, j4));
    }

    public final void J(M5 m5) {
        p0(m5, false);
        q0(new C0773g3(this, m5));
    }

    public final List K(String str, String str2, String str3) {
        m0(str, true);
        try {
            return (List) this.f2792a.f().t(new C0808l3(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.f2792a.a().G().b("Failed to get conditional user properties as", e5);
            return Collections.EMPTY_LIST;
        }
    }

    public final void L(C0755e eVar) {
        C0335p.l(eVar);
        C0335p.l(eVar.f2955c);
        C0335p.f(eVar.f2953a);
        m0(eVar.f2953a, true);
        q0(new C0780h3(this, new C0755e(eVar)));
    }

    public final void T(E e5, String str, String str2) {
        C0335p.l(e5);
        C0335p.f(str);
        m0(str, true);
        q0(new C0856s3(this, e5, str));
    }

    public final void W(M5 m5) {
        C0335p.f(m5.f2631a);
        C0335p.l(m5.f2652v);
        l0(new C0731a3(this, m5));
    }

    public final C0913b X(M5 m5) {
        p0(m5, false);
        C0335p.f(m5.f2631a);
        try {
            return (C0913b) this.f2792a.f().y(new C0843q3(this, m5)).get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            this.f2792a.a().G().c("Failed to get consent. appId", C0821n2.s(m5.f2631a), e5);
            return new C0913b((Bundle) null);
        }
    }

    public final List Z(String str, String str2, boolean z4, M5 m5) {
        p0(m5, false);
        String str3 = m5.f2631a;
        C0335p.l(str3);
        try {
            List<a6> list = (List) this.f2792a.f().t(new C0801k3(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (a6 a6Var : list) {
                if (!z4) {
                    if (!d6.J0(a6Var.f2856c)) {
                    }
                }
                arrayList.add(new Y5(a6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f2792a.a().G().c("Failed to query user properties. appId", C0821n2.s(m5.f2631a), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e6) {
            e = e6;
            this.f2792a.a().G().c("Failed to query user properties. appId", C0821n2.s(m5.f2631a), e);
            return Collections.EMPTY_LIST;
        }
    }

    public final void b0(M5 m5) {
        C0335p.f(m5.f2631a);
        C0335p.l(m5.f2652v);
        l0(new C0745c3(this, m5));
    }

    public final List c0(M5 m5, Bundle bundle) {
        p0(m5, false);
        C0335p.l(m5.f2631a);
        try {
            return (List) this.f2792a.f().t(new C0863t3(this, m5, bundle)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.f2792a.a().G().c("Failed to get trigger URIs. appId", C0821n2.s(m5.f2631a), e5);
            return Collections.EMPTY_LIST;
        }
    }

    public final byte[] d0(E e5, String str) {
        C0335p.f(str);
        C0335p.l(e5);
        m0(str, true);
        this.f2792a.a().F().b("Log and bundle. event", this.f2792a.n0().c(e5.f2366a));
        long a5 = this.f2792a.B().a() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f2792a.f().y(new C0849r3(this, e5, str)).get();
            if (bArr == null) {
                this.f2792a.a().G().b("Log and bundle returned null. appId", C0821n2.s(str));
                bArr = new byte[0];
            }
            this.f2792a.a().F().d("Log and bundle processed. event, size, time_ms", this.f2792a.n0().c(e5.f2366a), Integer.valueOf(bArr.length), Long.valueOf((this.f2792a.B().a() / 1000000) - a5));
            return bArr;
        } catch (InterruptedException e6) {
            e = e6;
            this.f2792a.a().G().d("Failed to log and bundle. appId, event, error", C0821n2.s(str), this.f2792a.n0().c(e5.f2366a), e);
            return null;
        } catch (ExecutionException e7) {
            e = e7;
            this.f2792a.a().G().d("Failed to log and bundle. appId, event, error", C0821n2.s(str), this.f2792a.n0().c(e5.f2366a), e);
            return null;
        }
    }

    public final List e0(M5 m5, boolean z4) {
        p0(m5, false);
        String str = m5.f2631a;
        C0335p.l(str);
        try {
            List<a6> list = (List) this.f2792a.f().t(new C0891x3(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (a6 a6Var : list) {
                if (!z4) {
                    if (!d6.J0(a6Var.f2856c)) {
                    }
                }
                arrayList.add(new Y5(a6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f2792a.a().G().c("Failed to get user properties. appId", C0821n2.s(m5.f2631a), e);
            return null;
        } catch (ExecutionException e6) {
            e = e6;
            this.f2792a.a().G().c("Failed to get user properties. appId", C0821n2.s(m5.f2631a), e);
            return null;
        }
    }

    public final void g0(M5 m5) {
        p0(m5, false);
        q0(new C0759e3(this, m5));
    }

    public final void i0(E e5, M5 m5) {
        C0335p.l(e5);
        p0(m5, false);
        q0(new C0836p3(this, e5, m5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void k(Bundle bundle, String str) {
        boolean q4 = this.f2792a.i0().q(G.f2473f1);
        boolean q5 = this.f2792a.i0().q(G.f2479h1);
        if (!bundle.isEmpty() || !q4 || !q5) {
            this.f2792a.l0().F0(str, bundle);
            if (q5 && this.f2792a.l0().h1(str)) {
                this.f2792a.l0().X(str, bundle);
                return;
            }
            return;
        }
        this.f2792a.l0().d1(str);
    }

    public final List l(String str, String str2, M5 m5) {
        p0(m5, false);
        String str3 = m5.f2631a;
        C0335p.l(str3);
        try {
            return (List) this.f2792a.f().t(new C0815m3(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e5) {
            this.f2792a.a().G().b("Failed to get conditional user properties", e5);
            return Collections.EMPTY_LIST;
        }
    }

    public final void m(Bundle bundle, M5 m5) {
        if (C0621m6.a() && this.f2792a.i0().q(G.f2479h1)) {
            p0(m5, false);
            String str = m5.f2631a;
            C0335p.l(str);
            q0(new Z2(this, bundle, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final E n0(E e5, M5 m5) {
        D d5;
        if (!"_cmp".equals(e5.f2366a) || (d5 = e5.f2367b) == null || d5.c() == 0) {
            return e5;
        }
        String m4 = e5.f2367b.m("_cis");
        if (!"referrer broadcast".equals(m4) && !"referrer API".equals(m4)) {
            return e5;
        }
        this.f2792a.a().J().b("Event has been filtered ", e5.toString());
        return new E("_cmpx", e5.f2367b, e5.f2368c, e5.f2369d);
    }

    public final void o(M5 m5) {
        p0(m5, false);
        q0(new C0752d3(this, m5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void o0(Bundle bundle, String str) {
        if (bundle.isEmpty()) {
            this.f2792a.l0().d1(str);
            return;
        }
        this.f2792a.l0().F0(str, bundle);
        this.f2792a.l0().X(str, bundle);
    }

    public final List r(String str, String str2, String str3, boolean z4) {
        m0(str, true);
        try {
            List<a6> list = (List) this.f2792a.f().t(new C0794j3(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (a6 a6Var : list) {
                if (!z4) {
                    if (!d6.J0(a6Var.f2856c)) {
                    }
                }
                arrayList.add(new Y5(a6Var));
            }
            return arrayList;
        } catch (InterruptedException e5) {
            e = e5;
            this.f2792a.a().G().c("Failed to get user properties as. appId", C0821n2.s(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e6) {
            e = e6;
            this.f2792a.a().G().c("Failed to get user properties as. appId", C0821n2.s(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    /* access modifiers changed from: package-private */
    public final void r0(E e5, M5 m5) {
        C c5;
        boolean z4;
        if (!this.f2792a.r0().W(m5.f2631a)) {
            s0(e5, m5);
            return;
        }
        this.f2792a.a().K().b("EES config found for", m5.f2631a);
        I2 r02 = this.f2792a.r0();
        String str = m5.f2631a;
        if (TextUtils.isEmpty(str)) {
            c5 = null;
        } else {
            c5 = (C) r02.f2576j.get(str);
        }
        if (c5 == null) {
            this.f2792a.a().K().b("EES not loaded for", m5.f2631a);
            s0(e5, m5);
            return;
        }
        try {
            Map Q4 = this.f2792a.x0().Q(e5.f2367b.j(), true);
            String a5 = q.a(e5.f2366a);
            if (a5 == null) {
                a5 = e5.f2366a;
            }
            z4 = c5.d(new C0542e(a5, e5.f2369d, Q4));
        } catch (C0543e0 unused) {
            this.f2792a.a().G().c("EES error. appId, eventName", m5.f2632b, e5.f2366a);
            z4 = false;
        }
        if (!z4) {
            this.f2792a.a().K().b("EES was not applied to event", e5.f2366a);
            s0(e5, m5);
            return;
        }
        if (c5.g()) {
            this.f2792a.a().K().b("EES edited event", e5.f2366a);
            s0(this.f2792a.x0().H(c5.a().d()), m5);
        } else {
            s0(e5, m5);
        }
        if (c5.f()) {
            for (C0542e eVar : c5.a().f()) {
                this.f2792a.a().K().b("EES logging created event", eVar.e());
                s0(this.f2792a.x0().H(eVar), m5);
            }
        }
    }

    public final void t(M5 m5) {
        C0335p.f(m5.f2631a);
        m0(m5.f2631a, false);
        q0(new C0829o3(this, m5));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void t0(M5 m5) {
        this.f2792a.z0();
        this.f2792a.m0(m5);
    }

    public final void u(Bundle bundle, M5 m5) {
        p0(m5, false);
        String str = m5.f2631a;
        C0335p.l(str);
        q0(new C0738b3(this, bundle, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void u0(M5 m5) {
        this.f2792a.z0();
        this.f2792a.o0(m5);
    }

    public final void v(M5 m5) {
        C0335p.f(m5.f2631a);
        C0335p.l(m5.f2652v);
        l0(new C0822n3(this, m5));
    }

    public final void w(Y5 y5, M5 m5) {
        C0335p.l(y5);
        p0(m5, false);
        q0(new C0870u3(this, y5, m5));
    }

    public final String z(M5 m5) {
        p0(m5, false);
        return this.f2792a.V(m5);
    }

    private X2(H5 h5, String str) {
        C0335p.l(h5);
        this.f2792a = h5;
        this.f2794k = null;
    }
}
