package com.google.android.gms.internal.measurement;

import M.C0335p;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

/* renamed from: com.google.android.gms.internal.measurement.z1  reason: case insensitive filesystem */
final class C0721z1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Long f2263e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ String f2264f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ String f2265g;

    /* renamed from: h  reason: collision with root package name */
    private final /* synthetic */ Bundle f2266h;

    /* renamed from: i  reason: collision with root package name */
    private final /* synthetic */ boolean f2267i;

    /* renamed from: j  reason: collision with root package name */
    private final /* synthetic */ boolean f2268j;

    /* renamed from: k  reason: collision with root package name */
    private final /* synthetic */ C0544e1 f2269k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0721z1(C0544e1 e1Var, Long l4, String str, String str2, Bundle bundle, boolean z4, boolean z5) {
        super(e1Var);
        this.f2263e = l4;
        this.f2264f = str;
        this.f2265g = str2;
        this.f2266h = bundle;
        this.f2267i = z4;
        this.f2268j = z5;
        this.f2269k = e1Var;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        long longValue;
        Long l4 = this.f2263e;
        if (l4 == null) {
            longValue = this.f1879a;
        } else {
            longValue = l4.longValue();
        }
        ((P0) C0335p.l(this.f2269k.f1878i)).logEvent(this.f2264f, this.f2265g, this.f2266h, this.f2267i, this.f2268j, longValue);
    }
}
