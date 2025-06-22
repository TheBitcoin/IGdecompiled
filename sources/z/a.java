package Z;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f654a;

    /* renamed from: b  reason: collision with root package name */
    private final String f655b;

    protected a(IBinder iBinder, String str) {
        this.f654a = iBinder;
        this.f655b = str;
    }

    public final IBinder asBinder() {
        return this.f654a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f655b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void i(int i4, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f654a.transact(i4, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i4, Parcel parcel) {
        try {
            this.f654a.transact(1, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
