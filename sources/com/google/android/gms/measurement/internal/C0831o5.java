package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* renamed from: com.google.android.gms.measurement.internal.o5  reason: case insensitive filesystem */
public final /* synthetic */ class C0831o5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ C0810l5 f3167a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f3168b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ C0821n2 f3169c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ Intent f3170d;

    public /* synthetic */ C0831o5(C0810l5 l5Var, int i4, C0821n2 n2Var, Intent intent) {
        this.f3167a = l5Var;
        this.f3168b = i4;
        this.f3169c = n2Var;
        this.f3170d = intent;
    }

    public final void run() {
        this.f3167a.d(this.f3168b, this.f3169c, this.f3170d);
    }
}
