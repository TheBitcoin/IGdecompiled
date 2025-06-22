package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i4, int i5) {
        int i6 = i4 + i5;
        boolean z4 = false;
        if ((i4 >= 0) == (i5 >= 0)) {
            boolean z5 = i4 >= 0;
            if (i6 >= 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i6;
    }

    public static double clamp(double d5, double d6, double d7) {
        if (d5 < d6) {
            return d6;
        }
        return d5 > d7 ? d7 : d5;
    }

    public static int decrementExact(int i4) {
        if (i4 != Integer.MIN_VALUE) {
            return i4 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i4) {
        if (i4 != Integer.MAX_VALUE) {
            return i4 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i4, int i5) {
        int i6 = i4 * i5;
        if (i4 == 0 || i5 == 0 || (i6 / i4 == i5 && i6 / i5 == i4)) {
            return i6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i4) {
        if (i4 != Integer.MIN_VALUE) {
            return -i4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i4, int i5) {
        int i6 = i4 - i5;
        boolean z4 = false;
        if ((i4 < 0) != (i5 < 0)) {
            boolean z5 = i4 < 0;
            if (i6 < 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i6;
    }

    public static int toIntExact(long j4) {
        if (j4 <= 2147483647L && j4 >= -2147483648L) {
            return (int) j4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long addExact(long j4, long j5) {
        long j6 = j4 + j5;
        boolean z4 = false;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if ((i4 >= 0) == (j5 >= 0)) {
            boolean z5 = i4 >= 0;
            if (j6 >= 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j6;
    }

    public static float clamp(float f4, float f5, float f6) {
        if (f4 < f5) {
            return f5;
        }
        return f4 > f6 ? f6 : f4;
    }

    public static long decrementExact(long j4) {
        if (j4 != Long.MIN_VALUE) {
            return j4 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j4) {
        if (j4 != Long.MAX_VALUE) {
            return j4 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j4) {
        if (j4 != Long.MIN_VALUE) {
            return -j4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j4, long j5) {
        long j6 = j4 - j5;
        boolean z4 = false;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if ((i4 < 0) != (j5 < 0)) {
            boolean z5 = i4 < 0;
            if (j6 < 0) {
                z4 = true;
            }
            if (z5 != z4) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j6;
    }

    public static int clamp(int i4, int i5, int i6) {
        if (i4 < i5) {
            return i5;
        }
        return i4 > i6 ? i6 : i4;
    }

    public static long multiplyExact(long j4, long j5) {
        long j6 = j4 * j5;
        if (j4 == 0 || j5 == 0 || (j6 / j4 == j5 && j6 / j5 == j4)) {
            return j6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j4, long j5, long j6) {
        if (j4 < j5) {
            return j5;
        }
        return j4 > j6 ? j6 : j4;
    }
}
