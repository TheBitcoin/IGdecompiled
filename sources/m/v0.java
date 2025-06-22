package M;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.b;
import b0.c;

public abstract class v0 extends b implements S {
    public v0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static S i(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof S) {
            return (S) queryLocalInterface;
        }
        return new u0(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            a C4 = C();
            parcel2.writeNoException();
            c.d(parcel2, C4);
        } else if (i4 != 2) {
            return false;
        } else {
            int b5 = b();
            parcel2.writeNoException();
            parcel2.writeInt(b5);
        }
        return true;
    }
}
