package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w6  reason: case insensitive filesystem */
public final class C0702w6 implements C0710x6 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0591j3 f2237a;

    /* renamed from: b  reason: collision with root package name */
    private static final C0591j3 f2238b;

    static {
        C0659r3 e5 = new C0659r3(C0600k3.a("com.google.android.gms.measurement")).f().e();
        e5.d("measurement.collection.event_safelist", true);
        f2237a = e5.d("measurement.service.store_null_safelist", true);
        f2238b = e5.d("measurement.service.store_safelist", true);
    }

    public final boolean A() {
        return true;
    }

    public final boolean B() {
        return ((Boolean) f2237a.e()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f2238b.e()).booleanValue();
    }
}
