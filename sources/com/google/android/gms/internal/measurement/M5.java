package com.google.android.gms.internal.measurement;

public enum M5 {
    DOUBLE(T5.DOUBLE, 1),
    FLOAT(T5.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(T5.BOOLEAN, 0),
    STRING(T5.STRING, (T5) null),
    GROUP(r24, (T5) null),
    MESSAGE(r24, (T5) null),
    BYTES(T5.BYTE_STRING, (T5) null),
    UINT32(r11, 0),
    ENUM(T5.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    

    /* renamed from: a  reason: collision with root package name */
    private final T5 f1563a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1564b;

    public final T5 a() {
        return this.f1563a;
    }

    private M5(T5 t5, int i4) {
        this.f1563a = t5;
        this.f1564b = i4;
    }
}
