package com.google.android.gms.auth.api.signin;

import N.b;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u4 = b.u(parcel2);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
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
                    str2 = b.d(parcel2, n4);
                    break;
                case 4:
                    str3 = b.d(parcel2, n4);
                    break;
                case 5:
                    str4 = b.d(parcel2, n4);
                    break;
                case 6:
                    uri = (Uri) b.c(parcel2, n4, Uri.CREATOR);
                    break;
                case 7:
                    str5 = b.d(parcel2, n4);
                    break;
                case 8:
                    j4 = b.q(parcel2, n4);
                    break;
                case 9:
                    str6 = b.d(parcel2, n4);
                    break;
                case 10:
                    arrayList = b.g(parcel2, n4, Scope.CREATOR);
                    break;
                case 11:
                    str7 = b.d(parcel2, n4);
                    break;
                case 12:
                    str8 = b.d(parcel2, n4);
                    break;
                default:
                    b.t(parcel2, n4);
                    break;
            }
        }
        b.h(parcel2, u4);
        return new GoogleSignInAccount(i4, str, str2, str3, str4, uri, str5, j4, str6, arrayList, str7, str8);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new GoogleSignInAccount[i4];
    }
}
