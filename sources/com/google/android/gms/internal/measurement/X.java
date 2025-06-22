package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.List;

public final class X extends A {
    protected X() {
        this.f1393a.add(Z.ASSIGN);
        this.f1393a.add(Z.CONST);
        this.f1393a.add(Z.CREATE_ARRAY);
        this.f1393a.add(Z.CREATE_OBJECT);
        this.f1393a.add(Z.EXPRESSION_LIST);
        this.f1393a.add(Z.f1676I);
        this.f1393a.add(Z.GET_INDEX);
        this.f1393a.add(Z.GET_PROPERTY);
        this.f1393a.add(Z.NULL);
        this.f1393a.add(Z.SET_PROPERTY);
        this.f1393a.add(Z.TYPEOF);
        this.f1393a.add(Z.UNDEFINED);
        this.f1393a.add(Z.VAR);
    }

    public final C0663s b(String str, Z2 z22, List list) {
        String str2;
        int i4 = 0;
        switch (W.f1652a[C0690v2.c(str).ordinal()]) {
            case 1:
                C0690v2.f(Z.ASSIGN, 2, list);
                C0663s b5 = z22.b((C0663s) list.get(0));
                if (!(b5 instanceof C0679u)) {
                    throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[]{b5.getClass().getCanonicalName()}));
                } else if (z22.g(b5.E())) {
                    C0663s b6 = z22.b((C0663s) list.get(1));
                    z22.h(b5.E(), b6);
                    return b6;
                } else {
                    throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[]{b5.E()}));
                }
            case 2:
                C0690v2.j(Z.CONST, 2, list);
                if (list.size() % 2 == 0) {
                    int i5 = 0;
                    while (i5 < list.size() - 1) {
                        C0663s b7 = z22.b((C0663s) list.get(i5));
                        if (b7 instanceof C0679u) {
                            z22.f(b7.E(), z22.b((C0663s) list.get(i5 + 1)));
                            i5 += 2;
                        } else {
                            throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[]{b7.getClass().getCanonicalName()}));
                        }
                    }
                    return C0663s.f2138b0;
                }
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            case 3:
                if (list.isEmpty()) {
                    return new C0560g();
                }
                C0560g gVar = new C0560g();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    C0663s b8 = z22.b((C0663s) it.next());
                    if (!(b8 instanceof C0605l)) {
                        gVar.q(i4, b8);
                        i4++;
                    } else {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                }
                return gVar;
            case 4:
                if (list.isEmpty()) {
                    return new r();
                }
                if (list.size() % 2 == 0) {
                    r rVar = new r();
                    while (i4 < list.size() - 1) {
                        C0663s b9 = z22.b((C0663s) list.get(i4));
                        C0663s b10 = z22.b((C0663s) list.get(i4 + 1));
                        if ((b9 instanceof C0605l) || (b10 instanceof C0605l)) {
                            throw new IllegalStateException("Failed to evaluate map entry");
                        }
                        rVar.h(b9.E(), b10);
                        i4 += 2;
                    }
                    return rVar;
                }
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            case 5:
                C0690v2.j(Z.EXPRESSION_LIST, 1, list);
                C0663s sVar = C0663s.f2138b0;
                while (i4 < list.size()) {
                    sVar = z22.b((C0663s) list.get(i4));
                    if (!(sVar instanceof C0605l)) {
                        i4++;
                    } else {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                }
                return sVar;
            case 6:
                C0690v2.f(Z.f1676I, 1, list);
                C0663s b11 = z22.b((C0663s) list.get(0));
                if (b11 instanceof C0679u) {
                    return z22.c(b11.E());
                }
                throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[]{b11.getClass().getCanonicalName()}));
            case 7:
            case 8:
                C0690v2.f(Z.GET_PROPERTY, 2, list);
                C0663s b12 = z22.b((C0663s) list.get(0));
                C0663s b13 = z22.b((C0663s) list.get(1));
                if ((b12 instanceof C0560g) && C0690v2.l(b13)) {
                    return ((C0560g) b12).k(b13.D().intValue());
                }
                if (b12 instanceof C0614m) {
                    return ((C0614m) b12).c(b13.E());
                }
                if (b12 instanceof C0679u) {
                    if ("length".equals(b13.E())) {
                        return new C0596k(Double.valueOf((double) b12.E().length()));
                    }
                    if (C0690v2.l(b13) && b13.D().doubleValue() < ((double) b12.E().length())) {
                        return new C0679u(String.valueOf(b12.E().charAt(b13.D().intValue())));
                    }
                }
                return C0663s.f2138b0;
            case 9:
                C0690v2.f(Z.NULL, 0, list);
                return C0663s.f2139c0;
            case 10:
                C0690v2.f(Z.SET_PROPERTY, 3, list);
                C0663s b14 = z22.b((C0663s) list.get(0));
                C0663s b15 = z22.b((C0663s) list.get(1));
                C0663s b16 = z22.b((C0663s) list.get(2));
                if (b14 == C0663s.f2138b0 || b14 == C0663s.f2139c0) {
                    throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[]{b15.E(), b14.E()}));
                } else if (!(b14 instanceof C0560g) || !(b15 instanceof C0596k)) {
                    if (b14 instanceof C0614m) {
                        ((C0614m) b14).h(b15.E(), b16);
                    }
                    return b16;
                } else {
                    ((C0560g) b14).q(b15.D().intValue(), b16);
                    return b16;
                }
            case 11:
                C0690v2.f(Z.TYPEOF, 1, list);
                C0663s b17 = z22.b((C0663s) list.get(0));
                if (b17 instanceof C0719z) {
                    str2 = "undefined";
                } else if (b17 instanceof C0569h) {
                    str2 = TypedValues.Custom.S_BOOLEAN;
                } else if (b17 instanceof C0596k) {
                    str2 = "number";
                } else if (b17 instanceof C0679u) {
                    str2 = TypedValues.Custom.S_STRING;
                } else if (b17 instanceof C0671t) {
                    str2 = "function";
                } else if ((b17 instanceof C0687v) || (b17 instanceof C0605l)) {
                    throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{b17}));
                } else {
                    str2 = "object";
                }
                return new C0679u(str2);
            case 12:
                C0690v2.f(Z.UNDEFINED, 0, list);
                return C0663s.f2138b0;
            case 13:
                C0690v2.j(Z.VAR, 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    C0663s b18 = z22.b((C0663s) it2.next());
                    if (b18 instanceof C0679u) {
                        z22.e(b18.E(), C0663s.f2138b0);
                    } else {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[]{b18.getClass().getCanonicalName()}));
                    }
                }
                return C0663s.f2138b0;
            default:
                return super.a(str);
        }
    }
}
