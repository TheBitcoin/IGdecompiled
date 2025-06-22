package J;

import M.C0333n;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.RewardPlus;

/* renamed from: J.d  reason: case insensitive filesystem */
public class C0305d extends a {
    @NonNull
    public static final Parcelable.Creator<C0305d> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final String f330a;

    /* renamed from: b  reason: collision with root package name */
    private final int f331b;

    /* renamed from: c  reason: collision with root package name */
    private final long f332c;

    public C0305d(String str, int i4, long j4) {
        this.f330a = str;
        this.f331b = i4;
        this.f332c = j4;
    }

    public String c() {
        return this.f330a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0305d) {
            C0305d dVar = (C0305d) obj;
            if (((c() == null || !c().equals(dVar.c())) && (c() != null || dVar.c() != null)) || g() != dVar.g()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public long g() {
        long j4 = this.f332c;
        if (j4 == -1) {
            return (long) this.f331b;
        }
        return j4;
    }

    public final int hashCode() {
        return C0333n.b(c(), Long.valueOf(g()));
    }

    public final String toString() {
        C0333n.a c5 = C0333n.c(this);
        c5.a(RewardPlus.NAME, c());
        c5.a("version", Long.valueOf(g()));
        return c5.toString();
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.n(parcel, 1, c(), false);
        c.i(parcel, 2, this.f331b);
        c.k(parcel, 3, g());
        c.b(parcel, a5);
    }

    public C0305d(String str, long j4) {
        this.f330a = str;
        this.f332c = j4;
        this.f331b = -1;
    }
}
