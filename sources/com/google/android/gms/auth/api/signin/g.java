package com.google.android.gms.auth.api.signin;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class g implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i4 = b.i(n4);
            if (i4 == 4) {
                str = b.d(parcel, n4);
            } else if (i4 == 7) {
                googleSignInAccount = (GoogleSignInAccount) b.c(parcel, n4, GoogleSignInAccount.CREATOR);
            } else if (i4 != 8) {
                b.t(parcel, n4);
            } else {
                str2 = b.d(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new SignInAccount[i4];
    }
}
