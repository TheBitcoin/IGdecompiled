package J;

import N.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class J implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        boolean z4 = false;
        String str = null;
        IBinder iBinder = null;
        boolean z5 = false;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i4 = b.i(n4);
            if (i4 == 1) {
                str = b.d(parcel, n4);
            } else if (i4 == 2) {
                iBinder = b.o(parcel, n4);
            } else if (i4 == 3) {
                z4 = b.j(parcel, n4);
            } else if (i4 != 4) {
                b.t(parcel, n4);
            } else {
                z5 = b.j(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new I(str, iBinder, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new I[i4];
    }
}
