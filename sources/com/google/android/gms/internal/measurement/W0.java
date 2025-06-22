package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class W0 extends Y implements U0 {
    W0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void f(Bundle bundle) {
        Parcel h4 = h();
        C0507a0.d(h4, bundle);
        k(1, h4);
    }
}
