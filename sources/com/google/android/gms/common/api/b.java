package com.google.android.gms.common.api;

import J.C0303b;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

public final class b implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = N.b.u(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        C0303b bVar = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = N.b.n(parcel);
            int i5 = N.b.i(n4);
            if (i5 == 1) {
                i4 = N.b.p(parcel, n4);
            } else if (i5 == 2) {
                str = N.b.d(parcel, n4);
            } else if (i5 == 3) {
                pendingIntent = (PendingIntent) N.b.c(parcel, n4, PendingIntent.CREATOR);
            } else if (i5 != 4) {
                N.b.t(parcel, n4);
            } else {
                bVar = (C0303b) N.b.c(parcel, n4, C0303b.CREATOR);
            }
        }
        N.b.h(parcel, u4);
        return new Status(i4, str, pendingIntent, bVar);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new Status[i4];
    }
}
