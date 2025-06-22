package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class F extends A {
    protected F() {
        this.f1393a.add(Z.APPLY);
        this.f1393a.add(Z.BLOCK);
        this.f1393a.add(Z.BREAK);
        this.f1393a.add(Z.CASE);
        this.f1393a.add(Z.DEFAULT);
        this.f1393a.add(Z.CONTINUE);
        this.f1393a.add(Z.DEFINE_FUNCTION);
        this.f1393a.add(Z.FN);
        this.f1393a.add(Z.IF);
        this.f1393a.add(Z.QUOTE);
        this.f1393a.add(Z.RETURN);
        this.f1393a.add(Z.SWITCH);
        this.f1393a.add(Z.TERNARY);
    }

    private static C0663s c(Z2 z22, List list) {
        C0690v2.j(Z.FN, 2, list);
        C0663s b5 = z22.b((C0663s) list.get(0));
        C0663s b6 = z22.b((C0663s) list.get(1));
        if (b6 instanceof C0560g) {
            List t4 = ((C0560g) b6).t();
            List arrayList = new ArrayList();
            if (list.size() > 2) {
                arrayList = list.subList(2, list.size());
            }
            return new C0671t(b5.E(), t4, arrayList, z22);
        }
        throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", new Object[]{b6.getClass().getCanonicalName()}));
    }

    public final C0663s b(String str, Z2 z22, List list) {
        C0663s sVar;
        C0663s sVar2;
        int i4 = 0;
        switch (I.f1495a[C0690v2.c(str).ordinal()]) {
            case 1:
                C0690v2.f(Z.APPLY, 3, list);
                C0663s b5 = z22.b((C0663s) list.get(0));
                String E4 = z22.b((C0663s) list.get(1)).E();
                C0663s b6 = z22.b((C0663s) list.get(2));
                if (!(b6 instanceof C0560g)) {
                    throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", new Object[]{b6.getClass().getCanonicalName()}));
                } else if (!E4.isEmpty()) {
                    return b5.G(E4, z22, ((C0560g) b6).t());
                } else {
                    throw new IllegalArgumentException("Function name for apply is undefined");
                }
            case 2:
                return z22.d().a(new C0560g(list));
            case 3:
                C0690v2.f(Z.BREAK, 0, list);
                return C0663s.f2141e0;
            case 4:
            case 5:
                if (!list.isEmpty()) {
                    C0663s b7 = z22.b((C0663s) list.get(0));
                    if (b7 instanceof C0560g) {
                        return z22.a((C0560g) b7);
                    }
                }
                return C0663s.f2138b0;
            case 6:
                C0690v2.f(Z.BREAK, 0, list);
                return C0663s.f2140d0;
            case 7:
                C0690v2.j(Z.DEFINE_FUNCTION, 2, list);
                C0671t tVar = (C0671t) c(z22, list);
                if (tVar.d() == null) {
                    z22.h("", tVar);
                    return tVar;
                }
                z22.h(tVar.d(), tVar);
                return tVar;
            case 8:
                return c(z22, list);
            case 9:
                C0690v2.j(Z.IF, 2, list);
                C0663s b8 = z22.b((C0663s) list.get(0));
                C0663s b9 = z22.b((C0663s) list.get(1));
                if (list.size() > 2) {
                    sVar = z22.b((C0663s) list.get(2));
                } else {
                    sVar = null;
                }
                C0663s sVar3 = C0663s.f2138b0;
                if (b8.C().booleanValue()) {
                    sVar2 = z22.a((C0560g) b9);
                } else if (sVar != null) {
                    sVar2 = z22.a((C0560g) sVar);
                } else {
                    sVar2 = sVar3;
                }
                if (sVar2 instanceof C0605l) {
                    return sVar2;
                }
                return sVar3;
            case 10:
                return new C0560g(list);
            case 11:
                if (list.isEmpty()) {
                    return C0663s.f2142f0;
                }
                C0690v2.f(Z.RETURN, 1, list);
                return new C0605l("return", z22.b((C0663s) list.get(0)));
            case 12:
                C0690v2.f(Z.SWITCH, 3, list);
                C0663s b10 = z22.b((C0663s) list.get(0));
                C0663s b11 = z22.b((C0663s) list.get(1));
                C0663s b12 = z22.b((C0663s) list.get(2));
                if (!(b11 instanceof C0560g)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                } else if (b12 instanceof C0560g) {
                    C0560g gVar = (C0560g) b11;
                    C0560g gVar2 = (C0560g) b12;
                    boolean z4 = false;
                    while (true) {
                        if (i4 < gVar.n()) {
                            if (z4 || b10.equals(z22.b(gVar.k(i4)))) {
                                C0663s b13 = z22.b(gVar2.k(i4));
                                if (!(b13 instanceof C0605l)) {
                                    z4 = true;
                                } else if (!((C0605l) b13).c().equals("break")) {
                                    return b13;
                                }
                            }
                            i4++;
                        } else if (gVar.n() + 1 == gVar2.n()) {
                            C0663s b14 = z22.b(gVar2.k(gVar.n()));
                            if (b14 instanceof C0605l) {
                                String c5 = ((C0605l) b14).c();
                                if (c5.equals("return") || c5.equals("continue")) {
                                    return b14;
                                }
                            }
                        }
                    }
                    return C0663s.f2138b0;
                } else {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
            case 13:
                C0690v2.f(Z.TERNARY, 3, list);
                if (z22.b((C0663s) list.get(0)).C().booleanValue()) {
                    return z22.b((C0663s) list.get(1));
                }
                return z22.b((C0663s) list.get(2));
            default:
                return super.a(str);
        }
    }
}
