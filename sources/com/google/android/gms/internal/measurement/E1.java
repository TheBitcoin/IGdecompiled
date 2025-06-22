package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import android.app.Activity;
import com.google.android.gms.internal.measurement.C0544e1;

final class E1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f1452e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1.c f1453f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    E1(C0544e1.c cVar, Activity activity) {
        super(C0544e1.this);
        this.f1452e = activity;
        this.f1453f = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(C0544e1.this.f1878i)).onActivityPaused(b.l0(this.f1452e), this.f1880b);
    }
}
