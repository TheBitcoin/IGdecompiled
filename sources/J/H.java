package J;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class H implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        boolean z4 = false;
        String str = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i6 = b.i(n4);
            if (i6 == 1) {
                z4 = b.j(parcel, n4);
            } else if (i6 == 2) {
                str = b.d(parcel, n4);
            } else if (i6 == 3) {
                i4 = b.p(parcel, n4);
            } else if (i6 != 4) {
                b.t(parcel, n4);
            } else {
                i5 = b.p(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new G(z4, str, i4, i5);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new G[i4];
    }
}
