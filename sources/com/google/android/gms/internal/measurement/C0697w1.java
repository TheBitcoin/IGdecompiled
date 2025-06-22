package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.w1  reason: case insensitive filesystem */
final class C0697w1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f2218e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Q0 f2219f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2220g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0697w1(C0544e1 e1Var, String str, Q0 q02) {
        super(e1Var);
        this.f2218e = str;
        this.f2219f = q02;
        this.f2220g = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2220g.f1878i)).getMaxUserProperties(this.f2218e, this.f2219f);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f2219f.f((Bundle) null);
    }
}
