package com.google.android.gms.internal.measurement;

import java.util.List;

public final class S extends A {
    protected S() {
        this.f1393a.add(Z.ADD);
        this.f1393a.add(Z.DIVIDE);
        this.f1393a.add(Z.MODULUS);
        this.f1393a.add(Z.MULTIPLY);
        this.f1393a.add(Z.NEGATE);
        this.f1393a.add(Z.POST_DECREMENT);
        this.f1393a.add(Z.POST_INCREMENT);
        this.f1393a.add(Z.PRE_DECREMENT);
        this.f1393a.add(Z.PRE_INCREMENT);
        this.f1393a.add(Z.SUBTRACT);
    }

    public final C0663s b(String str, Z2 z22, List list) {
        switch (V.f1646a[C0690v2.c(str).ordinal()]) {
            case 1:
                C0690v2.f(Z.ADD, 2, list);
                C0663s b5 = z22.b((C0663s) list.get(0));
                C0663s b6 = z22.b((C0663s) list.get(1));
                if (!(b5 instanceof C0614m) && !(b5 instanceof C0679u) && !(b6 instanceof C0614m) && !(b6 instanceof C0679u)) {
                    return new C0596k(Double.valueOf(b5.D().doubleValue() + b6.D().doubleValue()));
                }
                String E4 = b5.E();
                String E5 = b6.E();
                return new C0679u(E4 + E5);
            case 2:
                C0690v2.f(Z.DIVIDE, 2, list);
                return new C0596k(Double.valueOf(z22.b((C0663s) list.get(0)).D().doubleValue() / z22.b((C0663s) list.get(1)).D().doubleValue()));
            case 3:
                C0690v2.f(Z.MODULUS, 2, list);
                return new C0596k(Double.valueOf(z22.b((C0663s) list.get(0)).D().doubleValue() % z22.b((C0663s) list.get(1)).D().doubleValue()));
            case 4:
                C0690v2.f(Z.MULTIPLY, 2, list);
                return new C0596k(Double.valueOf(z22.b((C0663s) list.get(0)).D().doubleValue() * z22.b((C0663s) list.get(1)).D().doubleValue()));
            case 5:
                C0690v2.f(Z.NEGATE, 1, list);
                return new C0596k(Double.valueOf(z22.b((C0663s) list.get(0)).D().doubleValue() * -1.0d));
            case 6:
            case 7:
                C0690v2.g(str, 2, list);
                C0663s b7 = z22.b((C0663s) list.get(0));
                z22.b((C0663s) list.get(1));
                return b7;
            case 8:
            case 9:
                C0690v2.g(str, 1, list);
                return z22.b((C0663s) list.get(0));
            case 10:
                C0690v2.f(Z.SUBTRACT, 2, list);
                return new C0596k(Double.valueOf(z22.b((C0663s) list.get(0)).D().doubleValue() + new C0596k(Double.valueOf(z22.b((C0663s) list.get(1)).D().doubleValue() * -1.0d)).D().doubleValue()));
            default:
                return super.a(str);
        }
    }
}
