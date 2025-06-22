package M;

import android.os.IBinder;
import android.os.Parcel;

final class U implements C0331l {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f447a;

    U(IBinder iBinder) {
        this.f447a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f447a;
    }

    public final void f0(C0330k kVar, C0325f fVar) {
        IBinder iBinder;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            if (kVar != null) {
                iBinder = kVar.asBinder();
            } else {
                iBinder = null;
            }
            obtain.writeStrongBinder(iBinder);
            if (fVar != null) {
                obtain.writeInt(1);
                k0.a(fVar, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f447a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }
}
