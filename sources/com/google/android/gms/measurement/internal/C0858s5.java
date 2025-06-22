package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.s5  reason: case insensitive filesystem */
final class C0858s5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    long f3219a;

    /* renamed from: b  reason: collision with root package name */
    long f3220b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ C0865t5 f3221c;

    C0858s5(C0865t5 t5Var, long j4, long j5) {
        this.f3221c = t5Var;
        this.f3219a = j4;
        this.f3220b = j5;
    }

    public final void run() {
        this.f3221c.f3235b.f().D(new C0879v5(this));
    }
}
