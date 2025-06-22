package M;

import J.C0305d;
import M.C0329j;
import N.a;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;

/* renamed from: M.f  reason: case insensitive filesystem */
public class C0325f extends a {
    @NonNull
    public static final Parcelable.Creator<C0325f> CREATOR = new k0();

    /* renamed from: o  reason: collision with root package name */
    static final Scope[] f513o = new Scope[0];

    /* renamed from: p  reason: collision with root package name */
    static final C0305d[] f514p = new C0305d[0];

    /* renamed from: a  reason: collision with root package name */
    final int f515a;

    /* renamed from: b  reason: collision with root package name */
    final int f516b;

    /* renamed from: c  reason: collision with root package name */
    final int f517c;

    /* renamed from: d  reason: collision with root package name */
    String f518d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f519e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f520f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f521g;

    /* renamed from: h  reason: collision with root package name */
    Account f522h;

    /* renamed from: i  reason: collision with root package name */
    C0305d[] f523i;

    /* renamed from: j  reason: collision with root package name */
    C0305d[] f524j;

    /* renamed from: k  reason: collision with root package name */
    final boolean f525k;

    /* renamed from: l  reason: collision with root package name */
    final int f526l;

    /* renamed from: m  reason: collision with root package name */
    boolean f527m;

    /* renamed from: n  reason: collision with root package name */
    private final String f528n;

    C0325f(int i4, int i5, int i6, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0305d[] dVarArr, C0305d[] dVarArr2, boolean z4, int i7, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f513o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        dVarArr = dVarArr == null ? f514p : dVarArr;
        dVarArr2 = dVarArr2 == null ? f514p : dVarArr2;
        this.f515a = i4;
        this.f516b = i5;
        this.f517c = i6;
        if ("com.google.android.gms".equals(str)) {
            this.f518d = "com.google.android.gms";
        } else {
            this.f518d = str;
        }
        if (i4 < 2) {
            this.f522h = iBinder != null ? C0320a.k(C0329j.a.i(iBinder)) : null;
        } else {
            this.f519e = iBinder;
            this.f522h = account;
        }
        this.f520f = scopeArr;
        this.f521g = bundle;
        this.f523i = dVarArr;
        this.f524j = dVarArr2;
        this.f525k = z4;
        this.f526l = i7;
        this.f527m = z5;
        this.f528n = str2;
    }

    public final String c() {
        return this.f528n;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        k0.a(this, parcel, i4);
    }
}
