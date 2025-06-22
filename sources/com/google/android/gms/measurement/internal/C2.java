package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.SharedPreferences;

public final class C2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f2337a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2338b;

    /* renamed from: c  reason: collision with root package name */
    private String f2339c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ C0904z2 f2340d;

    public C2(C0904z2 z2Var, String str, String str2) {
        this.f2340d = z2Var;
        C0335p.f(str);
        this.f2337a = str;
    }

    public final String a() {
        if (!this.f2338b) {
            this.f2338b = true;
            this.f2339c = this.f2340d.J().getString(this.f2337a, (String) null);
        }
        return this.f2339c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f2340d.J().edit();
        edit.putString(this.f2337a, str);
        edit.apply();
        this.f2339c = str;
    }
}
