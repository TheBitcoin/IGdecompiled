package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.content.Context;
import com.google.android.gms.internal.measurement.w7;
import com.google.android.gms.measurement.internal.A3;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.measurement.internal.g2  reason: case insensitive filesystem */
public final class C0772g2 extends C0897y2 {

    /* renamed from: c  reason: collision with root package name */
    private String f2988c;

    /* renamed from: d  reason: collision with root package name */
    private String f2989d;

    /* renamed from: e  reason: collision with root package name */
    private int f2990e;

    /* renamed from: f  reason: collision with root package name */
    private String f2991f;

    /* renamed from: g  reason: collision with root package name */
    private long f2992g;

    /* renamed from: h  reason: collision with root package name */
    private long f2993h;

    /* renamed from: i  reason: collision with root package name */
    private List f2994i;

    /* renamed from: j  reason: collision with root package name */
    private String f2995j;

    /* renamed from: k  reason: collision with root package name */
    private int f2996k;

    /* renamed from: l  reason: collision with root package name */
    private String f2997l;

    /* renamed from: m  reason: collision with root package name */
    private String f2998m;

    /* renamed from: n  reason: collision with root package name */
    private String f2999n;

    /* renamed from: o  reason: collision with root package name */
    private long f3000o = 0;

    /* renamed from: p  reason: collision with root package name */
    private String f3001p = null;

    C0772g2(S2 s22, long j4) {
        super(s22);
        this.f2993h = j4;
    }

