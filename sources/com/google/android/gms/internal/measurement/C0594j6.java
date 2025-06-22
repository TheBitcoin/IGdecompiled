package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.j6  reason: case insensitive filesystem */
public final class C0594j6 implements C0603k6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1960a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1961b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f1962c;

    /* renamed from: d  reason: collision with root package name */
    private static final C0591j3 f1963d;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f1960a = e5.d("measurement.consent.stop_reset_on_storage_denied.client", true);
        f1961b = e5.d("measurement.consent.stop_reset_on_storage_denied.service", true);
        f1962c = e5.d("measurement.consent.scrub_audience_data_analytics_consent", true);
        f1963d = e5.d("measurement.consent.fix_first_open_count_from_snapshot", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f1960a.e()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f1962c.e()).booleanValue();
    }

    public final boolean D() {
        return ((Boolean) f1963d.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f1961b.e()).booleanValue();
    }
}
