package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: i  reason: collision with root package name */
    public static final String f678i = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public static abstract class C0015a extends Binder implements a {
        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;

        /* renamed from: android.support.v4.app.a$a$a  reason: collision with other inner class name */
        private static class C0016a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f679a;

            C0016a(IBinder iBinder) {
                this.f679a = iBinder;
            }

            public IBinder asBinder() {
                return this.f679a;
            }

            public void cancel(String str, int i4, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f678i);
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    this.f679a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void cancelAll(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f678i);
                    obtain.writeString(str);
                    this.f679a.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void notify(String str, int i4, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.f678i);
                    obtain.writeString(str);
                    obtain.writeInt(i4);
                    obtain.writeString(str2);
                    b.d(obtain, notification, 0);
                    this.f679a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0015a() {
            attachInterface(this, a.f678i);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a.f678i);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0016a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            String str = a.f678i;
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i4 == 1) {
                notify(parcel.readString(), parcel.readInt(), parcel.readString(), (Notification) b.c(parcel, Notification.CREATOR));
            } else if (i4 == 2) {
                cancel(parcel.readString(), parcel.readInt(), parcel.readString());
            } else if (i4 != 3) {
                return super.onTransact(i4, parcel, parcel2, i5);
            } else {
                cancelAll(parcel.readString());
            }
            return true;
        }
    }

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

    void cancel(String str, int i4, String str2);

    void cancelAll(String str);

    void notify(String str, int i4, String str2, Notification notification);
}
