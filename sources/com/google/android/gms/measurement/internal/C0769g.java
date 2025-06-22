package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import R.m;
import T.e;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import f0.p;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.gms.measurement.internal.g  reason: case insensitive filesystem */
public final class C0769g extends C0884w3 {

    /* renamed from: b  reason: collision with root package name */
    private Boolean f2984b;

    /* renamed from: c  reason: collision with root package name */
    private String f2985c;

    /* renamed from: d  reason: collision with root package name */
    private C0783i f2986d = new C0762f();

    /* renamed from: e  reason: collision with root package name */
    private Boolean f2987e;

    C0769g(S2 s22) {
        super(s22);
    }

    public static long I() {
        return ((Long) G.f2468e.a((Object) null)).longValue();
    }

    public static long K() {
        return (long) ((Integer) G.f2489l.a((Object) null)).intValue();
    }

    public static long P() {
        return ((Long) G.f2414F.a((Object) null)).longValue();
    }

    public static long Q() {
        return ((Long) G.f2404A.a((Object) null)).longValue();
    }

    private final String h(String str, String str2) {
        try {
            Class<String> cls = String.class;
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
            C0335p.l(str3);
            return str3;
        } catch (ClassNotFoundException e5) {
            a().G().b("Could not find SystemProperties class", e5);
            return str2;
        } catch (NoSuchMethodException e6) {
            a().G().b("Could not find SystemProperties.get() method", e6);
            return str2;
        } catch (IllegalAccessException e7) {
            a().G().b("Could not access SystemProperties.get()", e7);
            return str2;
        } catch (InvocationTargetException e8) {
            a().G().b("SystemProperties.get() threw an exception", e8);
            return str2;
        }
    }

