package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.f3  reason: case insensitive filesystem */
final class C0766f3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f2975a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f2976b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f2977c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ long f2978d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ X2 f2979e;

    C0766f3(X2 x22, String str, String str2, String str3, long j4) {
        this.f2975a = str;
        this.f2976b = str2;
        this.f2977c = str3;
        this.f2978d = j4;
        this.f2979e = x22;
    }

    public final void run() {
        String str = this.f2975a;
        if (str == null) {
            this.f2979e.f2792a.G(this.f2976b, (C0892x4) null);
            return;
        }
        this.f2979e.f2792a.G(this.f2976b, new C0892x4(this.f2977c, str, this.f2978d));
    }
}
