package com.google.android.gms.internal.measurement;

import N.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.measurement.b1  reason: case insensitive filesystem */
public final class C0517b1 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u4 = b.u(parcel2);
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        boolean z4 = false;
        while (parcel2.dataPosition() < u4) {
            int n4 = b.n(parcel2);
            switch (b.i(n4)) {
                case 1:
                    j4 = b.q(parcel2, n4);
                    break;
                case 2:
                    j5 = b.q(parcel2, n4);
                    break;
                case 3:
                    z4 = b.j(parcel2, n4);
                    break;
                case 4:
                    str = b.d(parcel2, n4);
                    break;
                case 5:
                    str2 = b.d(parcel2, n4);
                    break;
                case 6:
                    str3 = b.d(parcel2, n4);
                    break;
                case 7:
                    bundle = b.a(parcel2, n4);
                    break;
                case 8:
                    str4 = b.d(parcel2, n4);
                    break;
                default:
                    b.t(parcel2, n4);
                    break;
            }
        }
        b.h(parcel2, u4);
        return new C0526c1(j4, j5, z4, str, str2, str3, bundle, str4);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0526c1[i4];
    }
}
