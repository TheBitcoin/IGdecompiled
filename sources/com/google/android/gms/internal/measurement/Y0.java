package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

public abstract class Y0 extends C0516b0 implements V0 {
    public Y0() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            long readLong = parcel.readLong();
            C0507a0.f(parcel);
            V(parcel.readString(), parcel.readString(), (Bundle) C0507a0.a(parcel, Bundle.CREATOR), readLong);
            parcel2.writeNoException();
        } else if (i4 != 2) {
            return false;
        } else {
            int A4 = A();
            parcel2.writeNoException();
            parcel2.writeInt(A4);
        }
        return true;
    }
}
