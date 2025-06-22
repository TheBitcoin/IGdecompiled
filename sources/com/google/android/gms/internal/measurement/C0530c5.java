package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.measurement.c5  reason: case insensitive filesystem */
final class C0530c5 implements C0638o5 {

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f1777q = new int[0];

    /* renamed from: r  reason: collision with root package name */
    private static final Unsafe f1778r = F5.p();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f1779a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f1780b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1781c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1782d;

    /* renamed from: e  reason: collision with root package name */
    private final Z4 f1783e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1784f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f1785g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1786h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f1787i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1788j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1789k;

    /* renamed from: l  reason: collision with root package name */
    private final C0557f5 f1790l;

    /* renamed from: m  reason: collision with root package name */
    private final I4 f1791m;

    /* renamed from: n  reason: collision with root package name */
    private final E5 f1792n;

    /* renamed from: o  reason: collision with root package name */
    private final C0574h4 f1793o;

    /* renamed from: p  reason: collision with root package name */
    private final R4 f1794p;

    private C0530c5(int[] iArr, Object[] objArr, int i4, int i5, Z4 z4, boolean z5, int[] iArr2, int i6, int i7, C0557f5 f5Var, I4 i42, E5 e5, C0574h4 h4Var, R4 r4) {
        this.f1779a = iArr;
        this.f1780b = objArr;
        this.f1781c = i4;
        this.f1782d = i5;
        this.f1785g = z4 instanceof C0668s4;
        this.f1784f = h4Var != null && h4Var.d(z4);
        this.f1786h = false;
        this.f1787i = iArr2;
        this.f1788j = i6;
        this.f1789k = i7;
        this.f1790l = f5Var;
        this.f1791m = i42;
        this.f1792n = e5;
        this.f1793o = h4Var;
        this.f1783e = z4;
        this.f1794p = r4;
    }

    private static float B(Object obj, long j4) {
        return ((Float) F5.B(obj, j4)).floatValue();
    }

    private final int C(int i4) {
        return this.f1779a[i4 + 2];
    }

    private final void D(Object obj, int i4) {
        int C4 = C(i4);
        long j4 = (long) (1048575 & C4);
        if (j4 != 1048575) {
            F5.h(obj, j4, (1 << (C4 >>> 20)) | F5.t(obj, j4));
        }
    }

    private final void E(Object obj, int i4, int i5) {
        F5.h(obj, (long) (C(i5) & 1048575), i4);
    }

    private final void F(Object obj, Object obj2, int i4) {
        int i5 = this.f1779a[i4];
        if (K(obj2, i5, i4)) {
            long G4 = (long) (G(i4) & 1048575);
            Unsafe unsafe = f1778r;
            Object object = unsafe.getObject(obj2, G4);
            if (object != null) {
                C0638o5 O4 = O(i4);
                if (!K(obj, i5, i4)) {
                    if (!T(object)) {
                        unsafe.putObject(obj, G4, object);
                    } else {
                        Object A4 = O4.A();
                        O4.e(A4, object);
                        unsafe.putObject(obj, G4, A4);
                    }
                    E(obj, i5, i4);
                    return;
                }
                Object object2 = unsafe.getObject(obj, G4);
                if (!T(object2)) {
                    Object A5 = O4.A();
                    O4.e(A5, object2);
                    unsafe.putObject(obj, G4, A5);
                    object2 = A5;
                }
                O4.e(object2, object);
                return;
            }
            int i6 = this.f1779a[i4];
            String valueOf = String.valueOf(obj2);
            throw new IllegalStateException("Source subfield " + i6 + " is present but null: " + valueOf);
        }
    }

    private final int G(int i4) {
        return this.f1779a[i4 + 1];
    }

    private static int H(Object obj, long j4) {
        return ((Integer) F5.B(obj, j4)).intValue();
    }

    static D5 I(Object obj) {
        C0668s4 s4Var = (C0668s4) obj;
        D5 d5 = s4Var.zzb;
        if (d5 != D5.k()) {
            return d5;
        }
        D5 l4 = D5.l();
        s4Var.zzb = l4;
        return l4;
    }

