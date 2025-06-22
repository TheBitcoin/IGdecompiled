package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.j3  reason: case insensitive filesystem */
final class C0794j3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f3045a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3046b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3047c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ X2 f3048d;

    C0794j3(X2 x22, String str, String str2, String str3) {
        this.f3045a = str;
        this.f3046b = str2;
        this.f3047c = str3;
        this.f3048d = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3048d.f2792a.z0();
        return this.f3048d.f2792a.l0().D0(this.f3045a, this.f3046b, this.f3047c);
    }
}
