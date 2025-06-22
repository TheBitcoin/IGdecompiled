package M;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: M.e  reason: case insensitive filesystem */
public class C0324e extends a {
    @NonNull
    public static final Parcelable.Creator<C0324e> CREATOR = new j0();

    /* renamed from: a  reason: collision with root package name */
    private final r f505a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f506b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f507c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f508d;

    /* renamed from: e  reason: collision with root package name */
    private final int f509e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f510f;

    public C0324e(r rVar, boolean z4, boolean z5, int[] iArr, int i4, int[] iArr2) {
        this.f505a = rVar;
        this.f506b = z4;
        this.f507c = z5;
        this.f508d = iArr;
        this.f509e = i4;
        this.f510f = iArr2;
    }

    public int c() {
        return this.f509e;
    }

    public int[] g() {
        return this.f508d;
    }

    public int[] h() {
        return this.f510f;
    }

    public boolean j() {
        return this.f506b;
    }

    public boolean k() {
        return this.f507c;
    }

    public final r l() {
        return this.f505a;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.m(parcel, 1, this.f505a, i4, false);
        c.c(parcel, 2, j());
        c.c(parcel, 3, k());
        c.j(parcel, 4, g(), false);
        c.i(parcel, 5, c());
        c.j(parcel, 6, h(), false);
        c.b(parcel, a5);
    }
}
