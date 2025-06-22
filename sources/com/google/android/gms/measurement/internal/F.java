package com.google.android.gms.measurement.internal;

import N.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class F implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            if (b.i(n4) != 2) {
                b.t(parcel, n4);
            } else {
                bundle = b.a(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new D(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new D[i4];
    }
}
