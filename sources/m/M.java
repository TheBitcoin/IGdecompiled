package M;

import N.a;
import N.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public final class M extends a {
    public static final Parcelable.Creator<M> CREATOR = new N();

    /* renamed from: a  reason: collision with root package name */
    final int f435a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f436b;

    /* renamed from: c  reason: collision with root package name */
    private final int f437c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f438d;

    M(int i4, Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this.f435a = i4;
        this.f436b = account;
        this.f437c = i5;
        this.f438d = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f435a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.m(parcel, 2, this.f436b, i4, false);
        c.i(parcel, 3, this.f437c);
        c.m(parcel, 4, this.f438d, i4, false);
        c.b(parcel, a5);
    }

    public M(Account account, int i4, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i4, googleSignInAccount);
    }
}
