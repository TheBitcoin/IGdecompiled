package i0;

import K.j;
import N.a;
import N.c;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

public final class b extends a implements j {
    public static final Parcelable.Creator<b> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f3421a;

    /* renamed from: b  reason: collision with root package name */
    private int f3422b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f3423c;

    b(int i4, int i5, Intent intent) {
        this.f3421a = i4;
        this.f3422b = i5;
        this.f3423c = intent;
    }

    public final Status getStatus() {
        if (this.f3422b == 0) {
            return Status.f1249f;
        }
        return Status.f1253j;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f3421a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.i(parcel, 2, this.f3422b);
        c.m(parcel, 3, this.f3423c, i4, false);
        c.b(parcel, a5);
    }
}
