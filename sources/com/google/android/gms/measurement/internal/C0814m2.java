package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.m2  reason: case insensitive filesystem */
final class C0814m2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f3112a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f3113b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Object f3114c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Object f3115d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Object f3116e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ C0821n2 f3117f;

    C0814m2(C0821n2 n2Var, int i4, String str, Object obj, Object obj2, Object obj3) {
        this.f3112a = i4;
        this.f3113b = str;
        this.f3114c = obj;
        this.f3115d = obj2;
        this.f3116e = obj3;
        this.f3117f = n2Var;
    }

    public final void run() {
        C0904z2 F4 = this.f3117f.f3273a.F();
        if (!F4.p()) {
            this.f3117f.v(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.f3117f.f3134c == 0) {
            if (this.f3117f.b().Y()) {
                this.f3117f.f3134c = 'C';
            } else {
                this.f3117f.f3134c = 'c';
            }
        }
        if (this.f3117f.f3135d < 0) {
            this.f3117f.f3135d = 106000;
        }
        String str = "2" + "01VDIWEA?".charAt(this.f3112a) + this.f3117f.f3134c + this.f3117f.f3135d + ":" + C0821n2.u(true, this.f3113b, this.f3114c, this.f3115d, this.f3116e);
        if (str.length() > 1024) {
            str = this.f3113b.substring(0, 1024);
        }
        D2 d22 = F4.f3321f;
        if (d22 != null) {
            d22.b(str, 1);
        }
    }
}
