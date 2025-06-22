package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.h1  reason: case insensitive filesystem */
final class C0571h1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f1914e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f1915f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Object f1916g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ boolean f1917h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1918i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0571h1(C0544e1 e1Var, String str, String str2, Object obj, boolean z4) {
        super(e1Var);
        this.f1914e = str;
        this.f1915f = str2;
        this.f1916g = obj;
        this.f1917h = z4;
        this.f1918i = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f1918i.f1878i)).setUserProperty(this.f1914e, this.f1915f, b.l0(this.f1916g), this.f1917h, this.f1879a);
    }
}
