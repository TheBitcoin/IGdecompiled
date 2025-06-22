package com.google.android.gms.internal.measurement;

public final class T6 implements Q6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1632a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1633b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1632a = e5.d("measurement.gbraid_campaign.gbraid.client", true);
        f1633b = e5.d("measurement.gbraid_campaign.gbraid.service", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f1632a.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f1633b.e()).booleanValue();
    }
}
