package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.m5  reason: case insensitive filesystem */
final class C0620m5 implements X4 {

    /* renamed from: a  reason: collision with root package name */
    private final Z4 f2048a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2049b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f2050c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2051d;

    C0620m5(Z4 z4, String str, Object[] objArr) {
        this.f2048a = z4;
        this.f2049b = str;
        this.f2050c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f2051d = charAt;
            return;
        }
        char c5 = charAt & 8191;
        int i4 = 13;
        int i5 = 1;
        while (true) {
            int i6 = i5 + 1;
            char charAt2 = str.charAt(i5);
            if (charAt2 >= 55296) {
                c5 |= (charAt2 & 8191) << i4;
                i4 += 13;
                i5 = i6;
            } else {
                this.f2051d = c5 | (charAt2 << i4);
                return;
            }
        }
    }

    public final Z4 A() {
        return this.f2048a;
    }

    public final C0584i5 B() {
        int i4 = this.f2051d;
        if ((i4 & 1) != 0) {
            return C0584i5.PROTO2;
        }
        if ((i4 & 4) == 4) {
            return C0584i5.EDITIONS;
        }
        return C0584i5.PROTO3;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f2049b;
    }

    public final boolean b() {
        if ((this.f2051d & 2) == 2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] c() {
        return this.f2050c;
    }
}
