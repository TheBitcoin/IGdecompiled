package i0;

import M.M;
import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class k implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        M m4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i5 != 2) {
                b.t(parcel, n4);
            } else {
                m4 = (M) b.c(parcel, n4, M.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new j(i4, m4);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new j[i4];
    }
}
