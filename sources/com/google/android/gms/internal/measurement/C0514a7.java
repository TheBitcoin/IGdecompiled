package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.a7  reason: case insensitive filesystem */
public final class C0514a7 implements X6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1752a;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1752a = e5.d("measurement.gmscore_network_migration", false);
        e5.b("measurement.id.gmscore_network_migration", 0);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f1752a.e()).booleanValue();
    }
}
