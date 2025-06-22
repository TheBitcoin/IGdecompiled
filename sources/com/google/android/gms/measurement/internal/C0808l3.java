package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.l3  reason: case insensitive filesystem */
final class C0808l3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f3099a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3100b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3101c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ X2 f3102d;

    C0808l3(X2 x22, String str, String str2, String str3) {
        this.f3099a = str;
        this.f3100b = str2;
        this.f3101c = str3;
        this.f3102d = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3102d.f2792a.z0();
        return this.f3102d.f2792a.l0().R(this.f3099a, this.f3100b, this.f3101c);
    }
}