    private final boolean J(Object obj, int i4) {
        int C4 = C(i4);
        long j4 = (long) (C4 & 1048575);
        if (j4 == 1048575) {
            int G4 = G(i4);
            long j5 = (long) (G4 & 1048575);
            switch ((G4 & 267386880) >>> 20) {
                case 0:
                    if (Double.doubleToRawLongBits(F5.a(obj, j5)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(F5.n(obj, j5)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (F5.x(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (F5.x(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (F5.x(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return F5.F(obj, j5);
                case 8:
                    Object B4 = F5.B(obj, j5);
                    if (B4 instanceof String) {
                        if (!((String) B4).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(B4 instanceof K3)) {
                        throw new IllegalArgumentException();
                    } else if (!K3.f1515b.equals(B4)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (F5.B(obj, j5) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!K3.f1515b.equals(F5.B(obj, j5))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (F5.x(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (F5.t(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (F5.x(obj, j5) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (F5.B(obj, j5) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((F5.t(obj, j4) & (1 << (C4 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean K(Object obj, int i4, int i5) {
        if (F5.t(obj, (long) (C(i5) & 1048575)) == i4) {
            return true;
        }
        return false;
    }

    private final boolean L(Object obj, Object obj2, int i4) {
        if (J(obj, i4) == J(obj2, i4)) {
            return true;
        }
        return false;
    }

    private static long M(Object obj, long j4) {
        return ((Long) F5.B(obj, j4)).longValue();
    }

    private final C0700w4 N(int i4) {
        return (C0700w4) this.f1780b[((i4 / 3) << 1) + 1];
    }

    private final C0638o5 O(int i4) {
        int i5 = (i4 / 3) << 1;
        C0638o5 o5Var = (C0638o5) this.f1780b[i5];
        if (o5Var != null) {
            return o5Var;
        }
        C0638o5 b5 = C0611l5.a().b((Class) this.f1780b[i5 + 1]);
        this.f1780b[i5] = b5;
        return b5;
    }

    private static boolean P(Object obj, long j4) {
        return ((Boolean) F5.B(obj, j4)).booleanValue();
    }

    private final Object Q(int i4) {
        return this.f1780b[(i4 / 3) << 1];
    }

    private static void R(Object obj) {
        if (!T(obj)) {
            String valueOf = String.valueOf(obj);
            throw new IllegalArgumentException("Mutating immutable message: " + valueOf);
        }
    }

    private static boolean S(int i4) {
        return (i4 & 536870912) != 0;
    }

    private static boolean T(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof C0668s4) {
            return ((C0668s4) obj).F();
        }
        return true;
    }

    private static double i(Object obj, long j4) {
        return ((Double) F5.B(obj, j4)).doubleValue();
    }

    private final int j(int i4) {
        if (i4 < this.f1781c || i4 > this.f1782d) {
            return -1;
        }
        return k(i4, 0);
    }

    private final int k(int i4, int i5) {
        int length = (this.f1779a.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int i8 = this.f1779a[i7];
            if (i4 == i8) {
                return i7;
            }
            if (i4 < i8) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0289  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.C0530c5 m(java.lang.Class r32, com.google.android.gms.internal.measurement.X4 r33, com.google.android.gms.internal.measurement.C0557f5 r34, com.google.android.gms.internal.measurement.I4 r35, com.google.android.gms.internal.measurement.E5 r36, com.google.android.gms.internal.measurement.C0574h4 r37, com.google.android.gms.internal.measurement.R4 r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.C0620m5
            if (r1 == 0) goto L_0x03f5
            com.google.android.gms.internal.measurement.m5 r0 = (com.google.android.gms.internal.measurement.C0620m5) r0
            java.lang.String r1 = r0.a()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0055
            int[] r7 = f1777q
            r16 = r7
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r17 = 0
            goto L_0x016a
        L_0x0055:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0074
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0061:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0071
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0061
        L_0x0071:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0074:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0093
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0080:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0090
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0080
        L_0x0090:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0093:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x009f:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00af
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x009f
        L_0x00af:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b2:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00be:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00ce
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00be
        L_0x00ce:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d1:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00dd:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00ed
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00dd
        L_0x00ed:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f0:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x010f
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fc:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010c
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fc
        L_0x010c:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x010f:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0130
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011b:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012c
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011b
        L_0x012c:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0130:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0153
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013c:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x014e
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013c
        L_0x014e:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0153:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 << 1
            int r16 = r16 + r7
            r7 = r12
            r12 = r9
            r9 = r7
            r7 = r13
            r13 = r10
            r10 = r16
            r16 = r7
            r7 = r4
            r17 = r14
            r4 = r15
        L_0x016a:
            sun.misc.Unsafe r14 = f1778r
            java.lang.Object[] r15 = r0.c()
            com.google.android.gms.internal.measurement.Z4 r18 = r0.A()
            java.lang.Class r3 = r18.getClass()
            r33 = 1
            int r6 = r11 * 3
            int[] r6 = new int[r6]
            int r11 = r11 << 1
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r18 = r17 + r9
            r20 = r17
            r21 = r18
            r9 = 0
            r19 = 0
        L_0x018b:
            if (r4 >= r2) goto L_0x03da
            int r22 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01b3
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = r22
            r22 = 13
        L_0x019b:
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01ad
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r22
            r4 = r4 | r8
            int r22 = r22 + 13
            r8 = r24
            goto L_0x019b
        L_0x01ad:
            int r8 = r8 << r22
            r4 = r4 | r8
            r8 = r24
            goto L_0x01b5
        L_0x01b3:
            r8 = r22
        L_0x01b5:
            int r22 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01e2
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r5 = r22
            r22 = 13
        L_0x01c3:
            int r25 = r5 + 1
            char r5 = r1.charAt(r5)
            r26 = r0
            r0 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r0) goto L_0x01dc
            r0 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r0 = r0 << r22
            r8 = r8 | r0
            int r22 = r22 + 13
            r5 = r25
            r0 = r26
            goto L_0x01c3
        L_0x01dc:
            int r0 = r5 << r22
            r8 = r8 | r0
            r0 = r25
            goto L_0x01e6
        L_0x01e2:
            r26 = r0
            r0 = r22
        L_0x01e6:
            r5 = r8 & 255(0xff, float:3.57E-43)
            r22 = r2
            r2 = r8 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x01f4
            int r2 = r19 + 1
            r16[r19] = r9
            r19 = r2
        L_0x01f4:
            r2 = 51
            r28 = r4
            if (r5 < r2) goto L_0x029c
            int r2 = r0 + 1
            char r0 = r1.charAt(r0)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r0 < r4) goto L_0x0223
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x0209:
            int r30 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r4) goto L_0x021e
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r29
            r0 = r0 | r2
            int r29 = r29 + 13
            r2 = r30
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0209
        L_0x021e:
            int r2 = r2 << r29
            r0 = r0 | r2
            r2 = r30
        L_0x0223:
            int r4 = r5 + -51
            r29 = r0
            r0 = 9
            if (r4 == r0) goto L_0x0252
            r0 = 17
            if (r4 != r0) goto L_0x0230
            goto L_0x0252
        L_0x0230:
            r0 = 12
            if (r4 != r0) goto L_0x025f
            com.google.android.gms.internal.measurement.i5 r0 = r26.B()
            com.google.android.gms.internal.measurement.i5 r4 = com.google.android.gms.internal.measurement.C0584i5.PROTO2
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0244
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x025f
        L_0x0244:
            int r0 = r9 / 3
            int r0 = r0 << 1
            int r0 = r0 + 1
            int r4 = r10 + 1
            r10 = r15[r10]
            r11[r0] = r10
        L_0x0250:
            r10 = r4
            goto L_0x025f
        L_0x0252:
            int r0 = r9 / 3
            int r0 = r0 << 1
            int r0 = r0 + 1
            int r4 = r10 + 1
            r10 = r15[r10]
            r11[r0] = r10
            goto L_0x0250
        L_0x025f:
            int r0 = r29 << 1
            r4 = r15[r0]
            r25 = r0
            boolean r0 = r4 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0270
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
        L_0x026b:
            r30 = r6
            r29 = r7
            goto L_0x0279
        L_0x0270:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = r(r3, r4)
            r15[r25] = r4
            goto L_0x026b
        L_0x0279:
            long r6 = r14.objectFieldOffset(r4)
            int r0 = (int) r6
            int r4 = r25 + 1
            r6 = r15[r4]
            boolean r7 = r6 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x0289
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x0291
        L_0x0289:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = r(r3, r6)
            r15[r4] = r6
        L_0x0291:
            long r6 = r14.objectFieldOffset(r6)
            int r4 = (int) r6
            r6 = r2
            r2 = r10
            r10 = r1
            r1 = 0
            goto L_0x0397
        L_0x029c:
            r30 = r6
            r29 = r7
            int r2 = r10 + 1
            r4 = r15[r10]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = r(r3, r4)
            r6 = 49
            r7 = 9
            if (r5 == r7) goto L_0x0316
            r7 = 17
            if (r5 != r7) goto L_0x02b5
            goto L_0x0316
        L_0x02b5:
            r7 = 27
            if (r5 == r7) goto L_0x0309
            if (r5 != r6) goto L_0x02bc
            goto L_0x0309
        L_0x02bc:
            r7 = 12
            if (r5 == r7) goto L_0x02ef
            r7 = 30
            if (r5 == r7) goto L_0x02ef
            r7 = 44
            if (r5 != r7) goto L_0x02c9
            goto L_0x02ef
        L_0x02c9:
            r7 = 50
            if (r5 != r7) goto L_0x0322
            int r7 = r20 + 1
            r16[r20] = r9
            int r20 = r9 / 3
            int r20 = r20 << 1
            int r25 = r10 + 2
            r2 = r15[r2]
            r11[r20] = r2
            r2 = r8 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02ea
            int r20 = r20 + 1
            int r2 = r10 + 3
            r10 = r15[r25]
            r11[r20] = r10
            r20 = r7
            goto L_0x0322
        L_0x02ea:
            r20 = r7
            r2 = r25
            goto L_0x0322
        L_0x02ef:
            com.google.android.gms.internal.measurement.i5 r7 = r26.B()
            com.google.android.gms.internal.measurement.i5 r6 = com.google.android.gms.internal.measurement.C0584i5.PROTO2
            if (r7 == r6) goto L_0x02fb
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0322
        L_0x02fb:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            int r10 = r10 + 2
            r2 = r15[r2]
            r11[r6] = r2
        L_0x0307:
            r2 = r10
            goto L_0x0322
        L_0x0309:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            int r10 = r10 + 2
            r2 = r15[r2]
            r11[r6] = r2
            goto L_0x0307
        L_0x0316:
            int r6 = r9 / 3
            int r6 = r6 << 1
            int r6 = r6 + 1
            java.lang.Class r7 = r4.getType()
            r11[r6] = r7
        L_0x0322:
            long r6 = r14.objectFieldOffset(r4)
            int r4 = (int) r6
            r6 = r8 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0376
            r7 = 17
            if (r5 > r7) goto L_0x0376
            int r6 = r0 + 1
            char r0 = r1.charAt(r0)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r0 < r7) goto L_0x0353
            r0 = r0 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x033e:
            int r24 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r7) goto L_0x034f
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r10
            r0 = r0 | r6
            int r10 = r10 + 13
            r6 = r24
            goto L_0x033e
        L_0x034f:
            int r6 = r6 << r10
            r0 = r0 | r6
            r6 = r24
        L_0x0353:
            int r10 = r29 << 1
            int r24 = r0 / 32
            int r10 = r10 + r24
            r7 = r15[r10]
            r27 = r0
            boolean r0 = r7 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0365
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
        L_0x0363:
            r10 = r1
            goto L_0x036e
        L_0x0365:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = r(r3, r7)
            r15[r10] = r7
            goto L_0x0363
        L_0x036e:
            long r0 = r14.objectFieldOffset(r7)
            int r1 = (int) r0
            int r0 = r27 % 32
            goto L_0x037c
        L_0x0376:
            r10 = r1
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r0
            r0 = 0
        L_0x037c:
            r7 = 18
            if (r5 < r7) goto L_0x0391
            r7 = 49
            if (r5 > r7) goto L_0x0391
            int r7 = r21 + 1
            r16[r21] = r4
            r21 = r1
            r1 = r0
            r0 = r4
            r4 = r21
            r21 = r7
            goto L_0x0397
        L_0x0391:
            r31 = r1
            r1 = r0
            r0 = r4
            r4 = r31
        L_0x0397:
            int r7 = r9 + 1
            r30[r9] = r28
            int r25 = r9 + 2
            r27 = r0
            r0 = r8 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a7
        L_0x03a6:
            r0 = 0
        L_0x03a7:
            r28 = r0
            r0 = r8 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x03b0
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b1
        L_0x03b0:
            r0 = 0
        L_0x03b1:
            r0 = r28 | r0
            r8 = r8 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x03ba
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03bb
        L_0x03ba:
            r8 = 0
        L_0x03bb:
            r0 = r0 | r8
            int r5 = r5 << 20
            r0 = r0 | r5
            r0 = r0 | r27
            r30[r7] = r0
            int r9 = r9 + 3
            int r0 = r1 << 20
            r0 = r0 | r4
            r30[r25] = r0
            r4 = r6
            r1 = r10
            r0 = r26
            r7 = r29
            r6 = r30
            r5 = 55296(0xd800, float:7.7486E-41)
            r10 = r2
            r2 = r22
            goto L_0x018b
        L_0x03da:
            r26 = r0
            r30 = r6
            com.google.android.gms.internal.measurement.c5 r9 = new com.google.android.gms.internal.measurement.c5
            com.google.android.gms.internal.measurement.Z4 r14 = r26.A()
            r15 = 0
            r19 = r34
            r20 = r35
            r21 = r36
            r22 = r37
            r23 = r38
            r10 = r30
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r9
        L_0x03f5:
            android.support.v4.media.a.a(r0)
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.m(java.lang.Class, com.google.android.gms.internal.measurement.X4, com.google.android.gms.internal.measurement.f5, com.google.android.gms.internal.measurement.I4, com.google.android.gms.internal.measurement.E5, com.google.android.gms.internal.measurement.h4, com.google.android.gms.internal.measurement.R4):com.google.android.gms.internal.measurement.c5");
    }

    private final Object n(int i4, int i5, Map map, C0700w4 w4Var, Object obj, E5 e5, Object obj2) {
        this.f1794p.a(Q(i4));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!w4Var.a(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = e5.i(obj2);
                }
                T3 s4 = K3.s(Q4.a((P4) null, entry.getKey(), entry.getValue()));
                try {
                    Q4.b(s4.b(), (P4) null, entry.getKey(), entry.getValue());
                    e5.c(obj, i5, s4.a());
                    it.remove();
                } catch (IOException e6) {
                    throw new RuntimeException(e6);
                }
            }
        }
        return obj;
    }

    private final Object o(Object obj, int i4) {
        C0638o5 O4 = O(i4);
        long G4 = (long) (G(i4) & 1048575);
        if (!J(obj, i4)) {
            return O4.A();
        }
        Object object = f1778r.getObject(obj, G4);
        if (T(object)) {
            return object;
        }
        Object A4 = O4.A();
        if (object != null) {
            O4.e(A4, object);
        }
        return A4;
    }

    private final Object p(Object obj, int i4, int i5) {
        C0638o5 O4 = O(i5);
        if (!K(obj, i4, i5)) {
            return O4.A();
        }
        Object object = f1778r.getObject(obj, (long) (G(i5) & 1048575));
        if (T(object)) {
            return object;
        }
        Object A4 = O4.A();
        if (object != null) {
            O4.e(A4, object);
        }
        return A4;
    }

    private final Object q(Object obj, int i4, Object obj2, E5 e5, Object obj3) {
        C0700w4 N4;
        int i5 = this.f1779a[i4];
        Object B4 = F5.B(obj, (long) (G(i4) & 1048575));
        if (B4 == null || (N4 = N(i4)) == null) {
            return obj2;
        }
        return n(i4, i5, this.f1794p.b(B4), N4, obj2, e5, obj3);
    }

    private static Field r(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void s(int i4, Object obj, W5 w5) {
        if (obj instanceof String) {
            w5.s(i4, (String) obj);
        } else {
            w5.j(i4, (K3) obj);
        }
    }

    private static void t(E5 e5, Object obj, W5 w5) {
        e5.g(e5.k(obj), w5);
    }

    private final void u(W5 w5, int i4, Object obj, int i5) {
        if (obj != null) {
            this.f1794p.a(Q(i5));
            w5.g(i4, (P4) null, this.f1794p.c(obj));
        }
    }

    private final void v(Object obj, int i4, int i5, Object obj2) {
        f1778r.putObject(obj, (long) (G(i5) & 1048575), obj2);
        E(obj, i4, i5);
    }

    private final void w(Object obj, int i4, Object obj2) {
        f1778r.putObject(obj, (long) (G(i4) & 1048575), obj2);
        D(obj, i4);
    }

    private final void x(Object obj, Object obj2, int i4) {
        if (J(obj2, i4)) {
            long G4 = (long) (G(i4) & 1048575);
            Unsafe unsafe = f1778r;
            Object object = unsafe.getObject(obj2, G4);
            if (object != null) {
                C0638o5 O4 = O(i4);
                if (!J(obj, i4)) {
                    if (!T(object)) {
                        unsafe.putObject(obj, G4, object);
                    } else {
                        Object A4 = O4.A();
                        O4.e(A4, object);
                        unsafe.putObject(obj, G4, A4);
                    }
                    D(obj, i4);
                    return;
                }
                Object object2 = unsafe.getObject(obj, G4);
                if (!T(object2)) {
                    Object A5 = O4.A();
                    O4.e(A5, object2);
                    unsafe.putObject(obj, G4, A5);
                    object2 = A5;
                }
                O4.e(object2, object);
                return;
            }
            int i5 = this.f1779a[i4];
            String valueOf = String.valueOf(obj2);
            throw new IllegalStateException("Source subfield " + i5 + " is present but null: " + valueOf);
        }
    }

    private final boolean y(Object obj, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return J(obj, i4);
        }
        if ((i6 & i7) != 0) {
            return true;
        }
        return false;
    }

    private static boolean z(Object obj, int i4, C0638o5 o5Var) {
        return o5Var.b(F5.B(obj, (long) (i4 & 1048575)));
    }

    public final Object A() {
        return this.f1790l.a(this.f1783e);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03bd, code lost:
        r9 = r16 + r0;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03c3, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03e2, code lost:
        r9 = r16 + r0;
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03ea, code lost:
        r0 = r17;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04d9, code lost:
        r9 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04db, code lost:
        r2 = r2 + 3;
        r8 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r9 = r16 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a8, code lost:
        r9 = r16 + ((r8 + r9) + r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r6 = f1778r
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r2 = 0
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r4 = 0
            r9 = 0
        L_0x0010:
            int[] r5 = r0.f1779a
            int r5 = r5.length
            if (r2 >= r5) goto L_0x04e2
            int r5 = r0.G(r2)
            r10 = 267386880(0xff00000, float:2.3665827E-29)
            r10 = r10 & r5
            int r10 = r10 >>> 20
            int[] r11 = r0.f1779a
            r12 = r11[r2]
            int r13 = r2 + 2
            r11 = r11[r13]
            r13 = r11 & r8
            r14 = 17
            r15 = 1
            if (r10 > r14) goto L_0x003f
            if (r13 == r3) goto L_0x003a
            if (r13 != r8) goto L_0x0033
            r4 = 0
            goto L_0x0039
        L_0x0033:
            long r3 = (long) r13
            int r3 = r6.getInt(r1, r3)
            r4 = r3
        L_0x0039:
            r3 = r13
        L_0x003a:
            int r11 = r11 >>> 20
            int r11 = r15 << r11
            goto L_0x0040
        L_0x003f:
            r11 = 0
        L_0x0040:
            r5 = r5 & r8
            long r13 = (long) r5
            com.google.android.gms.internal.measurement.m4 r5 = com.google.android.gms.internal.measurement.C0619m4.DOUBLE_LIST_PACKED
            int r5 = r5.A()
            if (r10 < r5) goto L_0x0050
            com.google.android.gms.internal.measurement.m4 r5 = com.google.android.gms.internal.measurement.C0619m4.SINT64_LIST_PACKED
            int r5 = r5.A()
        L_0x0050:
            r16 = r9
            r5 = 0
            r8 = 0
            switch(r10) {
                case 0: goto L_0x04ca;
                case 1: goto L_0x04bc;
                case 2: goto L_0x04ab;
                case 3: goto L_0x049a;
                case 4: goto L_0x0489;
                case 5: goto L_0x047c;
                case 6: goto L_0x046f;
                case 7: goto L_0x0462;
                case 8: goto L_0x0443;
                case 9: goto L_0x042e;
                case 10: goto L_0x041c;
                case 11: goto L_0x040c;
                case 12: goto L_0x03fc;
                case 13: goto L_0x03f0;
                case 14: goto L_0x03d7;
                case 15: goto L_0x03c7;
                case 16: goto L_0x03ae;
                case 17: goto L_0x0397;
                case 18: goto L_0x038b;
                case 19: goto L_0x037f;
                case 20: goto L_0x0373;
                case 21: goto L_0x0367;
                case 22: goto L_0x035b;
                case 23: goto L_0x034f;
                case 24: goto L_0x0343;
                case 25: goto L_0x0337;
                case 26: goto L_0x032b;
                case 27: goto L_0x031b;
                case 28: goto L_0x030f;
                case 29: goto L_0x0303;
                case 30: goto L_0x02f7;
                case 31: goto L_0x02eb;
                case 32: goto L_0x02df;
                case 33: goto L_0x02d3;
                case 34: goto L_0x02c7;
                case 35: goto L_0x02b1;
                case 36: goto L_0x029b;
                case 37: goto L_0x0285;
                case 38: goto L_0x026f;
                case 39: goto L_0x0259;
                case 40: goto L_0x0243;
                case 41: goto L_0x022d;
                case 42: goto L_0x0217;
                case 43: goto L_0x0202;
                case 44: goto L_0x01ed;
                case 45: goto L_0x01d8;
                case 46: goto L_0x01c3;
                case 47: goto L_0x01ae;
                case 48: goto L_0x0194;
                case 49: goto L_0x0184;
                case 50: goto L_0x0174;
                case 51: goto L_0x0166;
                case 52: goto L_0x015a;
                case 53: goto L_0x014a;
                case 54: goto L_0x013a;
                case 55: goto L_0x012a;
                case 56: goto L_0x011e;
                case 57: goto L_0x0112;
                case 58: goto L_0x0106;
                case 59: goto L_0x00e8;
                case 60: goto L_0x00d5;
                case 61: goto L_0x00c4;
                case 62: goto L_0x00b5;
                case 63: goto L_0x00a6;
                case 64: goto L_0x009b;
                case 65: goto L_0x0090;
                case 66: goto L_0x0081;
                case 67: goto L_0x0072;
                case 68: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x04d9
        L_0x005a:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.Z4 r5 = (com.google.android.gms.internal.measurement.Z4) r5
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.x(r12, r5, r8)
        L_0x006e:
            int r9 = r16 + r5
            goto L_0x04db
        L_0x0072:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            long r8 = M(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.i0(r12, r8)
            goto L_0x006e
        L_0x0081:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = H(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.t0(r12, r5)
            goto L_0x006e
        L_0x0090:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.e0(r12, r8)
            goto L_0x006e
        L_0x009b:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.p0(r12, r7)
            goto L_0x006e
        L_0x00a6:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = H(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.d0(r12, r5)
            goto L_0x006e
        L_0x00b5:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = H(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.w0(r12, r5)
            goto L_0x006e
        L_0x00c4:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.K3 r5 = (com.google.android.gms.internal.measurement.K3) r5
            int r5 = com.google.android.gms.internal.measurement.C0520b4.Q(r12, r5)
            goto L_0x006e
        L_0x00d5:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0654q5.a(r12, r5, r8)
            goto L_0x006e
        L_0x00e8:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            boolean r8 = r5 instanceof com.google.android.gms.internal.measurement.K3
            if (r8 == 0) goto L_0x00fe
            com.google.android.gms.internal.measurement.K3 r5 = (com.google.android.gms.internal.measurement.K3) r5
            int r5 = com.google.android.gms.internal.measurement.C0520b4.Q(r12, r5)
            goto L_0x006e
        L_0x00fe:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = com.google.android.gms.internal.measurement.C0520b4.y(r12, r5)
            goto L_0x006e
        L_0x0106:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.z(r12, r15)
            goto L_0x006e
        L_0x0112:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.h0(r12, r7)
            goto L_0x006e
        L_0x011e:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.P(r12, r8)
            goto L_0x006e
        L_0x012a:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            int r5 = H(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.l0(r12, r5)
            goto L_0x006e
        L_0x013a:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            long r8 = M(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.m0(r12, r8)
            goto L_0x006e
        L_0x014a:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            long r8 = M(r1, r13)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.Y(r12, r8)
            goto L_0x006e
        L_0x015a:
            boolean r8 = r0.K(r1, r12, r2)
            if (r8 == 0) goto L_0x04d9
            int r5 = com.google.android.gms.internal.measurement.C0520b4.f(r12, r5)
            goto L_0x006e
        L_0x0166:
            boolean r5 = r0.K(r1, r12, r2)
            if (r5 == 0) goto L_0x04d9
            r8 = 0
            int r5 = com.google.android.gms.internal.measurement.C0520b4.e(r12, r8)
            goto L_0x006e
        L_0x0174:
            com.google.android.gms.internal.measurement.R4 r5 = r0.f1794p
            java.lang.Object r8 = r6.getObject(r1, r13)
            java.lang.Object r9 = r0.Q(r2)
            int r5 = r5.h(r12, r8, r9)
            goto L_0x006e
        L_0x0184:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0654q5.c(r12, r5, r8)
            goto L_0x006e
        L_0x0194:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.N(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
        L_0x01a8:
            int r8 = r8 + r9
            int r8 = r8 + r5
            int r9 = r16 + r8
            goto L_0x04db
        L_0x01ae:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.K(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x01c3:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.B(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x01d8:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.y(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x01ed:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.t(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x0202:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.Q(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x0217:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.e(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x022d:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.y(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x0243:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.B(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x0259:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.E(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x026f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.T(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x0285:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.H(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x029b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.y(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x02b1:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.B(r5)
            if (r5 <= 0) goto L_0x04d9
            int r8 = com.google.android.gms.internal.measurement.C0520b4.s0(r12)
            int r9 = com.google.android.gms.internal.measurement.C0520b4.v0(r5)
            goto L_0x01a8
        L_0x02c7:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.M(r12, r5, r7)
            goto L_0x006e
        L_0x02d3:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.J(r12, r5, r7)
            goto L_0x006e
        L_0x02df:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.A(r12, r5, r7)
            goto L_0x006e
        L_0x02eb:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.x(r12, r5, r7)
            goto L_0x006e
        L_0x02f7:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.s(r12, r5, r7)
            goto L_0x006e
        L_0x0303:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.P(r12, r5, r7)
            goto L_0x006e
        L_0x030f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.b(r12, r5)
            goto L_0x006e
        L_0x031b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0654q5.r(r12, r5, r8)
            goto L_0x006e
        L_0x032b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.q(r12, r5)
            goto L_0x006e
        L_0x0337:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.d(r12, r5, r7)
            goto L_0x006e
        L_0x0343:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.x(r12, r5, r7)
            goto L_0x006e
        L_0x034f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.A(r12, r5, r7)
            goto L_0x006e
        L_0x035b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.D(r12, r5, r7)
            goto L_0x006e
        L_0x0367:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.S(r12, r5, r7)
            goto L_0x006e
        L_0x0373:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.G(r12, r5, r7)
            goto L_0x006e
        L_0x037f:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.x(r12, r5, r7)
            goto L_0x006e
        L_0x038b:
            java.lang.Object r5 = r6.getObject(r1, r13)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.C0654q5.A(r12, r5, r7)
            goto L_0x006e
        L_0x0397:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.Z4 r5 = (com.google.android.gms.internal.measurement.Z4) r5
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0520b4.x(r12, r5, r8)
            goto L_0x006e
        L_0x03ae:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.i0(r12, r8)
        L_0x03bd:
            int r9 = r16 + r0
            r0 = r17
            goto L_0x04db
        L_0x03c3:
            r0 = r17
            goto L_0x04d9
        L_0x03c7:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.t0(r12, r0)
            goto L_0x03bd
        L_0x03d7:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.e0(r12, r8)
        L_0x03e2:
            int r9 = r16 + r0
            r0 = r17
            r1 = r18
            goto L_0x04db
        L_0x03ea:
            r0 = r17
            r1 = r18
            goto L_0x04d9
        L_0x03f0:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.p0(r12, r7)
            goto L_0x03e2
        L_0x03fc:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.d0(r12, r0)
            goto L_0x03bd
        L_0x040c:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.w0(r12, r0)
            goto L_0x03bd
        L_0x041c:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            java.lang.Object r0 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.K3 r0 = (com.google.android.gms.internal.measurement.K3) r0
            int r0 = com.google.android.gms.internal.measurement.C0520b4.Q(r12, r0)
            goto L_0x03bd
        L_0x042e:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04d9
            java.lang.Object r5 = r6.getObject(r1, r13)
            com.google.android.gms.internal.measurement.o5 r8 = r0.O(r2)
            int r5 = com.google.android.gms.internal.measurement.C0654q5.a(r12, r5, r8)
            goto L_0x006e
        L_0x0443:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            java.lang.Object r0 = r6.getObject(r1, r13)
            boolean r5 = r0 instanceof com.google.android.gms.internal.measurement.K3
            if (r5 == 0) goto L_0x045a
            com.google.android.gms.internal.measurement.K3 r0 = (com.google.android.gms.internal.measurement.K3) r0
            int r0 = com.google.android.gms.internal.measurement.C0520b4.Q(r12, r0)
            goto L_0x03bd
        L_0x045a:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = com.google.android.gms.internal.measurement.C0520b4.y(r12, r0)
            goto L_0x03bd
        L_0x0462:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.z(r12, r15)
            goto L_0x03e2
        L_0x046f:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.h0(r12, r7)
            goto L_0x03e2
        L_0x047c:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.P(r12, r8)
            goto L_0x03e2
        L_0x0489:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            int r0 = r6.getInt(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.l0(r12, r0)
            goto L_0x03bd
        L_0x049a:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.m0(r12, r8)
            goto L_0x03bd
        L_0x04ab:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03c3
            long r8 = r6.getLong(r1, r13)
            int r0 = com.google.android.gms.internal.measurement.C0520b4.Y(r12, r8)
            goto L_0x03bd
        L_0x04bc:
            r5 = r11
            r8 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x03ea
            int r0 = com.google.android.gms.internal.measurement.C0520b4.f(r12, r8)
            goto L_0x03e2
        L_0x04ca:
            r5 = r11
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x04d9
            r8 = 0
            int r5 = com.google.android.gms.internal.measurement.C0520b4.e(r12, r8)
            goto L_0x006e
        L_0x04d9:
            r9 = r16
        L_0x04db:
            int r2 = r2 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0010
        L_0x04e2:
            r16 = r9
            com.google.android.gms.internal.measurement.E5 r2 = r0.f1792n
            java.lang.Object r3 = r2.k(r1)
            int r2 = r2.a(r3)
            int r9 = r16 + r2
            boolean r2 = r0.f1784f
            if (r2 == 0) goto L_0x0545
            com.google.android.gms.internal.measurement.h4 r2 = r0.f1793o
            com.google.android.gms.internal.measurement.l4 r1 = r2.b(r1)
            com.google.android.gms.internal.measurement.p5 r2 = r1.f1985a
            int r2 = r2.a()
            r3 = 0
        L_0x0501:
            r4 = 0
            if (r7 >= r2) goto L_0x051d
            com.google.android.gms.internal.measurement.p5 r5 = r1.f1985a
            java.util.Map$Entry r5 = r5.f(r7)
            java.lang.Object r6 = r5.getKey()
            android.support.v4.media.a.a(r6)
            java.lang.Object r5 = r5.getValue()
            int r4 = com.google.android.gms.internal.measurement.C0610l4.b(r4, r5)
            int r3 = r3 + r4
            int r7 = r7 + 1
            goto L_0x0501
        L_0x051d:
            com.google.android.gms.internal.measurement.p5 r1 = r1.f1985a
            java.lang.Iterable r1 = r1.h()
            java.util.Iterator r1 = r1.iterator()
        L_0x0527:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0544
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r5 = r2.getKey()
            android.support.v4.media.a.a(r5)
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.measurement.C0610l4.b(r4, r2)
            int r3 = r3 + r2
            goto L_0x0527
        L_0x0544:
            int r9 = r9 + r3
        L_0x0545:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.a(java.lang.Object):int");
    }

    public final boolean b(Object obj) {
        int i4;
        int i5;
        Object obj2;
        C0530c5 c5Var;
        int i6 = 0;
        int i7 = 1048575;
        int i8 = 0;
        while (i6 < this.f1788j) {
            int i9 = this.f1787i[i6];
            int i10 = this.f1779a[i9];
            int G4 = G(i9);
            int i11 = this.f1779a[i9 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i8 = f1778r.getInt(obj, (long) i12);
                }
                i4 = i8;
                i5 = i12;
            } else {
                i5 = i7;
                i4 = i8;
            }
            if ((268435456 & G4) != 0) {
                c5Var = this;
                obj2 = obj;
                if (!c5Var.y(obj2, i9, i5, i4, i13)) {
                    return false;
                }
            } else {
                c5Var = this;
                obj2 = obj;
            }
            int i14 = (267386880 & G4) >>> 20;
            if (i14 != 9 && i14 != 17) {
                if (i14 != 27) {
                    if (i14 == 60 || i14 == 68) {
                        if (K(obj2, i10, i9) && !z(obj2, G4, O(i9))) {
                            return false;
                        }
                    } else if (i14 != 49) {
                        if (i14 == 50 && !c5Var.f1794p.c(F5.B(obj2, (long) (G4 & 1048575))).isEmpty()) {
                            c5Var.f1794p.a(Q(i9));
                            throw null;
                        }
                    }
                }
                List list = (List) F5.B(obj2, (long) (G4 & 1048575));
                if (!list.isEmpty()) {
                    C0638o5 O4 = O(i9);
                    for (int i15 = 0; i15 < list.size(); i15++) {
                        if (!O4.b(list.get(i15))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (c5Var.y(obj2, i9, i5, i4, i13) && !z(obj2, G4, O(i9))) {
                return false;
            }
            i6++;
            obj = obj2;
            i7 = i5;
            i8 = i4;
        }
        Object obj3 = obj;
        if (!this.f1784f || this.f1793o.b(obj3).n()) {
            return true;
        }
        return false;
    }

    public final void c(Object obj) {
        if (T(obj)) {
            if (obj instanceof C0668s4) {
                C0668s4 s4Var = (C0668s4) obj;
                s4Var.h(Integer.MAX_VALUE);
                s4Var.zza = 0;
                s4Var.E();
            }
            int length = this.f1779a.length;
            for (int i4 = 0; i4 < length; i4 += 3) {
                int G4 = G(i4);
                long j4 = (long) (1048575 & G4);
                int i5 = (G4 & 267386880) >>> 20;
                if (i5 != 9) {
                    if (i5 == 60 || i5 == 68) {
                        if (K(obj, this.f1779a[i4], i4)) {
                            O(i4).c(f1778r.getObject(obj, j4));
                        }
                    } else {
                        switch (i5) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f1791m.a(obj, j4);
                                continue;
                            case 50:
                                Unsafe unsafe = f1778r;
                                Object object = unsafe.getObject(obj, j4);
                                if (object != null) {
                                    unsafe.putObject(obj, j4, this.f1794p.g(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (J(obj, i4)) {
                    O(i4).c(f1778r.getObject(obj, j4));
                }
            }
            this.f1792n.l(obj);
            if (this.f1784f) {
                this.f1793o.f(obj);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016d, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0030, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022b, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.f1779a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022f
            int r3 = r8.G(r1)
            int[] r4 = r8.f1779a
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x021b;
                case 1: goto L_0x020f;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e3;
                case 6: goto L_0x01db;
                case 7: goto L_0x01cf;
                case 8: goto L_0x01c1;
                case 9: goto L_0x01b6;
                case 10: goto L_0x01aa;
                case 11: goto L_0x01a2;
                case 12: goto L_0x019a;
                case 13: goto L_0x0192;
                case 14: goto L_0x0186;
                case 15: goto L_0x017e;
                case 16: goto L_0x0172;
                case 17: goto L_0x0163;
                case 18: goto L_0x0157;
                case 19: goto L_0x0157;
                case 20: goto L_0x0157;
                case 21: goto L_0x0157;
                case 22: goto L_0x0157;
                case 23: goto L_0x0157;
                case 24: goto L_0x0157;
                case 25: goto L_0x0157;
                case 26: goto L_0x0157;
                case 27: goto L_0x0157;
                case 28: goto L_0x0157;
                case 29: goto L_0x0157;
                case 30: goto L_0x0157;
                case 31: goto L_0x0157;
                case 32: goto L_0x0157;
                case 33: goto L_0x0157;
                case 34: goto L_0x0157;
                case 35: goto L_0x0157;
                case 36: goto L_0x0157;
                case 37: goto L_0x0157;
                case 38: goto L_0x0157;
                case 39: goto L_0x0157;
                case 40: goto L_0x0157;
                case 41: goto L_0x0157;
                case 42: goto L_0x0157;
                case 43: goto L_0x0157;
                case 44: goto L_0x0157;
                case 45: goto L_0x0157;
                case 46: goto L_0x0157;
                case 47: goto L_0x0157;
                case 48: goto L_0x0157;
                case 49: goto L_0x0157;
                case 50: goto L_0x014b;
                case 51: goto L_0x0135;
                case 52: goto L_0x0123;
                case 53: goto L_0x0111;
                case 54: goto L_0x00ff;
                case 55: goto L_0x00f1;
                case 56: goto L_0x00df;
                case 57: goto L_0x00d1;
                case 58: goto L_0x00bf;
                case 59: goto L_0x00ab;
                case 60: goto L_0x009a;
                case 61: goto L_0x0089;
                case 62: goto L_0x007c;
                case 63: goto L_0x006f;
                case 64: goto L_0x0062;
                case 65: goto L_0x0051;
                case 66: goto L_0x0044;
                case 67: goto L_0x0033;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x022b
        L_0x0020:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
        L_0x0030:
            int r2 = r2 + r3
            goto L_0x022b
        L_0x0033:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            long r3 = M(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0044:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x0051:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            long r3 = M(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0062:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x006f:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x007c:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x0089:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x009a:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x00ab:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x00bf:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            boolean r3 = P(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.c(r3)
            goto L_0x0030
        L_0x00d1:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x00df:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            long r3 = M(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x00f1:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            int r3 = H(r9, r5)
            goto L_0x0030
        L_0x00ff:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            long r3 = M(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0111:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            long r3 = M(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0123:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            float r3 = B(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0030
        L_0x0135:
            boolean r3 = r8.K(r9, r4, r1)
            if (r3 == 0) goto L_0x022b
            int r2 = r2 * 53
            double r3 = i(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x014b:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x0157:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x0163:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            if (r3 == 0) goto L_0x016d
            int r7 = r3.hashCode()
        L_0x016d:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x022b
        L_0x0172:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.F5.x(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x017e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x0186:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.F5.x(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0192:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x019a:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x01a2:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x01aa:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x01b6:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            if (r3 == 0) goto L_0x016d
            int r7 = r3.hashCode()
            goto L_0x016d
        L_0x01c1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0030
        L_0x01cf:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.F5.F(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.c(r3)
            goto L_0x0030
        L_0x01db:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x01e3:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.F5.x(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.F5.t(r9, r5)
            goto L_0x0030
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.F5.x(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.F5.x(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x020f:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.F5.n(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0030
        L_0x021b:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.F5.a(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.C0684u4.b(r3)
            goto L_0x0030
        L_0x022b:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022f:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.E5 r0 = r8.f1792n
            java.lang.Object r0 = r0.k(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f1784f
            if (r0 == 0) goto L_0x024d
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.h4 r0 = r8.f1793o
            com.google.android.gms.internal.measurement.l4 r9 = r0.b(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.d(java.lang.Object):int");
    }

    public final void e(Object obj, Object obj2) {
        R(obj);
        obj2.getClass();
        for (int i4 = 0; i4 < this.f1779a.length; i4 += 3) {
            int G4 = G(i4);
            long j4 = (long) (1048575 & G4);
            int i5 = this.f1779a[i4];
            switch ((G4 & 267386880) >>> 20) {
                case 0:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.f(obj, j4, F5.a(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 1:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.g(obj, j4, F5.n(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 2:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.i(obj, j4, F5.x(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 3:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.i(obj, j4, F5.x(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 4:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 5:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.i(obj, j4, F5.x(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 6:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 7:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.v(obj, j4, F5.F(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 8:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.j(obj, j4, F5.B(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 9:
                    x(obj, obj2, i4);
                    break;
                case 10:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.j(obj, j4, F5.B(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 11:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 12:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 13:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 14:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.i(obj, j4, F5.x(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 15:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.h(obj, j4, F5.t(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 16:
                    if (!J(obj2, i4)) {
                        break;
                    } else {
                        F5.i(obj, j4, F5.x(obj2, j4));
                        D(obj, i4);
                        break;
                    }
                case 17:
                    x(obj, obj2, i4);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f1791m.b(obj, obj2, j4);
                    break;
                case 50:
                    C0654q5.m(this.f1794p, obj, obj2, j4);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!K(obj2, i5, i4)) {
                        break;
                    } else {
                        F5.j(obj, j4, F5.B(obj2, j4));
                        E(obj, i5, i4);
                        break;
                    }
                case 60:
                    F(obj, obj2, i4);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!K(obj2, i5, i4)) {
                        break;
                    } else {
                        F5.j(obj, j4, F5.B(obj2, j4));
                        E(obj, i5, i4);
                        break;
                    }
                case 68:
                    F(obj, obj2, i4);
                    break;
            }
        }
        C0654q5.n(this.f1792n, obj, obj2);
        if (this.f1784f) {
            C0654q5.l(this.f1793o, obj, obj2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:290:0x090c, code lost:
        r0 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x0a1e, code lost:
        r2 = r2 + 3;
        r5 = r4;
        r12 = r18;
        r11 = 1048575;
        r4 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x0a30  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(java.lang.Object r21, com.google.android.gms.internal.measurement.W5 r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r6 = r22
            int r2 = r6.A()
            r3 = 2
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r9 = 1
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            if (r2 != r3) goto L_0x052d
            com.google.android.gms.internal.measurement.E5 r2 = r0.f1792n
            t(r2, r1, r6)
            boolean r2 = r0.f1784f
            if (r2 == 0) goto L_0x0036
            com.google.android.gms.internal.measurement.h4 r2 = r0.f1793o
            com.google.android.gms.internal.measurement.l4 r2 = r2.b(r1)
            com.google.android.gms.internal.measurement.p5 r3 = r2.f1985a
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0036
            java.util.Iterator r2 = r2.i()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0038
        L_0x0036:
            r2 = 0
            r3 = 0
        L_0x0038:
            int[] r4 = r0.f1779a
            int r4 = r4.length
            int r4 = r4 + -3
        L_0x003d:
            if (r4 < 0) goto L_0x0515
            int r5 = r0.G(r4)
            int[] r12 = r0.f1779a
            r12 = r12[r4]
        L_0x0047:
            if (r3 == 0) goto L_0x0065
            com.google.android.gms.internal.measurement.h4 r13 = r0.f1793o
            int r13 = r13.a(r3)
            if (r13 <= r12) goto L_0x0065
            com.google.android.gms.internal.measurement.h4 r13 = r0.f1793o
            r13.c(r6, r3)
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            goto L_0x0047
        L_0x0063:
            r3 = 0
            goto L_0x0047
        L_0x0065:
            r13 = r5 & r7
            int r13 = r13 >>> 20
            switch(r13) {
                case 0: goto L_0x0502;
                case 1: goto L_0x04f2;
                case 2: goto L_0x04e2;
                case 3: goto L_0x04d2;
                case 4: goto L_0x04c2;
                case 5: goto L_0x04b2;
                case 6: goto L_0x04a2;
                case 7: goto L_0x0491;
                case 8: goto L_0x0480;
                case 9: goto L_0x046b;
                case 10: goto L_0x0458;
                case 11: goto L_0x0447;
                case 12: goto L_0x0436;
                case 13: goto L_0x0425;
                case 14: goto L_0x0414;
                case 15: goto L_0x0403;
                case 16: goto L_0x03f2;
                case 17: goto L_0x03dd;
                case 18: goto L_0x03cc;
                case 19: goto L_0x03bb;
                case 20: goto L_0x03aa;
                case 21: goto L_0x0399;
                case 22: goto L_0x0388;
                case 23: goto L_0x0377;
                case 24: goto L_0x0366;
                case 25: goto L_0x0355;
                case 26: goto L_0x0344;
                case 27: goto L_0x032f;
                case 28: goto L_0x031e;
                case 29: goto L_0x030d;
                case 30: goto L_0x02fc;
                case 31: goto L_0x02eb;
                case 32: goto L_0x02da;
                case 33: goto L_0x02c9;
                case 34: goto L_0x02b8;
                case 35: goto L_0x02a7;
                case 36: goto L_0x0296;
                case 37: goto L_0x0285;
                case 38: goto L_0x0274;
                case 39: goto L_0x0263;
                case 40: goto L_0x0252;
                case 41: goto L_0x0241;
                case 42: goto L_0x0230;
                case 43: goto L_0x021f;
                case 44: goto L_0x020e;
                case 45: goto L_0x01fd;
                case 46: goto L_0x01ec;
                case 47: goto L_0x01db;
                case 48: goto L_0x01ca;
                case 49: goto L_0x01b5;
                case 50: goto L_0x01aa;
                case 51: goto L_0x0199;
                case 52: goto L_0x0188;
                case 53: goto L_0x0177;
                case 54: goto L_0x0166;
                case 55: goto L_0x0155;
                case 56: goto L_0x0144;
                case 57: goto L_0x0133;
                case 58: goto L_0x0122;
                case 59: goto L_0x0111;
                case 60: goto L_0x00fc;
                case 61: goto L_0x00e9;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00c7;
                case 64: goto L_0x00b6;
                case 65: goto L_0x00a5;
                case 66: goto L_0x0094;
                case 67: goto L_0x0083;
                case 68: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x0511
        L_0x006e:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            r6.D(r12, r5, r13)
            goto L_0x0511
        L_0x0083:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = M(r1, r13)
            r6.K(r12, r13)
            goto L_0x0511
        L_0x0094:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.M(r12, r5)
            goto L_0x0511
        L_0x00a5:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = M(r1, r13)
            r6.n(r12, r13)
            goto L_0x0511
        L_0x00b6:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.J(r12, r5)
            goto L_0x0511
        L_0x00c7:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.v(r12, r5)
            goto L_0x0511
        L_0x00d8:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.B(r12, r5)
            goto L_0x0511
        L_0x00e9:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.K3 r5 = (com.google.android.gms.internal.measurement.K3) r5
            r6.j(r12, r5)
            goto L_0x0511
        L_0x00fc:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            r6.F(r12, r5, r13)
            goto L_0x0511
        L_0x0111:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            s(r12, r5, r6)
            goto L_0x0511
        L_0x0122:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            boolean r5 = P(r1, r13)
            r6.b(r12, r5)
            goto L_0x0511
        L_0x0133:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.h(r12, r5)
            goto L_0x0511
        L_0x0144:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = M(r1, r13)
            r6.w(r12, r13)
            goto L_0x0511
        L_0x0155:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = H(r1, r13)
            r6.m(r12, r5)
            goto L_0x0511
        L_0x0166:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = M(r1, r13)
            r6.N(r12, r13)
            goto L_0x0511
        L_0x0177:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = M(r1, r13)
            r6.f(r12, r13)
            goto L_0x0511
        L_0x0188:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            float r5 = B(r1, r13)
            r6.y(r12, r5)
            goto L_0x0511
        L_0x0199:
            boolean r13 = r0.K(r1, r12, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            double r13 = i(r1, r13)
            r6.x(r12, r13)
            goto L_0x0511
        L_0x01aa:
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            r0.u(r6, r12, r5, r4)
            goto L_0x0511
        L_0x01b5:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            com.google.android.gms.internal.measurement.C0654q5.j(r12, r5, r6, r13)
            goto L_0x0511
        L_0x01ca:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.W(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01db:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.V(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01ec:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.U(r12, r5, r6, r9)
            goto L_0x0511
        L_0x01fd:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.R(r12, r5, r6, r9)
            goto L_0x0511
        L_0x020e:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.z(r12, r5, r6, r9)
            goto L_0x0511
        L_0x021f:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.X(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0230:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.k(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0241:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.C(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0252:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.F(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0263:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.L(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0274:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.Y(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0285:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.O(r12, r5, r6, r9)
            goto L_0x0511
        L_0x0296:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.I(r12, r5, r6, r9)
            goto L_0x0511
        L_0x02a7:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.w(r12, r5, r6, r9)
            goto L_0x0511
        L_0x02b8:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.W(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02c9:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.V(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02da:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.U(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02eb:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.R(r12, r5, r6, r10)
            goto L_0x0511
        L_0x02fc:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.z(r12, r5, r6, r10)
            goto L_0x0511
        L_0x030d:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.X(r12, r5, r6, r10)
            goto L_0x0511
        L_0x031e:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.i(r12, r5, r6)
            goto L_0x0511
        L_0x032f:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            com.google.android.gms.internal.measurement.C0654q5.v(r12, r5, r6, r13)
            goto L_0x0511
        L_0x0344:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.u(r12, r5, r6)
            goto L_0x0511
        L_0x0355:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.k(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0366:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.C(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0377:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.F(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0388:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.L(r12, r5, r6, r10)
            goto L_0x0511
        L_0x0399:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.Y(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03aa:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.O(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03bb:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.I(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03cc:
            int[] r12 = r0.f1779a
            r12 = r12[r4]
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.measurement.C0654q5.w(r12, r5, r6, r10)
            goto L_0x0511
        L_0x03dd:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            r6.D(r12, r5, r13)
            goto L_0x0511
        L_0x03f2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.measurement.F5.x(r1, r13)
            r6.K(r12, r13)
            goto L_0x0511
        L_0x0403:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.M(r12, r5)
            goto L_0x0511
        L_0x0414:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.measurement.F5.x(r1, r13)
            r6.n(r12, r13)
            goto L_0x0511
        L_0x0425:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.J(r12, r5)
            goto L_0x0511
        L_0x0436:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.v(r12, r5)
            goto L_0x0511
        L_0x0447:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.B(r12, r5)
            goto L_0x0511
        L_0x0458:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.K3 r5 = (com.google.android.gms.internal.measurement.K3) r5
            r6.j(r12, r5)
            goto L_0x0511
        L_0x046b:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            com.google.android.gms.internal.measurement.o5 r13 = r0.O(r4)
            r6.F(r12, r5, r13)
            goto L_0x0511
        L_0x0480:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r1, r13)
            s(r12, r5, r6)
            goto L_0x0511
        L_0x0491:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            boolean r5 = com.google.android.gms.internal.measurement.F5.F(r1, r13)
            r6.b(r12, r5)
            goto L_0x0511
        L_0x04a2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.h(r12, r5)
            goto L_0x0511
        L_0x04b2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.measurement.F5.x(r1, r13)
            r6.w(r12, r13)
            goto L_0x0511
        L_0x04c2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            int r5 = com.google.android.gms.internal.measurement.F5.t(r1, r13)
            r6.m(r12, r5)
            goto L_0x0511
        L_0x04d2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.measurement.F5.x(r1, r13)
            r6.N(r12, r13)
            goto L_0x0511
        L_0x04e2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            long r13 = com.google.android.gms.internal.measurement.F5.x(r1, r13)
            r6.f(r12, r13)
            goto L_0x0511
        L_0x04f2:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            float r5 = com.google.android.gms.internal.measurement.F5.n(r1, r13)
            r6.y(r12, r5)
            goto L_0x0511
        L_0x0502:
            boolean r13 = r0.J(r1, r4)
            if (r13 == 0) goto L_0x0511
            r5 = r5 & r11
            long r13 = (long) r5
            double r13 = com.google.android.gms.internal.measurement.F5.a(r1, r13)
            r6.x(r12, r13)
        L_0x0511:
            int r4 = r4 + -3
            goto L_0x003d
        L_0x0515:
            if (r3 == 0) goto L_0x052c
            com.google.android.gms.internal.measurement.h4 r1 = r0.f1793o
            r1.c(r6, r3)
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x052a
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r3 = r1
            goto L_0x0515
        L_0x052a:
            r3 = 0
            goto L_0x0515
        L_0x052c:
            return
        L_0x052d:
            boolean r2 = r0.f1784f
            if (r2 == 0) goto L_0x054b
            com.google.android.gms.internal.measurement.h4 r2 = r0.f1793o
            com.google.android.gms.internal.measurement.l4 r2 = r2.b(r1)
            com.google.android.gms.internal.measurement.p5 r3 = r2.f1985a
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x054b
            java.util.Iterator r2 = r2.l()
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            r12 = r2
            goto L_0x054d
        L_0x054b:
            r3 = 0
            r12 = 0
        L_0x054d:
            int[] r2 = r0.f1779a
            int r13 = r2.length
            sun.misc.Unsafe r14 = f1778r
            r2 = 0
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
        L_0x0557:
            if (r2 >= r13) goto L_0x0a2c
            int r15 = r0.G(r2)
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            int[] r7 = r0.f1779a
            r8 = r7[r2]
            r17 = r15 & r16
            int r10 = r17 >>> 20
            r17 = 1
            r9 = 17
            if (r10 > r9) goto L_0x058c
            int r9 = r2 + 2
            r7 = r7[r9]
            r9 = r7 & r11
            if (r9 == r4) goto L_0x0580
            if (r9 != r11) goto L_0x0579
            r5 = 0
            goto L_0x057f
        L_0x0579:
            long r4 = (long) r9
            int r4 = r14.getInt(r1, r4)
            r5 = r4
        L_0x057f:
            r4 = r9
        L_0x0580:
            int r7 = r7 >>> 20
            int r7 = r17 << r7
            r19 = r7
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = r19
            goto L_0x0590
        L_0x058c:
            r7 = r3
            r3 = r4
            r4 = r5
            r5 = 0
        L_0x0590:
            if (r7 == 0) goto L_0x05ae
            com.google.android.gms.internal.measurement.h4 r9 = r0.f1793o
            int r9 = r9.a(r7)
            if (r9 > r8) goto L_0x05ae
            com.google.android.gms.internal.measurement.h4 r9 = r0.f1793o
            r9.c(r6, r7)
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto L_0x05ac
            java.lang.Object r7 = r12.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            goto L_0x0590
        L_0x05ac:
            r7 = 0
            goto L_0x0590
        L_0x05ae:
            r9 = r15 & r11
            r18 = r12
            long r11 = (long) r9
            switch(r10) {
                case 0: goto L_0x0a0f;
                case 1: goto L_0x09fe;
                case 2: goto L_0x09ed;
                case 3: goto L_0x09dc;
                case 4: goto L_0x09cb;
                case 5: goto L_0x09ba;
                case 6: goto L_0x09a9;
                case 7: goto L_0x0998;
                case 8: goto L_0x0987;
                case 9: goto L_0x0972;
                case 10: goto L_0x0960;
                case 11: goto L_0x0950;
                case 12: goto L_0x0940;
                case 13: goto L_0x0930;
                case 14: goto L_0x0920;
                case 15: goto L_0x0910;
                case 16: goto L_0x08fd;
                case 17: goto L_0x08e8;
                case 18: goto L_0x08d7;
                case 19: goto L_0x08c6;
                case 20: goto L_0x08b5;
                case 21: goto L_0x08a4;
                case 22: goto L_0x0893;
                case 23: goto L_0x0882;
                case 24: goto L_0x0871;
                case 25: goto L_0x0860;
                case 26: goto L_0x0850;
                case 27: goto L_0x083c;
                case 28: goto L_0x082c;
                case 29: goto L_0x081b;
                case 30: goto L_0x080a;
                case 31: goto L_0x07f9;
                case 32: goto L_0x07e8;
                case 33: goto L_0x07d7;
                case 34: goto L_0x07c6;
                case 35: goto L_0x07b6;
                case 36: goto L_0x07a6;
                case 37: goto L_0x0796;
                case 38: goto L_0x0786;
                case 39: goto L_0x0776;
                case 40: goto L_0x0766;
                case 41: goto L_0x0756;
                case 42: goto L_0x0746;
                case 43: goto L_0x0736;
                case 44: goto L_0x0726;
                case 45: goto L_0x0716;
                case 46: goto L_0x0706;
                case 47: goto L_0x06f6;
                case 48: goto L_0x06e6;
                case 49: goto L_0x06d3;
                case 50: goto L_0x06ca;
                case 51: goto L_0x06bb;
                case 52: goto L_0x06ac;
                case 53: goto L_0x069d;
                case 54: goto L_0x068e;
                case 55: goto L_0x067f;
                case 56: goto L_0x0670;
                case 57: goto L_0x0661;
                case 58: goto L_0x0652;
                case 59: goto L_0x0643;
                case 60: goto L_0x0630;
                case 61: goto L_0x0620;
                case 62: goto L_0x0612;
                case 63: goto L_0x0604;
                case 64: goto L_0x05f6;
                case 65: goto L_0x05e8;
                case 66: goto L_0x05da;
                case 67: goto L_0x05cc;
                case 68: goto L_0x05ba;
                default: goto L_0x05b6;
            }
        L_0x05b6:
            r9 = 1
        L_0x05b7:
            r10 = 0
            goto L_0x0a1e
        L_0x05ba:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.o5 r9 = r0.O(r2)
            r6.D(r8, r5, r9)
            goto L_0x05b6
        L_0x05cc:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            long r9 = M(r1, r11)
            r6.K(r8, r9)
            goto L_0x05b6
        L_0x05da:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.M(r8, r5)
            goto L_0x05b6
        L_0x05e8:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            long r9 = M(r1, r11)
            r6.n(r8, r9)
            goto L_0x05b6
        L_0x05f6:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.J(r8, r5)
            goto L_0x05b6
        L_0x0604:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.v(r8, r5)
            goto L_0x05b6
        L_0x0612:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.B(r8, r5)
            goto L_0x05b6
        L_0x0620:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.K3 r5 = (com.google.android.gms.internal.measurement.K3) r5
            r6.j(r8, r5)
            goto L_0x05b6
        L_0x0630:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.o5 r9 = r0.O(r2)
            r6.F(r8, r5, r9)
            goto L_0x05b6
        L_0x0643:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            java.lang.Object r5 = r14.getObject(r1, r11)
            s(r8, r5, r6)
            goto L_0x05b6
        L_0x0652:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            boolean r5 = P(r1, r11)
            r6.b(r8, r5)
            goto L_0x05b6
        L_0x0661:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.h(r8, r5)
            goto L_0x05b6
        L_0x0670:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            long r9 = M(r1, r11)
            r6.w(r8, r9)
            goto L_0x05b6
        L_0x067f:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            int r5 = H(r1, r11)
            r6.m(r8, r5)
            goto L_0x05b6
        L_0x068e:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            long r9 = M(r1, r11)
            r6.N(r8, r9)
            goto L_0x05b6
        L_0x069d:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            long r9 = M(r1, r11)
            r6.f(r8, r9)
            goto L_0x05b6
        L_0x06ac:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            float r5 = B(r1, r11)
            r6.y(r8, r5)
            goto L_0x05b6
        L_0x06bb:
            boolean r5 = r0.K(r1, r8, r2)
            if (r5 == 0) goto L_0x05b6
            double r9 = i(r1, r11)
            r6.x(r8, r9)
            goto L_0x05b6
        L_0x06ca:
            java.lang.Object r5 = r14.getObject(r1, r11)
            r0.u(r6, r8, r5, r2)
            goto L_0x05b6
        L_0x06d3:
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.o5 r9 = r0.O(r2)
            com.google.android.gms.internal.measurement.C0654q5.j(r5, r8, r6, r9)
            goto L_0x05b6
        L_0x06e6:
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r9 = 1
            com.google.android.gms.internal.measurement.C0654q5.W(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x06f6:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.V(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0706:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.U(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0716:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.R(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0726:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.z(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0736:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.X(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0746:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.k(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0756:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.C(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0766:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.F(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0776:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.L(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0786:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.Y(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x0796:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.O(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x07a6:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.I(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x07b6:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.w(r5, r8, r6, r9)
            goto L_0x05b7
        L_0x07c6:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r10 = 0
            com.google.android.gms.internal.measurement.C0654q5.W(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x07d7:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.V(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x07e8:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.U(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x07f9:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.R(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x080a:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.z(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x081b:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.X(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x082c:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.i(r5, r8, r6)
            goto L_0x05b7
        L_0x083c:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.o5 r10 = r0.O(r2)
            com.google.android.gms.internal.measurement.C0654q5.v(r5, r8, r6, r10)
            goto L_0x05b7
        L_0x0850:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.u(r5, r8, r6)
            goto L_0x05b7
        L_0x0860:
            r9 = 1
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            r10 = 0
            com.google.android.gms.internal.measurement.C0654q5.k(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x0871:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.C(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x0882:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.F(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x0893:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.L(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x08a4:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.Y(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x08b5:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.O(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x08c6:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.I(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x08d7:
            r9 = 1
            r10 = 0
            int[] r5 = r0.f1779a
            r5 = r5[r2]
            java.lang.Object r8 = r14.getObject(r1, r11)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.C0654q5.w(r5, r8, r6, r10)
            goto L_0x0a1e
        L_0x08e8:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0a1e
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.o5 r11 = r0.O(r2)
            r6.D(r8, r5, r11)
            goto L_0x0a1e
        L_0x08fd:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            long r11 = r14.getLong(r1, r11)
            r6.K(r8, r11)
        L_0x090c:
            r0 = r20
            goto L_0x0a1e
        L_0x0910:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.M(r8, r0)
            goto L_0x090c
        L_0x0920:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            long r11 = r14.getLong(r1, r11)
            r6.n(r8, r11)
            goto L_0x090c
        L_0x0930:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.J(r8, r0)
            goto L_0x090c
        L_0x0940:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.v(r8, r0)
            goto L_0x090c
        L_0x0950:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.B(r8, r0)
            goto L_0x090c
        L_0x0960:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            java.lang.Object r0 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.K3 r0 = (com.google.android.gms.internal.measurement.K3) r0
            r6.j(r8, r0)
            goto L_0x090c
        L_0x0972:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0a1e
            java.lang.Object r5 = r14.getObject(r1, r11)
            com.google.android.gms.internal.measurement.o5 r11 = r0.O(r2)
            r6.F(r8, r5, r11)
            goto L_0x0a1e
        L_0x0987:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            java.lang.Object r0 = r14.getObject(r1, r11)
            s(r8, r0, r6)
            goto L_0x090c
        L_0x0998:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            boolean r0 = com.google.android.gms.internal.measurement.F5.F(r1, r11)
            r6.b(r8, r0)
            goto L_0x090c
        L_0x09a9:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.h(r8, r0)
            goto L_0x090c
        L_0x09ba:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            long r11 = r14.getLong(r1, r11)
            r6.w(r8, r11)
            goto L_0x090c
        L_0x09cb:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            int r0 = r14.getInt(r1, r11)
            r6.m(r8, r0)
            goto L_0x090c
        L_0x09dc:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            long r11 = r14.getLong(r1, r11)
            r6.N(r8, r11)
            goto L_0x090c
        L_0x09ed:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            long r11 = r14.getLong(r1, r11)
            r6.f(r8, r11)
            goto L_0x090c
        L_0x09fe:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x090c
            float r0 = com.google.android.gms.internal.measurement.F5.n(r1, r11)
            r6.y(r8, r0)
            goto L_0x090c
        L_0x0a0f:
            r9 = 1
            r10 = 0
            boolean r5 = r0.y(r1, r2, r3, r4, r5)
            if (r5 == 0) goto L_0x0a1e
            double r11 = com.google.android.gms.internal.measurement.F5.a(r1, r11)
            r6.x(r8, r11)
        L_0x0a1e:
            int r2 = r2 + 3
            r5 = r4
            r12 = r18
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r3
            r3 = r7
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0557
        L_0x0a2c:
            r18 = r12
        L_0x0a2e:
            if (r3 == 0) goto L_0x0a45
            com.google.android.gms.internal.measurement.h4 r2 = r0.f1793o
            r2.c(r6, r3)
            boolean r2 = r18.hasNext()
            if (r2 == 0) goto L_0x0a43
            java.lang.Object r2 = r18.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r3 = r2
            goto L_0x0a2e
        L_0x0a43:
            r3 = 0
            goto L_0x0a2e
        L_0x0a45:
            com.google.android.gms.internal.measurement.E5 r2 = r0.f1792n
            t(r2, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.f(java.lang.Object, com.google.android.gms.internal.measurement.W5):void");
    }

    public final void g(Object obj, byte[] bArr, int i4, int i5, J3 j32) {
        l(obj, bArr, i4, i5, 0, j32);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (com.google.android.gms.internal.measurement.C0654q5.p(com.google.android.gms.internal.measurement.F5.B(r10, r6), com.google.android.gms.internal.measurement.F5.B(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.F5.x(r10, r6) == com.google.android.gms.internal.measurement.F5.x(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        if (com.google.android.gms.internal.measurement.F5.x(r10, r6) == com.google.android.gms.internal.measurement.F5.x(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b3, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c4, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d6, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ec, code lost:
        if (com.google.android.gms.internal.measurement.C0654q5.p(com.google.android.gms.internal.measurement.F5.B(r10, r6), com.google.android.gms.internal.measurement.F5.B(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0102, code lost:
        if (com.google.android.gms.internal.measurement.C0654q5.p(com.google.android.gms.internal.measurement.F5.B(r10, r6), com.google.android.gms.internal.measurement.F5.B(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0118, code lost:
        if (com.google.android.gms.internal.measurement.C0654q5.p(com.google.android.gms.internal.measurement.F5.B(r10, r6), com.google.android.gms.internal.measurement.F5.B(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012a, code lost:
        if (com.google.android.gms.internal.measurement.F5.F(r10, r6) == com.google.android.gms.internal.measurement.F5.F(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013c, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0150, code lost:
        if (com.google.android.gms.internal.measurement.F5.x(r10, r6) == com.google.android.gms.internal.measurement.F5.x(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0162, code lost:
        if (com.google.android.gms.internal.measurement.F5.t(r10, r6) == com.google.android.gms.internal.measurement.F5.t(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0176, code lost:
        if (com.google.android.gms.internal.measurement.F5.x(r10, r6) == com.google.android.gms.internal.measurement.F5.x(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018a, code lost:
        if (com.google.android.gms.internal.measurement.F5.x(r10, r6) == com.google.android.gms.internal.measurement.F5.x(r11, r6)) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.F5.n(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.F5.n(r11, r6))) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.F5.a(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.F5.a(r11, r6))) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.C0654q5.p(com.google.android.gms.internal.measurement.F5.B(r10, r6), com.google.android.gms.internal.measurement.F5.B(r11, r6)) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean h(java.lang.Object r10, java.lang.Object r11) {
        /*
            r9 = this;
            int[] r0 = r9.f1779a
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01cb
            int r4 = r9.G(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a8;
                case 1: goto L_0x018e;
                case 2: goto L_0x017a;
                case 3: goto L_0x0166;
                case 4: goto L_0x0154;
                case 5: goto L_0x0140;
                case 6: goto L_0x012e;
                case 7: goto L_0x011c;
                case 8: goto L_0x0106;
                case 9: goto L_0x00f0;
                case 10: goto L_0x00da;
                case 11: goto L_0x00c8;
                case 12: goto L_0x00b6;
                case 13: goto L_0x00a5;
                case 14: goto L_0x0092;
                case 15: goto L_0x0081;
                case 16: goto L_0x006e;
                case 17: goto L_0x0059;
                case 18: goto L_0x004b;
                case 19: goto L_0x004b;
                case 20: goto L_0x004b;
                case 21: goto L_0x004b;
                case 22: goto L_0x004b;
                case 23: goto L_0x004b;
                case 24: goto L_0x004b;
                case 25: goto L_0x004b;
                case 26: goto L_0x004b;
                case 27: goto L_0x004b;
                case 28: goto L_0x004b;
                case 29: goto L_0x004b;
                case 30: goto L_0x004b;
                case 31: goto L_0x004b;
                case 32: goto L_0x004b;
                case 33: goto L_0x004b;
                case 34: goto L_0x004b;
                case 35: goto L_0x004b;
                case 36: goto L_0x004b;
                case 37: goto L_0x004b;
                case 38: goto L_0x004b;
                case 39: goto L_0x004b;
                case 40: goto L_0x004b;
                case 41: goto L_0x004b;
                case 42: goto L_0x004b;
                case 43: goto L_0x004b;
                case 44: goto L_0x004b;
                case 45: goto L_0x004b;
                case 46: goto L_0x004b;
                case 47: goto L_0x004b;
                case 48: goto L_0x004b;
                case 49: goto L_0x004b;
                case 50: goto L_0x003d;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c4
        L_0x001c:
            int r4 = r9.C(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.F5.t(r10, r4)
            int r4 = com.google.android.gms.internal.measurement.F5.t(r11, r4)
            if (r8 != r4) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.C0654q5.p(r4, r5)
            if (r4 != 0) goto L_0x01c4
        L_0x003a:
            r3 = 0
            goto L_0x01c4
        L_0x003d:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.C0654q5.p(r3, r4)
            goto L_0x01c4
        L_0x004b:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.C0654q5.p(r3, r4)
            goto L_0x01c4
        L_0x0059:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.C0654q5.p(r4, r5)
            if (r4 != 0) goto L_0x01c4
            goto L_0x003a
        L_0x006e:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.measurement.F5.x(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.F5.x(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x0081:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x0092:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.measurement.F5.x(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.F5.x(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x00a5:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x00b6:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x00c8:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x00da:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.C0654q5.p(r4, r5)
            if (r4 != 0) goto L_0x01c4
            goto L_0x003a
        L_0x00f0:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.C0654q5.p(r4, r5)
            if (r4 != 0) goto L_0x01c4
            goto L_0x003a
        L_0x0106:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = com.google.android.gms.internal.measurement.F5.B(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.F5.B(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.C0654q5.p(r4, r5)
            if (r4 != 0) goto L_0x01c4
            goto L_0x003a
        L_0x011c:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            boolean r4 = com.google.android.gms.internal.measurement.F5.F(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.F5.F(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x012e:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x0140:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.measurement.F5.x(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.F5.x(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x0154:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            int r4 = com.google.android.gms.internal.measurement.F5.t(r10, r6)
            int r5 = com.google.android.gms.internal.measurement.F5.t(r11, r6)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x0166:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.measurement.F5.x(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.F5.x(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x017a:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            long r4 = com.google.android.gms.internal.measurement.F5.x(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.F5.x(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x018e:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            float r4 = com.google.android.gms.internal.measurement.F5.n(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.F5.n(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c4
            goto L_0x003a
        L_0x01a8:
            boolean r4 = r9.L(r10, r11, r2)
            if (r4 == 0) goto L_0x003a
            double r4 = com.google.android.gms.internal.measurement.F5.a(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.F5.a(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c4
            goto L_0x003a
        L_0x01c4:
            if (r3 != 0) goto L_0x01c7
            return r1
        L_0x01c7:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01cb:
            com.google.android.gms.internal.measurement.E5 r0 = r9.f1792n
            java.lang.Object r0 = r0.k(r10)
            com.google.android.gms.internal.measurement.E5 r2 = r9.f1792n
            java.lang.Object r2 = r2.k(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01de
            return r1
        L_0x01de:
            boolean r0 = r9.f1784f
            if (r0 == 0) goto L_0x01f3
            com.google.android.gms.internal.measurement.h4 r0 = r9.f1793o
            com.google.android.gms.internal.measurement.l4 r10 = r0.b(r10)
            com.google.android.gms.internal.measurement.h4 r0 = r9.f1793o
            com.google.android.gms.internal.measurement.l4 r11 = r0.b(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.h(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.android.gms.internal.measurement.D5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v117, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v121, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v125, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v48, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v51, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v52, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v55, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v87, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v91, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v63, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v145, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v146, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v147, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v149, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v65, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v123, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v100, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v126, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v129, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v110, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v82, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v111, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v113, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v134, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v116, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v135, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v136, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v122, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v86, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v94, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v124, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v125, resolved type: byte} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0714  */
    /* JADX WARNING: Removed duplicated region for block: B:533:0x0619 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:542:0x06de A[SYNTHETIC] */
    final int l(java.lang.Object r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.measurement.J3 r37) {
        /*
            r31 = this;
            r0 = r31
            r2 = r32
            r3 = r33
            r5 = r35
            r6 = r37
            R(r2)
            sun.misc.Unsafe r1 = f1778r
            r4 = r34
            r7 = -1
            r8 = 0
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r14 = 0
            r15 = 0
        L_0x0018:
            r16 = 0
            if (r4 >= r5) goto L_0x0c53
            int r15 = r4 + 1
            byte r4 = r3[r4]
            if (r4 >= 0) goto L_0x0028
            int r15 = com.google.android.gms.internal.measurement.G3.e(r4, r3, r15, r6)
            int r4 = r6.f1502a
        L_0x0028:
            r28 = r15
            r15 = r4
            r4 = r28
            int r12 = r15 >>> 3
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r15 & 7
            r13 = 3
            if (r12 <= r7) goto L_0x0048
            int r8 = r8 / r13
            int r7 = r0.f1781c
            if (r12 < r7) goto L_0x0045
            int r7 = r0.f1782d
            if (r12 > r7) goto L_0x0045
            int r7 = r0.k(r12, r8)
            goto L_0x0046
        L_0x0045:
            r7 = -1
        L_0x0046:
            r8 = -1
            goto L_0x004d
        L_0x0048:
            int r7 = r0.j(r12)
            goto L_0x0046
        L_0x004d:
            if (r7 != r8) goto L_0x005e
            r10 = r36
            r21 = r1
            r19 = r9
            r9 = r15
            r18 = -1
            r26 = 0
            r15 = r12
            r12 = r2
            goto L_0x0be8
        L_0x005e:
            int[] r8 = r0.f1779a
            int r19 = r7 + 1
            r13 = r8[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r13 & r19
            int r3 = r19 >>> 20
            r19 = r4
            r4 = r13 & r17
            long r4 = (long) r4
            r20 = r4
            r4 = 17
            r22 = 0
            java.lang.String r5 = ""
            r24 = 1
            if (r3 > r4) goto L_0x03ab
            int r4 = r7 + 2
            r4 = r8[r4]
            int r8 = r4 >>> 20
            int r25 = r24 << r8
            r4 = r4 & r17
            if (r4 == r9) goto L_0x009f
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r26 = r7
            if (r9 == r8) goto L_0x0092
            long r6 = (long) r9
            r1.putInt(r2, r6, r14)
        L_0x0092:
            if (r4 != r8) goto L_0x0096
            r6 = 0
            goto L_0x009b
        L_0x0096:
            long r6 = (long) r4
            int r6 = r1.getInt(r2, r6)
        L_0x009b:
            r14 = r4
            r27 = r6
            goto L_0x00a4
        L_0x009f:
            r26 = r7
            r27 = r14
            r14 = r9
        L_0x00a4:
            switch(r3) {
                case 0: goto L_0x0376;
                case 1: goto L_0x034e;
                case 2: goto L_0x0321;
                case 3: goto L_0x0321;
                case 4: goto L_0x02f8;
                case 5: goto L_0x02b8;
                case 6: goto L_0x0299;
                case 7: goto L_0x0274;
                case 8: goto L_0x021e;
                case 9: goto L_0x01d0;
                case 10: goto L_0x01af;
                case 11: goto L_0x02f8;
                case 12: goto L_0x0157;
                case 13: goto L_0x0299;
                case 14: goto L_0x02b8;
                case 15: goto L_0x0133;
                case 16: goto L_0x00fc;
                case 17: goto L_0x00bc;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            r34 = r2
            r2 = r1
            r1 = r34
            r7 = r33
            r34 = r14
            r9 = r19
            r8 = r26
            r18 = -1
        L_0x00b6:
            r19 = r15
            r15 = r37
            goto L_0x0398
        L_0x00bc:
            r3 = 3
            if (r11 != r3) goto L_0x00ec
            r7 = r26
            java.lang.Object r3 = r0.o(r2, r7)
            int r4 = r12 << 3
            r8 = r4 | 4
            com.google.android.gms.internal.measurement.o5 r4 = r0.O(r7)
            r5 = r33
            r9 = r37
            r13 = r7
            r6 = r19
            r18 = -1
            r7 = r35
            int r4 = com.google.android.gms.internal.measurement.G3.i(r3, r4, r5, r6, r7, r8, r9)
            r7 = r5
            r0.w(r2, r13, r3)
            r3 = r27 | r25
        L_0x00e2:
            r5 = r35
        L_0x00e4:
            r6 = r9
            r8 = r13
        L_0x00e6:
            r9 = r14
            r14 = r3
            r3 = r7
        L_0x00e9:
            r7 = r12
            goto L_0x0018
        L_0x00ec:
            r18 = -1
            r34 = r2
            r2 = r1
            r1 = r34
            r7 = r33
            r34 = r14
            r9 = r19
            r8 = r26
            goto L_0x00b6
        L_0x00fc:
            r7 = r33
            r9 = r37
            r4 = r19
            r13 = r26
            r18 = -1
            if (r11 != 0) goto L_0x0125
            int r8 = com.google.android.gms.internal.measurement.G3.s(r7, r4, r9)
            long r3 = r9.f1503b
            long r5 = com.google.android.gms.internal.measurement.W3.b(r3)
            r3 = r20
            r1.putLong(r2, r3, r5)
            r28 = r2
            r2 = r1
            r1 = r28
            r3 = r27 | r25
            r4 = r2
            r2 = r1
            r1 = r4
            r5 = r35
            r4 = r8
            goto L_0x00e4
        L_0x0125:
            r28 = r2
            r2 = r1
            r1 = r28
        L_0x012a:
            r8 = r13
        L_0x012b:
            r34 = r14
            r19 = r15
            r15 = r9
        L_0x0130:
            r9 = r4
            goto L_0x0398
        L_0x0133:
            r4 = r2
            r2 = r1
            r1 = r4
            r7 = r33
            r9 = r37
            r4 = r19
            r5 = r20
            r13 = r26
            r18 = -1
            if (r11 != 0) goto L_0x012a
            int r4 = com.google.android.gms.internal.measurement.G3.r(r7, r4, r9)
            int r3 = r9.f1502a
            int r3 = com.google.android.gms.internal.measurement.W3.a(r3)
            r2.putInt(r1, r5, r3)
            r3 = r27 | r25
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x00e2
        L_0x0157:
            r4 = r2
            r2 = r1
            r1 = r4
            r7 = r33
            r9 = r37
            r4 = r19
            r5 = r20
            r8 = r26
            r18 = -1
            if (r11 != 0) goto L_0x012b
            int r4 = com.google.android.gms.internal.measurement.G3.r(r7, r4, r9)
            int r3 = r9.f1502a
            com.google.android.gms.internal.measurement.w4 r11 = r0.N(r8)
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = r13 & r16
            if (r13 == 0) goto L_0x0180
            if (r11 == 0) goto L_0x0180
            boolean r11 = r11.a(r3)
            if (r11 == 0) goto L_0x0183
        L_0x0180:
            r34 = r4
            goto L_0x01a0
        L_0x0183:
            com.google.android.gms.internal.measurement.D5 r5 = I(r1)
            r34 = r4
            long r3 = (long) r3
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r5.e(r15, r3)
            r3 = r2
            r2 = r1
            r1 = r3
            r4 = r34
            r5 = r35
            r3 = r7
            r6 = r9
            r7 = r12
            r9 = r14
            r14 = r27
            goto L_0x0018
        L_0x01a0:
            r2.putInt(r1, r5, r3)
            r3 = r27 | r25
            r4 = r2
            r2 = r1
            r1 = r4
            r4 = r34
        L_0x01aa:
            r5 = r35
            r6 = r9
            goto L_0x00e6
        L_0x01af:
            r3 = r2
            r2 = r1
            r1 = r3
            r7 = r33
            r9 = r37
            r4 = r19
            r5 = r20
            r8 = r26
            r3 = 2
            r18 = -1
            if (r11 != r3) goto L_0x012b
            int r4 = com.google.android.gms.internal.measurement.G3.k(r7, r4, r9)
            java.lang.Object r3 = r9.f1504c
            r2.putObject(r1, r5, r3)
            r3 = r27 | r25
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x01aa
        L_0x01d0:
            r3 = r2
            r2 = r1
            r1 = r3
            r7 = r33
            r9 = r37
            r4 = r19
            r8 = r26
            r3 = 2
            r18 = -1
            if (r11 != r3) goto L_0x0207
            r5 = r1
            java.lang.Object r1 = r0.o(r5, r8)
            r3 = r2
            com.google.android.gms.internal.measurement.o5 r2 = r0.O(r8)
            r6 = r9
            r9 = r3
            r3 = r7
            r7 = r5
            r5 = r35
            int r4 = com.google.android.gms.internal.measurement.G3.j(r1, r2, r3, r4, r5, r6)
            r2 = r3
            r3 = r1
            r1 = r2
            r2 = r6
            r0.w(r7, r8, r3)
            r3 = r27 | r25
            r5 = r3
            r3 = r1
            r1 = r9
            r9 = r14
            r14 = r5
            r5 = r35
            r2 = r7
            goto L_0x00e9
        L_0x0207:
            r28 = r7
            r7 = r1
            r1 = r28
            r28 = r9
            r9 = r2
            r2 = r28
            r34 = r7
            r7 = r1
            r1 = r34
            r34 = r14
            r19 = r15
        L_0x021a:
            r15 = r2
            r2 = r9
            goto L_0x0130
        L_0x021e:
            r9 = r1
            r7 = r2
            r34 = r14
            r4 = r19
            r8 = r26
            r3 = 2
            r18 = -1
            r1 = r33
            r2 = r37
            r19 = r15
            r14 = r20
            if (r11 != r3) goto L_0x0270
            boolean r3 = S(r13)
            if (r3 == 0) goto L_0x023f
            int r3 = com.google.android.gms.internal.measurement.G3.p(r1, r4, r2)
        L_0x023d:
            r4 = r3
            goto L_0x0257
        L_0x023f:
            int r3 = com.google.android.gms.internal.measurement.G3.r(r1, r4, r2)
            int r4 = r2.f1502a
            if (r4 < 0) goto L_0x026b
            if (r4 != 0) goto L_0x024c
            r2.f1504c = r5
            goto L_0x023d
        L_0x024c:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r5.<init>(r1, r3, r4, r6)
            r2.f1504c = r5
            int r3 = r3 + r4
            goto L_0x023d
        L_0x0257:
            java.lang.Object r3 = r2.f1504c
            r9.putObject(r7, r14, r3)
        L_0x025c:
            r14 = r27 | r25
            r5 = r35
            r3 = r1
            r6 = r2
            r2 = r7
            r1 = r9
            r7 = r12
        L_0x0265:
            r15 = r19
            r9 = r34
            goto L_0x0018
        L_0x026b:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x0270:
            r15 = r7
            r7 = r1
            r1 = r15
            goto L_0x021a
        L_0x0274:
            r9 = r1
            r7 = r2
            r34 = r14
            r4 = r19
            r8 = r26
            r18 = -1
            r1 = r33
            r2 = r37
            r19 = r15
            r14 = r20
            if (r11 != 0) goto L_0x0270
            int r4 = com.google.android.gms.internal.measurement.G3.s(r1, r4, r2)
            long r5 = r2.f1503b
            int r3 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r3 == 0) goto L_0x0294
            r6 = 1
            goto L_0x0295
        L_0x0294:
            r6 = 0
        L_0x0295:
            com.google.android.gms.internal.measurement.F5.v(r7, r14, r6)
            goto L_0x025c
        L_0x0299:
            r9 = r1
            r7 = r2
            r34 = r14
            r4 = r19
            r8 = r26
            r3 = 5
            r18 = -1
            r1 = r33
            r2 = r37
            r19 = r15
            r14 = r20
            if (r11 != r3) goto L_0x0270
            int r3 = com.google.android.gms.internal.measurement.G3.q(r1, r4)
            r9.putInt(r7, r14, r3)
            int r4 = r4 + 4
            goto L_0x025c
        L_0x02b8:
            r9 = r1
            r7 = r2
            r34 = r14
            r4 = r19
            r8 = r26
            r3 = 1
            r18 = -1
            r1 = r33
            r2 = r37
            r19 = r15
            r14 = r20
            if (r11 != r3) goto L_0x02ec
            long r5 = com.google.android.gms.internal.measurement.G3.t(r1, r4)
            r28 = r7
            r7 = r1
            r1 = r9
            r9 = r4
            r3 = r14
            r15 = r2
            r2 = r28
            r1.putLong(r2, r3, r5)
            int r4 = r9 + 8
            r14 = r27 | r25
        L_0x02e1:
            r9 = r34
            r5 = r35
            r3 = r7
            r7 = r12
            r6 = r15
            r15 = r19
            goto L_0x0018
        L_0x02ec:
            r15 = r2
            r2 = r7
            r7 = r1
            r1 = r9
            r9 = r4
        L_0x02f1:
            r28 = r2
            r2 = r1
            r1 = r28
            goto L_0x0398
        L_0x02f8:
            r7 = r33
            r34 = r14
            r9 = r19
            r3 = r20
            r8 = r26
            r18 = -1
            r19 = r15
            r15 = r37
            if (r11 != 0) goto L_0x02f1
            int r5 = com.google.android.gms.internal.measurement.G3.r(r7, r9, r15)
            int r6 = r15.f1502a
            r1.putInt(r2, r3, r6)
            r14 = r27 | r25
            r9 = r34
            r4 = r5
            r3 = r7
            r7 = r12
            r6 = r15
            r15 = r19
            r5 = r35
            goto L_0x0018
        L_0x0321:
            r7 = r33
            r34 = r14
            r9 = r19
            r3 = r20
            r8 = r26
            r18 = -1
            r19 = r15
            r15 = r37
            if (r11 != 0) goto L_0x02f1
            int r9 = com.google.android.gms.internal.measurement.G3.s(r7, r9, r15)
            long r5 = r15.f1503b
            r1.putLong(r2, r3, r5)
            r28 = r2
            r2 = r1
            r1 = r28
            r14 = r27 | r25
            r3 = r2
            r2 = r1
            r1 = r3
            r5 = r35
            r3 = r7
            r4 = r9
            r7 = r12
            r6 = r15
            goto L_0x0265
        L_0x034e:
            r34 = r2
            r2 = r1
            r1 = r34
            r7 = r33
            r34 = r14
            r9 = r19
            r3 = r20
            r8 = r26
            r5 = 5
            r18 = -1
            r19 = r15
            r15 = r37
            if (r11 != r5) goto L_0x0398
            float r5 = com.google.android.gms.internal.measurement.G3.n(r7, r9)
            com.google.android.gms.internal.measurement.F5.g(r1, r3, r5)
            int r4 = r9 + 4
        L_0x036f:
            r14 = r27 | r25
            r3 = r2
            r2 = r1
            r1 = r3
            goto L_0x02e1
        L_0x0376:
            r34 = r2
            r2 = r1
            r1 = r34
            r7 = r33
            r34 = r14
            r9 = r19
            r3 = r20
            r8 = r26
            r5 = 1
            r18 = -1
            r19 = r15
            r15 = r37
            if (r11 != r5) goto L_0x0398
            double r5 = com.google.android.gms.internal.measurement.G3.a(r7, r9)
            com.google.android.gms.internal.measurement.F5.f(r1, r3, r5)
            int r4 = r9 + 8
            goto L_0x036f
        L_0x0398:
            r10 = r36
            r21 = r2
            r3 = r7
            r26 = r8
            r4 = r9
            r6 = r15
            r9 = r19
            r14 = r27
            r19 = r34
            r15 = r12
            r12 = r1
            goto L_0x0be8
        L_0x03ab:
            r6 = r2
            r2 = r1
            r1 = r6
            r6 = r7
            r18 = -1
            r28 = r15
            r15 = r37
            r29 = r20
            r20 = r8
            r21 = r19
            r7 = r29
            r19 = r28
            r4 = 27
            if (r3 != r4) goto L_0x041b
            r4 = 2
            if (r11 != r4) goto L_0x0406
            java.lang.Object r3 = r2.getObject(r1, r7)
            com.google.android.gms.internal.measurement.C4 r3 = (com.google.android.gms.internal.measurement.C4) r3
            boolean r4 = r3.b()
            if (r4 != 0) goto L_0x03e4
            int r4 = r3.size()
            if (r4 != 0) goto L_0x03db
            r4 = 10
            goto L_0x03dd
        L_0x03db:
            int r4 = r4 << 1
        L_0x03dd:
            com.google.android.gms.internal.measurement.C4 r3 = r3.a(r4)
            r2.putObject(r1, r7, r3)
        L_0x03e4:
            com.google.android.gms.internal.measurement.o5 r1 = r0.O(r6)
            r5 = r35
            r8 = r2
            r26 = r6
            r7 = r15
            r2 = r19
            r4 = r21
            r15 = r32
            r6 = r3
            r3 = r33
            int r4 = com.google.android.gms.internal.measurement.G3.o(r1, r2, r3, r4, r5, r6, r7)
            r1 = r2
            r6 = r37
            r7 = r12
            r2 = r15
            r15 = r1
            r1 = r8
            r8 = r26
            goto L_0x0018
        L_0x0406:
            r15 = r1
            r1 = r19
            r19 = r9
            r9 = r1
            r1 = r15
            r15 = r12
            r12 = r1
            r13 = r6
            r25 = r14
            r1 = r21
            r6 = r37
            r14 = r2
            r2 = r33
            goto L_0x09d5
        L_0x041b:
            r15 = r1
            r4 = r21
            r1 = 49
            if (r3 > r1) goto L_0x097d
            r21 = r2
            long r1 = (long) r13
            sun.misc.Unsafe r13 = f1778r
            java.lang.Object r20 = r13.getObject(r15, r7)
            r25 = r1
            r1 = r20
            com.google.android.gms.internal.measurement.C4 r1 = (com.google.android.gms.internal.measurement.C4) r1
            boolean r2 = r1.b()
            if (r2 != 0) goto L_0x0446
            int r2 = r1.size()
            r24 = 1
            int r2 = r2 << 1
            com.google.android.gms.internal.measurement.C4 r1 = r1.a(r2)
            r13.putObject(r15, r7, r1)
        L_0x0446:
            switch(r3) {
                case 18: goto L_0x092d;
                case 19: goto L_0x08f8;
                case 20: goto L_0x08a0;
                case 21: goto L_0x08a0;
                case 22: goto L_0x0877;
                case 23: goto L_0x0800;
                case 24: goto L_0x0796;
                case 25: goto L_0x075d;
                case 26: goto L_0x067a;
                case 27: goto L_0x0642;
                case 28: goto L_0x05bf;
                case 29: goto L_0x0877;
                case 30: goto L_0x055d;
                case 31: goto L_0x0796;
                case 32: goto L_0x0800;
                case 33: goto L_0x0502;
                case 34: goto L_0x0486;
                case 35: goto L_0x092d;
                case 36: goto L_0x08f8;
                case 37: goto L_0x08a0;
                case 38: goto L_0x08a0;
                case 39: goto L_0x0877;
                case 40: goto L_0x0800;
                case 41: goto L_0x0796;
                case 42: goto L_0x075d;
                case 43: goto L_0x0877;
                case 44: goto L_0x055d;
                case 45: goto L_0x0796;
                case 46: goto L_0x0800;
                case 47: goto L_0x0502;
                case 48: goto L_0x0486;
                case 49: goto L_0x045e;
                default: goto L_0x0449;
            }
        L_0x0449:
            r1 = r19
            r19 = r9
            r9 = r1
            r1 = r15
            r15 = r12
            r12 = r1
            r2 = r33
            r1 = r4
            r26 = r6
            r25 = r14
            r4 = r35
            r6 = r37
            goto L_0x095a
        L_0x045e:
            r3 = 3
            if (r11 != r3) goto L_0x0449
            r5 = r1
            com.google.android.gms.internal.measurement.o5 r1 = r0.O(r6)
            r3 = r33
            r7 = r37
            r8 = r6
            r2 = r19
            r6 = r5
            r5 = r35
            int r1 = com.google.android.gms.internal.measurement.G3.f(r1, r2, r3, r4, r5, r6, r7)
            r6 = r5
            r5 = r1
            r1 = r4
            r4 = r6
            r6 = r15
            r15 = r12
            r12 = r6
            r6 = r7
            r26 = r8
            r19 = r9
            r25 = r14
        L_0x0482:
            r9 = r2
            r2 = r3
            goto L_0x095b
        L_0x0486:
            r3 = r33
            r5 = r35
            r7 = r1
            r8 = r6
            r2 = r19
            r1 = 2
            r6 = r37
            if (r11 != r1) goto L_0x04c7
            r1 = r7
            com.google.android.gms.internal.measurement.J4 r1 = (com.google.android.gms.internal.measurement.J4) r1
            int r7 = com.google.android.gms.internal.measurement.G3.r(r3, r4, r6)
            int r11 = r6.f1502a
            int r11 = r11 + r7
        L_0x049d:
            if (r7 >= r11) goto L_0x04b1
            int r7 = com.google.android.gms.internal.measurement.G3.s(r3, r7, r6)
            r34 = r12
            long r12 = r6.f1503b
            long r12 = com.google.android.gms.internal.measurement.W3.b(r12)
            r1.g(r12)
            r12 = r34
            goto L_0x049d
        L_0x04b1:
            r34 = r12
            if (r7 != r11) goto L_0x04c2
        L_0x04b5:
            r1 = r4
            r4 = r5
            r5 = r7
            r26 = r8
            r19 = r9
            r25 = r14
            r12 = r15
            r15 = r34
            goto L_0x0482
        L_0x04c2:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x04c7:
            r34 = r12
            if (r11 != 0) goto L_0x04f3
            r1 = r7
            com.google.android.gms.internal.measurement.J4 r1 = (com.google.android.gms.internal.measurement.J4) r1
            int r7 = com.google.android.gms.internal.measurement.G3.s(r3, r4, r6)
            long r11 = r6.f1503b
            long r11 = com.google.android.gms.internal.measurement.W3.b(r11)
            r1.g(r11)
        L_0x04db:
            if (r7 >= r5) goto L_0x04b5
            int r11 = com.google.android.gms.internal.measurement.G3.r(r3, r7, r6)
            int r12 = r6.f1502a
            if (r2 != r12) goto L_0x04b5
            int r7 = com.google.android.gms.internal.measurement.G3.s(r3, r11, r6)
            long r11 = r6.f1503b
            long r11 = com.google.android.gms.internal.measurement.W3.b(r11)
            r1.g(r11)
            goto L_0x04db
        L_0x04f3:
            r1 = r4
            r4 = r5
            r26 = r8
            r19 = r9
            r25 = r14
            r12 = r15
            r15 = r34
        L_0x04fe:
            r9 = r2
            r2 = r3
            goto L_0x095a
        L_0x0502:
            r3 = r33
            r5 = r35
            r7 = r1
            r8 = r6
            r34 = r12
            r2 = r19
            r1 = 2
            r6 = r37
            if (r11 != r1) goto L_0x0533
            r1 = r7
            com.google.android.gms.internal.measurement.v4 r1 = (com.google.android.gms.internal.measurement.C0692v4) r1
            int r7 = com.google.android.gms.internal.measurement.G3.r(r3, r4, r6)
            int r11 = r6.f1502a
            int r11 = r11 + r7
        L_0x051b:
            if (r7 >= r11) goto L_0x052b
            int r7 = com.google.android.gms.internal.measurement.G3.r(r3, r7, r6)
            int r12 = r6.f1502a
            int r12 = com.google.android.gms.internal.measurement.W3.a(r12)
            r1.j(r12)
            goto L_0x051b
        L_0x052b:
            if (r7 != r11) goto L_0x052e
            goto L_0x04b5
        L_0x052e:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0533:
            if (r11 != 0) goto L_0x04f3
            r1 = r7
            com.google.android.gms.internal.measurement.v4 r1 = (com.google.android.gms.internal.measurement.C0692v4) r1
            int r7 = com.google.android.gms.internal.measurement.G3.r(r3, r4, r6)
            int r11 = r6.f1502a
            int r11 = com.google.android.gms.internal.measurement.W3.a(r11)
            r1.j(r11)
        L_0x0545:
            if (r7 >= r5) goto L_0x04b5
            int r11 = com.google.android.gms.internal.measurement.G3.r(r3, r7, r6)
            int r12 = r6.f1502a
            if (r2 != r12) goto L_0x04b5
            int r7 = com.google.android.gms.internal.measurement.G3.r(r3, r11, r6)
            int r11 = r6.f1502a
            int r11 = com.google.android.gms.internal.measurement.W3.a(r11)
            r1.j(r11)
            goto L_0x0545
        L_0x055d:
            r3 = r33
            r5 = r35
            r7 = r1
            r8 = r6
            r34 = r12
            r2 = r19
            r1 = 2
            r6 = r37
            if (r11 != r1) goto L_0x057a
            int r1 = com.google.android.gms.internal.measurement.G3.l(r3, r4, r7, r6)
            r19 = r2
            r12 = r3
            r11 = r4
            r13 = r5
            r5 = r7
            r20 = r1
            r7 = r6
            goto L_0x058e
        L_0x057a:
            if (r11 != 0) goto L_0x05b1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            int r7 = com.google.android.gms.internal.measurement.G3.b(r1, r2, r3, r4, r5, r6)
            r19 = r1
            r12 = r2
            r11 = r3
            r13 = r4
            r1 = r7
            r7 = r6
            r20 = r1
        L_0x058e:
            com.google.android.gms.internal.measurement.w4 r4 = r0.N(r8)
            r6 = r5
            r5 = 0
            r3 = r6
            com.google.android.gms.internal.measurement.E5 r6 = r0.f1792n
            r2 = r34
            r1 = r15
            com.google.android.gms.internal.measurement.C0654q5.h(r1, r2, r3, r4, r5, r6)
            r15 = r2
            r1 = r19
            r19 = r9
            r9 = r1
            r6 = r7
            r26 = r8
            r1 = r11
            r2 = r12
            r4 = r13
            r25 = r14
            r5 = r20
            r12 = r32
            goto L_0x095b
        L_0x05b1:
            r15 = r34
            r12 = r32
            r1 = r4
            r4 = r5
            r26 = r8
            r19 = r9
            r25 = r14
            goto L_0x04fe
        L_0x05bf:
            r13 = r35
            r7 = r37
            r5 = r1
            r8 = r6
            r15 = r12
            r1 = r19
            r3 = 2
            r12 = r33
            if (r11 != r3) goto L_0x0633
            int r2 = com.google.android.gms.internal.measurement.G3.r(r12, r4, r7)
            int r3 = r7.f1502a
            if (r3 < 0) goto L_0x062e
            int r6 = r12.length
            int r6 = r6 - r2
            if (r3 > r6) goto L_0x0629
            if (r3 != 0) goto L_0x05e1
            com.google.android.gms.internal.measurement.K3 r3 = com.google.android.gms.internal.measurement.K3.f1515b
            r5.add(r3)
            goto L_0x05e9
        L_0x05e1:
            com.google.android.gms.internal.measurement.K3 r6 = com.google.android.gms.internal.measurement.K3.n(r12, r2, r3)
            r5.add(r6)
        L_0x05e8:
            int r2 = r2 + r3
        L_0x05e9:
            if (r2 >= r13) goto L_0x0619
            int r3 = com.google.android.gms.internal.measurement.G3.r(r12, r2, r7)
            int r6 = r7.f1502a
            if (r1 != r6) goto L_0x0619
            int r2 = com.google.android.gms.internal.measurement.G3.r(r12, r3, r7)
            int r3 = r7.f1502a
            if (r3 < 0) goto L_0x0614
            int r6 = r12.length
            int r6 = r6 - r2
            if (r3 > r6) goto L_0x060f
            if (r3 != 0) goto L_0x0607
            com.google.android.gms.internal.measurement.K3 r3 = com.google.android.gms.internal.measurement.K3.f1515b
            r5.add(r3)
            goto L_0x05e9
        L_0x0607:
            com.google.android.gms.internal.measurement.K3 r6 = com.google.android.gms.internal.measurement.K3.n(r12, r2, r3)
            r5.add(r6)
            goto L_0x05e8
        L_0x060f:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0614:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x0619:
            r5 = r2
            r6 = r7
            r26 = r8
            r19 = r9
            r2 = r12
            r25 = r14
            r12 = r32
            r9 = r1
            r1 = r4
            r4 = r13
            goto L_0x095b
        L_0x0629:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x062e:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x0633:
            r6 = r7
            r26 = r8
            r19 = r9
            r2 = r12
            r25 = r14
            r12 = r32
        L_0x063d:
            r9 = r1
            r1 = r4
            r4 = r13
            goto L_0x095a
        L_0x0642:
            r13 = r35
            r7 = r37
            r5 = r1
            r8 = r6
            r15 = r12
            r1 = r19
            r3 = 2
            r12 = r33
            if (r11 != r3) goto L_0x066f
            r2 = r1
            com.google.android.gms.internal.measurement.o5 r1 = r0.O(r8)
            r6 = r5
            r3 = r12
            r5 = r13
            r12 = r32
            int r1 = com.google.android.gms.internal.measurement.G3.o(r1, r2, r3, r4, r5, r6, r7)
            r6 = r3
            r3 = r1
            r1 = r2
            r2 = r6
            r6 = r7
            r26 = r8
            r19 = r9
            r25 = r14
            r9 = r1
            r1 = r4
            r4 = r5
            r5 = r3
            goto L_0x095b
        L_0x066f:
            r6 = r7
            r2 = r12
            r12 = r32
            r26 = r8
            r19 = r9
            r25 = r14
            goto L_0x063d
        L_0x067a:
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r13 = r1
            r7 = r4
            r8 = r6
            r1 = r19
            r3 = 2
            r4 = r35
            r6 = r37
            if (r11 != r3) goto L_0x0753
            r19 = 536870912(0x20000000, double:2.652494739E-315)
            long r19 = r25 & r19
            int r3 = (r19 > r22 ? 1 : (r19 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x06ea
            int r3 = com.google.android.gms.internal.measurement.G3.r(r2, r7, r6)
            int r11 = r6.f1502a
            if (r11 < 0) goto L_0x06e5
            if (r11 != 0) goto L_0x06a6
            r13.add(r5)
            r26 = r8
            r19 = r9
            goto L_0x06b5
        L_0x06a6:
            r26 = r8
            java.lang.String r8 = new java.lang.String
            r19 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r8.<init>(r2, r3, r11, r9)
            r13.add(r8)
            int r3 = r3 + r11
        L_0x06b5:
            if (r3 >= r4) goto L_0x06de
            int r8 = com.google.android.gms.internal.measurement.G3.r(r2, r3, r6)
            int r9 = r6.f1502a
            if (r1 != r9) goto L_0x06de
            int r3 = com.google.android.gms.internal.measurement.G3.r(r2, r8, r6)
            int r8 = r6.f1502a
            if (r8 < 0) goto L_0x06d9
            if (r8 != 0) goto L_0x06cd
            r13.add(r5)
            goto L_0x06b5
        L_0x06cd:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r9.<init>(r2, r3, r8, r11)
            r13.add(r9)
            int r3 = r3 + r8
            goto L_0x06b5
        L_0x06d9:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x06de:
            r9 = r1
            r5 = r3
        L_0x06e0:
            r1 = r7
            r25 = r14
            goto L_0x095b
        L_0x06e5:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x06ea:
            r26 = r8
            r19 = r9
            int r3 = com.google.android.gms.internal.measurement.G3.r(r2, r7, r6)
            int r8 = r6.f1502a
            if (r8 < 0) goto L_0x074e
            if (r8 != 0) goto L_0x06fc
            r13.add(r5)
            goto L_0x0712
        L_0x06fc:
            int r9 = r3 + r8
            boolean r11 = com.google.android.gms.internal.measurement.J5.e(r2, r3, r9)
            if (r11 == 0) goto L_0x0749
            java.lang.String r11 = new java.lang.String
            r34 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r11.<init>(r2, r3, r8, r9)
            r13.add(r11)
        L_0x0710:
            r3 = r34
        L_0x0712:
            if (r3 >= r4) goto L_0x06de
            int r8 = com.google.android.gms.internal.measurement.G3.r(r2, r3, r6)
            int r9 = r6.f1502a
            if (r1 != r9) goto L_0x06de
            int r3 = com.google.android.gms.internal.measurement.G3.r(r2, r8, r6)
            int r8 = r6.f1502a
            if (r8 < 0) goto L_0x0744
            if (r8 != 0) goto L_0x072a
            r13.add(r5)
            goto L_0x0712
        L_0x072a:
            int r9 = r3 + r8
            boolean r11 = com.google.android.gms.internal.measurement.J5.e(r2, r3, r9)
            if (r11 == 0) goto L_0x073f
            java.lang.String r11 = new java.lang.String
            r34 = r9
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r11.<init>(r2, r3, r8, r9)
            r13.add(r11)
            goto L_0x0710
        L_0x073f:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.c()
            throw r1
        L_0x0744:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x0749:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.c()
            throw r1
        L_0x074e:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.d()
            throw r1
        L_0x0753:
            r26 = r8
            r19 = r9
        L_0x0757:
            r9 = r1
            r1 = r7
            r25 = r14
            goto L_0x095a
        L_0x075d:
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r13 = r1
            r7 = r4
            r26 = r6
            r1 = r19
            r3 = 2
            r4 = r35
            r6 = r37
            r19 = r9
            if (r11 != r3) goto L_0x078a
            android.support.v4.media.a.a(r13)
            int r3 = com.google.android.gms.internal.measurement.G3.r(r2, r7, r6)
            int r5 = r6.f1502a
            int r5 = r5 + r3
            if (r3 < r5) goto L_0x0786
            if (r3 != r5) goto L_0x0781
            goto L_0x06de
        L_0x0781:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0786:
            com.google.android.gms.internal.measurement.G3.s(r2, r3, r6)
            throw r16
        L_0x078a:
            if (r11 == 0) goto L_0x078d
            goto L_0x0757
        L_0x078d:
            android.support.v4.media.a.a(r13)
            com.google.android.gms.internal.measurement.G3.s(r2, r7, r6)
            long r1 = r6.f1503b
            throw r16
        L_0x0796:
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r13 = r1
            r7 = r4
            r26 = r6
            r1 = r19
            r3 = 2
            r4 = r35
            r6 = r37
            r19 = r9
            if (r11 != r3) goto L_0x07dd
            r3 = r13
            com.google.android.gms.internal.measurement.v4 r3 = (com.google.android.gms.internal.measurement.C0692v4) r3
            int r5 = com.google.android.gms.internal.measurement.G3.r(r2, r7, r6)
            int r8 = r6.f1502a
            int r9 = r5 + r8
            int r11 = r2.length
            if (r9 > r11) goto L_0x07d8
            int r11 = r3.size()
            int r8 = r8 / 4
            int r11 = r11 + r8
            r3.k(r11)
        L_0x07c2:
            if (r5 >= r9) goto L_0x07ce
            int r8 = com.google.android.gms.internal.measurement.G3.q(r2, r5)
            r3.j(r8)
            int r5 = r5 + 4
            goto L_0x07c2
        L_0x07ce:
            if (r5 != r9) goto L_0x07d3
        L_0x07d0:
            r9 = r1
            goto L_0x06e0
        L_0x07d3:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x07d8:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x07dd:
            r3 = 5
            if (r11 != r3) goto L_0x0757
            r3 = r13
            com.google.android.gms.internal.measurement.v4 r3 = (com.google.android.gms.internal.measurement.C0692v4) r3
            int r5 = com.google.android.gms.internal.measurement.G3.q(r2, r7)
            r3.j(r5)
            int r5 = r7 + 4
        L_0x07ec:
            if (r5 >= r4) goto L_0x07d0
            int r8 = com.google.android.gms.internal.measurement.G3.r(r2, r5, r6)
            int r9 = r6.f1502a
            if (r1 != r9) goto L_0x07d0
            int r5 = com.google.android.gms.internal.measurement.G3.q(r2, r8)
            r3.j(r5)
            int r5 = r8 + 4
            goto L_0x07ec
        L_0x0800:
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r13 = r1
            r7 = r4
            r26 = r6
            r1 = r19
            r3 = 2
            r4 = r35
            r6 = r37
            r19 = r9
            if (r11 != r3) goto L_0x084e
            r3 = r13
            com.google.android.gms.internal.measurement.J4 r3 = (com.google.android.gms.internal.measurement.J4) r3
            int r5 = com.google.android.gms.internal.measurement.G3.r(r2, r7, r6)
            int r8 = r6.f1502a
            int r9 = r5 + r8
            int r11 = r2.length
            if (r9 > r11) goto L_0x0849
            int r11 = r3.size()
            int r8 = r8 / 8
            int r11 = r11 + r8
            r3.j(r11)
        L_0x082c:
            if (r5 >= r9) goto L_0x083c
            r25 = r14
            long r13 = com.google.android.gms.internal.measurement.G3.t(r2, r5)
            r3.g(r13)
            int r5 = r5 + 8
            r14 = r25
            goto L_0x082c
        L_0x083c:
            r25 = r14
            if (r5 != r9) goto L_0x0844
        L_0x0840:
            r9 = r1
        L_0x0841:
            r1 = r7
            goto L_0x095b
        L_0x0844:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0849:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x084e:
            r25 = r14
            r3 = 1
            if (r11 != r3) goto L_0x0873
            r3 = r13
            com.google.android.gms.internal.measurement.J4 r3 = (com.google.android.gms.internal.measurement.J4) r3
            long r8 = com.google.android.gms.internal.measurement.G3.t(r2, r7)
            r3.g(r8)
            int r5 = r7 + 8
        L_0x085f:
            if (r5 >= r4) goto L_0x0840
            int r8 = com.google.android.gms.internal.measurement.G3.r(r2, r5, r6)
            int r9 = r6.f1502a
            if (r1 != r9) goto L_0x0840
            long r13 = com.google.android.gms.internal.measurement.G3.t(r2, r8)
            r3.g(r13)
            int r5 = r8 + 8
            goto L_0x085f
        L_0x0873:
            r9 = r1
            r1 = r7
            goto L_0x095a
        L_0x0877:
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r13 = r1
            r7 = r4
            r26 = r6
            r25 = r14
            r1 = r19
            r3 = 2
            r4 = r35
            r6 = r37
            r19 = r9
            if (r11 != r3) goto L_0x0894
            int r3 = com.google.android.gms.internal.measurement.G3.l(r2, r7, r13, r6)
            r9 = r1
            r5 = r3
            goto L_0x0841
        L_0x0894:
            if (r11 != 0) goto L_0x0873
            r3 = r7
            r5 = r13
            int r5 = com.google.android.gms.internal.measurement.G3.b(r1, r2, r3, r4, r5, r6)
            r9 = r1
            r1 = r3
            goto L_0x095b
        L_0x08a0:
            r2 = r19
            r19 = r9
            r9 = r2
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r5 = r1
            r1 = r4
            r26 = r6
            r25 = r14
            r3 = 2
            r4 = r35
            r6 = r37
            if (r11 != r3) goto L_0x08d6
            r3 = r5
            com.google.android.gms.internal.measurement.J4 r3 = (com.google.android.gms.internal.measurement.J4) r3
            int r5 = com.google.android.gms.internal.measurement.G3.r(r2, r1, r6)
            int r7 = r6.f1502a
            int r7 = r7 + r5
        L_0x08c1:
            if (r5 >= r7) goto L_0x08cd
            int r5 = com.google.android.gms.internal.measurement.G3.s(r2, r5, r6)
            long r13 = r6.f1503b
            r3.g(r13)
            goto L_0x08c1
        L_0x08cd:
            if (r5 != r7) goto L_0x08d1
            goto L_0x095b
        L_0x08d1:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x08d6:
            if (r11 != 0) goto L_0x095a
            r3 = r5
            com.google.android.gms.internal.measurement.J4 r3 = (com.google.android.gms.internal.measurement.J4) r3
            int r5 = com.google.android.gms.internal.measurement.G3.s(r2, r1, r6)
            long r7 = r6.f1503b
            r3.g(r7)
        L_0x08e4:
            if (r5 >= r4) goto L_0x095b
            int r7 = com.google.android.gms.internal.measurement.G3.r(r2, r5, r6)
            int r8 = r6.f1502a
            if (r9 != r8) goto L_0x095b
            int r5 = com.google.android.gms.internal.measurement.G3.s(r2, r7, r6)
            long r7 = r6.f1503b
            r3.g(r7)
            goto L_0x08e4
        L_0x08f8:
            r2 = r19
            r19 = r9
            r9 = r2
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r5 = r1
            r1 = r4
            r26 = r6
            r25 = r14
            r3 = 2
            r4 = r35
            r6 = r37
            if (r11 != r3) goto L_0x0922
            android.support.v4.media.a.a(r5)
            int r1 = com.google.android.gms.internal.measurement.G3.r(r2, r1, r6)
            int r3 = r6.f1502a
            int r1 = r1 + r3
            int r2 = r2.length
            if (r1 <= r2) goto L_0x0921
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0921:
            throw r16
        L_0x0922:
            r3 = 5
            if (r11 == r3) goto L_0x0926
            goto L_0x095a
        L_0x0926:
            android.support.v4.media.a.a(r5)
            com.google.android.gms.internal.measurement.G3.n(r2, r1)
            throw r16
        L_0x092d:
            r2 = r19
            r19 = r9
            r9 = r2
            r2 = r15
            r15 = r12
            r12 = r2
            r2 = r33
            r5 = r1
            r1 = r4
            r26 = r6
            r25 = r14
            r3 = 2
            r4 = r35
            r6 = r37
            if (r11 != r3) goto L_0x0957
            android.support.v4.media.a.a(r5)
            int r1 = com.google.android.gms.internal.measurement.G3.r(r2, r1, r6)
            int r3 = r6.f1502a
            int r1 = r1 + r3
            int r2 = r2.length
            if (r1 <= r2) goto L_0x0956
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x0956:
            throw r16
        L_0x0957:
            r3 = 1
            if (r11 == r3) goto L_0x0976
        L_0x095a:
            r5 = r1
        L_0x095b:
            if (r5 != r1) goto L_0x0965
            r10 = r36
            r3 = r2
            r4 = r5
        L_0x0961:
            r14 = r25
            goto L_0x0be8
        L_0x0965:
            r1 = r5
            r5 = r4
            r4 = r1
            r3 = r2
            r2 = r12
            r7 = r15
            r1 = r21
            r14 = r25
            r8 = r26
            r15 = r9
            r9 = r19
            goto L_0x0018
        L_0x0976:
            android.support.v4.media.a.a(r5)
            com.google.android.gms.internal.measurement.G3.a(r2, r1)
            throw r16
        L_0x097d:
            r1 = r19
            r19 = r9
            r9 = r1
            r1 = r15
            r15 = r12
            r12 = r1
            r1 = r4
            r21 = r13
            r25 = r14
            r14 = r2
            r13 = r6
            r2 = r33
            r6 = r37
            r4 = 50
            if (r3 != r4) goto L_0x09de
            r4 = 2
            if (r11 != r4) goto L_0x09d5
            sun.misc.Unsafe r3 = f1778r
            java.lang.Object r4 = r0.Q(r13)
            java.lang.Object r5 = r3.getObject(r12, r7)
            com.google.android.gms.internal.measurement.R4 r9 = r0.f1794p
            boolean r9 = r9.f(r5)
            if (r9 == 0) goto L_0x09b8
            com.google.android.gms.internal.measurement.R4 r9 = r0.f1794p
            java.lang.Object r9 = r9.d(r4)
            com.google.android.gms.internal.measurement.R4 r10 = r0.f1794p
            r10.e(r9, r5)
            r3.putObject(r12, r7, r9)
            r5 = r9
        L_0x09b8:
            com.google.android.gms.internal.measurement.R4 r3 = r0.f1794p
            r3.a(r4)
            com.google.android.gms.internal.measurement.R4 r3 = r0.f1794p
            r3.b(r5)
            int r1 = com.google.android.gms.internal.measurement.G3.r(r2, r1, r6)
            int r2 = r6.f1502a
            if (r2 < 0) goto L_0x09d0
            int r1 = r35 - r1
            if (r2 <= r1) goto L_0x09cf
            goto L_0x09d0
        L_0x09cf:
            throw r16
        L_0x09d0:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.g()
            throw r1
        L_0x09d5:
            r10 = r36
            r4 = r1
            r3 = r2
            r26 = r13
            r21 = r14
            goto L_0x0961
        L_0x09de:
            sun.misc.Unsafe r4 = f1778r
            int r26 = r13 + 2
            r20 = r20[r26]
            r26 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r20 & r17
            long r1 = (long) r1
            switch(r3) {
                case 51: goto L_0x0bc3;
                case 52: goto L_0x0ba5;
                case 53: goto L_0x0b89;
                case 54: goto L_0x0b89;
                case 55: goto L_0x0b6d;
                case 56: goto L_0x0b50;
                case 57: goto L_0x0b33;
                case 58: goto L_0x0b0c;
                case 59: goto L_0x0acd;
                case 60: goto L_0x0aac;
                case 61: goto L_0x0a98;
                case 62: goto L_0x0b6d;
                case 63: goto L_0x0a65;
                case 64: goto L_0x0b33;
                case 65: goto L_0x0b50;
                case 66: goto L_0x0a49;
                case 67: goto L_0x0a23;
                case 68: goto L_0x09fa;
                default: goto L_0x09ef;
            }
        L_0x09ef:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
        L_0x09f6:
            r21 = r14
            goto L_0x0be1
        L_0x09fa:
            r3 = 3
            if (r11 != r3) goto L_0x09ef
            java.lang.Object r1 = r0.p(r12, r15, r13)
            r2 = r9 & -8
            r2 = r2 | 4
            r6 = r2
            com.google.android.gms.internal.measurement.o5 r2 = r0.O(r13)
            r3 = r33
            r5 = r35
            r7 = r37
            r4 = r26
            int r2 = com.google.android.gms.internal.measurement.G3.i(r1, r2, r3, r4, r5, r6, r7)
            r5 = r4
            r6 = r7
            r0.v(r12, r15, r13, r1)
            r4 = r2
        L_0x0a1c:
            r26 = r13
            r21 = r14
            r13 = r5
            goto L_0x0be2
        L_0x0a23:
            r3 = r33
            r5 = r26
            if (r11 != 0) goto L_0x0a42
            int r11 = com.google.android.gms.internal.measurement.G3.s(r3, r5, r6)
            r34 = r11
            long r10 = r6.f1503b
            long r10 = com.google.android.gms.internal.measurement.W3.b(r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r4.putObject(r12, r7, r10)
            r4.putInt(r12, r1, r15)
        L_0x0a3f:
            r4 = r34
            goto L_0x0a1c
        L_0x0a42:
            r26 = r13
            r21 = r14
            r13 = r5
            goto L_0x0be1
        L_0x0a49:
            r3 = r33
            r5 = r26
            if (r11 != 0) goto L_0x0a42
            int r10 = com.google.android.gms.internal.measurement.G3.r(r3, r5, r6)
            int r11 = r6.f1502a
            int r11 = com.google.android.gms.internal.measurement.W3.a(r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.putObject(r12, r7, r11)
            r4.putInt(r12, r1, r15)
        L_0x0a63:
            r4 = r10
            goto L_0x0a1c
        L_0x0a65:
            r3 = r33
            r5 = r26
            if (r11 != 0) goto L_0x0a42
            int r10 = com.google.android.gms.internal.measurement.G3.r(r3, r5, r6)
            int r11 = r6.f1502a
            r34 = r10
            com.google.android.gms.internal.measurement.w4 r10 = r0.N(r13)
            if (r10 == 0) goto L_0x0a8d
            boolean r10 = r10.a(r11)
            if (r10 == 0) goto L_0x0a80
            goto L_0x0a8d
        L_0x0a80:
            com.google.android.gms.internal.measurement.D5 r1 = I(r12)
            long r7 = (long) r11
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r1.e(r9, r2)
            goto L_0x0a3f
        L_0x0a8d:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r4.putObject(r12, r7, r10)
            r4.putInt(r12, r1, r15)
            goto L_0x0a3f
        L_0x0a98:
            r3 = r33
            r5 = r26
            r10 = 2
            if (r11 != r10) goto L_0x0a42
            int r10 = com.google.android.gms.internal.measurement.G3.k(r3, r5, r6)
            java.lang.Object r11 = r6.f1504c
            r4.putObject(r12, r7, r11)
            r4.putInt(r12, r1, r15)
            goto L_0x0a63
        L_0x0aac:
            r3 = r33
            r5 = r26
            r10 = 2
            if (r11 != r10) goto L_0x0a42
            java.lang.Object r1 = r0.p(r12, r15, r13)
            com.google.android.gms.internal.measurement.o5 r2 = r0.O(r13)
            r4 = r5
            r5 = r35
            int r2 = com.google.android.gms.internal.measurement.G3.j(r1, r2, r3, r4, r5, r6)
            r0.v(r12, r15, r13, r1)
            r26 = r13
            r21 = r14
            r13 = r4
            r4 = r2
            goto L_0x0be2
        L_0x0acd:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r10 = 2
            if (r11 != r10) goto L_0x09f6
            int r10 = com.google.android.gms.internal.measurement.G3.r(r3, r13, r6)
            int r11 = r6.f1502a
            if (r11 != 0) goto L_0x0ae5
            r4.putObject(r12, r7, r5)
            r21 = r14
            goto L_0x0b06
        L_0x0ae5:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r21 & r5
            if (r5 == 0) goto L_0x0af9
            int r5 = r10 + r11
            boolean r5 = com.google.android.gms.internal.measurement.J5.e(r3, r10, r5)
            if (r5 == 0) goto L_0x0af4
            goto L_0x0af9
        L_0x0af4:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.c()
            throw r1
        L_0x0af9:
            java.lang.String r5 = new java.lang.String
            r21 = r14
            java.nio.charset.Charset r14 = com.google.android.gms.internal.measurement.C0684u4.f2196a
            r5.<init>(r3, r10, r11, r14)
            r4.putObject(r12, r7, r5)
            int r10 = r10 + r11
        L_0x0b06:
            r4.putInt(r12, r1, r15)
            r4 = r10
            goto L_0x0be2
        L_0x0b0c:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            if (r11 != 0) goto L_0x0be1
            int r5 = com.google.android.gms.internal.measurement.G3.s(r3, r13, r6)
            long r10 = r6.f1503b
            int r14 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r14 == 0) goto L_0x0b24
            r24 = 1
            goto L_0x0b26
        L_0x0b24:
            r24 = 0
        L_0x0b26:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r24)
            r4.putObject(r12, r7, r10)
            r4.putInt(r12, r1, r15)
        L_0x0b30:
            r4 = r5
            goto L_0x0be2
        L_0x0b33:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            r5 = 5
            if (r11 != r5) goto L_0x0be1
            int r5 = com.google.android.gms.internal.measurement.G3.q(r3, r13)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.putObject(r12, r7, r5)
            int r5 = r13 + 4
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0b50:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            r5 = 1
            if (r11 != r5) goto L_0x0be1
            long r10 = com.google.android.gms.internal.measurement.G3.t(r3, r13)
            java.lang.Long r5 = java.lang.Long.valueOf(r10)
            r4.putObject(r12, r7, r5)
            int r5 = r13 + 8
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0b6d:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            if (r11 != 0) goto L_0x0be1
            int r5 = com.google.android.gms.internal.measurement.G3.r(r3, r13, r6)
            int r10 = r6.f1502a
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r4.putObject(r12, r7, r10)
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0b89:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            if (r11 != 0) goto L_0x0be1
            int r5 = com.google.android.gms.internal.measurement.G3.s(r3, r13, r6)
            long r10 = r6.f1503b
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r4.putObject(r12, r7, r10)
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0ba5:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            r5 = 5
            if (r11 != r5) goto L_0x0be1
            float r5 = com.google.android.gms.internal.measurement.G3.n(r3, r13)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.putObject(r12, r7, r5)
            int r5 = r13 + 4
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0bc3:
            r3 = r26
            r26 = r13
            r13 = r3
            r3 = r33
            r21 = r14
            r5 = 1
            if (r11 != r5) goto L_0x0be1
            double r10 = com.google.android.gms.internal.measurement.G3.a(r3, r13)
            java.lang.Double r5 = java.lang.Double.valueOf(r10)
            r4.putObject(r12, r7, r5)
            int r5 = r13 + 8
            r4.putInt(r12, r1, r15)
            goto L_0x0b30
        L_0x0be1:
            r4 = r13
        L_0x0be2:
            r10 = r36
            if (r4 != r13) goto L_0x0c43
            goto L_0x0961
        L_0x0be8:
            if (r9 != r10) goto L_0x0bf8
            if (r10 != 0) goto L_0x0bed
            goto L_0x0bf8
        L_0x0bed:
            r13 = r35
            r15 = r9
            r6 = r4
            r9 = r19
        L_0x0bf3:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0c5f
        L_0x0bf8:
            boolean r1 = r0.f1784f
            if (r1 == 0) goto L_0x0c24
            com.google.android.gms.internal.measurement.f4 r1 = r6.f1505d
            com.google.android.gms.internal.measurement.f4 r2 = com.google.android.gms.internal.measurement.C0556f4.f1896c
            if (r1 == r2) goto L_0x0c24
            com.google.android.gms.internal.measurement.Z4 r6 = r0.f1783e
            com.google.android.gms.internal.measurement.E5 r7 = r0.f1792n
            r8 = r37
            r2 = r3
            r3 = r4
            r1 = r9
            r5 = r12
            r4 = r35
            int r3 = com.google.android.gms.internal.measurement.G3.d(r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r37
            r4 = r3
            r2 = r5
            r7 = r15
            r9 = r19
            r8 = r26
            r3 = r33
            r5 = r35
        L_0x0c1f:
            r15 = r1
            r1 = r21
            goto L_0x0018
        L_0x0c24:
            r3 = r4
            r1 = r9
            com.google.android.gms.internal.measurement.D5 r5 = I(r12)
            r2 = r33
            r4 = r35
            r6 = r37
            int r3 = com.google.android.gms.internal.measurement.G3.c(r1, r2, r3, r4, r5, r6)
            r5 = r4
            r2 = r12
            r7 = r15
            r9 = r19
            r8 = r26
            r15 = r1
            r4 = r3
            r1 = r21
            r3 = r33
            goto L_0x0018
        L_0x0c43:
            r1 = r9
            r3 = r33
            r5 = r35
            r6 = r37
            r2 = r12
            r7 = r15
            r9 = r19
            r14 = r25
            r8 = r26
            goto L_0x0c1f
        L_0x0c53:
            r10 = r36
            r21 = r1
            r12 = r2
            r13 = r5
            r19 = r9
            r25 = r14
            r6 = r4
            goto L_0x0bf3
        L_0x0c5f:
            if (r9 == r8) goto L_0x0c67
            long r1 = (long) r9
            r9 = r21
            r9.putInt(r12, r1, r14)
        L_0x0c67:
            int r1 = r0.f1788j
            r7 = r1
            r3 = r16
        L_0x0c6c:
            int r1 = r0.f1789k
            if (r7 >= r1) goto L_0x0c83
            int[] r1 = r0.f1787i
            r2 = r1[r7]
            com.google.android.gms.internal.measurement.E5 r4 = r0.f1792n
            r5 = r32
            r1 = r12
            java.lang.Object r2 = r0.q(r1, r2, r3, r4, r5)
            r3 = r2
            com.google.android.gms.internal.measurement.D5 r3 = (com.google.android.gms.internal.measurement.D5) r3
            int r7 = r7 + 1
            goto L_0x0c6c
        L_0x0c83:
            r1 = r12
            if (r3 == 0) goto L_0x0c8b
            com.google.android.gms.internal.measurement.E5 r2 = r0.f1792n
            r2.h(r1, r3)
        L_0x0c8b:
            if (r10 != 0) goto L_0x0c95
            if (r6 != r13) goto L_0x0c90
            goto L_0x0c99
        L_0x0c90:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.e()
            throw r1
        L_0x0c95:
            if (r6 > r13) goto L_0x0c9a
            if (r15 != r10) goto L_0x0c9a
        L_0x0c99:
            return r6
        L_0x0c9a:
            com.google.android.gms.internal.measurement.B4 r1 = com.google.android.gms.internal.measurement.B4.e()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.C0530c5.l(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.J3):int");
    }
}
