package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class X3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2795a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2796b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ long f2797c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f2798d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f2799e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ boolean f2800f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f2801g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ String f2802h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ F3 f2803i;

    X3(F3 f32, String str, String str2, long j4, Bundle bundle, boolean z4, boolean z5, boolean z6, String str3) {
        this.f2795a = str;
        this.f2796b = str2;
        this.f2797c = j4;
        this.f2798d = bundle;
        this.f2799e = z4;
        this.f2800f = z5;
        this.f2801g = z6;
        this.f2802h = str3;
        this.f2803i = f32;
    }

    public final void run() {
        this.f2803i.f0(this.f2795a, this.f2796b, this.f2797c, this.f2798d, this.f2799e, this.f2800f, this.f2801g, this.f2802h);
    }
}
