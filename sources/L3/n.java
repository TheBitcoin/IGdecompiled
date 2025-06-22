package l3;

import d3.l;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class n implements e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f21047a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final l f21048b;

    public static final class a implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f21049a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n f21050b;

        a(n nVar) {
            this.f21050b = nVar;
            this.f21049a = nVar.f21047a.iterator();
        }

        public boolean hasNext() {
            return this.f21049a.hasNext();
        }

        public Object next() {
            return this.f21050b.f21048b.invoke(this.f21049a.next());
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public n(e eVar, l lVar) {
        m.e(eVar, "sequence");
        m.e(lVar, "transformer");
        this.f21047a = eVar;
        this.f21048b = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
