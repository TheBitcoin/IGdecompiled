package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.q5  reason: case insensitive filesystem */
abstract class C0654q5 {

    /* renamed from: a  reason: collision with root package name */
    private static final E5 f2116a = new G5();

    static int A(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * C0520b4.P(i4, 0);
    }

    static int B(List list) {
        return list.size() << 3;
    }

    public static void C(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.E(i4, list, z4);
        }
    }

    static int D(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * C0520b4.s0(i4));
    }

    static int E(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.g0(v4Var.g(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.g0(((Integer) list.get(i4)).intValue());
            i4++;
        }
        return i6;
    }

    public static void F(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.z(i4, list, z4);
        }
    }

    static int G(int i4, List list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        return H(list) + (list.size() * C0520b4.s0(i4));
    }

    static int H(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.a0(j4.d(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.a0(((Long) list.get(i4)).longValue());
            i4++;
        }
        return i6;
    }

    public static void I(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.L(i4, list, z4);
        }
    }

    static int J(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return K(list) + (size * C0520b4.s0(i4));
    }

    static int K(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.o0(v4Var.g(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.o0(((Integer) list.get(i4)).intValue());
            i4++;
        }
        return i6;
    }

    public static void L(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.H(i4, list, z4);
        }
    }

    static int M(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * C0520b4.s0(i4));
    }

    static int N(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.j0(j4.d(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.j0(((Long) list.get(i4)).longValue());
            i4++;
        }
        return i6;
    }

    public static void O(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.k(i4, list, z4);
        }
    }

    static int P(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return Q(list) + (size * C0520b4.s0(i4));
    }

    static int Q(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.v0(v4Var.g(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.v0(((Integer) list.get(i4)).intValue());
            i4++;
        }
        return i6;
    }

    public static void R(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.c(i4, list, z4);
        }
    }

    static int S(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * C0520b4.s0(i4));
    }

    static int T(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof J4) {
            J4 j4 = (J4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.n0(j4.d(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.n0(((Long) list.get(i4)).longValue());
            i4++;
        }
        return i6;
    }

    public static void U(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.t(i4, list, z4);
        }
    }

    public static void V(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.u(i4, list, z4);
        }
    }

    public static void W(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.q(i4, list, z4);
        }
    }

    public static void X(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.G(i4, list, z4);
        }
    }

    public static void Y(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.C(i4, list, z4);
        }
    }

    static int a(int i4, Object obj, C0638o5 o5Var) {
        return C0520b4.R(i4, (Z4) obj, o5Var);
    }

    static int b(int i4, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int s02 = size * C0520b4.s0(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            s02 += C0520b4.A((K3) list.get(i5));
        }
        return s02;
    }

    static int c(int i4, List list, C0638o5 o5Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += C0520b4.x(i4, (Z4) list.get(i6), o5Var);
        }
        return i5;
    }

    static int d(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * C0520b4.z(i4, true);
    }

    static int e(List list) {
        return list.size();
    }

    public static E5 f() {
        return f2116a;
    }

    static Object g(Object obj, int i4, int i5, Object obj2, E5 e5) {
        if (obj2 == null) {
            obj2 = e5.i(obj);
        }
        e5.f(obj2, i4, (long) i5);
        return obj2;
    }

    static Object h(Object obj, int i4, List list, C0700w4 w4Var, Object obj2, E5 e5) {
        if (w4Var == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = (Integer) list.get(i6);
                int intValue = num.intValue();
                if (w4Var.a(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    obj2 = g(obj, i4, intValue, obj2, e5);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!w4Var.a(intValue2)) {
                obj2 = g(obj, i4, intValue2, obj2, e5);
                it.remove();
            }
        }
        return obj2;
    }

    public static void i(int i4, List list, W5 w5) {
        if (list != null && !list.isEmpty()) {
            w5.O(i4, list);
        }
    }

    public static void j(int i4, List list, W5 w5, C0638o5 o5Var) {
        if (list != null && !list.isEmpty()) {
            w5.l(i4, list, o5Var);
        }
    }

    public static void k(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.i(i4, list, z4);
        }
    }

    static void l(C0574h4 h4Var, Object obj, Object obj2) {
        C0610l4 b5 = h4Var.b(obj2);
        if (!b5.f1985a.isEmpty()) {
            h4Var.e(obj).f(b5);
        }
    }

    static void m(R4 r4, Object obj, Object obj2, long j4) {
        F5.j(obj, j4, r4.e(F5.B(obj, j4), F5.B(obj2, j4)));
    }

    static void n(E5 e5, Object obj, Object obj2) {
        e5.j(obj, e5.b(e5.k(obj), e5.k(obj2)));
    }

    public static void o(Class cls) {
        C0668s4.class.isAssignableFrom(cls);
    }

    static boolean p(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    static int q(int i4, List list) {
        int C4;
        int C5;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int s02 = C0520b4.s0(i4) * size;
        if (list instanceof G4) {
            G4 g4 = (G4) list;
            while (i5 < size) {
                Object a5 = g4.a(i5);
                if (a5 instanceof K3) {
                    C5 = C0520b4.A((K3) a5);
                } else {
                    C5 = C0520b4.C((String) a5);
                }
                s02 += C5;
                i5++;
            }
            return s02;
        }
        while (i5 < size) {
            Object obj = list.get(i5);
            if (obj instanceof K3) {
                C4 = C0520b4.A((K3) obj);
            } else {
                C4 = C0520b4.C((String) obj);
            }
            s02 += C4;
            i5++;
        }
        return s02;
    }

    static int r(int i4, List list, C0638o5 o5Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int s02 = C0520b4.s0(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            s02 += C0520b4.g((Z4) list.get(i5), o5Var);
        }
        return s02;
    }

    static int s(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return t(list) + (size * C0520b4.s0(i4));
    }

    static int t(List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof C0692v4) {
            C0692v4 v4Var = (C0692v4) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += C0520b4.X(v4Var.g(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += C0520b4.X(((Integer) list.get(i4)).intValue());
            i4++;
        }
        return i6;
    }

    public static void u(int i4, List list, W5 w5) {
        if (list != null && !list.isEmpty()) {
            w5.I(i4, list);
        }
    }

    public static void v(int i4, List list, W5 w5, C0638o5 o5Var) {
        if (list != null && !list.isEmpty()) {
            w5.e(i4, list, o5Var);
        }
    }

    public static void w(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.r(i4, list, z4);
        }
    }

    static int x(int i4, List list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * C0520b4.h0(i4, 0);
    }

    static int y(List list) {
        return list.size() << 2;
    }

    public static void z(int i4, List list, W5 w5, boolean z4) {
        if (list != null && !list.isEmpty()) {
            w5.p(i4, list, z4);
        }
    }
}
