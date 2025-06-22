package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.v  reason: case insensitive filesystem */
public final class C0687v implements C0663s {

    /* renamed from: a  reason: collision with root package name */
    private final String f2201a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList f2202b;

    public C0687v(String str, List list) {
        this.f2201a = str;
        ArrayList arrayList = new ArrayList();
        this.f2202b = arrayList;
        arrayList.addAll(list);
    }

    public final Boolean C() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final Double D() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final String E() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    public final String a() {
        return this.f2201a;
    }

    public final C0663s b() {
        return this;
    }

    public final ArrayList c() {
        return this.f2202b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0687v)) {
            return false;
        }
        C0687v vVar = (C0687v) obj;
        String str = this.f2201a;
        if (str == null ? vVar.f2201a != null : !str.equals(vVar.f2201a)) {
            return false;
        }
        ArrayList arrayList = this.f2202b;
        ArrayList arrayList2 = vVar.f2202b;
        if (arrayList != null) {
            return arrayList.equals(arrayList2);
        }
        if (arrayList2 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        String str = this.f2201a;
        int i5 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        int i6 = i4 * 31;
        ArrayList arrayList = this.f2202b;
        if (arrayList != null) {
            i5 = arrayList.hashCode();
        }
        return i6 + i5;
    }
}
