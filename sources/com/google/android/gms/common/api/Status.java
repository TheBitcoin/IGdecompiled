package com.google.android.gms.common.api;

import J.C0303b;
import K.c;
import K.j;
import M.C0333n;
import N.a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Status extends a implements j, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final Status f1248e = new Status(-1);

    /* renamed from: f  reason: collision with root package name */
    public static final Status f1249f = new Status(0);

    /* renamed from: g  reason: collision with root package name */
    public static final Status f1250g = new Status(14);

    /* renamed from: h  reason: collision with root package name */
    public static final Status f1251h = new Status(8);

    /* renamed from: i  reason: collision with root package name */
    public static final Status f1252i = new Status(15);

    /* renamed from: j  reason: collision with root package name */
    public static final Status f1253j = new Status(16);

    /* renamed from: k  reason: collision with root package name */
    public static final Status f1254k = new Status(18);

    /* renamed from: l  reason: collision with root package name */
    public static final Status f1255l = new Status(17);

    /* renamed from: a  reason: collision with root package name */
    private final int f1256a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1257b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f1258c;

    /* renamed from: d  reason: collision with root package name */
    private final C0303b f1259d;

    Status(int i4, String str, PendingIntent pendingIntent, C0303b bVar) {
        this.f1256a = i4;
        this.f1257b = str;
        this.f1258c = pendingIntent;
        this.f1259d = bVar;
    }

    public C0303b c() {
        return this.f1259d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f1256a != status.f1256a || !C0333n.a(this.f1257b, status.f1257b) || !C0333n.a(this.f1258c, status.f1258c) || !C0333n.a(this.f1259d, status.f1259d)) {
            return false;
        }
        return true;
    }

    public int g() {
        return this.f1256a;
    }

    public Status getStatus() {
        return this;
    }

    public String h() {
        return this.f1257b;
    }

    public int hashCode() {
        return C0333n.b(Integer.valueOf(this.f1256a), this.f1257b, this.f1258c, this.f1259d);
    }

    public boolean j() {
        return this.f1258c != null;
    }

    public boolean k() {
        return this.f1256a <= 0;
    }

    public final String l() {
        String str = this.f1257b;
        if (str != null) {
            return str;
        }
        return c.a(this.f1256a);
    }

    public String toString() {
        C0333n.a c5 = C0333n.c(this);
        c5.a("statusCode", l());
        c5.a("resolution", this.f1258c);
        return c5.toString();
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int a5 = N.c.a(parcel);
        N.c.i(parcel, 1, g());
        N.c.n(parcel, 2, h(), false);
        N.c.m(parcel, 3, this.f1258c, i4, false);
        N.c.m(parcel, 4, c(), i4, false);
        N.c.b(parcel, a5);
    }

    public Status(int i4) {
        this(i4, (String) null);
    }

    public Status(C0303b bVar, String str) {
        this(bVar, str, 17);
    }

    public Status(int i4, String str) {
        this(i4, str, (PendingIntent) null);
    }

    public Status(C0303b bVar, String str, int i4) {
        this(i4, str, bVar.h(), bVar);
    }

    public Status(int i4, String str, PendingIntent pendingIntent) {
        this(i4, str, pendingIntent, (C0303b) null);
    }
}
