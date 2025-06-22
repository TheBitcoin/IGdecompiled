package com.google.android.gms.measurement.internal;

final class W3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2780a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2781b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f2782c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f2783d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ F3 f2784e;

    W3(F3 f32, String str, String str2, Object obj, long j4) {
        this.f2780a = str;
        this.f2781b = str2;
        this.f2782c = obj;
        this.f2783d = j4;
        this.f2784e = f32;
    }

    public final void run() {
        this.f2784e.k0(this.f2780a, this.f2781b, this.f2782c, this.f2783d);
    }
}
