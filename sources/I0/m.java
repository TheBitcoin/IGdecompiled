package i0;

import J.C0303b;
import M.O;
import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class m implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        C0303b bVar = null;
        O o4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i5 == 2) {
                bVar = (C0303b) b.c(parcel, n4, C0303b.CREATOR);
            } else if (i5 != 3) {
                b.t(parcel, n4);
            } else {
                o4 = (O) b.c(parcel, n4, O.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new l(i4, bVar, o4);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new l[i4];
    }
}
