package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import R.e;
import R.n;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.internal.measurement.C0576h6;
import com.google.android.gms.internal.measurement.C0604k7;
import com.google.android.gms.internal.measurement.U0;
import com.google.android.gms.internal.measurement.r7;
import com.google.android.gms.measurement.internal.A3;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import f0.C0913b;
import f0.o;
import f0.p;
import f0.q;
import f0.r;
import f0.t;
import f0.u;
import f0.w;
import f0.x;
import f0.y;
import j$.util.Comparator$CC;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o0.C2170b;
import o0.C2172d;

public final class F3 extends C0897y2 {

    /* renamed from: c  reason: collision with root package name */
    private C0823n4 f2376c;

    /* renamed from: d  reason: collision with root package name */
    private u f2377d;

    /* renamed from: e  reason: collision with root package name */
    private final Set f2378e = new CopyOnWriteArraySet();

    /* renamed from: f  reason: collision with root package name */
    private boolean f2379f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference f2380g = new AtomicReference();

    /* renamed from: h  reason: collision with root package name */
    private final Object f2381h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f2382i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f2383j = 1;

    /* renamed from: k  reason: collision with root package name */
    private C0859t f2384k;

    /* renamed from: l  reason: collision with root package name */
    private PriorityQueue f2385l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2386m;

    /* renamed from: n  reason: collision with root package name */
    private A3 f2387n = A3.f2299c;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicLong f2388o = new AtomicLong(0);

    /* renamed from: p  reason: collision with root package name */
    private long f2389p = -1;

    /* renamed from: q  reason: collision with root package name */
    final i6 f2390q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2391r = true;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public C0859t f2392s;

    /* renamed from: t  reason: collision with root package name */
    private SharedPreferences.OnSharedPreferenceChangeListener f2393t;

    /* renamed from: u  reason: collision with root package name */
    private C0859t f2394u;

    /* renamed from: v  reason: collision with root package name */
    private final c6 f2395v = new C0767f4(this);

    protected F3(S2 s22) {
        super(s22);
        this.f2390q = new i6(s22);
    }

    public static int E(String str) {
        C0335p.f(str);
        return 25;
    }

    /* access modifiers changed from: private */
    public final void K0() {
        F3 f32;
        long j4;
        k();
        String a5 = e().f3330o.a();
        if (a5 == null) {
            f32 = this;
        } else if ("unset".equals(a5)) {
            f32 = this;
            f32.k0(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", (Object) null, B().currentTimeMillis());
        } else {
            if ("true".equals(a5)) {
                j4 = 1;
            } else {
                j4 = 0;
            }
            k0(MBridgeConstans.DYNAMIC_VIEW_WX_APP, "_npa", Long.valueOf(j4), B().currentTimeMillis());
            f32 = this;
        }
        if (!f32.f3273a.m() || !f32.f2391r) {
            a().F().a("Updating Scion state (FE)");
            q().f0();
            return;
        }
        a().F().a("Recording app launch after enabling measurement for the first time (FE)");
        C0();
        r().f3188e.a();
        f().D(new S3(this));
    }

    private final void N(Bundle bundle, int i4, long j4) {
        String str;
        s();
        String k4 = A3.k(bundle);
        if (k4 != null) {
            a().M().b("Ignoring invalid consent setting", k4);
            a().M().a("Valid consent values are 'granted', 'denied'");
        }
        boolean J4 = f().J();
        A3 c5 = A3.c(bundle, i4);
        if (c5.A()) {
            S(c5, j4, J4);
        }
        C0873v b5 = C0873v.b(bundle, i4);
        if (b5.k()) {
            Q(b5, J4);
        }
        Boolean e5 = C0873v.e(bundle);
        if (e5 != null) {
            if (i4 == -30) {
                str = "tcf";
            } else {
                str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
            }
            String str2 = str;
            if (!b().q(G.f2443T0) || !J4) {
                m0(str2, "allow_personalized_ads", e5.toString(), false, j4);
                return;
            }
            k0(str2, "allow_personalized_ads", e5.toString(), j4);
        }
    }

    static /* synthetic */ void P0(F3 f32, int i4) {
        if (f32.f2384k == null) {
            f32.f2384k = new Q3(f32, f32.f3273a);
        }
        f32.f2384k.b((long) (i4 * 1000));
    }

    static /* synthetic */ void Q0(F3 f32, Bundle bundle) {
        Bundle bundle2 = bundle;
        f32.k();
        f32.s();
        C0335p.l(bundle2);
        String string = bundle2.getString(RewardPlus.NAME);
        String string2 = bundle2.getString(TtmlNode.ATTR_TTS_ORIGIN);
        C0335p.f(string);
        C0335p.f(string2);
        C0335p.l(bundle2.get("value"));
        F3 f33 = f32;
        if (!f33.f3273a.m()) {
            f33.a().K().a("Conditional property not set since app measurement is disabled");
            return;
        }
        Y5 y5 = new Y5(string, bundle2.getLong("triggered_timestamp"), bundle2.get("value"), string2);
        try {
            E H4 = f33.g().H(bundle2.getString(MBridgeConstans.APP_ID), bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), string2, 0, true, true);
            E H5 = f33.g().H(bundle2.getString(MBridgeConstans.APP_ID), bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), string2, 0, true, true);
            E H6 = f33.g().H(bundle2.getString(MBridgeConstans.APP_ID), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), string2, 0, true, true);
            String string3 = bundle2.getString(MBridgeConstans.APP_ID);
            long j4 = bundle2.getLong("creation_timestamp");
            long j5 = j4;
            String str = string2;
            long j6 = j5;
            E e5 = H5;
            Y5 y52 = y5;
            f32.q().H(new C0755e(string3, str, y52, j6, false, bundle2.getString("trigger_event_name"), e5, bundle2.getLong("trigger_timeout"), H4, bundle2.getLong("time_to_live"), H6));
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void T0(String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        f().D(new X3(this, str, str2, j4, d6.D(bundle), z4, z5, z6, str3));
    }

