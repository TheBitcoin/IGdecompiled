package m0;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import m0.C2148p;
import m0.C2149q;

/* renamed from: m0.s  reason: case insensitive filesystem */
public class C2150s extends C2149q implements C2127A {

    /* renamed from: c  reason: collision with root package name */
    private final transient r f21149c;

    /* renamed from: m0.s$a */
    public static final class a extends C2149q.a {
        public C2150s a() {
            Collection entrySet = this.f21145a.entrySet();
            Comparator comparator = this.f21146b;
            if (comparator != null) {
                entrySet = G.a(comparator).d().b(entrySet);
            }
            return C2150s.e(entrySet, this.f21147c);
        }
    }

    C2150s(C2148p pVar, int i4, Comparator comparator) {
        super(pVar, i4);
        this.f21149c = d(comparator);
    }

    private static r d(Comparator comparator) {
        if (comparator == null) {
            return r.r();
        }
        return C2151t.D(comparator);
    }

    static C2150s e(Collection collection, Comparator comparator) {
        if (collection.isEmpty()) {
            return f();
        }
        C2148p.a aVar = new C2148p.a(collection.size());
        Iterator it = collection.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            r g4 = g(comparator, (Collection) entry.getValue());
            if (!g4.isEmpty()) {
                aVar.e(key, g4);
                i4 += g4.size();
            }
        }
        return new C2150s(aVar.b(), i4, comparator);
    }

    public static C2150s f() {
        return C2144l.f21120d;
    }

    private static r g(Comparator comparator, Collection collection) {
        if (comparator == null) {
            return r.o(collection);
        }
        return C2151t.y(comparator, collection);
    }
}
