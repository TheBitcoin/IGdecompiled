package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.q1  reason: case insensitive filesystem */
final class C0650q1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Q0 f2109e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2110f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0650q1(C0544e1 e1Var, Q0 q02) {
        super(e1Var);
        this.f2109e = q02;
        this.f2110f = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2110f.f1878i)).getGmpAppId(this.f2109e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f2109e.f((Bundle) null);
    }
}
