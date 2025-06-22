package i0;

import M.M;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class j extends a {
    public static final Parcelable.Creator<j> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    final int f3426a;

    /* renamed from: b  reason: collision with root package name */
    final M f3427b;

    j(int i4, M m4) {
        this.f3426a = i4;
        this.f3427b = m4;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f3426a);
        c.m(parcel, 2, this.f3427b, i4, false);
        c.b(parcel, a5);
    }
}
