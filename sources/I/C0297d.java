package I;

import N.b;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: I.d  reason: case insensitive filesystem */
public final class C0297d implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            if (b.i(n4) != 1) {
                b.t(parcel, n4);
            } else {
                intent = (Intent) b.c(parcel, n4, Intent.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new C0294a(intent);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0294a[i4];
    }
}
