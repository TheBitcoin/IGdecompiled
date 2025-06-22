package kotlin.jvm.internal;

import R2.c;
import d3.l;
import d3.p;
import d3.q;
import d3.r;
import d3.t;
import e3.a;
import e3.b;
import java.util.Collection;

public abstract class G {
    public static Collection a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            h(obj, "kotlin.collections.MutableCollection");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i4) {
        if (obj != null && !e(obj, i4)) {
            h(obj, "kotlin.jvm.functions.Function" + i4);
        }
        return obj;
    }

    public static Collection c(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e5) {
            throw g(e5);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof i) {
            return ((i) obj).getArity();
        }
        if (obj instanceof d3.a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof t) {
            return 6;
        }
        return -1;
    }

    public static boolean e(Object obj, int i4) {
        if (!(obj instanceof c) || d(obj) != i4) {
            return false;
        }
        return true;
    }

    private static Throwable f(Throwable th) {
        return m.l(th, G.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        i(str2 + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
