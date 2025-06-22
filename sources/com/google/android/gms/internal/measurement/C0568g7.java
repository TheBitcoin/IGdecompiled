package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.g7  reason: case insensitive filesystem */
public final class C0568g7 implements C0541d7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1907a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1908b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f1909c;

    /* renamed from: d  reason: collision with root package name */
    private static final C0591j3 f1910d;

    /* renamed from: e  reason: collision with root package name */
    private static final C0591j3 f1911e;

    /* renamed from: f  reason: collision with root package name */
    private static final C0591j3 f1912f;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1907a = e5.d("measurement.test.boolean_flag", false);
        f1908b = e5.b("measurement.test.cached_long_flag", -1);
        f1909c = e5.a("measurement.test.double_flag", -3.0d);
        f1910d = e5.b("measurement.test.int_flag", -2);
        f1911e = e5.b("measurement.test.long_flag", -1);
        f1912f = e5.c("measurement.test.string_flag", "---");
    }

    public final double A() {
        return ((Double) f1909c.e()).doubleValue();
    }

    public final long B() {
        return ((Long) f1908b.e()).longValue();
    }

    public final long C() {
        return ((Long) f1911e.e()).longValue();
    }

    public final String D() {
        return (String) f1912f.e();
    }

    public final boolean E() {
        return ((Boolean) f1907a.e()).booleanValue();
    }

    public final long b() {
        return ((Long) f1910d.e()).longValue();
    }
}
