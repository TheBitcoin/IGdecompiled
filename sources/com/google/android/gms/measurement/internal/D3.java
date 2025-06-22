package com.google.android.gms.measurement.internal;

import M.C0335p;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0526c1;

public final class D3 {

    /* renamed from: a  reason: collision with root package name */
    final Context f2350a;

    /* renamed from: b  reason: collision with root package name */
    String f2351b;

    /* renamed from: c  reason: collision with root package name */
    String f2352c;

    /* renamed from: d  reason: collision with root package name */
    String f2353d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f2354e;

    /* renamed from: f  reason: collision with root package name */
    long f2355f;

    /* renamed from: g  reason: collision with root package name */
    C0526c1 f2356g;

    /* renamed from: h  reason: collision with root package name */
    boolean f2357h = true;

    /* renamed from: i  reason: collision with root package name */
    Long f2358i;

    /* renamed from: j  reason: collision with root package name */
    String f2359j;

    public D3(Context context, C0526c1 c1Var, Long l4) {
        C0335p.l(context);
        Context applicationContext = context.getApplicationContext();
        C0335p.l(applicationContext);
        this.f2350a = applicationContext;
        this.f2358i = l4;
        if (c1Var != null) {
            this.f2356g = c1Var;
            this.f2351b = c1Var.f1770f;
            this.f2352c = c1Var.f1769e;
            this.f2353d = c1Var.f1768d;
            this.f2357h = c1Var.f1767c;
            this.f2355f = c1Var.f1766b;
            this.f2359j = c1Var.f1772h;
            Bundle bundle = c1Var.f1771g;
            if (bundle != null) {
                this.f2354e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
