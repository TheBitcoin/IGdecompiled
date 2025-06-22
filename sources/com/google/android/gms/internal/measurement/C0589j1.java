package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.j1  reason: case insensitive filesystem */
final class C0589j1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f1945e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f1946f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Bundle f1947g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1948h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0589j1(C0544e1 e1Var, String str, String str2, Bundle bundle) {
        super(e1Var);
        this.f1945e = str;
        this.f1946f = str2;
        this.f1947g = bundle;
        this.f1948h = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f1948h.f1878i)).clearConditionalUserProperty(this.f1945e, this.f1946f, this.f1947g);
    }
}
