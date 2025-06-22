package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.measurement.g  reason: case insensitive filesystem */
public final class C0560g implements C0614m, C0663s, Iterable {

    /* renamed from: a  reason: collision with root package name */
    private final SortedMap f1902a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f1903b;

    public C0560g() {
        this.f1902a = new TreeMap();
        this.f1903b = new TreeMap();
    }

    public final Boolean C() {
        return Boolean.TRUE;
    }

    public final Double D() {
        if (this.f1902a.size() == 1) {
            return k(0).D();
        }
        if (this.f1902a.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    public final String E() {
        return toString();
    }

    public final Iterator F() {
        return new C0551f(this, this.f1902a.keySet().iterator(), this.f1903b.keySet().iterator());
    }

    public final C0663s G(String str, Z2 z22, List list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return H.d(str, this, z22, list);
        }
        return C0640p.a(this, new C0679u(str), z22, list);
    }

    public final C0663s b() {
        C0560g gVar = new C0560g();
        for (Map.Entry entry : this.f1902a.entrySet()) {
            if (entry.getValue() instanceof C0614m) {
                gVar.f1902a.put((Integer) entry.getKey(), (C0663s) entry.getValue());
            } else {
                gVar.f1902a.put((Integer) entry.getKey(), ((C0663s) entry.getValue()).b());
            }
        }
        return gVar;
    }

    public final C0663s c(String str) {
        C0663s sVar;
        if ("length".equals(str)) {
            return new C0596k(Double.valueOf((double) n()));
        }
        if (!g(str) || (sVar = (C0663s) this.f1903b.get(str)) == null) {
            return C0663s.f2138b0;
        }
        return sVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0560g)) {
            return false;
        }
        C0560g gVar = (C0560g) obj;
        if (n() != gVar.n()) {
            return false;
        }
        if (this.f1902a.isEmpty()) {
            return gVar.f1902a.isEmpty();
        }
        for (int intValue = ((Integer) this.f1902a.firstKey()).intValue(); intValue <= ((Integer) this.f1902a.lastKey()).intValue(); intValue++) {
            if (!k(intValue).equals(gVar.k(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final boolean g(String str) {
        if ("length".equals(str) || this.f1903b.containsKey(str)) {
            return true;
        }
        return false;
    }

    public final void h(String str, C0663s sVar) {
        if (sVar == null) {
            this.f1903b.remove(str);
        } else {
            this.f1903b.put(str, sVar);
        }
    }

    public final int hashCode() {
        return this.f1902a.hashCode() * 31;
    }

    public final Iterator iterator() {
        return new C0578i(this);
    }

    public final int j() {
        return this.f1902a.size();
    }

    public final C0663s k(int i4) {
        C0663s sVar;
        if (i4 >= n()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        } else if (!r(i4) || (sVar = (C0663s) this.f1902a.get(Integer.valueOf(i4))) == null) {
            return C0663s.f2138b0;
        } else {
            return sVar;
        }
    }

    public final void l(int i4, C0663s sVar) {
        if (i4 < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i4);
        } else if (i4 >= n()) {
            q(i4, sVar);
        } else {
            for (int intValue = ((Integer) this.f1902a.lastKey()).intValue(); intValue >= i4; intValue--) {
                C0663s sVar2 = (C0663s) this.f1902a.get(Integer.valueOf(intValue));
                if (sVar2 != null) {
                    q(intValue + 1, sVar2);
                    this.f1902a.remove(Integer.valueOf(intValue));
                }
            }
            q(i4, sVar);
        }
    }

    public final void m(C0663s sVar) {
        q(n(), sVar);
    }

    public final int n() {
        if (this.f1902a.isEmpty()) {
            return 0;
        }
        return ((Integer) this.f1902a.lastKey()).intValue() + 1;
    }

    public final String o(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.f1902a.isEmpty()) {
            for (int i4 = 0; i4 < n(); i4++) {
                C0663s k4 = k(i4);
                sb.append(str);
                if (!(k4 instanceof C0719z) && !(k4 instanceof C0648q)) {
                    sb.append(k4.E());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final void p(int i4) {
        int intValue = ((Integer) this.f1902a.lastKey()).intValue();
        if (i4 <= intValue && i4 >= 0) {
            this.f1902a.remove(Integer.valueOf(i4));
            if (i4 == intValue) {
                int i5 = i4 - 1;
                if (!this.f1902a.containsKey(Integer.valueOf(i5)) && i5 >= 0) {
                    this.f1902a.put(Integer.valueOf(i5), C0663s.f2138b0);
                    return;
                }
                return;
            }
            while (true) {
                i4++;
                if (i4 <= ((Integer) this.f1902a.lastKey()).intValue()) {
                    C0663s sVar = (C0663s) this.f1902a.get(Integer.valueOf(i4));
                    if (sVar != null) {
                        this.f1902a.put(Integer.valueOf(i4 - 1), sVar);
                        this.f1902a.remove(Integer.valueOf(i4));
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void q(int i4, C0663s sVar) {
        if (i4 > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i4 < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i4);
        } else if (sVar == null) {
            this.f1902a.remove(Integer.valueOf(i4));
        } else {
            this.f1902a.put(Integer.valueOf(i4), sVar);
        }
    }

    public final boolean r(int i4) {
        if (i4 >= 0 && i4 <= ((Integer) this.f1902a.lastKey()).intValue()) {
            return this.f1902a.containsKey(Integer.valueOf(i4));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i4);
    }

    public final Iterator s() {
        return this.f1902a.keySet().iterator();
    }

    public final List t() {
        ArrayList arrayList = new ArrayList(n());
        for (int i4 = 0; i4 < n(); i4++) {
            arrayList.add(k(i4));
        }
        return arrayList;
    }

    public final String toString() {
        return o(",");
    }

    public final void u() {
        this.f1902a.clear();
    }

    public C0560g(List list) {
        this();
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                q(i4, (C0663s) list.get(i4));
            }
        }
    }

    public C0560g(C0663s... sVarArr) {
        this(Arrays.asList(sVarArr));
    }
}
