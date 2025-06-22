package com.google.android.gms.common.api.internal;

import L.q;
import android.app.Dialog;

final class A extends q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f1260a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ B f1261b;

    A(B b5, Dialog dialog) {
        this.f1261b = b5;
        this.f1260a = dialog;
    }

    public final void a() {
        this.f1261b.f1263b.o();
        if (this.f1260a.isShowing()) {
            this.f1260a.dismiss();
        }
    }
}
