package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.m3  reason: case insensitive filesystem */
final class C0815m3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f3118a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3119b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3120c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ X2 f3121d;

    C0815m3(X2 x22, String str, String str2, String str3) {
        this.f3118a = str;
        this.f3119b = str2;
        this.f3120c = str3;
        this.f3121d = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3121d.f2792a.z0();
        return this.f3121d.f2792a.l0().R(this.f3118a, this.f3119b, this.f3120c);
    }
}
