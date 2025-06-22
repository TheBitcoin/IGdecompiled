package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.b7  reason: case insensitive filesystem */
public final class C0523b7 implements C0532c7 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f1764a;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        e5.d("measurement.sdk.collection.last_deep_link_referrer2", true);
        f1764a = e5.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        e5.b("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean A() {
        return ((Boolean) f1764a.e()).booleanValue();
    }
}
