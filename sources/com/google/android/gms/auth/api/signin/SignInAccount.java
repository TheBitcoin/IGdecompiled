package com.google.android.gms.auth.api.signin;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class SignInAccount extends a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    final String f1230a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInAccount f1231b;

    /* renamed from: c  reason: collision with root package name */
    final String f1232c;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f1231b = googleSignInAccount;
        this.f1230a = C0335p.g(str, "8.3 and 8.4 SDKs require non-null email");
        this.f1232c = C0335p.g(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount c() {
        return this.f1231b;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f1230a;
        int a5 = c.a(parcel);
        c.n(parcel, 4, str, false);
        c.m(parcel, 7, this.f1231b, i4, false);
        c.n(parcel, 8, this.f1232c, false);
        c.b(parcel, a5);
    }
}
