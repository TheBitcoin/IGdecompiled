package M;

import N.b;
import android.os.Parcel;
import android.os.Parcelable;

public final class H implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int u4 = b.u(parcel2);
        String str = null;
        String str2 = null;
        long j4 = 0;
        long j5 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = -1;
        while (parcel2.dataPosition() < u4) {
            int n4 = b.n(parcel2);
            switch (b.i(n4)) {
                case 1:
                    i4 = b.p(parcel2, n4);
                    break;
                case 2:
                    i5 = b.p(parcel2, n4);
                    break;
                case 3:
                    i6 = b.p(parcel2, n4);
                    break;
                case 4:
                    j4 = b.q(parcel2, n4);
                    break;
                case 5:
                    j5 = b.q(parcel2, n4);
                    break;
                case 6:
                    str = b.d(parcel2, n4);
                    break;
                case 7:
                    str2 = b.d(parcel2, n4);
                    break;
                case 8:
                    i7 = b.p(parcel2, n4);
                    break;
                case 9:
                    i8 = b.p(parcel2, n4);
                    break;
                default:
                    b.t(parcel2, n4);
                    break;
            }
        }
        b.h(parcel2, u4);
        return new C0332m(i4, i5, i6, j4, j5, str, str2, i7, i8);
    }

    public final /* synthetic */ Object[] newArray(int i4) {
        return new C0332m[i4];
    }
}
