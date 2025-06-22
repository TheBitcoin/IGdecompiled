package l3;

import W2.b;
import d3.p;
import java.util.Iterator;
import kotlin.jvm.internal.m;

abstract class i {

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f21042a;

        public a(p pVar) {
            this.f21042a = pVar;
        }

        public Iterator iterator() {
            return i.a(this.f21042a);
        }
    }

    public static final Iterator a(p pVar) {
        m.e(pVar, "block");
        f fVar = new f();
        fVar.j(b.a(pVar, fVar, fVar));
        return fVar;
    }

    public static e b(p pVar) {
        m.e(pVar, "block");
        return new a(pVar);
    }
}
