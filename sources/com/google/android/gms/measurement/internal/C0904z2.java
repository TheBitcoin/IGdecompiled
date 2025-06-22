package com.google.android.gms.measurement.internal;

import C.a;
import M.C0335p;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.measurement.internal.A3;

/* renamed from: com.google.android.gms.measurement.internal.z2  reason: case insensitive filesystem */
final class C0904z2 extends C0905z3 {

    /* renamed from: B  reason: collision with root package name */
    static final Pair f3316B = new Pair("", 0L);

    /* renamed from: A  reason: collision with root package name */
    public final B2 f3317A = new B2(this, "default_event_parameters", (Bundle) null);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f3318c;

    /* renamed from: d  reason: collision with root package name */
    private Object f3319d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f3320e;

    /* renamed from: f  reason: collision with root package name */
    public D2 f3321f;

    /* renamed from: g  reason: collision with root package name */
    public final A2 f3322g = new A2(this, "first_open_time", 0);

    /* renamed from: h  reason: collision with root package name */
    public final A2 f3323h = new A2(this, "app_install_time", 0);

    /* renamed from: i  reason: collision with root package name */
    public final C2 f3324i = new C2(this, "app_instance_id", (String) null);

    /* renamed from: j  reason: collision with root package name */
    private String f3325j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3326k;

    /* renamed from: l  reason: collision with root package name */
    private long f3327l;

    /* renamed from: m  reason: collision with root package name */
    public final A2 f3328m = new A2(this, "session_timeout", 1800000);

    /* renamed from: n  reason: collision with root package name */
    public final C0890x2 f3329n = new C0890x2(this, "start_new_session", true);

    /* renamed from: o  reason: collision with root package name */
    public final C2 f3330o = new C2(this, "non_personalized_ads", (String) null);

    /* renamed from: p  reason: collision with root package name */
    public final B2 f3331p = new B2(this, "last_received_uri_timestamps_by_source", (Bundle) null);

    /* renamed from: q  reason: collision with root package name */
    public final C0890x2 f3332q = new C0890x2(this, "allow_remote_dynamite", false);

    /* renamed from: r  reason: collision with root package name */
    public final A2 f3333r = new A2(this, "last_pause_time", 0);

    /* renamed from: s  reason: collision with root package name */
    public final A2 f3334s = new A2(this, "session_id", 0);

    /* renamed from: t  reason: collision with root package name */
    public boolean f3335t;

    /* renamed from: u  reason: collision with root package name */
    public C0890x2 f3336u = new C0890x2(this, "app_backgrounded", false);

    /* renamed from: v  reason: collision with root package name */
    public C0890x2 f3337v = new C0890x2(this, "deep_link_retrieval_complete", false);

    /* renamed from: w  reason: collision with root package name */
    public A2 f3338w = new A2(this, "deep_link_retrieval_attempts", 0);

    /* renamed from: x  reason: collision with root package name */
    public final C2 f3339x = new C2(this, "firebase_feature_rollouts", (String) null);

    /* renamed from: y  reason: collision with root package name */
    public final C2 f3340y = new C2(this, "deferred_attribution_cache", (String) null);

    /* renamed from: z  reason: collision with root package name */
    public final A2 f3341z = new A2(this, "deferred_attribution_cache_timestamp", 0);

    C0904z2(S2 s22) {
        super(s22);
    }

