package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.w  reason: case insensitive filesystem */
final class C0880w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0898y3 f3268a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0859t f3269b;

    C0880w(C0859t tVar, C0898y3 y3Var) {
        this.f3268a = y3Var;
        this.f3269b = tVar;
    }

    public final void run() {
        this.f3268a.C();
        if (C0741c.a()) {
            this.f3268a.f().D(this);
            return;
        }
        boolean e5 = this.f3269b.e();
        this.f3269b.f3225c = 0;
        if (e5) {
            this.f3269b.d();
        }
    }
}
