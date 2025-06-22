package M;

import J.C0305d;
import N.a;
import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new i0();

    /* renamed from: a  reason: collision with root package name */
    Bundle f540a;

    /* renamed from: b  reason: collision with root package name */
    C0305d[] f541b;

    /* renamed from: c  reason: collision with root package name */
    int f542c;

    /* renamed from: d  reason: collision with root package name */
    C0324e f543d;

    h0(Bundle bundle, C0305d[] dVarArr, int i4, C0324e eVar) {
        this.f540a = bundle;
        this.f541b = dVarArr;
        this.f542c = i4;
        this.f543d = eVar;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.e(parcel, 1, this.f540a, false);
        c.p(parcel, 2, this.f541b, i4, false);
        c.i(parcel, 3, this.f542c);
        c.m(parcel, 4, this.f543d, i4, false);
        c.b(parcel, a5);
    }
}
