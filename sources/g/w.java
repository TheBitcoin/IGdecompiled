package G;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

public final class w implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i4 = b.i(n4);
            if (i4 == 2) {
                str = b.d(parcel, n4);
            } else if (i4 != 5) {
                b.t(parcel, n4);
            } else {
                googleSignInOptions = (GoogleSignInOptions) b.c(parcel, n4, GoogleSignInOptions.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new SignInConfiguration[i4];
    }
}
