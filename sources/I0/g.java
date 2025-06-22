package i0;

import Z.a;
import Z.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class g extends a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void l0(j jVar, f fVar) {
        Parcel h4 = h();
        c.c(h4, jVar);
        c.d(h4, fVar);
        i(12, h4);
    }
}
