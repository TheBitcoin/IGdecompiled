package l3;

import d3.l;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;

final class d implements e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d3.a f21033a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final l f21034b;

    public static final class a implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private Object f21035a;

        /* renamed from: b  reason: collision with root package name */
        private int f21036b = -2;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f21037c;

        a(d dVar) {
            this.f21037c = dVar;
        }

        private final void a() {
            Object obj;
            int i4;
            if (this.f21036b == -2) {
                obj = this.f21037c.f21033a.invoke();
            } else {
                l b5 = this.f21037c.f21034b;
                Object obj2 = this.f21035a;
                m.b(obj2);
                obj = b5.invoke(obj2);
            }
            this.f21035a = obj;
            if (obj == null) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            this.f21036b = i4;
        }

        public boolean hasNext() {
            if (this.f21036b < 0) {
                a();
            }
            if (this.f21036b == 1) {
                return true;
            }
            return false;
        }

        public Object next() {
            if (this.f21036b < 0) {
                a();
            }
            if (this.f21036b != 0) {
                Object obj = this.f21035a;
                m.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f21036b = -1;
                return obj;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(d3.a aVar, l lVar) {
        m.e(aVar, "getInitialValue");
        m.e(lVar, "getNextValue");
        this.f21033a = aVar;
        this.f21034b = lVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
