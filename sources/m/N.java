package M;

import N.b;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class N implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i6 = b.i(n4);
            if (i6 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i6 == 2) {
                account = (Account) b.c(parcel, n4, Account.CREATOR);
            } else if (i6 == 3) {
                i5 = b.p(parcel, n4);
            } else if (i6 != 4) {
                b.t(parcel, n4);
            } else {
                googleSignInAccount = (GoogleSignInAccount) b.c(parcel, n4, GoogleSignInAccount.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new M(i4, account, i5, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new M[i4];
    }
}
