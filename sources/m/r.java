package M;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class r extends a {
    @NonNull
    public static final Parcelable.Creator<r> CREATOR = new a0();

    /* renamed from: a  reason: collision with root package name */
    private final int f583a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f584b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f585c;

    /* renamed from: d  reason: collision with root package name */
    private final int f586d;

    /* renamed from: e  reason: collision with root package name */
    private final int f587e;

    public r(int i4, boolean z4, boolean z5, int i5, int i6) {
        this.f583a = i4;
        this.f584b = z4;
        this.f585c = z5;
        this.f586d = i5;
        this.f587e = i6;
    }

    public int c() {
        return this.f586d;
    }

    public int g() {
        return this.f587e;
    }

    public boolean h() {
        return this.f584b;
    }

    public boolean j() {
        return this.f585c;
    }

    public int k() {
        return this.f583a;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, k());
        c.c(parcel, 2, h());
        c.c(parcel, 3, j());
        c.i(parcel, 4, c());
        c.i(parcel, 5, g());
        c.b(parcel, a5);
    }
}
