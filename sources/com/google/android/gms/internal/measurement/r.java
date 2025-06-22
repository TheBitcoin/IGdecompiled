package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class r implements C0614m, C0663s {

    /* renamed from: a  reason: collision with root package name */
    private final Map f2119a = new HashMap();

    public final Boolean C() {
        return Boolean.TRUE;
    }

    public final Double D() {
        return Double.valueOf(Double.NaN);
    }

    public final String E() {
        return "[object Object]";
    }

    public final Iterator F() {
        return C0640p.b(this.f2119a);
    }

    public C0663s G(String str, Z2 z22, List list) {
        if ("toString".equals(str)) {
            return new C0679u(toString());
        }
        return C0640p.a(this, new C0679u(str), z22, list);
    }

    public final List a() {
        return new ArrayList(this.f2119a.keySet());
    }

    public final C0663s b() {
        r rVar = new r();
        for (Map.Entry entry : this.f2119a.entrySet()) {
            if (entry.getValue() instanceof C0614m) {
                rVar.f2119a.put((String) entry.getKey(), (C0663s) entry.getValue());
            } else {
                rVar.f2119a.put((String) entry.getKey(), ((C0663s) entry.getValue()).b());
            }
        }
        return rVar;
    }

    public final C0663s c(String str) {
        if (this.f2119a.containsKey(str)) {
            return (C0663s) this.f2119a.get(str);
        }
        return C0663s.f2138b0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        return this.f2119a.equals(((r) obj).f2119a);
    }

    public final boolean g(String str) {
        return this.f2119a.containsKey(str);
    }

    public final void h(String str, C0663s sVar) {
        if (sVar == null) {
            this.f2119a.remove(str);
        } else {
            this.f2119a.put(str, sVar);
        }
    }

    public int hashCode() {
        return this.f2119a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!this.f2119a.isEmpty()) {
            for (String str : this.f2119a.keySet()) {
                sb.append(String.format("%s: %s,", new Object[]{str, this.f2119a.get(str)}));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
