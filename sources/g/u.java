package G;

import Y.a;
import Y.d;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class u extends a implements IInterface {
    u(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void k(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel h4 = h();
        d.d(h4, tVar);
        d.c(h4, googleSignInOptions);
        i(103, h4);
    }

    public final void l0(t tVar, GoogleSignInOptions googleSignInOptions) {
        Parcel h4 = h();
        d.d(h4, tVar);
        d.c(h4, googleSignInOptions);
        i(102, h4);
    }
}
