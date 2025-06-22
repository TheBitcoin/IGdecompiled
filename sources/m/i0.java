package M;

import J.C0305d;
import N.b;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class i0 implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Bundle bundle = null;
        C0305d[] dVarArr = null;
        C0324e eVar = null;
        int i4 = 0;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            int i5 = b.i(n4);
            if (i5 == 1) {
                bundle = b.a(parcel, n4);
            } else if (i5 == 2) {
                dVarArr = (C0305d[]) b.f(parcel, n4, C0305d.CREATOR);
            } else if (i5 == 3) {
                i4 = b.p(parcel, n4);
            } else if (i5 != 4) {
                b.t(parcel, n4);
            } else {
                eVar = (C0324e) b.c(parcel, n4, C0324e.CREATOR);
            }
        }
        b.h(parcel, u4);
        return new h0(bundle, dVarArr, i4, eVar);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new h0[i4];
    }
}
