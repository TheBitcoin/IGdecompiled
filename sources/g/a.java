package G;

import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class a extends N.a {
    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f203a;

    /* renamed from: b  reason: collision with root package name */
    private int f204b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f205c;

    a(int i4, int i5, Bundle bundle) {
        this.f203a = i4;
        this.f204b = i5;
        this.f205c = bundle;
    }

    public int c() {
        return this.f204b;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f203a);
        c.i(parcel, 2, c());
        c.e(parcel, 3, this.f205c, false);
        c.b(parcel, a5);
    }
}
