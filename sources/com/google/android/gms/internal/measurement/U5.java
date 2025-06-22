package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class U5 extends r {

    /* renamed from: b  reason: collision with root package name */
    private final C0533d f1643b;

    public U5(C0533d dVar) {
        this.f1643b = dVar;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 21624207:
                if (str.equals("getEventName")) {
                    c5 = 0;
                    break;
                }
                break;
            case 45521504:
                if (str.equals("getTimestamp")) {
                    c5 = 1;
                    break;
                }
                break;
            case 146575578:
                if (str.equals("getParamValue")) {
                    c5 = 2;
                    break;
                }
                break;
            case 700587132:
                if (str.equals("getParams")) {
                    c5 = 3;
                    break;
                }
                break;
            case 920706790:
                if (str.equals("setParamValue")) {
                    c5 = 4;
                    break;
                }
                break;
            case 1570616835:
                if (str.equals("setEventName")) {
                    c5 = 5;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                C0690v2.g("getEventName", 0, list);
                return new C0679u(this.f1643b.d().e());
            case 1:
                C0690v2.g("getTimestamp", 0, list);
                return new C0596k(Double.valueOf((double) this.f1643b.d().a()));
            case 2:
                C0690v2.g("getParamValue", 1, list);
                return C0511a4.b(this.f1643b.d().b(z22.b((C0663s) list.get(0)).E()));
            case 3:
                C0690v2.g("getParams", 0, list);
                Map g4 = this.f1643b.d().g();
                r rVar = new r();
                for (String str2 : g4.keySet()) {
                    rVar.h(str2, C0511a4.b(g4.get(str2)));
                }
                return rVar;
            case 4:
                C0690v2.g("setParamValue", 2, list);
                String E4 = z22.b((C0663s) list.get(0)).E();
                C0663s b5 = z22.b((C0663s) list.get(1));
                this.f1643b.d().d(E4, C0690v2.d(b5));
                return b5;
            case 5:
                C0690v2.g("setEventName", 1, list);
                C0663s b6 = z22.b((C0663s) list.get(0));
                if (C0663s.f2138b0.equals(b6) || C0663s.f2139c0.equals(b6)) {
                    throw new IllegalArgumentException("Illegal event name");
                }
                this.f1643b.d().f(b6.E());
                return new C0679u(b6.E());
            default:
                return super.G(str, z22, list);
        }
    }
}
