package com.google.android.gms.dynamite;

import U.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b0.a;
import b0.c;

public final class m extends a implements IInterface {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int k() {
        Parcel h4 = h(6, i());
        int readInt = h4.readInt();
        h4.recycle();
        return readInt;
    }

    public final int l0(U.a aVar, String str, boolean z4) {
        Parcel i4 = i();
        c.d(i4, aVar);
        i4.writeString(str);
        i4.writeInt(z4 ? 1 : 0);
        Parcel h4 = h(3, i4);
        int readInt = h4.readInt();
        h4.recycle();
        return readInt;
    }

    public final int m0(U.a aVar, String str, boolean z4) {
        Parcel i4 = i();
        c.d(i4, aVar);
        i4.writeString(str);
        i4.writeInt(z4 ? 1 : 0);
        Parcel h4 = h(5, i4);
        int readInt = h4.readInt();
        h4.recycle();
        return readInt;
    }

    public final U.a n0(U.a aVar, String str, int i4) {
        Parcel i5 = i();
        c.d(i5, aVar);
        i5.writeString(str);
        i5.writeInt(i4);
        Parcel h4 = h(2, i5);
        U.a i6 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i6;
    }

    public final U.a o0(U.a aVar, String str, int i4, U.a aVar2) {
        Parcel i5 = i();
        c.d(i5, aVar);
        i5.writeString(str);
        i5.writeInt(i4);
        c.d(i5, aVar2);
        Parcel h4 = h(8, i5);
        U.a i6 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i6;
    }

    public final U.a p0(U.a aVar, String str, int i4) {
        Parcel i5 = i();
        c.d(i5, aVar);
        i5.writeString(str);
        i5.writeInt(i4);
        Parcel h4 = h(4, i5);
        U.a i6 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i6;
    }

    public final U.a q0(U.a aVar, String str, boolean z4, long j4) {
        Parcel i4 = i();
        c.d(i4, aVar);
        i4.writeString(str);
        i4.writeInt(z4 ? 1 : 0);
        i4.writeLong(j4);
        Parcel h4 = h(7, i4);
        U.a i5 = a.C0004a.i(h4.readStrongBinder());
        h4.recycle();
        return i5;
    }
}
