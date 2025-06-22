package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.r3  reason: case insensitive filesystem */
final class C0849r3 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ E f3205a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3206b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X2 f3207c;

    C0849r3(X2 x22, E e5, String str) {
        this.f3205a = e5;
        this.f3206b = str;
        this.f3207c = x22;
    }

    public final /* synthetic */ Object call() {
        this.f3207c.f2792a.z0();
        return this.f3207c.f2792a.u0().v(this.f3205a, this.f3206b);
    }
}
