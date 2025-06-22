package J;

import M.v0;
import N.a;
import N.c;
import U.b;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

public final class I extends a {
    public static final Parcelable.Creator<I> CREATOR = new J();

    /* renamed from: a  reason: collision with root package name */
    private final String f310a;

    /* renamed from: b  reason: collision with root package name */
    private final z f311b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f312c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f313d;

    I(String str, z zVar, boolean z4, boolean z5) {
        this.f310a = str;
        this.f311b = zVar;
        this.f312c = z4;
        this.f313d = z5;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f310a;
        int a5 = c.a(parcel);
        c.n(parcel, 1, str, false);
        z zVar = this.f311b;
        if (zVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zVar = null;
        }
        c.h(parcel, 2, zVar, false);
        c.c(parcel, 3, this.f312c);
        c.c(parcel, 4, this.f313d);
        c.b(parcel, a5);
    }

    I(String str, IBinder iBinder, boolean z4, boolean z5) {
        byte[] bArr;
        this.f310a = str;
        A a5 = null;
        if (iBinder != null) {
            try {
                U.a C4 = v0.i(iBinder).C();
                if (C4 == null) {
                    bArr = null;
                } else {
                    bArr = (byte[]) b.k(C4);
                }
                if (bArr != null) {
                    a5 = new A(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e5) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e5);
            }
        }
        this.f311b = a5;
        this.f312c = z4;
        this.f313d = z5;
    }
}
