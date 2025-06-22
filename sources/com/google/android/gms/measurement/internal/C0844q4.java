package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* renamed from: com.google.android.gms.measurement.internal.q4  reason: case insensitive filesystem */
final class C0844q4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f3193a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Uri f3194b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f3195c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f3196d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ C0823n4 f3197e;

    C0844q4(C0823n4 n4Var, boolean z4, Uri uri, String str, String str2) {
        this.f3193a = z4;
        this.f3194b = uri;
        this.f3195c = str;
        this.f3196d = str2;
        this.f3197e = n4Var;
    }

    public final void run() {
        C0823n4.a(this.f3197e, this.f3193a, this.f3194b, this.f3195c, this.f3196d);
    }
}
