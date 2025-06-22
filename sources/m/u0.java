package M;

import U.a;
import android.os.IBinder;
import android.os.Parcel;
import b0.a;

public final class u0 extends a implements S {
    u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final U.a C() {
        Parcel h4 = h(1, i());
        U.a i4 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i4;
    }

    public final int b() {
        Parcel h4 = h(2, i());
        int readInt = h4.readInt();
        h4.recycle();
        return readInt;
    }
}
