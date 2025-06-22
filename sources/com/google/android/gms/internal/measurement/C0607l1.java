package com.google.android.gms.internal.measurement;

import M.C0335p;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.l1  reason: case insensitive filesystem */
final class C0607l1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Boolean f1981e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1982f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0607l1(C0544e1 e1Var, Boolean bool) {
        super(e1Var);
        this.f1981e = bool;
        this.f1982f = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f1981e != null) {
            ((P0) C0335p.l(this.f1982f.f1878i)).setMeasurementEnabled(this.f1981e.booleanValue(), this.f1879a);
        } else {
            ((P0) C0335p.l(this.f1982f.f1878i)).clearMeasurementEnabled(this.f1879a);
        }
    }
}
