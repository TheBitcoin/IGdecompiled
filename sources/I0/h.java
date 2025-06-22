package i0;

import K.j;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class h extends a implements j {
    public static final Parcelable.Creator<h> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final List f3424a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3425b;

    public h(List list, String str) {
        this.f3424a = list;
        this.f3425b = str;
    }

    public final Status getStatus() {
        if (this.f3425b != null) {
            return Status.f1249f;
        }
        return Status.f1253j;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        List list = this.f3424a;
        int a5 = c.a(parcel);
        c.o(parcel, 1, list, false);
        c.n(parcel, 2, this.f3425b, false);
        c.b(parcel, a5);
    }
}
