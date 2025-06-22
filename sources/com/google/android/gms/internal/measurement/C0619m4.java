package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m4  reason: case insensitive filesystem */
public enum C0619m4 {
    DOUBLE(0, r4, r11),
    FLOAT(1, r5, r17),
    INT64(2, r5, r6),
    UINT64(3, r5, r6),
    INT32(4, r5, r32),
    FIXED64(5, r5, r24),
    FIXED32(6, r5, r32),
    BOOL(7, r5, r41),
    STRING(8, r5, r48),
    MESSAGE(9, r5, r6),
    BYTES(10, r5, r6),
    UINT32(11, r5, r32),
    ENUM(12, r5, r70),
    SFIXED32(13, r5, r32),
    SFIXED64(14, r5, r24),
    SINT32(15, r5, r32),
    SINT64(16, r5, r24),
    GROUP(17, r5, r55),
    DOUBLE_LIST(18, r23, r11),
    FLOAT_LIST(19, r23, r17),
    INT64_LIST(20, r23, r24),
    UINT64_LIST(21, r23, r24),
    INT32_LIST(22, r31, r32),
    FIXED64_LIST(23, r23, r24),
    FIXED32_LIST(24, r31, r32),
    BOOL_LIST(25, r23, r41),
    STRING_LIST(26, r23, r48),
    MESSAGE_LIST(27, r54, r55),
    BYTES_LIST(28, r23, r6),
    UINT32_LIST(29, r31, r32),
    ENUM_LIST(30, r23, r70),
    SFIXED32_LIST(31, r31, r32),
    SFIXED64_LIST(32, r23, r24),
    SINT32_LIST(33, r31, r32),
    SINT64_LIST(34, r23, r24),
    DOUBLE_LIST_PACKED(35, r23, r11),
    FLOAT_LIST_PACKED(36, r23, r17),
    INT64_LIST_PACKED(37, r23, r24),
    UINT64_LIST_PACKED(38, r23, r24),
    INT32_LIST_PACKED(39, r31, r32),
    FIXED64_LIST_PACKED(40, r23, r24),
    FIXED32_LIST_PACKED(41, r31, r32),
    BOOL_LIST_PACKED(42, r23, r41),
    UINT32_LIST_PACKED(43, r31, r32),
    ENUM_LIST_PACKED(44, r23, r70),
    SFIXED32_LIST_PACKED(45, r31, r32),
    SFIXED64_LIST_PACKED(46, r23, r24),
    SINT32_LIST_PACKED(47, r31, r32),
    SINT64_LIST_PACKED(48, r23, r24),
    GROUP_LIST(49, r54, r55),
    MAP(50, C0637o4.MAP, D4.VOID);
    

    /* renamed from: m0  reason: collision with root package name */
    private static final C0619m4[] f2032m0 = null;

    /* renamed from: a  reason: collision with root package name */
    private final int f2047a;

    static {
        C0619m4[] values = values();
        f2032m0 = new C0619m4[values.length];
        for (C0619m4 m4Var : values) {
            f2032m0[m4Var.f2047a] = m4Var;
        }
    }

    private C0619m4(int i4, C0637o4 o4Var, D4 d42) {
        this.f2047a = i4;
        int ordinal = o4Var.ordinal();
        if (ordinal == 1) {
            d42.a();
        } else if (ordinal == 3) {
            d42.a();
        }
        if (o4Var == C0637o4.SCALAR) {
            int i5 = C0645p4.f2100a[d42.ordinal()];
        }
    }

    public final int A() {
        return this.f2047a;
    }
}
