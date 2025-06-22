package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.j4  reason: case insensitive filesystem */
final class C0795j4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Boolean f3049a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ F3 f3050b;

    C0795j4(F3 f32, Boolean bool) {
        this.f3049a = bool;
        this.f3050b = f32;
    }

    public final void run() {
        this.f3050b.c0(this.f3049a, true);
    }
}
