package S2;

import T2.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: S2.p  reason: case insensitive filesystem */
abstract class C1602p {
    public static List a(List list) {
        m.e(list, "builder");
        return ((b) list).u();
    }

    public static final Object[] b(Object[] objArr, boolean z4) {
        m.e(objArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (z4 && m.a(objArr.getClass(), cls)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, cls);
        m.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static List c() {
        return new b(0, 1, (C2103g) null);
    }

    public static List d(int i4) {
        return new b(i4);
    }

    public static List e(Object obj) {
        List singletonList = Collections.singletonList(obj);
        m.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static Object[] f(int i4, Object[] objArr) {
        m.e(objArr, "array");
        if (i4 < objArr.length) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
