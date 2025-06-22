package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.SharedPreferences;

public final class A2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2294a;

    /* renamed from: b  reason: collision with root package name */
    private final long f2295b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2296c;

    /* renamed from: d  reason: collision with root package name */
    private long f2297d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0904z2 f2298e;

    public A2(C0904z2 z2Var, String str, long j4) {
        this.f2298e = z2Var;
        C0335p.f(str);
        this.f2294a = str;
        this.f2295b = j4;
    }

    public final long a() {
        if (!this.f2296c) {
            this.f2296c = true;
            this.f2297d = this.f2298e.J().getLong(this.f2294a, this.f2295b);
        }
        return this.f2297d;
    }

    public final void b(long j4) {
        SharedPreferences.Editor edit = this.f2298e.J().edit();
        edit.putLong(this.f2294a, j4);
        edit.apply();
        this.f2297d = j4;
    }
}
