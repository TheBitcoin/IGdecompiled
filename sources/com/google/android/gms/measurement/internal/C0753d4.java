package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.d4  reason: case insensitive filesystem */
final class C0753d4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2936a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2937b = null;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2938c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f2939d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f2940e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ F3 f2941f;

    C0753d4(F3 f32, AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        this.f2936a = atomicReference;
        this.f2938c = str2;
        this.f2939d = str3;
        this.f2940e = z4;
        this.f2941f = f32;
    }

    public final void run() {
        this.f2941f.f3273a.J().T(this.f2936a, (String) null, this.f2938c, this.f2939d, this.f2940e);
    }
}
