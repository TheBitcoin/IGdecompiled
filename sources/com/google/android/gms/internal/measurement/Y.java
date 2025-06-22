package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class Y implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1660a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1661b;

    protected Y(IBinder iBinder, String str) {
        this.f1660a = iBinder;
        this.f1661b = str;
    }

    public IBinder asBinder() {
        return this.f1660a;
    }

    /* access modifiers changed from: protected */
    public final Parcel h() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1661b);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final Parcel i(int i4, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.f1660a.transact(i4, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e5) {
            throw e5;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void k(int i4, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1660a.transact(i4, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
