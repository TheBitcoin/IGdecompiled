package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.i1  reason: case insensitive filesystem */
final class C0580i1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f1929e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f1930f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Q0 f1931g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1932h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0580i1(C0544e1 e1Var, String str, String str2, Q0 q02) {
        super(e1Var);
        this.f1929e = str;
        this.f1930f = str2;
        this.f1931g = q02;
        this.f1932h = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f1932h.f1878i)).getConditionalUserProperties(this.f1929e, this.f1930f, this.f1931g);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f1931g.f((Bundle) null);
    }
}
