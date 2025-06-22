package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class Z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ X2 f2830a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Bundle f2831b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ String f2832c;

    public /* synthetic */ Z2(X2 x22, Bundle bundle, String str) {
        this.f2830a = x22;
        this.f2831b = bundle;
        this.f2832c = str;
    }

    public final void run() {
        this.f2830a.o0(this.f2831b, this.f2832c);
    }
}
