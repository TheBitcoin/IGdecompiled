package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C0685u5;
import java.util.concurrent.Callable;

public final /* synthetic */ class J2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ I2 f2592a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ String f2593b;

    public /* synthetic */ J2(I2 i22, String str) {
        this.f2592a = i22;
        this.f2593b = str;
    }

    public final Object call() {
        return new C0685u5("internal.remoteConfig", new M2(this.f2592a, this.f2593b));
    }
}
