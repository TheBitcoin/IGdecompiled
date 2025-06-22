package com.google.android.gms.internal.measurement;

import android.net.Uri;
import l0.c;

/* renamed from: com.google.android.gms.internal.measurement.r3  reason: case insensitive filesystem */
public final class C0659r3 {

    /* renamed from: a  reason: collision with root package name */
    final String f2124a;

    /* renamed from: b  reason: collision with root package name */
    final Uri f2125b;

    /* renamed from: c  reason: collision with root package name */
    final String f2126c;

    /* renamed from: d  reason: collision with root package name */
    final String f2127d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f2128e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f2129f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f2130g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f2131h;

    /* renamed from: i  reason: collision with root package name */
    final c f2132i;

    public C0659r3(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (c) null);
    }

    public final C0591j3 a(String str, double d5) {
        return C0591j3.b(this, str, Double.valueOf(-3.0d), true);
    }

    public final C0591j3 b(String str, long j4) {
        return C0591j3.c(this, str, Long.valueOf(j4), true);
    }

    public final C0591j3 c(String str, String str2) {
        return C0591j3.d(this, str, str2, true);
    }

    public final C0591j3 d(String str, boolean z4) {
        return C0591j3.a(this, str, Boolean.valueOf(z4), true);
    }

    public final C0659r3 e() {
        return new C0659r3(this.f2124a, this.f2125b, this.f2126c, this.f2127d, this.f2128e, this.f2129f, true, this.f2131h, this.f2132i);
    }

    public final C0659r3 f() {
        if (this.f2126c.isEmpty()) {
            c cVar = this.f2132i;
            if (cVar == null) {
                return new C0659r3(this.f2124a, this.f2125b, this.f2126c, this.f2127d, true, this.f2129f, this.f2130g, this.f2131h, cVar);
            }
            throw new IllegalStateException("Cannot skip gservices both always and conditionally");
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    private C0659r3(String str, Uri uri, String str2, String str3, boolean z4, boolean z5, boolean z6, boolean z7, c cVar) {
        this.f2124a = str;
        this.f2125b = uri;
        this.f2126c = str2;
        this.f2127d = str3;
        this.f2128e = z4;
        this.f2129f = z5;
        this.f2130g = z6;
        this.f2131h = z7;
        this.f2132i = cVar;
    }
}
