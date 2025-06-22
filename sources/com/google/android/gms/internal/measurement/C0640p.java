package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.p  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0640p {
    public static C0663s a(C0614m mVar, C0663s sVar, Z2 z22, List list) {
        if (mVar.g(sVar.E())) {
            C0663s c5 = mVar.c(sVar.E());
            if (c5 instanceof C0623n) {
                return ((C0623n) c5).a(z22, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", new Object[]{sVar.E()}));
        } else if ("hasOwnProperty".equals(sVar.E())) {
            C0690v2.g("hasOwnProperty", 1, list);
            if (mVar.g(z22.b((C0663s) list.get(0)).E())) {
                return C0663s.f2143g0;
            }
            return C0663s.f2144h0;
        } else {
            throw new IllegalArgumentException(String.format("Object has no function %s", new Object[]{sVar.E()}));
        }
    }

    public static Iterator b(Map map) {
        return new C0632o(map.keySet().iterator());
    }
}
