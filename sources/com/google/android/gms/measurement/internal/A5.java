package com.google.android.gms.measurement.internal;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class A5 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        String str = null;
        long j4 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                str = b.d(parcel, n4);
            } else if (i5 == 2) {
                j4 = b.q(parcel, n4);
            } else if (i5 != 3) {
                b.t(parcel, n4);
            } else {
                i4 = b.p(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new B5(str, j4, i4);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new B5[i4];
    }
}
