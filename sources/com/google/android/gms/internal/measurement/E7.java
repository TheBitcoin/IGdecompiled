package com.google.android.gms.internal.measurement;

public final class E7 implements C7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1456a;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1456a = e5.d("measurement.currency.escape_underscore_fix", true);
        e5.d("measurement.validation.value_and_currency_params", true);
    }

    public final boolean A() {
        return ((Boolean) f1456a.e()).booleanValue();
    }
}
