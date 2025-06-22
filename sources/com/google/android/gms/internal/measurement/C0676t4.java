package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.C0668s4;

/* renamed from: com.google.android.gms.internal.measurement.t4  reason: case insensitive filesystem */
final class C0676t4 implements V4 {

    /* renamed from: a  reason: collision with root package name */
    private static final C0676t4 f2179a = new C0676t4();

    private C0676t4() {
    }

    public static C0676t4 c() {
        return f2179a;
    }

    public final X4 a(Class cls) {
        Class<C0668s4> cls2 = C0668s4.class;
        if (cls2.isAssignableFrom(cls)) {
            try {
                return (X4) C0668s4.l(cls.asSubclass(cls2)).o(C0668s4.c.f2156c, (Object) null, (Object) null);
            } catch (Exception e5) {
                String name = cls.getName();
                throw new RuntimeException("Unable to get message info for " + name, e5);
            }
        } else {
            String name2 = cls.getName();
            throw new IllegalArgumentException("Unsupported message type: " + name2);
        }
    }

    public final boolean b(Class cls) {
        return C0668s4.class.isAssignableFrom(cls);
    }
}
