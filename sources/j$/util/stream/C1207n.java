package j$.util.stream;

import j$.time.format.a;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.concurrent.t;
import j$.util.i0;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* renamed from: j$.util.stream.n  reason: case insensitive filesystem */
public final class C1207n extends Z1 {
    public static I0 Q(C1144a aVar, i0 i0Var) {
        a aVar2 = new a(21);
        a aVar3 = new a(22);
        a aVar4 = new a(23);
        Objects.requireNonNull(aVar2);
        Objects.requireNonNull(aVar3);
        Objects.requireNonNull(aVar4);
        return new I0((Collection) new C1252y1(X2.REFERENCE, aVar4, aVar3, aVar2, 3).c(aVar, i0Var));
    }

    public final E0 G(C1144a aVar, i0 i0Var, IntFunction intFunction) {
        if (W2.DISTINCT.n(aVar.f5463f)) {
            return aVar.y(i0Var, false, intFunction);
        }
        if (W2.ORDERED.n(aVar.f5463f)) {
            return Q(aVar, i0Var);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        t tVar = new t(4, (Object) atomicBoolean, (Object) concurrentHashMap);
        Objects.requireNonNull(tVar);
        new O(tVar, false).e(aVar, i0Var);
        Set keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add((Object) null);
            keySet = hashSet;
        }
        return new I0(keySet);
    }

    public final i0 H(C1144a aVar, i0 i0Var) {
        if (W2.DISTINCT.n(aVar.f5463f)) {
            return aVar.P(i0Var);
        }
        if (W2.ORDERED.n(aVar.f5463f)) {
            return Q(aVar, i0Var).spliterator();
        }
        return new C1173f3(aVar.P(i0Var), new ConcurrentHashMap());
    }

    public final C1187i2 J(int i4, C1187i2 i2Var) {
        Objects.requireNonNull(i2Var);
        if (W2.DISTINCT.n(i4)) {
            return i2Var;
        }
        if (W2.SORTED.n(i4)) {
            return new C1199l(i2Var);
        }
        return new C1203m(i2Var);
    }
}
