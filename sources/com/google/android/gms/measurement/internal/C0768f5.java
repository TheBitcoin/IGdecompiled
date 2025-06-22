package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* renamed from: com.google.android.gms.measurement.internal.f5  reason: case insensitive filesystem */
final class C0768f5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ComponentName f2981a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ C0754d5 f2982b;

    C0768f5(C0754d5 d5Var, ComponentName componentName) {
        this.f2981a = componentName;
        this.f2982b = d5Var;
    }

    public final void run() {
        F4.K(this.f2982b.f2944c, this.f2981a);
    }
}
