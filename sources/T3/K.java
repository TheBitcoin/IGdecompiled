package t3;

import V2.g;
import V2.h;
import d3.p;
import kotlin.jvm.internal.m;
import o3.Q0;

public final class K implements Q0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4476a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadLocal f4477b;

    /* renamed from: c  reason: collision with root package name */
    private final g.c f4478c;

    public K(Object obj, ThreadLocal threadLocal) {
        this.f4476a = obj;
        this.f4477b = threadLocal;
        this.f4478c = new L(threadLocal);
    }

    public Object fold(Object obj, p pVar) {
        return Q0.a.a(this, obj, pVar);
    }

    public g.b get(g.c cVar) {
        if (!m.a(getKey(), cVar)) {
            return null;
        }
        m.c(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    public g.c getKey() {
        return this.f4478c;
    }

    public g minusKey(g.c cVar) {
        if (m.a(getKey(), cVar)) {
            return h.f8445a;
        }
        return this;
    }

    public Object o(g gVar) {
        Object obj = this.f4477b.get();
        this.f4477b.set(this.f4476a);
        return obj;
    }

    public g plus(g gVar) {
        return Q0.a.b(this, gVar);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f4476a + ", threadLocal = " + this.f4477b + ')';
    }

    public void x(g gVar, Object obj) {
        this.f4477b.set(obj);
    }
}
