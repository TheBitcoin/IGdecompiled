package S2;

import j3.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;

/* renamed from: S2.q  reason: case insensitive filesystem */
abstract class C1603q extends C1602p {
    public static final Collection g(Object[] objArr) {
        m.e(objArr, "<this>");
        return new C1592f(objArr, false);
    }

    public static List h() {
        return A.f8231a;
    }

    public static d i(Collection collection) {
        m.e(collection, "<this>");
        return new d(0, collection.size() - 1);
    }

    public static int j(List list) {
        m.e(list, "<this>");
        return list.size() - 1;
    }

    public static List k(Object... objArr) {
        m.e(objArr, "elements");
        if (objArr.length > 0) {
            return C1597k.c(objArr);
        }
        return h();
    }

    public static List l(Object... objArr) {
        m.e(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new C1592f(objArr, true));
    }

    public static final List m(List list) {
        m.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return list;
        }
        return C1602p.e(list.get(0));
    }

    public static void n() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void o() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