    /* access modifiers changed from: package-private */
    public final boolean D() {
        SharedPreferences sharedPreferences = this.f3318c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final void E(Boolean bool) {
        k();
        SharedPreferences.Editor edit = J().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled_from_api");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void F(String str) {
        k();
        SharedPreferences.Editor edit = J().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void G(boolean z4) {
        k();
        a().K().b("App measurement setting deferred collection", Boolean.valueOf(z4));
        SharedPreferences.Editor edit = J().edit();
        edit.putBoolean("deferred_analytics_collection", z4);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences H() {
        k();
        m();
        if (this.f3320e == null) {
            synchronized (this.f3319d) {
                try {
                    if (this.f3320e == null) {
                        String str = A().getPackageName() + "_preferences";
                        a().K().b("Default prefs file", str);
                        this.f3320e = A().getSharedPreferences(str, 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3320e;
    }

    /* access modifiers changed from: package-private */
    public final void I(String str) {
        k();
        SharedPreferences.Editor edit = J().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences J() {
        k();
        m();
        C0335p.l(this.f3318c);
        return this.f3318c;
    }

    /* access modifiers changed from: package-private */
    public final SparseArray K() {
        Bundle a5 = this.f3331p.a();
        if (a5 == null) {
            return new SparseArray();
        }
        int[] intArray = a5.getIntArray("uriSources");
        long[] longArray = a5.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            a().G().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = 0; i4 < intArray.length; i4++) {
            sparseArray.put(intArray[i4], Long.valueOf(longArray[i4]));
        }
        return sparseArray;
    }

    /* access modifiers changed from: package-private */
    public final C0873v L() {
        k();
        return C0873v.d(J().getString("dma_consent_settings", (String) null));
    }

    /* access modifiers changed from: package-private */
    public final A3 M() {
        k();
        return A3.f(J().getString("consent_settings", "G1"), J().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    public final Boolean N() {
        k();
        if (!J().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(J().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final Boolean O() {
        k();
        if (J().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(J().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Boolean P() {
        k();
        if (J().contains("measurement_enabled")) {
            return Boolean.valueOf(J().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String Q() {
        k();
        String string = J().getString("previous_os_version", (String) null);
        c().m();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = J().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final String R() {
        k();
        return J().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final String S() {
        k();
        return J().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final void T() {
        k();
        Boolean P4 = P();
        SharedPreferences.Editor edit = J().edit();
        edit.clear();
        edit.apply();
        if (P4 != null) {
            t(P4);
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        SharedPreferences sharedPreferences = A().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f3318c = sharedPreferences;
        boolean z4 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f3335t = z4;
        if (!z4) {
            SharedPreferences.Editor edit = this.f3318c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f3321f = new D2(this, "health_monitor", Math.max(0, ((Long) G.f2465d.a((Object) null)).longValue()));
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Pair r(String str) {
        k();
        if (!M().m(A3.a.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long elapsedRealtime = B().elapsedRealtime();
        if (this.f3325j != null && elapsedRealtime < this.f3327l) {
            return new Pair(this.f3325j, Boolean.valueOf(this.f3326k));
        }
        this.f3327l = elapsedRealtime + b().z(str);
        a.b(true);
        try {
            a.C0000a a5 = a.a(A());
            this.f3325j = "";
            String a6 = a5.a();
            if (a6 != null) {
                this.f3325j = a6;
            }
            this.f3326k = a5.b();
        } catch (Exception e5) {
            a().F().b("Unable to get advertising id", e5);
            this.f3325j = "";
        }
        a.b(false);
        return new Pair(this.f3325j, Boolean.valueOf(this.f3326k));
    }

    /* access modifiers changed from: package-private */
    public final void s(SparseArray sparseArray) {
        if (sparseArray == null) {
            this.f3331p.b((Bundle) null);
            return;
        }
        int[] iArr = new int[sparseArray.size()];
        long[] jArr = new long[sparseArray.size()];
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            iArr[i4] = sparseArray.keyAt(i4);
            jArr[i4] = ((Long) sparseArray.valueAt(i4)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        this.f3331p.b(bundle);
    }

    /* access modifiers changed from: package-private */
    public final void t(Boolean bool) {
        k();
        SharedPreferences.Editor edit = J().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void u(boolean z4) {
        k();
        SharedPreferences.Editor edit = J().edit();
        edit.putBoolean("use_service", z4);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean v(int i4) {
        return A3.l(i4, J().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    public final boolean w(long j4) {
        if (j4 - this.f3328m.a() > this.f3333r.a()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean x(C0873v vVar) {
        k();
        if (!A3.l(vVar.a(), L().a())) {
            return false;
        }
        SharedPreferences.Editor edit = J().edit();
        edit.putString("dma_consent_settings", vVar.j());
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean y(A3 a32) {
        k();
        int b5 = a32.b();
        if (!v(b5)) {
            return false;
        }
        SharedPreferences.Editor edit = J().edit();
        edit.putString("consent_settings", a32.x());
        edit.putInt("consent_source", b5);
        edit.apply();
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean z(C0907z5 z5Var) {
        k();
        String string = J().getString("stored_tcf_param", "");
        String g4 = z5Var.g();
        if (g4.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = J().edit();
        edit.putString("stored_tcf_param", g4);
        edit.apply();
        return true;
    }
}
