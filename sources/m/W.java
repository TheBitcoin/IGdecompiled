package M;

import android.os.IBinder;
import android.os.IInterface;
import b0.b;

public abstract class W extends b implements X {
    public static X i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof X) {
            return (X) queryLocalInterface;
        }
        return new V(iBinder);
    }
}
