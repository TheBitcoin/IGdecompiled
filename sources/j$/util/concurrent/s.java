package j$.util.concurrent;

import j$.util.C1128c;
import j$.util.i0;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public final class s extends b implements C1128c {
    private static final long serialVersionUID = 2249069246763182397L;

    public final Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    public final boolean contains(Object obj) {
        return this.f5142a.containsValue(obj);
    }

    public final boolean remove(Object obj) {
        a aVar;
        if (obj == null) {
            return false;
        }
        Iterator it = iterator();
        do {
            aVar = (a) it;
            if (!aVar.hasNext()) {
                return false;
            }
        } while (!obj.equals(((h) it).next()));
        aVar.remove();
        return true;
    }

    public final Iterator iterator() {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        l[] lVarArr = concurrentHashMap.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new h(lVarArr, length, length, concurrentHashMap, 1);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z4 = false;
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return z4;
            }
            if (collection.contains(((h) it).next())) {
                aVar.remove();
                z4 = true;
            }
        }
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
                if (predicate.test(obj2) && concurrentHashMap.g(obj, (Object) null, obj2) != null) {
                    z4 = true;
                }
            }
        }
        return z4;
    }

    public final i0 spliterator() {
        ConcurrentHashMap concurrentHashMap = this.f5142a;
        long j4 = concurrentHashMap.j();
        l[] lVarArr = concurrentHashMap.f5127a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        return new j(lVarArr, length, 0, length, j4 < 0 ? 0 : j4, 1);
    }

    public final void forEach(Consumer consumer) {
        consumer.getClass();
        l[] lVarArr = this.f5142a.f5127a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a5 = pVar.a();
                if (a5 != null) {
                    consumer.accept(a5.f5154c);
                } else {
                    return;
                }
            }
        }
    }
}
