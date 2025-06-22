package com.google.android.gms.internal.measurement;

public final class U6 implements V6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1644a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1645b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1644a = e5.d("measurement.gmscore_feature_tracking", true);
        f1645b = e5.d("measurement.gmscore_client_telemetry", false);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f1644a.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f1645b.e()).booleanValue();
    }
}
