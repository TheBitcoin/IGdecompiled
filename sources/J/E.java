package J;

import N.a;
import N.c;
import U.a;
import U.b;
import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class E extends a {
    public static final Parcelable.Creator<E> CREATOR = new F();

    /* renamed from: a  reason: collision with root package name */
    private final String f300a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f301b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f302c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f303d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f304e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f305f;

    E(String str, boolean z4, boolean z5, IBinder iBinder, boolean z6, boolean z7) {
        this.f300a = str;
        this.f301b = z4;
        this.f302c = z5;
        this.f303d = (Context) b.k(a.C0004a.i(iBinder));
        this.f304e = z6;
        this.f305f = z7;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [U.a, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f300a;
        int a5 = c.a(parcel);
        c.n(parcel, 1, str, false);
        c.c(parcel, 2, this.f301b);
        c.c(parcel, 3, this.f302c);
        c.h(parcel, 4, b.l0(this.f303d), false);
        c.c(parcel, 5, this.f304e);
        c.c(parcel, 6, this.f305f);
        c.b(parcel, a5);
    }
}
