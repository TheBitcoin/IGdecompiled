package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.u6  reason: case insensitive filesystem */
public final class C0686u6 implements C0662r6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2198a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2199b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f2200c;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.dma_consent.client", true);
        e5.d("measurement.dma_consent.client_bow_check2", true);
        e5.d("measurement.dma_consent.separate_service_calls_fix", true);
        e5.d("measurement.dma_consent.service", true);
        f2198a = e5.d("measurement.dma_consent.service_database_update_fix", true);
        e5.d("measurement.dma_consent.service_dcu_event", true);
        f2199b = e5.d("measurement.dma_consent.service_dcu_event2", true);
        e5.d("measurement.dma_consent.service_npa_remote_default", true);
        e5.d("measurement.dma_consent.service_split_batch_on_consent", true);
        e5.d("measurement.dma_consent.set_consent_inline_on_worker", true);
        f2200c = e5.d("measurement.dma_consent.setting_npa_inline_fix", true);
    }

    public final boolean A() {
        return ((Boolean) f2198a.e()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f2199b.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f2200c.e()).booleanValue();
    }
}
