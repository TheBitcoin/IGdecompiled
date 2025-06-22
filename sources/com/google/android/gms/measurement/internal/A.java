package com.google.android.gms.measurement.internal;

import M.C0335p;

final class A {

    /* renamed from: a  reason: collision with root package name */
    final String f2283a;

    /* renamed from: b  reason: collision with root package name */
    final String f2284b;

    /* renamed from: c  reason: collision with root package name */
    final long f2285c;

    /* renamed from: d  reason: collision with root package name */
    final long f2286d;

    /* renamed from: e  reason: collision with root package name */
    final long f2287e;

    /* renamed from: f  reason: collision with root package name */
    final long f2288f;

    /* renamed from: g  reason: collision with root package name */
    final long f2289g;

    /* renamed from: h  reason: collision with root package name */
    final Long f2290h;

    /* renamed from: i  reason: collision with root package name */
    final Long f2291i;

    /* renamed from: j  reason: collision with root package name */
    final Long f2292j;

    /* renamed from: k  reason: collision with root package name */
    final Boolean f2293k;

    A(String str, String str2, long j4, long j5, long j6, long j7, Long l4, Long l5, Long l6, Boolean bool) {
        this(str, str2, 0, 0, 0, j6, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public final A a(long j4) {
        return new A(this.f2283a, this.f2284b, this.f2285c, this.f2286d, this.f2287e, j4, this.f2289g, this.f2290h, this.f2291i, this.f2292j, this.f2293k);
    }

    /* access modifiers changed from: package-private */
    public final A b(long j4, long j5) {
        return new A(this.f2283a, this.f2284b, this.f2285c, this.f2286d, this.f2287e, this.f2288f, j4, Long.valueOf(j5), this.f2291i, this.f2292j, this.f2293k);
    }

    /* access modifiers changed from: package-private */
    public final A c(Long l4, Long l5, Boolean bool) {
        Boolean bool2;
        if (bool == null || bool.booleanValue()) {
            bool2 = bool;
        } else {
            bool2 = null;
        }
        return new A(this.f2283a, this.f2284b, this.f2285c, this.f2286d, this.f2287e, this.f2288f, this.f2289g, this.f2290h, l4, l5, bool2);
    }

    A(String str, String str2, long j4, long j5, long j6, long j7, long j8, Long l4, Long l5, Long l6, Boolean bool) {
        long j9 = j4;
        long j10 = j5;
        long j11 = j6;
        long j12 = j8;
        C0335p.f(str);
        C0335p.f(str2);
        boolean z4 = false;
        C0335p.a(j9 >= 0);
        C0335p.a(j10 >= 0);
        C0335p.a(j11 >= 0);
        C0335p.a(j12 >= 0 ? true : z4);
        this.f2283a = str;
        this.f2284b = str2;
        this.f2285c = j9;
        this.f2286d = j10;
        this.f2287e = j11;
        this.f2288f = j7;
        this.f2289g = j12;
        this.f2290h = l4;
        this.f2291i = l5;
        this.f2292j = l6;
        this.f2293k = bool;
    }
}
