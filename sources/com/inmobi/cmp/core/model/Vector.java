package com.inmobi.cmp.core.model;

import R2.s;
import S2.C1601o;
import d3.p;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class Vector {

    /* renamed from: a  reason: collision with root package name */
    public Map<Integer, Boolean> f11780a;

    /* renamed from: b  reason: collision with root package name */
    public int f11781b;

    public static final class a extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vector f11782a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Vector vector) {
            super(2);
            this.f11782a = vector;
        }

        public Object invoke(Object obj, Object obj2) {
            int intValue = ((Number) obj).intValue();
            if (((Boolean) obj2).booleanValue()) {
                this.f11782a.set(intValue);
            } else {
                this.f11782a.unset(intValue);
            }
            return s.f8222a;
        }
    }

    public static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vector f11783a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Vector vector) {
            super(2);
            this.f11783a = vector;
        }

        public Object invoke(Object obj, Object obj2) {
            int intValue = ((Number) obj).intValue();
            boolean booleanValue = ((Boolean) obj2).booleanValue();
            if (this.f11783a.getMap().containsKey(Integer.valueOf(intValue))) {
                if (booleanValue) {
                    this.f11783a.set(intValue);
                } else {
                    this.f11783a.unset(intValue);
                }
            }
            return s.f8222a;
        }
    }

    public static final class c extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Vector f11784a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Vector f11785b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Vector vector, Vector vector2) {
            super(2);
            this.f11784a = vector;
            this.f11785b = vector2;
        }

        public Object invoke(Object obj, Object obj2) {
            int intValue = ((Number) obj).intValue();
            ((Boolean) obj2).getClass();
            Vector vector = this.f11784a;
            if (vector != null && !vector.contains(intValue)) {
                this.f11785b.unset(intValue);
            }
            return s.f8222a;
        }
    }

    public Vector() {
        this((Map) null, 1, (C2103g) null);
    }

    public static /* synthetic */ Vector copy$default(Vector vector, Map<Integer, Boolean> map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = vector.f11780a;
        }
        return vector.copy(map);
    }

    public final void clear() {
        this.f11780a.clear();
    }

    public final Map<Integer, Boolean> component1() {
        return this.f11780a;
    }

    public final boolean contains(int i4) {
        return this.f11780a.containsKey(Integer.valueOf(i4));
    }

    public final Vector copy(Map<Integer, Boolean> map) {
        m.e(map, "map");
        return new Vector(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Vector) && m.a(this.f11780a, ((Vector) obj).f11780a);
    }

    public final void forEach(p pVar) {
        m.e(pVar, "action");
        for (Map.Entry next : this.f11780a.entrySet()) {
            pVar.invoke(next.getKey(), next.getValue());
        }
    }

    public final Boolean get(int i4) {
        return this.f11780a.get(Integer.valueOf(i4));
    }

    public final Set<Integer> getAcceptedItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Number intValue : getMap().keySet()) {
            int intValue2 = intValue.intValue();
            if (m.a(get(intValue2), Boolean.TRUE)) {
                linkedHashSet.add(Integer.valueOf(intValue2));
            }
        }
        return linkedHashSet;
    }

    public final int getBitLength() {
        return this.f11781b;
    }

    public final Set<Integer> getKeys() {
        return this.f11780a.keySet();
    }

    public final Map<Integer, Boolean> getMap() {
        return this.f11780a;
    }

    public final int getMaxId() {
        Integer num = (Integer) C1601o.Q(this.f11780a.keySet());
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.f11780a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f11780a.isEmpty();
    }

    public final void set(int i4) {
        this.f11780a.put(Integer.valueOf(i4), Boolean.TRUE);
    }

    public final void setAllOwnedItems() {
        for (Map.Entry<Integer, Boolean> key : this.f11780a.entrySet()) {
            set(((Number) key.getKey()).intValue());
        }
    }

    public final void setBitLength(int i4) {
        this.f11781b = i4;
    }

    public final void setItems(Set<Integer> set) {
        m.e(set, "ids");
        for (Number intValue : set) {
            getMap().put(Integer.valueOf(intValue.intValue()), Boolean.TRUE);
            setBitLength(0);
        }
    }

    public final void setMap(Map<Integer, Boolean> map) {
        m.e(map, "<set-?>");
        this.f11780a = map;
    }

    public final void setOwnedItems(Vector vector) {
        if (vector != null) {
            vector.forEach(new b(this));
        }
    }

    public final int size() {
        return this.f11780a.size();
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("Vector(map=");
        a5.append(this.f11780a);
        a5.append(')');
        return a5.toString();
    }

    public final void unset(int i4) {
        this.f11780a.put(Integer.valueOf(i4), Boolean.FALSE);
        this.f11781b = 0;
    }

    public final void unsetAllOwnedItems() {
        for (Map.Entry<Integer, Boolean> key : this.f11780a.entrySet()) {
            unset(((Number) key.getKey()).intValue());
        }
    }

    public Vector(Map<Integer, Boolean> map) {
        m.e(map, "map");
        this.f11780a = map;
    }

    public final void set(Vector vector) {
        if (vector != null) {
            vector.forEach(new a(this));
        }
    }

    public final void set(Set<String> set) {
        m.e(set, "ids");
        for (String f4 : set) {
            Integer f5 = m3.m.f(f4);
            if (f5 != null) {
                getMap().put(Integer.valueOf(f5.intValue()), Boolean.TRUE);
                setBitLength(0);
            }
        }
    }

    public final void unset(Vector vector) {
        forEach(new c(vector, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Vector(Map map, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? new LinkedHashMap() : map);
    }

    public final void unset(Set<Integer> set) {
        m.e(set, "ids");
        for (Number intValue : set) {
            getMap().put(Integer.valueOf(intValue.intValue()), Boolean.FALSE);
            setBitLength(0);
        }
    }
}
