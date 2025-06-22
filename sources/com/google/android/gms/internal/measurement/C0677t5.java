package com.google.android.gms.internal.measurement;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.t5  reason: case insensitive filesystem */
final class C0677t5 implements Comparable, Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    private final Comparable f2180a;

    /* renamed from: b  reason: collision with root package name */
    private Object f2181b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ C0646p5 f2182c;

    C0677t5(C0646p5 p5Var, Map.Entry entry) {
        this(p5Var, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((C0677t5) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!a(this.f2180a, entry.getKey()) || !a(this.f2181b, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object getKey() {
        return this.f2180a;
    }

    public final Object getValue() {
        return this.f2181b;
    }

    public final int hashCode() {
        int i4;
        Comparable comparable = this.f2180a;
        int i5 = 0;
        if (comparable == null) {
            i4 = 0;
        } else {
            i4 = comparable.hashCode();
        }
        Object obj = this.f2181b;
        if (obj != null) {
            i5 = obj.hashCode();
        }
        return i4 ^ i5;
    }

    public final Object setValue(Object obj) {
        this.f2182c.r();
        Object obj2 = this.f2181b;
        this.f2181b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f2180a);
        String valueOf2 = String.valueOf(this.f2181b);
        return valueOf + "=" + valueOf2;
    }

    C0677t5(C0646p5 p5Var, Comparable comparable, Object obj) {
        this.f2182c = p5Var;
        this.f2180a = comparable;
        this.f2181b = obj;
    }
}