    private final String J() {
        if (!w7.a() || !b().q(G.f2506s0)) {
            try {
                Class<?> loadClass = A().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{A()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", (Class[]) null).invoke(invoke, (Object[]) null);
                    } catch (Exception unused) {
                        a().M().a("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    a().N().a("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            a().K().a("Disabled IID for tests.");
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

    /* access modifiers changed from: package-private */
    public final int D() {
        s();
        return this.f2990e;
    }

    /* access modifiers changed from: package-private */
    public final String E() {
        s();
        return this.f2998m;
    }

    /* access modifiers changed from: package-private */
    public final String F() {
        s();
        C0335p.l(this.f2988c);
        return this.f2988c;
    }

    /* access modifiers changed from: package-private */
    public final String G() {
        k();
        s();
        C0335p.l(this.f2997l);
        return this.f2997l;
    }

    /* access modifiers changed from: package-private */
    public final List H() {
        return this.f2994i;
    }

    /* access modifiers changed from: package-private */
    public final void I() {
        String str;
        String str2;
        k();
        if (!e().M().m(A3.a.ANALYTICS_STORAGE)) {
            a().F().a("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            g().W0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        C0835p2 F4 = a().F();
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        F4.a(String.format("Resetting session stitching token to %s", new Object[]{str2}));
        this.f2999n = str;
        this.f3000o = B().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean K(String str) {
        boolean z4;
        String str2 = this.f3001p;
        if (str2 == null || str2.equals(str)) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f3001p = str;
        return z4;
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0186 A[Catch:{ IllegalStateException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0187 A[Catch:{ IllegalStateException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0190 A[Catch:{ IllegalStateException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ac A[Catch:{ IllegalStateException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r11 = this;
            android.content.Context r0 = r11.A()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.A()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = "unknown"
            java.lang.String r5 = "Unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.G()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            r7.b(r8, r9)
            goto L_0x008c
        L_0x002d:
            java.lang.String r4 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.G()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            r7.b(r8, r9)
        L_0x0043:
            if (r4 != 0) goto L_0x0048
            java.lang.String r4 = "manual_install"
            goto L_0x0051
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0051
            r4 = r3
        L_0x0051:
            android.content.Context r7 = r11.A()     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0079 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r2)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r7 == 0) goto L_0x008c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0079 }
            goto L_0x0071
        L_0x0070:
            r8 = r5
        L_0x0071:
            java.lang.String r5 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0076 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x008c
        L_0x0076:
            r7 = r5
            r5 = r8
            goto L_0x007a
        L_0x0079:
            r7 = r5
        L_0x007a:
            com.google.android.gms.measurement.internal.n2 r8 = r11.a()
            com.google.android.gms.measurement.internal.p2 r8 = r8.G()
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            r8.c(r9, r10, r5)
            r5 = r7
        L_0x008c:
            r11.f2988c = r0
            r11.f2991f = r4
            r11.f2989d = r5
            r11.f2990e = r6
            r4 = 0
            r11.f2992g = r4
            com.google.android.gms.measurement.internal.S2 r4 = r11.f3273a
            java.lang.String r4 = r4.M()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 1
            if (r4 != 0) goto L_0x00b5
            com.google.android.gms.measurement.internal.S2 r4 = r11.f3273a
            java.lang.String r4 = r4.N()
            java.lang.String r6 = "am"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x00b5
            r4 = 1
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            com.google.android.gms.measurement.internal.S2 r6 = r11.f3273a
            int r6 = r6.u()
            switch(r6) {
                case 0: goto L_0x014c;
                case 1: goto L_0x013e;
                case 2: goto L_0x0130;
                case 3: goto L_0x0122;
                case 4: goto L_0x0114;
                case 5: goto L_0x0106;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00ea;
                case 8: goto L_0x00db;
                default: goto L_0x00bf;
            }
        L_0x00bf:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement disabled"
            r7.a(r8)
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.I()
            java.lang.String r8 = "Invalid scion state in identity"
            r7.a(r8)
            goto L_0x0159
        L_0x00db:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.a(r8)
            goto L_0x0159
        L_0x00ea:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.a(r8)
            goto L_0x0159
        L_0x00f8:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.M()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.a(r8)
            goto L_0x0159
        L_0x0106:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.a(r8)
            goto L_0x0159
        L_0x0114:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.a(r8)
            goto L_0x0159
        L_0x0122:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.a(r8)
            goto L_0x0159
        L_0x0130:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.a(r8)
            goto L_0x0159
        L_0x013e:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.J()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.a(r8)
            goto L_0x0159
        L_0x014c:
            com.google.android.gms.measurement.internal.n2 r7 = r11.a()
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()
            java.lang.String r8 = "App measurement collection enabled"
            r7.a(r8)
        L_0x0159:
            if (r6 != 0) goto L_0x015c
            goto L_0x015d
        L_0x015c:
            r5 = 0
        L_0x015d:
            r11.f2997l = r3
            r11.f2998m = r3
            if (r4 == 0) goto L_0x016b
            com.google.android.gms.measurement.internal.S2 r4 = r11.f3273a
            java.lang.String r4 = r4.M()
            r11.f2998m = r4
        L_0x016b:
            android.content.Context r4 = r11.A()     // Catch:{ IllegalStateException -> 0x01a8 }
            com.google.android.gms.measurement.internal.S2 r6 = r11.f3273a     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r6 = r6.P()     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r7 = "google_app_id"
            f0.n r8 = new f0.n     // Catch:{ IllegalStateException -> 0x01a8 }
            r8.<init>(r4, r6)     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r4 = r8.b(r7)     // Catch:{ IllegalStateException -> 0x01a8 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01a8 }
            if (r6 == 0) goto L_0x0187
            goto L_0x0188
        L_0x0187:
            r3 = r4
        L_0x0188:
            r11.f2997l = r3     // Catch:{ IllegalStateException -> 0x01a8 }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01a8 }
            if (r3 != 0) goto L_0x01aa
            f0.n r3 = new f0.n     // Catch:{ IllegalStateException -> 0x01a8 }
            android.content.Context r4 = r11.A()     // Catch:{ IllegalStateException -> 0x01a8 }
            com.google.android.gms.measurement.internal.S2 r6 = r11.f3273a     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r6 = r6.P()     // Catch:{ IllegalStateException -> 0x01a8 }
            r3.<init>(r4, r6)     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r4 = "admob_app_id"
            java.lang.String r3 = r3.b(r4)     // Catch:{ IllegalStateException -> 0x01a8 }
            r11.f2998m = r3     // Catch:{ IllegalStateException -> 0x01a8 }
            goto L_0x01aa
        L_0x01a8:
            r3 = move-exception
            goto L_0x01c9
        L_0x01aa:
            if (r5 == 0) goto L_0x01da
            com.google.android.gms.measurement.internal.n2 r3 = r11.a()     // Catch:{ IllegalStateException -> 0x01a8 }
            com.google.android.gms.measurement.internal.p2 r3 = r3.K()     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.f2988c     // Catch:{ IllegalStateException -> 0x01a8 }
            java.lang.String r6 = r11.f2997l     // Catch:{ IllegalStateException -> 0x01a8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01a8 }
            if (r6 == 0) goto L_0x01c3
            java.lang.String r6 = r11.f2998m     // Catch:{ IllegalStateException -> 0x01a8 }
            goto L_0x01c5
        L_0x01c3:
            java.lang.String r6 = r11.f2997l     // Catch:{ IllegalStateException -> 0x01a8 }
        L_0x01c5:
            r3.c(r4, r5, r6)     // Catch:{ IllegalStateException -> 0x01a8 }
            goto L_0x01da
        L_0x01c9:
            com.google.android.gms.measurement.internal.n2 r4 = r11.a()
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.C0821n2.s(r0)
            r4.c(r5, r0, r3)
        L_0x01da:
            r0 = 0
            r11.f2994i = r0
            com.google.android.gms.measurement.internal.g r0 = r11.b()
            java.lang.String r3 = "analytics.safelisted_events"
            java.util.List r0 = r0.J(r3)
            if (r0 == 0) goto L_0x021a
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x01fd
            com.google.android.gms.measurement.internal.n2 r0 = r11.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.M()
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r0.a(r3)
            goto L_0x021c
        L_0x01fd:
            java.util.Iterator r3 = r0.iterator()
        L_0x0201:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x021a
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.measurement.internal.d6 r5 = r11.g()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.w0(r6, r4)
            if (r4 != 0) goto L_0x0201
            goto L_0x021c
        L_0x021a:
            r11.f2994i = r0
        L_0x021c:
            if (r1 == 0) goto L_0x0229
            android.content.Context r0 = r11.A()
            boolean r0 = T.b.a(r0)
            r11.f2996k = r0
            return
        L_0x0229:
            r11.f2996k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0772g2.v():void");
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0122, code lost:
        if (e().M().m(com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE) == false) goto L_0x015f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.M5 y(java.lang.String r43) {
        /*
            r42 = this;
            r0 = r42
            r0.k()
            com.google.android.gms.measurement.internal.M5 r1 = new com.google.android.gms.measurement.internal.M5
            java.lang.String r2 = r0.F()
            java.lang.String r3 = r0.G()
            r0.s()
            java.lang.String r4 = r0.f2989d
            int r5 = r0.D()
            long r5 = (long) r5
            r0.s()
            java.lang.String r7 = r0.f2991f
            M.C0335p.l(r7)
            java.lang.String r7 = r0.f2991f
            r0.s()
            r0.k()
            long r8 = r0.f2992g
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0049
            com.google.android.gms.measurement.internal.S2 r8 = r0.f3273a
            com.google.android.gms.measurement.internal.d6 r8 = r8.L()
            android.content.Context r9 = r0.A()
            android.content.Context r12 = r0.A()
            java.lang.String r12 = r12.getPackageName()
            long r8 = r8.w(r9, r12)
            r0.f2992g = r8
        L_0x0049:
            r8 = r10
            long r10 = r0.f2992g
            com.google.android.gms.measurement.internal.S2 r12 = r0.f3273a
            boolean r13 = r12.m()
            com.google.android.gms.measurement.internal.z2 r12 = r0.e()
            boolean r12 = r12.f3335t
            r14 = 1
            r12 = r12 ^ r14
            r0.k()
            com.google.android.gms.measurement.internal.S2 r15 = r0.f3273a
            boolean r15 = r15.m()
            r16 = 0
            if (r15 != 0) goto L_0x006c
            r15 = r16
        L_0x0069:
            r17 = r8
            goto L_0x0071
        L_0x006c:
            java.lang.String r15 = r0.J()
            goto L_0x0069
        L_0x0071:
            com.google.android.gms.measurement.internal.S2 r8 = r0.f3273a
            com.google.android.gms.measurement.internal.z2 r9 = r8.F()
            com.google.android.gms.measurement.internal.A2 r9 = r9.f3322g
            r20 = r15
            r19 = 1
            long r14 = r9.a()
            int r9 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r9 != 0) goto L_0x008a
            long r8 = r8.f2717H
        L_0x0087:
            r15 = r20
            goto L_0x0091
        L_0x008a:
            long r8 = r8.f2717H
            long r8 = java.lang.Math.min(r8, r14)
            goto L_0x0087
        L_0x0091:
            int r20 = r0.z()
            com.google.android.gms.measurement.internal.g r14 = r0.b()
            boolean r21 = r14.U()
            com.google.android.gms.measurement.internal.z2 r14 = r0.e()
            r14.k()
            android.content.SharedPreferences r14 = r14.J()
            r22 = r1
            java.lang.String r1 = "deferred_analytics_collection"
            r23 = r2
            r2 = 0
            boolean r1 = r14.getBoolean(r1, r2)
            r2 = r23
            r14 = 0
            java.lang.String r23 = r0.E()
            com.google.android.gms.measurement.internal.g r14 = r0.b()
            r25 = r1
            java.lang.String r1 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r14 = r14.E(r1)
            if (r14 != 0) goto L_0x00cf
            r14 = r16
        L_0x00ca:
            r27 = r2
            r26 = r3
            goto L_0x00da
        L_0x00cf:
            boolean r14 = r14.booleanValue()
            r14 = r14 ^ 1
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            goto L_0x00ca
        L_0x00da:
            long r2 = r0.f2993h
            r28 = r2
            java.util.List r2 = r0.f2994i
            com.google.android.gms.measurement.internal.z2 r3 = r0.e()
            com.google.android.gms.measurement.internal.A3 r3 = r3.M()
            java.lang.String r3 = r3.x()
            r30 = r2
            java.lang.String r2 = r0.f2995j
            if (r2 != 0) goto L_0x00fc
            com.google.android.gms.measurement.internal.d6 r2 = r0.g()
            java.lang.String r2 = r2.U0()
            r0.f2995j = r2
        L_0x00fc:
            java.lang.String r2 = r0.f2995j
            boolean r31 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r31 == 0) goto L_0x0125
            r31 = r2
            com.google.android.gms.measurement.internal.g r2 = r0.b()
            r32 = r3
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2453Y0
            boolean r2 = r2.q(r3)
            if (r2 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.z2 r2 = r0.e()
            com.google.android.gms.measurement.internal.A3 r2 = r2.M()
            com.google.android.gms.measurement.internal.A3$a r3 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE
            boolean r2 = r2.m(r3)
            if (r2 != 0) goto L_0x0129
            goto L_0x015f
        L_0x0125:
            r31 = r2
            r32 = r3
        L_0x0129:
            r0.k()
            long r2 = r0.f3000o
            int r16 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r16 == 0) goto L_0x0154
            R.d r2 = r0.B()
            long r2 = r2.currentTimeMillis()
            r33 = r2
            long r2 = r0.f3000o
            long r2 = r33 - r2
            r33 = r2
            java.lang.String r2 = r0.f2999n
            if (r2 == 0) goto L_0x0154
            r2 = 86400000(0x5265c00, double:4.2687272E-316)
            int r16 = (r33 > r2 ? 1 : (r33 == r2 ? 0 : -1))
            if (r16 <= 0) goto L_0x0154
            java.lang.String r2 = r0.f3001p
            if (r2 != 0) goto L_0x0154
            r0.I()
        L_0x0154:
            java.lang.String r2 = r0.f2999n
            if (r2 != 0) goto L_0x015b
            r0.I()
        L_0x015b:
            java.lang.String r2 = r0.f2999n
            r16 = r2
        L_0x015f:
            com.google.android.gms.measurement.internal.g r2 = r0.b()
            java.lang.String r3 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r2 = r2.E(r3)
            if (r2 != 0) goto L_0x016d
            r2 = 0
            goto L_0x0171
        L_0x016d:
            boolean r2 = r2.booleanValue()
        L_0x0171:
            com.google.android.gms.measurement.internal.d6 r3 = r0.g()
            java.lang.String r0 = r42.F()
            long r33 = r3.z0(r0)
            com.google.android.gms.measurement.internal.z2 r0 = r42.e()
            com.google.android.gms.measurement.internal.A3 r0 = r0.M()
            int r35 = r0.b()
            com.google.android.gms.measurement.internal.z2 r0 = r42.e()
            com.google.android.gms.measurement.internal.v r0 = r0.L()
            java.lang.String r36 = r0.j()
            boolean r0 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r0 == 0) goto L_0x01b1
            com.google.android.gms.measurement.internal.g r0 = r42.b()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2423J0
            boolean r0 = r0.q(r3)
            if (r0 == 0) goto L_0x01b1
            r42.g()
            int r0 = com.google.android.gms.measurement.internal.d6.y0()
            r37 = r0
            goto L_0x01b3
        L_0x01b1:
            r37 = 0
        L_0x01b3:
            boolean r0 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r0 == 0) goto L_0x01cd
            com.google.android.gms.measurement.internal.g r0 = r42.b()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2423J0
            boolean r0 = r0.q(r3)
            if (r0 == 0) goto L_0x01cd
            com.google.android.gms.measurement.internal.d6 r0 = r42.g()
            long r17 = r0.Q0()
        L_0x01cd:
            r38 = r17
            com.google.android.gms.measurement.internal.g r0 = r42.b()
            java.lang.String r40 = r0.T()
            com.google.android.gms.measurement.internal.g r0 = r42.b()
            r3 = 1
            f0.p r0 = r0.y(r1, r3)
            com.google.android.gms.measurement.internal.B1 r1 = new com.google.android.gms.measurement.internal.B1
            r1.<init>(r0)
            java.lang.String r41 = r1.c()
            r18 = r8
            r8 = 106000(0x19e10, double:5.2371E-319)
            r1 = r22
            r22 = r25
            r3 = r26
            r25 = r28
            r29 = r32
            r32 = r2
            r2 = r27
            r27 = r30
            r30 = r31
            r31 = r16
            r16 = 0
            r28 = 0
            r24 = r14
            r14 = r12
            r12 = r43
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (long) r5, (java.lang.String) r7, (long) r8, (long) r10, (java.lang.String) r12, (boolean) r13, (boolean) r14, (java.lang.String) r15, (long) r16, (long) r18, (int) r20, (boolean) r21, (boolean) r22, (java.lang.String) r23, (java.lang.Boolean) r24, (long) r25, (java.util.List) r27, (java.lang.String) r28, (java.lang.String) r29, (java.lang.String) r30, (java.lang.String) r31, (boolean) r32, (long) r33, (int) r35, (java.lang.String) r36, (int) r37, (long) r38, (java.lang.String) r40, (java.lang.String) r41)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0772g2.y(java.lang.String):com.google.android.gms.measurement.internal.M5");
    }

    /* access modifiers changed from: package-private */
    public final int z() {
        s();
        return this.f2996k;
    }
}
