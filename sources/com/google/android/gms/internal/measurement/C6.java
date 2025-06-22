package com.google.android.gms.internal.measurement;

public final class C6 implements D6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1424a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f1425b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f1426c;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f1424a = e5.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f1425b = e5.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f1426c = e5.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f1424a.e()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f1426c.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f1425b.e()).booleanValue();
    }
}
