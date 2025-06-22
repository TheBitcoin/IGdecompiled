package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.v1  reason: case insensitive filesystem */
final class C0689v1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ int f2204e = 5;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f2205f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ Object f2206g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Object f2207h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ Object f2208i;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2209j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0689v1(C0544e1 e1Var, boolean z4, int i4, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f2205f = str;
        this.f2206g = obj;
        this.f2207h = null;
        this.f2208i = null;
        this.f2209j = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        ((P0) C0335p.l(this.f2209j.f1878i)).logHealthData(this.f2204e, this.f2205f, b.l0(this.f2206g), b.l0((Object) null), b.l0((Object) null));
    }
}
