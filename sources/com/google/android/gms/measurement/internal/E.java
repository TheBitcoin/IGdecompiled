package com.google.android.gms.measurement.internal;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import f0.C0915d;

public final class E extends a {
    public static final Parcelable.Creator<E> CREATOR = new C0915d();

    /* renamed from: a  reason: collision with root package name */
    public final String f2366a;

    /* renamed from: b  reason: collision with root package name */
    public final D f2367b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2368c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2369d;

    E(E e5, long j4) {
        C0335p.l(e5);
        this.f2366a = e5.f2366a;
        this.f2367b = e5.f2367b;
        this.f2368c = e5.f2368c;
        this.f2369d = j4;
    }

    public final String toString() {
        String str = this.f2368c;
        String str2 = this.f2366a;
        String valueOf = String.valueOf(this.f2367b);
        return "origin=" + str + ",name=" + str2 + ",params=" + valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.n(parcel, 2, this.f2366a, false);
        c.m(parcel, 3, this.f2367b, i4, false);
        c.n(parcel, 4, this.f2368c, false);
        c.k(parcel, 5, this.f2369d);
        c.b(parcel, a5);
    }

    public E(String str, D d5, String str2, long j4) {
        this.f2366a = str;
        this.f2367b = d5;
        this.f2368c = str2;
        this.f2369d = j4;
    }
}
