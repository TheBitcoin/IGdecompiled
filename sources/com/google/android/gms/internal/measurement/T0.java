package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

public abstract class T0 extends C0516b0 implements U0 {
    public T0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 != 1) {
            return false;
        }
        C0507a0.f(parcel);
        f((Bundle) C0507a0.a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
