package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.j  reason: case insensitive filesystem */
enum C0790j {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');
    
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final char f3044a;

    private C0790j(char c5) {
        this.f3044a = c5;
    }

    public static C0790j b(char c5) {
        for (C0790j jVar : values()) {
            if (jVar.f3044a == c5) {
                return jVar;
            }
        }
        return UNSET;
    }
}
