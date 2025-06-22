package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.h5  reason: case insensitive filesystem */
final class C0782h5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C0754d5 f3017a;

    C0782h5(C0754d5 d5Var) {
        this.f3017a = d5Var;
    }

    public final void run() {
        F4.K(this.f3017a.f2944c, new ComponentName(this.f3017a.f2944c.A(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
