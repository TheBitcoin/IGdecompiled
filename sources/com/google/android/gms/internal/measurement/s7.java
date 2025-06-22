package com.google.android.gms.internal.measurement;

public final class s7 implements p7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2164a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2165b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.client.sessions.background_sessions_enabled", true);
        f2164a = e5.d("measurement.client.sessions.enable_fix_background_engagement", false);
        e5.d("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f2165b = e5.d("measurement.client.sessions.enable_pause_engagement_in_background", true);
        e5.d("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        e5.d("measurement.client.sessions.session_id_enabled", true);
        e5.b("measurement.id.client.sessions.enable_fix_background_engagement", 0);
    }

    public final boolean A() {
        return ((Boolean) f2164a.e()).booleanValue();
    }

    public final boolean B() {
        return ((Boolean) f2165b.e()).booleanValue();
    }
}
