package com.google.android.gms.internal.measurement;

import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.y  reason: case insensitive filesystem */
public final class C0711y extends A {
    public C0711y() {
        this.f1393a.add(Z.BITWISE_AND);
        this.f1393a.add(Z.BITWISE_LEFT_SHIFT);
        this.f1393a.add(Z.BITWISE_NOT);
        this.f1393a.add(Z.BITWISE_OR);
        this.f1393a.add(Z.BITWISE_RIGHT_SHIFT);
        this.f1393a.add(Z.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f1393a.add(Z.BITWISE_XOR);
    }

    public final C0663s b(String str, Z2 z22, List list) {
        switch (B.f1404a[C0690v2.c(str).ordinal()]) {
            case 1:
                C0690v2.f(Z.BITWISE_AND, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()) & C0690v2.i(z22.b((C0663s) list.get(1)).D().doubleValue()))));
            case 2:
                C0690v2.f(Z.BITWISE_LEFT_SHIFT, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()) << ((int) (C0690v2.m(z22.b((C0663s) list.get(1)).D().doubleValue()) & 31)))));
            case 3:
                C0690v2.f(Z.BITWISE_NOT, 1, list);
                return new C0596k(Double.valueOf((double) (~C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()))));
            case 4:
                C0690v2.f(Z.BITWISE_OR, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()) | C0690v2.i(z22.b((C0663s) list.get(1)).D().doubleValue()))));
            case 5:
                C0690v2.f(Z.BITWISE_RIGHT_SHIFT, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()) >> ((int) (C0690v2.m(z22.b((C0663s) list.get(1)).D().doubleValue()) & 31)))));
            case 6:
                C0690v2.f(Z.BITWISE_UNSIGNED_RIGHT_SHIFT, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.m(z22.b((C0663s) list.get(0)).D().doubleValue()) >>> ((int) (C0690v2.m(z22.b((C0663s) list.get(1)).D().doubleValue()) & 31)))));
            case 7:
                C0690v2.f(Z.BITWISE_XOR, 2, list);
                return new C0596k(Double.valueOf((double) (C0690v2.i(z22.b((C0663s) list.get(0)).D().doubleValue()) ^ C0690v2.i(z22.b((C0663s) list.get(1)).D().doubleValue()))));
            default:
                return super.a(str);
        }
    }
}
