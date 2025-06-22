package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.a  reason: case insensitive filesystem */
final class C0727a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2841a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ long f2842b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0894y f2843c;

    C0727a(C0894y yVar, String str, long j4) {
        this.f2841a = str;
        this.f2842b = j4;
        this.f2843c = yVar;
    }

    public final void run() {
        C0894y.v(this.f2843c, this.f2841a, this.f2842b);
    }
}
