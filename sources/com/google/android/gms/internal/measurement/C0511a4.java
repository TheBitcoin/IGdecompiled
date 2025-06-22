package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.a4  reason: case insensitive filesystem */
public abstract class C0511a4 {
    public static C0663s a(C2 c22) {
        if (c22 == null) {
            return C0663s.f2138b0;
        }
        int i4 = A3.f1400a[c22.H().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        List<C2> L4 = c22.L();
                        ArrayList arrayList = new ArrayList();
                        for (C2 a5 : L4) {
                            arrayList.add(a(a5));
                        }
                        return new C0687v(c22.J(), arrayList);
                    } else if (i4 != 5) {
                        String valueOf = String.valueOf(c22);
                        throw new IllegalStateException("Invalid entity: " + valueOf);
                    } else {
                        throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
                    }
                } else if (c22.N()) {
                    return new C0569h(Boolean.valueOf(c22.M()));
                } else {
                    return new C0569h((Boolean) null);
                }
            } else if (c22.O()) {
                return new C0596k(Double.valueOf(c22.G()));
            } else {
                return new C0596k((Double) null);
            }
        } else if (c22.P()) {
            return new C0679u(c22.K());
        } else {
            return C0663s.f2145i0;
        }
    }

    public static C0663s b(Object obj) {
        if (obj == null) {
            return C0663s.f2139c0;
        }
        if (obj instanceof String) {
            return new C0679u((String) obj);
        }
        if (obj instanceof Double) {
            return new C0596k((Double) obj);
        }
        if (obj instanceof Long) {
            return new C0596k(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new C0596k(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new C0569h((Boolean) obj);
        }
        if (obj instanceof Map) {
            r rVar = new r();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                C0663s b5 = b(map.get(next));
                if (next != null) {
                    if (!(next instanceof String)) {
                        next = next.toString();
                    }
                    rVar.h((String) next, b5);
                }
            }
            return rVar;
        } else if (obj instanceof List) {
            C0560g gVar = new C0560g();
            for (Object b6 : (List) obj) {
                gVar.m(b(b6));
            }
            return gVar;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }
}
