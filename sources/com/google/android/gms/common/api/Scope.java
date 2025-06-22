package com.google.android.gms.common.api;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f1246a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1247b;

    Scope(int i4, String str) {
        C0335p.g(str, "scopeUri must not be null or empty");
        this.f1246a = i4;
        this.f1247b = str;
    }

    public String c() {
        return this.f1247b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1247b.equals(((Scope) obj).f1247b);
    }

    public int hashCode() {
        return this.f1247b.hashCode();
    }

    public String toString() {
        return this.f1247b;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f1246a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.n(parcel, 2, c(), false);
        c.b(parcel, a5);
    }

    public Scope(String str) {
        this(1, str);
    }
}
