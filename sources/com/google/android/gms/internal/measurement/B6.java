package com.google.android.gms.internal.measurement;

public final class B6 implements C0718y6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1409a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1410b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.client.ad_id_consent_fix", true);
        e5.d("measurement.service.consent.aiid_reset_fix", false);
        e5.d("measurement.service.consent.aiid_reset_fix2", true);
        e5.d("measurement.service.consent.app_start_fix", true);
        f1409a = e5.d("measurement.service.consent.params_on_fx", true);
        f1410b = e5.d("measurement.service.consent.pfo_on_fx", true);
    }

    public final boolean A() {
        return ((Boolean) f1409a.e()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f1410b.e()).booleanValue();
    }
}
