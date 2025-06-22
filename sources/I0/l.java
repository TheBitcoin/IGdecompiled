package i0;

import J.C0303b;
import M.O;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    final int f3428a;

    /* renamed from: b  reason: collision with root package name */
    private final C0303b f3429b;

    /* renamed from: c  reason: collision with root package name */
    private final O f3430c;

    l(int i4, C0303b bVar, O o4) {
        this.f3428a = i4;
        this.f3429b = bVar;
        this.f3430c = o4;
    }

    public final C0303b c() {
        return this.f3429b;
    }

    public final O g() {
        return this.f3430c;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f3428a);
        c.m(parcel, 2, this.f3429b, i4, false);
        c.m(parcel, 3, this.f3430c, i4, false);
        c.b(parcel, a5);
    }
}
