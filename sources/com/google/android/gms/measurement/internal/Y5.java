package com.google.android.gms.measurement.internal;

import M.C0335p;
import N.a;
import N.c;
import android.os.Parcel;
import android.os.Parcelable;

public final class Y5 extends a {
    public static final Parcelable.Creator<Y5> CREATOR = new b6();

    /* renamed from: a  reason: collision with root package name */
    private final int f2823a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2824b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2825c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f2826d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2827e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2828f;

    /* renamed from: g  reason: collision with root package name */
    public final Double f2829g;

    Y5(a6 a6Var) {
        this(a6Var.f2856c, a6Var.f2857d, a6Var.f2858e, a6Var.f2855b);
    }

    public final Object c() {
        Long l4 = this.f2826d;
        if (l4 != null) {
            return l4;
        }
        Double d5 = this.f2829g;
        if (d5 != null) {
            return d5;
        }
        String str = this.f2827e;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int a5 = c.a(parcel);
        c.i(parcel, 1, this.f2823a);
        c.n(parcel, 2, this.f2824b, false);
        c.k(parcel, 3, this.f2825c);
        c.l(parcel, 4, this.f2826d, false);
        c.g(parcel, 5, (Float) null, false);
        c.n(parcel, 6, this.f2827e, false);
        c.n(parcel, 7, this.f2828f, false);
        c.f(parcel, 8, this.f2829g, false);
        c.b(parcel, a5);
    }

    Y5(String str, long j4, Object obj, String str2) {
        C0335p.f(str);
        this.f2823a = 2;
        this.f2824b = str;
        this.f2825c = j4;
        this.f2828f = str2;
        if (obj == null) {
            this.f2826d = null;
            this.f2829g = null;
            this.f2827e = null;
        } else if (obj instanceof Long) {
            this.f2826d = (Long) obj;
            this.f2829g = null;
            this.f2827e = null;
        } else if (obj instanceof String) {
            this.f2826d = null;
            this.f2829g = null;
            this.f2827e = (String) obj;
        } else if (obj instanceof Double) {
            this.f2826d = null;
            this.f2829g = (Double) obj;
            this.f2827e = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    Y5(int i4, String str, long j4, Long l4, Float f4, String str2, String str3, Double d5) {
        this.f2823a = i4;
        this.f2824b = str;
        this.f2825c = j4;
        this.f2826d = l4;
        if (i4 == 1) {
            this.f2829g = f4 != null ? Double.valueOf(f4.doubleValue()) : null;
        } else {
            this.f2829g = d5;
        }
        this.f2827e = str2;
        this.f2828f = str3;
    }
}
