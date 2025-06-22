package l3;

import d3.l;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;

public final class c implements e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final e f21026a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f21027b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final l f21028c;

    public static final class a implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator f21029a;

        /* renamed from: b  reason: collision with root package name */
        private int f21030b = -1;

        /* renamed from: c  reason: collision with root package name */
        private Object f21031c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f21032d;

        a(c cVar) {
            this.f21032d = cVar;
            this.f21029a = cVar.f21026a.iterator();
        }

        private final void a() {
            while (this.f21029a.hasNext()) {
                Object next = this.f21029a.next();
                if (((Boolean) this.f21032d.f21028c.invoke(next)).booleanValue() == this.f21032d.f21027b) {
                    this.f21031c = next;
                    this.f21030b = 1;
                    return;
                }
            }
            this.f21030b = 0;
        }

        public boolean hasNext() {
            if (this.f21030b == -1) {
                a();
            }
            if (this.f21030b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f21030b == -1) {
                a();
            }
            if (this.f21030b != 0) {
                Object obj = this.f21031c;
                this.f21031c = null;
                this.f21030b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public c(e eVar, boolean z4, l lVar) {
        m.e(eVar, "sequence");
        m.e(lVar, "predicate");
        this.f21026a = eVar;
        this.f21027b = z4;
        this.f21028c = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
