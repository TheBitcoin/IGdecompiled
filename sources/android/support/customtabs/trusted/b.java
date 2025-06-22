package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface b extends IInterface {

    /* renamed from: h  reason: collision with root package name */
    public static final String f676h = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    public static abstract class a extends Binder implements b {
        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_extraCommand = 9;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        /* renamed from: android.support.customtabs.trusted.b$a$a  reason: collision with other inner class name */
        private static class C0013a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f677a;

            C0013a(IBinder iBinder) {
                this.f677a = iBinder;
            }

            public Bundle areNotificationsEnabled(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    C0014b.d(obtain, bundle, 0);
                    this.f677a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0014b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f677a;
            }

            public void cancelNotification(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    C0014b.d(obtain, bundle, 0);
                    this.f677a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    obtain.writeString(str);
                    C0014b.d(obtain, bundle, 0);
                    obtain.writeStrongBinder(iBinder);
                    this.f677a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0014b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getActiveNotifications() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    this.f677a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0014b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSmallIconBitmap() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    this.f677a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0014b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSmallIconId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    this.f677a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle notifyNotificationWithChannel(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f676h);
                    C0014b.d(obtain, bundle, 0);
                    this.f677a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) C0014b.c(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, b.f676h);
        }

        public static b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b.f676h);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0013a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            String str = b.f676h;
            if (i4 >= 1 && i4 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i4 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i4) {
                case 2:
                    Bundle notifyNotificationWithChannel = notifyNotificationWithChannel((Bundle) C0014b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0014b.d(parcel2, notifyNotificationWithChannel, 1);
                    break;
                case 3:
                    cancelNotification((Bundle) C0014b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 4:
                    int smallIconId = getSmallIconId();
                    parcel2.writeNoException();
                    parcel2.writeInt(smallIconId);
                    break;
                case 5:
                    Bundle activeNotifications = getActiveNotifications();
                    parcel2.writeNoException();
                    C0014b.d(parcel2, activeNotifications, 1);
                    break;
                case 6:
                    Bundle areNotificationsEnabled = areNotificationsEnabled((Bundle) C0014b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    C0014b.d(parcel2, areNotificationsEnabled, 1);
                    break;
                case 7:
                    Bundle smallIconBitmap = getSmallIconBitmap();
                    parcel2.writeNoException();
                    C0014b.d(parcel2, smallIconBitmap, 1);
                    break;
                case 9:
                    Bundle extraCommand = extraCommand(parcel.readString(), (Bundle) C0014b.c(parcel, Bundle.CREATOR), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    C0014b.d(parcel2, extraCommand, 1);
                    break;
                default:
                    return super.onTransact(i4, parcel, parcel2, i5);
            }
            return true;
        }
    }

    /* renamed from: android.support.customtabs.trusted.b$b  reason: collision with other inner class name */
    public static class C0014b {
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

    Bundle areNotificationsEnabled(Bundle bundle);

    void cancelNotification(Bundle bundle);

    Bundle extraCommand(String str, Bundle bundle, IBinder iBinder);

    Bundle getActiveNotifications();

    Bundle getSmallIconBitmap();

    int getSmallIconId();

    Bundle notifyNotificationWithChannel(Bundle bundle);
}
