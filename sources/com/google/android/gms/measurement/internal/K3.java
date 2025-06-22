package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class K3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ F3 f2603a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ Bundle f2604b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ long f2605c;

    public /* synthetic */ K3(F3 f32, Bundle bundle, long j4) {
        this.f2603a = f32;
        this.f2604b = bundle;
        this.f2605c = j4;
    }

    public final void run() {
        this.f2603a.O(this.f2604b, this.f2605c);
    }
}
