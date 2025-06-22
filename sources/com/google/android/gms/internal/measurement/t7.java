package com.google.android.gms.internal.measurement;

public final class t7 implements u7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2185a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2186b;

    /* renamed from: c  reason: collision with root package name */
    private static final C0591j3 f2187c;

    /* renamed from: d  reason: collision with root package name */
    private static final C0591j3 f2188d;

    /* renamed from: e  reason: collision with root package name */
    private static final C0591j3 f2189e;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        f2185a = e5.d("measurement.sgtm.google_signal.enable", false);
        f2186b = e5.d("measurement.sgtm.preview_mode_enabled", true);
        f2187c = e5.d("measurement.sgtm.rollout_percentage_fix", false);
        f2188d = e5.d("measurement.sgtm.service", true);
        f2189e = e5.d("measurement.sgtm.upload_queue", false);
        e5.b("measurement.id.sgtm", 0);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f2185a.e()).booleanValue();
    }

    public final boolean C() {
        return ((Boolean) f2187c.e()).booleanValue();
    }

    public final boolean D() {
        return ((Boolean) f2188d.e()).booleanValue();
    }

    public final boolean E() {
        return ((Boolean) f2189e.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f2186b.e()).booleanValue();
    }
}
