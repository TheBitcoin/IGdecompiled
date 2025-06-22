package i0;

import J.C0303b;
import Z.b;
import Z.c;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public abstract class e extends b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean l0(int i4, Parcel parcel, Parcel parcel2, int i5) {
        switch (i4) {
            case 3:
                C0303b bVar = (C0303b) c.a(parcel, C0303b.CREATOR);
                b bVar2 = (b) c.a(parcel, b.CREATOR);
                c.b(parcel);
                break;
            case 4:
                Status status = (Status) c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            case 6:
                Status status2 = (Status) c.a(parcel, Status.CREATOR);
                c.b(parcel);
                break;
            case 7:
                Status status3 = (Status) c.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) c.a(parcel, GoogleSignInAccount.CREATOR);
                c.b(parcel);
                break;
            case 8:
                c.b(parcel);
                a0((l) c.a(parcel, l.CREATOR));
                break;
            case 9:
                h hVar = (h) c.a(parcel, h.CREATOR);
                c.b(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
