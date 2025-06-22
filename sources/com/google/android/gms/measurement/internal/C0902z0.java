package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.z0  reason: case insensitive filesystem */
final class C0902z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f3313a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f3314b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0894y f3315c;

    C0902z0(C0894y yVar, String str, long j4) {
        this.f3313a = str;
        this.f3314b = j4;
        this.f3315c = yVar;
    }

    public final void run() {
        C0894y.z(this.f3315c, this.f3313a, this.f3314b);
    }
}
