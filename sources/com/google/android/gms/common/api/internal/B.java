package com.google.android.gms.common.api.internal;

import J.C0303b;
import M.C0335p;
import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiActivity;

final class B implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final z f1262a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C f1263b;

    B(C c5, z zVar) {
        this.f1263b = c5;
        this.f1262a = zVar;
    }

    public final void run() {
        if (this.f1263b.f1277b) {
            C0303b b5 = this.f1262a.b();
            if (b5.j()) {
                C c5 = this.f1263b;
                c5.f1281a.startActivityForResult(GoogleApiActivity.a(c5.b(), (PendingIntent) C0335p.l(b5.h()), this.f1262a.a(), false), 1);
                return;
            }
            C c6 = this.f1263b;
            if (c6.f1280e.b(c6.b(), b5.c(), (String) null) != null) {
                C c7 = this.f1263b;
                c7.f1280e.w(c7.b(), c7.f1281a, b5.c(), 2, this.f1263b);
            } else if (b5.c() == 18) {
                C c8 = this.f1263b;
                Dialog r4 = c8.f1280e.r(c8.b(), c8);
                C c9 = this.f1263b;
                c9.f1280e.s(c9.b().getApplicationContext(), new A(this, r4));
            } else {
                this.f1263b.l(b5, this.f1262a.a());
            }
        }
    }
}
