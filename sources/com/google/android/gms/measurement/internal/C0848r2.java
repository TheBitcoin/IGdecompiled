package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.r2  reason: case insensitive filesystem */
public final class C0848r2 {

    /* renamed from: a  reason: collision with root package name */
    public String f3201a;

    /* renamed from: b  reason: collision with root package name */
    public String f3202b;

    /* renamed from: c  reason: collision with root package name */
    private long f3203c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f3204d;

    public C0848r2(String str, String str2, Bundle bundle, long j4) {
        this.f3201a = str;
        this.f3202b = str2;
        this.f3204d = bundle == null ? new Bundle() : bundle;
        this.f3203c = j4;
    }

    public static C0848r2 b(E e5) {
        return new C0848r2(e5.f2366a, e5.f2368c, e5.f2367b.j(), e5.f2369d);
    }

    public final E a() {
        return new E(this.f3201a, new D(new Bundle(this.f3204d)), this.f3202b, this.f3203c);
    }

    public final String toString() {
        String str = this.f3202b;
        String str2 = this.f3201a;
        String valueOf = String.valueOf(this.f3204d);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }
}
