package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.v5  reason: case insensitive filesystem */
public final /* synthetic */ class C0879v5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ C0858s5 f3267a;

    public /* synthetic */ C0879v5(C0858s5 s5Var) {
        this.f3267a = s5Var;
    }

    public final void run() {
        C0858s5 s5Var = this.f3267a;
        C0865t5 t5Var = s5Var.f3221c;
        long j4 = s5Var.f3219a;
        long j5 = s5Var.f3220b;
        t5Var.f3235b.k();
        t5Var.f3235b.a().F().a("Application going to the background");
        t5Var.f3235b.e().f3336u.a(true);
        t5Var.f3235b.D(true);
        if (!t5Var.f3235b.b().V()) {
            if (t5Var.f3235b.b().q(G.f2437Q0)) {
                t5Var.f3235b.E(false, false, j5);
                t5Var.f3235b.f3189f.e(j5);
            } else {
                t5Var.f3235b.f3189f.e(j5);
                t5Var.f3235b.E(false, false, j5);
            }
        }
        t5Var.f3235b.a().J().b("Application backgrounded at: timestamp_millis", Long.valueOf(j4));
        if (t5Var.f3235b.b().q(G.f2470e1)) {
            t5Var.f3235b.o().B0();
        }
    }
}
