package j$.util;

import java.util.Arrays;

public final class Objects {
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static String toString(Object obj) {
        return String.valueOf(obj);
    }

    public static <T> T requireNonNull(T t4) {
        t4.getClass();
        return t4;
    }

    public static <T> T requireNonNull(T t4, String str) {
        if (t4 != null) {
            return t4;
        }
        throw new NullPointerException(str);
    }
}
