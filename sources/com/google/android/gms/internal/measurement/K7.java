package com.google.android.gms.internal.measurement;

import java.util.List;

public final class K7 extends C0623n {

    /* renamed from: c  reason: collision with root package name */
    private C0515b f1519c;

    public K7(C0515b bVar) {
        super("internal.registerCallback");
        this.f1519c = bVar;
    }

    public final C0663s a(Z2 z22, List list) {
        int i4;
        C0690v2.g(this.f2065a, 3, list);
        String E4 = z22.b((C0663s) list.get(0)).E();
        C0663s b5 = z22.b((C0663s) list.get(1));
        if (b5 instanceof C0671t) {
            C0663s b6 = z22.b((C0663s) list.get(2));
            if (b6 instanceof r) {
                r rVar = (r) b6;
                if (rVar.g("type")) {
                    String E5 = rVar.c("type").E();
                    if (rVar.g("priority")) {
                        i4 = C0690v2.i(rVar.c("priority").D().doubleValue());
                    } else {
                        i4 = 1000;
                    }
                    this.f1519c.c(E4, i4, (C0671t) b5, E5);
                    return C0663s.f2138b0;
                }
                throw new IllegalArgumentException("Undefined rule type");
            }
            throw new IllegalArgumentException("Invalid callback params");
        }
        throw new IllegalArgumentException("Invalid callback type");
    }
}
