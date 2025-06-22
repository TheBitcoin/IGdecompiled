package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.e4  reason: case insensitive filesystem */
final class C0760e4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f2966a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2967b = null;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2968c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f2969d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ F3 f2970e;

    C0760e4(F3 f32, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f2966a = atomicReference;
        this.f2968c = str2;
        this.f2969d = str3;
        this.f2970e = f32;
    }

    public final void run() {
        this.f2970e.f3273a.J().S(this.f2966a, (String) null, this.f2968c, this.f2969d);
    }
}
