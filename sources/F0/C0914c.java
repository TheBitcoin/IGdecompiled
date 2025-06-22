package f0;

import N.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f0.c  reason: case insensitive filesystem */
public final class C0914c implements Parcelable.Creator {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            if (b.i(n4) != 1) {
                b.t(parcel, n4);
            } else {
                bundle = b.a(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new C0913b(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0913b[i4];
    }
}
