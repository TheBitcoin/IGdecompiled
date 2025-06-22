package com.google.android.gms.common.api;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        String str = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i5 != 2) {
                b.t(parcel, n4);
            } else {
                str = b.d(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new Scope(i4, str);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new Scope[i4];
    }
}
