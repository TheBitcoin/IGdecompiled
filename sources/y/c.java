package Y;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class c extends Binder implements IInterface {
    protected c(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public abstract boolean h(int i4, Parcel parcel, Parcel parcel2, int i5);

    public final boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
        if (i4 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i4, parcel, parcel2, i5)) {
            return true;
        }
        return h(i4, parcel, parcel2, i5);
    }

    public final IBinder asBinder() {
        return this;
    }
}
