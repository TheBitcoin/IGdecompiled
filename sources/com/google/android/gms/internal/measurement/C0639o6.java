package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.o6  reason: case insensitive filesystem */
public final class C0639o6 implements C0612l6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2095a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2096b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f2097c;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f2095a = e5.d("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        f2096b = e5.d("measurement.defensively_copy_bundles_validate_default_params", true);
        f2097c = e5.d("measurement.set_default_event_parameters_with_backfill.service", false);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f2095a.e()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f2097c.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f2096b.e()).booleanValue();
    }
}
