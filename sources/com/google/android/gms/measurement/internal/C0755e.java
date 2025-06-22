package com.google.android.gms.measurement.internal;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.measurement.internal.e  reason: case insensitive filesystem */
public final class C0755e extends a {
    public static final Parcelable.Creator<C0755e> CREATOR = new C0748d();

    /* renamed from: a  reason: collision with root package name */
    public String f2953a;

    /* renamed from: b  reason: collision with root package name */
    public String f2954b;

    /* renamed from: c  reason: collision with root package name */
    public Y5 f2955c;

    /* renamed from: d  reason: collision with root package name */
    public long f2956d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2957e;

    /* renamed from: f  reason: collision with root package name */
    public String f2958f;

    /* renamed from: g  reason: collision with root package name */
    public E f2959g;

    /* renamed from: h  reason: collision with root package name */
    public long f2960h;

    /* renamed from: i  reason: collision with root package name */
    public E f2961i;

    /* renamed from: j  reason: collision with root package name */
    public long f2962j;

    /* renamed from: k  reason: collision with root package name */
    public E f2963k;

    C0755e(C0755e eVar) {
        C0335p.l(eVar);
        this.f2953a = eVar.f2953a;
        this.f2954b = eVar.f2954b;
        this.f2955c = eVar.f2955c;
        this.f2956d = eVar.f2956d;
        this.f2957e = eVar.f2957e;
        this.f2958f = eVar.f2958f;
        this.f2959g = eVar.f2959g;
        this.f2960h = eVar.f2960h;
        this.f2961i = eVar.f2961i;
        this.f2962j = eVar.f2962j;
        this.f2963k = eVar.f2963k;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.n(parcel, 2, this.f2953a, false);
        c.n(parcel, 3, this.f2954b, false);
        c.m(parcel, 4, this.f2955c, i4, false);
        c.k(parcel, 5, this.f2956d);
        c.c(parcel, 6, this.f2957e);
        c.n(parcel, 7, this.f2958f, false);
        c.m(parcel, 8, this.f2959g, i4, false);
        c.k(parcel, 9, this.f2960h);
        c.m(parcel, 10, this.f2961i, i4, false);
        c.k(parcel, 11, this.f2962j);
        c.m(parcel, 12, this.f2963k, i4, false);
        c.b(parcel, a5);
    }

    C0755e(String str, String str2, Y5 y5, long j4, boolean z4, String str3, E e5, long j5, E e6, long j6, E e7) {
        this.f2953a = str;
        this.f2954b = str2;
        this.f2955c = y5;
        this.f2956d = j4;
        this.f2957e = z4;
        this.f2958f = str3;
        this.f2959g = e5;
        this.f2960h = j5;
        this.f2961i = e6;
        this.f2962j = j6;
        this.f2963k = e7;
    }
}
