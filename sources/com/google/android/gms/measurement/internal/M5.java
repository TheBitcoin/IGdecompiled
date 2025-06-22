package com.google.android.gms.measurement.internal;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class M5 extends a {
    public static final Parcelable.Creator<M5> CREATOR = new e6();

    /* renamed from: A  reason: collision with root package name */
    public final int f2625A;

    /* renamed from: B  reason: collision with root package name */
    public final String f2626B;

    /* renamed from: C  reason: collision with root package name */
    public final int f2627C;

    /* renamed from: D  reason: collision with root package name */
    public final long f2628D;

    /* renamed from: E  reason: collision with root package name */
    public final String f2629E;

    /* renamed from: F  reason: collision with root package name */
    public final String f2630F;

    /* renamed from: a  reason: collision with root package name */
    public final String f2631a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2632b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2633c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2634d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2635e;

    /* renamed from: f  reason: collision with root package name */
    public final long f2636f;

    /* renamed from: g  reason: collision with root package name */
    public final String f2637g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f2638h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2639i;

    /* renamed from: j  reason: collision with root package name */
    public final long f2640j;

    /* renamed from: k  reason: collision with root package name */
    public final String f2641k;

    /* renamed from: l  reason: collision with root package name */
    private final long f2642l;

    /* renamed from: m  reason: collision with root package name */
    public final long f2643m;

    /* renamed from: n  reason: collision with root package name */
    public final int f2644n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f2645o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f2646p;

    /* renamed from: q  reason: collision with root package name */
    public final String f2647q;

    /* renamed from: r  reason: collision with root package name */
    public final Boolean f2648r;

    /* renamed from: s  reason: collision with root package name */
    public final long f2649s;

    /* renamed from: t  reason: collision with root package name */
    public final List f2650t;

    /* renamed from: u  reason: collision with root package name */
    private final String f2651u;

    /* renamed from: v  reason: collision with root package name */
    public final String f2652v;

    /* renamed from: w  reason: collision with root package name */
    public final String f2653w;

    /* renamed from: x  reason: collision with root package name */
    public final String f2654x;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f2655y;

    /* renamed from: z  reason: collision with root package name */
    public final long f2656z;

    M5(String str, String str2, String str3, long j4, String str4, long j5, long j6, String str5, boolean z4, boolean z5, String str6, long j7, long j8, int i4, boolean z6, boolean z7, String str7, Boolean bool, long j9, List list, String str8, String str9, String str10, String str11, boolean z8, long j10, int i5, String str12, int i6, long j11, String str13, String str14) {
        C0335p.f(str);
        this.f2631a = str;
        this.f2632b = TextUtils.isEmpty(str2) ? null : str2;
        this.f2633c = str3;
        this.f2640j = j4;
        this.f2634d = str4;
        this.f2635e = j5;
        this.f2636f = j6;
        this.f2637g = str5;
        this.f2638h = z4;
        this.f2639i = z5;
        this.f2641k = str6;
        this.f2642l = j7;
        this.f2643m = j8;
        this.f2644n = i4;
        this.f2645o = z6;
        this.f2646p = z7;
        this.f2647q = str7;
        this.f2648r = bool;
        this.f2649s = j9;
        this.f2650t = list;
        this.f2651u = null;
        this.f2652v = str9;
        this.f2653w = str10;
        this.f2654x = str11;
        this.f2655y = z8;
        this.f2656z = j10;
        this.f2625A = i5;
        this.f2626B = str12;
        this.f2627C = i6;
        this.f2628D = j11;
        this.f2629E = str13;
        this.f2630F = str14;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.n(parcel, 2, this.f2631a, false);
        c.n(parcel, 3, this.f2632b, false);
        c.n(parcel, 4, this.f2633c, false);
        c.n(parcel, 5, this.f2634d, false);
        c.k(parcel, 6, this.f2635e);
        c.k(parcel, 7, this.f2636f);
        c.n(parcel, 8, this.f2637g, false);
        c.c(parcel, 9, this.f2638h);
        c.c(parcel, 10, this.f2639i);
        c.k(parcel, 11, this.f2640j);
        c.n(parcel, 12, this.f2641k, false);
        c.k(parcel, 13, this.f2642l);
        c.k(parcel, 14, this.f2643m);
        c.i(parcel, 15, this.f2644n);
        c.c(parcel, 16, this.f2645o);
        c.c(parcel, 18, this.f2646p);
        c.n(parcel, 19, this.f2647q, false);
        c.d(parcel, 21, this.f2648r, false);
        c.k(parcel, 22, this.f2649s);
        c.o(parcel, 23, this.f2650t, false);
        c.n(parcel, 24, this.f2651u, false);
        c.n(parcel, 25, this.f2652v, false);
        c.n(parcel, 26, this.f2653w, false);
        c.n(parcel, 27, this.f2654x, false);
        c.c(parcel, 28, this.f2655y);
        c.k(parcel, 29, this.f2656z);
        c.i(parcel, 30, this.f2625A);
        c.n(parcel, 31, this.f2626B, false);
        c.i(parcel, 32, this.f2627C);
        c.k(parcel, 34, this.f2628D);
        c.n(parcel, 35, this.f2629E, false);
        c.n(parcel, 36, this.f2630F, false);
        c.b(parcel, a5);
    }

    M5(String str, String str2, String str3, String str4, long j4, long j5, String str5, boolean z4, boolean z5, long j6, String str6, long j7, long j8, int i4, boolean z6, boolean z7, String str7, Boolean bool, long j9, List list, String str8, String str9, String str10, String str11, boolean z8, long j10, int i5, String str12, int i6, long j11, String str13, String str14) {
        this.f2631a = str;
        this.f2632b = str2;
        this.f2633c = str3;
        this.f2640j = j6;
        this.f2634d = str4;
        this.f2635e = j4;
        this.f2636f = j5;
        this.f2637g = str5;
        this.f2638h = z4;
        this.f2639i = z5;
        this.f2641k = str6;
        this.f2642l = j7;
        this.f2643m = j8;
        this.f2644n = i4;
        this.f2645o = z6;
        this.f2646p = z7;
        this.f2647q = str7;
        this.f2648r = bool;
        this.f2649s = j9;
        this.f2650t = list;
        this.f2651u = str8;
        this.f2652v = str9;
        this.f2653w = str10;
        this.f2654x = str11;
        this.f2655y = z8;
        this.f2656z = j10;
        this.f2625A = i5;
        this.f2626B = str12;
        this.f2627C = i6;
        this.f2628D = j11;
        this.f2629E = str13;
        this.f2630F = str14;
    }
}
