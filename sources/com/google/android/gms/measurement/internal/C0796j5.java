package com.google.android.gms.measurement.internal;

import C.a;
import R.d;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import j$.util.Objects;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.j5  reason: case insensitive filesystem */
public final class C0796j5 extends E5 {

    /* renamed from: d  reason: collision with root package name */
    private final Map f3051d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final A2 f3052e;

    /* renamed from: f  reason: collision with root package name */
    public final A2 f3053f;

    /* renamed from: g  reason: collision with root package name */
    public final A2 f3054g;

    /* renamed from: h  reason: collision with root package name */
    public final A2 f3055h;

    /* renamed from: i  reason: collision with root package name */
    public final A2 f3056i;

    /* renamed from: j  reason: collision with root package name */
    public final A2 f3057j;

    C0796j5(H5 h5) {
        super(h5);
        C0904z2 e5 = e();
        Objects.requireNonNull(e5);
        this.f3052e = new A2(e5, "last_delete_stale", 0);
        C0904z2 e6 = e();
        Objects.requireNonNull(e6);
        this.f3053f = new A2(e6, "last_delete_stale_batch", 0);
        C0904z2 e7 = e();
        Objects.requireNonNull(e7);
        this.f3054g = new A2(e7, "backoff", 0);
        C0904z2 e8 = e();
        Objects.requireNonNull(e8);
        this.f3055h = new A2(e8, "last_upload", 0);
        C0904z2 e9 = e();
        Objects.requireNonNull(e9);
        this.f3056i = new A2(e9, "last_upload_attempt", 0);
        C0904z2 e10 = e();
        Objects.requireNonNull(e10);
        this.f3057j = new A2(e10, "midnight_offset", 0);
    }

    private final Pair v(String str) {
        C0789i5 i5Var;
        a.C0000a aVar;
        k();
        long elapsedRealtime = B().elapsedRealtime();
        C0789i5 i5Var2 = (C0789i5) this.f3051d.get(str);
        if (i5Var2 != null && elapsedRealtime < i5Var2.f3031c) {
            return new Pair(i5Var2.f3029a, Boolean.valueOf(i5Var2.f3030b));
        }
        a.b(true);
        long z4 = b().z(str) + elapsedRealtime;
        try {
            aVar = a.a(A());
        } catch (PackageManager.NameNotFoundException unused) {
            if (i5Var2 != null) {
                try {
                    if (elapsedRealtime < i5Var2.f3031c + b().x(str, G.f2462c)) {
                        return new Pair(i5Var2.f3029a, Boolean.valueOf(i5Var2.f3030b));
                    }
                } catch (Exception e5) {
                    a().F().b("Unable to get advertising id", e5);
                    i5Var = new C0789i5("", false, z4);
                }
            }
            aVar = null;
        }
        if (aVar == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String a5 = aVar.a();
        if (a5 != null) {
            i5Var = new C0789i5(a5, aVar.b(), z4);
        } else {
            i5Var = new C0789i5("", aVar.b(), z4);
        }
        this.f3051d.put(str, i5Var);
        a.b(false);
        return new Pair(i5Var.f3029a, Boolean.valueOf(i5Var.f3030b));
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

    public final /* bridge */ /* synthetic */ Z5 l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ h6 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0797k n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ I2 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0796j5 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ G5 q() {
        return super.q();
    }

    /* access modifiers changed from: protected */
    public final boolean u() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Pair w(String str, A3 a32) {
        if (a32.y()) {
            return v(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    public final String x(String str, boolean z4) {
        String str2;
        k();
        if (z4) {
            str2 = (String) v(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest V02 = d6.V0();
        if (V02 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, V02.digest(str2.getBytes()))});
    }
}
