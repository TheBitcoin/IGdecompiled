package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import android.app.Activity;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.k1  reason: case insensitive filesystem */
final class C0598k1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Activity f1966e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f1967f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f1968g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f1969h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0598k1(C0544e1 e1Var, Activity activity, String str, String str2) {
        super(e1Var);
        this.f1966e = activity;
        this.f1967f = str;
        this.f1968g = str2;
        this.f1969h = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f1969h.f1878i)).setCurrentScreen(b.l0(this.f1966e), this.f1967f, this.f1968g, this.f1879a);
    }
}
