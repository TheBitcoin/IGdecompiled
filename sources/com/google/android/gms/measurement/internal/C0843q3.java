package com.google.android.gms.measurement.internal;

import f0.C0913b;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.q3  reason: case insensitive filesystem */
final class C0843q3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ M5 f3191a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ X2 f3192b;

    C0843q3(X2 x22, M5 m5) {
        this.f3191a = m5;
        this.f3192b = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3192b.f2792a.z0();
        return new C0913b(this.f3192b.f2792a.d(this.f3191a.f2631a));
    }
}
