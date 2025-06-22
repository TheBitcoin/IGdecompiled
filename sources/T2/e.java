package T2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final d f8356a;

    public e(d dVar) {
        m.e(dVar, "backing");
        this.f8356a = dVar;
    }

    public boolean addAll(Collection collection) {
        m.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f8356a.size();
    }

    public void clear() {
        this.f8356a.clear();
    }

    public boolean containsAll(Collection collection) {
        m.e(collection, "elements");
        return this.f8356a.o(collection);
    }

    public boolean isEmpty() {
        return this.f8356a.isEmpty();
    }

    public Iterator iterator() {
        return this.f8356a.t();
    }

    public boolean j(Map.Entry entry) {
        m.e(entry, "element");
        return this.f8356a.p(entry);
    }

    public boolean k(Map.Entry entry) {
        m.e(entry, "element");
        return this.f8356a.J(entry);
    }

    /* renamed from: l */
    public boolean add(Map.Entry entry) {
        m.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        m.e(collection, "elements");
        this.f8356a.m();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        m.e(collection, "elements");
        this.f8356a.m();
        return super.retainAll(collection);
    }
}
