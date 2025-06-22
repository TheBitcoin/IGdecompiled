package b0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1130a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1131b;

    protected a(IBinder iBinder, String str) {
        this.f1130a = iBinder;
        this.f1131b = str;
    }

    public final IBinder asBinder() {
        return this.f1130a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h(int i4, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1130a.transact(i4, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel i() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1131b);
        return obtain;
    }
}
