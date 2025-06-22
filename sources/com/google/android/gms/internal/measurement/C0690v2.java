package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.v2  reason: case insensitive filesystem */
public abstract class C0690v2 {
    public static double a(double d5) {
        int i4;
        int i5;
        if (Double.isNaN(d5)) {
            return 0.0d;
        }
        if (Double.isInfinite(d5) || d5 == 0.0d || d5 == -0.0d) {
            return d5;
        }
        if (i4 > 0) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        return ((double) i5) * Math.floor(Math.abs(d5));
    }

    public static int b(Z2 z22) {
        int i4 = i(z22.c("runtime.counter").D().doubleValue() + 1.0d);
        if (i4 <= 1000000) {
            z22.h("runtime.counter", new C0596k(Double.valueOf((double) i4)));
            return i4;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }

    public static Z c(String str) {
        Z z4;
        if (str == null || str.isEmpty()) {
            z4 = null;
        } else {
            z4 = Z.a(Integer.parseInt(str));
        }
        if (z4 != null) {
            return z4;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", new Object[]{str}));
    }

    public static Object d(C0663s sVar) {
        if (C0663s.f2139c0.equals(sVar)) {
            return null;
        }
        if (C0663s.f2138b0.equals(sVar)) {
            return "";
        }
        if (sVar instanceof r) {
            return e((r) sVar);
        }
        if (sVar instanceof C0560g) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((C0560g) sVar).iterator();
            while (it.hasNext()) {
                Object d5 = d((C0663s) it.next());
                if (d5 != null) {
                    arrayList.add(d5);
                }
            }
            return arrayList;
        } else if (!sVar.D().isNaN()) {
            return sVar.D();
        } else {
            return sVar.E();
        }
    }

    public static Map e(r rVar) {
        HashMap hashMap = new HashMap();
        for (String str : rVar.a()) {
            Object d5 = d(rVar.c(str));
            if (d5 != null) {
                hashMap.put(str, d5);
            }
        }
        return hashMap;
    }

    public static void f(Z z4, int i4, List list) {
        g(z4.name(), i4, list);
    }

    public static void g(String str, int i4, List list) {
        if (list.size() != i4) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", new Object[]{str, Integer.valueOf(i4), Integer.valueOf(list.size())}));
        }
    }

    public static boolean h(C0663s sVar, C0663s sVar2) {
        if (!sVar.getClass().equals(sVar2.getClass())) {
            return false;
        }
        if ((sVar instanceof C0719z) || (sVar instanceof C0648q)) {
            return true;
        }
        if (sVar instanceof C0596k) {
            if (Double.isNaN(sVar.D().doubleValue()) || Double.isNaN(sVar2.D().doubleValue())) {
                return false;
            }
            return sVar.D().equals(sVar2.D());
        } else if (sVar instanceof C0679u) {
            return sVar.E().equals(sVar2.E());
        } else {
            if (sVar instanceof C0569h) {
                return sVar.C().equals(sVar2.C());
            }
            if (sVar == sVar2) {
                return true;
            }
            return false;
        }
    }

    public static int i(double d5) {
        int i4;
        int i5;
        if (Double.isNaN(d5) || Double.isInfinite(d5) || d5 == 0.0d) {
            return 0;
        }
        if (i4 > 0) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        return (int) ((long) ((((double) i5) * Math.floor(Math.abs(d5))) % 4.294967296E9d));
    }

    public static void j(Z z4, int i4, List list) {
        k(z4.name(), i4, list);
    }

    public static void k(String str, int i4, List list) {
        if (list.size() < i4) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", new Object[]{str, Integer.valueOf(i4), Integer.valueOf(list.size())}));
        }
    }

    public static boolean l(C0663s sVar) {
        if (sVar == null) {
            return false;
        }
        Double D4 = sVar.D();
        if (D4.isNaN() || D4.doubleValue() < 0.0d || !D4.equals(Double.valueOf(Math.floor(D4.doubleValue())))) {
            return false;
        }
        return true;
    }

    public static long m(double d5) {
        return ((long) i(d5)) & 4294967295L;
    }

    public static void n(String str, int i4, List list) {
        if (list.size() > i4) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", new Object[]{str, Integer.valueOf(i4), Integer.valueOf(list.size())}));
        }
    }
}
