package com.google.android.gms.measurement.internal;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class e6 implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u4 = b.u(parcel2);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList arrayList = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = -2147483648L;
        String str11 = "";
        String str12 = str11;
        String str13 = str12;
        String str14 = str13;
        boolean z4 = true;
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = false;
        int i5 = 100;
        int i6 = 0;
        while (parcel2.dataPosition() < u4) {
            int n4 = b.n(parcel2);
            switch (b.i(n4)) {
                case 2:
                    str = b.d(parcel2, n4);
                    break;
                case 3:
                    str2 = b.d(parcel2, n4);
                    break;
                case 4:
                    str3 = b.d(parcel2, n4);
                    break;
                case 5:
                    str4 = b.d(parcel2, n4);
                    break;
                case 6:
                    j4 = b.q(parcel2, n4);
                    break;
                case 7:
                    j5 = b.q(parcel2, n4);
                    break;
                case 8:
                    str5 = b.d(parcel2, n4);
                    break;
                case 9:
                    z4 = b.j(parcel2, n4);
                    break;
                case 10:
                    z5 = b.j(parcel2, n4);
                    break;
                case 11:
                    j11 = b.q(parcel2, n4);
                    break;
                case 12:
                    str6 = b.d(parcel2, n4);
                    break;
                case 13:
                    j6 = b.q(parcel2, n4);
                    break;
                case 14:
                    j7 = b.q(parcel2, n4);
                    break;
                case 15:
                    i4 = b.p(parcel2, n4);
                    break;
                case 16:
                    z6 = b.j(parcel2, n4);
                    break;
                case 18:
                    z7 = b.j(parcel2, n4);
                    break;
                case 19:
                    str7 = b.d(parcel2, n4);
                    break;
                case 21:
                    bool = b.k(parcel2, n4);
                    break;
                case 22:
                    j8 = b.q(parcel2, n4);
                    break;
                case 23:
                    arrayList = b.e(parcel2, n4);
                    break;
                case 24:
                    str8 = b.d(parcel2, n4);
                    break;
                case 25:
                    str11 = b.d(parcel2, n4);
                    break;
                case 26:
                    str12 = b.d(parcel2, n4);
                    break;
                case 27:
                    str9 = b.d(parcel2, n4);
                    break;
                case 28:
                    z8 = b.j(parcel2, n4);
                    break;
                case 29:
                    j9 = b.q(parcel2, n4);
                    break;
                case 30:
                    i5 = b.p(parcel2, n4);
                    break;
                case 31:
                    str13 = b.d(parcel2, n4);
                    break;
                case 32:
                    i6 = b.p(parcel2, n4);
                    break;
                case 34:
                    j10 = b.q(parcel2, n4);
                    break;
                case 35:
                    str10 = b.d(parcel2, n4);
                    break;
                case 36:
                    str14 = b.d(parcel2, n4);
                    break;
                default:
                    b.t(parcel2, n4);
                    break;
            }
        }
        b.h(parcel2, u4);
        return new M5(str, str2, str3, str4, j4, j5, str5, z4, z5, j11, str6, j6, j7, i4, z6, z7, str7, bool, j8, (List) arrayList, str8, str11, str12, str9, z8, j9, i5, str13, i6, j10, str10, str14);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new M5[i4];
    }
}
