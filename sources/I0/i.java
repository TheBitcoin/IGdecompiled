package i0;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class i implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        ArrayList arrayList = null;
        String str = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i4 = b.i(n4);
            if (i4 == 1) {
                arrayList = b.e(parcel, n4);
            } else if (i4 != 2) {
                b.t(parcel, n4);
            } else {
                str = b.d(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new h(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new h[i4];
    }
}
