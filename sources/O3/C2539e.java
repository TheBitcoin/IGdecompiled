package O3;

import N3.W;
import kotlin.jvm.internal.m;

/* renamed from: O3.e  reason: case insensitive filesystem */
public abstract class C2539e {
    public static final int a(int[] iArr, int i4, int i5, int i6) {
        m.e(iArr, "<this>");
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int i9 = iArr[i8];
            if (i9 < i4) {
                i5 = i8 + 1;
            } else if (i9 <= i4) {
                return i8;
            } else {
                i7 = i8 - 1;
            }
        }
        return (-i5) - 1;
    }

    public static final int b(W w4, int i4) {
        m.e(w4, "<this>");
        int a5 = a(w4.O(), i4 + 1, 0, w4.P().length);
        if (a5 >= 0) {
            return a5;
        }
        return ~a5;
    }
}
