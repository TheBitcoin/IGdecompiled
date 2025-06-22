package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w2  reason: case insensitive filesystem */
public enum C0698w2 implements C0708x4 {
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN(0),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED(1),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED(2),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED(3),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED(4),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED(5);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f2228a;

    private C0698w2(int i4) {
        this.f2228a = i4;
    }

    public static C0698w2 a(int i4) {
        if (i4 == 0) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN;
        }
        if (i4 == 1) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED;
        }
        if (i4 == 2) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED;
        }
        if (i4 == 3) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED;
        }
        if (i4 == 4) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED;
        }
        if (i4 != 5) {
            return null;
        }
        return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED;
    }

    public static C0700w4 b() {
        return C0682u2.f2195a;
    }

    public final int A() {
        return this.f2228a;
    }

    public final String toString() {
        return "<" + C0698w2.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f2228a + " name=" + name() + '>';
    }
}
