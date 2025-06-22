package G;

import Y.c;
import android.os.Parcel;

public abstract class q extends c implements r {
    public q() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            x();
        } else if (i4 != 2) {
            return false;
        } else {
            q();
        }
        return true;
    }
}
