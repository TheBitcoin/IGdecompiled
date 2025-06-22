package M;

import J.C0303b;
import M.C0329j;
import N.a;
import N.c;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class O extends a {
    public static final Parcelable.Creator<O> CREATOR = new P();

    /* renamed from: a  reason: collision with root package name */
    final int f439a;

    /* renamed from: b  reason: collision with root package name */
    final IBinder f440b;

    /* renamed from: c  reason: collision with root package name */
    private final C0303b f441c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f442d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f443e;

    O(int i4, IBinder iBinder, C0303b bVar, boolean z4, boolean z5) {
        this.f439a = i4;
        this.f440b = iBinder;
        this.f441c = bVar;
        this.f442d = z4;
        this.f443e = z5;
    }

    public final C0303b c() {
        return this.f441c;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O)) {
            return false;
        }
        O o4 = (O) obj;
        if (!this.f441c.equals(o4.f441c) || !C0333n.a(g(), o4.g())) {
            return false;
        }
        return true;
    }

    public final C0329j g() {
        IBinder iBinder = this.f440b;
        if (iBinder == null) {
            return null;
        }
        return C0329j.a.i(iBinder);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f439a);
        c.h(parcel, 2, this.f440b, false);
        c.m(parcel, 3, this.f441c, i4, false);
        c.c(parcel, 4, this.f442d);
        c.c(parcel, 5, this.f443e);
        c.b(parcel, a5);
    }
}
