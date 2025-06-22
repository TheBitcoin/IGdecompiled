package com.google.android.gms.internal.measurement;

import N.a;
import N.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.measurement.c1  reason: case insensitive filesystem */
public final class C0526c1 extends a {
    public static final Parcelable.Creator<C0526c1> CREATOR = new C0517b1();

    /* renamed from: a  reason: collision with root package name */
    public final long f1765a;

    /* renamed from: b  reason: collision with root package name */
    public final long f1766b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1767c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1768d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1769e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1770f;

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f1771g;

    /* renamed from: h  reason: collision with root package name */
    public final String f1772h;

    public C0526c1(long j4, long j5, boolean z4, String str, String str2, String str3, Bundle bundle, String str4) {
        this.f1765a = j4;
        this.f1766b = j5;
        this.f1767c = z4;
        this.f1768d = str;
        this.f1769e = str2;
        this.f1770f = str3;
        this.f1771g = bundle;
        this.f1772h = str4;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.k(parcel, 1, this.f1765a);
        c.k(parcel, 2, this.f1766b);
        c.c(parcel, 3, this.f1767c);
        c.n(parcel, 4, this.f1768d, false);
        c.n(parcel, 5, this.f1769e, false);
        c.n(parcel, 6, this.f1770f, false);
        c.e(parcel, 7, this.f1771g, false);
        c.n(parcel, 8, this.f1772h, false);
        c.b(parcel, a5);
    }
}
