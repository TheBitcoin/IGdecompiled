package T2;

import S2.C1591e;
import e3.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.m;

public final class f extends C1591e implements Set, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f8357a;

    public f(d dVar) {
        m.e(dVar, "backing");
        this.f8357a = dVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f8357a.size();
    }

    public void clear() {
        this.f8357a.clear();
    }

    public boolean contains(Object obj) {
        return this.f8357a.containsKey(obj);
    }

    public boolean isEmpty() {
        return this.f8357a.isEmpty();
    }

    public Iterator iterator() {
        return this.f8357a.D();
    }

    public boolean remove(Object obj) {
        return this.f8357a.M(obj);
    }

    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f8357a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f8357a.m();
        return super.retainAll(collection);
    }
}
