package Y;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f650a;

    /* renamed from: b  reason: collision with root package name */
    private final String f651b;

    protected a(IBinder iBinder, String str) {
        this.f650a = iBinder;
        this.f651b = str;
    }

    public final IBinder asBinder() {
        return this.f650a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f651b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void i(int i4, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f650a.transact(i4, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
