package l3;

import S2.C1601o;
import d3.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.n;

abstract class m extends l {

    public static final class a implements Iterable, e3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f21045a;

        public a(e eVar) {
            this.f21045a = eVar;
        }

        public Iterator iterator() {
            return this.f21045a.iterator();
        }
    }

    static final class b extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f21046a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Boolean invoke(Object obj) {
            boolean z4;
            if (obj == null) {
                z4 = true;
            } else {
                z4 = false;
            }
            return Boolean.valueOf(z4);
        }
    }

    public static Iterable g(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        return new a(eVar);
    }

    public static final e h(e eVar, l lVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        kotlin.jvm.internal.m.e(lVar, "predicate");
        return new c(eVar, false, lVar);
    }

    public static final e i(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        e h4 = h(eVar, b.f21046a);
        kotlin.jvm.internal.m.c(h4, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return h4;
    }

    public static Object j(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static Object k(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static Object l(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static e m(e eVar, l lVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        kotlin.jvm.internal.m.e(lVar, "transform");
        return new n(eVar, lVar);
    }

    public static e n(e eVar, l lVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        kotlin.jvm.internal.m.e(lVar, "transform");
        return i(new n(eVar, lVar));
    }

    public static List o(e eVar) {
        kotlin.jvm.internal.m.e(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return C1601o.h();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return C1601o.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
