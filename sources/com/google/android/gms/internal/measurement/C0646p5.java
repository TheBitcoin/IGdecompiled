package com.google.android.gms.internal.measurement;

import j$.util.DesugarCollections;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.android.gms.internal.measurement.p5  reason: case insensitive filesystem */
abstract class C0646p5 extends AbstractMap {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Object[] f2101a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2102b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Map f2103c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2104d;

    /* renamed from: e  reason: collision with root package name */
    private volatile C0701w5 f2105e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Map f2106f;

    private final int c(Comparable comparable) {
        int i4;
        int i5 = this.f2102b;
        int i6 = i5 - 1;
        if (i6 >= 0) {
            int compareTo = comparable.compareTo((Comparable) ((C0677t5) this.f2101a[i6]).getKey());
            if (compareTo > 0) {
                i4 = i5 + 1;
                return -i4;
            } else if (compareTo == 0) {
                return i6;
            }
        }
        int i7 = 0;
        while (i7 <= i6) {
            int i8 = (i7 + i6) / 2;
            int compareTo2 = comparable.compareTo((Comparable) ((C0677t5) this.f2101a[i8]).getKey());
            if (compareTo2 < 0) {
                i6 = i8 - 1;
            } else if (compareTo2 <= 0) {
                return i8;
            } else {
                i7 = i8 + 1;
            }
        }
        i4 = i7 + 1;
        return -i4;
    }

    /* access modifiers changed from: private */
    public final Object i(int i4) {
        r();
        Object value = ((C0677t5) this.f2101a[i4]).getValue();
        Object[] objArr = this.f2101a;
        System.arraycopy(objArr, i4 + 1, objArr, i4, (this.f2102b - i4) - 1);
        this.f2102b--;
        if (!this.f2103c.isEmpty()) {
            Iterator it = q().entrySet().iterator();
            this.f2101a[this.f2102b] = new C0677t5(this, (Map.Entry) it.next());
            this.f2102b++;
            it.remove();
        }
        return value;
    }

    private final SortedMap q() {
        r();
        if (this.f2103c.isEmpty() && !(this.f2103c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2103c = treeMap;
            this.f2106f = treeMap.descendingMap();
        }
        return (SortedMap) this.f2103c;
    }

    /* access modifiers changed from: private */
    public final void r() {
        if (this.f2104d) {
            throw new UnsupportedOperationException();
        }
    }

    public final int a() {
        return this.f2102b;
    }

    public void clear() {
        r();
        if (this.f2102b != 0) {
            this.f2101a = null;
            this.f2102b = 0;
        }
        if (!this.f2103c.isEmpty()) {
            this.f2103c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (c(comparable) >= 0 || this.f2103c.containsKey(comparable)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final Object put(Comparable comparable, Object obj) {
        r();
        int c5 = c(comparable);
        if (c5 >= 0) {
            return ((C0677t5) this.f2101a[c5]).setValue(obj);
        }
        r();
        if (this.f2101a == null) {
            this.f2101a = new Object[16];
        }
        int i4 = -(c5 + 1);
        if (i4 >= 16) {
            return q().put(comparable, obj);
        }
        int i5 = this.f2102b;
        if (i5 == 16) {
            C0677t5 t5Var = (C0677t5) this.f2101a[15];
            this.f2102b = i5 - 1;
            q().put((Comparable) t5Var.getKey(), t5Var.getValue());
        }
        Object[] objArr = this.f2101a;
        System.arraycopy(objArr, i4, objArr, i4 + 1, (objArr.length - i4) - 1);
        this.f2101a[i4] = new C0677t5(this, comparable, obj);
        this.f2102b++;
        return null;
    }

    public Set entrySet() {
        if (this.f2105e == null) {
            this.f2105e = new C0701w5(this);
        }
        return this.f2105e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0646p5)) {
            return super.equals(obj);
        }
        C0646p5 p5Var = (C0646p5) obj;
        int size = size();
        if (size != p5Var.size()) {
            return false;
        }
        int i4 = this.f2102b;
        if (i4 != p5Var.f2102b) {
            return entrySet().equals(p5Var.entrySet());
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!f(i5).equals(p5Var.f(i5))) {
                return false;
            }
        }
        if (i4 != size) {
            return this.f2103c.equals(p5Var.f2103c);
        }
        return true;
    }

    public final Map.Entry f(int i4) {
        if (i4 < this.f2102b) {
            return (C0677t5) this.f2101a[i4];
        }
        throw new ArrayIndexOutOfBoundsException(i4);
    }

    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int c5 = c(comparable);
        if (c5 >= 0) {
            return ((C0677t5) this.f2101a[c5]).getValue();
        }
        return this.f2103c.get(comparable);
    }

    public final Iterable h() {
        if (this.f2103c.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return this.f2103c.entrySet();
    }

    public int hashCode() {
        int i4 = this.f2102b;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += this.f2101a[i6].hashCode();
        }
        if (this.f2103c.size() > 0) {
            return i5 + this.f2103c.hashCode();
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final Set l() {
        return new C0693v5(this);
    }

    public void m() {
        Map map;
        Map map2;
        if (!this.f2104d) {
            if (this.f2103c.isEmpty()) {
                map = Collections.EMPTY_MAP;
            } else {
                map = DesugarCollections.unmodifiableMap(this.f2103c);
            }
            this.f2103c = map;
            if (this.f2106f.isEmpty()) {
                map2 = Collections.EMPTY_MAP;
            } else {
                map2 = DesugarCollections.unmodifiableMap(this.f2106f);
            }
            this.f2106f = map2;
            this.f2104d = true;
        }
    }

    public final boolean o() {
        return this.f2104d;
    }

    public Object remove(Object obj) {
        r();
        Comparable comparable = (Comparable) obj;
        int c5 = c(comparable);
        if (c5 >= 0) {
            return i(c5);
        }
        if (this.f2103c.isEmpty()) {
            return null;
        }
        return this.f2103c.remove(comparable);
    }

    public int size() {
        return this.f2102b + this.f2103c.size();
    }

    private C0646p5() {
        Map map = Collections.EMPTY_MAP;
        this.f2103c = map;
        this.f2106f = map;
    }
}
