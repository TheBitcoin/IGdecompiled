package l0;

public abstract class h {
    private static String a(int i4, int i5, String str) {
        if (i4 < 0) {
            return j.a("%s (%s) must not be negative", str, Integer.valueOf(i4));
        } else if (i5 >= 0) {
            return j.a("%s (%s) must be less than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static String b(int i4, int i5, String str) {
        if (i4 < 0) {
            return j.a("%s (%s) must not be negative", str, Integer.valueOf(i4));
        } else if (i5 >= 0) {
            return j.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i4), Integer.valueOf(i5));
        } else {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static String c(int i4, int i5, int i6) {
        if (i4 < 0 || i4 > i6) {
            return b(i4, i6, "start index");
        }
        if (i5 < 0 || i5 > i6) {
            return b(i5, i6, "end index");
        }
        return j.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i5), Integer.valueOf(i4));
    }

    public static void d(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z4, String str, int i4, int i5) {
        if (!z4) {
            throw new IllegalArgumentException(j.a(str, Integer.valueOf(i4), Integer.valueOf(i5)));
        }
    }

    public static int g(int i4, int i5) {
        return h(i4, i5, "index");
    }

    public static int h(int i4, int i5, String str) {
        if (i4 >= 0 && i4 < i5) {
            return i4;
        }
        throw new IndexOutOfBoundsException(a(i4, i5, str));
    }

    public static Object i(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object j(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int k(int i4, int i5) {
        return l(i4, i5, "index");
    }

    public static int l(int i4, int i5, String str) {
        if (i4 >= 0 && i4 <= i5) {
            return i4;
        }
        throw new IndexOutOfBoundsException(b(i4, i5, str));
    }

    public static void m(int i4, int i5, int i6) {
        if (i4 < 0 || i5 < i4 || i5 > i6) {
            throw new IndexOutOfBoundsException(c(i4, i5, i6));
        }
    }

    public static void n(boolean z4) {
        if (!z4) {
            throw new IllegalStateException();
        }
    }

    public static void o(boolean z4, Object obj) {
        if (!z4) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void p(boolean z4, String str, Object obj) {
        if (!z4) {
            throw new IllegalStateException(j.a(str, obj));
        }
    }
}
