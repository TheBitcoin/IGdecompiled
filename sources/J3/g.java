package j3;

abstract class g extends f {
    public static int a(int i4, int i5) {
        if (i4 < i5) {
            return i5;
        }
        return i4;
    }

    public static long b(long j4, long j5) {
        if (j4 < j5) {
            return j5;
        }
        return j4;
    }

    public static int c(int i4, int i5) {
        if (i4 > i5) {
            return i5;
        }
        return i4;
    }

    public static long d(long j4, long j5) {
        if (j4 > j5) {
            return j5;
        }
        return j4;
    }

    public static float e(float f4, float f5, float f6) {
        if (f5 > f6) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f6 + " is less than minimum " + f5 + '.');
        } else if (f4 < f5) {
            return f5;
        } else {
            if (f4 > f6) {
                return f6;
            }
            return f4;
        }
    }

    public static int f(int i4, int i5, int i6) {
        if (i5 > i6) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i6 + " is less than minimum " + i5 + '.');
        } else if (i4 < i5) {
            return i5;
        } else {
            if (i4 > i6) {
                return i6;
            }
            return i4;
        }
    }

    public static long g(long j4, long j5, long j6) {
        if (j5 > j6) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j6 + " is less than minimum " + j5 + '.');
        } else if (j4 < j5) {
            return j5;
        } else {
            if (j4 > j6) {
                return j6;
            }
            return j4;
        }
    }

    public static b h(int i4, int i5) {
        return b.f20919d.a(i4, i5, -1);
    }

    public static d i(int i4, int i5) {
        if (i5 <= Integer.MIN_VALUE) {
            return d.f20927e.a();
        }
        return new d(i4, i5 - 1);
    }
}
