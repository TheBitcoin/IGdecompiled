package com.google.android.gms.internal.measurement;

public enum D4 {
    VOID(Void.class, Void.class, (Class) null),
    INT(r4, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(K3.class, K3.class, K3.f1515b),
    ENUM(r4, Integer.class, (Class) null),
    MESSAGE(Object.class, Object.class, (Class) null);
    

    /* renamed from: a  reason: collision with root package name */
    private final Class f1441a;

    private D4(Class cls, Class cls2, Object obj) {
        this.f1441a = cls2;
    }

    public final Class a() {
        return this.f1441a;
    }
}
