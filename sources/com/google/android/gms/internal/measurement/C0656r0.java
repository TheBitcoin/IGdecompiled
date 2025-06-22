package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.r0  reason: case insensitive filesystem */
public abstract class C0656r0 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0656r0 f2120a;

    /* renamed from: b  reason: collision with root package name */
    static final C0656r0 f2121b;

    static {
        C0649q0 b5 = new C0579i0().e("").c(false).b(C0672t0.ALL_CHECKS);
        C0664s0 s0Var = C0664s0.READ_AND_WRITE;
        f2120a = b5.a(s0Var).d();
        f2121b = new C0579i0().e("").c(false).b(C0672t0.NO_CHECKS).a(s0Var).d();
        new C0579i0().e("").c(false).b(C0672t0.SKIP_COMPLIANCE_CHECK).a(s0Var).d();
    }

    public abstract C0570h0 a();

    public abstract C0561g0 b();

    public abstract C0672t0 c();

    public abstract C0664s0 d();

    public abstract String e();

    public abstract boolean f();
}
