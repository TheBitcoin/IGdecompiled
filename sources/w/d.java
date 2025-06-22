package W;

import android.os.IBinder;
import android.os.Parcel;

public final class d extends a implements f {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String b() {
        Parcel i4 = i(1, h());
        String readString = i4.readString();
        i4.recycle();
        return readString;
    }

    public final boolean s(boolean z4) {
        Parcel h4 = h();
        c.a(h4, true);
        Parcel i4 = i(2, h4);
        boolean b5 = c.b(i4);
        i4.recycle();
        return b5;
    }
}
