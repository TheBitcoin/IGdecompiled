package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.k3  reason: case insensitive filesystem */
final class C0801k3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f3080a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3081b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3082c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ X2 f3083d;

    C0801k3(X2 x22, String str, String str2, String str3) {
        this.f3080a = str;
        this.f3081b = str2;
        this.f3082c = str3;
        this.f3083d = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3083d.f2792a.z0();
        return this.f3083d.f2792a.l0().D0(this.f3080a, this.f3081b, this.f3082c);
    }
}
