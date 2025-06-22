package i0;

import N.b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class c implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Intent intent = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i6 = b.i(n4);
            if (i6 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i6 == 2) {
                i5 = b.p(parcel, n4);
            } else if (i6 != 3) {
                b.t(parcel, n4);
            } else {
                intent = (Intent) b.c(parcel, n4, Intent.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new b(i4, i5, intent);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new b[i4];
    }
}
