package T2;

import S2.C1589c;
import e3.b;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.m;

public final class g extends C1589c implements Collection, b {

    /* renamed from: a  reason: collision with root package name */
    private final d f8358a;

    public g(d dVar) {
        m.e(dVar, "backing");
        this.f8358a = dVar;
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f8358a.size();
    }

    public void clear() {
        this.f8358a.clear();
    }

    public boolean contains(Object obj) {
        return this.f8358a.containsValue(obj);
    }

    public boolean isEmpty() {
        return this.f8358a.isEmpty();
    }

    public Iterator iterator() {
        return this.f8358a.P();
    }

    public boolean remove(Object obj) {
        return this.f8358a.N(obj);
    }

    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f8358a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f8358a.m();
        return super.retainAll(collection);
    }
}
