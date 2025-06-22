package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

public final class L extends A {
    protected L() {
        this.f1393a.add(Z.FOR_IN);
        this.f1393a.add(Z.FOR_IN_CONST);
        this.f1393a.add(Z.FOR_IN_LET);
        this.f1393a.add(Z.FOR_LET);
        this.f1393a.add(Z.FOR_OF);
        this.f1393a.add(Z.FOR_OF_CONST);
        this.f1393a.add(Z.FOR_OF_LET);
        this.f1393a.add(Z.WHILE);
    }

    private static C0663s c(P p4, C0663s sVar, C0663s sVar2) {
        return d(p4, sVar.F(), sVar2);
    }

    private static C0663s d(P p4, Iterator it, C0663s sVar) {
        if (it != null) {
            while (it.hasNext()) {
                C0663s a5 = p4.a((C0663s) it.next()).a((C0560g) sVar);
                if (a5 instanceof C0605l) {
                    C0605l lVar = (C0605l) a5;
                    if ("break".equals(lVar.c())) {
                        return C0663s.f2138b0;
                    }
                    if ("return".equals(lVar.c())) {
                        return lVar;
                    }
                }
            }
        }
        return C0663s.f2138b0;
    }

    private static C0663s e(P p4, C0663s sVar, C0663s sVar2) {
        if (sVar instanceof Iterable) {
            return d(p4, ((Iterable) sVar).iterator(), sVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    public final C0663s b(String str, Z2 z22, List list) {
        switch (O.f1585a[C0690v2.c(str).ordinal()]) {
            case 1:
                C0690v2.f(Z.FOR_IN, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E4 = ((C0663s) list.get(0)).E();
                    return c(new T(z22, E4), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
            case 2:
                C0690v2.f(Z.FOR_IN_CONST, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E5 = ((C0663s) list.get(0)).E();
                    return c(new N(z22, E5), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
            case 3:
                C0690v2.f(Z.FOR_IN_LET, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E6 = ((C0663s) list.get(0)).E();
                    return c(new Q(z22, E6), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
            case 4:
                C0690v2.f(Z.FOR_LET, 4, list);
                C0663s b5 = z22.b((C0663s) list.get(0));
                if (b5 instanceof C0560g) {
                    C0560g gVar = (C0560g) b5;
                    C0663s sVar = (C0663s) list.get(1);
                    C0663s sVar2 = (C0663s) list.get(2);
                    C0663s b6 = z22.b((C0663s) list.get(3));
                    Z2 d5 = z22.d();
                    for (int i4 = 0; i4 < gVar.n(); i4++) {
                        String E7 = gVar.k(i4).E();
                        d5.h(E7, z22.c(E7));
                    }
                    while (z22.b(sVar).C().booleanValue()) {
                        C0663s a5 = z22.a((C0560g) b6);
                        if (a5 instanceof C0605l) {
                            C0605l lVar = (C0605l) a5;
                            if ("break".equals(lVar.c())) {
                                return C0663s.f2138b0;
                            }
                            if ("return".equals(lVar.c())) {
                                return lVar;
                            }
                        }
                        Z2 d6 = z22.d();
                        for (int i5 = 0; i5 < gVar.n(); i5++) {
                            String E8 = gVar.k(i5).E();
                            d6.h(E8, d5.c(E8));
                        }
                        d6.b(sVar2);
                        d5 = d6;
                    }
                    return C0663s.f2138b0;
                }
                throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
            case 5:
                C0690v2.f(Z.FOR_OF, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E9 = ((C0663s) list.get(0)).E();
                    return e(new T(z22, E9), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
            case 6:
                C0690v2.f(Z.FOR_OF_CONST, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E10 = ((C0663s) list.get(0)).E();
                    return e(new N(z22, E10), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
            case 7:
                C0690v2.f(Z.FOR_OF_LET, 3, list);
                if (list.get(0) instanceof C0679u) {
                    String E11 = ((C0663s) list.get(0)).E();
                    return e(new Q(z22, E11), z22.b((C0663s) list.get(1)), z22.b((C0663s) list.get(2)));
                }
                throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
            case 8:
                C0690v2.f(Z.WHILE, 4, list);
                C0663s sVar3 = (C0663s) list.get(0);
                C0663s sVar4 = (C0663s) list.get(1);
                C0663s b7 = z22.b((C0663s) list.get(3));
                if (z22.b((C0663s) list.get(2)).C().booleanValue()) {
                    C0663s a6 = z22.a((C0560g) b7);
                    if (a6 instanceof C0605l) {
                        C0605l lVar2 = (C0605l) a6;
                        if (!"break".equals(lVar2.c())) {
                            if ("return".equals(lVar2.c())) {
                                return lVar2;
                            }
                        }
                        return C0663s.f2138b0;
                    }
                }
                while (z22.b(sVar3).C().booleanValue()) {
                    C0663s a7 = z22.a((C0560g) b7);
                    if (a7 instanceof C0605l) {
                        C0605l lVar3 = (C0605l) a7;
                        if ("break".equals(lVar3.c())) {
                            return C0663s.f2138b0;
                        }
                        if ("return".equals(lVar3.c())) {
                            return lVar3;
                        }
                    }
                    z22.b(sVar4);
                }
                return C0663s.f2138b0;
            default:
                return super.a(str);
        }
    }
}
