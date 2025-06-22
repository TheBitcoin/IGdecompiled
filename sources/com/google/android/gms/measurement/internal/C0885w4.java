package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.w4  reason: case insensitive filesystem */
public final class C0885w4 extends C0897y2 {

    /* renamed from: c  reason: collision with root package name */
    private volatile C0892x4 f3274c;

    /* renamed from: d  reason: collision with root package name */
    private volatile C0892x4 f3275d;

    /* renamed from: e  reason: collision with root package name */
    protected C0892x4 f3276e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f3277f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private Activity f3278g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f3279h;

    /* renamed from: i  reason: collision with root package name */
    private volatile C0892x4 f3280i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public C0892x4 f3281j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3282k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f3283l = new Object();

    public C0885w4(S2 s22) {
        super(s22);
    }

    private final String D(Class cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] split = canonicalName.split("\\.");
        if (split.length > 0) {
            str2 = split[split.length - 1];
        } else {
            str2 = "";
        }
        if (str2.length() > b().o((String) null, false)) {
            return str2.substring(0, b().o((String) null, false));
        }
        return str2;
    }

    private final void G(Activity activity, C0892x4 x4Var, boolean z4) {
        C0892x4 x4Var2;
        C0892x4 x4Var3;
        String str;
        if (this.f3274c == null) {
            x4Var2 = this.f3275d;
        } else {
            x4Var2 = this.f3274c;
        }
        C0892x4 x4Var4 = x4Var2;
        if (x4Var.f3295b == null) {
            if (activity != null) {
                str = D(activity.getClass(), "Activity");
            } else {
                str = null;
            }
            x4Var3 = new C0892x4(x4Var.f3294a, str, x4Var.f3296c, x4Var.f3298e, x4Var.f3299f);
        } else {
            x4Var3 = x4Var;
        }
        this.f3275d = this.f3274c;
        this.f3274c = x4Var3;
        f().D(new C0899y4(this, x4Var3, x4Var4, B().elapsedRealtime(), z4));
    }

    static /* synthetic */ void J(C0885w4 w4Var, Bundle bundle, C0892x4 x4Var, C0892x4 x4Var2, long j4) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        w4Var.N(x4Var, x4Var2, j4, true, w4Var.g().F((String) null, "screen_view", bundle, (List) null, false));
    }

    /* access modifiers changed from: private */
    public final void N(C0892x4 x4Var, C0892x4 x4Var2, long j4, boolean z4, Bundle bundle) {
        boolean z5;
        Bundle bundle2;
        String str;
        long j5;
        C0892x4 x4Var3 = x4Var;
        C0892x4 x4Var4 = x4Var2;
        long j6 = j4;
        Bundle bundle3 = bundle;
        k();
        boolean z6 = false;
        if (x4Var4 == null || x4Var4.f3296c != x4Var3.f3296c || !Objects.equals(x4Var4.f3295b, x4Var3.f3295b) || !Objects.equals(x4Var4.f3294a, x4Var3.f3294a)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z4 && this.f3276e != null) {
            z6 = true;
        }
        if (z5) {
            if (bundle3 == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            d6.X(x4Var, bundle4, true);
            if (x4Var4 != null) {
                String str2 = x4Var4.f3294a;
                if (str2 != null) {
                    bundle4.putString("_pn", str2);
                }
                String str3 = x4Var4.f3295b;
                if (str3 != null) {
                    bundle4.putString("_pc", str3);
                }
                bundle4.putLong("_pi", x4Var4.f3296c);
            }
            if (z6) {
                long a5 = r().f3189f.a(j6);
                if (a5 > 0) {
                    g().M(bundle4, a5);
                }
            }
            if (!b().V()) {
                bundle4.putLong("_mst", 1);
            }
            if (x4Var3.f3298e) {
                str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
            } else {
                str = "auto";
            }
            String str4 = str;
            long currentTimeMillis = B().currentTimeMillis();
            if (x4Var3.f3298e) {
                long j7 = x4Var3.f3299f;
                if (j7 != 0) {
                    j5 = j7;
                    o().e0(str4, "_vs", j5, bundle4);
                }
            }
            j5 = currentTimeMillis;
            o().e0(str4, "_vs", j5, bundle4);
        }
        if (z6) {
            O(this.f3276e, true, j6);
        }
        this.f3276e = x4Var3;
        if (x4Var3.f3298e) {
            this.f3281j = x4Var3;
        }
        q().J(x4Var);
    }

    /* access modifiers changed from: private */
    public final void O(C0892x4 x4Var, boolean z4, long j4) {
        boolean z5;
        l().s(B().elapsedRealtime());
        if (x4Var == null || !x4Var.f3297d) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (r().E(z5, z4, j4) && x4Var != null) {
            x4Var.f3297d = false;
        }
    }

    private final C0892x4 T(Activity activity) {
        C0335p.l(activity);
        C0892x4 x4Var = (C0892x4) this.f3277f.get(Integer.valueOf(activity.hashCode()));
        if (x4Var == null) {
            C0892x4 x4Var2 = new C0892x4((String) null, D(activity.getClass(), "Activity"), g().R0());
            this.f3277f.put(Integer.valueOf(activity.hashCode()), x4Var2);
            x4Var = x4Var2;
        }
        if (this.f3280i != null) {
            return this.f3280i;
        }
        return x4Var;
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

    public final void E(Activity activity) {
        synchronized (this.f3283l) {
            try {
                if (activity == this.f3278g) {
                    this.f3278g = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (b().V()) {
            this.f3277f.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public final void F(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (b().V() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.f3277f.put(Integer.valueOf(activity.hashCode()), new C0892x4(bundle2.getString(RewardPlus.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void H(Activity activity, String str, String str2) {
        String str3;
        if (!b().V()) {
            a().M().a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        C0892x4 x4Var = this.f3274c;
        if (x4Var == null) {
            a().M().a("setCurrentScreen cannot be called while no activity active");
        } else if (this.f3277f.get(Integer.valueOf(activity.hashCode())) == null) {
            a().M().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = D(activity.getClass(), "Activity");
            }
            boolean equals = Objects.equals(x4Var.f3295b, str2);
            boolean equals2 = Objects.equals(x4Var.f3294a, str);
            if (equals && equals2) {
                a().M().a("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > b().o((String) null, false))) {
                a().M().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= b().o((String) null, false))) {
                C0835p2 K4 = a().K();
                if (str == null) {
                    str3 = "null";
                } else {
                    str3 = str;
                }
                K4.c("Setting current screen to name, class", str3, str2);
                C0892x4 x4Var2 = new C0892x4(str, str2, g().R0());
                this.f3277f.put(Integer.valueOf(activity.hashCode()), x4Var2);
                G(activity, x4Var2, true);
            } else {
                a().M().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c6, code lost:
        r0 = a().K();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d0, code lost:
        if (r4 != null) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d5, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d6, code lost:
        if (r5 != null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d8, code lost:
        r3 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00db, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dc, code lost:
        r0.c("Logging screen view with name, class", r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
        if (r13.f3274c != null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e3, code lost:
        r0 = r13.f3275d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e6, code lost:
        r0 = r13.f3274c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e8, code lost:
        r3 = new com.google.android.gms.measurement.internal.C0892x4(r4, r5, g().R0(), true, r15);
        r13.f3274c = r3;
        r13.f3275d = r0;
        r13.f3280i = r3;
        f().D(new com.google.android.gms.measurement.internal.C0906z4(r13, r14, r3, r0, B().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(android.os.Bundle r14, long r15) {
        /*
            r13 = this;
            java.lang.Object r1 = r13.f3283l
            monitor-enter(r1)
            boolean r0 = r13.f3282k     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x001a
            com.google.android.gms.measurement.internal.n2 r14 = r13.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.p2 r14 = r14.M()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Cannot log screen view event when the app is in the background."
            r14.a(r0)     // Catch:{ all -> 0x0016 }
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x0016:
            r0 = move-exception
            r14 = r0
            goto L_0x0116
        L_0x001a:
            r0 = 0
            r2 = 0
            if (r14 == 0) goto L_0x0087
            java.lang.String r3 = "screen_name"
            java.lang.String r3 = r14.getString(r3)     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x0051
            int r4 = r3.length()     // Catch:{ all -> 0x0016 }
            if (r4 <= 0) goto L_0x003a
            int r4 = r3.length()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.g r5 = r13.b()     // Catch:{ all -> 0x0016 }
            int r5 = r5.o(r2, r0)     // Catch:{ all -> 0x0016 }
            if (r4 <= r5) goto L_0x0051
        L_0x003a:
            com.google.android.gms.measurement.internal.n2 r14 = r13.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.p2 r14 = r14.M()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Invalid screen name length for screen view. Length"
            int r2 = r3.length()     // Catch:{ all -> 0x0016 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0016 }
            r14.b(r0, r2)     // Catch:{ all -> 0x0016 }
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x0051:
            java.lang.String r4 = "screen_class"
            java.lang.String r4 = r14.getString(r4)     // Catch:{ all -> 0x0016 }
            if (r4 == 0) goto L_0x0084
            int r5 = r4.length()     // Catch:{ all -> 0x0016 }
            if (r5 <= 0) goto L_0x006d
            int r5 = r4.length()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.g r6 = r13.b()     // Catch:{ all -> 0x0016 }
            int r2 = r6.o(r2, r0)     // Catch:{ all -> 0x0016 }
            if (r5 <= r2) goto L_0x0084
        L_0x006d:
            com.google.android.gms.measurement.internal.n2 r14 = r13.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.p2 r14 = r14.M()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Invalid screen class length for screen view. Length"
            int r2 = r4.length()     // Catch:{ all -> 0x0016 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0016 }
            r14.b(r0, r2)     // Catch:{ all -> 0x0016 }
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x0084:
            r2 = r4
            r4 = r3
            goto L_0x0088
        L_0x0087:
            r4 = r2
        L_0x0088:
            if (r2 != 0) goto L_0x009b
            android.app.Activity r2 = r13.f3278g     // Catch:{ all -> 0x0016 }
            if (r2 == 0) goto L_0x0099
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x0016 }
            java.lang.String r3 = "Activity"
            java.lang.String r2 = r13.D(r2, r3)     // Catch:{ all -> 0x0016 }
            goto L_0x009b
        L_0x0099:
            java.lang.String r2 = "Activity"
        L_0x009b:
            r5 = r2
            com.google.android.gms.measurement.internal.x4 r2 = r13.f3274c     // Catch:{ all -> 0x0016 }
            boolean r3 = r13.f3279h     // Catch:{ all -> 0x0016 }
            if (r3 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00c5
            r13.f3279h = r0     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = r2.f3295b     // Catch:{ all -> 0x0016 }
            boolean r0 = j$.util.Objects.equals(r0, r5)     // Catch:{ all -> 0x0016 }
            java.lang.String r2 = r2.f3294a     // Catch:{ all -> 0x0016 }
            boolean r2 = j$.util.Objects.equals(r2, r4)     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.n2 r14 = r13.a()     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.p2 r14 = r14.M()     // Catch:{ all -> 0x0016 }
            java.lang.String r0 = "Ignoring call to log screen view event with duplicate parameters."
            r14.a(r0)     // Catch:{ all -> 0x0016 }
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            return
        L_0x00c5:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            com.google.android.gms.measurement.internal.n2 r0 = r13.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            java.lang.String r1 = "Logging screen view with name, class"
            if (r4 != 0) goto L_0x00d5
            java.lang.String r2 = "null"
            goto L_0x00d6
        L_0x00d5:
            r2 = r4
        L_0x00d6:
            if (r5 != 0) goto L_0x00db
            java.lang.String r3 = "null"
            goto L_0x00dc
        L_0x00db:
            r3 = r5
        L_0x00dc:
            r0.c(r1, r2, r3)
            com.google.android.gms.measurement.internal.x4 r0 = r13.f3274c
            if (r0 != 0) goto L_0x00e6
            com.google.android.gms.measurement.internal.x4 r0 = r13.f3275d
            goto L_0x00e8
        L_0x00e6:
            com.google.android.gms.measurement.internal.x4 r0 = r13.f3274c
        L_0x00e8:
            com.google.android.gms.measurement.internal.x4 r3 = new com.google.android.gms.measurement.internal.x4
            com.google.android.gms.measurement.internal.d6 r1 = r13.g()
            long r6 = r1.R0()
            r8 = 1
            r9 = r15
            r3.<init>(r4, r5, r6, r8, r9)
            r13.f3274c = r3
            r13.f3275d = r0
            r13.f3280i = r3
            R.d r1 = r13.B()
            long r11 = r1.elapsedRealtime()
            com.google.android.gms.measurement.internal.P2 r1 = r13.f()
            com.google.android.gms.measurement.internal.z4 r6 = new com.google.android.gms.measurement.internal.z4
            r7 = r13
            r8 = r14
            r10 = r0
            r9 = r3
            r6.<init>(r7, r8, r9, r10, r11)
            r1.D(r6)
            return
        L_0x0116:
            monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0885w4.I(android.os.Bundle, long):void");
    }

    public final C0892x4 P() {
        return this.f3274c;
    }

    public final void Q(Activity activity) {
        synchronized (this.f3283l) {
            this.f3282k = false;
            this.f3279h = true;
        }
        long elapsedRealtime = B().elapsedRealtime();
        if (!b().V()) {
            this.f3274c = null;
            f().D(new A4(this, elapsedRealtime));
            return;
        }
        C0892x4 T4 = T(activity);
        this.f3275d = this.f3274c;
        this.f3274c = null;
        f().D(new D4(this, T4, elapsedRealtime));
    }

    public final void R(Activity activity, Bundle bundle) {
        C0892x4 x4Var;
        if (b().V() && bundle != null && (x4Var = (C0892x4) this.f3277f.get(Integer.valueOf(activity.hashCode()))) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", x4Var.f3296c);
            bundle2.putString(RewardPlus.NAME, x4Var.f3294a);
            bundle2.putString("referrer_name", x4Var.f3295b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void S(Activity activity) {
        synchronized (this.f3283l) {
            this.f3282k = true;
            if (activity != this.f3278g) {
                synchronized (this.f3283l) {
                    this.f3278g = activity;
                    this.f3279h = false;
                }
                if (b().V()) {
                    this.f3280i = null;
                    f().D(new C4(this));
                }
            }
        }
        if (!b().V()) {
            this.f3274c = this.f3280i;
            f().D(new B4(this));
            return;
        }
        G(activity, T(activity), false);
        C0894y l4 = l();
        l4.f().D(new Y(l4, l4.B().elapsedRealtime()));
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
    public final boolean x() {
        return false;
    }

    public final C0892x4 z(boolean z4) {
        s();
        k();
        if (!z4) {
            return this.f3276e;
        }
        C0892x4 x4Var = this.f3276e;
        if (x4Var != null) {
            return x4Var;
        }
        return this.f3281j;
    }
}
