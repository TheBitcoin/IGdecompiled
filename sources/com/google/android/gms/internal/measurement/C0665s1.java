package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.s1  reason: case insensitive filesystem */
final class C0665s1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Q0 f2150e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2151f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0665s1(C0544e1 e1Var, Q0 q02) {
        super(e1Var);
        this.f2150e = q02;
        this.f2151f = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2151f.f1878i)).generateEventId(this.f2150e);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f2150e.f((Bundle) null);
    }
}
