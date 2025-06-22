package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.p6  reason: case insensitive filesystem */
public final class C0647p6 implements C0655q6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2107a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2108b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f2107a = e5.d("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        f2108b = e5.d("measurement.set_default_event_parameters_propagate_clear.service", false);
        e5.b("measurement.id.set_default_event_parameters_propagate_clear.experiment_id", 0);
    }

    public final boolean A() {
        return ((Boolean) f2107a.e()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f2108b.e()).booleanValue();
    }
}
