package d;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: d.a  reason: case insensitive filesystem */
public interface C0908a extends IInterface {

    /* renamed from: j  reason: collision with root package name */
    public static final String f3350j = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* renamed from: d.a$b */
    public static class b {
        /* access modifiers changed from: private */
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static void d(Parcel parcel, Parcelable parcelable, int i4) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i4);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void j0(int i4, Bundle bundle);

    /* renamed from: d.a$a  reason: collision with other inner class name */
    public static abstract class C0026a extends Binder implements C0908a {

        /* renamed from: d.a$a$a  reason: collision with other inner class name */
        private static class C0027a implements C0908a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f3351a;

            C0027a(IBinder iBinder) {
                this.f3351a = iBinder;
            }

            public IBinder asBinder() {
                return this.f3351a;
            }

            public void j0(int i4, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C0908a.f3350j);
                    obtain.writeInt(i4);
                    b.d(obtain, bundle, 0);
                    this.f3351a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0026a() {
            attachInterface(this, C0908a.f3350j);
        }

        public static C0908a h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(C0908a.f3350j);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0908a)) {
                return new C0027a(iBinder);
            }
            return (C0908a) queryLocalInterface;
        }

        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) {
            String str = C0908a.f3350j;
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i4 != 1) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                j0(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }
    }
}
