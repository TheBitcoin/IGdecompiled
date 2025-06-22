package com.google.android.gms.measurement.internal;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class B5 extends a {
    public static final Parcelable.Creator<B5> CREATOR = new A5();

    /* renamed from: a  reason: collision with root package name */
    public final String f2332a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2333b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2334c;

    B5(String str, long j4, int i4) {
        this.f2332a = str;
        this.f2333b = j4;
        this.f2334c = i4;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.n(parcel, 1, this.f2332a, false);
        c.k(parcel, 2, this.f2333b);
        c.i(parcel, 3, this.f2334c);
        c.b(parcel, a5);
    }
}
