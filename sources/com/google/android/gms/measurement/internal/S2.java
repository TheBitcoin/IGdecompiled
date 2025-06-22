package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import R.g;
import T.e;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.C0526c1;
import com.google.android.gms.internal.measurement.C0591j3;
import com.google.android.gms.internal.measurement.R6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import f0.C0913b;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class S2 implements C0898y3 {

    /* renamed from: I  reason: collision with root package name */
    private static volatile S2 f2709I;

    /* renamed from: A  reason: collision with root package name */
    private volatile Boolean f2710A;

    /* renamed from: B  reason: collision with root package name */
    private Boolean f2711B;

    /* renamed from: C  reason: collision with root package name */
    private Boolean f2712C;

    /* renamed from: D  reason: collision with root package name */
    private volatile boolean f2713D;

    /* renamed from: E  reason: collision with root package name */
    private int f2714E;

    /* renamed from: F  reason: collision with root package name */
    private int f2715F;

    /* renamed from: G  reason: collision with root package name */
    private AtomicInteger f2716G = new AtomicInteger(0);

    /* renamed from: H  reason: collision with root package name */
    final long f2717H;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2718a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2719b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2720c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2721d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2722e;

    /* renamed from: f  reason: collision with root package name */
    private final C0741c f2723f;

    /* renamed from: g  reason: collision with root package name */
    private final C0769g f2724g;

    /* renamed from: h  reason: collision with root package name */
    private final C0904z2 f2725h;

    /* renamed from: i  reason: collision with root package name */
    private final C0821n2 f2726i;

    /* renamed from: j  reason: collision with root package name */
    private final P2 f2727j;

    /* renamed from: k  reason: collision with root package name */
    private final C0838p5 f2728k;

    /* renamed from: l  reason: collision with root package name */
    private final d6 f2729l;

    /* renamed from: m  reason: collision with root package name */
    private final C0779h2 f2730m;

    /* renamed from: n  reason: collision with root package name */
    private final d f2731n;

    /* renamed from: o  reason: collision with root package name */
    private final C0885w4 f2732o;

    /* renamed from: p  reason: collision with root package name */
    private final F3 f2733p;

    /* renamed from: q  reason: collision with root package name */
    private final C0894y f2734q;

    /* renamed from: r  reason: collision with root package name */
    private final C0857s4 f2735r;

    /* renamed from: s  reason: collision with root package name */
    private final String f2736s;

    /* renamed from: t  reason: collision with root package name */
    private C0765f2 f2737t;

    /* renamed from: u  reason: collision with root package name */
    private F4 f2738u;

    /* renamed from: v  reason: collision with root package name */
    private C0887x f2739v;

    /* renamed from: w  reason: collision with root package name */
    private C0772g2 f2740w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f2741x = false;

    /* renamed from: y  reason: collision with root package name */
    private Boolean f2742y;

    /* renamed from: z  reason: collision with root package name */
    private long f2743z;

    private S2(D3 d32) {
        long j4;
        Bundle bundle;
        boolean z4 = false;
        C0335p.l(d32);
        C0741c cVar = new C0741c(d32.f2350a);
        this.f2723f = cVar;
        C0751d2.f2933a = cVar;
        Context context = d32.f2350a;
        this.f2718a = context;
        this.f2719b = d32.f2351b;
        this.f2720c = d32.f2352c;
        this.f2721d = d32.f2353d;
        this.f2722e = d32.f2357h;
        this.f2710A = d32.f2354e;
        this.f2736s = d32.f2359j;
        this.f2713D = true;
        C0526c1 c1Var = d32.f2356g;
        if (!(c1Var == null || (bundle = c1Var.f1771g) == null)) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.f2711B = (Boolean) obj;
            }
            Object obj2 = c1Var.f1771g.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.f2712C = (Boolean) obj2;
            }
        }
        C0591j3.l(context);
        d b5 = g.b();
        this.f2731n = b5;
        Long l4 = d32.f2358i;
        if (l4 != null) {
            j4 = l4.longValue();
        } else {
            j4 = b5.currentTimeMillis();
        }
        this.f2717H = j4;
        this.f2724g = new C0769g(this);
        C0904z2 z2Var = new C0904z2(this);
        z2Var.n();
        this.f2725h = z2Var;
        C0821n2 n2Var = new C0821n2(this);
        n2Var.n();
        this.f2726i = n2Var;
        d6 d6Var = new d6(this);
        d6Var.n();
        this.f2729l = d6Var;
        this.f2730m = new C0779h2(new C3(d32, this));
        this.f2734q = new C0894y(this);
        C0885w4 w4Var = new C0885w4(this);
        w4Var.t();
        this.f2732o = w4Var;
        F3 f32 = new F3(this);
        f32.t();
        this.f2733p = f32;
        C0838p5 p5Var = new C0838p5(this);
        p5Var.t();
        this.f2728k = p5Var;
        C0857s4 s4Var = new C0857s4(this);
        s4Var.n();
        this.f2735r = s4Var;
        P2 p22 = new P2(this);
        p22.n();
        this.f2727j = p22;
        C0526c1 c1Var2 = d32.f2356g;
        if (!(c1Var2 == null || c1Var2.f1766b == 0)) {
            z4 = true;
        }
        boolean z5 = !z4;
        if (context.getApplicationContext() instanceof Application) {
            H().V0(z5);
        } else {
            a().L().a("Application context is not an Application");
        }
        p22.D(new Y2(this, d32));
    }

    public static S2 b(Context context, C0526c1 c1Var, Long l4) {
        Bundle bundle;
        if (c1Var != null && (c1Var.f1769e == null || c1Var.f1770f == null)) {
            c1Var = new C0526c1(c1Var.f1765a, c1Var.f1766b, c1Var.f1767c, c1Var.f1768d, (String) null, (String) null, c1Var.f1771g, (String) null);
        }
        C0335p.l(context);
        C0335p.l(context.getApplicationContext());
        if (f2709I == null) {
            synchronized (S2.class) {
                try {
                    if (f2709I == null) {
                        f2709I = new S2(new D3(context, c1Var, l4));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (!(c1Var == null || (bundle = c1Var.f1771g) == null || !bundle.containsKey("dataCollectionDefaultEnabled"))) {
            C0335p.l(f2709I);
            f2709I.j(c1Var.f1771g.getBoolean("dataCollectionDefaultEnabled"));
        }
        C0335p.l(f2709I);
        return f2709I;
    }

    private static void d(C0897y2 y2Var) {
        if (y2Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!y2Var.w()) {
            String valueOf = String.valueOf(y2Var.getClass());
            throw new IllegalStateException("Component not initialized: " + valueOf);
        }
    }

    static /* synthetic */ void e(S2 s22, D3 d32) {
        s22.f().k();
        C0887x xVar = new C0887x(s22);
        xVar.n();
        s22.f2739v = xVar;
        C0772g2 g2Var = new C0772g2(s22, d32.f2355f);
        g2Var.t();
        s22.f2740w = g2Var;
        C0765f2 f2Var = new C0765f2(s22);
        f2Var.t();
        s22.f2737t = f2Var;
        F4 f4 = new F4(s22);
        f4.t();
        s22.f2738u = f4;
        s22.f2729l.o();
        s22.f2725h.o();
        s22.f2740w.u();
        s22.a().J().b("App measurement initialized, version", 106000L);
        s22.a().J().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String F4 = g2Var.F();
        if (TextUtils.isEmpty(s22.f2719b)) {
            if (s22.L().E0(F4, s22.f2724g.T())) {
                s22.a().J().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                C0835p2 J4 = s22.a().J();
                J4.a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + F4);
            }
        }
        s22.a().F().a("Debug-level message logging enabled");
        if (s22.f2714E != s22.f2716G.get()) {
            s22.a().G().c("Not all components initialized", Integer.valueOf(s22.f2714E), Integer.valueOf(s22.f2716G.get()));
        }
        s22.f2741x = true;
    }

    private static void g(C0884w3 w3Var) {
        if (w3Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void h(C0905z3 z3Var) {
        if (z3Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!z3Var.p()) {
            String valueOf = String.valueOf(z3Var.getClass());
            throw new IllegalStateException("Component not initialized: " + valueOf);
        }
    }

    private final C0857s4 s() {
        h(this.f2735r);
        return this.f2735r;
    }

    public final Context A() {
        return this.f2718a;
    }

    public final d B() {
        return this.f2731n;
    }

    public final C0741c C() {
        return this.f2723f;
    }

    public final C0779h2 D() {
        return this.f2730m;
    }

    public final C0821n2 E() {
        C0821n2 n2Var = this.f2726i;
        if (n2Var == null || !n2Var.p()) {
            return null;
        }
        return this.f2726i;
    }

    public final C0904z2 F() {
        g(this.f2725h);
        return this.f2725h;
    }

    /* access modifiers changed from: package-private */
    public final P2 G() {
        return this.f2727j;
    }

    public final F3 H() {
        d(this.f2733p);
        return this.f2733p;
    }

    public final C0885w4 I() {
        d(this.f2732o);
        return this.f2732o;
    }

    public final F4 J() {
        d(this.f2738u);
        return this.f2738u;
    }

    public final C0838p5 K() {
        d(this.f2728k);
        return this.f2728k;
    }

    public final d6 L() {
        g(this.f2729l);
        return this.f2729l;
    }

    public final String M() {
        return this.f2719b;
    }

    public final String N() {
        return this.f2720c;
    }

    public final String O() {
        return this.f2721d;
    }

    public final String P() {
        return this.f2736s;
    }

    /* access modifiers changed from: package-private */
    public final void Q() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* access modifiers changed from: package-private */
    public final void R() {
        this.f2716G.incrementAndGet();
    }

    public final C0821n2 a() {
        h(this.f2726i);
        return this.f2726i;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        if (r1.A() != false) goto L_0x00de;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.google.android.gms.internal.measurement.C0526c1 r12) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r11.f()
            r0.k()
            boolean r0 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.g r0 = r11.f2724g
            com.google.android.gms.measurement.internal.b2 r1 = com.google.android.gms.measurement.internal.G.f2423J0
            boolean r0 = r0.q(r1)
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.d6 r0 = r11.L()
            boolean r0 = r0.X0()
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.d6 r0 = r11.L()
            r0.k()
            android.content.IntentFilter r1 = new android.content.IntentFilter
            r1.<init>()
            java.lang.String r2 = "com.google.android.gms.measurement.TRIGGERS_AVAILABLE"
            r1.addAction(r2)
            f0.F r2 = new f0.F
            com.google.android.gms.measurement.internal.S2 r3 = r0.f3273a
            r2.<init>(r3)
            android.content.Context r3 = r0.A()
            r4 = 2
            androidx.core.content.ContextCompat.registerReceiver(r3, r2, r1, r4)
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.F()
            java.lang.String r1 = "Registered app receiver"
            r0.a(r1)
        L_0x004e:
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            com.google.android.gms.measurement.internal.A3 r0 = r0.M()
            int r1 = r0.b()
            com.google.android.gms.measurement.internal.g r2 = r11.f2724g
            java.lang.String r3 = "google_analytics_default_allow_ad_storage"
            r4 = 0
            f0.p r2 = r2.y(r3, r4)
            com.google.android.gms.measurement.internal.g r3 = r11.f2724g
            java.lang.String r5 = "google_analytics_default_allow_analytics_storage"
            f0.p r3 = r3.y(r5, r4)
            f0.p r5 = f0.p.UNINITIALIZED
            r6 = -10
            r7 = 0
            r8 = 30
            if (r2 != r5) goto L_0x0076
            if (r3 == r5) goto L_0x0085
        L_0x0076:
            com.google.android.gms.measurement.internal.z2 r9 = r11.F()
            boolean r9 = r9.v(r6)
            if (r9 == 0) goto L_0x0085
            com.google.android.gms.measurement.internal.A3 r1 = com.google.android.gms.measurement.internal.A3.e(r2, r3, r6)
            goto L_0x00de
        L_0x0085:
            com.google.android.gms.measurement.internal.g2 r2 = r11.y()
            java.lang.String r2 = r2.G()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x00b2
            if (r1 == 0) goto L_0x00a3
            if (r1 == r8) goto L_0x00a3
            r2 = 10
            if (r1 == r2) goto L_0x00a3
            if (r1 == r8) goto L_0x00a3
            if (r1 == r8) goto L_0x00a3
            r2 = 40
            if (r1 != r2) goto L_0x00b2
        L_0x00a3:
            com.google.android.gms.measurement.internal.F3 r1 = r11.H()
            com.google.android.gms.measurement.internal.A3 r2 = new com.google.android.gms.measurement.internal.A3
            r2.<init>(r7, r7, r6)
            long r9 = r11.f2717H
            r1.S(r2, r9, r4)
            goto L_0x00dd
        L_0x00b2:
            com.google.android.gms.measurement.internal.g2 r1 = r11.y()
            java.lang.String r1 = r1.G()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x00dd
            if (r12 == 0) goto L_0x00dd
            android.os.Bundle r1 = r12.f1771g
            if (r1 == 0) goto L_0x00dd
            com.google.android.gms.measurement.internal.z2 r1 = r11.F()
            boolean r1 = r1.v(r8)
            if (r1 == 0) goto L_0x00dd
            android.os.Bundle r1 = r12.f1771g
            com.google.android.gms.measurement.internal.A3 r1 = com.google.android.gms.measurement.internal.A3.c(r1, r8)
            boolean r2 = r1.A()
            if (r2 == 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r1 = r7
        L_0x00de:
            r2 = 1
            if (r1 == 0) goto L_0x00eb
            com.google.android.gms.measurement.internal.F3 r0 = r11.H()
            long r9 = r11.f2717H
            r0.S(r1, r9, r2)
            r0 = r1
        L_0x00eb:
            com.google.android.gms.measurement.internal.F3 r1 = r11.H()
            r1.R(r0)
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            com.google.android.gms.measurement.internal.v r0 = r0.L()
            int r0 = r0.a()
            com.google.android.gms.measurement.internal.g r1 = r11.f2724g
            java.lang.String r3 = "google_analytics_default_allow_ad_personalization_signals"
            f0.p r1 = r1.y(r3, r2)
            if (r1 == r5) goto L_0x0115
            com.google.android.gms.measurement.internal.n2 r3 = r11.a()
            com.google.android.gms.measurement.internal.p2 r3 = r3.K()
            java.lang.String r9 = "Default ad personalization consent from Manifest"
            r3.b(r9, r1)
        L_0x0115:
            com.google.android.gms.measurement.internal.g r1 = r11.f2724g
            java.lang.String r3 = "google_analytics_default_allow_ad_user_data"
            f0.p r1 = r1.y(r3, r2)
            if (r1 == r5) goto L_0x0132
            boolean r3 = com.google.android.gms.measurement.internal.A3.l(r6, r0)
            if (r3 == 0) goto L_0x0132
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            com.google.android.gms.measurement.internal.v r0 = com.google.android.gms.measurement.internal.C0873v.c(r1, r6)
            r12.Q(r0, r2)
            goto L_0x01b5
        L_0x0132:
            com.google.android.gms.measurement.internal.g2 r1 = r11.y()
            java.lang.String r1 = r1.G()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0151
            if (r0 == 0) goto L_0x0144
            if (r0 != r8) goto L_0x0151
        L_0x0144:
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            com.google.android.gms.measurement.internal.v r0 = new com.google.android.gms.measurement.internal.v
            r0.<init>(r7, r6)
            r12.Q(r0, r2)
            goto L_0x01b5
        L_0x0151:
            com.google.android.gms.measurement.internal.g2 r1 = r11.y()
            java.lang.String r1 = r1.G()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x017e
            if (r12 == 0) goto L_0x017e
            android.os.Bundle r1 = r12.f1771g
            if (r1 == 0) goto L_0x017e
            boolean r0 = com.google.android.gms.measurement.internal.A3.l(r8, r0)
            if (r0 == 0) goto L_0x017e
            android.os.Bundle r0 = r12.f1771g
            com.google.android.gms.measurement.internal.v r0 = com.google.android.gms.measurement.internal.C0873v.b(r0, r8)
            boolean r1 = r0.k()
            if (r1 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.F3 r1 = r11.H()
            r1.Q(r0, r2)
        L_0x017e:
            com.google.android.gms.measurement.internal.g2 r0 = r11.y()
            java.lang.String r0 = r0.G()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x01b5
            if (r12 == 0) goto L_0x01b5
            android.os.Bundle r0 = r12.f1771g
            if (r0 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            com.google.android.gms.measurement.internal.C2 r0 = r0.f3330o
            java.lang.String r0 = r0.a()
            if (r0 != 0) goto L_0x01b5
            android.os.Bundle r0 = r12.f1771g
            java.lang.Boolean r0 = com.google.android.gms.measurement.internal.C0873v.e(r0)
            if (r0 == 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.F3 r1 = r11.H()
            java.lang.String r12 = r12.f1769e
            java.lang.String r3 = "allow_personalized_ads"
            java.lang.String r0 = r0.toString()
            r1.l0(r12, r3, r0, r4)
        L_0x01b5:
            com.google.android.gms.measurement.internal.g r12 = r11.f2724g
            java.lang.String r0 = "google_analytics_tcf_data_enabled"
            java.lang.Boolean r12 = r12.E(r0)
            if (r12 != 0) goto L_0x01c1
            r12 = 1
            goto L_0x01c5
        L_0x01c1:
            boolean r12 = r12.booleanValue()
        L_0x01c5:
            if (r12 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.F()
            java.lang.String r0 = "TCF client enabled."
            r12.a(r0)
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            r12.I0()
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            r12.G0()
        L_0x01e2:
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.A2 r12 = r12.f3322g
            long r0 = r12.a()
            r5 = 0
            int r12 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r12 != 0) goto L_0x0210
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.K()
            long r0 = r11.f2717H
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "Persisting first open"
            r12.b(r1, r0)
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.A2 r12 = r12.f3322g
            long r0 = r11.f2717H
            r12.b(r0)
        L_0x0210:
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            com.google.android.gms.measurement.internal.i6 r12 = r12.f2390q
            r12.c()
            boolean r12 = r11.p()
            if (r12 != 0) goto L_0x02a4
            boolean r12 = r11.m()
            if (r12 == 0) goto L_0x0404
            com.google.android.gms.measurement.internal.d6 r12 = r11.L()
            java.lang.String r0 = "android.permission.INTERNET"
            boolean r12 = r12.F0(r0)
            if (r12 != 0) goto L_0x023e
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()
            java.lang.String r0 = "App is missing INTERNET permission"
            r12.a(r0)
        L_0x023e:
            com.google.android.gms.measurement.internal.d6 r12 = r11.L()
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r12 = r12.F0(r0)
            if (r12 != 0) goto L_0x0257
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()
            java.lang.String r0 = "App is missing ACCESS_NETWORK_STATE permission"
            r12.a(r0)
        L_0x0257:
            android.content.Context r12 = r11.f2718a
            T.d r12 = T.e.a(r12)
            boolean r12 = r12.f()
            if (r12 != 0) goto L_0x0295
            com.google.android.gms.measurement.internal.g r12 = r11.f2724g
            boolean r12 = r12.X()
            if (r12 != 0) goto L_0x0295
            android.content.Context r12 = r11.f2718a
            boolean r12 = com.google.android.gms.measurement.internal.d6.d0(r12)
            if (r12 != 0) goto L_0x0280
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()
            java.lang.String r0 = "AppMeasurementReceiver not registered/enabled"
            r12.a(r0)
        L_0x0280:
            android.content.Context r12 = r11.f2718a
            boolean r12 = com.google.android.gms.measurement.internal.d6.e0(r12, r4)
            if (r12 != 0) goto L_0x0295
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()
            java.lang.String r0 = "AppMeasurementService not registered/enabled"
            r12.a(r0)
        L_0x0295:
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()
            java.lang.String r0 = "Uploading is not possible. App measurement disabled"
            r12.a(r0)
            goto L_0x0404
        L_0x02a4:
            com.google.android.gms.measurement.internal.g2 r12 = r11.y()
            java.lang.String r12 = r12.G()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x02c0
            com.google.android.gms.measurement.internal.g2 r12 = r11.y()
            java.lang.String r12 = r12.E()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0340
        L_0x02c0:
            r11.L()
            com.google.android.gms.measurement.internal.g2 r12 = r11.y()
            java.lang.String r12 = r12.G()
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            java.lang.String r0 = r0.S()
            com.google.android.gms.measurement.internal.g2 r1 = r11.y()
            java.lang.String r1 = r1.E()
            com.google.android.gms.measurement.internal.z2 r3 = r11.F()
            java.lang.String r3 = r3.R()
            boolean r12 = com.google.android.gms.measurement.internal.d6.m0(r12, r0, r1, r3)
            if (r12 == 0) goto L_0x0322
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.J()
            java.lang.String r0 = "Rechecking which service to use due to a GMP App Id change"
            r12.a(r0)
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            r12.T()
            com.google.android.gms.measurement.internal.f2 r12 = r11.z()
            r12.H()
            com.google.android.gms.measurement.internal.F4 r12 = r11.f2738u
            r12.a0()
            com.google.android.gms.measurement.internal.F4 r12 = r11.f2738u
            r12.Z()
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.A2 r12 = r12.f3322g
            long r0 = r11.f2717H
            r12.b(r0)
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.C2 r12 = r12.f3324i
            r12.b(r7)
        L_0x0322:
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.g2 r0 = r11.y()
            java.lang.String r0 = r0.G()
            r12.I(r0)
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.g2 r0 = r11.y()
            java.lang.String r0 = r0.E()
            r12.F(r0)
        L_0x0340:
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.A3 r12 = r12.M()
            com.google.android.gms.measurement.internal.A3$a r0 = com.google.android.gms.measurement.internal.A3.a.ANALYTICS_STORAGE
            boolean r12 = r12.m(r0)
            if (r12 != 0) goto L_0x0359
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.C2 r12 = r12.f3324i
            r12.b(r7)
        L_0x0359:
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            com.google.android.gms.measurement.internal.C2 r0 = r0.f3324i
            java.lang.String r0 = r0.a()
            r12.a1(r0)
            com.google.android.gms.measurement.internal.d6 r12 = r11.L()
            boolean r12 = r12.Y0()
            if (r12 != 0) goto L_0x039a
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.C2 r12 = r12.f3339x
            java.lang.String r12 = r12.a()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x039a
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.L()
            java.lang.String r0 = "Remote config removed with active feature rollouts"
            r12.a(r0)
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.C2 r12 = r12.f3339x
            r12.b(r7)
        L_0x039a:
            com.google.android.gms.measurement.internal.g2 r12 = r11.y()
            java.lang.String r12 = r12.G()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L_0x03b6
            com.google.android.gms.measurement.internal.g2 r12 = r11.y()
            java.lang.String r12 = r12.E()
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x0404
        L_0x03b6:
            boolean r12 = r11.m()
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            boolean r0 = r0.D()
            if (r0 != 0) goto L_0x03d5
            com.google.android.gms.measurement.internal.g r0 = r11.f2724g
            boolean r0 = r0.W()
            if (r0 != 0) goto L_0x03d5
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            r1 = r12 ^ 1
            r0.G(r1)
        L_0x03d5:
            if (r12 == 0) goto L_0x03de
            com.google.android.gms.measurement.internal.F3 r12 = r11.H()
            r12.C0()
        L_0x03de:
            com.google.android.gms.measurement.internal.p5 r12 = r11.K()
            com.google.android.gms.measurement.internal.w5 r12 = r12.f3188e
            r12.a()
            com.google.android.gms.measurement.internal.F4 r12 = r11.J()
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            r12.Q(r0)
            com.google.android.gms.measurement.internal.F4 r12 = r11.J()
            com.google.android.gms.measurement.internal.z2 r0 = r11.F()
            com.google.android.gms.measurement.internal.B2 r0 = r0.f3317A
            android.os.Bundle r0 = r0.a()
            r12.z(r0)
        L_0x0404:
            boolean r12 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r12 == 0) goto L_0x0432
            com.google.android.gms.measurement.internal.g r12 = r11.f2724g
            com.google.android.gms.measurement.internal.b2 r0 = com.google.android.gms.measurement.internal.G.f2423J0
            boolean r12 = r12.q(r0)
            if (r12 == 0) goto L_0x0432
            com.google.android.gms.measurement.internal.d6 r12 = r11.L()
            boolean r12 = r12.X0()
            if (r12 == 0) goto L_0x0432
            java.lang.Thread r12 = new java.lang.Thread
            com.google.android.gms.measurement.internal.F3 r0 = r11.H()
            j$.util.Objects.requireNonNull(r0)
            com.google.android.gms.measurement.internal.W2 r1 = new com.google.android.gms.measurement.internal.W2
            r1.<init>(r0)
            r12.<init>(r1)
            r12.start()
        L_0x0432:
            com.google.android.gms.measurement.internal.z2 r12 = r11.F()
            com.google.android.gms.measurement.internal.x2 r12 = r12.f3332q
            r12.a(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.S2.c(com.google.android.gms.internal.measurement.c1):void");
    }

    public final P2 f() {
        h(this.f2727j);
        return this.f2727j;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void i(String str, int i4, Throwable th, byte[] bArr, Map map) {
        if ((i4 == 200 || i4 == 204 || i4 == 304) && th == null) {
            F().f3337v.a(true);
            if (bArr == null || bArr.length == 0) {
                a().F().a("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                if (TextUtils.isEmpty(optString)) {
                    a().F().a("Deferred Deep Link is empty.");
                    return;
                }
                String optString2 = jSONObject.optString("gclid", "");
                String optString3 = jSONObject.optString("gbraid", "");
                String optString4 = jSONObject.optString("gad_source", "");
                double optDouble = jSONObject.optDouble(CampaignEx.JSON_KEY_TIMESTAMP, 0.0d);
                Bundle bundle = new Bundle();
                if (!R6.a() || !this.f2724g.q(G.f2445U0)) {
                    if (!L().L0(optString)) {
                        a().L().c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                        return;
                    }
                } else if (!L().L0(optString)) {
                    a().L().d("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                    return;
                } else {
                    if (!TextUtils.isEmpty(optString3)) {
                        bundle.putString("gbraid", optString3);
                    }
                    if (!TextUtils.isEmpty(optString4)) {
                        bundle.putString("gad_source", optString4);
                    }
                }
                if (R6.a()) {
                    this.f2724g.q(G.f2445U0);
                }
                bundle.putString("gclid", optString2);
                bundle.putString("_cis", "ddp");
                this.f2733p.b1("auto", "_cmp", bundle);
                d6 L4 = L();
                if (!TextUtils.isEmpty(optString) && L4.i0(optString, optDouble)) {
                    L4.A().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                }
            } catch (JSONException e5) {
                a().G().b("Failed to parse the Deferred Deep Link response. exception", e5);
            }
        } else {
            a().L().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i4), th);
        }
    }

    /* access modifiers changed from: package-private */
    public final void j(boolean z4) {
        this.f2710A = Boolean.valueOf(z4);
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        this.f2714E++;
    }

    public final boolean l() {
        if (this.f2710A == null || !this.f2710A.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        if (u() == 0) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        f().k();
        return this.f2713D;
    }

    public final boolean o() {
        return TextUtils.isEmpty(this.f2719b);
    }

    /* access modifiers changed from: protected */
    public final boolean p() {
        boolean z4;
        if (this.f2741x) {
            f().k();
            Boolean bool = this.f2742y;
            if (bool == null || this.f2743z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f2731n.elapsedRealtime() - this.f2743z) > 1000)) {
                this.f2743z = this.f2731n.elapsedRealtime();
                boolean z5 = true;
                if (!L().F0("android.permission.INTERNET") || !L().F0("android.permission.ACCESS_NETWORK_STATE") || (!e.a(this.f2718a).f() && !this.f2724g.X() && (!d6.d0(this.f2718a) || !d6.e0(this.f2718a, false)))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                Boolean valueOf = Boolean.valueOf(z4);
                this.f2742y = valueOf;
                if (valueOf.booleanValue()) {
                    if (!L().k0(y().G(), y().E()) && TextUtils.isEmpty(y().E())) {
                        z5 = false;
                    }
                    this.f2742y = Boolean.valueOf(z5);
                }
            }
            return this.f2742y.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    public final boolean q() {
        return this.f2722e;
    }

    public final boolean r() {
        Bundle bundle;
        int i4;
        String str;
        f().k();
        h(s());
        String F4 = y().F();
        boolean z4 = false;
        if (!this.f2724g.U()) {
            a().K().a("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair r4 = F().r(F4);
        if (((Boolean) r4.second).booleanValue() || TextUtils.isEmpty((CharSequence) r4.first)) {
            a().K().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        } else if (!s().t()) {
            a().L().a("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            F4 J4 = J();
            J4.k();
            J4.s();
            if (!J4.k0() || J4.g().I0() >= 234200) {
                C0913b q02 = H().q0();
                if (q02 != null) {
                    bundle = q02.f3367a;
                } else {
                    bundle = null;
                }
                int i5 = 1;
                if (bundle == null) {
                    int i6 = this.f2715F;
                    this.f2715F = i6 + 1;
                    if (i6 < 10) {
                        z4 = true;
                    }
                    C0835p2 F5 = a().F();
                    if (z4) {
                        str = "Retrying.";
                    } else {
                        str = "Skipping.";
                    }
                    F5.b("Failed to retrieve DMA consent from the service, " + str + " retryCount", Integer.valueOf(this.f2715F));
                    return z4;
                }
                A3 c5 = A3.c(bundle, 100);
                sb.append("&gcs=");
                sb.append(c5.w());
                C0873v b5 = C0873v.b(bundle, 100);
                sb.append("&dma=");
                if (b5.h() == Boolean.FALSE) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                sb.append(i4);
                if (!TextUtils.isEmpty(b5.i())) {
                    sb.append("&dma_cps=");
                    sb.append(b5.i());
                }
                if (C0873v.e(bundle) == Boolean.TRUE) {
                    i5 = 0;
                }
                sb.append("&npa=");
                sb.append(i5);
                a().K().b("Consent query parameters to Bow", sb);
            }
            StringBuilder sb2 = sb;
            d6 L4 = L();
            y();
            String str2 = F4;
            URL K4 = L4.K(106000, str2, (String) r4.first, F().f3338w.a() - 1, sb2.toString());
            if (K4 != null) {
                C0857s4 s4 = s();
                V2 v22 = new V2(this);
                s4.k();
                s4.m();
                C0335p.l(K4);
                C0335p.l(v22);
                s4.f().w(new C0871u4(s4, str2, K4, (byte[]) null, (Map) null, v22));
            }
            return false;
        }
    }

    public final void t(boolean z4) {
        f().k();
        this.f2713D = z4;
    }

    public final int u() {
        f().k();
        if (this.f2724g.W()) {
            return 1;
        }
        Boolean bool = this.f2712C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!n()) {
            return 8;
        }
        Boolean P4 = F().P();
        if (P4 == null) {
            Boolean E4 = this.f2724g.E("firebase_analytics_collection_enabled");
            if (E4 == null) {
                Boolean bool2 = this.f2711B;
                if (bool2 != null) {
                    if (bool2.booleanValue()) {
                        return 0;
                    }
                    return 5;
                } else if (this.f2710A == null || this.f2710A.booleanValue()) {
                    return 0;
                } else {
                    return 7;
                }
            } else if (E4.booleanValue()) {
                return 0;
            } else {
                return 4;
            }
        } else if (P4.booleanValue()) {
            return 0;
        } else {
            return 3;
        }
    }

    public final C0894y v() {
        C0894y yVar = this.f2734q;
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public final C0769g w() {
        return this.f2724g;
    }

    public final C0887x x() {
        h(this.f2739v);
        return this.f2739v;
    }

    public final C0772g2 y() {
        d(this.f2740w);
        return this.f2740w;
    }

    public final C0765f2 z() {
        d(this.f2737t);
        return this.f2737t;
    }
}
