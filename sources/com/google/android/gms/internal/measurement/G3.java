package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

abstract class G3 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f1479a = 100;

    static double a(byte[] bArr, int i4) {
        return Double.longBitsToDouble(t(bArr, i4));
    }

    static int b(int i4, byte[] bArr, int i5, int i6, C4 c42, J3 j32) {
        C0692v4 v4Var = (C0692v4) c42;
        int r4 = r(bArr, i5, j32);
        v4Var.j(j32.f1502a);
        while (r4 < i6) {
            int r5 = r(bArr, r4, j32);
            if (i4 != j32.f1502a) {
                break;
            }
            r4 = r(bArr, r5, j32);
            v4Var.j(j32.f1502a);
        }
        return r4;
    }

    static int c(int i4, byte[] bArr, int i5, int i6, D5 d5, J3 j32) {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 == 0) {
                J3 j33 = j32;
                int s4 = s(bArr, i5, j33);
                d5.e(i4, Long.valueOf(j33.f1503b));
                return s4;
            } else if (i7 == 1) {
                d5.e(i4, Long.valueOf(t(bArr, i5)));
                return i5 + 8;
            } else if (i7 == 2) {
                byte[] bArr2 = bArr;
                J3 j34 = j32;
                int r4 = r(bArr2, i5, j34);
                int i8 = j34.f1502a;
                if (i8 < 0) {
                    throw B4.d();
                } else if (i8 <= bArr2.length - r4) {
                    if (i8 == 0) {
                        d5.e(i4, K3.f1515b);
                    } else {
                        d5.e(i4, K3.n(bArr2, r4, i8));
                    }
                    return r4 + i8;
                } else {
                    throw B4.g();
                }
            } else if (i7 == 3) {
                D5 l4 = D5.l();
                int i9 = (i4 & -8) | 4;
                int i10 = j32.f1506e + 1;
                j32.f1506e = i10;
                m(i10);
                int i11 = 0;
                while (true) {
                    if (i5 >= i6) {
                        break;
                    }
                    int r5 = r(bArr, i5, j32);
                    i11 = j32.f1502a;
                    if (i11 == i9) {
                        i5 = r5;
                        break;
                    }
                    i5 = c(i11, bArr, r5, i6, l4, j32);
                }
                int i12 = i6;
                j32.f1506e--;
                if (i5 > i12 || i11 != i9) {
                    throw B4.e();
                }
                d5.e(i4, l4);
                return i5;
            } else if (i7 == 5) {
                d5.e(i4, Integer.valueOf(q(bArr, i5)));
                return i5 + 4;
            } else {
                throw B4.b();
            }
        } else {
            throw B4.b();
        }
    }

    static int d(int i4, byte[] bArr, int i5, int i6, Object obj, Z4 z4, E5 e5, J3 j32) {
        j32.f1505d.b(z4, i4 >>> 3);
        return c(i4, bArr, i5, i6, C0530c5.I(obj), j32);
    }

    static int e(int i4, byte[] bArr, int i5, J3 j32) {
        int i6 = i4 & ModuleDescriptor.MODULE_VERSION;
        int i7 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            j32.f1502a = i6 | (b5 << 7);
            return i7;
        }
        int i8 = i6 | ((b5 & Byte.MAX_VALUE) << 7);
        int i9 = i5 + 2;
        byte b6 = bArr[i7];
        if (b6 >= 0) {
            j32.f1502a = i8 | (b6 << 14);
            return i9;
        }
        int i10 = i8 | ((b6 & Byte.MAX_VALUE) << 14);
        int i11 = i5 + 3;
        byte b7 = bArr[i9];
        if (b7 >= 0) {
            j32.f1502a = i10 | (b7 << 21);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 21);
        int i13 = i5 + 4;
        byte b8 = bArr[i11];
        if (b8 >= 0) {
            j32.f1502a = i12 | (b8 << 28);
            return i13;
        }
        int i14 = i12 | ((b8 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                j32.f1502a = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    static int f(C0638o5 o5Var, int i4, byte[] bArr, int i5, int i6, C4 c42, J3 j32) {
        int i7 = (i4 & -8) | 4;
        C0638o5 o5Var2 = o5Var;
        byte[] bArr2 = bArr;
        int i8 = i6;
        J3 j33 = j32;
        int g4 = g(o5Var2, bArr2, i5, i8, i7, j33);
        c42.add(j33.f1504c);
        while (g4 < i8) {
            int r4 = r(bArr2, g4, j33);
            if (i4 != j33.f1502a) {
                break;
            }
            g4 = g(o5Var2, bArr2, r4, i8, i7, j33);
            c42.add(j33.f1504c);
        }
        return g4;
    }

    private static int g(C0638o5 o5Var, byte[] bArr, int i4, int i5, int i6, J3 j32) {
        Object A4 = o5Var.A();
        C0638o5 o5Var2 = o5Var;
        J3 j33 = j32;
        int i7 = i(A4, o5Var2, bArr, i4, i5, i6, j33);
        o5Var2.c(A4);
        j33.f1504c = A4;
        return i7;
    }

    static int h(C0638o5 o5Var, byte[] bArr, int i4, int i5, J3 j32) {
        Object A4 = o5Var.A();
        C0638o5 o5Var2 = o5Var;
        J3 j33 = j32;
        int j4 = j(A4, o5Var2, bArr, i4, i5, j33);
        o5Var2.c(A4);
        j33.f1504c = A4;
        return j4;
    }

    static int i(Object obj, C0638o5 o5Var, byte[] bArr, int i4, int i5, int i6, J3 j32) {
        int i7 = j32.f1506e + 1;
        j32.f1506e = i7;
        m(i7);
        C0530c5 c5Var = (C0530c5) o5Var;
        Object obj2 = obj;
        int l4 = c5Var.l(obj2, bArr, i4, i5, i6, j32);
        j32.f1506e--;
        j32.f1504c = obj2;
        return l4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int j(java.lang.Object r6, com.google.android.gms.internal.measurement.C0638o5 r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.J3 r11) {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = e(r9, r8, r0, r11)
            int r9 = r11.f1502a
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.f1506e
            int r10 = r10 + 1
            r11.f1506e = r10
            m(r10)
            int r4 = r3 + r9
            r1 = r6
            r0 = r7
            r2 = r8
            r5 = r11
            r0.g(r1, r2, r3, r4, r5)
            int r6 = r5.f1506e
            int r6 = r6 + -1
            r5.f1506e = r6
            r5.f1504c = r1
            return r4
        L_0x002d:
            com.google.android.gms.internal.measurement.B4 r6 = com.google.android.gms.internal.measurement.B4.g()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.G3.j(java.lang.Object, com.google.android.gms.internal.measurement.o5, byte[], int, int, com.google.android.gms.internal.measurement.J3):int");
    }

    static int k(byte[] bArr, int i4, J3 j32) {
        int r4 = r(bArr, i4, j32);
        int i5 = j32.f1502a;
        if (i5 < 0) {
            throw B4.d();
        } else if (i5 > bArr.length - r4) {
            throw B4.g();
        } else if (i5 == 0) {
            j32.f1504c = K3.f1515b;
            return r4;
        } else {
            j32.f1504c = K3.n(bArr, r4, i5);
            return r4 + i5;
        }
    }

    static int l(byte[] bArr, int i4, C4 c42, J3 j32) {
        C0692v4 v4Var = (C0692v4) c42;
        int r4 = r(bArr, i4, j32);
        int i5 = j32.f1502a + r4;
        while (r4 < i5) {
            r4 = r(bArr, r4, j32);
            v4Var.j(j32.f1502a);
        }
        if (r4 == i5) {
            return r4;
        }
        throw B4.g();
    }

    private static void m(int i4) {
        if (i4 >= f1479a) {
            throw B4.f();
        }
    }

    static float n(byte[] bArr, int i4) {
        return Float.intBitsToFloat(q(bArr, i4));
    }

    static int o(C0638o5 o5Var, int i4, byte[] bArr, int i5, int i6, C4 c42, J3 j32) {
        int h4 = h(o5Var, bArr, i5, i6, j32);
        c42.add(j32.f1504c);
        while (h4 < i6) {
            int r4 = r(bArr, h4, j32);
            if (i4 != j32.f1502a) {
                break;
            }
            h4 = h(o5Var, bArr, r4, i6, j32);
            c42.add(j32.f1504c);
        }
        return h4;
    }

    static int p(byte[] bArr, int i4, J3 j32) {
        int r4 = r(bArr, i4, j32);
        int i5 = j32.f1502a;
        if (i5 < 0) {
            throw B4.d();
        } else if (i5 == 0) {
            j32.f1504c = "";
            return r4;
        } else {
            j32.f1504c = J5.d(bArr, r4, i5);
            return r4 + i5;
        }
    }

    static int q(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    static int r(byte[] bArr, int i4, J3 j32) {
        int i5 = i4 + 1;
        byte b5 = bArr[i4];
        if (b5 < 0) {
            return e(b5, bArr, i5, j32);
        }
        j32.f1502a = b5;
        return i5;
    }

    static int s(byte[] bArr, int i4, J3 j32) {
        int i5 = i4 + 1;
        long j4 = (long) bArr[i4];
        if (j4 >= 0) {
            j32.f1503b = j4;
            return i5;
        }
        int i6 = i4 + 2;
        byte b5 = bArr[i5];
        long j5 = (j4 & 127) | (((long) (b5 & Byte.MAX_VALUE)) << 7);
        int i7 = 7;
        while (b5 < 0) {
            int i8 = i6 + 1;
            byte b6 = bArr[i6];
            i7 += 7;
            j5 |= ((long) (b6 & Byte.MAX_VALUE)) << i7;
            int i9 = i8;
            b5 = b6;
            i6 = i9;
        }
        j32.f1503b = j5;
        return i6;
    }

    static long t(byte[] bArr, int i4) {
        return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
    }
}
