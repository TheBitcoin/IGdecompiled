package M;

import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: M.m  reason: case insensitive filesystem */
public class C0332m extends a {
    @NonNull
    public static final Parcelable.Creator<C0332m> CREATOR = new H();

    /* renamed from: a  reason: collision with root package name */
    private final int f552a;

    /* renamed from: b  reason: collision with root package name */
    private final int f553b;

    /* renamed from: c  reason: collision with root package name */
    private final int f554c;

    /* renamed from: d  reason: collision with root package name */
    private final long f555d;

    /* renamed from: e  reason: collision with root package name */
    private final long f556e;

    /* renamed from: f  reason: collision with root package name */
    private final String f557f;

    /* renamed from: g  reason: collision with root package name */
    private final String f558g;

    /* renamed from: h  reason: collision with root package name */
    private final int f559h;

    /* renamed from: i  reason: collision with root package name */
    private final int f560i;

    public C0332m(int i4, int i5, int i6, long j4, long j5, String str, String str2, int i7, int i8) {
        this.f552a = i4;
        this.f553b = i5;
        this.f554c = i6;
        this.f555d = j4;
        this.f556e = j5;
        this.f557f = str;
        this.f558g = str2;
        this.f559h = i7;
        this.f560i = i8;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f552a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.i(parcel, 2, this.f553b);
        c.i(parcel, 3, this.f554c);
        c.k(parcel, 4, this.f555d);
        c.k(parcel, 5, this.f556e);
        c.n(parcel, 6, this.f557f, false);
        c.n(parcel, 7, this.f558g, false);
        c.i(parcel, 8, this.f559h);
        c.i(parcel, 9, this.f560i);
        c.b(parcel, a5);
    }
}
