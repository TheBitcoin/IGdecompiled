package com.google.android.gms.internal.measurement;

import java.util.List;

public final class J extends A {
    protected J() {
        this.f1393a.add(Z.AND);
        this.f1393a.add(Z.NOT);
        this.f1393a.add(Z.OR);
    }

    public final C0663s b(String str, Z2 z22, List list) {
        int i4 = M.f1531a[C0690v2.c(str).ordinal()];
        if (i4 == 1) {
            C0690v2.f(Z.AND, 2, list);
            C0663s b5 = z22.b((C0663s) list.get(0));
            if (!b5.C().booleanValue()) {
                return b5;
            }
            return z22.b((C0663s) list.get(1));
        } else if (i4 == 2) {
            C0690v2.f(Z.NOT, 1, list);
            return new C0569h(Boolean.valueOf(!z22.b((C0663s) list.get(0)).C().booleanValue()));
        } else if (i4 != 3) {
            return super.a(str);
        } else {
            C0690v2.f(Z.OR, 2, list);
            C0663s b6 = z22.b((C0663s) list.get(0));
            if (b6.C().booleanValue()) {
                return b6;
            }
            return z22.b((C0663s) list.get(1));
        }
    }
}
