package com.google.android.gms.measurement.internal;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class b6 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u4 = b.u(parcel2);
        String str = null;
        Long l4 = null;
        Float f4 = null;
        String str2 = null;
        String str3 = null;
        Double d5 = null;
        long j4 = 0;
        int i4 = 0;
        while (parcel2.dataPosition() < u4) {
            int n4 = b.n(parcel2);
            switch (b.i(n4)) {
                case 1:
                    i4 = b.p(parcel2, n4);
                    break;
                case 2:
                    str = b.d(parcel2, n4);
                    break;
                case 3:
                    j4 = b.q(parcel2, n4);
                    break;
                case 4:
                    l4 = b.r(parcel2, n4);
                    break;
                case 5:
                    f4 = b.m(parcel2, n4);
                    break;
                case 6:
                    str2 = b.d(parcel2, n4);
                    break;
                case 7:
                    str3 = b.d(parcel2, n4);
                    break;
                case 8:
                    d5 = b.l(parcel2, n4);
                    break;
                default:
                    b.t(parcel2, n4);
                    break;
            }
        }
        b.h(parcel2, u4);
        return new Y5(i4, str, j4, l4, f4, str2, str3, d5);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new Y5[i4];
    }
}
