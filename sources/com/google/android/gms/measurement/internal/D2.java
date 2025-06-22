package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.SharedPreferences;
import android.util.Pair;

public final class D2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2345a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2346b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2347c;

    /* renamed from: d  reason: collision with root package name */
    private final long f2348d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0904z2 f2349e;

    private final long c() {
        return this.f2349e.J().getLong(this.f2345a, 0);
    }

    private final void d() {
        this.f2349e.k();
        long currentTimeMillis = this.f2349e.B().currentTimeMillis();
        SharedPreferences.Editor edit = this.f2349e.J().edit();
        edit.remove(this.f2346b);
        edit.remove(this.f2347c);
        edit.putLong(this.f2345a, currentTimeMillis);
        edit.apply();
    }

    public final Pair a() {
        long j4;
        this.f2349e.k();
        this.f2349e.k();
        long c5 = c();
        if (c5 == 0) {
            d();
            j4 = 0;
        } else {
            j4 = Math.abs(c5 - this.f2349e.B().currentTimeMillis());
        }
        long j5 = this.f2348d;
        if (j4 < j5) {
            return null;
        }
        if (j4 > (j5 << 1)) {
            d();
            return null;
        }
        String string = this.f2349e.J().getString(this.f2347c, (String) null);
        long j6 = this.f2349e.J().getLong(this.f2346b, 0);
        d();
        if (string == null || j6 <= 0) {
            return C0904z2.f3316B;
        }
        return new Pair(string, Long.valueOf(j6));
    }

    public final void b(String str, long j4) {
        boolean z4;
        this.f2349e.k();
        if (c() == 0) {
            d();
        }
        if (str == null) {
            str = "";
        }
        long j5 = this.f2349e.J().getLong(this.f2346b, 0);
        if (j5 <= 0) {
            SharedPreferences.Editor edit = this.f2349e.J().edit();
            edit.putString(this.f2347c, str);
            edit.putLong(this.f2346b, 1);
            edit.apply();
            return;
        }
        long j6 = j5 + 1;
        if ((this.f2349e.g().W0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j6) {
            z4 = true;
        } else {
            z4 = false;
        }
        SharedPreferences.Editor edit2 = this.f2349e.J().edit();
        if (z4) {
            edit2.putString(this.f2347c, str);
        }
        edit2.putLong(this.f2346b, j6);
        edit2.apply();
    }

    private D2(C0904z2 z2Var, String str, long j4) {
        this.f2349e = z2Var;
        C0335p.f(str);
        C0335p.a(j4 > 0);
        this.f2345a = str + ":start";
        this.f2346b = str + ":count";
        this.f2347c = str + ":value";
        this.f2348d = j4;
    }
}
