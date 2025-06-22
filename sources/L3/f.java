package l3;

import R2.m;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import e3.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.m;

final class f extends g implements Iterator, d, a {

    /* renamed from: a  reason: collision with root package name */
    private int f21038a;

    /* renamed from: b  reason: collision with root package name */
    private Object f21039b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator f21040c;

    /* renamed from: d  reason: collision with root package name */
    private d f21041d;

    private final Throwable h() {
        int i4 = this.f21038a;
        if (i4 == 4) {
            return new NoSuchElementException();
        }
        if (i4 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f21038a);
    }

    private final Object i() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public Object a(Object obj, d dVar) {
        this.f21039b = obj;
        this.f21038a = 3;
        this.f21041d = dVar;
        Object c5 = b.c();
        if (c5 == b.c()) {
            h.c(dVar);
        }
        if (c5 == b.c()) {
            return c5;
        }
        return s.f8222a;
    }

    public Object d(Iterator it, d dVar) {
        if (!it.hasNext()) {
            return s.f8222a;
        }
        this.f21040c = it;
        this.f21038a = 2;
        this.f21041d = dVar;
        Object c5 = b.c();
        if (c5 == b.c()) {
            h.c(dVar);
        }
        if (c5 == b.c()) {
            return c5;
        }
        return s.f8222a;
    }

    public g getContext() {
        return V2.h.f8445a;
    }

    public boolean hasNext() {
        while (true) {
            int i4 = this.f21038a;
            if (i4 != 0) {
                if (i4 == 1) {
                    Iterator it = this.f21040c;
                    m.b(it);
                    if (it.hasNext()) {
                        this.f21038a = 2;
                        return true;
                    }
                    this.f21040c = null;
                } else if (i4 == 2 || i4 == 3) {
                    return true;
                } else {
                    if (i4 == 4) {
                        return false;
                    }
                    throw h();
                }
            }
            this.f21038a = 5;
            d dVar = this.f21041d;
            m.b(dVar);
            this.f21041d = null;
            m.a aVar = R2.m.f8216a;
            dVar.resumeWith(R2.m.a(s.f8222a));
        }
    }

    public final void j(d dVar) {
        this.f21041d = dVar;
    }

    public Object next() {
        int i4 = this.f21038a;
        if (i4 == 0 || i4 == 1) {
            return i();
        }
        if (i4 == 2) {
            this.f21038a = 1;
            Iterator it = this.f21040c;
            kotlin.jvm.internal.m.b(it);
            return it.next();
        } else if (i4 == 3) {
            this.f21038a = 0;
            Object obj = this.f21039b;
            this.f21039b = null;
            return obj;
        } else {
            throw h();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void resumeWith(Object obj) {
        n.b(obj);
        this.f21038a = 4;
    }
}
