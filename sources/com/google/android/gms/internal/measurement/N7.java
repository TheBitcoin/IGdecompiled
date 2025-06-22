package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class N7 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private final W4 f1583c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f1584d = new HashMap();

    public N7(W4 w4) {
        super("require");
        this.f1583c = w4;
    }

    public final C0663s a(Z2 z22, List list) {
        C0690v2.g("require", 1, list);
        String E4 = z22.b((C0663s) list.get(0)).E();
        if (this.f1584d.containsKey(E4)) {
            return (C0663s) this.f1584d.get(E4);
        }
        C0663s a5 = this.f1583c.a(E4);
        if (a5 instanceof C0623n) {
            this.f1584d.put(E4, (C0623n) a5);
        }
        return a5;
    }
}
