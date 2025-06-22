package j$.util;

import j$.util.stream.Stream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* renamed from: j$.util.n  reason: case insensitive filesystem */
public class C1139n implements Collection, Serializable, C1128c {
    private static final long serialVersionUID = 1820017752578914078L;

    /* renamed from: a  reason: collision with root package name */
    public final Collection f5239a;

    public C1139n(Collection collection) {
        collection.getClass();
        this.f5239a = collection;
    }

    public final int size() {
        return this.f5239a.size();
    }

    public final boolean isEmpty() {
        return this.f5239a.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.f5239a.contains(obj);
    }

    public Object[] toArray() {
        return this.f5239a.toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return this.f5239a.toArray(objArr);
    }

    public final String toString() {
        return this.f5239a.toString();
    }

    public Iterator iterator() {
        return new C1138m(this);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection collection) {
        return this.f5239a.containsAll(collection);
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public void forEach(Consumer consumer) {
        Collection$EL.a(this.f5239a, consumer);
    }

    public final boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException();
    }

    public i0 spliterator() {
        return Collection$EL.c(this.f5239a);
    }

    public Stream stream() {
        return Collection$EL.stream(this.f5239a);
    }

    public Stream parallelStream() {
        return Collection$EL.b(this.f5239a);
    }

    public final Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }
}
