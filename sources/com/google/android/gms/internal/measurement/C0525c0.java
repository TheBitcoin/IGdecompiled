package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.measurement.c0  reason: case insensitive filesystem */
public abstract class C0525c0 extends C0516b0 implements C0534d0 {
    public static C0534d0 i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        if (queryLocalInterface instanceof C0534d0) {
            return (C0534d0) queryLocalInterface;
        }
        return new C0552f0(iBinder);
    }
}
