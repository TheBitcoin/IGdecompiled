package j$.util.concurrent;

import j$.util.C1128c;
import j$.util.Objects;
import j$.util.i0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class i extends b implements Set, C1128c {
    private static final long serialVersionUID = 7249069246763182397L;

    public final Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    public final boolean removeIf(Predicate predicate) {
        Objects.requireNonNull(predicate);
        Iterator it = iterator();
        boolean z4 = false;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return z4;
            }
            if (predicate.test(((h) it).next())) {
                aVar.remove();
                z4 = true;
            }
        }
    }

    public final boolean contains(Object obj) {
        return this.f5142a.containsKey(obj);
    }

    public final boolean remove(Object obj) {
        return this.f5142a.remove(obj) != null;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        l[] lVarArr = concurrentHashMap.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 0);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i4 = 0;
        while (((a) it).hasNext()) {
            i4 += ((h) it).next().hashCode();
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
        return new j(lVarArr, length, 0, length, j4 < 0 ? 0 : j4, 0);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.f5142a.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    consumer.accept(a5.f5153b);
                } else {
                    return;
                }
            }
        }
    }
}