    static /* synthetic */ void U(F3 f32, Bundle bundle) {
        Bundle bundle2 = bundle;
        f32.k();
        f32.s();
        C0335p.l(bundle2);
        String f4 = C0335p.f(bundle2.getString(RewardPlus.NAME));
        F3 f33 = f32;
        if (!f33.f3273a.m()) {
            f33.a().K().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        Y5 y5 = new Y5(f4, 0, (Object) null, "");
        try {
            E H4 = f33.g().H(bundle2.getString(MBridgeConstans.APP_ID), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), "", bundle2.getLong("creation_timestamp"), true, true);
            f33.q().H(new C0755e(bundle2.getString(MBridgeConstans.APP_ID), "", y5, bundle2.getLong("creation_timestamp"), bundle2.getBoolean("active"), bundle2.getString("trigger_event_name"), (E) null, bundle2.getLong("trigger_timeout"), (E) null, bundle2.getLong("time_to_live"), H4));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void V(F3 f32, A3 a32, long j4, boolean z4, boolean z5) {
        f32.k();
        f32.s();
        A3 M4 = f32.e().M();
        if (j4 <= f32.f2389p && A3.l(M4.b(), a32.b())) {
            f32.a().J().b("Dropped out-of-date consent setting, proposed settings", a32);
        } else if (f32.e().y(a32)) {
            f32.a().K().b("Setting storage consent(FE)", a32);
            f32.f2389p = j4;
            if (f32.q().j0()) {
                f32.q().o0(z4);
            } else {
                f32.q().U(z4);
            }
            if (z5) {
                f32.q().Q(new AtomicReference());
            }
        } else {
            f32.a().J().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(a32.b()));
        }
    }

    static /* synthetic */ void W(F3 f32, A3 a32, A3 a33) {
        if (!C0576h6.a() || !f32.b().q(G.f2453Y0)) {
            A3.a aVar = A3.a.ANALYTICS_STORAGE;
            A3.a aVar2 = A3.a.AD_STORAGE;
            boolean n4 = a32.n(a33, aVar, aVar2);
            boolean s4 = a32.s(a33, aVar, aVar2);
            if (n4 || s4) {
                f32.m().I();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c0(Boolean bool, boolean z4) {
        k();
        s();
        a().F().b("Setting app measurement enabled (FE)", bool);
        e().t(bool);
        if (z4) {
            e().E(bool);
        }
        if (this.f3273a.n() || (bool != null && !bool.booleanValue())) {
            K0();
        }
    }

    private final void g0(String str, String str2, long j4, Object obj) {
        f().D(new W3(this, str, str2, obj, j4));
    }

    static /* synthetic */ int z(F3 f32, Throwable th) {
        String message = th.getMessage();
        f32.f2386m = false;
        if (message == null) {
            return 2;
        }
        if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            if (message.contains("Background")) {
                f32.f2386m = true;
            }
            return 1;
        } else if (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) {
            return 2;
        } else {
            return 3;
        }
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    /* access modifiers changed from: package-private */
    public final PriorityQueue A0() {
        if (this.f2385l == null) {
            x.a();
            this.f2385l = w.a(Comparator$CC.comparing(new E3(), new H3()));
        }
        return this.f2385l;
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final void B0() {
        k();
        s();
        if (b().q(G.f2470e1)) {
            F4 q4 = q();
            q4.k();
            q4.s();
            if (!q4.k0() || q4.g().I0() >= 242600) {
                q().X();
            }
        }
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final void C0() {
        k();
        s();
        if (this.f3273a.p()) {
            Boolean E4 = b().E("google_analytics_deferred_deep_link_enabled");
            if (E4 != null && E4.booleanValue()) {
                a().F().a("Deferred Deep Link feature enabled.");
                f().D(new y(this));
            }
            q().Y();
            this.f2391r = false;
            String Q4 = e().Q();
            if (!TextUtils.isEmpty(Q4)) {
                c().m();
                if (!Q4.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", Q4);
                    b1("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void D0() {
        if ((A().getApplicationContext() instanceof Application) && this.f2376c != null) {
            ((Application) A().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f2376c);
        }
    }

    /* access modifiers changed from: package-private */
    public final void E0() {
        if (C0604k7.a() && b().q(G.f2423J0)) {
            if (f().J()) {
                a().G().a("Cannot get trigger URIs from analytics worker thread");
            } else if (C0741c.a()) {
                a().G().a("Cannot get trigger URIs from main thread");
            } else {
                s();
                a().K().a("Getting trigger URIs (FE)");
                AtomicReference atomicReference = new AtomicReference();
                f().s(atomicReference, 5000, "get trigger URIs", new G3(this, atomicReference));
                List list = (List) atomicReference.get();
                if (list == null) {
                    a().G().a("Timed out waiting for get trigger URIs");
                } else {
                    f().D(new J3(this, list));
                }
            }
        }
    }

    public final void F0() {
        k();
        if (e().f3337v.b()) {
            a().F().a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long a5 = e().f3338w.a();
        e().f3338w.b(1 + a5);
        if (a5 >= 5) {
            a().L().a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            e().f3337v.a(true);
            return;
        }
        if (this.f2392s == null) {
            this.f2392s = new C0732a4(this, this.f3273a);
        }
        this.f2392s.b(0);
    }

    public final ArrayList G(String str, String str2) {
        if (f().J()) {
            a().G().a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        } else if (C0741c.a()) {
            a().G().a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            P2 f4 = this.f3273a.f();
            AtomicReference atomicReference2 = atomicReference;
            C0760e4 e4Var = new C0760e4(this, atomicReference2, (String) null, str, str2);
            AtomicReference atomicReference3 = atomicReference2;
            f4.s(atomicReference3, 5000, "get conditional user properties", e4Var);
            List list = (List) atomicReference3.get();
            if (list != null) {
                return d6.t0(list);
            }
            a().G().b("Timed out waiting for get conditional user properties", (Object) null);
            return new ArrayList();
        }
    }

    public final void G0() {
        k();
        a().F().a("Handle tcf update.");
        C0907z5 c5 = C0907z5.c(e().H());
        a().K().b("Tcf preferences read", c5);
        if (e().z(c5)) {
            Bundle b5 = c5.b();
            a().K().b("Consent generated from Tcf", b5);
            if (b5 != Bundle.EMPTY) {
                N(b5, -30, B().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", c5.e());
            b1("auto", "_tcf", bundle);
        }
    }

    public final Map H(String str, String str2, boolean z4) {
        if (f().J()) {
            a().G().a("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        } else if (C0741c.a()) {
            a().G().a("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        } else {
            AtomicReference atomicReference = new AtomicReference();
            P2 f4 = this.f3273a.f();
            boolean z5 = z4;
            AtomicReference atomicReference2 = atomicReference;
            C0753d4 d4Var = new C0753d4(this, atomicReference2, (String) null, str, str2, z5);
            AtomicReference atomicReference3 = atomicReference2;
            f4.s(atomicReference3, 5000, "get user properties", d4Var);
            List<Y5> list = (List) atomicReference3.get();
            if (list == null) {
                a().G().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z5));
                return Collections.EMPTY_MAP;
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (Y5 y5 : list) {
                Object c5 = y5.c();
                if (c5 != null) {
                    arrayMap.put(y5.f2824b, c5);
                }
            }
            return arrayMap;
        }
    }

    /* access modifiers changed from: package-private */
    public final void H0() {
        B5 b5;
        MeasurementManagerFutures T02;
        k();
        this.f2386m = false;
        if (!A0().isEmpty() && !this.f2382i && (b5 = (B5) A0().poll()) != null && (T02 = g().T0()) != null) {
            this.f2382i = true;
            a().K().b("Registering trigger URI", b5.f2332a);
            C2172d registerTriggerAsync = T02.registerTriggerAsync(Uri.parse(b5.f2332a));
            if (registerTriggerAsync == null) {
                this.f2382i = false;
                A0().add(b5);
                return;
            }
            if (!b().q(G.f2433O0)) {
                SparseArray K4 = e().K();
                K4.put(b5.f2334c, Long.valueOf(b5.f2333b));
                e().s(K4);
            }
            C2170b.a(registerTriggerAsync, new R3(this, b5), new N3(this));
        }
    }

    public final void I(long j4) {
        a1((String) null);
        f().D(new Z3(this, j4));
    }

    public final void I0() {
        k();
        a().F().a("Register tcfPrefChangeListener.");
        if (this.f2393t == null) {
            this.f2394u = new U3(this, this.f3273a);
            this.f2393t = new M3(this);
        }
        e().H().registerOnSharedPreferenceChangeListener(this.f2393t);
    }

    /* access modifiers changed from: package-private */
    public final void J(long j4, boolean z4) {
        k();
        s();
        a().F().a("Resetting analytics data (FE)");
        C0838p5 r4 = r();
        r4.k();
        r4.f3189f.b();
        m().I();
        boolean m4 = this.f3273a.m();
        C0904z2 e5 = e();
        e5.f3322g.b(j4);
        if (!TextUtils.isEmpty(e5.e().f3339x.a())) {
            e5.f3339x.b((String) null);
        }
        e5.f3333r.b(0);
        e5.f3334s.b(0);
        if (!e5.b().W()) {
            e5.G(!m4);
        }
        e5.f3340y.b((String) null);
        e5.f3341z.b(0);
        e5.f3317A.b((Bundle) null);
        if (z4) {
            q().d0();
        }
        r().f3188e.a();
        this.f2391r = !m4;
    }

    /* access modifiers changed from: package-private */
    public final boolean J0() {
        return this.f2386m;
    }

    public final void K(Intent intent) {
        if (r7.a() && b().q(G.f2520z0)) {
            Uri data = intent.getData();
            if (data == null) {
                a().J().a("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                a().J().a("Preview Mode was not enabled.");
                b().L((String) null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (!TextUtils.isEmpty(queryParameter2)) {
                a().J().b("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
                b().L(queryParameter2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void L(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            a().K().a("IABTCF_TCString change picked up in listener.");
            ((C0859t) C0335p.l(this.f2394u)).b(500);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void M(Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = e().f3317A.a();
            if (b().q(G.f2482i1)) {
                bundle2 = new Bundle(bundle2);
            }
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    g();
                    if (d6.h0(obj)) {
                        g();
                        d6.Y(this.f2395v, 27, (String) null, (String) null, 0);
                    }
                    a().M().c("Invalid default event parameter type. Name, value", next, obj);
                } else if (d6.J0(next)) {
                    a().M().b("Invalid default event parameter name. Name", next);
                } else if (obj == null) {
                    bundle2.remove(next);
                } else if (g().l0("param", next, b().o((String) null, false), obj)) {
                    g().O(bundle2, next, obj);
                }
            }
            g();
            if (d6.g0(bundle2, b().v())) {
                g();
                d6.Y(this.f2395v, 26, (String) null, (String) null, 0);
                a().M().a("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        e().f3317A.b(bundle2);
        if (!bundle.isEmpty() || b().q(G.f2476g1)) {
            q().z(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void M0(long j4) {
        J(j4, true);
    }

    public final void N0(Bundle bundle) {
        O0(bundle, B().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void O(Bundle bundle, long j4) {
        if (TextUtils.isEmpty(m().G())) {
            N(bundle, 0, j4);
        } else {
            a().M().a("Using developer consent only; google app id found");
        }
    }

    public final void O0(Bundle bundle, long j4) {
        C0335p.l(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(MBridgeConstans.APP_ID))) {
            a().L().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(MBridgeConstans.APP_ID);
        C0335p.l(bundle2);
        Class<String> cls = String.class;
        o.a(bundle2, MBridgeConstans.APP_ID, cls, (Object) null);
        o.a(bundle2, TtmlNode.ATTR_TTS_ORIGIN, cls, (Object) null);
        o.a(bundle2, RewardPlus.NAME, cls, (Object) null);
        o.a(bundle2, "value", Object.class, (Object) null);
        o.a(bundle2, "trigger_event_name", cls, (Object) null);
        Class<Long> cls2 = Long.class;
        o.a(bundle2, "trigger_timeout", cls2, 0L);
        o.a(bundle2, "timed_out_event_name", cls, (Object) null);
        Class<Bundle> cls3 = Bundle.class;
        o.a(bundle2, "timed_out_event_params", cls3, (Object) null);
        o.a(bundle2, "triggered_event_name", cls, (Object) null);
        o.a(bundle2, "triggered_event_params", cls3, (Object) null);
        o.a(bundle2, "time_to_live", cls2, 0L);
        o.a(bundle2, "expired_event_name", cls, (Object) null);
        o.a(bundle2, "expired_event_params", cls3, (Object) null);
        C0335p.f(bundle2.getString(RewardPlus.NAME));
        C0335p.f(bundle2.getString(TtmlNode.ATTR_TTS_ORIGIN));
        C0335p.l(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j4);
        String string = bundle2.getString(RewardPlus.NAME);
        Object obj = bundle2.get("value");
        if (g().r0(string) != 0) {
            a().G().b("Invalid conditional user property name", d().g(string));
        } else if (g().t(string, obj) != 0) {
            a().G().c("Invalid conditional user property value", d().g(string), obj);
        } else {
            Object A02 = g().A0(string, obj);
            if (A02 == null) {
                a().G().c("Unable to normalize conditional user property value", d().g(string), obj);
                return;
            }
            o.b(bundle2, A02);
            long j5 = bundle2.getLong("trigger_timeout");
            if (TextUtils.isEmpty(bundle2.getString("trigger_event_name")) || (j5 <= 15552000000L && j5 >= 1)) {
                long j6 = bundle2.getLong("time_to_live");
                if (j6 > 15552000000L || j6 < 1) {
                    a().G().c("Invalid conditional user property time to live", d().g(string), Long.valueOf(j6));
                } else {
                    f().D(new C0746c4(this, bundle2));
                }
            } else {
                a().G().c("Invalid conditional user property timeout", d().g(string), Long.valueOf(j5));
            }
        }
    }

    public final void P(U0 u02) {
        f().D(new C0774g4(this, u02));
    }

    /* access modifiers changed from: package-private */
    public final void Q(C0873v vVar, boolean z4) {
        C0816m4 m4Var = new C0816m4(this, vVar);
        if (z4) {
            k();
            m4Var.run();
            return;
        }
        f().D(m4Var);
    }

    /* access modifiers changed from: package-private */
    public final void R(A3 a32) {
        boolean z4;
        k();
        if ((!a32.z() || !a32.y()) && !q().i0()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z4 != this.f3273a.n()) {
            this.f3273a.t(z4);
            Boolean O4 = e().O();
            if (!z4 || O4 == null || O4.booleanValue()) {
                c0(Boolean.valueOf(z4), false);
            }
        }
    }

    public final void R0(t tVar) {
        s();
        C0335p.l(tVar);
        if (!this.f2378e.remove(tVar)) {
            a().L().a("OnEventListener had not been registered");
        }
    }

    public final void S(A3 a32, long j4, boolean z4) {
        A3 a33;
        boolean z5;
        boolean z6;
        boolean z7;
        A3 a34;
        p pVar;
        s();
        int b5 = a32.b();
        if (b5 != -10 && a32.t() == (pVar = p.UNINITIALIZED) && a32.v() == pVar) {
            a().M().a("Ignoring empty consent settings");
            return;
        }
        synchronized (this.f2381h) {
            try {
                a33 = this.f2387n;
                z5 = false;
                if (A3.l(b5, a33.b())) {
                    z7 = a32.u(this.f2387n);
                    if (a32.z() && !this.f2387n.z()) {
                        z5 = true;
                    }
                    a34 = a32.p(this.f2387n);
                    this.f2387n = a34;
                    z6 = z5;
                    z5 = true;
                } else {
                    a34 = a32;
                    z7 = false;
                    z6 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!z5) {
            a().J().b("Ignoring lower-priority consent settings, proposed settings", a34);
            return;
        }
        long andIncrement = this.f2388o.getAndIncrement();
        if (z7) {
            a1((String) null);
            C0809l4 l4Var = new C0809l4(this, a34, j4, andIncrement, z6, a33);
            if (z4) {
                k();
                l4Var.run();
                return;
            }
            f().G(l4Var);
            return;
        }
        C0837p4 p4Var = new C0837p4(this, a34, andIncrement, z6, a33);
        if (z4) {
            k();
            p4Var.run();
        } else if (b5 == 30 || b5 == -10) {
            f().G(p4Var);
        } else {
            f().D(p4Var);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void S0(String str) {
        if (m().K(str)) {
            m().I();
        }
    }

    public final void U0(String str, String str2, Bundle bundle) {
        j0(str, str2, bundle, true, true, B().currentTimeMillis());
    }

    public final void V0(boolean z4) {
        if (A().getApplicationContext() instanceof Application) {
            Application application = (Application) A().getApplicationContext();
            if (this.f2376c == null) {
                this.f2376c = new C0823n4(this);
            }
            if (z4) {
                application.unregisterActivityLifecycleCallbacks(this.f2376c);
                application.registerActivityLifecycleCallbacks(this.f2376c);
                a().K().a("Registered activity lifecycle callback");
            }
        }
    }

    public final void W0(long j4) {
        f().D(new V3(this, j4));
    }

    public final void X0(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        f().D(new I3(this, bundle2));
    }

    public final void Y0(Bundle bundle, long j4) {
        f().G(new K3(this, bundle, j4));
    }

    public final void Z(t tVar) {
        s();
        C0335p.l(tVar);
        if (!this.f2378e.add(tVar)) {
            a().L().a("OnEventListener already registered");
        }
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final void a0(u uVar) {
        u uVar2;
        boolean z4;
        k();
        s();
        if (!(uVar == null || uVar == (uVar2 = this.f2377d))) {
            if (uVar2 == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0335p.p(z4, "EventInterceptor already set.");
        }
        this.f2377d = uVar;
    }

    /* access modifiers changed from: package-private */
    public final void a1(String str) {
        this.f2380g.set(str);
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final void b0(Boolean bool) {
        s();
        f().D(new C0795j4(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void b1(String str, String str2, Bundle bundle) {
        k();
        e0(str, str2, B().currentTimeMillis(), bundle);
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final void c1(boolean z4) {
        s();
        f().D(new T3(this, z4));
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final void d0(String str, long j4) {
        if (str == null || !TextUtils.isEmpty(str)) {
            f().D(new L3(this, str));
            m0((String) null, "_id", str, true, j4);
            return;
        }
        this.f3273a.a().L().a("User ID must be non-empty or null");
    }

    public final void d1(Bundle bundle, long j4) {
        N(bundle, -20, j4);
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    /* access modifiers changed from: package-private */
    public final void e0(String str, String str2, long j4, Bundle bundle) {
        boolean z4;
        k();
        if (this.f2377d == null || d6.J0(str2)) {
            z4 = true;
        } else {
            z4 = false;
        }
        f0(str, str2, j4, bundle, true, z4, true, (String) null);
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    /* access modifiers changed from: protected */
    public final void f0(String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        long j5;
        boolean z7;
        boolean z8;
        String str4;
        long j6;
        int i4;
        Class<?> cls;
        String str5 = str;
        String str6 = str2;
        Bundle bundle2 = bundle;
        int i5 = 0;
        C0335p.f(str5);
        C0335p.l(bundle2);
        k();
        s();
        if (!this.f3273a.m()) {
            a().F().a("Event not sent since app measurement is disabled");
            return;
        }
        List H4 = m().H();
        if (H4 == null || H4.contains(str6)) {
            if (!this.f2379f) {
                this.f2379f = true;
                try {
                    if (!this.f3273a.q()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, A().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{A()});
                    } catch (Exception e5) {
                        a().L().b("Failed to invoke Tag Manager's initialize() method", e5);
                    }
                } catch (ClassNotFoundException unused) {
                    a().J().a("Tag Manager is not found and thus will not be used");
                }
            }
            if ("_cmp".equals(str6) && bundle2.containsKey("gclid")) {
                k0("auto", "_lgclid", bundle2.getString("gclid"), B().currentTimeMillis());
            }
            F3 f32 = this;
            if (z4 && d6.M0(str6)) {
                f32.g().N(bundle2, f32.e().f3317A.a());
            }
            if (!z6 && !"_iap".equals(str6)) {
                d6 L4 = f32.f3273a.L();
                int i6 = 2;
                if (L4.C0(NotificationCompat.CATEGORY_EVENT, str6)) {
                    if (!L4.p0(NotificationCompat.CATEGORY_EVENT, q.f3379a, q.f3380b, str6)) {
                        i6 = 13;
                    } else if (L4.j0(NotificationCompat.CATEGORY_EVENT, 40, str6)) {
                        i6 = 0;
                    }
                }
                if (i6 != 0) {
                    f32.a().H().b("Invalid public event name. Event will not be logged (FE)", f32.d().c(str6));
                    f32.f3273a.L();
                    String J4 = d6.J(str6, 40, true);
                    if (str6 != null) {
                        i5 = str6.length();
                    }
                    f32.f3273a.L();
                    d6.Y(f32.f2395v, i6, "_ev", J4, i5);
                    return;
                }
            }
            C0892x4 z9 = f32.p().z(false);
            if (z9 != null && !bundle2.containsKey("_sc")) {
                z9.f3297d = true;
            }
            d6.X(z9, bundle2, z4 && !z6);
            boolean equals = "am".equals(str5);
            boolean J02 = d6.J0(str6);
            if (!z4 || f32.f2377d == null || J02 || equals) {
                long j7 = j4;
                if (f32.f3273a.p()) {
                    int s4 = f32.g().s(str6);
                    if (s4 != 0) {
                        f32.a().H().b("Invalid event name. Event will not be logged (FE)", f32.d().c(str6));
                        f32.g();
                        String J5 = d6.J(str6, 40, true);
                        if (str6 != null) {
                            i5 = str6.length();
                        }
                        f32.f3273a.L();
                        d6.Z(f32.f2395v, str3, s4, "_ev", J5, i5);
                        return;
                    }
                    Bundle F4 = f32.g().F(str3, str6, bundle, e.b("_o", "_sn", "_sc", "_si"), z6);
                    C0335p.l(F4);
                    if (f32.p().z(false) == null || !"_ae".equals(str6)) {
                        z7 = equals;
                        j5 = 0;
                    } else {
                        C0872u5 u5Var = f32.r().f3189f;
                        j5 = 0;
                        long elapsedRealtime = u5Var.f3253d.B().elapsedRealtime();
                        z7 = equals;
                        long j8 = elapsedRealtime - u5Var.f3251b;
                        u5Var.f3251b = elapsedRealtime;
                        if (j8 > 0) {
                            f32.g().M(F4, j8);
                        }
                    }
                    if (!"auto".equals(str5) && "_ssr".equals(str6)) {
                        d6 g4 = f32.g();
                        String string = F4.getString("_ffr");
                        if (n.a(string)) {
                            string = null;
                        } else if (string != null) {
                            string = string.trim();
                        }
                        if (Objects.equals(string, g4.e().f3339x.a())) {
                            g4.a().F().a("Not logging duplicate session_start_with_rollout event");
                            return;
                        }
                        g4.e().f3339x.b(string);
                    } else if ("_ae".equals(str6)) {
                        String a5 = f32.g().e().f3339x.a();
                        if (!TextUtils.isEmpty(a5)) {
                            F4.putString("_ffr", a5);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(F4);
                    if (f32.b().q(G.f2435P0)) {
                        z8 = f32.r().F();
                    } else {
                        z8 = f32.e().f3336u.b();
                    }
                    if (f32.e().f3333r.a() <= j5 || !f32.e().w(j7) || !z8) {
                        j6 = j5;
                        str4 = "_ae";
                    } else {
                        f32.a().K().a("Current session is expired, remove the session number, ID, and engagement time");
                        j6 = j5;
                        str4 = "_ae";
                        k0("auto", "_sid", (Object) null, f32.B().currentTimeMillis());
                        k0("auto", "_sno", (Object) null, B().currentTimeMillis());
                        k0("auto", "_se", (Object) null, B().currentTimeMillis());
                        f32 = this;
                        f32.e().f3334s.b(j6);
                    }
                    if (F4.getLong("extend_session", j6) == 1) {
                        f32.a().K().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        i4 = 1;
                        f32.f3273a.K().f3188e.b(j7, true);
                    } else {
                        i4 = 1;
                    }
                    ArrayList arrayList2 = new ArrayList(F4.keySet());
                    Collections.sort(arrayList2);
                    int size = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size) {
                        Object obj = arrayList2.get(i7);
                        i7 += i4;
                        String str7 = (String) obj;
                        if (str7 != null) {
                            f32.g();
                            Bundle[] x02 = d6.x0(F4.get(str7));
                            if (x02 != null) {
                                F4.putParcelableArray(str7, x02);
                            }
                        }
                        i4 = 1;
                    }
                    int i8 = 0;
                    while (i8 < arrayList.size()) {
                        Bundle bundle3 = (Bundle) arrayList.get(i8);
                        String str8 = i8 != 0 ? "_ep" : str6;
                        bundle3.putString("_o", str5);
                        if (z5) {
                            bundle3 = f32.g().E(bundle3, (String) null);
                        }
                        String str9 = str5;
                        Bundle bundle4 = bundle3;
                        f32.q().I(new E(str8, new D(bundle3), str9, j7), str3);
                        if (!z7) {
                            for (t a6 : f32.f2378e) {
                                a6.a(str, str6, new Bundle(bundle4), j4);
                            }
                        }
                        i8++;
                        str5 = str;
                        j7 = j4;
                    }
                    if (f32.p().z(false) != null && str4.equals(str6)) {
                        f32.r().E(true, true, f32.B().elapsedRealtime());
                        return;
                    }
                    return;
                }
                return;
            }
            f32.a().F().c("Passing event to registered event handler (FE)", f32.d().c(str6), f32.d().a(bundle2));
            C0335p.l(f32.f2377d);
            f32.f2377d.a(str5, str6, bundle2, j4);
            return;
        }
        a().F().c("Dropping non-safelisted event. event name, origin", str6, str5);
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final void h0(String str, String str2, Bundle bundle) {
        long currentTimeMillis = B().currentTimeMillis();
        C0335p.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(RewardPlus.NAME, str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        f().D(new C0739b4(this, bundle2));
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final void i0(String str, String str2, Bundle bundle, String str3) {
        j();
        T0(str, str2, B().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final void j0(String str, String str2, Bundle bundle, boolean z4, boolean z5, long j4) {
        boolean z6;
        if (str == null) {
            str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (Objects.equals(str2, "screen_view")) {
            p().I(bundle2, j4);
            return;
        }
        long j5 = j4;
        if (!z5 || this.f2377d == null || d6.J0(str2)) {
            z6 = true;
        } else {
            z6 = false;
        }
        T0(str3, str2, j5, bundle2, z5, z6, z4, (String) null);
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    /* access modifiers changed from: package-private */
    public final void k0(String str, String str2, Object obj, long j4) {
        long j5;
        C0335p.f(str);
        C0335p.f(str2);
        k();
        s();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "false";
                    if (str4.equals(str3.toLowerCase(Locale.ENGLISH))) {
                        j5 = 1;
                    } else {
                        j5 = 0;
                    }
                    Long valueOf = Long.valueOf(j5);
                    C2 c22 = e().f3330o;
                    if (valueOf.longValue() == 1) {
                        str4 = "true";
                    }
                    c22.b(str4);
                    obj = valueOf;
                    str2 = "_npa";
                    a().K().c("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                e().f3330o.b("unset");
                str2 = "_npa";
            }
            a().K().c("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str5 = str2;
        Object obj2 = obj;
        if (!this.f3273a.m()) {
            a().K().a("User property not set since app measurement is disabled");
        } else if (this.f3273a.p()) {
            q().M(new Y5(str5, j4, obj2, str));
        }
    }

    public final /* bridge */ /* synthetic */ C0894y l() {
        return super.l();
    }

    public final void l0(String str, String str2, Object obj, boolean z4) {
        m0(str, str2, obj, z4, B().currentTimeMillis());
    }

    public final /* bridge */ /* synthetic */ C0772g2 m() {
        return super.m();
    }

    public final void m0(String str, String str2, Object obj, boolean z4, long j4) {
        int i4;
        if (str == null) {
            str = MBridgeConstans.DYNAMIC_VIEW_WX_APP;
        }
        String str3 = str;
        int i5 = 0;
        if (z4) {
            i4 = g().r0(str2);
        } else {
            d6 g4 = g();
            if (g4.C0("user property", str2)) {
                if (!g4.o0("user property", r.f3383a, str2)) {
                    i4 = 15;
                } else if (g4.j0("user property", 24, str2)) {
                    i4 = 0;
                }
            }
            i4 = 6;
        }
        if (i4 != 0) {
            g();
            String J4 = d6.J(str2, 24, true);
            if (str2 != null) {
                i5 = str2.length();
            }
            this.f3273a.L();
            d6.Y(this.f2395v, i4, "_ev", J4, i5);
        } else if (obj != null) {
            int t4 = g().t(str2, obj);
            if (t4 != 0) {
                g();
                String J5 = d6.J(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i5 = String.valueOf(obj).length();
                }
                this.f3273a.L();
                d6.Y(this.f2395v, t4, "_ev", J5, i5);
                return;
            }
            Object A02 = g().A0(str2, obj);
            if (A02 != null) {
                g0(str3, str2, j4, A02);
            }
        } else {
            g0(str3, str2, j4, (Object) null);
        }
    }

    public final /* bridge */ /* synthetic */ C0765f2 n() {
        return super.n();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void n0(List list) {
        k();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray K4 = e().K();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                B5 b5 = (B5) it.next();
                if (!K4.contains(b5.f2334c) || ((Long) K4.get(b5.f2334c)).longValue() < b5.f2333b) {
                    A0().add(b5);
                }
            }
            H0();
        }
    }

    public final /* bridge */ /* synthetic */ F3 o() {
        return super.o();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void o0(AtomicReference atomicReference) {
        Bundle a5 = e().f3331p.a();
        F4 q4 = q();
        if (a5 == null) {
            a5 = new Bundle();
        }
        q4.R(atomicReference, a5);
    }

    public final /* bridge */ /* synthetic */ C0885w4 p() {
        return super.p();
    }

    public final Application.ActivityLifecycleCallbacks p0() {
        return this.f2376c;
    }

    public final /* bridge */ /* synthetic */ F4 q() {
        return super.q();
    }

    public final C0913b q0() {
        k();
        return q().V();
    }

    public final /* bridge */ /* synthetic */ C0838p5 r() {
        return super.r();
    }

    public final Boolean r0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) f().s(atomicReference, 15000, "boolean test flag value", new P3(this, atomicReference));
    }

    public final Double s0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) f().s(atomicReference, 15000, "double test flag value", new C0802k4(this, atomicReference));
    }

    public final Integer t0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) f().s(atomicReference, 15000, "int test flag value", new C0781h4(this, atomicReference));
    }

    public final Long u0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) f().s(atomicReference, 15000, "long test flag value", new C0788i4(this, atomicReference));
    }

    public final String v0() {
        return (String) this.f2380g.get();
    }

    public final String w0() {
        C0892x4 P4 = this.f3273a.I().P();
        if (P4 != null) {
            return P4.f3295b;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final String x0() {
        C0892x4 P4 = this.f3273a.I().P();
        if (P4 != null) {
            return P4.f3294a;
        }
        return null;
    }

    public final String y0() {
        if (this.f3273a.M() != null) {
            return this.f3273a.M();
        }
        try {
            return new f0.n(A(), this.f3273a.P()).b("google_app_id");
        } catch (IllegalStateException e5) {
            this.f3273a.a().G().b("getGoogleAppId failed with exception", e5);
            return null;
        }
    }

    public final String z0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) f().s(atomicReference, 15000, "String test flag value", new Y3(this, atomicReference));
    }
}
