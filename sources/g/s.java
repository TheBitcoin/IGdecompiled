package G;

import Y.c;
import Y.d;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class s extends c implements t {
    public s() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 101:
                d.b(parcel);
                N((GoogleSignInAccount) d.a(parcel, GoogleSignInAccount.CREATOR), (Status) d.a(parcel, Status.CREATOR));
                break;
            case 102:
                d.b(parcel);
                U((Status) d.a(parcel, Status.CREATOR));
                break;
            case 103:
                d.b(parcel);
                M((Status) d.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
