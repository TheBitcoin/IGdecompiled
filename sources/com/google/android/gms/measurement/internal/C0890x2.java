package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.measurement.internal.x2  reason: case insensitive filesystem */
public final class C0890x2 {

    /* renamed from: a  reason: collision with root package name */
    private final String f3287a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3288b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3289c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3290d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0904z2 f3291e;

    public C0890x2(C0904z2 z2Var, String str, boolean z4) {
        this.f3291e = z2Var;
        C0335p.f(str);
        this.f3287a = str;
        this.f3288b = z4;
    }

    public final void a(boolean z4) {
        SharedPreferences.Editor edit = this.f3291e.J().edit();
        edit.putBoolean(this.f3287a, z4);
        edit.apply();
        this.f3290d = z4;
    }

    public final boolean b() {
        if (!this.f3289c) {
            this.f3289c = true;
            this.f3290d = this.f3291e.J().getBoolean(this.f3287a, this.f3288b);
        }
        return this.f3290d;
    }
}
