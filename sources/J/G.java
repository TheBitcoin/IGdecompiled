package J;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class G extends a {
    public static final Parcelable.Creator<G> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f306a;

    /* renamed from: b  reason: collision with root package name */
    private final String f307b;

    /* renamed from: c  reason: collision with root package name */
    private final int f308c;

    /* renamed from: d  reason: collision with root package name */
    private final int f309d;

    G(boolean z4, String str, int i4, int i5) {
        this.f306a = z4;
        this.f307b = str;
        this.f308c = O.a(i4) - 1;
        this.f309d = t.a(i5) - 1;
    }

    public final String c() {
        return this.f307b;
    }

    public final boolean g() {
        return this.f306a;
    }

    public final int h() {
        return t.a(this.f309d);
    }

    public final int j() {
        return O.a(this.f308c);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.c(parcel, 1, this.f306a);
        c.n(parcel, 2, this.f307b, false);
        c.i(parcel, 3, this.f308c);
        c.i(parcel, 4, this.f309d);
        c.b(parcel, a5);
    }
}
