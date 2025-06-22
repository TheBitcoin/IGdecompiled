package W;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f643a;

    /* renamed from: b  reason: collision with root package name */
    private final String f644b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    protected a(IBinder iBinder, String str) {
        this.f643a = iBinder;
    }

    public final IBinder asBinder() {
        return this.f643a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f644b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i4, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f643a.transact(i4, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }
}
