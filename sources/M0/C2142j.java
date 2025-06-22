package m0;

import java.util.Arrays;
import l0.f;

/* renamed from: m0.j  reason: case insensitive filesystem */
abstract class C2142j {
    static Object a(int i4) {
        if (i4 < 2 || i4 > 1073741824 || Integer.highestOneBit(i4) != i4) {
            StringBuilder sb = new StringBuilder(52);
            sb.append("must be power of 2 between 2^1 and 2^30: ");
            sb.append(i4);
            throw new IllegalArgumentException(sb.toString());
        } else if (i4 <= 256) {
            return new byte[i4];
        } else {
            if (i4 <= 65536) {
                return new short[i4];
            }
            return new int[i4];
        }
    }

    static int b(int i4, int i5) {
        return i4 & (~i5);
    }

    static int c(int i4, int i5) {
        return i4 & i5;
    }

    static int d(int i4, int i5, int i6) {
        return (i4 & (~i6)) | (i5 & i6);
    }

    static int e(int i4) {
        int i5;
        if (i4 < 32) {
            i5 = 4;
        } else {
            i5 = 2;
        }
        return i5 * (i4 + 1);
    }

    static int f(Object obj, Object obj2, int i4, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i5;
        int i6;
        int c5 = C2145m.c(obj);
        int i7 = c5 & i4;
        int h4 = h(obj3, i7);
        if (h4 == 0) {
            return -1;
        }
        int b5 = b(c5, i4);
        int i8 = -1;
        while (true) {
            i5 = h4 - 1;
            i6 = iArr[i5];
            if (b(i6, i4) != b5 || !f.a(obj, objArr[i5]) || (objArr2 != null && !f.a(obj2, objArr2[i5]))) {
                int c6 = c(i6, i4);
                if (c6 == 0) {
                    return -1;
                }
                int i9 = c6;
                i8 = i5;
                h4 = i9;
            }
        }
        int c7 = c(i6, i4);
        if (i8 == -1) {
            i(obj3, i7, c7);
            return i5;
        }
        iArr[i8] = d(iArr[i8], c7, i4);
        return i5;
    }

    static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    static int h(Object obj, int i4) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i4] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i4] & 65535;
        }
        return ((int[]) obj)[i4];
    }

    static void i(Object obj, int i4, int i5) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i4] = (byte) i5;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i4] = (short) i5;
        } else {
            ((int[]) obj)[i4] = i5;
        }
    }

    static int j(int i4) {
        return Math.max(4, C2145m.a(i4 + 1, 1.0d));
    }
}
