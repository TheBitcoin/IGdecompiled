package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.s3  reason: case insensitive filesystem */
final class C0856s3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ E f3216a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3217b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ X2 f3218c;

    C0856s3(X2 x22, E e5, String str) {
        this.f3216a = e5;
        this.f3217b = str;
        this.f3218c = x22;
    }

    public final void run() {
        this.f3218c.f2792a.z0();
        this.f3218c.f2792a.t(this.f3216a, this.f3217b);
    }
}
