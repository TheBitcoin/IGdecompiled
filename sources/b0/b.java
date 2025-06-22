package b0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements IInterface {
    protected b(String str) {
        attachInterface(this, str);
    }

    /* access modifiers changed from: protected */
    public boolean h(int i4, Parcel parcel, Parcel parcel2, int i5) {
        return false;
    }

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
