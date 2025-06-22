package com.google.android.gms.internal.measurement;

import M.C0335p;
import U.b;
import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0544e1;

final class A1 extends C0544e1.a {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Bundle f1397e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ Activity f1398f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ C0544e1.c f1399g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    A1(C0544e1.c cVar, Bundle bundle, Activity activity) {
        super(C0544e1.this);
        this.f1397e = bundle;
        this.f1398f = activity;
        this.f1399g = cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Bundle bundle;
        if (this.f1397e != null) {
            bundle = new Bundle();
            if (this.f1397e.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f1397e.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((P0) C0335p.l(C0544e1.this.f1878i)).onActivityCreated(b.l0(this.f1398f), bundle, this.f1880b);
    }
}
