package j$.util.concurrent;

import j$.util.C1128c;
import j$.util.i0;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class e extends b implements Set, C1128c {
    private static final long serialVersionUID = 2249069246763182397L;

    public final Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    public final boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        return this.f5142a.f(entry.getKey(), entry.getValue(), false) == null;
    }

    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        Object obj2;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (obj2 = this.f5142a.get(key)) == null || (value = entry.getValue()) == null) {
            return false;
        }
        return value == obj2 || value.equals(obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = (java.util.Map.Entry) r3;
        r0 = r3.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r3 = r3.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof java.util.Map.Entry
            if (r0 == 0) goto L_0x001c
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r0 = r3.getKey()
            if (r0 == 0) goto L_0x001c
            java.lang.Object r3 = r3.getValue()
            if (r3 == 0) goto L_0x001c
            j$.util.concurrent.ConcurrentHashMap r1 = r2.f5142a
            boolean r3 = r1.remove(r0, r3)
            if (r3 == 0) goto L_0x001c
            r3 = 1
            return r3
        L_0x001c:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.e.remove(java.lang.Object):boolean");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [j$.util.concurrent.a, java.util.Iterator] */
    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        l[] lVarArr = concurrentHashMap.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new a(lVarArr, length, length, concurrentHashMap);
    }

    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (this.f5142a.f(entry.getKey(), entry.getValue(), false) == null) {
                z4 = true;
            }
        }
        return z4;
    }

    public final boolean removeIf(Predicate predicate) {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        predicate.getClass();
        l[] lVarArr = concurrentHashMap.f5127a;
        boolean z4 = false;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                Object obj = a5.f5153b;
                Object obj2 = a5.f5154c;
                if (predicate.test(new AbstractMap.SimpleImmutableEntry(obj, obj2)) && concurrentHashMap.g(obj, (Object) null, obj2) != null) {
                    z4 = true;
                }
            }
        }
        return z4;
    }

    public final int hashCode() {
        l[] lVarArr = this.f5142a.f5127a;
        int i4 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 == null) {
                    break;
                }
                i4 += a5.hashCode();
            }
        }
        return i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set != this) {
            return containsAll(set) && set.containsAll(this);
        }
        return true;
    }

    public final i0 spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        long j4 = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        long j5 = 0;
        if (j4 >= 0) {
            j5 = j4;
        }
        int i4 = length;
        return new f(lVarArr, i4, 0, i4, j5, concurrentHashMap);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.f5142a.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    consumer.accept(new k(a5.f5153b, a5.f5154c, this.f5142a));
                } else {
                    return;
                }
            }
        }
    }
}
