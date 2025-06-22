package M;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class a0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        int i4 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i7 = b.i(n4);
            if (i7 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i7 == 2) {
                z4 = b.j(parcel, n4);
            } else if (i7 == 3) {
                z5 = b.j(parcel, n4);
            } else if (i7 == 4) {
                i5 = b.p(parcel, n4);
            } else if (i7 != 5) {
                b.t(parcel, n4);
            } else {
                i6 = b.p(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new r(i4, z4, z5, i5, i6);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new r[i4];
    }
}
