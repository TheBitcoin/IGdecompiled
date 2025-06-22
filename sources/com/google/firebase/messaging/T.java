package com.google.firebase.messaging;

import N.b;
import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class T implements Parcelable.Creator {
    static void c(S s4, Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.e(parcel, 2, s4.f11265a, false);
        c.b(parcel, a5);
    }

    /* renamed from: a */
    public S createFromParcel(Parcel parcel) {
        int u4 = b.u(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < u4) {
            int n4 = b.n(parcel);
            if (b.i(n4) != 2) {
                b.t(parcel, n4);
            } else {
                bundle = b.a(parcel, n4);
            }
        }
        b.h(parcel, u4);
        return new S(bundle);
    }

    /* renamed from: b */
    public S[] newArray(int i4) {
        return new S[i4];
    }
}
