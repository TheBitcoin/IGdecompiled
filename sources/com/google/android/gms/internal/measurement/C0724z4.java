package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.z4  reason: case insensitive filesystem */
public final class C0724z4 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private final C0533d f2270c;

    public C0724z4(C0533d dVar) {
        super("internal.eventLogger");
        this.f2270c = dVar;
    }

    public final C0663s a(Z2 z22, List list) {
        Map map;
        C0690v2.g(this.f2065a, 3, list);
        String E4 = z22.b((C0663s) list.get(0)).E();
        long a5 = (long) C0690v2.a(z22.b((C0663s) list.get(1)).D().doubleValue());
        C0663s b5 = z22.b((C0663s) list.get(2));
        if (b5 instanceof r) {
            map = C0690v2.e((r) b5);
        } else {
            map = new HashMap();
        }
        this.f2270c.c(E4, a5, map);
        return C0663s.f2138b0;
    }
}
