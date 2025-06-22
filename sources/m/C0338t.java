package M;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: M.t  reason: case insensitive filesystem */
public class C0338t extends a {
    @NonNull
    public static final Parcelable.Creator<C0338t> CREATOR = new C0342x();

    /* renamed from: a  reason: collision with root package name */
    private final int f593a;

    /* renamed from: b  reason: collision with root package name */
    private List f594b;

    public C0338t(int i4, List list) {
        this.f593a = i4;
        this.f594b = list;
    }

    public final int c() {
        return this.f593a;
    }

    public final List g() {
        return this.f594b;
    }

    public final void h(C0332m mVar) {
        if (this.f594b == null) {
            this.f594b = new ArrayList();
        }
        this.f594b.add(mVar);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f593a);
        c.q(parcel, 2, this.f594b, false);
        c.b(parcel, a5);
    }
}
