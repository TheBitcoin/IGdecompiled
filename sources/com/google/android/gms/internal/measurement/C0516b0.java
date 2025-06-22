package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.measurement.b0  reason: case insensitive filesystem */
public abstract class C0516b0 extends Binder implements IInterface {
    protected C0516b0(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract boolean h(int i4, Parcel parcel, Parcel parcel2, int i5);

    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        boolean z4;
        if (i4 > 16777215) {
            z4 = super.onTransact(i4, parcel, parcel2, i5);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z4 = false;
        }
        if (z4) {
            return true;
        }
        return h(i4, parcel, parcel2, i5);
    }
}
