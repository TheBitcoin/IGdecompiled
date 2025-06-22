package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import android.app.Activity;
import com.google.android.gms.internal.measurement.C0544e1;

final class G1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f1475e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Q0 f1476f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ C0544e1.c f1477g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    G1(C0544e1.c cVar, Activity activity, Q0 q02) {
        super(C0544e1.this);
        this.f1475e = activity;
        this.f1476f = q02;
        this.f1477g = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(C0544e1.this.f1878i)).onActivitySaveInstanceState(b.l0(this.f1475e), this.f1476f, this.f1880b);
    }
}
