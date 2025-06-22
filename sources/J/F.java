package J;

import N.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class F implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            switch (b.i(n4)) {
                case 1:
                    str = b.d(parcel, n4);
                    break;
                case 2:
                    z4 = b.j(parcel, n4);
                    break;
                case 3:
                    z5 = b.j(parcel, n4);
                    break;
                case 4:
                    iBinder = b.o(parcel, n4);
                    break;
                case 5:
                    z6 = b.j(parcel, n4);
                    break;
                case 6:
                    z7 = b.j(parcel, n4);
                    break;
                default:
                    b.t(parcel, n4);
                    break;
            }
        }
        b.h(parcel, u4);
        return new E(str, z4, z5, iBinder, z6, z7);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new E[i4];
    }
}
