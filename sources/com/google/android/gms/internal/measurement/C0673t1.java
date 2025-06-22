package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.t1  reason: case insensitive filesystem */
final class C0673t1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f2174e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f2175f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ boolean f2176g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Q0 f2177h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2178i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0673t1(C0544e1 e1Var, String str, String str2, boolean z4, Q0 q02) {
        super(e1Var);
        this.f2174e = str;
        this.f2175f = str2;
        this.f2176g = z4;
        this.f2177h = q02;
        this.f2178i = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2178i.f1878i)).getUserProperties(this.f2174e, this.f2175f, this.f2176g, this.f2177h);
    }

    /* access modifiers changed from: protected */
    public final void b() {
        this.f2177h.f((Bundle) null);
    }
}
