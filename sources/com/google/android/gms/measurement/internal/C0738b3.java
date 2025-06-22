package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.measurement.internal.b3  reason: case insensitive filesystem */
public final /* synthetic */ class C0738b3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ X2 f2872a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Bundle f2873b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f2874c;

    public /* synthetic */ C0738b3(X2 x22, Bundle bundle, String str) {
        this.f2872a = x22;
        this.f2873b = bundle;
        this.f2874c = str;
    }

    public final void run() {
        this.f2872a.k(this.f2873b, this.f2874c);
    }
}
