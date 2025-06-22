package f0;

import N.a;
import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: f0.b  reason: case insensitive filesystem */
public final class C0913b extends a {
    public static final Parcelable.Creator<C0913b> CREATOR = new C0914c();

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f3367a;

    public C0913b(Bundle bundle) {
        this.f3367a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.e(parcel, 1, this.f3367a, false);
        c.b(parcel, a5);
    }
}
