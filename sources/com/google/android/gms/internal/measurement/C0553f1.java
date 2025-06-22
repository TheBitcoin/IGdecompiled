package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.f1  reason: case insensitive filesystem */
final class C0553f1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Bundle f1891e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1892f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0553f1(C0544e1 e1Var, Bundle bundle) {
        super(e1Var);
        this.f1891e = bundle;
        this.f1892f = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f1892f.f1878i)).setConditionalUserProperty(this.f1891e, this.f1879a);
    }
}
