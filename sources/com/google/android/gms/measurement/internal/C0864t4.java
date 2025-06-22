package com.google.android.gms.measurement.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.t4  reason: case insensitive filesystem */
public final /* synthetic */ class C0864t4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ C0871u4 f3229a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f3230b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ Exception f3231c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f3232d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ Map f3233e;

    public /* synthetic */ C0864t4(C0871u4 u4Var, int i4, Exception exc, byte[] bArr, Map map) {
        this.f3229a = u4Var;
        this.f3230b = i4;
        this.f3231c = exc;
        this.f3232d = bArr;
        this.f3233e = map;
    }

    public final void run() {
        this.f3229a.a(this.f3230b, this.f3231c, this.f3232d, this.f3233e);
    }
}
