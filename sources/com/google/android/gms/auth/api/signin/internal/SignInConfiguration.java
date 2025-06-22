package com.google.android.gms.auth.api.signin.internal;

import G.b;
import G.w;
import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class SignInConfiguration extends a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final String f1235a;

    /* renamed from: b  reason: collision with root package name */
    private final GoogleSignInOptions f1236b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f1235a = C0335p.f(str);
        this.f1236b = googleSignInOptions;
    }

    public final GoogleSignInOptions c() {
        return this.f1236b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f1235a.equals(signInConfiguration.f1235a)) {
            GoogleSignInOptions googleSignInOptions = this.f1236b;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.f1236b;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (!googleSignInOptions.equals(googleSignInOptions2)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new b().a(this.f1235a).a(this.f1236b).b();
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        String str = this.f1235a;
        int a5 = c.a(parcel);
        c.n(parcel, 2, str, false);
        c.m(parcel, 5, this.f1236b, i4, false);
        c.b(parcel, a5);
    }
}
