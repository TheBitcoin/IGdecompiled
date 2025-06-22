package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.measurement.f0  reason: case insensitive filesystem */
public final class C0552f0 extends Y implements C0534d0 {
    C0552f0(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle f(Bundle bundle) {
        Parcel h4 = h();
        C0507a0.d(h4, bundle);
        Parcel i4 = i(1, h4);
        Bundle bundle2 = (Bundle) C0507a0.a(i4, Bundle.CREATOR);
        i4.recycle();
        return bundle2;
    }
}
