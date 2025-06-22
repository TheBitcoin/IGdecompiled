package com.google.android.gms.internal.measurement;

import java.util.List;

public final class D extends A {
    public D() {
        this.f1393a.add(Z.EQUALS);
        this.f1393a.add(Z.GREATER_THAN);
        this.f1393a.add(Z.GREATER_THAN_EQUALS);
        this.f1393a.add(Z.IDENTITY_EQUALS);
        this.f1393a.add(Z.IDENTITY_NOT_EQUALS);
        this.f1393a.add(Z.LESS_THAN);
        this.f1393a.add(Z.LESS_THAN_EQUALS);
        this.f1393a.add(Z.NOT_EQUALS);
    }

    private static boolean c(C0663s sVar, C0663s sVar2) {
        C0663s uVar;
        C0663s uVar2;
        while (!sVar.getClass().equals(sVar2.getClass())) {
            if (((sVar instanceof C0719z) || (sVar instanceof C0648q)) && ((sVar2 instanceof C0719z) || (sVar2 instanceof C0648q))) {
                return true;
            }
            boolean z4 = sVar instanceof C0596k;
            if (!z4 || !(sVar2 instanceof C0679u)) {
                boolean z5 = sVar instanceof C0679u;
                if (z5 && (sVar2 instanceof C0596k)) {
                    uVar = new C0596k(sVar.D());
                } else if (sVar instanceof C0569h) {
                    uVar = new C0596k(sVar.D());
                } else if (sVar2 instanceof C0569h) {
                    uVar2 = new C0596k(sVar2.D());
                } else if ((z5 || z4) && (sVar2 instanceof C0614m)) {
                    uVar2 = new C0679u(sVar2.E());
                } else if (!(sVar instanceof C0614m) || (!(sVar2 instanceof C0679u) && !(sVar2 instanceof C0596k))) {
                    return false;
                } else {
                    uVar = new C0679u(sVar.E());
                }
                sVar = uVar;
            } else {
                uVar2 = new C0596k(sVar2.D());
            }
            sVar2 = uVar2;
        }
        if ((sVar instanceof C0719z) || (sVar instanceof C0648q)) {
            return true;
        }
        if (sVar instanceof C0596k) {
            if (Double.isNaN(sVar.D().doubleValue()) || Double.isNaN(sVar2.D().doubleValue()) || sVar.D().doubleValue() != sVar2.D().doubleValue()) {
                return false;
            }
            return true;
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

    private static boolean d(C0663s sVar, C0663s sVar2) {
        if (sVar instanceof C0614m) {
            sVar = new C0679u(sVar.E());
        }
        if (sVar2 instanceof C0614m) {
            sVar2 = new C0679u(sVar2.E());
        }
        if (!(sVar instanceof C0679u) || !(sVar2 instanceof C0679u)) {
            double doubleValue = sVar.D().doubleValue();
            double doubleValue2 = sVar2.D().doubleValue();
            if (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || ((doubleValue == 0.0d && doubleValue2 == -0.0d) || ((doubleValue == -0.0d && doubleValue2 == 0.0d) || Double.compare(doubleValue, doubleValue2) >= 0))) {
                return false;
            }
            return true;
        } else if (sVar.E().compareTo(sVar2.E()) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean e(C0663s sVar, C0663s sVar2) {
        if (sVar instanceof C0614m) {
            sVar = new C0679u(sVar.E());
        }
        if (sVar2 instanceof C0614m) {
            sVar2 = new C0679u(sVar2.E());
        }
        if (((!(sVar instanceof C0679u) || !(sVar2 instanceof C0679u)) && (Double.isNaN(sVar.D().doubleValue()) || Double.isNaN(sVar2.D().doubleValue()))) || d(sVar2, sVar)) {
            return false;
        }
        return true;
    }

    public final C0663s b(String str, Z2 z22, List list) {
        boolean z4;
        boolean h4;
        C0690v2.f(C0690v2.c(str), 2, list);
        C0663s b5 = z22.b((C0663s) list.get(0));
        C0663s b6 = z22.b((C0663s) list.get(1));
        switch (G.f1474a[C0690v2.c(str).ordinal()]) {
            case 1:
                z4 = c(b5, b6);
                break;
            case 2:
                z4 = d(b6, b5);
                break;
            case 3:
                z4 = e(b6, b5);
                break;
            case 4:
                z4 = C0690v2.h(b5, b6);
                break;
            case 5:
                h4 = C0690v2.h(b5, b6);
                break;
            case 6:
                z4 = d(b5, b6);
                break;
            case 7:
                z4 = e(b5, b6);
                break;
            case 8:
                h4 = c(b5, b6);
                break;
            default:
                return super.a(str);
        }
        z4 = !h4;
        if (z4) {
            return C0663s.f2143g0;
        }
        return C0663s.f2144h0;
    }
}
