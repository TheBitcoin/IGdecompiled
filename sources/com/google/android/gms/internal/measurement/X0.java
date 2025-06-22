package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class X0 extends Y implements V0 {
    X0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int A() {
        Parcel i4 = i(2, h());
        int readInt = i4.readInt();
        i4.recycle();
        return readInt;
    }

    public final void V(String str, String str2, Bundle bundle, long j4) {
        Parcel h4 = h();
        h4.writeString(str);
        h4.writeString(str2);
        C0507a0.d(h4, bundle);
        h4.writeLong(j4);
        k(1, h4);
    }
}
