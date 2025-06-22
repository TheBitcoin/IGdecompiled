package com.google.android.gms.internal.measurement;

final class M4 implements C0629n5 {

    /* renamed from: b  reason: collision with root package name */
    private static final V4 f1542b = new L4();

    /* renamed from: a  reason: collision with root package name */
    private final V4 f1543a;

    public M4() {
        this(new N4(C0676t4.c(), f1542b));
    }

    public final C0638o5 a(Class cls) {
        C0574h4 h4Var;
        C0654q5.o(cls);
        X4 a5 = this.f1543a.a(cls);
        if (a5.b()) {
            return C0539d5.i(C0654q5.f(), C0583i4.a(), a5.A());
        }
        C0557f5 a6 = C0575h5.a();
        I4 a7 = K4.a();
        E5 f4 = C0654q5.f();
        if (O4.f1590a[a5.B().ordinal()] != 1) {
            h4Var = C0583i4.a();
        } else {
            h4Var = null;
        }
        return C0530c5.m(cls, a5, a6, a7, f4, h4Var, T4.a());
    }

    private M4(V4 v4) {
        this.f1543a = (V4) C0684u4.f(v4, "messageInfoFactory");
    }
}
