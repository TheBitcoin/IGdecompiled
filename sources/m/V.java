package M;

import J.E;
import J.G;
import J.I;
import android.os.IBinder;
import android.os.Parcel;
import b0.a;
import b0.c;

public final class V extends a implements X {
    V(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final G O(E e5) {
        Parcel i4 = i();
        c.c(i4, e5);
        Parcel h4 = h(8, i4);
        G g4 = (G) c.a(h4, G.CREATOR);
        h4.recycle();
        return g4;
    }

    public final boolean R(I i4, U.a aVar) {
        Parcel i5 = i();
        c.c(i5, i4);
        c.d(i5, aVar);
        Parcel h4 = h(5, i5);
        boolean e5 = c.e(h4);
        h4.recycle();
        return e5;
    }

    public final boolean d() {
        Parcel h4 = h(7, i());
        boolean e5 = c.e(h4);
        h4.recycle();
        return e5;
    }

    public final G p(E e5) {
        Parcel i4 = i();
        c.c(i4, e5);
        Parcel h4 = h(6, i4);
        G g4 = (G) c.a(h4, G.CREATOR);
        h4.recycle();
        return g4;
    }
}
