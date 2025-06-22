package com.google.android.gms.dynamite;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.a;
import b0.c;

public final class n extends a implements IInterface {
    n(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final U.a k(U.a aVar, String str, int i4, U.a aVar2) {
        Parcel i5 = i();
        c.d(i5, aVar);
        i5.writeString(str);
        i5.writeInt(i4);
        c.d(i5, aVar2);
        Parcel h4 = h(2, i5);
        U.a i6 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i6;
    }

    public final U.a l0(U.a aVar, String str, int i4, U.a aVar2) {
        Parcel i5 = i();
        c.d(i5, aVar);
        i5.writeString(str);
        i5.writeInt(i4);
        c.d(i5, aVar2);
        Parcel h4 = h(3, i5);
        U.a i6 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i6;
    }
}
