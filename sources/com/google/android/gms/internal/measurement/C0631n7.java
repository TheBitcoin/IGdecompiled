package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.n7  reason: case insensitive filesystem */
public final class C0631n7 implements o7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2071a;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.collection.enable_session_stitching_token.client.dev", true);
        e5.d("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        f2071a = e5.d("measurement.session_stitching_token_enabled", false);
        e5.d("measurement.link_sst_to_sid", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f2071a.e()).booleanValue();
    }
}
