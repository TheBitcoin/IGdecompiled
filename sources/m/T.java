package M;

import android.os.Bundle;
import android.os.Parcel;
import b0.b;
import b0.c;

public abstract class T extends b implements C0330k {
    public T() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 == 1) {
            c.b(parcel);
            P(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i4 == 2) {
            c.b(parcel);
            D(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
        } else if (i4 != 3) {
            return false;
        } else {
            c.b(parcel);
            E(parcel.readInt(), parcel.readStrongBinder(), (h0) c.a(parcel, h0.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
