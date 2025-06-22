package M;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: M.x  reason: case insensitive filesystem */
public final class C0342x implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        ArrayList arrayList = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                i4 = b.p(parcel, n4);
            } else if (i5 != 2) {
                b.t(parcel, n4);
            } else {
                arrayList = b.g(parcel, n4, C0332m.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new C0338t(i4, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0338t[i4];
    }
}