    private final Bundle r() {
        try {
            if (A().getPackageManager() == null) {
                a().G().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo c5 = e.a(A()).c(A().getPackageName(), 128);
            if (c5 != null) {
                return c5.metaData;
            }
            a().G().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            a().G().b("Failed to load metadata: Package name not found", e5);
            return null;
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

    public final String D(String str, C0737b2 b2Var) {
        if (TextUtils.isEmpty(str)) {
            return (String) b2Var.a((Object) null);
        }
        return (String) b2Var.a(this.f2986d.h(str, b2Var.b()));
    }

    /* access modifiers changed from: package-private */
    public final Boolean E(String str) {
        C0335p.f(str);
        Bundle r4 = r();
        if (r4 == null) {
            a().G().a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!r4.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(r4.getBoolean(str));
        }
    }

    public final boolean F(String str, C0737b2 b2Var) {
        return H(str, b2Var);
    }

    /* access modifiers changed from: package-private */
    public final String G(String str) {
        return D(str, G.f2432O);
    }

    public final boolean H(String str, C0737b2 b2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) b2Var.a((Object) null)).booleanValue();
        }
        String h4 = this.f2986d.h(str, b2Var.b());
        if (TextUtils.isEmpty(h4)) {
            return ((Boolean) b2Var.a((Object) null)).booleanValue();
        }
        return ((Boolean) b2Var.a(Boolean.valueOf("1".equals(h4)))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List J(java.lang.String r4) {
        /*
            r3 = this;
            M.C0335p.f(r4)
            android.os.Bundle r0 = r3.r()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.n2 r4 = r3.a()
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.A()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.n2 r0 = r3.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0769g.J(java.lang.String):java.util.List");
    }

    public final void L(String str) {
        this.f2985c = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str) {
        return H(str, G.f2430N);
    }

    public final boolean N(String str) {
        return "1".equals(this.f2986d.h(str, "gaia_collection_enabled"));
    }

    public final boolean O(String str) {
        return "1".equals(this.f2986d.h(str, "measurement.event_sampling_enabled"));
    }

    public final String R() {
        return h("debug.firebase.analytics.app", "");
    }

    public final String S() {
        return h("debug.deferred.deeplink", "");
    }

    public final String T() {
        return this.f2985c;
    }

    public final boolean U() {
        Boolean E4 = E("google_analytics_adid_collection_enabled");
        if (E4 == null || E4.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean V() {
        Boolean E4 = E("google_analytics_automatic_screen_reporting_enabled");
        if (E4 == null || E4.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean W() {
        Boolean E4 = E("firebase_analytics_collection_deactivated");
        if (E4 == null || !E4.booleanValue()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean X() {
        if (this.f2984b == null) {
            Boolean E4 = E("app_measurement_lite");
            this.f2984b = E4;
            if (E4 == null) {
                this.f2984b = Boolean.FALSE;
            }
        }
        if (this.f2984b.booleanValue() || !this.f3273a.q()) {
            return true;
        }
        return false;
    }

    public final boolean Y() {
        boolean z4;
        if (this.f2987e == null) {
            synchronized (this) {
                try {
                    if (this.f2987e == null) {
                        ApplicationInfo applicationInfo = A().getApplicationInfo();
                        String a5 = m.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            if (str == null || !str.equals(a5)) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            this.f2987e = Boolean.valueOf(z4);
                        }
                        if (this.f2987e == null) {
                            this.f2987e = Boolean.TRUE;
                            a().G().a("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f2987e.booleanValue();
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

    public final double l(String str, C0737b2 b2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) b2Var.a((Object) null)).doubleValue();
        }
        String h4 = this.f2986d.h(str, b2Var.b());
        if (TextUtils.isEmpty(h4)) {
            return ((Double) b2Var.a((Object) null)).doubleValue();
        }
        try {
            return ((Double) b2Var.a(Double.valueOf(Double.parseDouble(h4)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) b2Var.a((Object) null)).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int m(String str) {
        return n(str, G.f2424K, 500, 2000);
    }

    public final int n(String str, C0737b2 b2Var, int i4, int i5) {
        return Math.max(Math.min(t(str, b2Var), i5), i4);
    }

    /* access modifiers changed from: package-private */
    public final int o(String str, boolean z4) {
        if (z4) {
            return n(str, G.f2444U, 100, 500);
        }
        return 500;
    }

    /* access modifiers changed from: package-private */
    public final void p(C0783i iVar) {
        this.f2986d = iVar;
    }

    public final boolean q(C0737b2 b2Var) {
        return H((String) null, b2Var);
    }

    public final int s(String str) {
        return n(str, G.f2426L, 25, 100);
    }

    public final int t(String str, C0737b2 b2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) b2Var.a((Object) null)).intValue();
        }
        String h4 = this.f2986d.h(str, b2Var.b());
        if (TextUtils.isEmpty(h4)) {
            return ((Integer) b2Var.a((Object) null)).intValue();
        }
        try {
            return ((Integer) b2Var.a(Integer.valueOf(Integer.parseInt(h4)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) b2Var.a((Object) null)).intValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int u(String str, boolean z4) {
        return Math.max(o(str, z4), 256);
    }

    public final int v() {
        if (g().c0(201500000, true)) {
            return 100;
        }
        return 25;
    }

    public final int w(String str) {
        return t(str, G.f2499p);
    }

    public final long x(String str, C0737b2 b2Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) b2Var.a((Object) null)).longValue();
        }
        String h4 = this.f2986d.h(str, b2Var.b());
        if (TextUtils.isEmpty(h4)) {
            return ((Long) b2Var.a((Object) null)).longValue();
        }
        try {
            return ((Long) b2Var.a(Long.valueOf(Long.parseLong(h4)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) b2Var.a((Object) null)).longValue();
        }
    }

    public final p y(String str, boolean z4) {
        Object obj;
        C0335p.f(str);
        Bundle r4 = r();
        if (r4 == null) {
            a().G().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = r4.get(str);
        }
        if (obj == null) {
            return p.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return p.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return p.DENIED;
        }
        if (z4 && "eu_consent_policy".equals(obj)) {
            return p.POLICY;
        }
        a().L().b("Invalid manifest metadata for", str);
        return p.UNINITIALIZED;
    }

    /* access modifiers changed from: package-private */
    public final long z(String str) {
        return x(str, G.f2459b);
    }
}
