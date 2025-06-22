package com.google.android.gms.internal.measurement;

import M.C0335p;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.y1  reason: case insensitive filesystem */
final class C0713y1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0544e1.b f2256e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2257f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0713y1(C0544e1 e1Var, C0544e1.b bVar) {
        super(e1Var);
        this.f2256e = bVar;
        this.f2257f = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2257f.f1878i)).registerOnMeasurementEventListener(this.f2256e);
    }
}
