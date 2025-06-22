package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.i6  reason: case insensitive filesystem */
public final class C0585i6 implements C0558f6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1940a;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.client.consent_state_v1", true);
        e5.d("measurement.client.3p_consent_state_v1", true);
        e5.d("measurement.service.consent_state_v1_W36", true);
        f1940a = e5.b("measurement.service.storage_consent_support_version", 203600);
    }

    public final long A() {
        return ((Long) f1940a.e()).longValue();
    }
}
