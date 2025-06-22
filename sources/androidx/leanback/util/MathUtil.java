package androidx.leanback.util;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MathUtil {
    private MathUtil() {
    }

    public static int safeLongToInt(long j4) {
        int i4 = (int) j4;
        if (((long) i4) == j4) {
            return i4;
        }
        throw new ArithmeticException("Input overflows int.\n");
    }
}
