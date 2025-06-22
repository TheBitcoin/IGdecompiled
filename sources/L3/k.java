package l3;

import d3.l;
import java.util.Iterator;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

abstract class k extends j {

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f21043a;

        public a(Iterator it) {
            this.f21043a = it;
        }

        public Iterator iterator() {
            return this.f21043a;
        }
    }

    static final class b extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f21044a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Object obj) {
            super(0);
            this.f21044a = obj;
        }

        public final Object invoke() {
            return this.f21044a;
        }
    }

    public static e c(Iterator it) {
        m.e(it, "<this>");
        return d(new a(it));
    }

    public static e d(e eVar) {
        m.e(eVar, "<this>");
        if (eVar instanceof a) {
            return eVar;
        }
        return new a(eVar);
    }

    public static e e(d3.a aVar, l lVar) {
        m.e(aVar, "seedFunction");
        m.e(lVar, "nextFunction");
        return new d(aVar, lVar);
    }

    public static e f(Object obj, l lVar) {
        m.e(lVar, "nextFunction");
        if (obj == null) {
            return b.f21025a;
        }
        return new d(new b(obj), lVar);
    }
}
