package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class g extends AbstractMap implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator f11683i = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Comparator f11684a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11685b;

    /* renamed from: c  reason: collision with root package name */
    e f11686c;

    /* renamed from: d  reason: collision with root package name */
    int f11687d;

    /* renamed from: e  reason: collision with root package name */
    int f11688e;

    /* renamed from: f  reason: collision with root package name */
    final e f11689f;

    /* renamed from: g  reason: collision with root package name */
    private b f11690g;

    /* renamed from: h  reason: collision with root package name */
    private c f11691h;

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            /* renamed from: b */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry) || g.this.c((Map.Entry) obj) == null) {
                return false;
            }
            return true;
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            e c5;
            if (!(obj instanceof Map.Entry) || (c5 = g.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            g.this.f(c5, true);
            return true;
        }

        public int size() {
            return g.this.f11687d;
        }
    }

    final class c extends AbstractSet {

        class a extends d {
            a() {
                super();
            }

            public Object next() {
                return a().f11705f;
            }
        }

        c() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        public Iterator iterator() {
            return new a();
        }

        public boolean remove(Object obj) {
            if (g.this.h(obj) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return g.this.f11687d;
        }
    }

    private abstract class d implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        e f11696a;

        /* renamed from: b  reason: collision with root package name */
        e f11697b = null;

        /* renamed from: c  reason: collision with root package name */
        int f11698c;

        d() {
            this.f11696a = g.this.f11689f.f11703d;
            this.f11698c = g.this.f11688e;
        }

        /* access modifiers changed from: package-private */
        public final e a() {
            e eVar = this.f11696a;
            g gVar = g.this;
            if (eVar == gVar.f11689f) {
                throw new NoSuchElementException();
            } else if (gVar.f11688e == this.f11698c) {
                this.f11696a = eVar.f11703d;
                this.f11697b = eVar;
                return eVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            if (this.f11696a != g.this.f11689f) {
                return true;
            }
            return false;
        }

        public final void remove() {
            e eVar = this.f11697b;
            if (eVar != null) {
                g.this.f(eVar, true);
                this.f11697b = null;
                this.f11698c = g.this.f11688e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public g() {
        this(f11683i, true);
    }

    private boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void e(e eVar, boolean z4) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (eVar != null) {
            e eVar2 = eVar.f11701b;
            e eVar3 = eVar.f11702c;
            int i8 = 0;
            if (eVar2 != null) {
                i4 = eVar2.f11708i;
            } else {
                i4 = 0;
            }
            if (eVar3 != null) {
                i5 = eVar3.f11708i;
            } else {
                i5 = 0;
            }
            int i9 = i4 - i5;
            if (i9 == -2) {
                e eVar4 = eVar3.f11701b;
                e eVar5 = eVar3.f11702c;
                if (eVar5 != null) {
                    i7 = eVar5.f11708i;
                } else {
                    i7 = 0;
                }
                if (eVar4 != null) {
                    i8 = eVar4.f11708i;
                }
                int i10 = i8 - i7;
                if (i10 == -1 || (i10 == 0 && !z4)) {
                    j(eVar);
                } else {
                    k(eVar3);
                    j(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i9 == 2) {
                e eVar6 = eVar2.f11701b;
                e eVar7 = eVar2.f11702c;
                if (eVar7 != null) {
                    i6 = eVar7.f11708i;
                } else {
                    i6 = 0;
                }
                if (eVar6 != null) {
                    i8 = eVar6.f11708i;
                }
                int i11 = i8 - i6;
                if (i11 == 1 || (i11 == 0 && !z4)) {
                    k(eVar);
                } else {
                    j(eVar2);
                    k(eVar);
                }
                if (z4) {
                    return;
                }
            } else if (i9 == 0) {
                eVar.f11708i = i4 + 1;
                if (z4) {
                    return;
                }
            } else {
                eVar.f11708i = Math.max(i4, i5) + 1;
                if (!z4) {
                    return;
                }
            }
            eVar = eVar.f11700a;
        }
    }

    private void i(e eVar, e eVar2) {
        e eVar3 = eVar.f11700a;
        eVar.f11700a = null;
        if (eVar2 != null) {
            eVar2.f11700a = eVar3;
        }
        if (eVar3 == null) {
            this.f11686c = eVar2;
        } else if (eVar3.f11701b == eVar) {
            eVar3.f11701b = eVar2;
        } else {
            eVar3.f11702c = eVar2;
        }
    }

    private void j(e eVar) {
        int i4;
        int i5;
        e eVar2 = eVar.f11701b;
        e eVar3 = eVar.f11702c;
        e eVar4 = eVar3.f11701b;
        e eVar5 = eVar3.f11702c;
        eVar.f11702c = eVar4;
        if (eVar4 != null) {
            eVar4.f11700a = eVar;
        }
        i(eVar, eVar3);
        eVar3.f11701b = eVar;
        eVar.f11700a = eVar3;
        int i6 = 0;
        if (eVar2 != null) {
            i4 = eVar2.f11708i;
        } else {
            i4 = 0;
        }
        if (eVar4 != null) {
            i5 = eVar4.f11708i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        eVar.f11708i = max;
        if (eVar5 != null) {
            i6 = eVar5.f11708i;
        }
        eVar3.f11708i = Math.max(max, i6) + 1;
    }

    private void k(e eVar) {
        int i4;
        int i5;
        e eVar2 = eVar.f11701b;
        e eVar3 = eVar.f11702c;
        e eVar4 = eVar2.f11701b;
        e eVar5 = eVar2.f11702c;
        eVar.f11701b = eVar5;
        if (eVar5 != null) {
            eVar5.f11700a = eVar;
        }
        i(eVar, eVar2);
        eVar2.f11702c = eVar;
        eVar.f11700a = eVar2;
        int i6 = 0;
        if (eVar3 != null) {
            i4 = eVar3.f11708i;
        } else {
            i4 = 0;
        }
        if (eVar5 != null) {
            i5 = eVar5.f11708i;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        eVar.f11708i = max;
        if (eVar4 != null) {
            i6 = eVar4.f11708i;
        }
        eVar2.f11708i = Math.max(max, i6) + 1;
    }

    /* access modifiers changed from: package-private */
    public e b(Object obj, boolean z4) {
        int i4;
        e eVar;
        Comparable comparable;
        e eVar2;
        Comparator comparator = this.f11684a;
        e eVar3 = this.f11686c;
        if (eVar3 != null) {
            if (comparator == f11683i) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i4 = comparable.compareTo(eVar3.f11705f);
                } else {
                    i4 = comparator.compare(obj, eVar3.f11705f);
                }
                if (i4 == 0) {
                    return eVar3;
                }
                if (i4 < 0) {
                    eVar2 = eVar3.f11701b;
                } else {
                    eVar2 = eVar3.f11702c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i4 = 0;
        }
        e eVar4 = eVar3;
        if (!z4) {
            return null;
        }
        e eVar5 = this.f11689f;
        if (eVar4 != null) {
            eVar = new e(this.f11685b, eVar4, obj, eVar5, eVar5.f11704e);
            if (i4 < 0) {
                eVar4.f11701b = eVar;
            } else {
                eVar4.f11702c = eVar;
            }
            e(eVar4, true);
        } else if (comparator != f11683i || (obj instanceof Comparable)) {
            eVar = new e(this.f11685b, eVar4, obj, eVar5, eVar5.f11704e);
            this.f11686c = eVar;
        } else {
            throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
        }
        this.f11687d++;
        this.f11688e++;
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public e c(Map.Entry entry) {
        e d5 = d(entry.getKey());
        if (d5 == null || !a(d5.f11707h, entry.getValue())) {
            return null;
        }
        return d5;
    }

    public void clear() {
        this.f11686c = null;
        this.f11687d = 0;
        this.f11688e++;
        e eVar = this.f11689f;
        eVar.f11704e = eVar;
        eVar.f11703d = eVar;
    }

    public boolean containsKey(Object obj) {
        if (d(obj) != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public e d(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public Set entrySet() {
        b bVar = this.f11690g;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        this.f11690g = bVar2;
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public void f(e eVar, boolean z4) {
        e eVar2;
        int i4;
        if (z4) {
            e eVar3 = eVar.f11704e;
            eVar3.f11703d = eVar.f11703d;
            eVar.f11703d.f11704e = eVar3;
        }
        e eVar4 = eVar.f11701b;
        e eVar5 = eVar.f11702c;
        e eVar6 = eVar.f11700a;
        int i5 = 0;
        if (eVar4 == null || eVar5 == null) {
            if (eVar4 != null) {
                i(eVar, eVar4);
                eVar.f11701b = null;
            } else if (eVar5 != null) {
                i(eVar, eVar5);
                eVar.f11702c = null;
            } else {
                i(eVar, (e) null);
            }
            e(eVar6, false);
            this.f11687d--;
            this.f11688e++;
            return;
        }
        if (eVar4.f11708i > eVar5.f11708i) {
            eVar2 = eVar4.b();
        } else {
            eVar2 = eVar5.a();
        }
        f(eVar2, false);
        e eVar7 = eVar.f11701b;
        if (eVar7 != null) {
            i4 = eVar7.f11708i;
            eVar2.f11701b = eVar7;
            eVar7.f11700a = eVar2;
            eVar.f11701b = null;
        } else {
            i4 = 0;
        }
        e eVar8 = eVar.f11702c;
        if (eVar8 != null) {
            i5 = eVar8.f11708i;
            eVar2.f11702c = eVar8;
            eVar8.f11700a = eVar2;
            eVar.f11702c = null;
        }
        eVar2.f11708i = Math.max(i4, i5) + 1;
        i(eVar, eVar2);
    }

    public Object get(Object obj) {
        e d5 = d(obj);
        if (d5 != null) {
            return d5.f11707h;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public e h(Object obj) {
        e d5 = d(obj);
        if (d5 != null) {
            f(d5, true);
        }
        return d5;
    }

    public Set keySet() {
        c cVar = this.f11691h;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f11691h = cVar2;
        return cVar2;
    }

    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        } else if (obj2 != null || this.f11685b) {
            e b5 = b(obj, true);
            Object obj3 = b5.f11707h;
            b5.f11707h = obj2;
            return obj3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public Object remove(Object obj) {
        e h4 = h(obj);
        if (h4 != null) {
            return h4.f11707h;
        }
        return null;
    }

    public int size() {
        return this.f11687d;
    }

    public g(boolean z4) {
        this(f11683i, z4);
    }

    public g(Comparator comparator, boolean z4) {
        this.f11687d = 0;
        this.f11688e = 0;
        this.f11684a = comparator == null ? f11683i : comparator;
        this.f11685b = z4;
        this.f11689f = new e(z4);
    }

    static final class e implements Map.Entry {

        /* renamed from: a  reason: collision with root package name */
        e f11700a;

        /* renamed from: b  reason: collision with root package name */
        e f11701b;

        /* renamed from: c  reason: collision with root package name */
        e f11702c;

        /* renamed from: d  reason: collision with root package name */
        e f11703d;

        /* renamed from: e  reason: collision with root package name */
        e f11704e;

        /* renamed from: f  reason: collision with root package name */
        final Object f11705f;

        /* renamed from: g  reason: collision with root package name */
        final boolean f11706g;

        /* renamed from: h  reason: collision with root package name */
        Object f11707h;

        /* renamed from: i  reason: collision with root package name */
        int f11708i;

        e(boolean z4) {
            this.f11705f = null;
            this.f11706g = z4;
            this.f11704e = this;
            this.f11703d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f11701b; eVar2 != null; eVar2 = eVar2.f11701b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f11702c; eVar2 != null; eVar2 = eVar2.f11702c) {
                eVar = eVar2;
            }
            return eVar;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f11705f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f11707h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Object getKey() {
            return this.f11705f;
        }

        public Object getValue() {
            return this.f11707h;
        }

        public int hashCode() {
            int i4;
            Object obj = this.f11705f;
            int i5 = 0;
            if (obj == null) {
                i4 = 0;
            } else {
                i4 = obj.hashCode();
            }
            Object obj2 = this.f11707h;
            if (obj2 != null) {
                i5 = obj2.hashCode();
            }
            return i4 ^ i5;
        }

        public Object setValue(Object obj) {
            if (obj != null || this.f11706g) {
                Object obj2 = this.f11707h;
                this.f11707h = obj;
                return obj2;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f11705f + "=" + this.f11707h;
        }

        e(boolean z4, e eVar, Object obj, e eVar2, e eVar3) {
            this.f11700a = eVar;
            this.f11705f = obj;
            this.f11706g = z4;
            this.f11708i = 1;
            this.f11703d = eVar2;
            this.f11704e = eVar3;
            eVar3.f11703d = this;
            eVar2.f11704e = this;
        }
    }
}
