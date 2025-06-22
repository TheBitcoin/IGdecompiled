package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.measurement.b  reason: case insensitive filesystem */
public final class C0515b {

    /* renamed from: a  reason: collision with root package name */
    private final TreeMap f1753a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    private final TreeMap f1754b = new TreeMap();

    private static int a(Z2 z22, C0671t tVar, C0663s sVar) {
        C0663s a5 = tVar.a(z22, Collections.singletonList(sVar));
        if (a5 instanceof C0596k) {
            return C0690v2.i(a5.D().doubleValue());
        }
        return -1;
    }

    public final void b(Z2 z22, C0533d dVar) {
        U5 u5 = new U5(dVar);
        for (Integer num : this.f1753a.keySet()) {
            C0542e eVar = (C0542e) dVar.d().clone();
            int a5 = a(z22, (C0671t) this.f1753a.get(num), u5);
            if (a5 == 2 || a5 == -1) {
                dVar.e(eVar);
            }
        }
        for (Integer num2 : this.f1754b.keySet()) {
            a(z22, (C0671t) this.f1754b.get(num2), u5);
        }
    }

    public final void c(String str, int i4, C0671t tVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f1754b;
        } else if ("edit".equals(str2)) {
            treeMap = this.f1753a;
        } else {
            throw new IllegalStateException("Unknown callback type: " + str2);
        }
        if (treeMap.containsKey(Integer.valueOf(i4))) {
            i4 = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i4), tVar);
    }
}
