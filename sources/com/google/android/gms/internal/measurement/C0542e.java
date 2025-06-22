package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import m0.r;

/* renamed from: com.google.android.gms.internal.measurement.e  reason: case insensitive filesystem */
public final class C0542e {

    /* renamed from: d  reason: collision with root package name */
    private static final r f1865d = r.t("_syn", "_err", "_el");

    /* renamed from: a  reason: collision with root package name */
    private String f1866a;

    /* renamed from: b  reason: collision with root package name */
    private long f1867b;

    /* renamed from: c  reason: collision with root package name */
    private Map f1868c;

    public C0542e(String str, long j4, Map map) {
        this.f1866a = str;
        this.f1867b = j4;
        HashMap hashMap = new HashMap();
        this.f1868c = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public static Object c(String str, Object obj, Object obj2) {
        if (f1865d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (!(obj instanceof String) && obj != null) {
                return obj;
            }
        } else if (obj instanceof Double) {
            return obj2;
        } else {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    public final long a() {
        return this.f1867b;
    }

    public final Object b(String str) {
        if (this.f1868c.containsKey(str)) {
            return this.f1868c.get(str);
        }
        return null;
    }

    public final /* synthetic */ Object clone() {
        return new C0542e(this.f1866a, this.f1867b, new HashMap(this.f1868c));
    }

    public final void d(String str, Object obj) {
        if (obj == null) {
            this.f1868c.remove(str);
            return;
        }
        this.f1868c.put(str, c(str, this.f1868c.get(str), obj));
    }

    public final String e() {
        return this.f1866a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0542e)) {
            return false;
        }
        C0542e eVar = (C0542e) obj;
        if (this.f1867b == eVar.f1867b && this.f1866a.equals(eVar.f1866a)) {
            return this.f1868c.equals(eVar.f1868c);
        }
        return false;
    }

    public final void f(String str) {
        this.f1866a = str;
    }

    public final Map g() {
        return this.f1868c;
    }

    public final int hashCode() {
        long j4 = this.f1867b;
        return (((this.f1866a.hashCode() * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.f1868c.hashCode();
    }

    public final String toString() {
        String str = this.f1866a;
        long j4 = this.f1867b;
        String valueOf = String.valueOf(this.f1868c);
        return "Event{name='" + str + "', timestamp=" + j4 + ", params=" + valueOf + "}";
    }
}
