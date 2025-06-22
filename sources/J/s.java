package J;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class s implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        long j4 = -1;
        int i4 = 0;
        String str = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                str = b.d(parcel, n4);
            } else if (i5 == 2) {
                i4 = b.p(parcel, n4);
            } else if (i5 != 3) {
                b.t(parcel, n4);
            } else {
                j4 = b.q(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new C0305d(str, i4, j4);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0305d[i4];
    }
}
